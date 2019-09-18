import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FairHouseOfferPage;

import java.io.IOException;

public class CreateFairHouseOffer extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void createOrganisation() throws IOException {
        login();

        //because we have to move explicit to our select fields
        Actions actions = new Actions(driver);

        loadProps();
        loadPropsForDepartment();
        loadPropsForFairHouseOfferDepartment();
        FairHouseOfferPage fairHouseOfferPage = new FairHouseOfferPage(driver);

        try {
            fairHouseOfferPage.addDepartment().click();
            fairHouseOfferPage.addFairHouseOfferDepartment().click();
        } catch (Exception e) {
            System.out.println("Es wurde noch kein Department angelegt.");
        }

        try {
            fairHouseOfferPage.addFirstFairHouseOfferDepartment().click();
        } catch (Exception e) {
            System.out.println("Es existiert schon ein erstes Department");
        }

        fairHouseOfferPage.accessibilityApartment().click();
        fairHouseOfferPage.accessibilityApartmentArea().click();
        fairHouseOfferPage.accessibility().click();
        fairHouseOfferPage.conformation().click();
        try {
            //Submit Button hat Fehler
            fairHouseOfferPage.submitButton().click();
            fairHouseOfferPage.submitButton().click();
            fairHouseOfferPage.submitButton().click();
        } catch (Exception e) {
            System.out.println("Submit Button in modal doesnt work!");
        }

        //allgemeine Angaben
        fairHouseOfferPage.fairHouseOfferDepartmentName().sendKeys(propDepartment.getProperty("fairHouseOfferDepartmentName"));
        fairHouseOfferPage.fairHouseOfferDepartmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
        fairHouseOfferPage.fairHouseOfferDepartmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
        fairHouseOfferPage.fairHouseOfferDepartmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
        fairHouseOfferPage.fairHouseOfferDepartmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
        fairHouseOfferPage.fairHouseOfferDepartmentWebsite().sendKeys(propDepartment.getProperty("website"));

        //angaben zur Person
        fairHouseOfferPage.fairHouseOfferDepartmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
        fairHouseOfferPage.fairHouseOfferDepartmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
        fairHouseOfferPage.fairHouseOfferDepartmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
        fairHouseOfferPage.fairHouseOfferDepartmentContactEmail().sendKeys(propDepartment.getProperty("contactEmail"));
        fairHouseOfferPage.fairHouseOfferDepartmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));

        WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
        actions.moveToElement(contactSalutation).click().build().perform();
        fairHouseOfferPage.fairHouseOfferDepartmentContactSalutationChosen().click();

        //sprechzeiten
        fairHouseOfferPage.mondayHourBegin().sendKeys(propDepartment.getProperty("mondayHourBegin"));
        fairHouseOfferPage.mondayMinuteBegin().sendKeys(propDepartment.getProperty("mondayMinuteBegin"));
        fairHouseOfferPage.mondayHourEnd().sendKeys(propDepartment.getProperty("mondayHourEnd"));
        fairHouseOfferPage.mondayMinuteEnd().sendKeys(propDepartment.getProperty("mondayMinuteEnd"));

        fairHouseOfferPage.wednesdayHourBegin().sendKeys(propDepartment.getProperty("wednesdayHourBegin"));
        fairHouseOfferPage.wednesdayMinuteBegin().sendKeys(propDepartment.getProperty("wednesdayMinuteBegin"));
        fairHouseOfferPage.wednesdayHourEnd().sendKeys(propDepartment.getProperty("wednesdayHourEnd"));
        fairHouseOfferPage.wednesdayMinuteEnd().sendKeys(propDepartment.getProperty("wednesdayMinuteEnd"));

        fairHouseOfferPage.fridayHourBegin().sendKeys(propDepartment.getProperty("fridayHourBegin"));
        fairHouseOfferPage.fridayMinuteBegin().sendKeys(propDepartment.getProperty("fridayMinuteBegin"));
        fairHouseOfferPage.fridayHourEnd().sendKeys(propDepartment.getProperty("fridayHourEnd"));
        fairHouseOfferPage.fridayMinuteEnd().sendKeys(propDepartment.getProperty("fridayMinuteEnd"));

        //Allgemeine Beschreibung des Wohnprojekts
        fairHouseOfferPage.descriptionOfApartment().sendKeys(propFairHouseOffer.getProperty("descriptionOfApartment"));

        WebElement apartmentType = driver.findElement(By.id("residentialProperty.type"));
        actions.moveToElement(apartmentType).click().build().perform();
        fairHouseOfferPage.apartmentTypeChosen().click();

        WebElement apartmentProperty = driver.findElement(By.id("residentialProperty.condominiumType"));
        actions.moveToElement(apartmentProperty).click().build().perform();
        fairHouseOfferPage.apartmentPropertyChosen().click();

        fairHouseOfferPage.provider().sendKeys(propFairHouseOffer.getProperty("provider"));

        WebElement providerType = driver.findElement(By.id("residentialProperty.provider.type"));
        actions.moveToElement(providerType).click().build().perform();
        fairHouseOfferPage.providerTypeChosen().click();

        fairHouseOfferPage.operator().sendKeys(propFairHouseOffer.getProperty("operator"));
        fairHouseOfferPage.operatorDescription().sendKeys(propFairHouseOffer.getProperty("operatorDescription"));
        fairHouseOfferPage.rental().sendKeys(propFairHouseOffer.getProperty("rental"));
        fairHouseOfferPage.otherCosts().sendKeys(propFairHouseOffer.getProperty("otherCosts"));
        fairHouseOfferPage.apartmentPrice().sendKeys(propFairHouseOffer.getProperty("apartmentPrice"));
        fairHouseOfferPage.commonCharge().sendKeys(propFairHouseOffer.getProperty("commonCharge"));
        fairHouseOfferPage.additionalPurchasePrice().sendKeys(propFairHouseOffer.getProperty("additionalPurchasePrice"));
        fairHouseOfferPage.commission().sendKeys(propFairHouseOffer.getProperty("commission"));
        fairHouseOfferPage.available().sendKeys(propFairHouseOffer.getProperty("available"));

        WebElement floor = driver.findElement(By.id("residentialProperty.floor"));
        actions.moveToElement(floor).click().build().perform();
        fairHouseOfferPage.floorChosen().click();

        fairHouseOfferPage.numberOfRooms().sendKeys(propFairHouseOffer.getProperty("numberOfRooms"));
        fairHouseOfferPage.livingSpace().sendKeys(propFairHouseOffer.getProperty("livingSpace"));

        WebElement energyCertificate = driver.findElement(By.id("residentialProperty.energyCertificate"));
        actions.moveToElement(energyCertificate).click().build().perform();
        fairHouseOfferPage.energyCertificateChosen().click();

        fairHouseOfferPage.energyDemand().sendKeys(propFairHouseOffer.getProperty("energyDemand"));

        //Beschreibungen örtliche Gegebenheiten
        fairHouseOfferPage.yearOfConstruction().sendKeys(propFairHouseOffer.getProperty("yearOfConstruction"));
        fairHouseOfferPage.yearOfLastRefurbishment().sendKeys(propFairHouseOffer.getProperty("yearOfLastRefurbishment"));
        fairHouseOfferPage.numberOfCommonRooms().sendKeys(propFairHouseOffer.getProperty("numberOfCommonRooms"));

        //Youtube
        fairHouseOfferPage.youTubeVideo().sendKeys(propDepartment.getProperty("youTubeVideo"));

        //save
        fairHouseOfferPage.saveDepartment().click();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
