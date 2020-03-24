package license;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.license.LicensePageobject;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LicensePaymentLastschriftTest extends BaseClass {
    @Test()
    public void payWithSepaLastschriftForLicense() throws InterruptedException, IOException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            LicensePageobject licensePageobject = new LicensePageobject(driver);
            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);
            licensePageobject.licenseNavbar().click();
            TimeUnit.SECONDS.sleep(1);
            licensePageobject.firstDepartmentAddLicense().click();
            TimeUnit.SECONDS.sleep(1);
            licensePageobject.checkboxForConfirmation().click();
            TimeUnit.SECONDS.sleep(1);
            licensePageobject.continueToPayment().click();
            TimeUnit.SECONDS.sleep(1);
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='checkout-frame']")));
            TimeUnit.SECONDS.sleep(2);

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Lastschrift SEPA']"))).click();
            TimeUnit.SECONDS.sleep(1);

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form[1]/div/div[5]/div[1]/div[2]/div[2]/div/input"))).clear();
            TimeUnit.SECONDS.sleep(1);
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form[1]/div/div[5]/div[1]/div[2]/div[2]/div/input"))).sendKeys("Max Musterman");
            TimeUnit.SECONDS.sleep(1);

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form[1]/div/div[5]/div[1]/div[2]/div[3]/div/input"))).sendKeys("DE24300209002411761956");
            TimeUnit.SECONDS.sleep(1);

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form[1]/div/div[5]/div[1]/div[2]/div[5]/div/input[2]"))).click();
            TimeUnit.SECONDS.sleep(4);

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div[7]/div/div/input[2]"))).click();
            TimeUnit.SECONDS.sleep(4);

            driver.switchTo().defaultContent();
            try {
                if (driver.findElement(By.xpath("//span[contains(text(),'Kauf leider fehlgeschlagen!')]")).getText().equals("Kauf leider fehlgeschlagen!")) {
                    driver.quit();
                    Assert.fail("Paying failure during payment for license.");
                }
            } catch (Exception e) {

            }
        }
        driver.quit();
        driver = null;
    }
}