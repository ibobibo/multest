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
        TimeUnit.SECONDS.sleep(4);

        loadProps();

        accessAllCookies(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']"))).clear();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']"))).sendKeys(prop.getProperty("contactEmail").toLowerCase());
            TimeUnit.SECONDS.sleep(4);

            String x = "//ul[@class='email-list']//span[contains(text(),'" + prop.getProperty("contactEmail").toLowerCase() + "')]";
            WebElement findEmail = driver.findElement(By.xpath(x));
            findEmail.click();
            TimeUnit.SECONDS.sleep(2);

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='preview-iframe panel-html']")));
            driver.findElement(By.xpath("/html/body/p[3]/a")).click();
            TimeUnit.SECONDS.sleep(4);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.close();

            driver.switchTo().window(tabs.get(0));
            TimeUnit.SECONDS.sleep(2);
            driver.switchTo().defaultContent();
            TimeUnit.SECONDS.sleep(2);

            driver.quit();
        }
    }
}
