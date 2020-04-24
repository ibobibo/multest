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

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            EditUserDetailsPage editUserDetailsPage = new EditUserDetailsPage(driver);
            editUserDetailsPage.accountMenu().click();
            editUserDetailsPage.passwordMenuSettings().click();
            editUserDetailsPage.currentPassword().sendKeys(prop.getProperty("contactPassword"));
            editUserDetailsPage.newPassword().sendKeys(prop.getProperty("contactNewPassword"));
            editUserDetailsPage.newPasswordRepeat().sendKeys(prop.getProperty("contactNewPassword"));
            editUserDetailsPage.submitButton().click();
            logout();
        }
        driver.quit();
    }
}
