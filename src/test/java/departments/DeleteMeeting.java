package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.departments.DeleteMeetingPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteMeeting extends BaseClass {
    @Test()
    public void deleteMeeting() throws InterruptedException, IOException {
        initializeBrowser();

        DeleteMeetingPage deleteMeetingPage = new DeleteMeetingPage(driver);
        login(prop.getProperty("anfragenTestEmail"), prop.getProperty("anfragenTestPassword"));

        while (true) {
            try {
                String xpath = "//span[contains(text(),'Antworten')]";
                WebElement webElemForXpath = driver.findElement(By.xpath(xpath));
                webElemForXpath.click();
                deleteMeetingPage.discardMeetingReqFromUser().click();
                deleteMeetingPage.textArea().sendKeys(prop.getProperty("textAreaDiscardInvite"));
                deleteMeetingPage.submit().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("cant delete meeting req from user");
                break;
            }
        }
        logout();
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
    }
}
