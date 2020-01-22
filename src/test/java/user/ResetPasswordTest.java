package user;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.user.ResetPasswordPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ResetPasswordTest extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void resetPassword() throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
            resetPasswordPage.getNewPassword().click();
            TimeUnit.SECONDS.sleep(1);
            resetPasswordPage.email().sendKeys(prop.getProperty("contactEmail") + i);
            TimeUnit.SECONDS.sleep(1);
            resetPasswordPage.resetPassword().click();
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}