package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.departments.CheckIfRequestAreDeletedPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckIfRequestAreDeleted extends BaseClass {
    @Test()
    public void checkIfRequestAreDeleted() throws InterruptedException, IOException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        try {
            accessAllCookies(driver);
        } catch (Exception e) {
            System.out.println("cookies accepted");
        }

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
        TimeUnit.SECONDS.sleep(1);

        driver.close();
        driver = null;
    }
}
