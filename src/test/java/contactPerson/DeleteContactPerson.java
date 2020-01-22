package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.contactPerson.DeleteContactPersonPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteContactPerson extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies(driver);
    }

    @Test()
    public void deleteContactPerson() throws InterruptedException {
        DeleteContactPersonPage deleteContactPersonPage = new DeleteContactPersonPage(driver);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {

            loginLoop(i);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            try {
                deleteContactPersonPage.addContactPersonCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card wird geklickt.");
            }

            while (getCountContactPerson() != 0) {
                String xpath = "//section[@class='Userdata']//tr[1]//a[@class='delete']";
                WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                if (findTr.isDisplayed()) {
                    findTr.click();
                    deleteContactPersonPage.delete().click();
                    TimeUnit.SECONDS.sleep(2);
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
