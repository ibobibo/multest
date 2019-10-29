import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DeleteUserPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteUser extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(4);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(4);
    }

    @Test
    public void deleteUser() throws IOException, InterruptedException {
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
    }


    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
