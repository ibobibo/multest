package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ToggleOrganisation extends MulLoginLogout {

    @Override
    public int getCount() {
        return super.getCount();
    }

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test()
    public void toggleAllOrganisation() throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            WebDriverWait wait = new WebDriverWait(driver, 20);

            int x = 1;
            while (getCount() >= x) {
                TimeUnit.SECONDS.sleep(5);

                String xpath = "//tr[" + x + "]//td[1]//label[1]";
                WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                if (findTr.isDisplayed()) {
                    findTr.click();
                }
                x++;
            }
            TimeUnit.SECONDS.sleep(6);
            logout();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
