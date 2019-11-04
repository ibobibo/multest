package pageObjectsMarketplace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteMarketplaceUserPage {
    WebDriver driver;

    public DeleteMarketplaceUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    WebElement accountMenu;
    @FindBy(xpath = "//span[@class='settings']")
    WebElement accountMenuSettings;
    @FindBy(xpath = "//button[@class='delete-button']")
    WebElement deleteButton;
    @FindBy(xpath = "//button[@id='mul-confirm-delete-category']")
    WebElement deleteAccept;
    @FindBy(xpath = "//button[@class='cancel']")
    WebElement deleteCancel;

    public WebElement accountMenu() {
        return accountMenu;
    }

    public WebElement accountMenuSettings() {
        return accountMenuSettings;
    }

    public WebElement deleteButton() {
        return deleteButton;
    }

    public WebElement deleteAccept() {
        return deleteAccept;
    }

    public WebElement deleteCancel() {
        return deleteCancel;
    }
}
