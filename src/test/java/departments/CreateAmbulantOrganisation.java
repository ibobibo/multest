package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.AmbulantOrganisationPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateAmbulantOrganisation extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void createAmbulantOrganisation() throws IOException, InterruptedException {
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            loginLoop(i);

            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);

            loadPropsForDepartment();
            AmbulantOrganisationPage ambulantOrganisationPage = new AmbulantOrganisationPage(driver);

            try {
                ambulantOrganisationPage.addDepartment().click();
                TimeUnit.SECONDS.sleep(1);
                ambulantOrganisationPage.addAmbulantDepartment().click();
                TimeUnit.SECONDS.sleep(1);

            } catch (Exception e) {
                System.out.println("Es wurde noch kein Department angelegt.");
            }

            try {
                ambulantOrganisationPage.addFirstAmbulantDepartment().click();
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println("Es existiert schon ein erstes Department");
            }

            //allgemeine Angaben
            TimeUnit.SECONDS.sleep(2);

            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

            ambulantOrganisationPage.ambulantDepartmentName().sendKeys(propDepartment.getProperty("ambulantDepartmentName"));

            WebElement organisationType = driver.findElement(By.id("organisationType"));
            actions.moveToElement(organisationType).click().build().perform();
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

            TimeUnit.SECONDS.sleep(6);
            logout();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
