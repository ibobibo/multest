import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MulRegister extends BaseClass {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
    public static Properties prop = new Properties();

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test
    public void register() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.registerButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        registerPage.siteName().sendKeys(prop.getProperty("registerSiteName"));
        registerPage.umbrellaOrganisation().click();

        registerPage.contactSalutation().click();
        registerPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName"));
        registerPage.contactLastName().sendKeys(prop.getProperty("contactLastName"));
        registerPage.contactEmail().sendKeys(prop.getProperty("contactEmail"));
        registerPage.contactPhone().sendKeys(prop.getProperty("contactPhone"));
        registerPage.accountFirstPassword().sendKeys(prop.getProperty("contactPassword"));
        registerPage.accountSecondPassword().sendKeys(prop.getProperty("contactPassword"));
        registerPage.accountPremiumCode().sendKeys(prop.getProperty("accountPremiumCode"));
        registerPage.accept().click();
        registerPage.registerSubmit().click();
        //HANDLEDYNAMIC DROPDOWN !!!! VIDEO 47

        log.info("Successfully Register for a mul account");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
