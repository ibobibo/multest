package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.contactPerson.ContactPersonGetDepartmentPage;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ContactPersonGetDepartment extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies(driver);
    }

    @Test()
    public void contactPersonGetDepartment() throws InterruptedException {
        ContactPersonGetDepartmentPage contactPersonGetDepartmentPage = new ContactPersonGetDepartmentPage(driver);
        DepartmentPage departmentPage = new DepartmentPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);

            try {
                departmentPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            if (contactPersonGetDepartmentPage.contactUserDisplayed().isDisplayed()) {
                int x = 0;
                int y = 1;
                while (getCount() >= y) {
                    TimeUnit.SECONDS.sleep(2);
                    String xpath = "//tr[" + y + "]//button[@id='company-button-" + x + "']";
                    WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                    if (findTr.isDisplayed()) {
                        findTr.click();
                        TimeUnit.SECONDS.sleep(2);
                    }
                    contactPersonGetDepartmentPage.choseContactPerson().click();
                    TimeUnit.SECONDS.sleep(2);
                    contactPersonGetDepartmentPage.submit().click();
                    x++;
                    y++;
                }
            }

            TimeUnit.SECONDS.sleep(2);
        }
        try {
            departmentPage.addContactPersonCard().click();
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Card will be clicked.");
        }

        TimeUnit.SECONDS.sleep(2);

        if (!contactPersonGetDepartmentPage.addedLocationForContactPerson().getText().equals("Ambulant")) {
            driver.quit();
            Assert.fail("Der Standort konnte der Anpsprechperson nicht zugewiesen werden.");
        }

        logout();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
