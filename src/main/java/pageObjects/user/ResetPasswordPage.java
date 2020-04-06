package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Neues Passwort anfordern')]")
    WebElement getNewPassword;
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//div[@class='col-md-6']//button")
    WebElement resetPassword;

    public WebElement getNewPassword() {
        return getNewPassword;
    }

    public WebElement email() {
        return email;
    }

    public WebElement resetPassword() {
        return resetPassword;
    }
}
