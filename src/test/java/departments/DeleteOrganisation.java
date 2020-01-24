package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.departments.DeleteOrganisationPage;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteOrganisation extends BaseClass {
    @Test()
    public void deleteAllOrganisation() throws InterruptedException, IOException {
        initializeBrowser();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            DeleteOrganisationPage deleteOrganisationPage = new DeleteOrganisationPage(driver);
            DepartmentPage departmentPage = new DepartmentPage(driver);
            loginLoop(i);
            TimeUnit.SECONDS.sleep(4);

            departmentPage.addDepartmentCard().click();

            WebDriverWait wait = new WebDriverWait(driver, 20);
            while (getCount() != 0) {
                String xpath = "//section[@class='MulTable withoutSearch withoutTopElements']//tr[1]//a[@class='delete']";
                WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                System.out.println("xxx");
                findTr.click();
                System.out.println("delete click");
                WebElement findElem = wait.until(ExpectedConditions.elementToBeClickable(deleteOrganisationPage.deleteClick()));
                findElem.click();
                TimeUnit.SECONDS.sleep(2);
                try {
                    departmentPage.addDepartmentCard().click();
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    System.out.println("Card wird geklickt.");
                }
            }
            TimeUnit.SECONDS.sleep(2);
        }
        logout();
        TimeUnit.SECONDS.sleep(2);
        driver.close();
        driver = null;
    }
}
