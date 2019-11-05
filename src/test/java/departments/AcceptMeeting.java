package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.AcceptMeetingPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AcceptMeeting extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test()
    public void deleteAllOrganisation() throws InterruptedException {
        AcceptMeetingPage acceptMeetingPage = new AcceptMeetingPage(driver);
        login(prop.getProperty("anfragenTestEmail"), prop.getProperty("anfragenTestPassword"));
        acceptMeetingPage.requestCount().click();

        int i = 1;
        while (true) {
            try {
                String xpath = "//body//div[@class='DepartmentRequests']//div//div[" + i + "]//div[2]//button[1]";
                WebElement webElemForXpath = driver.findElement(By.xpath(xpath));
                webElemForXpath.click();
                acceptMeetingPage.timeSelectField().click();
                acceptMeetingPage.whichTime().click();
                acceptMeetingPage.textArea().sendKeys(prop.getProperty("textAreaAcceptInvite"));
                acceptMeetingPage.submit().click();
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
