import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    public void verifyRegisteredUser() throws IOException {
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            Actions actions = new Actions(driver);
            String x = "//ul[@class='email-list']//span[contains(text(),'" + prop.getProperty("contactEmail").toLowerCase() + i + "')]";

            try {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                WebElement findEmail = driver.findElement(By.xpath(x));
                actions.moveToElement(findEmail).click().build().perform();
            } catch (Exception e) {
                System.out.println("shit 1");
            }

            try {
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='preview-iframe panel-html']")));
                driver.findElement(By.xpath("/html/body/p[3]/a")).click();
                driver.switchTo().defaultContent();
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                System.out.println("shit 2");
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
