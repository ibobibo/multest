package departments;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginLogout extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void loginLogout() throws IOException, InterruptedException {
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);
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
