import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.StationaryOrganisationPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateStationaryOrganisation extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void createOrganisation() throws IOException {
        login();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //because we have to move explicit to our select fields
        Actions actions = new Actions(driver);

        loadProps();
        loadPropsForAmbulantDepartment();
        StationaryOrganisationPage stationaryOrganisationPage = new StationaryOrganisationPage(driver);

        try {
            stationaryOrganisationPage.addDepartment().click();
            stationaryOrganisationPage.addStationaryDepartment().click();
        } catch (Exception e) {
            System.out.println("Es wurde noch kein Department angelegt.");
        }

        try {
            stationaryOrganisationPage.addFirstStationaryDepartment().click();
        } catch (Exception e) {
            System.out.println("Es existiert schon ein erstes Department");
        }

        //Allgemeine Angaben
        stationaryOrganisationPage.stationaryDepartmentName().sendKeys(propAmbulant.getProperty("ambulantDepartmentName"));
        stationaryOrganisationPage.stationaryDepartmentOrganisationType().click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        stationaryOrganisationPage.stationaryDepartmentOrganisationTypeChosen().click();
        stationaryOrganisationPage.stationaryDepartmentStreetAddress().sendKeys(propAmbulant.getProperty("ambulantDepartmentStreetAddress"));
        stationaryOrganisationPage.stationaryDepartmentStreetNumber().sendKeys(propAmbulant.getProperty("ambulantDepartmentStreetNumber"));
        stationaryOrganisationPage.stationaryDepartmentPostalCode().sendKeys(propAmbulant.getProperty("ambulantDepartmentPostalCode"));
        stationaryOrganisationPage.stationaryDepartmentAddressCity().sendKeys(propAmbulant.getProperty("ambulantDepartmentAddressCity"));
        stationaryOrganisationPage.stationaryDepartmentWebsite().sendKeys(propAmbulant.getProperty("ambulantDepartmentWebsite"));

        //angaben zur Person
        stationaryOrganisationPage.stationaryDepartmentContactFirstName().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactFirstName"));
        stationaryOrganisationPage.stationaryDepartmentContactLastName().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactLastName"));
        stationaryOrganisationPage.stationaryDepartmentContactTitle().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactTitle"));
        stationaryOrganisationPage.stationaryDepartmentContactEmail().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactEmail"));
        stationaryOrganisationPage.stationaryDepartmentContactPhone().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactPhone"));

        WebElement availability = driver.findElement(By.id("availability"));
        actions.moveToElement(availability).click().build().perform();
        stationaryOrganisationPage.stationaryDepartmentAvailableChosen().click();

        WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
        actions.moveToElement(contactSalutation).click().build().perform();
        stationaryOrganisationPage.stationaryDepartmentContactSalutationChosen().click();

        //sprechzeiten
        stationaryOrganisationPage.mondayHourBegin().sendKeys(propAmbulant.getProperty("mondayHourBegin"));
        stationaryOrganisationPage.mondayMinuteBegin().sendKeys(propAmbulant.getProperty("mondayMinuteBegin"));
        stationaryOrganisationPage.mondayHourEnd().sendKeys(propAmbulant.getProperty("mondayHourEnd"));
        stationaryOrganisationPage.mondayMinuteEnd().sendKeys(propAmbulant.getProperty("mondayMinuteEnd"));

        stationaryOrganisationPage.wednesdayHourBegin().sendKeys(propAmbulant.getProperty("wednesdayHourBegin"));
        stationaryOrganisationPage.wednesdayMinuteBegin().sendKeys(propAmbulant.getProperty("wednesdayMinuteBegin"));
        stationaryOrganisationPage.wednesdayHourEnd().sendKeys(propAmbulant.getProperty("wednesdayHourEnd"));
        stationaryOrganisationPage.wednesdayMinuteEnd().sendKeys(propAmbulant.getProperty("wednesdayMinuteEnd"));

        stationaryOrganisationPage.fridayHourBegin().sendKeys(propAmbulant.getProperty("fridayHourBegin"));
        stationaryOrganisationPage.fridayMinuteBegin().sendKeys(propAmbulant.getProperty("fridayMinuteBegin"));
        stationaryOrganisationPage.fridayHourEnd().sendKeys(propAmbulant.getProperty("fridayHourEnd"));
        stationaryOrganisationPage.fridayMinuteEnd().sendKeys(propAmbulant.getProperty("fridayMinuteEnd"));

        //Beschreibung
        stationaryOrganisationPage.presentationOfDepartment().sendKeys(propAmbulant.getProperty("presentationOfDepartment"));
        stationaryOrganisationPage.particularityZero().sendKeys(propAmbulant.getProperty("particularityZero"));
        stationaryOrganisationPage.particularityOne().sendKeys(propAmbulant.getProperty("particularityOne"));
        stationaryOrganisationPage.particularityTwo().sendKeys(propAmbulant.getProperty("particularityTwo"));

//            ambulantOrganisationPage.youTubeVideo().sendKeys(propAmbulant.getProperty("youTubeVideo"));
//
//            ambulantOrganisationPage.saveAmbulantDepartment().click();

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
