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

public class LicenseCancelPaymentLastschriftTest extends BaseClass {
    @Test()
    public void cancelPaymentSepa() throws InterruptedException, IOException {
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
            TimeUnit.SECONDS.sleep(1);

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Lastschrift SEPA']"))).click();
            TimeUnit.SECONDS.sleep(3);
            try {
                licensePageobject.clickAccount().click();
                TimeUnit.SECONDS.sleep(1);
                new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/form[1]/div/div[6]/div[1]/div[2]/div[5]/div/input[1]"))).click();
            } catch (Exception e) {
                System.out.println("Can't cancel Payment!");
            }
            driver.switchTo().alert().accept();
            TimeUnit.SECONDS.sleep(1);
            driver.switchTo().defaultContent();

            if (!licensePageobject.checkIfBucketIsEmpty().isDisplayed()) {
                driver.close();
                Assert.fail("Canceling Payment with Sepa Lastschrift couldn't work.");
            }
        }
        driver.close();
        driver = null;
    }
}
