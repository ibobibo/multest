import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MulLogin extends BaseClass {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.username().sendKeys(prop.getProperty("loginUsername"));
        loginPage.password().sendKeys(prop.getProperty("loginPassword"));
        loginPage.anmelden().click();
        log.info("Successfully Log in with a mul account");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
