package user;

import org.testng.annotations.Test;
import pageObjects.user.RegisterPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MulRegister extends BaseClass {
    @Test
    public void register() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {

            RegisterPage registerPage = new RegisterPage(driver);
            TimeUnit.SECONDS.sleep(2);
            registerPage.registerButtonHomepage().click();
            TimeUnit.SECONDS.sleep(2);

            accessAllCookies(driver);

            registerPage.siteCompany().sendKeys(prop.getProperty("registerSiteCompany"));

            registerPage.companyForm().click();
            registerPage.companyFormChosen().click();

            registerPage.streetAddress().sendKeys(prop.getProperty("streetAddress"));
            registerPage.streetNumber().sendKeys(prop.getProperty("streetNumber"));
            registerPage.postalCode().sendKeys(prop.getProperty("postalCode"));
            registerPage.city().sendKeys(prop.getProperty("city"));

            registerPage.umbrellaOrganisation().click();

            registerPage.contactSalutation().click();
            registerPage.contactSalutationMale().click();

            registerPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName") + i);
            registerPage.contactLastName().sendKeys(prop.getProperty("contactLastName") + i);
            registerPage.contactEmail().sendKeys(prop.getProperty("contactEmail"));
            registerPage.contactPhone().sendKeys(prop.getProperty("contactPhone"));
            registerPage.accountFirstPassword().sendKeys(prop.getProperty("contactPassword"));
            registerPage.accountSecondPassword().sendKeys(prop.getProperty("contactPassword"));

            registerPage.accept().click();
            TimeUnit.SECONDS.sleep(4);
            registerPage.registerSubmit().click();
            TimeUnit.SECONDS.sleep(4);
        }
        driver.quit();
        driver = null;
    }
}
