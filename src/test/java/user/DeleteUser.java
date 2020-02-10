package user;

import org.testng.annotations.Test;
import pageObjects.user.DeleteUserPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteUser extends BaseClass {
    @Test
    public void deleteUser() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(4);

        loadProps();
        loginAdmin();
        DeleteUserPage deleteUserPage = new DeleteUserPage(driver);
        deleteUserPage.masterManaging().click();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            TimeUnit.SECONDS.sleep(2);
            deleteUserPage.searchField().clear();
            deleteUserPage.searchField().sendKeys(prop.getProperty("contactEmail") + i);
            deleteUserPage.searchFieldButton().click();
            TimeUnit.SECONDS.sleep(2);
            deleteUserPage.deleteButton().click();
            TimeUnit.SECONDS.sleep(2);
            deleteUserPage.deleteAccess().click();
            TimeUnit.SECONDS.sleep(2);
        }
        driver.quit();
        driver = null;
    }
}
