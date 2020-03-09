package license;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.license.LicensePageobject;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GetLicenseFromHomepage extends BaseClass {
    @Test()
    public void clickLicenseFromHomepage() throws InterruptedException, IOException {
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
            if (!licensePageobject.checkIfTrial().getText().equals("Kostenlose Premiumversion")) {
                Assert.fail("'Kostenlose Premiumversion' isn't displayed");
            }
            TimeUnit.SECONDS.sleep(1);
            licensePageobject.navToLicensePage().click();
            TimeUnit.SECONDS.sleep(1);
            if (!licensePageobject.checkIfLicensePage().getText().equals("Premium-Lizenzen")) {
                Assert.fail("'Premium-Lizenzen' isn't displayed");
            }
            logout();
        }
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
        driver = null;
    }
}
