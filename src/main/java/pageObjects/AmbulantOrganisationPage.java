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
    @FindBy(xpath = "//section[@class='Input textarea required empty invalid']//textarea[@id='description']")
    WebElement presentationOfDepartment;
    @FindBy(xpath = "//section[@class='Input uspTextarea textarea required empty invalid']//textarea[@id='usps.0']")
    WebElement particularityZero;
    @FindBy(xpath = "//section[@class='Input uspTextarea textarea required empty invalid']//textarea[@id='usps.1']")
    WebElement particularityOne;
    @FindBy(xpath = "//section[@class='Input uspTextarea textarea required empty invalid']//textarea[@id='usps.2']")
    WebElement particularityTwo;
    @FindBy(xpath = "//section[@class='Input uspTextarea textarea required empty invalid']//textarea[@id='usps.3']")
    WebElement particularityThree;
    @FindBy(xpath = "//section[@class='Input uspTextarea textarea required empty invalid']//textarea[@id='usps.4']")
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

    //Pflegegrad
    @FindBy(xpath = "//section[@class='DepartmentOffers']//input[@id='tmp.offers.careLevel.1']")
    WebElement careLevelOne;
    @FindBy(xpath = "//section[@class='DepartmentOffers']//input[@id='tmp.offers.careLevel.2']")
    WebElement careLevelTwo;
    @FindBy(xpath = "//section[@class='DepartmentOffers']//input[@id='tmp.offers.careLevel.3']")
    WebElement careLevelThree;
    @FindBy(xpath = "//section[@class='DepartmentOffers']//input[@id='tmp.offers.careLevel.4']")
    WebElement careLevelFour;
    @FindBy(xpath = "//section[@class='DepartmentOffers']//input[@id='tmp.offers.careLevel.5']")
    WebElement careLevelFive;

    //GETTER Pflegegrad
    public WebElement careLevelOne() {
        return careLevelOne;
    }

    public WebElement careLevelTwo() {
        return careLevelTwo;
    }

    public WebElement careLevelThree() {
        return careLevelThree;
    }

    public WebElement careLevelFour() {
        return careLevelFour;
    }

    public WebElement careLevelFive() {
        return careLevelFive;
    }

    //Leistungen
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1094']")
    WebElement foodOnWheels;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1095']")
    WebElement homeHelp;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1096']")
    WebElement domesticCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1097']")
    WebElement ambulantHospice;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1098']")
    WebElement treatmentCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1099']")
    WebElement mentallyRetardet;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e109a']")
    WebElement physicallyDisabled;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e109b']")
    WebElement dayCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e109c']")
    WebElement nightCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e109d']")
    WebElement intensivCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e109e']")
    WebElement preventionCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e109f']")
    WebElement reliefCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e10a0']")
    WebElement dementiaCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e10a1']")
    WebElement intensivCareVegetativeState;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e10a2']")
    WebElement ventilatorCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e10a3']")
    WebElement hospiceWork;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e10a4']")
    WebElement hollydayCare;

    //GETTER Leistungen
    public WebElement foodOnWheels() {
        return foodOnWheels;
    }

    public WebElement homeHelp() {
        return homeHelp;
    }

    public WebElement domesticCare() {
        return domesticCare;
    }

    public WebElement ambulantHospice() {
        return ambulantHospice;
    }

    public WebElement treatmentCare() {
        return treatmentCare;
    }

    public WebElement mentallyRetardet() {
        return mentallyRetardet;
    }

    public WebElement physicallyDisabled() {
        return physicallyDisabled;
    }

    public WebElement dayCare() {
        return dayCare;
    }

    public WebElement nightCare() {
        return nightCare;
    }

    public WebElement intensivCare() {
        return intensivCare;
    }

    public WebElement preventionCare() {
        return preventionCare;
    }

    public WebElement reliefCare() {
        return reliefCare;
    }

    public WebElement dementiaCare() {
        return dementiaCare;
    }

    public WebElement intensivCareVegetativeState() {
        return intensivCareVegetativeState;
    }

    public WebElement ventilatorCare() {
        return ventilatorCare;
    }

    public WebElement hospiceWork() {
        return hospiceWork;
    }

    public WebElement hollydayCare() {
        return hollydayCare;
    }
}
