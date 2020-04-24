package license;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.license.LicensePageobject;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CountDepartments extends BaseClass {
    int departmentCount = 0;

    @Test()
    public void countDepartments() throws InterruptedException, IOException {
        initializeBrowser();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            LicensePageobject licensePageobject = new LicensePageobject(driver);
            loginLoop(i);
            licensePageobject.showDepartments().click();
            int x = 1;
            while (true) {
                try {
                    if (driver.findElement(By.xpath("//div[contains(@class,'tab-pane active')]//tr[" + x + "]//td[1]")).isDisplayed()) {
                        departmentCount = departmentCount + 1;
                        x++;
                    }
                } catch (Exception e) {
                    break;
                }
            }
            licensePageobject.licenseNavbar().click();
            String departmentCountLicensePage = licensePageobject.countDepartmentsInLicensePage().getText().split("( [A-Z])\\w+")[0];
            String departmentCountConvert = String.valueOf(departmentCount);
            if (!departmentCountLicensePage.equals(departmentCountConvert)) {
                driver.close();
                Assert.fail(departmentCountLicensePage + " isn't equal to " + departmentCountConvert);
            }
        }
        logout();
        driver.quit();
    }
}
