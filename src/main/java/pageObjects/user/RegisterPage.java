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

    @FindBy(xpath = "//a[@id='nav-register']")
    WebElement registerButtonHomepage;

    @FindBy(xpath = "//input[@id='enterprise.name']")
    WebElement siteCompany;
    @FindBy(xpath = "//input[@id='enterprise.address.streetAddress']")
    WebElement streetAddress;
    @FindBy(xpath = "//input[@id='enterprise.address.streetNumber']")
    WebElement streetNumber;
    @FindBy(xpath = "//input[@id='enterprise.address.postalCode']")
    WebElement postalCode;
    @FindBy(xpath = "//input[@id='enterprise.address.city']")
    WebElement city;

    @FindBy(xpath = "//select[@id='enterprise.umbrellaOrganisationId']")
    WebElement umbrellaOrganisation;
    @FindBy(xpath = "//select[@id='enterprise.legalForm']")
    WebElement companyForm;
    @FindBy(xpath = "//option[contains(text(),'Bathildisheim e. V.')]")
    WebElement umbrellaOrganisationChosen;
    @FindBy(xpath = "//option[contains(text(),'Aktiengesellschaft (AG)')]")
    WebElement companyFormChosen;
    @FindBy(xpath = "//select[@id='contact.salutation']")
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

    public WebElement companyFormChosen() {
        return companyFormChosen;
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

    public WebElement umbrellaOrganisation() {
        return umbrellaOrganisation;
    }

    public WebElement companyForm() {
        return companyForm;
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
