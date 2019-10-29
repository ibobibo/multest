package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.contactPerson.ContactPersonGetDepartmentPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ContactPersonGetDepartment extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies();
    }

    @Test()
    public void contactPersonGetDepartment() throws InterruptedException {
        ContactPersonGetDepartmentPage contactPersonGetDepartmentPage = new ContactPersonGetDepartmentPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);

            if (contactPersonGetDepartmentPage.contactUserDisplayed().isDisplayed()) {
                int x = 0;
                int y= 1;
                while (getCount() >= y) {
                    TimeUnit.SECONDS.sleep(5);
                    String xpath = "//tr[" + y + "]//button[@id='company-button-" + x + "']";
                    WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                    if (findTr.isDisplayed()) {
                        findTr.click();
                    }
                    contactPersonGetDepartmentPage.choseContactPerson().click();
                    contactPersonGetDepartmentPage.submit().click();
                    x++;
                    y++;
                }
            }
            TimeUnit.SECONDS.sleep(2);
        }
        logout();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
