package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.AcceptMeetingPage;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AcceptMeeting extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(1);
    }

    @Test()
    public void acceptMeeting() throws InterruptedException {
        AcceptMeetingPage acceptMeetingPage = new AcceptMeetingPage(driver);
        DepartmentPage departmentPage = new DepartmentPage(driver);
        login(prop.getProperty("anfragenTestEmail"), prop.getProperty("anfragenTestPassword"));
        TimeUnit.SECONDS.sleep(2);
        try {
            departmentPage.dashboardCard().click();
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Card wird geklickt.");
        }
        acceptMeetingPage.newRequest().click();

        int i = 1;
        while (true) {
            try {
                String xpath = "//section[@class='Workspace']//section[" + i + "]//div[1]//button[1]//span[1]";
                WebElement webElemForXpath = driver.findElement(By.xpath(xpath));
                webElemForXpath.click();
                acceptMeetingPage.labelForKindOfRes().click();
                acceptMeetingPage.timeSelectField().click();
                acceptMeetingPage.whichTime().click();
                acceptMeetingPage.textArea().sendKeys(prop.getProperty("textAreaAcceptInvite"));
                acceptMeetingPage.submit().click();
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
