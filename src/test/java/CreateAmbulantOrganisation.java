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
    public void createOrganisation() throws IOException, InterruptedException {
        loadProps();
        loadPropsForAmbulantDepartment();
        AmbulantOrganisationPage ambulantOrganisationPage = new AmbulantOrganisationPage(driver);

        login();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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

        //funktioniert!!!!
        WebElement element = driver.findElement(By.id("availability"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        ambulantOrganisationPage.ambulantDepartmentAvailableChosen().click();

        ambulantOrganisationPage.ambulantDepartmentContactSalutation().click();
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

    @AfterTest
    public void closeBrowser() {
        driver = null;
    }
}
