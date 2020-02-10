package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import pageObjects.departments.EditOrganisationPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EditOrganisation extends BaseClass {
    @Test()
    public void editAllOrganisation() throws InterruptedException, IOException {
        initializeBrowser();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            EditOrganisationPage editOrganisationPage = new EditOrganisationPage(driver);
            DepartmentPage departmentPage = new DepartmentPage(driver);

            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);
            WebDriverWait wait = new WebDriverWait(driver, 20);

            try {
                departmentPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card wird geklickt.");
            }

            int x = 1;
            while (getCount() >= x) {
                TimeUnit.SECONDS.sleep(2);
                String xpath = "//section[@class='Department']//tr[" + x + "]//td[@class='actions']//a[@class='edit']";
                WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                findTr.click();
                TimeUnit.SECONDS.sleep(2);

                editOrganisationPage.changeName().clear();
                editOrganisationPage.changeName().sendKeys(prop.getProperty("edit"));
                WebElement findElem = wait.until(ExpectedConditions.elementToBeClickable(editOrganisationPage.saveClick()));
                findElem.click();
                TimeUnit.SECONDS.sleep(2);
                try {
                    departmentPage.addDepartmentCard().click();
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    System.out.println("Card wird geklickt.");
                }
                x++;
            }
            TimeUnit.SECONDS.sleep(2);
        }
        logout();
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
        driver = null;
    }
}
