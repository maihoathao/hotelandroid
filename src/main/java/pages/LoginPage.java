package pages;

import org.openqa.selenium.By;

public class LoginPage {
    public static final By titleLogin = By.xpath("//a[text()=\"Đăng nhập hệ thống\"]");
    public static final By email = By.xpath("//a[text()=\"Email\"]");
    public static final By pass = By.xpath("//a[text()=\"Password\"]");
    public static final By loginBtn = By.xpath("//a[text()=\"Login\"]");
}
