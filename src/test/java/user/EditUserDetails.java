package user;

import org.testng.annotations.Test;
import pageObjectsMarketplace.user.EditUserDetailsPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EditUserDetails extends BaseClass {
    @Test
    public void editUserDetails() throws InterruptedException, IOException {
        initializeBrowser();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            EditUserDetailsPage editUserDetailsPage = new EditUserDetailsPage(driver);
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
            logout();
            login(prop.getProperty("contactEmail") + "Edited", prop.getProperty("contactPassword"));
            editUserDetailsPage.accountMenu().click();
            editUserDetailsPage.accountMenuSettings().click();
            editUserDetailsPage.firstName().clear();
            editUserDetailsPage.firstName().sendKeys(prop.getProperty("contactFirstName"));
            editUserDetailsPage.lastName().clear();
            editUserDetailsPage.lastName().sendKeys(prop.getProperty("contactLastName"));
            editUserDetailsPage.mail().clear();
            editUserDetailsPage.mail().sendKeys(prop.getProperty("contactEmail"));
            editUserDetailsPage.phone().clear();
            editUserDetailsPage.phone().sendKeys(prop.getProperty("contactPhone"));
            editUserDetailsPage.submitButton().click();
        }
        driver.quit();
    }
}
