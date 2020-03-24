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
    @FindBy(xpath = "//section[@id='app-header']//a[@href='/login']")
    WebElement anmeldenButton;
    @FindBy(xpath = "//section[2]//div[1]//input[1]")
    WebElement username;
    @FindBy(xpath = "//section[4]//div[1]//input[1]")
    WebElement password;
    @FindBy(xpath = "//button[@id='login-submit']")
    WebElement anmelden;

    public WebElement anmeldenButton() {
        return anmeldenButton;
    }

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
    @FindBy(xpath = "//div[@class='collapse navbar-collapse']//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
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
