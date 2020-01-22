package placements;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.placements.DeletePlacementPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeletePlacement extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void deletePlacement() throws IOException, InterruptedException {
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
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
