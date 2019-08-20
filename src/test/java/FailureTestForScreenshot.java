import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.BaseClass;

import java.io.IOException;

public class FailureTestForScreenshot extends BaseClass {
    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    @BeforeTest
    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to Homepage of MUL");
    }

    @Test()
    public void findNotExistingElem() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.notExisting().sendKeys("notExisting");
        log.info("Test will fail");
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }


}
