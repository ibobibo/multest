package resources;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginLogoutPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MulLoginLogout extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
    }

    public void login() throws InterruptedException {
        System.out.println("bin drin");
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("contactEmail"));
        loginLogoutPage.password().sendKeys(prop.getProperty("contactPassword"));
        loginLogoutPage.anmelden().click();
        TimeUnit.SECONDS.sleep(4);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void login(String anfrageNameEmail, String anfrageNamePassword) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(anfrageNameEmail);
        loginLogoutPage.password().sendKeys(anfrageNamePassword);
        TimeUnit.SECONDS.sleep(2);
        loginLogoutPage.anmelden().click();

        TimeUnit.SECONDS.sleep(2);
    }

    public void loginLoop(int i) throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        TimeUnit.SECONDS.sleep(2);
        loginLogoutPage.username().sendKeys(prop.getProperty("contactEmail") + i);
        loginLogoutPage.password().sendKeys(prop.getProperty("contactPassword"));
        TimeUnit.SECONDS.sleep(1);
        loginLogoutPage.anmelden().click();

        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void loginLoopMarketplace(int i) throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        try {
            loginLogoutPage.anmeldenButton().click();
        } catch (Exception e) {
            System.out.println("dont need it");
        }
        TimeUnit.SECONDS.sleep(1);
        loginLogoutPage.username().sendKeys(prop.getProperty("marketPlaceName") + i);
        loginLogoutPage.password().sendKeys(prop.getProperty("marketPlacePassword"));
        TimeUnit.SECONDS.sleep(3);
        loginLogoutPage.anmelden().click();
        TimeUnit.SECONDS.sleep(2);
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
