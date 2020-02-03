package marketplaceTests.meetingRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjectsMarketplace.meetingRequest.AskForMeetingPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AskForMeeting extends BaseClass {
    @Test
    public void askForMeeting() throws InterruptedException, IOException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);

        AskForMeetingPage askForMeetingPage = new AskForMeetingPage(driver);
        TimeUnit.SECONDS.sleep(2);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(2);
            askForMeetingPage.searchDepartmentTitle().click();
            askForMeetingPage.departmentName().sendKeys(prop.getProperty("departmentName"));
            TimeUnit.SECONDS.sleep(2);
            askForMeetingPage.searchDepartment().click();
            TimeUnit.SECONDS.sleep(2);
            askForMeetingPage.moreInformation().click();
            TimeUnit.SECONDS.sleep(2);
            askForMeetingPage.askForMeeting().click();
            //meetingType
            String meetingType = "//label[" + getRandomNumberInRange(1, 3) + "]//div[1]//div[1]";
            String meetingTypePhone = "//label[1]//div[1]//div[1]";
            WebElement whichMeetingType = driver.findElement(By.xpath(meetingType));
            whichMeetingType.click();
            TimeUnit.SECONDS.sleep(1);
            if (meetingType.equals(meetingTypePhone)) {
                askForMeetingPage.phoneNumber().sendKeys(prop.getProperty("marketPlacePhone"));
                askForMeetingPage.wishTime().click();
                askForMeetingPage.wishTimeChosen().click();
            }
            TimeUnit.SECONDS.sleep(2);
            askForMeetingPage.textAreaComment().sendKeys(prop.getProperty("textAreaComment"));
            TimeUnit.SECONDS.sleep(2);
            askForMeetingPage.next().click();
            TimeUnit.SECONDS.sleep(2);
            askForMeetingPage.accept().click();
            TimeUnit.SECONDS.sleep(2);
            askForMeetingPage.next().click();
            TimeUnit.SECONDS.sleep(6);
            askForMeetingPage.accountMenu().click();
            askForMeetingPage.accountMenuLogout().click();
        }
        driver.close();
        driver = null;
    }
}
