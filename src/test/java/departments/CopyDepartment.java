package departments;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.CopyDepartmentPage;
import pageObjects.departments.DepartmentPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyDepartment extends MulLoginLogout {

    @Override
    public int getCount() {
        return super.getCount();
    }

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test()
    public void editAllOrganisation() throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            CopyDepartmentPage copyDepartmentPage = new CopyDepartmentPage(driver);
            DepartmentPage departmentPage = new DepartmentPage(driver);

            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);

            try {
                departmentPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card wird geklickt.");
            }

            String departmentName = copyDepartmentPage.departmentName().getText();
            copyDepartmentPage.addCopyOfDepartment().click();
            String copiedDepartmentName = copyDepartmentPage.copiedDepartmentName().getText();
            String x = departmentName + " - Kopie";
            if (x.equals(copiedDepartmentName)) {

            } else {
                System.out.println(x);
                System.out.println(copiedDepartmentName);
                Assert.fail("Department konnte nicht kopiert werden.");
            }

            TimeUnit.SECONDS.sleep(2);
        }
        logout();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
