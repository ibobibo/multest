package marketplaceTests.meetingRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjectsMarketplace.meetingRequest.OperationsOnMeetingAsMarketplaceUserPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteMeetingAsMarketplaceUser extends BaseClass {
    @Test
    public void deleteMeetingAsMarketplaceUser() throws InterruptedException, IOException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(2);
        try {
            accessAllCookies(driver);
        } catch (Exception e) {
            System.out.println("cookies accepted");
        }

        OperationsOnMeetingAsMarketplaceUserPage operationsOnMeetingAsMarketplaceUserPage = new OperationsOnMeetingAsMarketplaceUserPage(driver);
        TimeUnit.SECONDS.sleep(2);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(3);

            operationsOnMeetingAsMarketplaceUserPage.accountMenu().click();
            operationsOnMeetingAsMarketplaceUserPage.myAccount().click();

            while (true) {
                try {
                    String xPathString = "//div[@class='results']//div[1]//div[1]//div[1]//div[1]//button[2]//span[1]";
                    WebElement elemForXpath = driver.findElement(By.xpath(xPathString));
                    elemForXpath.click();
                } catch (Exception e) {
                    System.out.println("Cant delete meeting req");
                    break;
                }
            }
            TimeUnit.SECONDS.sleep(5);
            operationsOnMeetingAsMarketplaceUserPage.accountMenu().click();
            operationsOnMeetingAsMarketplaceUserPage.accountMenuLogout().click();
        }
        driver.quit();
        driver = null;
    }
}
