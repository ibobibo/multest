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

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            CopyDepartmentPage copyDepartmentPage = new CopyDepartmentPage(driver);
            DepartmentPage departmentPage = new DepartmentPage(driver);
            loginLoop(i);

            try {
                departmentPage.addDepartmentCard().click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }
            copyDepartmentPage.addCopyOfDepartment().click();
        }
        logout();
        driver.quit();
    }
}
