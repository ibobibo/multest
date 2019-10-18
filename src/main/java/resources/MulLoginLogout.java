package resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginLogoutPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MulLoginLogout extends BaseClass {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
    }

    public void login() throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("contactEmail"));
        loginLogoutPage.password().sendKeys(prop.getProperty("contactPassword"));
        loginLogoutPage.anmelden().click();

        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void loginLoop(int i) throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("contactEmail") + i);
        loginLogoutPage.password().sendKeys(prop.getProperty("contactPassword"));
        TimeUnit.SECONDS.sleep(1);
        loginLogoutPage.anmelden().click();

        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void loginAdmin() throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("adminName"));
        loginLogoutPage.password().sendKeys(prop.getProperty("adminPassword"));
        loginLogoutPage.anmelden().click();

        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void logout() throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.userOption().click();
        loginLogoutPage.logout().click();

        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
