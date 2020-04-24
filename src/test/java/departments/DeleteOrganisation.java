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
    public void deleteAllOrganisation() throws IOException {
        initializeBrowser();
        accessAllCookies(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            DeleteOrganisationPage deleteOrganisationPage = new DeleteOrganisationPage(driver);
            DepartmentPage departmentPage = new DepartmentPage(driver);

            loginLoop(i);

            try {
                departmentPage.addDepartmentCard().click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            WebDriverWait wait = new WebDriverWait(driver, 20);
            while (getCount() != 0) {
                try {
                    String xpath = "//a[@id='delete-button-0']";
                    WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                    findTr.click();
                    WebElement findElem = wait.until(ExpectedConditions.elementToBeClickable(deleteOrganisationPage.deleteClick()));
                    findElem.click();
                    TimeUnit.SECONDS.sleep(4);
                } catch (Exception e) {
                    System.out.println("Departmentanzahl= " + getCount());
                    break;
                }

                try {
                    departmentPage.addDepartmentCard().click();
                } catch (Exception e) {
                    System.out.println("Card will be clicked.");
                }
            }
        }
        driver.quit();
    }
}
