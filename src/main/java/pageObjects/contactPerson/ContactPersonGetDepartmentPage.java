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

    @FindBy(xpath = "//section[@class='Userdata']//tbody//tr")
    WebElement contactUserDisplayed;
    @FindBy(xpath = "//label[@class='Checkbox ']")
    WebElement choseContactPerson;
    @FindBy(xpath = "//button[@class='submit-button saveUser']")
    WebElement submit;

    public WebElement contactUserDisplayed() {
        return contactUserDisplayed;
    }

    public WebElement choseContactPerson() {
        return choseContactPerson;
    }

    public WebElement submit() {
        return submit;
    }
}
