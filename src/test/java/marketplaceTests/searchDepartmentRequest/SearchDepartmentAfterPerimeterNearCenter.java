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

public class SearchDepartmentAfterPerimeterNearCenter extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void searchDepartmentAfterPerimeterNearCenter() throws InterruptedException {
        SearchDepartmentPage searchDepartmentPage = new SearchDepartmentPage(driver);
        TimeUnit.SECONDS.sleep(2);

        searchDepartmentPage.searchDepartmentTitle().click();
        TimeUnit.SECONDS.sleep(2);
        int[] plzPerimeterCentral = {13189, 10999, 10247};
        int testIfFailure = 0;

        searchDepartmentPage.location().sendKeys("Berlin");
        TimeUnit.SECONDS.sleep(2);
        searchDepartmentPage.selectPerimeter().click();
        TimeUnit.SECONDS.sleep(2);
        searchDepartmentPage.selectPerimeterOption5().click();
        TimeUnit.SECONDS.sleep(2);

        int tr = 1;

        for (int card = 1; card < 5; card++) {
            WebElement cardElement = driver.findElement(By.xpath("//ul[@class='tab-bar nav nav-tabs']//li[" + card + "]"));
            cardElement.click();
            searchDepartmentPage.searchDepartment().click();
            TimeUnit.SECONDS.sleep(4);

            while (true) {
                try {
                    tr = tr + 1;
                    try {
                        WebElement skipSecondElem = driver.findElement(By.xpath("//div[contains(text(),'Sinas Altersgerechtes Wohnangebot')]"));
                        if (skipSecondElem.isDisplayed()) {
                            System.out.println("skip sinas elem");
                            tr = tr + 1;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        WebElement skipFirstElem = driver.findElement(By.xpath("//div[contains(text(),'Sinas Pflegeheim')]"));
                        if (skipFirstElem.isDisplayed()) {
                            System.out.println("skip sinas elem");
                            tr = tr + 1;
                        }
                    } catch (Exception e) {
                    }
                    WebElement postalCodeResults = driver.findElement(By.xpath("//tr[" + tr + "]//td[1]//div[1]//div[2]//div[1]//div[3]//div[2]"));

                    for (int array = 0; array < plzPerimeterCentral.length; array++) {
                        if (postalCodeResults.getText().equals(plzPerimeterCentral[array] + " Berlin")) {
                            testIfFailure = testIfFailure + 1;
                            break;
                        }

                        if (testIfFailure == 3) {
                            System.out.println("breakTest");
                            break;
                        }
                    }
                    try {
                        WebElement skipSecondElem = driver.findElement(By.xpath("//div[contains(text(),'Sinas Altersgerechtes Wohnangebot')]"));
                        if (skipSecondElem.isDisplayed()) {
                            System.out.println("skip sinas elem");
                            tr = tr - 1;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        WebElement skipFirstElem = driver.findElement(By.xpath("//div[contains(text(),'Sinas Pflegeheim')]"));
                        if (skipFirstElem.isDisplayed()) {
                            System.out.println("skip sinas elem");
                            tr = tr - 1;
                        }
                    } catch (Exception e) {
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
                    tr = 0;
                    break;
                }
            }
            if (testIfFailure == 3) {
                testIfFailure = testIfFailure - 3;
            } else {
                Assert.fail("We found more/less places than expected(Expected places: 3): " + testIfFailure + " in Card No:" + card);
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}

