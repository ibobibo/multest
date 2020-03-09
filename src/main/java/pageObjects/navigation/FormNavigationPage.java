package pageObjects.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormNavigationPage {
    WebDriver driver;

    public FormNavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Jetzt registrieren')]")
    WebElement navToRegister;
    @FindBy(xpath = "//span[contains(text(),'Jetzt anmelden')]")
    WebElement navToLogin;
    @FindBy(xpath = "//button[@id='login-submit']")
    WebElement loginButton;
    @FindBy(xpath = "//button[@id='register-submit']")
    WebElement signupButton;

    public WebElement navToRegister() {
        return navToRegister;
    }

    public WebElement navToLogin() {
        return navToLogin;
    }

    public WebElement loginButton() {
        return loginButton;
    }

    public WebElement signupButton() {
        return signupButton;
    }
}
