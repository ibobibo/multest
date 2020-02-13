package user;

import org.testng.annotations.Test;
import pageObjectsMarketplace.user.EditUserDetailsPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PasswordChangeTest extends BaseClass {
    @Test
    public void changePasswordTest() throws InterruptedException, IOException {
        initializeBrowser();
        try {
            accessAllCookies(driver);
        } catch (Exception e) {
            System.out.println("cookies accepted through register class");
        }

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            EditUserDetailsPage editUserDetailsPage = new EditUserDetailsPage(driver);
            TimeUnit.SECONDS.sleep(2);
            editUserDetailsPage.accountMenu().click();
            editUserDetailsPage.passwordMenuSettings().click();
            TimeUnit.SECONDS.sleep(1);
            editUserDetailsPage.currentPassword().sendKeys(prop.getProperty("contactPassword"));
            editUserDetailsPage.newPassword().sendKeys(prop.getProperty("contactNewPassword"));
            editUserDetailsPage.newPasswordRepeat().sendKeys(prop.getProperty("contactNewPassword"));
            editUserDetailsPage.submitButton().click();
            TimeUnit.SECONDS.sleep(2);
            logout();
        }
        driver.quit();
        driver = null;
    }
}