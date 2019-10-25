package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.FairHouseOfferPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateFairHouseOffer extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void createFairHouseOrganisation() throws IOException, InterruptedException {
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            loginLoop(i);

            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);

            loadPropsForDepartment();
            loadPropsForFairHouseOfferDepartment();
            FairHouseOfferPage fairHouseOfferPage = new FairHouseOfferPage(driver);

            try {
                fairHouseOfferPage.addDepartment().click();
                TimeUnit.SECONDS.sleep(1);
                fairHouseOfferPage.addFairHouseOfferDepartment().click();
                TimeUnit.SECONDS.sleep(1);
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
            TimeUnit.SECONDS.sleep(4);
            try {
                //Submit Button hat Fehler
                fairHouseOfferPage.submitButton().click();
                fairHouseOfferPage.submitButton().click();
                fairHouseOfferPage.submitButton().click();
            } catch (Exception e) {
                System.out.println("Submit Button in modal doesnt work!");
            }

            //allgemeine Angaben
            TimeUnit.SECONDS.sleep(4);

            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

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

            WebElement apartmentType = driver.findElement(By.xpath("//label[contains(text(),'Wohnungstyp')]"));
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

            TimeUnit.SECONDS.sleep(6);
            logout();
            TimeUnit.SECONDS.sleep(4);

        }
    }

    @AfterTest
    public void closeBrowser() {

    }
}
