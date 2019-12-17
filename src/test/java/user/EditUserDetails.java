package user;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.user.EditUserDetailsPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EditUserDetails extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void editUserDetails() throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            EditUserDetailsPage editUserDetailsPage = new EditUserDetailsPage(driver);
            TimeUnit.SECONDS.sleep(2);
            editUserDetailsPage.accountMenu().click();
            editUserDetailsPage.accountMenuSettings().click();
            editUserDetailsPage.firstName().clear();
            editUserDetailsPage.firstName().sendKeys("abc");
            editUserDetailsPage.lastName().clear();
            editUserDetailsPage.lastName().sendKeys("def");
            editUserDetailsPage.mail().clear();
            editUserDetailsPage.mail().sendKeys(prop.getProperty("contactEmail") + "Edited");
            editUserDetailsPage.phone().clear();
            editUserDetailsPage.phone().sendKeys("12345678Edited");
            editUserDetailsPage.submitButton().click();
            TimeUnit.SECONDS.sleep(2);
            logout();
            TimeUnit.SECONDS.sleep(2);
            login(prop.getProperty("contactEmail")+"Edited",prop.getProperty("contactPassword"));
            TimeUnit.SECONDS.sleep(2);
            editUserDetailsPage.accountMenu().click();
            editUserDetailsPage.accountMenuSettings().click();
            editUserDetailsPage.firstName().clear();
            editUserDetailsPage.firstName().sendKeys(prop.getProperty("contactFirstName"));
            editUserDetailsPage.lastName().clear();
            editUserDetailsPage.lastName().sendKeys(prop.getProperty("contactLastName"));
            editUserDetailsPage.mail().clear();
            editUserDetailsPage.mail().sendKeys(prop.getProperty("contactEmail") + i);
            editUserDetailsPage.phone().clear();
            editUserDetailsPage.phone().sendKeys(prop.getProperty("contactPhone"));
            editUserDetailsPage.submitButton().click();
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}