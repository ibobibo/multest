package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditOrganisationPage {
    WebDriver driver;

    public EditOrganisationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='publish-department']")
    WebElement saveClick;
    @FindBy(xpath = "//button[@id='preview-department']")
    WebElement previewClick;
    @FindBy(xpath = "//button[@class='back']")
    WebElement backClick;
    @FindBy(xpath = "//input[@id='name']")
    WebElement changeName;

    public WebElement saveClick() {
        return saveClick;
    }

    public WebElement previewClick() {
        return previewClick;
    }

    public WebElement backClick() {
        return backClick;
    }

    public WebElement changeName() {
        return changeName;
    }
}