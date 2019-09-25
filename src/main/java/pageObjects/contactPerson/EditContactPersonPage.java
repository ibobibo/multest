package pageObjects.contactPerson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactPersonPage {
    WebDriver driver;

    public EditContactPersonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//option[. = 'ohne Anrede']")
    WebElement contactSalutationChosen;
    @FindBy(id = "firstName")
    WebElement contactFirstName;
    @FindBy(id = "lastName")
    WebElement contactLastName;
    @FindBy(id = "email")
    WebElement contactEmail;
    @FindBy(id = "phone")
    WebElement contactPhone;
    @FindBy(xpath = "//section[@class='FormButtons']//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//section[@class='FormButtons']//button[@class='back']")
    WebElement back;


    public WebElement contactSalutationChosen() {
        return contactSalutationChosen;
    }

    public WebElement contactFirstName() {
        return contactFirstName;
    }

    public WebElement contactLastName() {
        return contactLastName;
    }

    public WebElement contactEmail() {
        return contactEmail;
    }

    public WebElement contactPhone() {
        return contactPhone;
    }

    public WebElement submit() {
        return submit;
    }

    public WebElement back() {
        return back;
    }

}
