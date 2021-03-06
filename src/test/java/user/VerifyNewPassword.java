package user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.user.VerifyPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class VerifyNewPassword extends BaseClass {
    @Test
    public void verifyRegisteredUser() throws IOException, InterruptedException {
        initializeMailServer();
        VerifyPage verifyPage = new VerifyPage(driver);
        loadProps();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            WebElement inputField = driver.findElement(By.xpath("//div[@class='search-container']//input[@placeholder='Search']"));
            String x = "//li[1]//span[contains(text(),'" + prop.getProperty("contactEmail").toLowerCase() + "')]";
            inputField.clear();
            inputField.sendKeys(prop.getProperty("contactEmail").toLowerCase());
            WebElement findEmail = driver.findElement(By.xpath(x));
            findEmail.click();
            TimeUnit.SECONDS.sleep(4);
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='preview-iframe panel-html']")));
            driver.findElement(By.xpath("/html/body/p[3]/a")).click();

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            accessAllCookies(driver);
            verifyPage.newPassword().sendKeys(prop.getProperty("contactPassword"));
            verifyPage.newPasswordRepeat().sendKeys(prop.getProperty("contactPassword"));
            verifyPage.submitPassword().click();
            TimeUnit.SECONDS.sleep(1);

            driver.close();

            driver.switchTo().window(tabs.get(0));
            TimeUnit.SECONDS.sleep(2);
            driver.switchTo().defaultContent();
            TimeUnit.SECONDS.sleep(2);
        }
        driver.quit();
    }
}
