import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AmbulantOrganisationPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateAmbulantOrganisation extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void createOrganisation() throws IOException {
        loadProps();
        AmbulantOrganisationPage registerPage = new AmbulantOrganisationPage(driver);

        login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        registerPage.addDepartment().click();
        registerPage.addAmbulantDepartment().click();

    }

    @AfterTest
    public void closeBrowser() {
        driver = null;
    }
}
