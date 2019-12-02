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

public class CreateStationaryOrganisation extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void createStationaryOrganisation() throws IOException, InterruptedException {
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            loginLoop(i);

            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);

            loadPropsForDepartment();
            DepartmentPage stationaryOrganisationPage = new DepartmentPage(driver);

            try{
                stationaryOrganisationPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                System.out.println("Card wird geklickt.");
            }

            try {
                stationaryOrganisationPage.addDepartment().click();
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println("Es wurde noch kein Department angelegt.");
            }

            try {
                stationaryOrganisationPage.addFirstStationaryDepartment().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Es wurde noch kein Department angelegt.");
            }

            try {
                stationaryOrganisationPage.addStationaryDepartment().click();
            } catch (Exception e) {
                System.out.println("Es existiert schon ein erstes Department");
            }

            //Allgemeine Angaben
            TimeUnit.SECONDS.sleep(2);

            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

            stationaryOrganisationPage.departmentName().sendKeys(propDepartment.getProperty("stationaryDepartmentName"));

            WebElement organisationType = driver.findElement(By.id("organisationType"));
            actions.moveToElement(organisationType).click().build().perform();
            stationaryOrganisationPage.departmentOrganisationTypeChosen().click();

            stationaryOrganisationPage.departmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
            stationaryOrganisationPage.departmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
            stationaryOrganisationPage.departmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
            stationaryOrganisationPage.departmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
            stationaryOrganisationPage.departmentWebsite().sendKeys(propDepartment.getProperty("website"));

            //angaben zur Person
            stationaryOrganisationPage.departmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
            stationaryOrganisationPage.departmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
            stationaryOrganisationPage.departmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
            stationaryOrganisationPage.departmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));

            WebElement availability = driver.findElement(By.id("availability"));
            actions.moveToElement(availability).click().build().perform();
            stationaryOrganisationPage.departmentAvailableChosen().click();

            WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
            actions.moveToElement(contactSalutation).click().build().perform();
            stationaryOrganisationPage.departmentContactSalutationChosen().click();

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
