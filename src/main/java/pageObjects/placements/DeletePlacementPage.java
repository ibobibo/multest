package pageObjects.placements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePlacementPage {
    WebDriver driver;

    public DeletePlacementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement nameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//a[@id='edit-enterprise-button']")
    WebElement editPlacement;
    @FindBy(xpath = "//button[@class='delete-button']")
    WebElement deletePlacement;
    @FindBy(xpath = "//button[@class='confirm delete']")
    WebElement acceptDelete;

    public WebElement nameField() {
        return nameField;
    }

    public WebElement passwordField() {
        return passwordField;
    }

    public WebElement editPlacement() {
        return editPlacement;
    }

    public WebElement deletePlacement() {
        return deletePlacement;
    }

    public WebElement acceptDelete() {
        return acceptDelete;
    }
}
