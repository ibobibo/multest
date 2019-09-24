package placements;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.placements.DeletePlacementPage;
import resources.MulLogin;

import java.io.IOException;

public class DeletePlacement extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void deletePlacement() throws IOException {
        login();

        loadProps();
        DeletePlacementPage deletePlacementPage = new DeletePlacementPage(driver);

//        while (deletePlacementPage.editPlacement().isDisplayed()) {
        deletePlacementPage.editPlacement().click();
        deletePlacementPage.deletePlacement().click();
        deletePlacementPage.acceptDelete().click();
//        }
    }

    @AfterTest
    public void closeBrowser() {
        driver = null;
    }
}
