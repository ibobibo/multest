package user;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.user.EditUserDetailsPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ResetPasswordTest extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void resetPassword() throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            EditUserDetailsPage editUserDetailsPage = new EditUserDetailsPage(driver);
            TimeUnit.SECONDS.sleep(2);
            login(prop.getProperty("contactEmail") + i, prop.getProperty("contactNewPassword"));
            TimeUnit.SECONDS.sleep(3);
            editUserDetailsPage.accountMenu().click();
            editUserDetailsPage.passwordMenuSettings().click();
            TimeUnit.SECONDS.sleep(1);
            editUserDetailsPage.currentPassword().sendKeys(prop.getProperty("contactNewPassword"));
            editUserDetailsPage.newPassword().sendKeys(prop.getProperty("contactPassword"));
            editUserDetailsPage.newPasswordRepeat().sendKeys(prop.getProperty("contactPassword"));
            editUserDetailsPage.submitButton().click();
            TimeUnit.SECONDS.sleep(2);
            logout();
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}