package user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.user.RegisterPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MulRegister extends BaseClass {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
    }

    @Test
    public void register() throws IOException, InterruptedException {
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {

            RegisterPage registerPage = new RegisterPage(driver);

            TimeUnit.SECONDS.sleep(2);
            registerPage.registerButtonHomepage().click();
            TimeUnit.SECONDS.sleep(2);

            registerPage.siteCompany().sendKeys(prop.getProperty("registerSiteCompany") + i);
            registerPage.streetAddress().sendKeys(prop.getProperty("streetAddress"));
            registerPage.streetNumber().sendKeys(prop.getProperty("streetNumber"));
            registerPage.postalCode().sendKeys(prop.getProperty("postalCode"));
            registerPage.city().sendKeys(prop.getProperty("city"));
            registerPage.siteName().sendKeys(prop.getProperty("registerSiteName") + i);

            registerPage.umbrellaOrganisation().click();
            registerPage.umbrellaOrganisationChosen().click();

            registerPage.contactSalutation().click();
            registerPage.contactSalutationMale().click();

            registerPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName") + i);
            registerPage.contactLastName().sendKeys(prop.getProperty("contactLastName") + i);
            registerPage.contactEmail().sendKeys(prop.getProperty("contactEmail") + i);
            registerPage.contactPhone().sendKeys(prop.getProperty("contactPhone"));
            registerPage.accountFirstPassword().sendKeys(prop.getProperty("contactPassword"));
            registerPage.accountSecondPassword().sendKeys(prop.getProperty("contactPassword"));
            registerPage.accountPremiumCode().sendKeys(prop.getProperty("accountPremiumCode"));
            registerPage.accept().click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            registerPage.registerSubmit().click();
        }
        log.info("Successfully Register for a mul account");
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
