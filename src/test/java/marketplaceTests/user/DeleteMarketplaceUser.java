package marketplaceTests.user;

import org.testng.annotations.Test;
import pageObjectsMarketplace.user.DeleteMarketplaceUserPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteMarketplaceUser extends BaseClass {

    @Test
    public void deleteMarketplaceUser() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();

        loadProps();
        DeleteMarketplaceUserPage deleteMarketplaceUserPage = new DeleteMarketplaceUserPage(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(2);
            deleteMarketplaceUserPage.accountMenu().click();
            TimeUnit.SECONDS.sleep(2);
            deleteMarketplaceUserPage.accountMenuSettings().click();
            TimeUnit.SECONDS.sleep(2);
            deleteMarketplaceUserPage.deleteButton().click();
            TimeUnit.SECONDS.sleep(3);
            deleteMarketplaceUserPage.deleteAccept().click();
            TimeUnit.SECONDS.sleep(3);
        }
        driver.quit();
    }
}
