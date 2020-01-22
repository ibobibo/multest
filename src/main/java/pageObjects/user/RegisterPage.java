package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='app-header']//a[@href='#/register']")
    WebElement registerButtonHomepage;

    @FindBy(xpath = "//input[@id='site.company']")
    WebElement siteCompany;
    @FindBy(id = "site.streetAddress")
    WebElement streetAddress;
    @FindBy(id = "site.streetNumber")
    WebElement streetNumber;
    @FindBy(id = "site.postalCode")
    WebElement postalCode;
    @FindBy(id = "site.city")
    WebElement city;
    @FindBy(id = "site.name")
    WebElement siteName;

    @FindBy(id = "site.umbrellaOrganisation.id")
    WebElement umbrellaOrganisation;
    @FindBy(xpath = "//option[. = 'Stiftung Liebenau']")
    WebElement umbrellaOrganisationChosen;
    @FindBy(xpath = "//section[@class='Input  select    required empty']//select[@id='contact.salutation']")
    WebElement contactSalutation;
    @FindBy(xpath = "//option[. = 'Herr']")
    WebElement contactSalutationMale;
    @FindBy(id = "contact.firstName")
    WebElement contactFirstName;
    @FindBy(id = "contact.lastName")
    WebElement contactLastName;
    @FindBy(id = "contact.email")
    WebElement contactEmail;
    @FindBy(id = "contact.phone")
    WebElement contactPhone;
    @FindBy(id = "account.firstPassword")
    WebElement accountFirstPassword;
    @FindBy(id = "account.secondPassword")
    WebElement accountSecondPassword;
    @FindBy(id = "account.premiumCode")
    WebElement accountPremiumCode;
    @FindBy(xpath = "//section[@class='Register']//label[@class='Checkbox ']//span[contains(text(),'Ich habe die Erklärung zum ')]")
    WebElement accept;
    @FindBy(id = "register-submit")
    WebElement registerSubmit;

    public WebElement registerButtonHomepage() {
        return registerButtonHomepage;
    }

    public WebElement siteCompany() {
        return siteCompany;
    }

    public WebElement streetAddress() {
        return streetAddress;
    }

    public WebElement streetNumber() {
        return streetNumber;
    }

    public WebElement postalCode() {
        return postalCode;
    }

    public WebElement city() {
        return city;
    }

    public WebElement siteName() {
        return siteName;
    }

    public WebElement umbrellaOrganisation() {
        return umbrellaOrganisation;
    }

    public WebElement umbrellaOrganisationChosen() {
        return umbrellaOrganisationChosen;
    }

    public WebElement contactSalutation() {
        return contactSalutation;
    }

    public WebElement contactSalutationMale() {
        return contactSalutationMale;
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

    public WebElement accountFirstPassword() {
        return accountFirstPassword;
    }

    public WebElement accountSecondPassword() {
        return accountSecondPassword;
    }

    public WebElement accountPremiumCode() {
        return accountPremiumCode;
    }

    public WebElement accept() {
        return accept;
    }

    public WebElement registerSubmit() {
        return registerSubmit;
    }
}
