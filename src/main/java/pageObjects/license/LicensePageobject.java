package pageObjects.license;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicensePageobject {
    WebDriver driver;

    public LicensePageobject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='nav-home']")
    WebElement homepageNavbar;
    @FindBy(xpath = "//a[@id='nav-license']")
    WebElement licenseNavbar;
    @FindBy(xpath = "//li[@id='account-menu']")
    WebElement menuNavbar;

    public WebElement homepageNavbar() {
        return homepageNavbar;
    }

    public WebElement licenseNavbar() {
        return licenseNavbar;
    }

    public WebElement menuNavbar() {
        return menuNavbar;
    }

    @FindBy(xpath = "//section[@class='Collapsable isOpen']/div[@class='collapse show']/div[1]//button[@class='addToCart']")
    WebElement firstDepartmentAddLicense;
    @FindBy(xpath = "//section[@class='Collapsable isOpen']/div[@class='collapse show']/div[2]//button[@class='addToCart']")
    WebElement secondDepartmentAddLicense;
    @FindBy(xpath = "//section[@class='Collapsable isOpen']/div[@class='collapse show']/div[1]//button[@class='removeFromCart']")
    WebElement firstDepartmentRemoveLicense;
    @FindBy(xpath = "//section[@class='Collapsable isOpen']/div[@class='collapse show']/div[2]//button[@class='removeFromCart']")
    WebElement secondDepartmentRemoveLicense;

    public WebElement firstDepartmentAddLicense() {
        return firstDepartmentAddLicense;
    }

    public WebElement secondDepartmentAddLicense() {
        return secondDepartmentAddLicense;
    }

    public WebElement firstDepartmentRemoveLicense() {
        return firstDepartmentRemoveLicense;
    }

    public WebElement secondDepartmentRemoveLicense() {
        return secondDepartmentRemoveLicense;
    }

    @FindBy(xpath = "//section[@class='Collapsable isOpen']/div[@class='collapse show']/div[1]//span[contains(text(),'jetzt für 12 Monate buchen für 299,88')]")
    WebElement priceTextOfFirstElem;
    @FindBy(xpath = "//section[@class='Collapsable isOpen']/div[@class='collapse show']/div[2]//b[1]")
    WebElement priceTextOfSecondElem;
    @FindBy(xpath = "//section[@class='PremiumCart']//div[1]//div[3]//div[2]")
    WebElement shoppingCartFirstElem;
    @FindBy(xpath = "//section[@class='PremiumCart']//div[2]//div[3]//div[2]")
    WebElement shoppingCartSecondElem;
    @FindBy(xpath = "//div[@class='priceNetSum']//div[@class='values']")
    WebElement priceOfBothElems;
    @FindBy(xpath = "//div[@class='value']")
    WebElement taxesOfUniqueElems;
    @FindBy(xpath = "//div[@class='totalSum']//div[@class='values']")
    WebElement wholePrice;

    public WebElement priceTextOfFirstElem() {
        return priceTextOfFirstElem;
    }

    public WebElement priceTextOfSecondElem() {
        return priceTextOfSecondElem;
    }

    public WebElement shoppingCartFirstElem() {
        return shoppingCartFirstElem;
    }

    public WebElement shoppingCartSecondElem() {
        return shoppingCartSecondElem;
    }

    public WebElement priceOfBothElems() {
        return priceOfBothElems;
    }

    public WebElement taxesOfUniqueElems() {
        return taxesOfUniqueElems;
    }

    public WebElement wholePrice() {
        return wholePrice;
    }

    @FindBy(xpath = "//section[@class='PremiumCart']//div[@class='confirmation']//label[@class='Checkbox ']//span[contains(text(),'Ich')]")
    WebElement checkboxForConfirmation;
    @FindBy(xpath = "//a[@href='/premium/checkout']")
    WebElement continueToPayment;

    public WebElement checkboxForConfirmation() {
        return checkboxForConfirmation;
    }

    public WebElement continueToPayment() {
        return continueToPayment;
    }

    @FindBy(xpath = "//span[contains(text(),'Ihr Warenkorb ist leer.')]")
    WebElement checkIfBucketIsEmpty;

    public WebElement checkIfBucketIsEmpty() {
        return checkIfBucketIsEmpty;
    }

    @FindBy(xpath = "//div[@class='trialEndInfo']")
    WebElement checkIfTrial;
    @FindBy(xpath = "//a[@class='newPremium']")
    WebElement navToLicensePage;
    @FindBy(xpath = "//span[contains(text(),'Premium-Lizenzen')]")
    WebElement checkIfLicensePage;

    public WebElement checkIfTrial() {
        return checkIfTrial;
    }

    public WebElement navToLicensePage() {
        return navToLicensePage;
    }

    public WebElement checkIfLicensePage() {
        return checkIfLicensePage;
    }

    @FindBy(xpath = "//div[@class='tab-pane active']//span[contains(text(),'Einrichtung erstellen')]")
    WebElement checkIfDepartmentsAreCreated;
    @FindBy(xpath = "//div[@id='app-view-container']//li[2]//a[1]")
    WebElement showDepartments;
    @FindBy(xpath = "//div[@class='info']//span[contains(text(),'Einrichtungen')]")
    WebElement countDepartmentsInLicensePage;

    public WebElement checkIfDepartmentsAreCreated() {
        return checkIfDepartmentsAreCreated;
    }

    public WebElement showDepartments() {
        return showDepartments;
    }

    public WebElement countDepartmentsInLicensePage() {
        return countDepartmentsInLicensePage;
    }

}
