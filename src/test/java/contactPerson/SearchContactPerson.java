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
        SearchContactPersonPage searchContactPersonPage = new SearchContactPersonPage(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            try {
                searchContactPersonPage.addContactPersonCard().click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            for (int loop = 1; loop <= 3; loop++) {
                if (loop == 1) {
                    searchContactPersonPage.searchField().clear();
                    searchContactPersonPage.searchField().sendKeys(prop.getProperty("contactFirstName1"));
                    searchContactPersonPage.searchButton().click();
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
                    try {
                        searchContactPersonPage.resultFromSearchGamma().getText().contains(prop.getProperty("contactFirstName3"));
                    } catch (Exception e) {
                        driver.close();
                        Assert.fail("Suche ergab kein Ergebnis");
                    }
                }
            }
        }
        logout();
        driver.quit();
    }
}
