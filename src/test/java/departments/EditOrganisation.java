package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.EditOrganisationPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EditOrganisation extends MulLoginLogout {

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
            EditOrganisationPage editOrganisationPage = new EditOrganisationPage(driver);
            loginLoop(i);
            WebDriverWait wait = new WebDriverWait(driver, 20);

            int x = 1;
            while (getCount() >= x) {
                TimeUnit.SECONDS.sleep(2);
                String xpath = "//section[@class='Department']//tr[" + x + "]//td[@class='actions']//a[@class='edit']";
                WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                findTr.click();
                TimeUnit.SECONDS.sleep(2);

                editOrganisationPage.changeName().clear();
                editOrganisationPage.changeName().sendKeys(propDepartment.getProperty("editDepartmentName"));
                WebElement findElem = wait.until(ExpectedConditions.elementToBeClickable(editOrganisationPage.saveClick()));
                findElem.click();
                x++;
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
