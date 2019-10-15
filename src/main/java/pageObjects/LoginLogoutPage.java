package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLogoutPage {
    WebDriver driver;

    public LoginLogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //LOGIN
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-submit")
    WebElement anmelden;

    public WebElement username() {
        return username;
    }

    public WebElement password() {
        return password;
    }

    public WebElement anmelden() {
        return anmelden;
    }

    //LOGOUT
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    WebElement userOption;
    @FindBy(xpath = "//span[@class='logout']")
    WebElement logout;

    public WebElement userOption() {
        return userOption;
    }

    public WebElement logout() {
        return logout;
    }
}
