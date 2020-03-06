package placements;

import org.testng.annotations.Test;
import pageObjects.placements.DeletePlacementPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeletePlacement extends BaseClass {
    @Test
    public void deleteAccount() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies(driver);

        loadProps();
        DeletePlacementPage deletePlacementPage = new DeletePlacementPage(driver);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);
            deletePlacementPage.editPlacement().click();
            deletePlacementPage.deletePlacement().click();
            deletePlacementPage.acceptDelete().click();
            TimeUnit.SECONDS.sleep(3);
        }
        driver.quit();
        driver = null;
    }
}
