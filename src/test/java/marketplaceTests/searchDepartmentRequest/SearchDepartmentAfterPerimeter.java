package marketplaceTests.searchDepartmentRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.searchDepartmentRequest.SearchDepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchDepartmentAfterPerimeter extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void searchDepartmentAfterPerimeter() throws InterruptedException {
        SearchDepartmentPage searchDepartmentPage = new SearchDepartmentPage(driver);
        TimeUnit.SECONDS.sleep(2);

        searchDepartmentPage.searchDepartmentTitle().click();
        TimeUnit.SECONDS.sleep(2);
        int[] plzPerimeterMoreToBorder = {13159, 13125, 12623, 12559, 12307, 14165, 13591, 13465, 13189, 10247, 10999, 10117};
        int[] plzPerimeterCentral = {13189, 10247, 10999, 10117};
        int testIfFailure = 0;

        for (int card = 1; card < 5; card++) {
            WebElement cardElement = driver.findElement(By.xpath("//ul[@class='tab-bar nav nav-tabs']//li[" + card + "]"));
            cardElement.click();
            for (int i = 0; i < 2; i++) {
                searchDepartmentPage.location().clear();
                searchDepartmentPage.location().sendKeys("Berlin");
                TimeUnit.SECONDS.sleep(2);
                searchDepartmentPage.selectPerimeter().click();
                TimeUnit.SECONDS.sleep(2);

                if (i == 0) {
                    searchDepartmentPage.selectPerimeterOption5().click();
                    TimeUnit.SECONDS.sleep(2);
                    searchDepartmentPage.searchDepartment().click();
                    TimeUnit.SECONDS.sleep(2);

                    int tr = 2;
                    while (true) {
                        try {
                            if ((tr % 10) == 0) {
                                searchDepartmentPage.nextPage().click();
                                TimeUnit.SECONDS.sleep(4);
                            }
                            WebElement postalCodeResults = driver.findElement(By.xpath("//tr[" + tr + "]//td[1]//div[1]//div[2]//div[1]//div[3]//div[2]"));
                            for (int array = 0; array < plzPerimeterCentral.length; array++) {
                                if (postalCodeResults.getText().equals(plzPerimeterCentral[array] + " Berlin")) {
                                    testIfFailure = testIfFailure + 1;
                                    System.out.println("testIfFailure1:" + testIfFailure);
                                    break;
                                }
                            }
                            TimeUnit.SECONDS.sleep(2);
                            if (testIfFailure == 4) {
                                System.out.println("Geklappt: " + testIfFailure);
                                testIfFailure = testIfFailure - 4;
                                break;
                            }
                            tr = tr + 1;
                        } catch (Exception e) {
                            System.out.println("Error: short test");
                            break;
                        }
                    }
                } else if (i == 1) {
                    searchDepartmentPage.selectPerimeterOption50().click();
                    TimeUnit.SECONDS.sleep(4);
                    searchDepartmentPage.searchDepartment().click();
                    TimeUnit.SECONDS.sleep(4);

                    int tr = 2;
                    while (true) {
                        try {
                            if ((tr % 10) == 0) {
                                searchDepartmentPage.nextPage().click();
                                TimeUnit.SECONDS.sleep(4);
                            }
                            WebElement postalCodeResults = driver.findElement(By.xpath("//tr[" + tr + "]//td[1]//div[1]//div[2]//div[1]//div[3]//div[2]"));
                            for (int array = 0; array < plzPerimeterMoreToBorder.length; array++) {
                                if (postalCodeResults.getText().equals(plzPerimeterMoreToBorder[array] + " Berlin")) {
                                    testIfFailure = testIfFailure + 1;
                                    System.out.println("testIfFailure2:" + testIfFailure);
                                }
                            }
                            TimeUnit.SECONDS.sleep(2);
                            if (testIfFailure == 12) {
                                System.out.println("Geklappt: " + testIfFailure);
                                testIfFailure = testIfFailure - 12;
                                break;
                            }
                            tr = tr + 1;
                        } catch (Exception e) {
                            System.out.println("Error: long test");
                            break;
                        }
                    }
                }
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
//        driver.close();
//        driver = null;
    }
}
