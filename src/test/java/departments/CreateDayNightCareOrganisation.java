package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.DayNightCareOrganisationPage;
import resources.MulLogin;

import java.io.IOException;

public class CreateDayNightCareOrganisation extends MulLogin {

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
        DayNightCareOrganisationPage dayNightCareOrganisationPage = new DayNightCareOrganisationPage(driver);

        try {
            dayNightCareOrganisationPage.addDepartment().click();
            dayNightCareOrganisationPage.addDayNightCareDepartment().click();
        } catch (Exception e) {
            System.out.println("Es wurde noch kein Department angelegt.");
        }

        try {
            dayNightCareOrganisationPage.addFirstDayNightCareDepartment().click();
        } catch (Exception e) {
            System.out.println("Es existiert schon ein erstes Department");
        }

        //allgemeine Angaben
        dayNightCareOrganisationPage.dayNightCareDepartmentName().sendKeys(propDepartment.getProperty("dayNightCareDepartmentName"));
        dayNightCareOrganisationPage.dayNightCareDepartmentOrganisationType().click();
        dayNightCareOrganisationPage.dayNightCareDepartmentOrganisationTypeChosen().click();
        dayNightCareOrganisationPage.dayNightCareDepartmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
        dayNightCareOrganisationPage.dayNightCareDepartmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
        dayNightCareOrganisationPage.dayNightCareDepartmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
        dayNightCareOrganisationPage.dayNightCareDepartmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
        dayNightCareOrganisationPage.dayNightCareDepartmentWebsite().sendKeys(propDepartment.getProperty("website"));

        //angaben zur Person
        dayNightCareOrganisationPage.dayNightCareDepartmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
        dayNightCareOrganisationPage.dayNightCareDepartmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
        dayNightCareOrganisationPage.dayNightCareDepartmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
        dayNightCareOrganisationPage.dayNightCareDepartmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));

        WebElement availability = driver.findElement(By.id("availability"));
        actions.moveToElement(availability).click().build().perform();
        dayNightCareOrganisationPage.dayNightCareDepartmentAvailableChosen().click();

        WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
        actions.moveToElement(contactSalutation).click().build().perform();
        dayNightCareOrganisationPage.dayNightCareDepartmentContactSalutationChosen().click();

        //sprechzeiten
        dayNightCareOrganisationPage.mondayHourBegin().sendKeys(propDepartment.getProperty("mondayHourBegin"));
        dayNightCareOrganisationPage.mondayMinuteBegin().sendKeys(propDepartment.getProperty("mondayMinuteBegin"));
        dayNightCareOrganisationPage.mondayHourEnd().sendKeys(propDepartment.getProperty("mondayHourEnd"));
        dayNightCareOrganisationPage.mondayMinuteEnd().sendKeys(propDepartment.getProperty("mondayMinuteEnd"));

        dayNightCareOrganisationPage.wednesdayHourBegin().sendKeys(propDepartment.getProperty("wednesdayHourBegin"));
        dayNightCareOrganisationPage.wednesdayMinuteBegin().sendKeys(propDepartment.getProperty("wednesdayMinuteBegin"));
        dayNightCareOrganisationPage.wednesdayHourEnd().sendKeys(propDepartment.getProperty("wednesdayHourEnd"));
        dayNightCareOrganisationPage.wednesdayMinuteEnd().sendKeys(propDepartment.getProperty("wednesdayMinuteEnd"));

        dayNightCareOrganisationPage.fridayHourBegin().sendKeys(propDepartment.getProperty("fridayHourBegin"));
        dayNightCareOrganisationPage.fridayMinuteBegin().sendKeys(propDepartment.getProperty("fridayMinuteBegin"));
        dayNightCareOrganisationPage.fridayHourEnd().sendKeys(propDepartment.getProperty("fridayHourEnd"));
        dayNightCareOrganisationPage.fridayMinuteEnd().sendKeys(propDepartment.getProperty("fridayMinuteEnd"));

        //Beschreibung
        dayNightCareOrganisationPage.presentationOfDepartment().sendKeys(propDepartment.getProperty("presentationOfDepartment"));
        dayNightCareOrganisationPage.particularityZero().sendKeys(propDepartment.getProperty("particularityZero"));
        dayNightCareOrganisationPage.particularityOne().sendKeys(propDepartment.getProperty("particularityOne"));
        dayNightCareOrganisationPage.particularityTwo().sendKeys(propDepartment.getProperty("particularityTwo"));

        //youtube
        dayNightCareOrganisationPage.youTubeVideo().sendKeys(propDepartment.getProperty("youTubeVideo"));

        //speichern
        dayNightCareOrganisationPage.saveDepartment().click();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
