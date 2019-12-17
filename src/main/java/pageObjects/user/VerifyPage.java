package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyPage {
    WebDriver driver;

    public VerifyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement inputField;
    @FindBy(xpath = "//input[@id='newPassword']")
    WebElement newPassword;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    WebElement newPasswordRepeat;
    @FindBy(xpath = "//button[@class='mul-set-password-button']")
    WebElement submitPassword;


    public WebElement inputField() {
        return inputField;
    }

    public WebElement newPassword() {
        return newPassword;
    }

    public WebElement newPasswordRepeat() {
        return newPasswordRepeat;
    }

    public WebElement submitPassword() {
        return submitPassword;
    }

}
