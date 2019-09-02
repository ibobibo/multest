package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmbulantOrganisationPage {
    WebDriver driver;

    public AmbulantOrganisationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='Department']//a[@id='add-department']")
    WebElement addDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='AMBULANT card']//a[@class='create']")
    WebElement addAmbulantDepartment;

    @FindBy(id = "name")
    WebElement ambulantDepartmentName;
    @FindBy(id = "address.streetAddress")
    WebElement ambulantDepartmentStreetAddress;
    @FindBy(id = "address.streetNumber")
    WebElement ambulantDepartmentStreetNumber;
    @FindBy(id = "address.postalCode")
    WebElement ambulantDepartmentPostalCode;
    @FindBy(id = "address.city")
    WebElement ambulantDepartmentAddressCity;
    @FindBy(id = "website")
    WebElement ambulantDepartmentWebsite;
    @FindBy(id = "availability")
    WebElement ambulantDepartmentAvailable;


    public WebElement addDepartment() {
        return addDepartment;
    }

    public WebElement addAmbulantDepartment() {
        return addAmbulantDepartment;
    }

    public WebElement ambulantDepartmentName() {
        return ambulantDepartmentName;
    }

    public WebElement ambulantDepartmentStreetAddress() {
        return ambulantDepartmentStreetAddress;
    }

    public WebElement ambulantDepartmentStreetNumber() {
        return ambulantDepartmentStreetNumber;
    }

    public WebElement ambulantDepartmentPostalCode() {
        return ambulantDepartmentPostalCode;
    }

    public WebElement ambulantDepartmentAddressCity() {
        return ambulantDepartmentAddressCity;
    }

    public WebElement ambulantDepartmentWebsite() {
        return ambulantDepartmentWebsite;
    }

    public WebElement ambulantDepartmentAvailable() {
        return ambulantDepartmentAvailable;
    }
}
