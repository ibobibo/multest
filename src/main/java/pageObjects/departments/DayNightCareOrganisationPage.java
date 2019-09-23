package pageObjects.departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DayNightCareOrganisationPage {
    WebDriver driver;

    public DayNightCareOrganisationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='Department']//a[@id='add-department']")
    WebElement addDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='DAYCARE card']//a[@class='create']")
    WebElement addDayNightCareDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='DAYCARE card']//a[@class='create']")
    WebElement addFirstDayNightCareDepartment;

    //allgemeine Angaben zur Einrichtung
    @FindBy(id = "name")
    WebElement dayNightCareDepartmentName;
    @FindBy(id = "organisationType")
    WebElement dayNightCareDepartmentOrganisationType;
    @FindBy(xpath = "//option[. = 'Privat']")
    WebElement dayNightCareDepartmentOrganisationTypeChosen;
    @FindBy(id = "confession")
    WebElement dayNightCareDepartmentConfession;
    @FindBy(xpath = "//section[@class='Input  select     empty']//label[@class='Checkbox ']")
    WebElement dayNightCareDepartmentAccept;
    @FindBy(id = "address.streetAddress")
    WebElement dayNightCareDepartmentStreetAddress;
    @FindBy(id = "address.streetNumber")
    WebElement dayNightCareDepartmentStreetNumber;
    @FindBy(id = "address.postalCode")
    WebElement dayNightCareDepartmentPostalCode;
    @FindBy(id = "address.city")
    WebElement dayNightCareDepartmentAddressCity;
    @FindBy(id = "website")
    WebElement dayNightCareDepartmentWebsite;
    @FindBy(id = "#availability")
    WebElement dayNightCareDepartmentAvailable;
    @FindBy(xpath = "//option[. = 'Auf Anfrage']")
    WebElement dayNightCareDepartmentAvailableChosen;

    //GETTER allgemeine Angaben zur Einrichtung
    public WebElement addDepartment() {
        return addDepartment;
    }

    public WebElement addDayNightCareDepartment() {
        return addDayNightCareDepartment;
    }

    public WebElement addFirstDayNightCareDepartment() {
        return addFirstDayNightCareDepartment;
    }

    public WebElement dayNightCareDepartmentName() {
        return dayNightCareDepartmentName;
    }

    public WebElement dayNightCareDepartmentOrganisationType() {
        return dayNightCareDepartmentOrganisationType;
    }

    public WebElement dayNightCareDepartmentOrganisationTypeChosen() {
        return dayNightCareDepartmentOrganisationTypeChosen;
    }

    public WebElement dayNightCareDepartmentConfession() {
        return dayNightCareDepartmentConfession;
    }

    public WebElement dayNightCareDepartmentAccept() {
        return dayNightCareDepartmentAccept;
    }

    public WebElement dayNightCareDepartmentStreetAddress() {
        return dayNightCareDepartmentStreetAddress;
    }

    public WebElement dayNightCareDepartmentStreetNumber() {
        return dayNightCareDepartmentStreetNumber;
    }

    public WebElement dayNightCareDepartmentPostalCode() {
        return dayNightCareDepartmentPostalCode;
    }

    public WebElement dayNightCareDepartmentAddressCity() {
        return dayNightCareDepartmentAddressCity;
    }

    public WebElement dayNightCareDepartmentWebsite() {
        return dayNightCareDepartmentWebsite;
    }

    public WebElement dayNightCareDepartmentAvailable() {
        return dayNightCareDepartmentAvailable;
    }

    public WebElement dayNightCareDepartmentAvailableChosen() {
        return dayNightCareDepartmentAvailableChosen;
    }

    //ansprechpartner
    @FindBy(id = "contact.salutation")
    WebElement dayNightCareDepartmentContactSalutation;
    @FindBy(xpath = "//option[. = 'ohne Anrede']")
    WebElement dayNightCareDepartmentContactSalutationChosen;
    @FindBy(id = "contact.firstName")
    WebElement dayNightCareDepartmentContactFirstName;
    @FindBy(id = "contact.lastName")
    WebElement dayNightCareDepartmentContactLastName;
    @FindBy(id = "contact.title")
    WebElement dayNightCareDepartmentContactTitle;
    @FindBy(id = "contact.phone")
    WebElement dayNightCareDepartmentContactPhone;

    //GETTER ansprechpartner
    public WebElement dayNightCareDepartmentContactSalutation() {
        return dayNightCareDepartmentContactSalutation;
    }

    public WebElement dayNightCareDepartmentContactSalutationChosen() {
        return dayNightCareDepartmentContactSalutationChosen;
    }

    public WebElement dayNightCareDepartmentContactFirstName() {
        return dayNightCareDepartmentContactFirstName;
    }

    public WebElement dayNightCareDepartmentContactLastName() {
        return dayNightCareDepartmentContactLastName;
    }

    public WebElement dayNightCareDepartmentContactTitle() {
        return dayNightCareDepartmentContactTitle;
    }

    public WebElement dayNightCareDepartmentContactPhone() {
        return dayNightCareDepartmentContactPhone;
    }

    //sprechzeiten Montag
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.0.0.startHour']")
    WebElement mondayHourBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.0.0.startMinute']")
    WebElement mondayMinuteBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.0.0.endHour']")
    WebElement mondayHourEnd;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.0.0.endMinute']")
    WebElement mondayMinuteEnd;

    //GETTER sprechzeiten Montag
    public WebElement mondayHourBegin() {
        return mondayHourBegin;
    }

    public WebElement mondayMinuteBegin() {
        return mondayMinuteBegin;
    }

    public WebElement mondayHourEnd() {
        return mondayHourEnd;
    }

    public WebElement mondayMinuteEnd() {
        return mondayMinuteEnd;
    }

    //sprechzeiten Dienstag
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.1.0.startHour']")
    WebElement tuesdayHourBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.1.0.startMinute']")
    WebElement tuesdayMinuteBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.1.0.endHour']")
    WebElement tuesdayHourEnd;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.1.0.endMinute']")
    WebElement tuesdayMinuteEnd;

    //GETTER sprechzeiten Dienstag
    public WebElement tuesdayHourBegin() {
        return tuesdayHourBegin;
    }

    public WebElement tuesdayMinuteBegin() {
        return tuesdayMinuteBegin;
    }

    public WebElement tuesdayHourEnd() {
        return tuesdayHourEnd;
    }

    public WebElement tuesdayMinuteEnd() {
        return tuesdayMinuteEnd;
    }

    //sprechzeiten Mittwoch
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.2.0.startHour']")
    WebElement wednesdayHourBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.2.0.startMinute']")
    WebElement wednesdayMinuteBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.2.0.endHour']")
    WebElement wednesdayHourEnd;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.2.0.endMinute']")
    WebElement wednesdayMinuteEnd;

    //GETTER sprechzeiten Mittwoch
    public WebElement wednesdayHourBegin() {
        return wednesdayHourBegin;
    }

    public WebElement wednesdayMinuteBegin() {
        return wednesdayMinuteBegin;
    }

    public WebElement wednesdayHourEnd() {
        return wednesdayHourEnd;
    }

    public WebElement wednesdayMinuteEnd() {
        return wednesdayMinuteEnd;
    }

    //sprechzeiten Donnerstag
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.3.0.startHour']")
    WebElement thursdayHourBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.3.0.startMinute']")
    WebElement thursdayMinuteBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.3.0.endHour']")
    WebElement thursdayHourEnd;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.3.0.endMinute']")
    WebElement thursdayMinuteEnd;

    //GETTER sprechzeiten Donnerstag
    public WebElement thursdayHourBegin() {
        return thursdayHourBegin;
    }

    public WebElement thursdayMinuteBegin() {
        return thursdayMinuteBegin;
    }

    public WebElement thursdayHourEnd() {
        return thursdayHourEnd;
    }

    public WebElement thursdayMinuteEnd() {
        return thursdayMinuteEnd;
    }

    //sprechzeiten Freitag
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.4.0.startHour']")
    WebElement fridayHourBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.4.0.startMinute']")
    WebElement fridayMinuteBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.4.0.endHour']")
    WebElement fridayHourEnd;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.4.0.endMinute']")
    WebElement fridayMinuteEnd;

    //GETTER sprechzeiten Freitag
    public WebElement fridayHourBegin() {
        return fridayHourBegin;
    }

    public WebElement fridayMinuteBegin() {
        return fridayMinuteBegin;
    }

    public WebElement fridayHourEnd() {
        return fridayHourEnd;
    }

    public WebElement fridayMinuteEnd() {
        return fridayMinuteEnd;
    }

    //sprechzeiten Samstag
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.5.0.startHour']")
    WebElement saturdayHourBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.5.0.startMinute']")
    WebElement saturdayMinuteBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.5.0.endHour']")
    WebElement saturdayHourEnd;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.5.0.endMinute']")
    WebElement saturdayMinuteEnd;

    //GETTER sprechzeiten Samstag
    public WebElement saturdayHourBegin() {
        return saturdayHourBegin;
    }

    public WebElement saturdayMinuteBegin() {
        return saturdayMinuteBegin;
    }

    public WebElement saturdayHourEnd() {
        return saturdayHourEnd;
    }

    public WebElement saturdayMinuteEnd() {
        return saturdayMinuteEnd;
    }

    //sprechzeiten Sonntag
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.6.0.startHour']")
    WebElement sundayHourBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.6.0.startMinute']")
    WebElement sundayMinuteBegin;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.6.0.endHour']")
    WebElement sundayHourEnd;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.consultationHours.6.0.endMinute']")
    WebElement sundayMinuteEnd;

    //GETTER sprechzeiten Sonntag
    public WebElement sundayHourBegin() {
        return sundayHourBegin;
    }

    public WebElement sundayMinuteBegin() {
        return sundayMinuteBegin;
    }

    public WebElement sundayHourEnd() {
        return sundayHourEnd;
    }

    public WebElement sundayMinuteEnd() {
        return sundayMinuteEnd;
    }

    //Allgemeine Beschreibung
    @FindBy(id = "description")
    WebElement presentationOfDepartment;
    @FindBy(id = "usps.0")
    WebElement particularityZero;
    @FindBy(id = "usps.1")
    WebElement particularityOne;
    @FindBy(id = "usps.2")
    WebElement particularityTwo;
    @FindBy(id = "usps.3")
    WebElement particularityThree;
    @FindBy(id = "usps.4")
    WebElement particularityFour;

    //GETTER allgemeine Beschreibung
    public WebElement presentationOfDepartment() {
        return presentationOfDepartment;
    }

    public WebElement particularityZero() {
        return particularityZero;
    }

    public WebElement particularityOne() {
        return particularityOne;
    }

    public WebElement particularityTwo() {
        return particularityTwo;
    }

    public WebElement particularityThree() {
        return particularityThree;
    }

    public WebElement particularityFour() {
        return particularityFour;
    }

    //Personal
    @FindBy(xpath = "//section[@class='Input  select     empty']//select[@id='staffRange']")
    WebElement staffRange;

    //GETTER Personal
    public WebElement staffRange() {
        return staffRange;
    }

    //bediente PLZ
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.operatedZipCodes']")
    WebElement servedAreas;

    //GETTER bediente PLZ
    public WebElement servedAreas() {
        return servedAreas;
    }

    //weitere sprachen
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.languages.ENGLISH']")
    WebElement english;
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.languages.TURKISH']")
    WebElement turkish;
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.languages.FRENCH']")
    WebElement french;
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.languages.RUSSIAN']")
    WebElement russian;
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.languages.SPANISH']")
    WebElement spanish;
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.languages.POLISH']")
    WebElement polish;

    //GETTER weitere Sprachen
    public WebElement english() {
        return english;
    }

    public WebElement turkish() {
        return turkish;
    }

    public WebElement french() {
        return french;
    }

    public WebElement russian() {
        return russian;
    }

    public WebElement spanish() {
        return spanish;
    }

    public WebElement polish() {
        return polish;
    }

    //Siegel
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.certificateCategories.5d10da2b9a3dec00013e10b6']")
    WebElement certificat;

    //GETTER Siegel
    public WebElement certificat() {
        return certificat;
    }

    //youtube video
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='youtubeURL']")
    WebElement youTubeVideo;

    //GETTER youtube video
    public WebElement youTubeVideo() {
        return youTubeVideo;
    }

    //Einrichtung speichern
    @FindBy(id = "publish-department")
    WebElement saveDepartment;

    //GETTER Einrichtung speichern
    public WebElement saveDepartment() {
        return saveDepartment;
    }
}
