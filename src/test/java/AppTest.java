import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.SetupMobileUtil;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppTest {
    public static URL url;
    public static DesiredCapabilities capabilities;
    public static AndroidDriver<MobileElement> driver;
    Properties props;
    //1
    @BeforeSuite
    public void setupAppium() throws MalformedURLException {
        //2
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        url = new URL(URL_STRING);
//3
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/maihoathao/GitHub_prjOlder/GitHub_new/hotelandroid/src/main/resources/hotel4.apk");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //4
        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.resetApp();
    }
    //5
    @AfterSuite
    public void uninstallApp() throws InterruptedException {
        driver.removeApp("com.example.android.contactmanager");
    }
    //6
//    @Test(enabled=true)
//    public void myFirstTest() throws InterruptedException {
//        driver.resetApp();
//    }
    @Test(enabled = true)
    public void loginApp() throws InterruptedException{
        try{
//            get data from file config
            props = new Properties();
            InputStream file = getClass().getResourceAsStream("config.properties");
            props.load(file);
            String getEmail = props.getProperty("email");
            String getPass = props.getProperty("password");
//            input data to Login page
            SetupMobileUtil.explicitlyWait(driver,LoginPage.titleLogin);
            driver.findElement(LoginPage.email).sendKeys(getEmail);
            driver.findElement(LoginPage.pass).sendKeys(getPass);
            driver.findElement(LoginPage.loginBtn).click();

            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
            System.out.println("-->login success");

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
