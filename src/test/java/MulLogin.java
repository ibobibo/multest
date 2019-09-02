import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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

    @Test(dataProvider = "getData")
    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.username().sendKeys(username);
        loginPage.password().sendKeys(password);
        loginPage.anmelden().click();
        log.info("Successfully Log in with a mul account");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
        //0th row
        data[0][0] = "a@a.a";
        data[0][1] = "aaaaa";

        return data;
    }
}
