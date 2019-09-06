import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AmbulantOrganisationPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateAmbulantOrganisation extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void createOrganisation() throws IOException {
        login();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        for (int i = 0; i < 2; i++) {
            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);

            loadProps();
            loadPropsForAmbulantDepartment();
            AmbulantOrganisationPage ambulantOrganisationPage = new AmbulantOrganisationPage(driver);

            ambulantOrganisationPage.addDepartment().click();
            ambulantOrganisationPage.addAmbulantDepartment().click();

            ambulantOrganisationPage.ambulantDepartmentName().sendKeys(propAmbulant.getProperty("ambulantDepartmentName"));
            ambulantOrganisationPage.ambulantDepartmentOrganisationType().click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            ambulantOrganisationPage.ambulantDepartmentOrganisationTypeChosen().click();
            ambulantOrganisationPage.ambulantDepartmentStreetAddress().sendKeys(propAmbulant.getProperty("ambulantDepartmentStreetAddress"));
            ambulantOrganisationPage.ambulantDepartmentStreetNumber().sendKeys(propAmbulant.getProperty("ambulantDepartmentStreetNumber"));
            ambulantOrganisationPage.ambulantDepartmentPostalCode().sendKeys(propAmbulant.getProperty("ambulantDepartmentPostalCode"));
            ambulantOrganisationPage.ambulantDepartmentAddressCity().sendKeys(propAmbulant.getProperty("ambulantDepartmentAddressCity"));
            ambulantOrganisationPage.ambulantDepartmentWebsite().sendKeys(propAmbulant.getProperty("ambulantDepartmentWebsite"));

            ambulantOrganisationPage.ambulantDepartmentContactFirstName().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactFirstName"));
            ambulantOrganisationPage.ambulantDepartmentContactLastName().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactLastName"));
            ambulantOrganisationPage.ambulantDepartmentContactTitle().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactTitle"));
            ambulantOrganisationPage.ambulantDepartmentContactEmail().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactEmail"));
            ambulantOrganisationPage.ambulantDepartmentContactPhone().sendKeys(propAmbulant.getProperty("ambulantDepartmentContactPhone"));

            WebElement availability = driver.findElement(By.id("availability"));
            actions.moveToElement(availability).click().build().perform();
            ambulantOrganisationPage.ambulantDepartmentAvailableChosen().click();

            WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
            actions.moveToElement(contactSalutation).click().build().perform();
            ambulantOrganisationPage.ambulantDepartmentContactSalutationChosen().click();

            ambulantOrganisationPage.mondayHourBegin().sendKeys(propAmbulant.getProperty("mondayHourBegin"));
            ambulantOrganisationPage.mondayMinuteBegin().sendKeys(propAmbulant.getProperty("mondayMinuteBegin"));
            ambulantOrganisationPage.mondayHourEnd().sendKeys(propAmbulant.getProperty("mondayHourEnd"));
            ambulantOrganisationPage.mondayMinuteEnd().sendKeys(propAmbulant.getProperty("mondayMinuteEnd"));

            ambulantOrganisationPage.wednesdayHourBegin().sendKeys(propAmbulant.getProperty("wednesdayHourBegin"));
            ambulantOrganisationPage.wednesdayMinuteBegin().sendKeys(propAmbulant.getProperty("wednesdayMinuteBegin"));
            ambulantOrganisationPage.wednesdayHourEnd().sendKeys(propAmbulant.getProperty("wednesdayHourEnd"));
            ambulantOrganisationPage.wednesdayMinuteEnd().sendKeys(propAmbulant.getProperty("wednesdayMinuteEnd"));

            ambulantOrganisationPage.fridayHourBegin().sendKeys(propAmbulant.getProperty("fridayHourBegin"));
            ambulantOrganisationPage.fridayMinuteBegin().sendKeys(propAmbulant.getProperty("fridayMinuteBegin"));
            ambulantOrganisationPage.fridayHourEnd().sendKeys(propAmbulant.getProperty("fridayHourEnd"));
            ambulantOrganisationPage.fridayMinuteEnd().sendKeys(propAmbulant.getProperty("fridayMinuteEnd"));

            ambulantOrganisationPage.presentationOfDepartment().sendKeys(propAmbulant.getProperty("presentationOfDepartment"));
            ambulantOrganisationPage.particularityZero().sendKeys(propAmbulant.getProperty("particularityZero"));
            ambulantOrganisationPage.particularityOne().sendKeys(propAmbulant.getProperty("particularityOne"));
            ambulantOrganisationPage.particularityTwo().sendKeys(propAmbulant.getProperty("particularityTwo"));

            ambulantOrganisationPage.youTubeVideo().sendKeys(propAmbulant.getProperty("youTubeVideo"));

            ambulantOrganisationPage.saveAmbulantDepartment().click();
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
