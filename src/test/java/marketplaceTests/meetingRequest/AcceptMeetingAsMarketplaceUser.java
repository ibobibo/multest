package marketplaceTests.meetingRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjectsMarketplace.meetingRequest.AcceptMeetingAsMarketplaceUserPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AcceptMeetingAsMarketplaceUser extends BaseClass {
    @Test
    public void askForMeeting() throws InterruptedException, IOException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);

        AcceptMeetingAsMarketplaceUserPage acceptMeetingAsMarketplaceUserPage = new AcceptMeetingAsMarketplaceUserPage(driver);
        TimeUnit.SECONDS.sleep(2);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(3);

            int x = 0;
            while (true) {
                try {
                    x = x + 1;
                    String xPathString = "//div[@class='results']//div[" + x + "]//div[1]//div[1]//div[1]//div[1]//button[1]//span[1]";
                    WebElement elemForXpath = driver.findElement(By.xpath(xPathString));
                    elemForXpath.click();
                } catch (Exception e) {
                    System.out.println("cant accept meeting req as marketplace user");
                    break;
                }
            }
            acceptMeetingAsMarketplaceUserPage.accountMenu().click();
            acceptMeetingAsMarketplaceUserPage.accountMenuLogout().click();
        }
        driver.quit();
        driver = null;
    }
}
