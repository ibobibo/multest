package license;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.license.LicensePageobject;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LicenseTest extends BaseClass {
    @Test()
    public void licenseTests() throws InterruptedException, IOException {
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
            licensePageobject.secondDepartmentAddLicense().click();
            TimeUnit.SECONDS.sleep(1);
            String firstPrice = licensePageobject.priceTextOfFirstElem().getText();
            String soppingCartFirstElem = licensePageobject.shoppingCartFirstElem().getText();
            String secondPrice = licensePageobject.priceTextOfSecondElem().getText();
            String soppingCartSecondElem = licensePageobject.shoppingCartSecondElem().getText();

            //checks if the prices are correct
            String[] partsOfString = firstPrice.split("jetzt für 12 Monate buchen für ");

            if (soppingCartFirstElem == partsOfString[1]) {
                continue;
            } else {
                Assert.fail(partsOfString[1] + " isn't equal to " + soppingCartFirstElem);
            }

            if (secondPrice == soppingCartSecondElem) {
                continue;
            } else {
                Assert.fail(soppingCartSecondElem + " isn't equal to " + secondPrice);
            }

            if (licensePageobject.priceOfBothElems().getText().equals("599,76 €")) {
            } else {
                Assert.fail(licensePageobject.priceOfBothElems().getText() + " isn't equal to 599,76 €");
            }

            if (licensePageobject.taxesOfUniqueElems().getText().equals("113,96 €")) {
            } else {
                Assert.fail(licensePageobject.taxesOfUniqueElems().getText() + " isn't equal to 113,96 €");
            }

            if (licensePageobject.wholePrice().getText().equals("713,72 €")) {
            } else {
                Assert.fail(licensePageobject.wholePrice().getText() + " isn't equal to 713,72 €");
            }

            licensePageobject.firstDepartmentRemoveLicense().click();
            TimeUnit.SECONDS.sleep(1);
            licensePageobject.secondDepartmentRemoveLicense().click();
            TimeUnit.SECONDS.sleep(1);
            logout();
        }
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
        driver = null;
    }
}
