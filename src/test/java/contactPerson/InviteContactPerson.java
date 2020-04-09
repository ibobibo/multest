package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InviteContactPerson extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies(driver);
    }

    @Test()
    public void inviteContactPerson() throws InterruptedException {
        DepartmentPage departmentPage = new DepartmentPage(driver);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);

            try {
                departmentPage.addContactPersonCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            WebDriverWait wait = new WebDriverWait(driver, 5);

            int x = 1;
            while (getCountContactPerson() >= x) {
                String xpath = "//section[@class='Userdata']//tr[" + x + "]//button[@class='invite']";
                WebElement findTr = null;
                try {
                    findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                } catch (Exception e) {
                    System.out.println("not displayed");
                }
                if (findTr.isDisplayed()) {
                    findTr.click();
                }
                x++;
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
