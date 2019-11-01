package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalConsultationPage {
    WebDriver driver;

    public DigitalConsultationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='nav-link']//span[contains(text(),'Digitale Beratung')]")
    WebElement clickDigitalConsultation;
    @FindBy(xpath = "//input[@id='location']")
    WebElement postalCode;
    @FindBy(xpath = "//section[@class='AdvisorPage']//label[@class='Checkbox ']//span[contains(text(),'Hiermit willigen Sie in die Verarbeitung')]")
    WebElement checkboxDigitalConsultation;
    @FindBy(xpath = "//button[@id='next-page']")
    WebElement nextPage;
    @FindBy(xpath = "//button[@class='back']")
    WebElement back;
    @FindBy(xpath = "//button[@id='2_4']")
    WebElement nursingDegreeAvailable;
    @FindBy(xpath = "//button[@id='2_5']")
    WebElement nursingDegreeNotAvailable;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Pflege')]")
    WebElement pflegeTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Hauswirtschaft & Einkaufen')]")
    WebElement hauswirtschaftTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Mobilität & Bewegung')]")
    WebElement mobilitaetTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Essen & Trinken')]")
    WebElement essenTrinkenTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Unterstützung bei Krankheit')]")
    WebElement unterstuetzungBeiKrankheitTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Hilfsmittel & Sicherheit im Alltag')]")
    WebElement hilfsmittelUndSicherheitImAlltagTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Betreuung & Begleitung')]")
    WebElement betreuungUndBegleitungTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Altersgerechtes Wohnen')]")
    WebElement altersgerechtesWohnenTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Demenz')]")
    WebElement demenzTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Gesellschaft & Unterhaltung')]")
    WebElement gesellschaftUndUnterhaltungTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Prävention & Vorsorge')]")
    WebElement praeventionUndVorsorgeTitle;
    @FindBy(xpath = "//div[@class='title'][contains(text(),'Zuhause bleiben')]")
    WebElement zuHauseBleibenTitle;

    //hauswirtschaftButtons
    @FindBy(xpath = "//button[@id='10_53']")
    WebElement yesButtonCard3;
    @FindBy(xpath = "//button[@id='10_54']")
    WebElement noButtonCard3;
    @FindBy(xpath = "//button[@id='20_99']")
    WebElement yesButtonCard7;
    @FindBy(xpath = "//button[@id='20_100']")
    WebElement noButtonCard7;
    @FindBy(xpath = "//button[@id='24_136']")
    WebElement yesButtonCard8;
    @FindBy(xpath = "//button[@id='24_137']")
    WebElement noButtonCard8;
    //button[@id='24_136']

    public WebElement clickDigitalConsultation() {
        return clickDigitalConsultation;
    }

    public WebElement postalCode() {
        return postalCode;
    }

    public WebElement checkboxDigitalConsultation() {
        return checkboxDigitalConsultation;
    }

    public WebElement nextPage() {
        return nextPage;
    }

    public WebElement back() {
        return back;
    }

    public WebElement nursingDegreeAvailable() {
        return nursingDegreeAvailable;
    }

    //card titles
    public WebElement pflegeTitle() {
        return pflegeTitle;
    }

    public WebElement hauswirtschaftTitle() {
        return hauswirtschaftTitle;
    }

    public WebElement mobilitaetTitle() {
        return mobilitaetTitle;
    }

    public WebElement essenTrinkenTitle() {
        return essenTrinkenTitle;
    }

    public WebElement unterstuetzungBeiKrankheitTitle() {
        return unterstuetzungBeiKrankheitTitle;
    }

    public WebElement hilfsmittelUndSicherheitImAlltagTitle() {
        return hilfsmittelUndSicherheitImAlltagTitle;
    }

    public WebElement betreuungUndBegleitungTitle() {
        return betreuungUndBegleitungTitle;
    }

    public WebElement altersgerechtesWohnenTitle() {
        return altersgerechtesWohnenTitle;
    }

    public WebElement demenzTitle() {
        return demenzTitle;
    }

    public WebElement gesellschaftUndUnterhaltungTitle() {
        return gesellschaftUndUnterhaltungTitle;
    }

    public WebElement praeventionUndVorsorgeTitle() {
        return praeventionUndVorsorgeTitle;
    }

    public WebElement zuHauseBleibenTitle() {
        return zuHauseBleibenTitle;
    }

    public WebElement yesButtonCard3() {
        return yesButtonCard3;
    }

    public WebElement noButtonCard3() {
        return noButtonCard3;
    }

    public WebElement yesButtonCard7() {
        return yesButtonCard3;
    }

    public WebElement noButtonCard7() {
        return noButtonCard3;
    }

    public WebElement yesButtonCard8() {
        return yesButtonCard3;
    }

    public WebElement noButtonCard8() {
        return noButtonCard3;
    }
}
