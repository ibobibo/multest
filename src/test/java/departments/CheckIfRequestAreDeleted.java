package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.CheckIfRequestAreDeletedPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckIfRequestAreDeleted extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(1);
    }

    @Test()
    public void checkIfRequestAreDeleted() throws InterruptedException {
        CheckIfRequestAreDeletedPage checkIfRequestAreDeletedPage = new CheckIfRequestAreDeletedPage(driver);
        login(prop.getProperty("anfragenTestEmail"), prop.getProperty("anfragenTestPassword"));
        checkIfRequestAreDeletedPage.requestCount().click();

        int i = 0;
        while (true) {
            try {
                i = i + 1;
                String xpath = "//body/div[@id='root']/div/div[@class='app-container admin']/div/div[@id='app-view-container']/div[@class='view-routes']/div/div[@class='DepartmentRequests']/div/div[" + i + "]/div[1]/div[1]/span";
                WebElement webElemForXpath = driver.findElement(By.xpath(xpath));
                if (webElemForXpath.getText().contains("Deleted")) {
                    Assert.fail("Deleted user found at index " + i);
                    System.out.println(i);
                }
            } catch (Exception e) {
                break;
            }
        }
        logout();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
