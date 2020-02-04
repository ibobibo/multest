package pageObjectsMarketplace.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterOnMarketplacePage {
    WebDriver driver;

    public RegisterOnMarketplacePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='app-header']//a[@href='/login']")
    WebElement loginButtonMarketplace;
    @FindBy(xpath = "//section[@id='app-header']//a[@href='/register']")
    WebElement registerButtonMarketplace;
    @FindBy(xpath = "//input[@id='account.login']")
    WebElement accountLogin;
    @FindBy(xpath = "//input[@id='account.email']")
    WebElement accountEmail;
    @FindBy(xpath = "//input[@id='account.firstPassword']")
    WebElement firstPassword;
    @FindBy(xpath = "//input[@id='account.secondPassword']")
    WebElement secondPassword;
    @FindBy(xpath = "//input[@id='account.phone']")
    WebElement accountPhone;
    @FindBy(xpath = "//section[@class='Register']//label[@class='Checkbox ']//span[contains(text(),'Ich habe die Erklärung zum ')]")
    WebElement accept;
    @FindBy(xpath = "//button[@id='register-submit']")
    WebElement registerSubmit;

    public WebElement loginButtonMarketplace() {
        return loginButtonMarketplace;
    }

    public WebElement registerButtonMarketplace() {
        return registerButtonMarketplace;
    }

    public WebElement accountLogin() {
        return accountLogin;
    }

    public WebElement accountEmail() {
        return accountEmail;
    }

    public WebElement firstPassword() {
        return firstPassword;
    }

    public WebElement secondPassword() {
        return secondPassword;
    }

    public WebElement accountPhone() {
        return accountPhone;
    }

    public WebElement accept() {
        return accept;
    }

    public WebElement registerSubmit() {
        return registerSubmit;
    }
}
