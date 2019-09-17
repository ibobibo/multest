import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.StationaryOrganisationPage;

import java.io.IOException;

public class CreateStationaryOrganisation extends MulLogin {

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
        stationaryOrganisationPage.stationaryDepartmentName().sendKeys(propDepartment.getProperty("stationaryDepartmentName"));
        stationaryOrganisationPage.stationaryDepartmentOrganisationType().click();

        stationaryOrganisationPage.stationaryDepartmentOrganisationTypeChosen().click();
        stationaryOrganisationPage.stationaryDepartmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
        stationaryOrganisationPage.stationaryDepartmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
        stationaryOrganisationPage.stationaryDepartmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
        stationaryOrganisationPage.stationaryDepartmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
        stationaryOrganisationPage.stationaryDepartmentWebsite().sendKeys(propDepartment.getProperty("website"));

        //angaben zur Person
        stationaryOrganisationPage.stationaryDepartmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
        stationaryOrganisationPage.stationaryDepartmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
        stationaryOrganisationPage.stationaryDepartmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
        stationaryOrganisationPage.stationaryDepartmentContactEmail().sendKeys(propDepartment.getProperty("contactEmail"));
        stationaryOrganisationPage.stationaryDepartmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));

        WebElement availability = driver.findElement(By.id("availability"));
        actions.moveToElement(availability).click().build().perform();
        stationaryOrganisationPage.stationaryDepartmentAvailableChosen().click();

        WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
        actions.moveToElement(contactSalutation).click().build().perform();
        stationaryOrganisationPage.stationaryDepartmentContactSalutationChosen().click();

        //sprechzeiten
        stationaryOrganisationPage.mondayHourBegin().sendKeys(propDepartment.getProperty("mondayHourBegin"));
        stationaryOrganisationPage.mondayMinuteBegin().sendKeys(propDepartment.getProperty("mondayMinuteBegin"));
        stationaryOrganisationPage.mondayHourEnd().sendKeys(propDepartment.getProperty("mondayHourEnd"));
        stationaryOrganisationPage.mondayMinuteEnd().sendKeys(propDepartment.getProperty("mondayMinuteEnd"));

        stationaryOrganisationPage.wednesdayHourBegin().sendKeys(propDepartment.getProperty("wednesdayHourBegin"));
        stationaryOrganisationPage.wednesdayMinuteBegin().sendKeys(propDepartment.getProperty("wednesdayMinuteBegin"));
        stationaryOrganisationPage.wednesdayHourEnd().sendKeys(propDepartment.getProperty("wednesdayHourEnd"));
        stationaryOrganisationPage.wednesdayMinuteEnd().sendKeys(propDepartment.getProperty("wednesdayMinuteEnd"));

        stationaryOrganisationPage.fridayHourBegin().sendKeys(propDepartment.getProperty("fridayHourBegin"));
        stationaryOrganisationPage.fridayMinuteBegin().sendKeys(propDepartment.getProperty("fridayMinuteBegin"));
        stationaryOrganisationPage.fridayHourEnd().sendKeys(propDepartment.getProperty("fridayHourEnd"));
        stationaryOrganisationPage.fridayMinuteEnd().sendKeys(propDepartment.getProperty("fridayMinuteEnd"));

        //Beschreibung
        stationaryOrganisationPage.presentationOfDepartment().sendKeys(propDepartment.getProperty("presentationOfDepartment"));
        stationaryOrganisationPage.particularityZero().sendKeys(propDepartment.getProperty("particularityZero"));
        stationaryOrganisationPage.particularityOne().sendKeys(propDepartment.getProperty("particularityOne"));
        stationaryOrganisationPage.particularityTwo().sendKeys(propDepartment.getProperty("particularityTwo"));

        //Youtube
        stationaryOrganisationPage.youTubeVideo().sendKeys(propDepartment.getProperty("youTubeVideo"));

        //speichern
        stationaryOrganisationPage.saveDepartment().click();

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
