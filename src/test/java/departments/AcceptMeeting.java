package departments;

import org.testng.annotations.Test;
import pageObjects.departments.AcceptMeetingPage;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AcceptMeeting extends BaseClass {
    @Test()
    public void acceptMeeting() throws InterruptedException, IOException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);

        accessAllCookies(driver);

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

        System.out.println(acceptMeetingPage.answerReq().getText());
        acceptMeetingPage.answerReq().click();
        TimeUnit.SECONDS.sleep(2);

        try {
            acceptMeetingPage.answerReq().click();
        } catch (Exception e) {
            System.out.println("Antwort Button wurde geklickt.");
        }

        acceptMeetingPage.labelForKindOfRes().click();
        acceptMeetingPage.timeSelectField().click();
        acceptMeetingPage.whichTime().click();
        acceptMeetingPage.textArea().sendKeys(prop.getProperty("textAreaAcceptInvite"));
        acceptMeetingPage.submit().click();

        logout();
        TimeUnit.SECONDS.sleep(1);

        driver.quit();
        driver = null;
    }
}
