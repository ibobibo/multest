package pageObjects.departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StationaryOrganisationPage {
    WebDriver driver;

    public StationaryOrganisationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='Department']//a[@id='add-department']")
    WebElement addDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='STATIONARY card']//a[@class='create']")
    WebElement addStationaryDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='STATIONARY card']//a[@class='create']")
    WebElement addFirstStationaryDepartment;

    //allgemeine Angaben zur Einrichtung
    @FindBy(id = "name")
    WebElement stationaryDepartmentName;
    @FindBy(xpath = "//option[. = 'Privat']")
    WebElement stationaryDepartmentOrganisationTypeChosen;
    @FindBy(id = "confession")
    WebElement stationaryDepartmentConfession;
    @FindBy(xpath = "//section[@class='Input  select     empty']//label[@class='Checkbox ']")
    WebElement stationaryDepartmentAccept;
    @FindBy(id = "address.streetAddress")
    WebElement stationaryDepartmentStreetAddress;
    @FindBy(id = "address.streetNumber")
    WebElement stationaryDepartmentStreetNumber;
    @FindBy(id = "address.postalCode")
    WebElement stationaryDepartmentPostalCode;
    @FindBy(id = "address.city")
    WebElement stationaryDepartmentAddressCity;
    @FindBy(id = "website")
    WebElement stationaryDepartmentWebsite;
    @FindBy(id = "#availability")
    WebElement stationaryDepartmentAvailable;
    @FindBy(xpath = "//option[. = 'Auf Anfrage']")
    WebElement stationaryDepartmentAvailableChosen;

    //GETTER allgemeine Angaben zur Einrichtung
    public WebElement addDepartment() {
        return addDepartment;
    }

    public WebElement addStationaryDepartment() {
        return addStationaryDepartment;
    }

    public WebElement addFirstStationaryDepartment() {
        return addFirstStationaryDepartment;
    }

    public WebElement stationaryDepartmentName() {
        return stationaryDepartmentName;
    }

    public WebElement stationaryDepartmentOrganisationTypeChosen() {
        return stationaryDepartmentOrganisationTypeChosen;
    }

    public WebElement stationaryDepartmentConfession() {
        return stationaryDepartmentConfession;
    }

    public WebElement stationaryDepartmentAccept() {
        return stationaryDepartmentAccept;
    }

    public WebElement stationaryDepartmentStreetAddress() {
        return stationaryDepartmentStreetAddress;
    }

    public WebElement stationaryDepartmentStreetNumber() {
        return stationaryDepartmentStreetNumber;
    }

    public WebElement stationaryDepartmentPostalCode() {
        return stationaryDepartmentPostalCode;
    }

    public WebElement stationaryDepartmentAddressCity() {
        return stationaryDepartmentAddressCity;
    }

    public WebElement stationaryDepartmentWebsite() {
        return stationaryDepartmentWebsite;
    }

    public WebElement stationaryDepartmentAvailable() {
        return stationaryDepartmentAvailable;
    }

    public WebElement stationaryDepartmentAvailableChosen() {
        return stationaryDepartmentAvailableChosen;
    }

    //ansprechpartner
    @FindBy(id = "contact.salutation")
    WebElement stationaryDepartmentContactSalutation;
    @FindBy(xpath = "//option[. = 'ohne Anrede']")
    WebElement stationaryDepartmentContactSalutationChosen;
    @FindBy(id = "contact.firstName")
    WebElement stationaryDepartmentContactFirstName;
    @FindBy(id = "contact.lastName")
    WebElement stationaryDepartmentContactLastName;
    @FindBy(id = "contact.title")
    WebElement stationaryDepartmentContactTitle;
    @FindBy(id = "contact.phone")
    WebElement stationaryDepartmentContactPhone;

    //GETTER ansprechpartner
    public WebElement stationaryDepartmentContactSalutation() {
        return stationaryDepartmentContactSalutation;
    }

    public WebElement stationaryDepartmentContactSalutationChosen() {
        return stationaryDepartmentContactSalutationChosen;
    }

    public WebElement stationaryDepartmentContactFirstName() {
        return stationaryDepartmentContactFirstName;
    }

    public WebElement stationaryDepartmentContactLastName() {
        return stationaryDepartmentContactLastName;
    }

    public WebElement stationaryDepartmentContactTitle() {
        return stationaryDepartmentContactTitle;
    }

    public WebElement stationaryDepartmentContactPhone() {
        return stationaryDepartmentContactPhone;
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
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.yearOfConstruction']")
    WebElement constructionYear;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.yearOfLastRefurbishment']")
    WebElement refurbishmentYear;
    @FindBy(xpath = "//section[@class='DepartmentRealEstate']//label[@class='Checkbox ']")
    WebElement elevator;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.numberOfRooms']")
    WebElement numberOfRooms;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.roomSizeMin']")
    WebElement roomSizeMin;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.roomSizeMax']")
    WebElement roomSizeMax;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.numberOfBeds']")
    WebElement numberOfBeds;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.numberOfCommonRooms']")
    WebElement numberOfCommonRooms;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.environmentInfo']")
    WebElement enviromentInfo;

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

    public WebElement constructionYear() {
        return constructionYear;
    }

    public WebElement refurbishmentYear() {
        return refurbishmentYear;
    }

    public WebElement elevator() {
        return elevator;
    }

    public WebElement numberOfRooms() {
        return numberOfRooms;
    }

    public WebElement roomSizeMin() {
        return roomSizeMin;
    }

    public WebElement roomSizeMax() {
        return roomSizeMax;
    }

    public WebElement numberOfBeds() {
        return numberOfBeds;
    }

    public WebElement numberOfCommonRooms() {
        return numberOfCommonRooms;
    }

    public WebElement enviromentInfo() {
        return enviromentInfo;
    }

    //Personal
    @FindBy(xpath = "//section[@class='Input  select     empty']//select[@id='staffRange']")
    WebElement staffRange;

    //GETTER Personal
    public WebElement staffRange() {
        return staffRange;
    }

    //Pflegegrad der Betreut wird
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.offers.minPrice.1']")
    WebElement careLevelOne;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.offers.minPrice.2']")
    WebElement careLevelTwo;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.offers.minPrice.3']")
    WebElement careLevelThree;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.offers.minPrice.4']")
    WebElement careLevelFour;
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.offers.minPrice.5']")
    WebElement careLevelFive;

    //GETTER Pflegegrad der Betreut wird
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

    //Leistungen - Pflege
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e106b']")
    WebElement bath;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e106c']")
    WebElement balkon;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e106d']")
    WebElement kapelle;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e106e']")
    WebElement church;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e106f']")
    WebElement fitness;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1070']")
    WebElement spa;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1071']")
    WebElement swimhall;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1072']")
    WebElement libary;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1073']")
    WebElement roomForAll;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1074']")
    WebElement kegelGame;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1075']")
    WebElement busStation;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1076']")
    WebElement busShuttle;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1077']")
    WebElement resturant;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1078']")
    WebElement cafe;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.careCategories.5d109c239a3dec00013e1079']")
    WebElement pets;

    //GETTER Leistungen - Pflege
    public WebElement bath() {
        return bath;
    }

    public WebElement balkon() {
        return balkon;
    }

    public WebElement kapelle() {
        return kapelle;
    }

    public WebElement church() {
        return church;
    }

    public WebElement fitness() {
        return fitness;
    }

    public WebElement spa() {
        return spa;
    }

    public WebElement swimhall() {
        return swimhall;
    }

    public WebElement libary() {
        return libary;
    }

    public WebElement roomForAll() {
        return roomForAll;
    }

    public WebElement kegelGame() {
        return kegelGame;
    }

    public WebElement busStation() {
        return busStation;
    }

    public WebElement busShuttle() {
        return busShuttle;
    }

    public WebElement resturant() {
        return resturant;
    }

    public WebElement cafe() {
        return cafe;
    }

    public WebElement pets() {
        return pets;
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

    //Verkehrsanbindung
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.transportConnections.BUS']")
    WebElement trafficBusStation;
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.transportConnections.TRAIN']")
    WebElement trafficTrainStation;
    @FindBy(xpath = "//section[@class='DepartmentBasicServices']//input[@id='tmp.transportConnections.PARKING']")
    WebElement trafficParkStation;

    //GETTER Verkehrsanbindung
    public WebElement trafficBusStation() {
        return trafficBusStation;
    }

    public WebElement trafficTrainStation() {
        return trafficTrainStation;
    }

    public WebElement trafficParkStation() {
        return trafficParkStation;
    }

    //Sonstige Ausstattungen
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107a']")
    WebElement testLiving;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107b']")
    WebElement guestLiving;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107c']")
    WebElement ownFurniture;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107d']")
    WebElement treatmentCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107e']")
    WebElement mentalCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107f']")
    WebElement physicallyCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1080']")
    WebElement fullTime;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1081']")
    WebElement dayTime;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1082']")
    WebElement nightTime;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1083']")
    WebElement smallTime;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1084']")
    WebElement intensivCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1085']")
    WebElement respiteCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1086']")
    WebElement littleRespiteCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1087']")
    WebElement dementStation;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1088']")
    WebElement dementVilleClosed;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1089']")
    WebElement dementVilleOpen;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e108a']")
    WebElement dementCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e108b']")
    WebElement comaCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e108c']")
    WebElement breatheCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e108d']")
    WebElement dementCareWithAccommodation;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e108e']")
    WebElement specialMentalCare;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e108f']")
    WebElement hospiceWork;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1090']")
    WebElement forHandicapped;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1091']")
    WebElement doctorVisit;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1092']")
    WebElement specialDoctorVisit;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1093']")
    WebElement hollydayCare;


    //GETTER Sonstige Ausstattungen
    public WebElement testLiving() {
        return testLiving;
    }

    public WebElement guestLiving() {
        return guestLiving;
    }

    public WebElement ownFurniture() {
        return ownFurniture;
    }

    public WebElement treatmentCare() {
        return treatmentCare;
    }

    public WebElement mentalCare() {
        return mentalCare;
    }

    public WebElement physicallyCare() {
        return physicallyCare;
    }

    public WebElement fullTime() {
        return fullTime;
    }

    public WebElement dayTime() {
        return dayTime;
    }

    public WebElement nightTime() {
        return nightTime;
    }

    public WebElement smallTime() {
        return smallTime;
    }

    public WebElement intensivCare() {
        return intensivCare;
    }

    public WebElement respiteCare() {
        return respiteCare;
    }

    public WebElement littleRespiteCare() {
        return littleRespiteCare;
    }

    public WebElement dementStation() {
        return dementStation;
    }

    public WebElement dementVilleClosed() {
        return dementVilleClosed;
    }

    public WebElement dementVilleOpen() {
        return dementVilleOpen;
    }

    public WebElement dementCare() {
        return dementCare;
    }

    public WebElement comaCare() {
        return comaCare;
    }

    public WebElement breatheCare() {
        return breatheCare;
    }

    public WebElement dementCareWithAccommodation() {
        return dementCareWithAccommodation;
    }

    public WebElement specialMentalCare() {
        return specialMentalCare;
    }

    public WebElement hospiceWork() {
        return hospiceWork;
    }

    public WebElement forHandicapped() {
        return forHandicapped;
    }

    public WebElement doctorVisit() {
        return doctorVisit;
    }

    public WebElement specialDoctorVisit() {
        return specialDoctorVisit;
    }

    public WebElement hollydayCare() {
        return hollydayCare;
    }

    //Leistungen - Räumlichkeiten
    @FindBy(xpath = "//section[@class='DepartmentRoomServices']//input[@id='tmp.realEstate.roomTypes.SINGLE']")
    WebElement singleBed;
    @FindBy(xpath = "//section[@class='DepartmentRoomServices']//input[@id='tmp.realEstate.roomTypes.DOUBLE']")
    WebElement doubleBed;
    @FindBy(xpath = "//section[@class='DepartmentRoomServices']//input[@id='tmp.realEstate.bathRoomTypes.SINGLE']")
    WebElement singleToilet;
    @FindBy(xpath = "//section[@class='DepartmentRoomServices']//input[@id='tmp.realEstate.bathRoomTypes.DOUBLE']")
    WebElement doubleToilet;

    //GETTER Leistungen - Räumlichkeiten
    public WebElement singleBed() {
        return singleBed;
    }

    public WebElement doubleBed() {
        return doubleBed;
    }

    public WebElement singleToilet() {
        return singleToilet;
    }

    public WebElement doubleToilet() {
        return doubleToilet;
    }

    //Siegel
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.certificateCategories.5d12030e9a3dec00013e10d8']")
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
