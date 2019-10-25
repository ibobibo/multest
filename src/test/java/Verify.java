import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Verify extends BaseClass {
    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeMailServer();
        accessAllCookies();
    }

    @Test
    public void verifyRegisteredUser() throws IOException, InterruptedException {
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            WebElement inputField = driver.findElement(By.xpath("//div[@class='search-container']//input[@placeholder='Search']"));
            String x = "//ul[@class='email-list']//span[contains(text(),'" + prop.getProperty("contactEmail").toLowerCase() + i + "')]";
            inputField.clear();
            inputField.sendKeys(prop.getProperty("contactEmail").toLowerCase() + i);

            WebElement findEmail = driver.findElement(By.xpath(x));
            findEmail.click();

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='preview-iframe panel-html']")));
            driver.findElement(By.xpath("/html/body/p[3]/a")).click();
            driver.switchTo().defaultContent();
            TimeUnit.SECONDS.sleep(5);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
