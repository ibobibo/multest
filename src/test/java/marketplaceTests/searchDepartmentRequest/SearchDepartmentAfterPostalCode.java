package marketplaceTests.searchDepartmentRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.searchDepartmentRequest.SearchDepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchDepartmentAfterPostalCode extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void searchDepartmentAfterPostalCode() throws InterruptedException {
        SearchDepartmentPage searchDepartmentPage = new SearchDepartmentPage(driver);
        TimeUnit.SECONDS.sleep(2);

        searchDepartmentPage.searchDepartmentTitle().click();
        TimeUnit.SECONDS.sleep(2);
        int[] plz = {13159, 13125, 12623, 12559, 12307, 14165, 13591, 13465, 13189, 10247, 10999};
        for (int card = 1; card < 5; card++) {
            WebElement cardElement = driver.findElement(By.xpath("//ul[@class='tab-bar nav nav-tabs']//li[" + card + "]"));
            cardElement.click();
            for (int i = 0; i < plz.length; i++) {
                searchDepartmentPage.location().sendKeys(plz[i] + " Berlin");
                TimeUnit.SECONDS.sleep(2);
                searchDepartmentPage.searchDepartment().click();
                TimeUnit.SECONDS.sleep(2);
                String equalPostalCode = searchDepartmentPage.getPostalCodeOfResult().getText();
                if (!equalPostalCode.equals(plz[i] + " Berlin")) {
                    driver.quit();
                    Assert.fail("Error: " + equalPostalCode + " is not equal" + plz[i] + " Berlin in Card " + card);
                }
                TimeUnit.SECONDS.sleep(2);
                searchDepartmentPage.location().clear();
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
//        driver.quit();
//        driver = null;
    }
}
