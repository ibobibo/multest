package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ToggleOrganisation extends BaseClass {
    @Test()
    public void toggleAllOrganisation() throws InterruptedException, IOException {
        initializeBrowser();
        accessAllCookies(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            DepartmentPage departmentPage = new DepartmentPage(driver);
            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);
            try {
                departmentPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }
            WebDriverWait wait = new WebDriverWait(driver, 20);

            int x = 1;
            while (getCount() >= x) {
                TimeUnit.SECONDS.sleep(5);

                String xpath = "//tr[" + x + "]//td[1]//label[1]";
                WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                if (findTr.isDisplayed()) {
                    findTr.click();
                }
                x++;
            }
            TimeUnit.SECONDS.sleep(6);
            logout();
            TimeUnit.SECONDS.sleep(2);
        }
        driver.quit();
        driver = null;
    }
}

