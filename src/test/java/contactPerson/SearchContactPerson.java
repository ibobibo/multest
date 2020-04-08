package contactPerson;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.contactPerson.SearchContactPersonPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchContactPerson extends BaseClass {
    @Test()
    public void searchContactPerson() throws InterruptedException, IOException {
        initializeBrowser();
        accessAllCookies(driver);

        SearchContactPersonPage searchContactPersonPage = new SearchContactPersonPage(driver);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {

            loginLoop(i);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            try {
                searchContactPersonPage.addContactPersonCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            for (int loop = 1; loop <= 3; loop++) {
                if (loop == 1) {
                    searchContactPersonPage.searchField().clear();
                    searchContactPersonPage.searchField().sendKeys(prop.getProperty("contactFirstName1"));
                    searchContactPersonPage.searchButton().click();
                    TimeUnit.SECONDS.sleep(2);
                    try {
                        searchContactPersonPage.resultFromSearchAlpha().getText().contains(prop.getProperty("contactFirstName1"));
                    } catch (Exception e) {
                        driver.close();
                        Assert.fail("Suche ergab kein Ergebnis");
                    }
                } else if (loop == 2) {
                    searchContactPersonPage.searchField().clear();
                    searchContactPersonPage.searchField().sendKeys(prop.getProperty("contactFirstName2"));
                    searchContactPersonPage.searchButton().click();
                    TimeUnit.SECONDS.sleep(2);
                    try {
                        searchContactPersonPage.resultFromSearchBeta().getText().contains(prop.getProperty("contactFirstName2"));
                    } catch (Exception e) {
                        driver.close();
                        Assert.fail("Suche ergab kein Ergebnis");
                    }
                } else if (loop == 3) {
                    searchContactPersonPage.searchField().clear();
                    searchContactPersonPage.searchField().sendKeys(prop.getProperty("contactFirstName3"));
                    searchContactPersonPage.searchButton().click();
                    TimeUnit.SECONDS.sleep(2);
                    try {
                        searchContactPersonPage.resultFromSearchGamma().getText().contains(prop.getProperty("contactFirstName3"));
                    } catch (Exception e) {
                        driver.close();
                        Assert.fail("Suche ergab kein Ergebnis");
                    }
                }
            }
            TimeUnit.SECONDS.sleep(2);
        }
        logout();
        TimeUnit.SECONDS.sleep(2);
        driver.close();
        driver = null;
    }
}
