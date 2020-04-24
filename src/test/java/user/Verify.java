package user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Verify extends BaseClass {
    @Test
    public void verifyRegisteredUser() throws IOException, InterruptedException {
        initializeMailServer();
        loadProps();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search']"));
            searchField.clear();
            searchField.sendKeys(prop.getProperty("contactEmail"));

            String x = "//ul[@class='email-list']//span[contains(text(),'" + prop.getProperty("contactEmail").toLowerCase() + "')]";
            WebElement findEmail = driver.findElement(By.xpath(x));
            findEmail.click();

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='preview-iframe panel-html']")));
            driver.findElement(By.xpath("/html/body/p[3]/a")).click();
            TimeUnit.SECONDS.sleep(5);

            driver.quit();
        }
    }
}
