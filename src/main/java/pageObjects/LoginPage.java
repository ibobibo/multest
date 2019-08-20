package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-submit")
    WebElement anmelden;
    @FindBy(id = "not-existing")
    WebElement notExisting;

    public WebElement username() {
        return username;
    }

    public WebElement password() {
        return password;
    }

    public WebElement anmelden() {
        return anmelden;
    }

    public WebElement notExisting() {
        return notExisting;
    }
}
