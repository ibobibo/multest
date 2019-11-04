package marketplaceTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.RegisterOnMarketplacePage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MarketplaceRegister extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void registerOnMarketplace() throws IOException, InterruptedException {
        loadProps();
        RegisterOnMarketplacePage registerOnMarketplacePage = new RegisterOnMarketplacePage(driver);


        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
                registerOnMarketplacePage.loginButtonMarketplace().click();
            } catch (Exception e) {
                System.out.println("dont need it");
            }

            TimeUnit.SECONDS.sleep(6);
            registerOnMarketplacePage.registerButtonMarketplace().click();

            registerOnMarketplacePage.accountLogin().sendKeys(prop.getProperty("marketPlaceName") + i);
            registerOnMarketplacePage.accountEmail().sendKeys(prop.getProperty("marketPlaceEmail") + i);
            registerOnMarketplacePage.firstPassword().sendKeys(prop.getProperty("marketPlacePassword"));
            registerOnMarketplacePage.secondPassword().sendKeys(prop.getProperty("marketPlacePassword"));
            registerOnMarketplacePage.accountPhone().sendKeys(prop.getProperty("marketPlacePhone"));

            TimeUnit.SECONDS.sleep(1);
            registerOnMarketplacePage.accept().click();

            TimeUnit.SECONDS.sleep(1);
            registerOnMarketplacePage.registerSubmit().click();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
