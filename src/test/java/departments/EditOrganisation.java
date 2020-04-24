package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

            try {
                departmentPage.addDepartmentCard().click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            int x = 0;
            while (getCount() != x) {
                String xpath = "//a[@id='edit-button-" + x + "']";
                WebElement findTr = driver.findElement(By.xpath(xpath));
                findTr.click();

                editOrganisationPage.changeName().clear();
                editOrganisationPage.changeName().sendKeys(prop.getProperty("edit"));
                editOrganisationPage.saveClick().click();

                try {
                    departmentPage.addDepartmentCard().click();
                } catch (Exception e) {
                    System.out.println("Card will be clicked.");
                }
                x++;
            }
        }
        logout();
        driver.quit();
    }
}
