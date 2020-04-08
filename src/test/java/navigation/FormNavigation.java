package navigation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.navigation.FormNavigationPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FormNavigation extends BaseClass {
    @Test
    public void formNavigation() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            System.out.println("hallooo");

            FormNavigationPage formNavigationPage = new FormNavigationPage(driver);
            TimeUnit.SECONDS.sleep(4);
            accessAllCookies(driver);

            //navigate to signup form
            formNavigationPage.navToRegister().click();
            System.out.println("have clicked on register");
            TimeUnit.SECONDS.sleep(2);
            if (!formNavigationPage.signupButton().getText().equals("Registrieren")) {
                driver.close();
                Assert.fail("not on signup page");
            }

            //navigate to login form
            formNavigationPage.navToLogin().click();
            if (!formNavigationPage.loginButton().getText().equals("Anmelden")) {
                driver.close();
                Assert.fail("not on login page");
            }

        }
        driver.close();
        driver = null;
    }
}
