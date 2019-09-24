package placements;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.placements.NewPlacementPage;
import resources.MulLogin;

import java.io.IOException;

public class CreateNewPlacement extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void createNewPlacement() throws IOException {
        login();

        loadProps();
        loadPropsForPlacement();
        NewPlacementPage newPlacementPage = new NewPlacementPage(driver);

        for (int i = 0; i < 10; i++) {
            newPlacementPage.newPlacement().click();
            newPlacementPage.nameOfPlacement().sendKeys(propNewPlacement.getProperty("nameOfPlacement"));
            newPlacementPage.organisation().click();
            newPlacementPage.organisationChosen().click();
            newPlacementPage.submit().click();
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver = null;
    }
}
