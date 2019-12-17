package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.contactPerson.ContactPersonPage;
import pageObjects.departments.DepartmentPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateSomeContactPersonForSearch extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies();
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
                System.out.println("Card wird geklickt.");
            }


            TimeUnit.SECONDS.sleep(1);

            for (int loop = 0; loop < 3; loop++) {
                if (loop == 0) {
                    contactPersonPage.addContactPerson().click();
                    TimeUnit.SECONDS.sleep(1);
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
                    TimeUnit.SECONDS.sleep(1);
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
                    TimeUnit.SECONDS.sleep(1);
                    WebElement availability = driver.findElement(By.id("salutation"));
                    actions.moveToElement(availability).click().build().perform();
                    contactPersonPage.contactSalutationChosen().click();
                    contactPersonPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName3"));
                    contactPersonPage.contactLastName().sendKeys(prop.getProperty("contactLastName3"));
                    contactPersonPage.contactEmail().sendKeys(prop.getProperty("contactPersonEmail3"));
                    contactPersonPage.contactPhone().sendKeys("body");
                    contactPersonPage.submit().click();
                }
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}