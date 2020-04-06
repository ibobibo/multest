package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateStationaryOrganisation extends BaseClass {
    @Test
    public void createStationaryOrganisation() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();
        accessAllCookies(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            try {
                loginLoop(i);
            } catch (Exception e) {
                System.out.println("logged in");
            }
            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);

            loadPropsForDepartment();
            DepartmentPage departmentPage = new DepartmentPage(driver);

            try {
                departmentPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            try {
                departmentPage.addDepartment().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("first Department");
            }

            try {
                departmentPage.addFirstStationaryDepartment().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("first Department");
            }

            try {
                departmentPage.addStationaryDepartment().click();
            } catch (Exception e) {
                System.out.println("n'th Department");
            }

            //Allgemeine Angaben
            TimeUnit.SECONDS.sleep(4);

            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

            departmentPage.departmentName().sendKeys(propDepartment.getProperty("stationaryDepartmentName"));

            WebElement organisationType = driver.findElement(By.id("organisationType"));
            actions.moveToElement(organisationType).click().build().perform();
            departmentPage.departmentOrganisationTypeChosen().click();

            departmentPage.departmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
            departmentPage.departmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
            departmentPage.departmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
            departmentPage.departmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
            departmentPage.departmentWebsite().sendKeys(propDepartment.getProperty("website"));

            //angaben zur Person
            departmentPage.departmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
            departmentPage.departmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
            departmentPage.departmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
            departmentPage.departmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));

            WebElement availability = driver.findElement(By.id("availability"));
            actions.moveToElement(availability).click().build().perform();
            departmentPage.departmentAvailableChosen().click();

            WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
            actions.moveToElement(contactSalutation).click().build().perform();
            departmentPage.departmentContactSalutationChosen().click();

            //sprechzeiten
            departmentPage.mondayHourBegin().sendKeys(propDepartment.getProperty("mondayHourBegin"));
            departmentPage.mondayMinuteBegin().sendKeys(propDepartment.getProperty("mondayMinuteBegin"));
            departmentPage.mondayHourEnd().sendKeys(propDepartment.getProperty("mondayHourEnd"));
            departmentPage.mondayMinuteEnd().sendKeys(propDepartment.getProperty("mondayMinuteEnd"));

            departmentPage.wednesdayHourBegin().sendKeys(propDepartment.getProperty("wednesdayHourBegin"));
            departmentPage.wednesdayMinuteBegin().sendKeys(propDepartment.getProperty("wednesdayMinuteBegin"));
            departmentPage.wednesdayHourEnd().sendKeys(propDepartment.getProperty("wednesdayHourEnd"));
            departmentPage.wednesdayMinuteEnd().sendKeys(propDepartment.getProperty("wednesdayMinuteEnd"));

            departmentPage.fridayHourBegin().sendKeys(propDepartment.getProperty("fridayHourBegin"));
            departmentPage.fridayMinuteBegin().sendKeys(propDepartment.getProperty("fridayMinuteBegin"));
            departmentPage.fridayHourEnd().sendKeys(propDepartment.getProperty("fridayHourEnd"));
            departmentPage.fridayMinuteEnd().sendKeys(propDepartment.getProperty("fridayMinuteEnd"));

            //Beschreibung
            departmentPage.presentationOfDepartment().sendKeys(propDepartment.getProperty("presentationOfDepartment"));
            departmentPage.particularityZero().sendKeys(propDepartment.getProperty("particularityZero"));
            departmentPage.particularityOne().sendKeys(propDepartment.getProperty("particularityOne"));
            departmentPage.particularityTwo().sendKeys(propDepartment.getProperty("particularityTwo"));

            //Youtube
            departmentPage.youTubeVideo().sendKeys(propDepartment.getProperty("youTubeVideo"));

            //speichern
            departmentPage.saveDepartment().click();

            TimeUnit.SECONDS.sleep(6);
            logout();
            TimeUnit.SECONDS.sleep(2);
        }
        driver.quit();
        driver = null;
    }
}
