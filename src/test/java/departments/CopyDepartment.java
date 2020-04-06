package departments;

import org.testng.annotations.Test;
import pageObjects.departments.CopyDepartmentPage;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyDepartment extends BaseClass {

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Test()
    public void copyOrganisation() throws InterruptedException, IOException {
        initializeBrowser();
        accessAllCookies(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            CopyDepartmentPage copyDepartmentPage = new CopyDepartmentPage(driver);
            DepartmentPage departmentPage = new DepartmentPage(driver);

            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);

            try {
                departmentPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            copyDepartmentPage.addCopyOfDepartment().click();
            TimeUnit.SECONDS.sleep(2);
        }
        logout();
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
        driver = null;
    }
}
