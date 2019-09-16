import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DayNightCareOrganisationPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateDayNightCareOrganisation extends MulLogin {

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
        loadPropsForDayNightCareDepartment();
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
        dayNightCareOrganisationPage.dayNightCareDepartmentName().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentName"));
        dayNightCareOrganisationPage.dayNightCareDepartmentOrganisationType().click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dayNightCareOrganisationPage.dayNightCareDepartmentOrganisationTypeChosen().click();
        dayNightCareOrganisationPage.dayNightCareDepartmentStreetAddress().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentStreetAddress"));
        dayNightCareOrganisationPage.dayNightCareDepartmentStreetNumber().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentStreetNumber"));
        dayNightCareOrganisationPage.dayNightCareDepartmentPostalCode().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentPostalCode"));
        dayNightCareOrganisationPage.dayNightCareDepartmentAddressCity().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentAddressCity"));
        dayNightCareOrganisationPage.dayNightCareDepartmentWebsite().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentWebsite"));

        //angaben zur Person
        dayNightCareOrganisationPage.dayNightCareDepartmentContactFirstName().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentContactFirstName"));
        dayNightCareOrganisationPage.dayNightCareDepartmentContactLastName().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentContactLastName"));
        dayNightCareOrganisationPage.dayNightCareDepartmentContactTitle().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentContactTitle"));
        dayNightCareOrganisationPage.dayNightCareDepartmentContactEmail().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentContactEmail"));
        dayNightCareOrganisationPage.dayNightCareDepartmentContactPhone().sendKeys(propDayNightCare.getProperty("dayNightCareDepartmentContactPhone"));

        WebElement availability = driver.findElement(By.id("availability"));
        actions.moveToElement(availability).click().build().perform();
        dayNightCareOrganisationPage.dayNightCareDepartmentAvailableChosen().click();

        WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
        actions.moveToElement(contactSalutation).click().build().perform();
        dayNightCareOrganisationPage.dayNightCareDepartmentContactSalutationChosen().click();

        //sprechzeiten
        dayNightCareOrganisationPage.mondayHourBegin().sendKeys(propDayNightCare.getProperty("mondayHourBegin"));
        dayNightCareOrganisationPage.mondayMinuteBegin().sendKeys(propDayNightCare.getProperty("mondayMinuteBegin"));
        dayNightCareOrganisationPage.mondayHourEnd().sendKeys(propDayNightCare.getProperty("mondayHourEnd"));
        dayNightCareOrganisationPage.mondayMinuteEnd().sendKeys(propDayNightCare.getProperty("mondayMinuteEnd"));

        dayNightCareOrganisationPage.wednesdayHourBegin().sendKeys(propDayNightCare.getProperty("wednesdayHourBegin"));
        dayNightCareOrganisationPage.wednesdayMinuteBegin().sendKeys(propDayNightCare.getProperty("wednesdayMinuteBegin"));
        dayNightCareOrganisationPage.wednesdayHourEnd().sendKeys(propDayNightCare.getProperty("wednesdayHourEnd"));
        dayNightCareOrganisationPage.wednesdayMinuteEnd().sendKeys(propDayNightCare.getProperty("wednesdayMinuteEnd"));

        dayNightCareOrganisationPage.fridayHourBegin().sendKeys(propDayNightCare.getProperty("fridayHourBegin"));
        dayNightCareOrganisationPage.fridayMinuteBegin().sendKeys(propDayNightCare.getProperty("fridayMinuteBegin"));
        dayNightCareOrganisationPage.fridayHourEnd().sendKeys(propDayNightCare.getProperty("fridayHourEnd"));
        dayNightCareOrganisationPage.fridayMinuteEnd().sendKeys(propDayNightCare.getProperty("fridayMinuteEnd"));

        //Beschreibung
        dayNightCareOrganisationPage.presentationOfDepartment().sendKeys(propDayNightCare.getProperty("presentationOfDepartment"));
        dayNightCareOrganisationPage.particularityZero().sendKeys(propDayNightCare.getProperty("particularityZero"));
        dayNightCareOrganisationPage.particularityOne().sendKeys(propDayNightCare.getProperty("particularityOne"));
        dayNightCareOrganisationPage.particularityTwo().sendKeys(propDayNightCare.getProperty("particularityTwo"));

        dayNightCareOrganisationPage.youTubeVideo().sendKeys(propDayNightCare.getProperty("youTubeVideo"));

        dayNightCareOrganisationPage.saveDayNightCareDepartment().click();

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
