package placements;

import org.testng.annotations.Test;
import pageObjects.placements.DeletePlacementPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeletePlacement extends BaseClass {
    @Test
    public void deletePlacement() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(1);

        loadProps();
        DeletePlacementPage deletePlacementPage = new DeletePlacementPage(driver);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            loginLoop(i);
            try {
                deletePlacementPage.nameField().clear();
                deletePlacementPage.passwordField().clear();
                login(prop.getProperty("contactEmail") + i, prop.getProperty("contactNewPassword"));
            } catch (Exception e) {
                System.out.println("Passwort wurde nicht verändert");
            }

            TimeUnit.SECONDS.sleep(2);
            deletePlacementPage.editPlacement().click();
            deletePlacementPage.deletePlacement().click();
            deletePlacementPage.acceptDelete().click();

            TimeUnit.SECONDS.sleep(6);
            logout();
            TimeUnit.SECONDS.sleep(2);
        }
        driver.close();
        driver = null;
    }
}
