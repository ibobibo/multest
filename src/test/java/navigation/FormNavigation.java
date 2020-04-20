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
            FormNavigationPage formNavigationPage = new FormNavigationPage(driver);

            //navigate to signup form
            formNavigationPage.navToRegister().click();
            TimeUnit.SECONDS.sleep(4);
            if (!formNavigationPage.signupButton().getText().equals("Registrieren")) {
                driver.quit();
                Assert.fail("not on signup page");
            }

            //navigate to login form
            formNavigationPage.navToLogin().click();
            TimeUnit.SECONDS.sleep(4);
            if (!formNavigationPage.loginButton().getText().equals("Anmelden")) {
                driver.quit();
                Assert.fail("not on login page");
            }
        }
        driver.quit();
    }
}
