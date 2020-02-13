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
        TimeUnit.SECONDS.sleep(2);
        try {
            accessAllCookies(driver);
        } catch (Exception e) {
            System.out.println("cookies accepted through register class");
        }


        VerifyPage verifyPage = new VerifyPage(driver);
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            WebElement inputField = driver.findElement(By.xpath("//div[@class='search-container']//input[@placeholder='Search']"));
            String x = "//ul[@class='email-list']//span[contains(text(),'" + prop.getProperty("contactEmail").toLowerCase() + i + "')]";
            inputField.clear();
            TimeUnit.SECONDS.sleep(1);
            inputField.sendKeys(prop.getProperty("contactEmail").toLowerCase() + i);
            TimeUnit.SECONDS.sleep(1);

            WebElement findEmail = driver.findElement(By.xpath(x));
            findEmail.click();
            TimeUnit.SECONDS.sleep(2);


            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='preview-iframe panel-html']")));
            driver.findElement(By.xpath("/html/body/p[3]/a")).click();
            TimeUnit.SECONDS.sleep(2);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            TimeUnit.SECONDS.sleep(4);
            accessAllCookies(driver);
            TimeUnit.SECONDS.sleep(2);

            verifyPage.newPassword().sendKeys(prop.getProperty("contactPassword"));
            verifyPage.newPasswordRepeat().sendKeys(prop.getProperty("contactPassword"));
            TimeUnit.SECONDS.sleep(2);
            verifyPage.submitPassword().click();
            TimeUnit.SECONDS.sleep(1);

            driver.close();

            driver.switchTo().window(tabs.get(0));
            TimeUnit.SECONDS.sleep(2);
            driver.switchTo().defaultContent();
            TimeUnit.SECONDS.sleep(2);
        }
        driver.quit();
        driver = null;
    }
}
