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

    //allgemeine Angaben zur Einrichtung
    @FindBy(id = "name")
    WebElement ambulantDepartmentName;
    @FindBy(id = "organisationType")
    WebElement ambulantDepartmentOrganisationType;
    @FindBy(id = "confession")
    WebElement ambulantDepartmentConfession;
    @FindBy(xpath = "//section[@class='Input  select     empty']//label[@class='Checkbox ']")
    WebElement ambulantDepartmentAccept;
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

    //GETTER allgemeine Angaben zur Einrichtung
    public WebElement addDepartment() {
        return addDepartment;
    }

    public WebElement addAmbulantDepartment() {
        return addAmbulantDepartment;
    }

    public WebElement ambulantDepartmentName() {
        return ambulantDepartmentName;
    }

    public WebElement ambulantDepartmentOrganisationType() {
        return ambulantDepartmentOrganisationType;
    }

    public WebElement ambulantDepartmentConfession() {
        return ambulantDepartmentConfession;
    }

    public WebElement ambulantDepartmentAccept() {
        return ambulantDepartmentAccept;
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

    //ansprechpartner
    @FindBy(id = "contact.salutation")
    WebElement ambulantDepartmentContactSalutation;
    @FindBy(id = "contact.firstName")
    WebElement ambulantDepartmentContactFirstName;
    @FindBy(id = "contact.lastName")
    WebElement ambulantDepartmentContactLastName;
    @FindBy(id = "contact.title")
    WebElement ambulantDepartmentContactTitle;
    @FindBy(id = "contact.email")
    WebElement ambulantDepartmentContactEmail;
    @FindBy(id = "contact.phone")
    WebElement ambulantDepartmentContactPhone;

    //GETTER ansprechpartner
    public WebElement ambulantDepartmentContactSalutation() {
        return ambulantDepartmentContactSalutation;
    }

    public WebElement ambulantDepartmentContactFirstName() {
        return ambulantDepartmentContactFirstName;
    }

    public WebElement ambulantDepartmentContactLastName() {
        return ambulantDepartmentContactLastName;
    }

    public WebElement ambulantDepartmentContactTitle() {
        return ambulantDepartmentContactTitle;
    }

    public WebElement ambulantDepartmentContactEmail() {
        return ambulantDepartmentContactEmail;
    }

    public WebElement ambulantDepartmentContactPhone() {
        return ambulantDepartmentContactPhone;
    }

    //sprechzeiten

    //GETTER sprechzeiten
}
