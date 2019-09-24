package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.DeleteOrganisationPage;
import resources.MulLogin;

import java.io.IOException;

public class DeleteOrganisation extends MulLogin {

    @Override
    public int getCount() {
        return super.getCount();
    }

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test()
    public void deleteAllOrganisation() {
        DeleteOrganisationPage deleteOrganisationPage = new DeleteOrganisationPage(driver);
        login();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        while (getCount() != 0) {
            String xpath = "//tr[" + 1 + "]/td[6]//div[1]//a[2]";
            WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            findTr.click();
            WebElement findElem = wait.until(ExpectedConditions.elementToBeClickable(deleteOrganisationPage.deleteClick()));
            findElem.click();
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
