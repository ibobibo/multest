package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObjects.contactPerson.ContactPersonPage;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateSomeContactPersonForSearch extends BaseClass {
    @Test()
    public void addContactPerson() throws IOException {
        initializeBrowser();

        ContactPersonPage contactPersonPage = new ContactPersonPage(driver);
        DepartmentPage departmentPage = new DepartmentPage(driver);
        Actions actions = new Actions(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            loadPropsForDepartment();

            try {
                departmentPage.addContactPersonCard().click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            for (int loop = 0; loop < 3; loop++) {
                if (loop == 0) {
                    contactPersonPage.addContactPerson().click();
                    WebElement availability = driver.findElement(By.id("salutation"));
                    actions.moveToElement(availability).click().build().perform();
                    contactPersonPage.contactSalutationChosen().click();
                    contactPersonPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName1"));
                    contactPersonPage.contactLastName().sendKeys(prop.getProperty("contactLastName1"));
                    contactPersonPage.contactEmail().sendKeys(prop.getProperty("contactPersonEmail1"));
                    contactPersonPage.contactPhone().sendKeys("body");
                    contactPersonPage.submit().click();
                } else if (loop == 1) {
                    contactPersonPage.addContactPerson().click();
                    WebElement availability = driver.findElement(By.id("salutation"));
                    actions.moveToElement(availability).click().build().perform();
                    contactPersonPage.contactSalutationChosen().click();
                    contactPersonPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName2"));
                    contactPersonPage.contactLastName().sendKeys(prop.getProperty("contactLastName2"));
                    contactPersonPage.contactEmail().sendKeys(prop.getProperty("contactPersonEmail2"));
                    contactPersonPage.contactPhone().sendKeys("body");
                    contactPersonPage.submit().click();
                } else if (loop == 2) {
                    contactPersonPage.addContactPerson().click();
                    WebElement availability = driver.findElement(By.id("salutation"));
                    actions.moveToElement(availability).click().build().perform();
                    contactPersonPage.contactSalutationChosen().click();
                    contactPersonPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName3"));
                    contactPersonPage.contactLastName().sendKeys(prop.getProperty("contactLastName3"));
                    contactPersonPage.contactEmail().sendKeys(prop.getProperty("contactPersonEmail3"));
                    contactPersonPage.contactPhone().sendKeys("body");
                    contactPersonPage.submit().click();
                }
            }
        }
        driver.quit();
    }
}
