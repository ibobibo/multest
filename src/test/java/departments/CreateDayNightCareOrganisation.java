package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateDayNightCareOrganisation extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void createDayNightCareOrganisation() throws IOException, InterruptedException {
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            loginLoop(i);

            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);

            loadPropsForDepartment();
            DepartmentPage dayNightCareOrganisationPage = new DepartmentPage(driver);

            try{
                dayNightCareOrganisationPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                System.out.println("Card wird geklickt.");
            }

            try {
                dayNightCareOrganisationPage.addDepartment().click();
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println("Es wurde noch kein Department angelegt.");
            }

            try {
                dayNightCareOrganisationPage.addFirstDayNightCareDepartment().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Es wurde noch kein Department angelegt.");
            }

            try {
                dayNightCareOrganisationPage.addDayNightCareDepartment().click();
            } catch (Exception e) {
                System.out.println("Es existiert schon ein erstes Department");
            }

            //allgemeine Angaben
            TimeUnit.SECONDS.sleep(2);

            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

            dayNightCareOrganisationPage.departmentName().sendKeys(propDepartment.getProperty("dayNightCareDepartmentName"));

            WebElement organisationType = driver.findElement(By.id("organisationType"));
            actions.moveToElement(organisationType).click().build().perform();
            dayNightCareOrganisationPage.departmentOrganisationTypeChosen().click();

            dayNightCareOrganisationPage.departmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
            dayNightCareOrganisationPage.departmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
            dayNightCareOrganisationPage.departmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
            dayNightCareOrganisationPage.departmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
            dayNightCareOrganisationPage.departmentWebsite().sendKeys(propDepartment.getProperty("website"));

            //angaben zur Person
            dayNightCareOrganisationPage.departmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
            dayNightCareOrganisationPage.departmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
            dayNightCareOrganisationPage.departmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
            dayNightCareOrganisationPage.departmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));

            WebElement availability = driver.findElement(By.id("availability"));
            actions.moveToElement(availability).click().build().perform();
            dayNightCareOrganisationPage.departmentAvailableChosen().click();

            WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
            actions.moveToElement(contactSalutation).click().build().perform();
            dayNightCareOrganisationPage.departmentContactSalutationChosen().click();

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
