package pageObjects.contactPerson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPersonGetDepartmentPage {
    WebDriver driver;

    public ContactPersonGetDepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[contains(@class,'MulTable withoutSearch withoutTopElements')]//table//tbody//tr")
    WebElement contactUserDisplayed;
    @FindBy(xpath = "//button[@class='assign']")
    WebElement choseContactPerson;
    @FindBy(xpath = "//button[contains(@class,'primary')]")
    WebElement submit;
    @FindBy(xpath = "//span[text()='Ambulant']")
    WebElement addedLocationForContactPerson;

    public WebElement contactUserDisplayed() {
        return contactUserDisplayed;
    }

    public WebElement choseContactPerson() {
        return choseContactPerson;
    }

    public WebElement submit() {
        return submit;
    }

    public WebElement addedLocationForContactPerson() {
        return addedLocationForContactPerson;
    }
}
