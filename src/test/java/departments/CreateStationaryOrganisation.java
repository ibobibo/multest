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

public class CreateStationaryOrganisation extends BaseClass {
    @Test
    public void createStationaryOrganisation() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);

            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);
            loadPropsForDepartment();
            DepartmentPage departmentPage = new DepartmentPage(driver);

            try {
                departmentPage.addDepartmentCard().click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }
            try {
                departmentPage.addDepartment().click();
            } catch (Exception e) {
                System.out.println("first Department");
            }
            try {
                departmentPage.addFirstStationaryDepartment().click();
            } catch (Exception e) {
                System.out.println("first Department");
            }
            try {
                departmentPage.addStationaryDepartment().click();
            } catch (Exception e) {
                System.out.println("n'th Department");
            }

            //Allgemeine Angaben
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

            //image
            String[] cars = {
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild1.jpg",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild2.jpg",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild3.jpg",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild4.png",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild5.png",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild6.png",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild7.jpg",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild8.gif",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild9.gif",
                    "/Users/ijawad/Documents/Arbeit/Automatisierung/MulTesting/src/main/java/departmentPictures/Bild10.gif"
            };
            for (int y = 0; y < cars.length; y++) {
                departmentPage.uploadDepartmentImage().sendKeys(cars[y]);
                TimeUnit.SECONDS.sleep(10);
                departmentPage.saveDepartment().click();
                String xpath = "//a[@id='edit-button-2']";
                WebElement findTr = driver.findElement(By.xpath(xpath));
                findTr.click();
            }

            //speichern
            departmentPage.saveDepartment().click();
            logout();
        }
        driver.quit();
    }
}
