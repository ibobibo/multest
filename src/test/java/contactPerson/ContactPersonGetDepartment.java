package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.contactPerson.ContactPersonGetDepartmentPage;
import resources.MulLogin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ContactPersonGetDepartment extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test()
    public void addContactPerson() throws InterruptedException {
        ContactPersonGetDepartmentPage contactPersonGetDepartmentPage = new ContactPersonGetDepartmentPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        login();

        if (contactPersonGetDepartmentPage.contactUserDisplayed().isDisplayed()) {
            int i = 1;
            while (getCount() >= i) {
                TimeUnit.SECONDS.sleep(5);
                String xpath = "//tr[" + i + "]//td[6]//div[1]//button[1]";
                WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                if (findTr.isDisplayed()) {
                    findTr.click();
                }
                contactPersonGetDepartmentPage.choseContactPerson().click();
                contactPersonGetDepartmentPage.submit().click();
                i++;
            }
        }

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
