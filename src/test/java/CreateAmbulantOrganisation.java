import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AmbulantOrganisationPage;

import java.io.IOException;

public class CreateAmbulantOrganisation extends MulLogin {

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
        AmbulantOrganisationPage ambulantOrganisationPage = new AmbulantOrganisationPage(driver);

        try {
            ambulantOrganisationPage.addDepartment().click();
            ambulantOrganisationPage.addAmbulantDepartment().click();
        } catch (Exception e) {
            System.out.println("Es wurde noch kein Department angelegt.");
        }

        try {
            ambulantOrganisationPage.addFirstAmbulantDepartment().click();
        } catch (Exception e) {
            System.out.println("Es existiert schon ein erstes Department");
        }

        //allgemeine Angaben
        ambulantOrganisationPage.ambulantDepartmentName().sendKeys(propDepartment.getProperty("ambulantDepartmentName"));
        ambulantOrganisationPage.ambulantDepartmentOrganisationType().click();
        ambulantOrganisationPage.ambulantDepartmentOrganisationTypeChosen().click();
        ambulantOrganisationPage.ambulantDepartmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
        ambulantOrganisationPage.ambulantDepartmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
        ambulantOrganisationPage.ambulantDepartmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
        ambulantOrganisationPage.ambulantDepartmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
        ambulantOrganisationPage.ambulantDepartmentWebsite().sendKeys(propDepartment.getProperty("website"));

        //angaben zur Person
        ambulantOrganisationPage.ambulantDepartmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
        ambulantOrganisationPage.ambulantDepartmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
        ambulantOrganisationPage.ambulantDepartmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
        ambulantOrganisationPage.ambulantDepartmentContactEmail().sendKeys(propDepartment.getProperty("contactEmail"));
        ambulantOrganisationPage.ambulantDepartmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));

        WebElement availability = driver.findElement(By.id("availability"));
        actions.moveToElement(availability).click().build().perform();
        ambulantOrganisationPage.ambulantDepartmentAvailableChosen().click();

        WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
        actions.moveToElement(contactSalutation).click().build().perform();
        ambulantOrganisationPage.ambulantDepartmentContactSalutationChosen().click();

        //sprechzeiten
        ambulantOrganisationPage.mondayHourBegin().sendKeys(propDepartment.getProperty("mondayHourBegin"));
        ambulantOrganisationPage.mondayMinuteBegin().sendKeys(propDepartment.getProperty("mondayMinuteBegin"));
        ambulantOrganisationPage.mondayHourEnd().sendKeys(propDepartment.getProperty("mondayHourEnd"));
        ambulantOrganisationPage.mondayMinuteEnd().sendKeys(propDepartment.getProperty("mondayMinuteEnd"));

        ambulantOrganisationPage.wednesdayHourBegin().sendKeys(propDepartment.getProperty("wednesdayHourBegin"));
        ambulantOrganisationPage.wednesdayMinuteBegin().sendKeys(propDepartment.getProperty("wednesdayMinuteBegin"));
        ambulantOrganisationPage.wednesdayHourEnd().sendKeys(propDepartment.getProperty("wednesdayHourEnd"));
        ambulantOrganisationPage.wednesdayMinuteEnd().sendKeys(propDepartment.getProperty("wednesdayMinuteEnd"));

        ambulantOrganisationPage.fridayHourBegin().sendKeys(propDepartment.getProperty("fridayHourBegin"));
        ambulantOrganisationPage.fridayMinuteBegin().sendKeys(propDepartment.getProperty("fridayMinuteBegin"));
        ambulantOrganisationPage.fridayHourEnd().sendKeys(propDepartment.getProperty("fridayHourEnd"));
        ambulantOrganisationPage.fridayMinuteEnd().sendKeys(propDepartment.getProperty("fridayMinuteEnd"));

        //Beschreibung
        ambulantOrganisationPage.presentationOfDepartment().sendKeys(propDepartment.getProperty("presentationOfDepartment"));
        ambulantOrganisationPage.particularityZero().sendKeys(propDepartment.getProperty("particularityZero"));
        ambulantOrganisationPage.particularityOne().sendKeys(propDepartment.getProperty("particularityOne"));
        ambulantOrganisationPage.particularityTwo().sendKeys(propDepartment.getProperty("particularityTwo"));

        //youtube
        ambulantOrganisationPage.youTubeVideo().sendKeys(propDepartment.getProperty("youTubeVideo"));

        //speichern
        ambulantOrganisationPage.saveDepartment().click();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
