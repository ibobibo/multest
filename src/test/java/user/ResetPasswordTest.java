package user;

import org.testng.annotations.Test;
import pageObjects.user.ResetPasswordPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ResetPasswordTest extends BaseClass {
    @Test
    public void resetPassword() throws InterruptedException, IOException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(5);
        loadProps();
        accessAllCookies(driver);


        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
            resetPasswordPage.getNewPassword().click();
            TimeUnit.SECONDS.sleep(3);
            resetPasswordPage.email().sendKeys(prop.getProperty("contactEmail"));
            resetPasswordPage.resetPassword().click();
        }
        driver.close();
        driver = null;
    }
}
