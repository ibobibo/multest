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

public class LicensePaymentCreditCardTest extends BaseClass {
    @Test()
    public void payWithCreditCardForLicense() throws InterruptedException, IOException {
        initializeBrowser();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            LicensePageobject licensePageobject = new LicensePageobject(driver);
            loginLoop(i);
            licensePageobject.licenseNavbar().click();
            licensePageobject.secondDepartmentAddLicense().click();
            licensePageobject.checkboxForConfirmation().click();
            licensePageobject.continueToPayment().click();

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='checkout-frame']")));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='payment_formula_checkout_page']/div/div[6]/div[2]/div[1]/div[2]/img"))).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='card_holder']"))).clear();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='card_holder']"))).sendKeys("Max Musterman");
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cc_no']"))).sendKeys("4200000000000000");
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cc_exp_month']"))).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'01')]"))).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cc_exp_year']"))).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'2021')]"))).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cvc']"))).sendKeys("123");
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='payment_formula_checkout_page']/div/div[6]/div[2]/div[2]/div[6]/div/input[2]"))).click();
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
