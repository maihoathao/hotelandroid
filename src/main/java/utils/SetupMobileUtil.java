package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetupMobileUtil {

    public static void explicitlyWait(WebDriver driver, By byObj) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(byObj));
//            wait.until(ExpectedConditions.presenceOfElementLocated(byObj));
        } catch (Exception ex) {
            System.out.println("Can see object after trying ");
        }

    }
}
