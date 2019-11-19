package marketplaceTests.user;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.user.DeleteMarketplaceUserPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteMarketplaceUser extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void deleteMarketplaceUser() throws IOException, InterruptedException {
        loadProps();
        DeleteMarketplaceUserPage deleteMarketplaceUserPage = new DeleteMarketplaceUserPage(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(2);
            deleteMarketplaceUserPage.accountMenu().click();
            TimeUnit.SECONDS.sleep(1);
            deleteMarketplaceUserPage.accountMenuSettings().click();
            TimeUnit.SECONDS.sleep(1);
            deleteMarketplaceUserPage.deleteButton().click();
            deleteMarketplaceUserPage.deleteAccept().click();
            TimeUnit.SECONDS.sleep(3);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}