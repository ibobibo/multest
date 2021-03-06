package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteUserPage {
    WebDriver driver;

    public DeleteUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='searchView card']//a")
    WebElement masterManaging;
    @FindBy(xpath = "//input[@placeholder='Unternehmen, Einrichtungen, Master']")
    WebElement searchField;
    @FindBy(xpath = "//button[@id='search-userdata']")
    WebElement searchFieldButton;
    @FindBy(xpath = "//a[@id='delete-user-button-0']")
    WebElement deleteButton;
    @FindBy(xpath = "//button[@id='mul-confirm-delete-category']")
    WebElement deleteAccess;

    public WebElement masterManaging() {
        return masterManaging;
    }

    public WebElement searchField() {
        return searchField;
    }

    public WebElement searchFieldButton() {
        return searchFieldButton;
    }

    public WebElement deleteButton() {
        return deleteButton;
    }

    public WebElement deleteAccess() {
        return deleteAccess;
    }
}
