package pageObjects.departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FairHouseOfferPage {
    WebDriver driver;

    public FairHouseOfferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //click add Department
    @FindBy(xpath = "//section[@class='Department']//a[@id='add-department']")
    WebElement addDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='HOUSING card']//a[@class='create']")
    WebElement addFairHouseOfferDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='HOUSING card']//a[@class='create']")
    WebElement addFirstFairHouseOfferDepartment;

    //GETTER click add Department
    public WebElement addDepartment() {
        return addDepartment;
    }

    public WebElement addFairHouseOfferDepartment() {
        return addFairHouseOfferDepartment;
    }

    public WebElement addFirstFairHouseOfferDepartment() {
        return addFirstFairHouseOfferDepartment;
    }

    //MODAL für Department
    @FindBy(xpath = "//span[contains(text(),'barrierearme Wohnung')]")
    WebElement accessibilityApartment;
    @FindBy(xpath = "//span[contains(text(),'barrierearmes Wohnumfeld')]")
    WebElement accessibilityApartmentArea;
    @FindBy(xpath = "//span[contains(text(),'barrierefrei')]")
    WebElement accessibility;
    @FindBy(xpath = "//span[contains(text(),'Aufzug/ Lift')]")
    WebElement elevator;
    @FindBy(xpath = "//span[contains(text(),'Serviceangebote')]")
    WebElement serviceOffer;
    @FindBy(xpath = "//span[contains(text(),'Mobilitätsangebote')]")
    WebElement mobilityOffer;
    @FindBy(xpath = "//span[contains(text(),'technische Assistenzsysteme')]")
    WebElement technicalAssistanceSystems;
    @FindBy(xpath = "//span[contains(text(),'Ich bestätige')]")
    WebElement conformation;
    @FindBy(xpath = "//div[@class='modal-footer']//button[@type='submit']")
    WebElement submitButton;

    //GETTER Modal Department
    public WebElement accessibilityApartment() {
        return accessibilityApartment;
    }

    public WebElement accessibilityApartmentArea() {
        return accessibilityApartmentArea;
    }

    public WebElement accessibility() {
        return accessibility;
    }

    public WebElement elevator() {
        return elevator;
    }

    public WebElement serviceOffer() {
        return serviceOffer;
    }

    public WebElement mobilityOffer() {
        return mobilityOffer;
    }

    public WebElement technicalAssistanceSystems() {
        return technicalAssistanceSystems;
    }

    public WebElement conformation() {
        return conformation;
    }

    public WebElement submitButton() {
        return submitButton;
    }

    //allgemeine Angaben zur Einrichtung
    @FindBy(id = "name")
    WebElement fairHouseOfferDepartmentName;
    @FindBy(id = "address.streetAddress")
    WebElement fairHouseOfferDepartmentStreetAddress;
    @FindBy(id = "address.streetNumber")
    WebElement fairHouseOfferDepartmentStreetNumber;
    @FindBy(id = "address.postalCode")
    WebElement fairHouseOfferDepartmentPostalCode;
    @FindBy(id = "address.city")
    WebElement fairHouseOfferDepartmentAddressCity;
    @FindBy(id = "website")
    WebElement fairHouseOfferDepartmentWebsite;

    //GETTER allgemeine Angaben zur Einrichtung
    public WebElement fairHouseOfferDepartmentName() {
        return fairHouseOfferDepartmentName;
    }

    public WebElement fairHouseOfferDepartmentStreetAddress() {
        return fairHouseOfferDepartmentStreetAddress;
    }

    public WebElement fairHouseOfferDepartmentStreetNumber() {
        return fairHouseOfferDepartmentStreetNumber;
    }

    public WebElement fairHouseOfferDepartmentPostalCode() {
        return fairHouseOfferDepartmentPostalCode;
    }

    public WebElement fairHouseOfferDepartmentAddressCity() {
        return fairHouseOfferDepartmentAddressCity;
    }

    public WebElement fairHouseOfferDepartmentWebsite() {
        return fairHouseOfferDepartmentWebsite;
    }

    //ansprechpartner
    @FindBy(xpath = "//option[. = 'ohne Anrede']")
    WebElement fairHouseOfferDepartmentContactSalutationChosen;
    @FindBy(id = "contact.firstName")
    WebElement fairHouseOfferDepartmentContactFirstName;
    @FindBy(id = "contact.lastName")
    WebElement fairHouseOfferDepartmentContactLastName;
    @FindBy(id = "contact.title")
    WebElement fairHouseOfferDepartmentContactTitle;
    @FindBy(id = "contact.phone")
    WebElement fairHouseOfferDepartmentContactPhone;

    //GETTER ansprechpartner
    public WebElement fairHouseOfferDepartmentContactSalutationChosen() {
        return fairHouseOfferDepartmentContactSalutationChosen;
    }

    public WebElement fairHouseOfferDepartmentContactFirstName() {
        return fairHouseOfferDepartmentContactFirstName;
    }

    public WebElement fairHouseOfferDepartmentContactLastName() {
        return fairHouseOfferDepartmentContactLastName;
    }

    public WebElement fairHouseOfferDepartmentContactTitle() {
        return fairHouseOfferDepartmentContactTitle;
    }

    public WebElement fairHouseOfferDepartmentContactPhone() {
        return fairHouseOfferDepartmentContactPhone;
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

    //Allgemeine Beschreibung des Wohnprojekts
    @FindBy(xpath = "//textarea[@id='residentialProperty.description']")
    WebElement descriptionOfApartment;
    @FindBy(xpath = "//option[. = 'eigene Wohnung']")
    WebElement apartmentTypeChosen;
    @FindBy(xpath = "//option[. = 'Quartier']")
    WebElement apartmentPropertyChosen;
    @FindBy(id = "residentialProperty.provider.text")
    WebElement provider;
    @FindBy(xpath = "//option[. = 'Eigentümer']")
    WebElement providerTypeChosen;
    @FindBy(id = "residentialProperty.operator.text")
    WebElement operator;
    @FindBy(id = "residentialProperty.operator.description")
    WebElement operatorDescription;
    @FindBy(id = "residentialProperty.minRentalFee")
    WebElement rental;
    @FindBy(id = "residentialProperty.ancillaryCosts")
    WebElement otherCosts;
    @FindBy(id = "residentialProperty.ancillaryCostsIncluded")
    WebElement otherCostsInRenalCheckbox;
    @FindBy(id = "residentialProperty.minPurchasePrice")
    WebElement apartmentPrice;
    @FindBy(id = "residentialProperty.commonCharge")
    WebElement commonCharge;
    @FindBy(id = "residentialProperty.additionalPurchasePrice")
    WebElement additionalPurchasePrice;
    @FindBy(id = "residentialProperty.commission")
    WebElement commission;
    @FindBy(id = "residentialProperty.available")
    WebElement available;
    @FindBy(xpath = "//option[. = 'Erdgeschoss']")
    WebElement floorChosen;
    @FindBy(id = "residentialProperty.numberOfRooms")
    WebElement numberOfRooms;
    @FindBy(id = "residentialProperty.livingSpace")
    WebElement livingSpace;
    @FindBy(id = "residentialProperty.subsidizedHousing")
    WebElement subsidizedHousingCheckbox;
    @FindBy(xpath = "//option[. = 'Bedarfsausweis']")
    WebElement energyCertificateChosen;
    @FindBy(id = "residentialProperty.energyDemand")
    WebElement energyDemand;

    //GETTER Allgemeine Beschreibung des Wohnprojekts
    public WebElement descriptionOfApartment() {
        return descriptionOfApartment;
    }

    public WebElement apartmentTypeChosen() {
        return apartmentTypeChosen;
    }

    public WebElement apartmentPropertyChosen() {
        return apartmentPropertyChosen;
    }

    public WebElement provider() {
        return provider;
    }

    public WebElement providerTypeChosen() {
        return providerTypeChosen;
    }

    public WebElement operator() {
        return operator;
    }

    public WebElement operatorDescription() {
        return operatorDescription;
    }

    public WebElement rental() {
        return rental;
    }

    public WebElement otherCosts() {
        return otherCosts;
    }

    public WebElement otherCostsInRenalCheckbox() {
        return otherCostsInRenalCheckbox;
    }

    public WebElement apartmentPrice() {
        return apartmentPrice;
    }

    public WebElement commonCharge() {
        return commonCharge;
    }

    public WebElement additionalPurchasePrice() {
        return additionalPurchasePrice;
    }

    public WebElement commission() {
        return commission;
    }

    public WebElement available() {
        return available;
    }

    public WebElement floorChosen() {
        return floorChosen;
    }

    public WebElement numberOfRooms() {
        return numberOfRooms;
    }

    public WebElement livingSpace() {
        return livingSpace;
    }

    public WebElement subsidizedHousingCheckbox() {
        return subsidizedHousingCheckbox;
    }

    public WebElement energyCertificateChosen() {
        return energyCertificateChosen;
    }

    public WebElement energyDemand() {
        return energyDemand;
    }

    //Beschreibungen örtliche Gegebenheiten
    @FindBy(id = "realEstate.yearOfConstruction")
    WebElement yearOfConstruction;
    @FindBy(id = "realEstate.yearOfLastRefurbishment")
    WebElement yearOfLastRefurbishment;
    @FindBy(id = "realEstate.numberOfCommonRooms")
    WebElement numberOfCommonRooms;

    //GETTER Beschreibungen örtliche Gegebenheiten
    public WebElement yearOfConstruction() {
        return yearOfConstruction;
    }

    public WebElement yearOfLastRefurbishment() {
        return yearOfLastRefurbishment;
    }

    public WebElement numberOfCommonRooms() {
        return numberOfCommonRooms;
    }

    //leistungen Pflege
    //sonsigte Ausstatungen
    //soziale Umgebung
    //freizeit und Umgebung

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
