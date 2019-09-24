package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.MulLogin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ToggleOrganisation extends MulLogin {

    @Override
    public int getCount() {
        return super.getCount();
    }

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test()
    public void toggleAllOrganisation() throws InterruptedException {
        login();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        int i = 1;
        while (getCount() >= i) {
            TimeUnit.SECONDS.sleep(5);
            String xpath = "//tr[" + i + "]//td[1]//label[1]";
            WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            if (findTr.isDisplayed()) {
                findTr.click();
            }
            i++;
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}

