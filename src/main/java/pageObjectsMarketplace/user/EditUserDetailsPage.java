package pageObjectsMarketplace.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserDetailsPage {
    WebDriver driver;

    public EditUserDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    WebElement accountMenu;
    @FindBy(xpath = "//span[@class='settings']")
    WebElement accountMenuSettings;
    @FindBy(xpath = "//select[@id='salutation']")
    WebElement salutation;
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement mail;
    @FindBy(xpath = "//input[@id='phone']")
    WebElement phone;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public WebElement accountMenu() {
        return accountMenu;
    }

    public WebElement accountMenuSettings() {
        return accountMenuSettings;
    }

    public WebElement salutation() {
        return salutation;
    }

    public WebElement firstName() {
        return firstName;
    }

    public WebElement lastName() {
        return lastName;
    }

    public WebElement mail() {
        return mail;
    }

    public WebElement phone() {
        return phone;
    }

    public WebElement submitButton() {
        return submitButton;
    }

    //passwordChangeTest
    @FindBy(xpath = "//span[@class='password']")
    WebElement passwordMenuSettings;
    @FindBy(xpath = "//input[@id='currentPassword']")
    WebElement currentPassword;
    @FindBy(xpath = "//input[@id='account.firstPassword']")
    WebElement newPassword;
    @FindBy(xpath = "//input[@id='account.secondPassword']")
    WebElement newPasswordRepeat;

    public WebElement passwordMenuSettings() {
        return passwordMenuSettings;
    }

    public WebElement currentPassword() {
        return currentPassword;
    }

    public WebElement newPassword() {
        return newPassword;
    }

    public WebElement newPasswordRepeat() {
        return newPasswordRepeat;
    }

}
