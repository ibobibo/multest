import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MulRegister extends BaseClass {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void register() {
        RegisterPage registerPage = new RegisterPage(driver);

        log.info("Successfully Log in with a mul account");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
