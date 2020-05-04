package pageObjects.departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentPage {
    WebDriver driver;

    public DepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //MODAL FAIRHOUSE OFFER
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

    //GETTER MODAL FAIRHOUSE OFFER
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

    @FindBy(xpath = "//h3[@id='department-heading']//button")
    WebElement addDepartment;
    @FindBy(xpath = "//div[@id='app-view-container']//li[1]//a[1]")
    WebElement dashboardCard;
    @FindBy(xpath = "//div[@id='app-view-container']//li[2]//a[1]")
    WebElement addDepartmentCard;
    @FindBy(xpath = "//div[@id='app-view-container']//li[3]//a[1]")
    WebElement addContactPersonCard;

    @FindBy(xpath = "//div[@class='tab-pane active']//div[@class='AMBULANT card']//div[2]//a[@class='create']")
    WebElement addFirstAmbulantDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='AMBULANT card']//a[@class='create']")
    WebElement addAmbulantDepartment;
    @FindBy(xpath = "//div[@class='tab-pane active']//div[@class='STATIONARY card']//div[2]//a[@class='create']")
    WebElement addFirstStationaryDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='STATIONARY card']//a[@class='create']")
    WebElement addStationaryDepartment;
    @FindBy(xpath = "//div[@class='tab-pane active']//div[@class='HOUSING card']//div[2]//a[@class='create']")
    WebElement addFirstFairHouseOfferDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='HOUSING card']//a[@class='create']")
    WebElement addFairHouseOfferDepartment;
    @FindBy(xpath = "//div[@class='tab-pane active']//div[@class='DAYCARE card']//div[2]//a[@class='create']")
    WebElement addFirstDayNightCareDepartment;
    @FindBy(xpath = "//section[@class='DepartmentCreateTiles']//div[@class='DAYCARE card']//a[@class='create']")
    WebElement addDayNightCareDepartment;


    public WebElement addDepartment() {
        return addDepartment;
    }

    public WebElement dashboardCard() {
        return dashboardCard;
    }

    public WebElement addDepartmentCard() {
        return addDepartmentCard;
    }

    public WebElement addContactPersonCard() {
        return addContactPersonCard;
    }

    public WebElement addAmbulantDepartment() {
        return addAmbulantDepartment;
    }

    public WebElement addFirstAmbulantDepartment() {
        return addFirstAmbulantDepartment;
    }

    public WebElement addStationaryDepartment() {
        return addStationaryDepartment;
    }

    public WebElement addFirstStationaryDepartment() {
        return addFirstStationaryDepartment;
    }


    public WebElement addFairHouseOfferDepartment() {
        return addFairHouseOfferDepartment;
    }

    public WebElement addFirstFairHouseOfferDepartment() {
        return addFirstFairHouseOfferDepartment;
    }

    public WebElement addDayNightCareDepartment() {
        return addDayNightCareDepartment;
    }

    public WebElement addFirstDayNightCareDepartment() {
        return addFirstDayNightCareDepartment;
    }

    //allgemeine Angaben zur Einrichtung
    @FindBy(id = "name")
    WebElement departmentName;
    @FindBy(xpath = "//option[. = 'Privat']")
    WebElement departmentOrganisationTypeChosen;
    @FindBy(id = "confession")
    WebElement departmentConfession;
    @FindBy(xpath = "//section[@class='Input  select     empty']//label[@class='Checkbox ']")
    WebElement departmentAccept;
    @FindBy(id = "address.streetAddress")
    WebElement departmentStreetAddress;
    @FindBy(id = "address.streetNumber")
    WebElement departmentStreetNumber;
    @FindBy(id = "address.postalCode")
    WebElement departmentPostalCode;
    @FindBy(id = "address.city")
    WebElement departmentAddressCity;
    @FindBy(id = "website")
    WebElement departmentWebsite;
    @FindBy(id = "#availability")
    WebElement departmentAvailable;
    @FindBy(xpath = "//option[. = 'Auf Anfrage']")
    WebElement departmentAvailableChosen;

    //GETTER allgemeine Angaben zur Einrichtung
    public WebElement departmentName() {
        return departmentName;
    }

    public WebElement departmentOrganisationTypeChosen() {
        return departmentOrganisationTypeChosen;
    }

    public WebElement departmentConfession() {
        return departmentConfession;
    }

    public WebElement departmentAccept() {
        return departmentAccept;
    }

    public WebElement departmentStreetAddress() {
        return departmentStreetAddress;
    }

    public WebElement departmentStreetNumber() {
        return departmentStreetNumber;
    }

    public WebElement departmentPostalCode() {
        return departmentPostalCode;
    }

    public WebElement departmentAddressCity() {
        return departmentAddressCity;
    }

    public WebElement departmentWebsite() {
        return departmentWebsite;
    }

    public WebElement departmentAvailable() {
        return departmentAvailable;
    }

    public WebElement departmentAvailableChosen() {
        return departmentAvailableChosen;
    }

    //ansprechpartner
    @FindBy(xpath = "//option[. = 'ohne Anrede']")
    WebElement departmentContactSalutationChosen;
    @FindBy(id = "contact.firstName")
    WebElement departmentContactFirstName;
    @FindBy(id = "contact.lastName")
    WebElement departmentContactLastName;
    @FindBy(id = "contact.title")
    WebElement departmentContactTitle;
    @FindBy(id = "contact.phone")
    WebElement departmentContactPhone;

    //GETTER ansprechpartner
    public WebElement departmentContactSalutationChosen() {
        return departmentContactSalutationChosen;
    }

    public WebElement departmentContactFirstName() {
        return departmentContactFirstName;
    }

    public WebElement departmentContactLastName() {
        return departmentContactLastName;
    }

    public WebElement departmentContactTitle() {
        return departmentContactTitle;
    }

    public WebElement departmentContactPhone() {
        return departmentContactPhone;
    }

    //sprechzeiten Montag
    @FindBy(xpath = "//input[@id='tmp.consultationHours.0.0.startHour']")
    WebElement mondayHourBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.0.0.startMinute']")
    WebElement mondayMinuteBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.0.0.endHour']")
    WebElement mondayHourEnd;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.0.0.endMinute']")
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
    @FindBy(xpath = "//input[@id='tmp.consultationHours.1.0.startHour']")
    WebElement tuesdayHourBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.1.0.startMinute']")
    WebElement tuesdayMinuteBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.1.0.endHour']")
    WebElement tuesdayHourEnd;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.1.0.endMinute']")
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
    @FindBy(xpath = "//input[@id='tmp.consultationHours.2.0.startHour']")
    WebElement wednesdayHourBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.2.0.startMinute']")
    WebElement wednesdayMinuteBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.2.0.endHour']")
    WebElement wednesdayHourEnd;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.2.0.endMinute']")
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
    @FindBy(xpath = "//input[@id='tmp.consultationHours.3.0.startHour']")
    WebElement thursdayHourBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.3.0.startMinute']")
    WebElement thursdayMinuteBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.3.0.endHour']")
    WebElement thursdayHourEnd;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.3.0.endMinute']")
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
    @FindBy(xpath = "//input[@id='tmp.consultationHours.4.0.startHour']")
    WebElement fridayHourBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.4.0.startMinute']")
    WebElement fridayMinuteBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.4.0.endHour']")
    WebElement fridayHourEnd;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.4.0.endMinute']")
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
    @FindBy(xpath = "//input[@id='tmp.consultationHours.5.0.startHour']")
    WebElement saturdayHourBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.5.0.startMinute']")
    WebElement saturdayMinuteBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.5.0.endHour']")
    WebElement saturdayHourEnd;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.5.0.endMinute']")
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
    @FindBy(xpath = "//input[@id='tmp.consultationHours.6.0.startHour']")
    WebElement sundayHourBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.6.0.startMinute']")
    WebElement sundayMinuteBegin;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.6.0.endHour']")
    WebElement sundayHourEnd;
    @FindBy(xpath = "//input[@id='tmp.consultationHours.6.0.endMinute']")
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
    @FindBy(xpath = "//section[@class='Input  text     empty']//input[@id='tmp.operatedZipCodes']")
    WebElement servedAreas;
    @FindBy(xpath = "//section[@class='Input  select     empty']//select[@id='staffRange']")
    WebElement staffRange;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.yearOfConstruction']")
    WebElement constructionYear;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.yearOfLastRefurbishment']")
    WebElement refurbishmentYear;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.numberOfCommonRooms']")
    WebElement numberOfCommonRooms;

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

    public WebElement servedAreas() {
        return servedAreas;
    }

    public WebElement staffRange() {
        return staffRange;
    }

    public WebElement constructionYear() {
        return constructionYear;
    }

    public WebElement refurbishmentYear() {
        return refurbishmentYear;
    }

    public WebElement numberOfCommonRooms() {
        return numberOfCommonRooms;
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
    @FindBy(xpath = "//section[@class='DepartmentRealEstate']//label[@class='Checkbox ']")
    WebElement elevatorCheckbox;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.roomSizeMin']")
    WebElement roomSizeMin;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.roomSizeMax']")
    WebElement roomSizeMax;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.numberOfBeds']")
    WebElement numberOfBeds;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.numberOfRelaxationRooms']")
    WebElement numberOfRelaxationRooms;
    @FindBy(xpath = "//section[@class='Input  number     empty']//input[@id='realEstate.numberOfFloors']")
    WebElement numberOfFloors;

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

    public WebElement elevatorCheckbox() {
        return elevatorCheckbox;
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

    public WebElement numberOfRelaxationRooms() {
        return numberOfRelaxationRooms;
    }

    public WebElement numberOfFloors() {
        return numberOfFloors;
    }

    //umgebungsinfos
    @FindBy(xpath = "//textarea[@id='realEstate.environmentInfo']")
    WebElement environmentInfo;

    public WebElement environmentInfo() {
        return environmentInfo;
    }

    //preise
    @FindBy(xpath = "//section[@id='DepartmentResidentialProperty']/label[1]")
    WebElement toRent;

    @FindBy(xpath = "//span[contains(text(),'Zum Kauf')]")
    WebElement toBuy;
    //OPTIONen die dann angezeigt werden
    @FindBy(xpath = "//input[@id='residentialProperty.minPurchasePrice']")
    WebElement price;
    @FindBy(xpath = "//input[@id='residentialProperty.commonCharge']")
    WebElement houseMoney;
    @FindBy(xpath = "//input[@id='residentialProperty.additionalPurchasePrice']")
    WebElement additionalCosts;
    @FindBy(xpath = "//input[@id='residentialProperty.commission']")
    WebElement provision;

    public WebElement toRent() {
        return toRent;
    }

    public WebElement toBuy() {
        return toBuy;
    }

    //optionen die dann angezeigt werden
    public WebElement price() {
        return price;
    }

    public WebElement houseMoney() {
        return houseMoney;
    }

    public WebElement additionalCosts() {
        return additionalCosts;
    }

    public WebElement provision() {
        return provision;
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

    //FAIRHOUSE OFFER Allgemeine Beschreibung des Wohnprojekts
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
    @FindBy(xpath = "//select[@id='residentialProperty.type']")
    WebElement rental;
    @FindBy(id = "residentialProperty.ancillaryCosts")
    WebElement otherCosts;
    @FindBy(id = "//section[@class='DepartmentDescription']//span[contains(text(),'Nebenkosten in Miete enthalten')]")
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
    @FindBy(id = "//section[@class='DepartmentDescription']//span[contains(text(),'Wohnberechtigungsschein')]")
    WebElement subsidizedHousingCheckbox;
    @FindBy(xpath = "//option[. = 'Bedarfsausweis']")
    WebElement energyCertificateChosen;
    @FindBy(id = "residentialProperty.energyDemand")
    WebElement energyDemand;

    //FAIRHOUSE OFFER GETTER Allgemeine Beschreibung des Wohnprojekts
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

    //FAIRHOUSE OFFER
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


    //Sonstige Ausstattungen
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107a']")
    WebElement testLiving;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107b']")
    WebElement guestLiving;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e107c']")
    WebElement ownFurniture;
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
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1090']")
    WebElement forHandicapped;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1091']")
    WebElement doctorVisit;
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.facilityCategories.5d109c239a3dec00013e1092']")
    WebElement specialDoctorVisit;


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

    public WebElement forHandicapped() {
        return forHandicapped;
    }

    public WebElement doctorVisit() {
        return doctorVisit;
    }

    public WebElement specialDoctorVisit() {
        return specialDoctorVisit;
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
    @FindBy(xpath = "//section[@class='DepartmentCategories']//input[@id='tmp.certificateCategories.5d10da2b9a3dec00013e10b6']")
    WebElement certificat;

    //GETTER Siegel
    public WebElement certificat() {
        return certificat;
    }

    //youtube video
    @FindBy(xpath = "//input[@id='youtubeURL']")
    WebElement youTubeVideo;

    //GETTER youtube video
    public WebElement youTubeVideo() {
        return youTubeVideo;
    }

    // Einrichtung speichern
    @FindBy(xpath = "//button[@id='publish-department']")
    WebElement saveDepartment;

    //GETTER ambulante Einrichtung speichern
    public WebElement saveDepartment() {
        return saveDepartment;
    }

    //image upload
    @FindBy(xpath = "//section[@id='DepartmentGeneralData']//input[@class='fileInput']")
    WebElement uploadDepartmentCompanyImage;
    @FindBy(xpath = "//div[@class='image-tile-row-inner']//input[@class='fileInput']")
    WebElement uploadDepartmentImage;
    @FindBy(xpath = "//div[@class='no-icon image-gallery-cta']//input[@class='fileInput']")
    WebElement contactPhoto;
    @FindBy(xpath = "//section[@id='DepartmentDocumentUpload']//input[@class='fileInput']")
    WebElement infoMaterial;
    @FindBy(xpath = "//section[@id='DepartmentMdkReport']//input[@class='fileInput']")
    WebElement mdkReport;

    public WebElement uploadDepartmentCompanyImage() {
        return uploadDepartmentCompanyImage;
    }

    public WebElement uploadDepartmentImage() {
        return uploadDepartmentImage;
    }

    public WebElement contactPhoto() {
        return contactPhoto;
    }

    public WebElement infoMaterial() {
        return infoMaterial;
    }

    public WebElement mdkReport() {
        return mdkReport;
    }



}
