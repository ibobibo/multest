package navigation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.navigation.CheckPflegesternePage;
import resources.BaseClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CheckPflegesterne extends BaseClass {
    @Test
    public void checkPflegesternePage() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            CheckPflegesternePage checkPflegesternePage = new CheckPflegesternePage(driver);
            loginLoop(i);

            //navigate to signup form
            checkPflegesternePage.checkPflegesterneNavigation().click();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));
            TimeUnit.SECONDS.sleep(2);

            if(!driver.getCurrentUrl().contains("https://dev-pflegesterne.mitpflegeleben.de/login?user=")){
                Assert.fail("not on the right site");
            }

        }
        driver.quit();
    }
}
