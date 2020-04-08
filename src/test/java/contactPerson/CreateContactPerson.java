package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.contactPerson.ContactPersonPage;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateContactPerson extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies(driver);
    }

    @Test()
    public void addContactPerson() throws IOException, InterruptedException {
        ContactPersonPage contactPersonPage = new ContactPersonPage(driver);
        DepartmentPage departmentPage = new DepartmentPage(driver);
        Actions actions = new Actions(driver);
        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {

            loginLoop(i);
            loadPropsForDepartment();

            try {
                departmentPage.addContactPersonCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            TimeUnit.SECONDS.sleep(1);

            contactPersonPage.addContactPerson().click();
            TimeUnit.SECONDS.sleep(1);
            WebElement availability = driver.findElement(By.id("salutation"));
            actions.moveToElement(availability).click().build().perform();
            contactPersonPage.contactSalutationChosen().click();
            contactPersonPage.contactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
            contactPersonPage.contactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
            contactPersonPage.contactEmail().sendKeys(propDepartment.getProperty("contactEmail"));
            contactPersonPage.contactPhone().sendKeys(propDepartment.getProperty("contactPhone"));
            contactPersonPage.submit().click();
        }
        TimeUnit.SECONDS.sleep(1);
        logout();
    }

    @AfterTest
    public void closeBrowser() {
       driver.close();
        driver = null;
    }
}
