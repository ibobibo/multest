package user;

import org.testng.annotations.Test;
import pageObjects.user.RegisterPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MulRegister extends BaseClass {
    @Test
    public void register() throws IOException, InterruptedException {
        System.out.println("1");
        initializeBrowser();
        System.out.println("2");
        loadProps();
        System.out.println("3");
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            System.out.println("4");
            RegisterPage registerPage = new RegisterPage(driver);
            System.out.println("5");
            registerPage.registerButtonHomepage().click();
            System.out.println("6");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("7");
            registerPage.siteCompany().sendKeys(prop.getProperty("registerSiteCompany"));
            accessAllCookies(driver);
            System.out.println("8");

            registerPage.siteCompany().sendKeys(prop.getProperty("registerSiteCompany"));

            registerPage.companyForm().click();
            registerPage.companyFormChosen().click();
            System.out.println("9");

            registerPage.streetAddress().sendKeys(prop.getProperty("streetAddress"));
            registerPage.streetNumber().sendKeys(prop.getProperty("streetNumber"));
            registerPage.postalCode().sendKeys(prop.getProperty("postalCode"));
            registerPage.city().sendKeys(prop.getProperty("city"));
            System.out.println("10");
            registerPage.umbrellaOrganisation().click();
            registerPage.umbrellaOrganisationChosen().click();
            System.out.println("11");

            registerPage.contactSalutation().click();
            registerPage.contactSalutationMale().click();
            System.out.println("12");

            registerPage.contactFirstName().sendKeys(prop.getProperty("contactFirstName"));
            registerPage.contactLastName().sendKeys(prop.getProperty("contactLastName"));
            registerPage.contactEmail().sendKeys(prop.getProperty("contactEmail"));
            registerPage.contactPhone().sendKeys(prop.getProperty("contactPhone"));
            registerPage.accountFirstPassword().sendKeys(prop.getProperty("contactPassword"));
            registerPage.accountSecondPassword().sendKeys(prop.getProperty("contactPassword"));
            System.out.println("13");

            registerPage.accept().click();
            TimeUnit.SECONDS.sleep(4);
            System.out.println("14");
            registerPage.registerSubmit().click();
            System.out.println("15");
            TimeUnit.SECONDS.sleep(4);
        }
        driver.quit();
    }
}
