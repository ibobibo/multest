package user;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.DeleteUserPage;
import resources.BaseClass;

import java.io.IOException;

public class DeleteUser extends BaseClass {
    @Test
    public void checkIfUserIsDeleted() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();
        loginAdmin();
        DeleteUserPage deleteUserPage = new DeleteUserPage(driver);
        deleteUserPage.masterManaging().click();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            deleteUserPage.searchField().clear();
            deleteUserPage.searchField().sendKeys(prop.getProperty("contactEmail"));
            deleteUserPage.searchFieldButton().click();
            try {
                deleteUserPage.deleteButton().click();
                deleteUserPage.deleteAccess().click();
                driver.close();
                Assert.fail("User isn't deleted.");
            } catch (Exception e) {
                break;
            }
        }
        driver.quit();
    }
}
