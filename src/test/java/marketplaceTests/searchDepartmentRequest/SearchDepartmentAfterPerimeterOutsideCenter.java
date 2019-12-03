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

public class SearchDepartmentAfterPerimeterOutsideCenter extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void searchDepartmentAfterPerimeterOutsideCenter() throws InterruptedException {
        SearchDepartmentPage searchDepartmentPage = new SearchDepartmentPage(driver);
        TimeUnit.SECONDS.sleep(2);

        searchDepartmentPage.searchDepartmentTitle().click();
        TimeUnit.SECONDS.sleep(2);
        int[] plzPerimeterMoreToBorder = {10999, 10117, 13189, 10247, 13159, 13125, 12623, 12559, 12307, 14165, 13591, 13465};
        int testIfFailure = 0;

        searchDepartmentPage.location().sendKeys("Berlin");
        searchDepartmentPage.departmentName().sendKeys("EinNameDerNichtSoEinFachZuFindenSeinSoll");
        TimeUnit.SECONDS.sleep(2);
        searchDepartmentPage.selectPerimeter().click();
        TimeUnit.SECONDS.sleep(2);
        searchDepartmentPage.selectPerimeterOption50().click();
        TimeUnit.SECONDS.sleep(2);

        for (int card = 1; card < 5; card++) {
            int tr = 0;
            WebElement cardElement = driver.findElement(By.xpath("//ul[@class='tab-bar nav nav-tabs']//li[" + card + "]"));
            cardElement.click();
            searchDepartmentPage.searchDepartment().click();
            TimeUnit.SECONDS.sleep(4);

            while (true) {
                try {
                    tr = tr + 1;

                    WebElement postalCodeResults = driver.findElement(By.xpath("//tr[" + tr + "]//td[1]//div[1]//div[2]//div[1]//div[3]//div[2]"));

                    for (int array = 0; array < plzPerimeterMoreToBorder.length; array++) {
                        if (postalCodeResults.getText().equals(plzPerimeterMoreToBorder[array] + " Berlin")) {
                            System.out.println(postalCodeResults.getText());
                            System.out.println(plzPerimeterMoreToBorder[array] + " Berlin");
                            testIfFailure = testIfFailure + 1;
                            break;
                        }

                        if (testIfFailure == 12) {
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
            if (testIfFailure == 12) {
                testIfFailure = testIfFailure - 12;
            } else {
                Assert.fail("We found more/less places than expected(Expected places: 12): " + testIfFailure + " in Card No:" + card);
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
