package license;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.license.LicensePageobject;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NavigateToLicensePageThroughDepartmentIcon extends BaseClass {
    @Test()
    public void checkIfValuesAreCorrectlyRepresented() throws InterruptedException, IOException {
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
            licensePageobject.showDepartments().click();
            TimeUnit.SECONDS.sleep(1);
            licensePageobject.navigateToLicensePageThroughDepartmentIcon().click();

            if (!licensePageobject.countElementsInBucket().getText().equals("1")) {
                driver.quit();
                Assert.fail(licensePageobject.countElementsInBucket().getText() + " isn't equal to 1");
            }

            logout();
        }
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
        driver = null;
    }
}
