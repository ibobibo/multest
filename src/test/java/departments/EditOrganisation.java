package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.EditOrganisationPage;
import resources.MulLogin;

import java.io.IOException;

public class EditOrganisation extends MulLogin {

    @Override
    public int getCount() {
        return super.getCount();
    }

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
        loadPropsForDepartment();
    }

    @Test()
    public void editAllOrganisation() {
        EditOrganisationPage editOrganisationPage = new EditOrganisationPage(driver);
        login();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        int i = 1;
        while (getCount() >= i) {
            String xpath = "//section[@class='Department']//tr[" + i + "]//td[3]//a[1]";
            WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            findTr.click();

            editOrganisationPage.changeName().clear();
            editOrganisationPage.changeName().sendKeys(propDepartment.getProperty("editDepartmentName"));
            WebElement findElem = wait.until(ExpectedConditions.elementToBeClickable(editOrganisationPage.saveClick()));
            findElem.click();
            i++;
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver =null;
    }
}
