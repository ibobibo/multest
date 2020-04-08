package marketplaceTests.user;

import org.testng.annotations.Test;
import pageObjectsMarketplace.user.RegisterOnMarketplacePage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MarketplaceRegister extends BaseClass {
    @Test
    public void registerOnMarketplace() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(4);
        loadProps();
        RegisterOnMarketplacePage registerOnMarketplacePage = new RegisterOnMarketplacePage(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            try {
                TimeUnit.SECONDS.sleep(4);
                registerOnMarketplacePage.loginButtonMarketplace().click();
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println("dont need it");
            }
            TimeUnit.SECONDS.sleep(4);
            registerOnMarketplacePage.registerButtonMarketplace().click();
            TimeUnit.SECONDS.sleep(4);
            accessAllCookies(driver);

            registerOnMarketplacePage.accountLogin().sendKeys(prop.getProperty("marketPlaceName"));
            registerOnMarketplacePage.accountEmail().sendKeys(prop.getProperty("marketPlaceEmail"));
            registerOnMarketplacePage.firstPassword().sendKeys(prop.getProperty("marketPlacePassword"));
            registerOnMarketplacePage.secondPassword().sendKeys(prop.getProperty("marketPlacePassword"));
            registerOnMarketplacePage.accountPhone().sendKeys(prop.getProperty("marketPlacePhone"));

            TimeUnit.SECONDS.sleep(1);
            registerOnMarketplacePage.accept().click();

            TimeUnit.SECONDS.sleep(1);
            registerOnMarketplacePage.registerSubmit().click();
            TimeUnit.SECONDS.sleep(1);
        }
        driver.close();
        driver = null;
    }
}
