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

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            LicensePageobject licensePageobject = new LicensePageobject(driver);
            loginLoop(i);
            licensePageobject.licenseNavbar().click();
            licensePageobject.firstDepartmentAddLicense().click();
            licensePageobject.checkboxForConfirmation().click();
            licensePageobject.continueToPayment().click();

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='checkout-frame']")));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='payment_formula_checkout_page']/div/div[6]/div[1]/div[1]/div[2]/img"))).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_holder']"))).clear();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_holder']"))).sendKeys("Max Musterman");
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='iban']"))).sendKeys("DE24300209002411761956");
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form[1]/div/div[6]/div[1]/div[2]/div[5]/div/input[2]"))).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div[7]/div/div/input[2]"))).click();
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
    }
}
