import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.placements.DeletePlacementPage;

import java.io.IOException;

public class DeletePlacement extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void createOrganisation() throws IOException {
        login();

        loadProps();
        DeletePlacementPage deletePlacementPage = new DeletePlacementPage(driver);

        deletePlacementPage.editPlacement().click();

    }

    @AfterTest
    public void closeBrowser() {
        driver = null;
    }
}
