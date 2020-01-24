package marketplaceTests.meetingRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.meetingRequest.OperationsOnMeetingAsMarketplaceUserPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AnswerMeetingAsMarketplaceUser extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void askForMeeting() throws InterruptedException {
        OperationsOnMeetingAsMarketplaceUserPage operationsOnMeetingAsMarketplaceUserPage = new OperationsOnMeetingAsMarketplaceUserPage(driver);
        TimeUnit.SECONDS.sleep(2);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(3);

            operationsOnMeetingAsMarketplaceUserPage.accountMenu().click();
            operationsOnMeetingAsMarketplaceUserPage.myAccount().click();

            int x = 0;
            while (true) {
                try {
                    x = x + 1;
                    String xPathString = "//section[@class='RequestPreviewContainer']/div[@class='results']/div[" + x + "]/div[1]/div[1]/div[1]/button[1]/span[1]";
                    WebElement elemForXpath = driver.findElement(By.xpath(xPathString));
                    elemForXpath.click();
                    TimeUnit.SECONDS.sleep(1);
                    operationsOnMeetingAsMarketplaceUserPage.answerMessage().sendKeys(prop.getProperty("answerMessage"));
                    TimeUnit.SECONDS.sleep(1);
                    operationsOnMeetingAsMarketplaceUserPage.submit().click();
                } catch (Exception e) {
                    break;
                }
            }
            operationsOnMeetingAsMarketplaceUserPage.accountMenu().click();
            operationsOnMeetingAsMarketplaceUserPage.accountMenuLogout().click();
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}