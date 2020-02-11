package user;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.DeleteUserPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteUser extends BaseClass {
    @Test
    public void checkIfUserIsDeleted() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        try {
            accessAllCookies(driver);
        } catch (Exception e) {
            System.out.println("cookies accepted through register class");
        }
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
            try {
                deleteUserPage.deleteButton().click();
                deleteUserPage.deleteAccess().click();
                Assert.fail("User isn't deleted.");
            } catch (Exception e) {
                break;
            }
        }
        driver.close();
        driver = null;
    }
}