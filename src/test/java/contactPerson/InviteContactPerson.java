package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.MulLoginLogout;

import java.io.IOException;

public class InviteContactPerson extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test()
    public void inviteContactPerson() throws InterruptedException {
        login();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        int i = 1;
        while (getCountContactPerson() >= i) {
            String xpath = "//section[@class='Userdata']//tr[" + i + "]//button[@class='invite']";
            WebElement findTr = null;
            try {
                findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            } catch (Exception e) {
                System.out.println("not displayed");
            }
            if (findTr.isDisplayed()) {
                findTr.click();
            }

            i++;
        }

        logout();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
