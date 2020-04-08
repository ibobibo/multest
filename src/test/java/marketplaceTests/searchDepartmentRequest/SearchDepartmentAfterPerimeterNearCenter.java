package marketplaceTests.searchDepartmentRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.searchDepartmentRequest.SearchDepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchDepartmentAfterPerimeterNearCenter extends BaseClass {
    @BeforeTest
    public void freeDriver() {
        //cleanUp();
    }

    @Test
    public void searchDepartmentAfterPerimeterNearCenter() throws InterruptedException, IOException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies(driver);


        SearchDepartmentPage searchDepartmentPage = new SearchDepartmentPage(driver);
        searchDepartmentPage.searchDepartmentTitle().click();
        TimeUnit.SECONDS.sleep(2);

        int[] plzPerimeterCentral = {13189, 10999, 10247, 13159, 10117};
        int testIfFailure = 0;

        searchDepartmentPage.location().sendKeys("Berlin");
        searchDepartmentPage.departmentName().sendKeys("EinNameDerNichtSoEinFachZuFindenSeinSoll");
        TimeUnit.SECONDS.sleep(2);
        searchDepartmentPage.selectPerimeter().click();
        TimeUnit.SECONDS.sleep(2);
        searchDepartmentPage.selectPerimeterOption5().click();
        TimeUnit.SECONDS.sleep(2);

        for (int card = 1; card < 5; card++) {
            int tr = 0;
            WebElement cardElement = driver.findElement(By.xpath("//ul[@class='tab-bar nav nav-tabs']//li[" + card + "]"));
            cardElement.click();
            searchDepartmentPage.searchDepartment().click();
            TimeUnit.SECONDS.sleep(2);

            while (true) {
                try {
                    tr = tr + 1;
                    WebElement postalCodeResults = driver.findElement(By.xpath("//tr[" + tr + "]//td[1]//div[1]//div[2]//div[1]//div[3]//div[2]"));

                    for (int array = 0; array < plzPerimeterCentral.length; array++) {
                        if (postalCodeResults.getText().equals(plzPerimeterCentral[array] + " Berlin")) {
                            testIfFailure = testIfFailure + 1;
                            break;
                        }
                        if (testIfFailure == 5) {
                            System.out.println("breakTest");
                            break;
                        }
                    }

                    if ((tr % 10) == 0) {
                        tr = 0;
                        try {
                            searchDepartmentPage.nextPage().click();
                            TimeUnit.SECONDS.sleep(2);
                        } catch (Exception e) {
                            System.out.println("there is no next page");
                            break;
                        }
                    }
                } catch (Exception e) {
                    break;
                }
            }
            if (testIfFailure == 5) {
                tr = 0;
                testIfFailure = testIfFailure - 5;
            } else {
                driver.close();
                Assert.fail("We found more/less places than expected(Expected places: 5): " + testIfFailure + " in Card No:" + card);
            }
        }
        driver.close();
        driver = null;
    }
}

