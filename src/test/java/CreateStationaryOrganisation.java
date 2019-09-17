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
        loadPropsForStationaryDepartment();
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
        stationaryOrganisationPage.stationaryDepartmentName().sendKeys(propStationary.getProperty("stationaryDepartmentName"));
        stationaryOrganisationPage.stationaryDepartmentOrganisationType().click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        stationaryOrganisationPage.stationaryDepartmentOrganisationTypeChosen().click();
        stationaryOrganisationPage.stationaryDepartmentStreetAddress().sendKeys(propStationary.getProperty("stationaryDepartmentStreetAddress"));
        stationaryOrganisationPage.stationaryDepartmentStreetNumber().sendKeys(propStationary.getProperty("stationaryDepartmentStreetNumber"));
        stationaryOrganisationPage.stationaryDepartmentPostalCode().sendKeys(propStationary.getProperty("stationaryDepartmentPostalCode"));
        stationaryOrganisationPage.stationaryDepartmentAddressCity().sendKeys(propStationary.getProperty("stationaryDepartmentAddressCity"));
        stationaryOrganisationPage.stationaryDepartmentWebsite().sendKeys(propStationary.getProperty("stationaryDepartmentWebsite"));

        //angaben zur Person
        stationaryOrganisationPage.stationaryDepartmentContactFirstName().sendKeys(propStationary.getProperty("stationaryDepartmentContactFirstName"));
        stationaryOrganisationPage.stationaryDepartmentContactLastName().sendKeys(propStationary.getProperty("stationaryDepartmentContactLastName"));
        stationaryOrganisationPage.stationaryDepartmentContactTitle().sendKeys(propStationary.getProperty("stationaryDepartmentContactTitle"));
        stationaryOrganisationPage.stationaryDepartmentContactEmail().sendKeys(propStationary.getProperty("stationaryDepartmentContactEmail"));
        stationaryOrganisationPage.stationaryDepartmentContactPhone().sendKeys(propStationary.getProperty("stationaryDepartmentContactPhone"));

        WebElement availability = driver.findElement(By.id("availability"));
        actions.moveToElement(availability).click().build().perform();
        stationaryOrganisationPage.stationaryDepartmentAvailableChosen().click();

        WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
        actions.moveToElement(contactSalutation).click().build().perform();
        stationaryOrganisationPage.stationaryDepartmentContactSalutationChosen().click();

        //sprechzeiten
        stationaryOrganisationPage.mondayHourBegin().sendKeys(propStationary.getProperty("mondayHourBegin"));
        stationaryOrganisationPage.mondayMinuteBegin().sendKeys(propStationary.getProperty("mondayMinuteBegin"));
        stationaryOrganisationPage.mondayHourEnd().sendKeys(propStationary.getProperty("mondayHourEnd"));
        stationaryOrganisationPage.mondayMinuteEnd().sendKeys(propStationary.getProperty("mondayMinuteEnd"));

        stationaryOrganisationPage.wednesdayHourBegin().sendKeys(propStationary.getProperty("wednesdayHourBegin"));
        stationaryOrganisationPage.wednesdayMinuteBegin().sendKeys(propStationary.getProperty("wednesdayMinuteBegin"));
        stationaryOrganisationPage.wednesdayHourEnd().sendKeys(propStationary.getProperty("wednesdayHourEnd"));
        stationaryOrganisationPage.wednesdayMinuteEnd().sendKeys(propStationary.getProperty("wednesdayMinuteEnd"));

        stationaryOrganisationPage.fridayHourBegin().sendKeys(propStationary.getProperty("fridayHourBegin"));
        stationaryOrganisationPage.fridayMinuteBegin().sendKeys(propStationary.getProperty("fridayMinuteBegin"));
        stationaryOrganisationPage.fridayHourEnd().sendKeys(propStationary.getProperty("fridayHourEnd"));
        stationaryOrganisationPage.fridayMinuteEnd().sendKeys(propStationary.getProperty("fridayMinuteEnd"));

        //Beschreibung
        stationaryOrganisationPage.presentationOfDepartment().sendKeys(propStationary.getProperty("presentationOfDepartment"));
        stationaryOrganisationPage.particularityZero().sendKeys(propStationary.getProperty("particularityZero"));
        stationaryOrganisationPage.particularityOne().sendKeys(propStationary.getProperty("particularityOne"));
        stationaryOrganisationPage.particularityTwo().sendKeys(propStationary.getProperty("particularityTwo"));

        //Youtube
        stationaryOrganisationPage.youTubeVideo().sendKeys(propStationary.getProperty("youTubeVideo"));

        //speichern
        stationaryOrganisationPage.saveDepartment().click();

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
