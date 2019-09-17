import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FairHouseOfferPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateFairHouseOffer extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void createOrganisation() throws IOException, InterruptedException {
        login();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //because we have to move explicit to our select fields
        Actions actions = new Actions(driver);

        loadProps();
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
        fairHouseOfferPage.fairHouseOfferDepartmentName().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentName"));
        fairHouseOfferPage.fairHouseOfferDepartmentStreetAddress().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentStreetAddress"));
        fairHouseOfferPage.fairHouseOfferDepartmentStreetNumber().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentStreetNumber"));
        fairHouseOfferPage.fairHouseOfferDepartmentPostalCode().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentPostalCode"));
        fairHouseOfferPage.fairHouseOfferDepartmentAddressCity().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentAddressCity"));
        fairHouseOfferPage.fairHouseOfferDepartmentWebsite().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentWebsite"));

        //angaben zur Person
        fairHouseOfferPage.fairHouseOfferDepartmentContactFirstName().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentContactFirstName"));
        fairHouseOfferPage.fairHouseOfferDepartmentContactLastName().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentContactLastName"));
        fairHouseOfferPage.fairHouseOfferDepartmentContactTitle().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentContactTitle"));
        fairHouseOfferPage.fairHouseOfferDepartmentContactEmail().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentContactEmail"));
        fairHouseOfferPage.fairHouseOfferDepartmentContactPhone().sendKeys(propFairHouseOffer.getProperty("fairHouseOfferDepartmentContactPhone"));

        WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
        actions.moveToElement(contactSalutation).click().build().perform();
        fairHouseOfferPage.fairHouseOfferDepartmentContactSalutationChosen().click();

        //sprechzeiten
        fairHouseOfferPage.mondayHourBegin().sendKeys(propFairHouseOffer.getProperty("mondayHourBegin"));
        fairHouseOfferPage.mondayMinuteBegin().sendKeys(propFairHouseOffer.getProperty("mondayMinuteBegin"));
        fairHouseOfferPage.mondayHourEnd().sendKeys(propFairHouseOffer.getProperty("mondayHourEnd"));
        fairHouseOfferPage.mondayMinuteEnd().sendKeys(propFairHouseOffer.getProperty("mondayMinuteEnd"));

        fairHouseOfferPage.wednesdayHourBegin().sendKeys(propFairHouseOffer.getProperty("wednesdayHourBegin"));
        fairHouseOfferPage.wednesdayMinuteBegin().sendKeys(propFairHouseOffer.getProperty("wednesdayMinuteBegin"));
        fairHouseOfferPage.wednesdayHourEnd().sendKeys(propFairHouseOffer.getProperty("wednesdayHourEnd"));
        fairHouseOfferPage.wednesdayMinuteEnd().sendKeys(propFairHouseOffer.getProperty("wednesdayMinuteEnd"));

        fairHouseOfferPage.fridayHourBegin().sendKeys(propFairHouseOffer.getProperty("fridayHourBegin"));
        fairHouseOfferPage.fridayMinuteBegin().sendKeys(propFairHouseOffer.getProperty("fridayMinuteBegin"));
        fairHouseOfferPage.fridayHourEnd().sendKeys(propFairHouseOffer.getProperty("fridayHourEnd"));
        fairHouseOfferPage.fridayMinuteEnd().sendKeys(propFairHouseOffer.getProperty("fridayMinuteEnd"));

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
        fairHouseOfferPage.youTubeVideo().sendKeys(propFairHouseOffer.getProperty("youTubeVideo"));

        //save
        fairHouseOfferPage.saveDepartment().click();

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
