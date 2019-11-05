package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.AcceptMeetingPage;
import pageObjects.departments.DeleteMeetingPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteMeeting extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test()
    public void deleteAllOrganisation() throws InterruptedException {
        DeleteMeetingPage deletetMeetingPage = new DeleteMeetingPage(driver);
        login(prop.getProperty("anfragenTestEmail"), prop.getProperty("anfragenTestPassword"));
        deletetMeetingPage.requestCount().click();

        int i = 1;
        while (true) {
            try {
                String xpath = "//body//div[@class='DepartmentRequests']//div//div[" + i + "]//div[2]//a[1]";
                WebElement webElemForXpath = driver.findElement(By.xpath(xpath));
                webElemForXpath.click();
                deletetMeetingPage.textArea().sendKeys(prop.getProperty("textAreaDiscardInvite"));
                deletetMeetingPage.submit().click();
                TimeUnit.SECONDS.sleep(6);
                i = i + 1;
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
