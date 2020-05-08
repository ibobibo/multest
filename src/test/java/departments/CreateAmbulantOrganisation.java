package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateAmbulantOrganisation extends BaseClass {
    @Test
    public void createAmbulantOrganisation() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();
        loadPropsForDepartment();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            Actions actions = new Actions(driver);
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
                departmentPage.addFirstAmbulantDepartment().click();
            } catch (Exception e) {
                System.out.println("first Department");
            }
            try {
                departmentPage.addAmbulantDepartment().click();
            } catch (Exception e) {
                System.out.println("n'th Department");
            }

            //allgemeine Angaben
            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

            departmentPage.departmentName().sendKeys(propDepartment.getProperty("ambulantDepartmentName"));

//            File companyPicture = new File("src/main/java/departmentPictures/BildCompany.png");
//            departmentPage.uploadDepartmentCompanyImage().sendKeys(companyPicture.getAbsolutePath());
//            TimeUnit.SECONDS.sleep(10);
//            File contactPhoto = new File("src/main/java/departmentPictures/ContactPhoto.jpg");
//            departmentPage.contactPhoto().sendKeys(contactPhoto.getAbsolutePath());
//            TimeUnit.SECONDS.sleep(10);

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

            //image
            File[] files = {
                    new File("src/main/java/departmentPictures/Bild1.jpg"),
                    new File("src/main/java/departmentPictures/Bild2.jpg"),
                    new File("src/main/java/departmentPictures/Bild3.jpg"),
                    new File("src/main/java/departmentPictures/Bild4.png"),
                    new File("src/main/java/departmentPictures/Bild5.png"),
                    new File("src/main/java/departmentPictures/Bild6.png"),
                    new File("src/main/java/departmentPictures/Bild7.jpg"),
                    new File("src/main/java/departmentPictures/Bild8.gif"),
                    new File("src/main/java/departmentPictures/Bild9.gif"),
                    new File("src/main/java/departmentPictures/Bild10.gif")
            };
            for (int y = 0; y < files.length; y++) {
                departmentPage.uploadDepartmentImage().sendKeys(files[y].getAbsolutePath());
                TimeUnit.SECONDS.sleep(15);
                departmentPage.saveDepartment().click();
                String xpath = "//a[@id='edit-button-1']";
                WebElement findTr = driver.findElement(By.xpath(xpath));
                findTr.click();
            }

            File infoMaterial= new File("src/main/java/departmentPdfFiles/small13kb.pdf");
            departmentPage.infoMaterial().sendKeys( infoMaterial.getAbsolutePath());
            TimeUnit.SECONDS.sleep(10);
            File mdkReport= new File("src/main/java/departmentPdfFiles/small13kb.pdf");
            departmentPage.mdkReport().sendKeys( mdkReport.getAbsolutePath());
            TimeUnit.SECONDS.sleep(10);
            //speichern
            departmentPage.saveDepartment().click();
            logout();
        }
        driver.quit();
    }
}
