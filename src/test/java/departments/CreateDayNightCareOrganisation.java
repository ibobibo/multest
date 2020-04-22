package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateDayNightCareOrganisation extends BaseClass {
    @Test
    public void createDayNightCareOrganisation() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);

            Actions actions = new Actions(driver);
            loadPropsForDepartment();
            DepartmentPage departmentPage = new DepartmentPage(driver);

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.addDepartmentCard())).click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.addDepartment())).click();
            } catch (Exception e) {
                System.out.println("first Department");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.addFirstDayNightCareDepartment())).click();
            } catch (Exception e) {
                System.out.println("first Department");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.addDayNightCareDepartment())).click();
            } catch (Exception e) {
                System.out.println("n'th Department");
            }

            //allgemeine Angaben
            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

            departmentPage.departmentName().sendKeys(propDepartment.getProperty("dayNightCareDepartmentName"));

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

            //youtube
            departmentPage.youTubeVideo().sendKeys(propDepartment.getProperty("youTubeVideo"));

            //speichern
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.saveDepartment())).click();
            TimeUnit.SECONDS.sleep(2);
            logout();
            TimeUnit.SECONDS.sleep(2);
        }
        driver.quit();
    }
}
