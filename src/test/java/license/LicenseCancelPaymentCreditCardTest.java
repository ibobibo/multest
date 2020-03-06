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

public class LicenseCancelPaymentCreditCardTest extends BaseClass {
    @Test()
    public void cancelPaymentCreditCard() throws InterruptedException, IOException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);

        try {
            accessAllCookies(driver);
        } catch (Exception e) {
            System.out.println("cookies accepted");
        }

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
            TimeUnit.SECONDS.sleep(1);

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Kredit- / Debitkarten']"))).click();
            TimeUnit.SECONDS.sleep(2);

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form[1]/div/div[5]/div[2]/div[2]/div[6]/div/input[1]"))).click();
            driver.switchTo().alert().accept();
            TimeUnit.SECONDS.sleep(2);

            driver.switchTo().defaultContent();
            if (!licensePageobject.checkIfBucketIsEmpty().isDisplayed()) {
                Assert.fail("Canceling payment with Kredit- / Debitkarten couldn't work.");
            }
        }
        driver.quit();
        driver = null;
    }
}
