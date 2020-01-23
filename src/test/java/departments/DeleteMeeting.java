package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.DeleteMeetingPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteMeeting extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(1);
    }

    @Test()
    public void deleteAllOrganisation() throws InterruptedException {
        DeleteMeetingPage deletetMeetingPage = new DeleteMeetingPage(driver);
        login(prop.getProperty("anfragenTestEmail"), prop.getProperty("anfragenTestPassword"));

        while (true) {
            try {
                String xpath = "//section[@class='Workspace']//section[1]//div[1]//button[1]//span[1]";
                WebElement webElemForXpath = driver.findElement(By.xpath(xpath));
                webElemForXpath.click();
                deletetMeetingPage.discardMeetingReqFromUser().click();
                deletetMeetingPage.textArea().sendKeys(prop.getProperty("textAreaDiscardInvite"));
                deletetMeetingPage.submit().click();
                TimeUnit.SECONDS.sleep(2);
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
