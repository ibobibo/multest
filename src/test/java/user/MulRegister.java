package user;

import org.testng.annotations.Test;
import pageObjects.user.RegisterPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MulRegister extends BaseClass {
    @Test
    public void register() throws IOException, InterruptedException {
        initializeDriver();
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {

            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.registerButtonHomepage().click();
            TimeUnit.SECONDS.sleep(2);

            registerPage.siteCompany().sendKeys(prop.getProperty("registerSiteCompany") + i);
            System.out.println("a");
            registerPage.streetAddress().sendKeys(prop.getProperty("streetAddress"));
            System.out.println("b");
            registerPage.streetNumber().sendKeys(prop.getProperty("streetNumber"));
            System.out.println("c");
            registerPage.postalCode().sendKeys(prop.getProperty("postalCode"));
            System.out.println("d");
            registerPage.city().sendKeys(prop.getProperty("city"));
            System.out.println("e");
            registerPage.siteName().sendKeys(prop.getProperty("registerSiteName") + i);
            System.out.println("f");

            registerPage.umbrellaOrganisation().click();
            registerPage.umbrellaOrganisationChosen().click();
            System.out.println("g");

            registerPage.contactSalutation().click();
            registerPage.contactSalutationMale().click();
            System.out.println("h");

            registerPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName") + i);
            System.out.println("i");
            registerPage.contactLastName().sendKeys(prop.getProperty("contactLastName") + i);
            System.out.println("j");
            registerPage.contactEmail().sendKeys(prop.getProperty("contactEmail") + i);
            System.out.println("k");
            registerPage.contactPhone().sendKeys(prop.getProperty("contactPhone"));
            System.out.println("l");
            registerPage.accountFirstPassword().sendKeys(prop.getProperty("contactPassword"));
            System.out.println("m");
            registerPage.accountSecondPassword().sendKeys(prop.getProperty("contactPassword"));
            System.out.println("n");
            registerPage.accountPremiumCode().sendKeys(prop.getProperty("accountPremiumCode"));
            System.out.println("o");

            registerPage.accept().click();
            System.out.println("p");
            TimeUnit.SECONDS.sleep(2);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            registerPage.registerSubmit().click();
            System.out.println("geschafft");
            TimeUnit.SECONDS.sleep(4);

            driver.close();
            driver = null;
        }
    }
}
