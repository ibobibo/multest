package marketplaceTests.bookmarkAndCompareDepartmentTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.bookmarkTests.CompareMarketplaceDepartmentsPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CompareMarketplaceDepartments extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void compareMarketplaceDepartments() throws IOException, InterruptedException {
        loadProps();
        CompareMarketplaceDepartmentsPage compareMarketplaceDepartments = new CompareMarketplaceDepartmentsPage(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(2);
            compareMarketplaceDepartments.clickHeaderForSearch().click();

            for (int card = 1; card < 5; card++) {
                WebElement cardElement = driver.findElement(By.xpath("//ul[@class='tab-bar nav nav-tabs']//li[" + card + "]"));
                cardElement.click();
                compareMarketplaceDepartments.location().sendKeys("Berlin");
                TimeUnit.SECONDS.sleep(2);
                compareMarketplaceDepartments.searchDepartment().click();
                TimeUnit.SECONDS.sleep(2);
                for (int c = 1; c < 5; c++) {
                    String xpathForCompareIcon = "//tr[" + c + "]" + "//section[@class='DepartmentCompareButton']//button[@class='compare ']";
                    WebElement compareButton = driver.findElement(By.xpath(xpathForCompareIcon));
                    compareButton.click();
                }
                TimeUnit.SECONDS.sleep(1);
                compareMarketplaceDepartments.location().clear();
            }
            for (int searchButton = 0; searchButton < 4; searchButton++) {
                compareMarketplaceDepartments.clickHeaderForCompare().click();
                if (searchButton == 0) {
                    compareMarketplaceDepartments.bucketButtonCompareAmbulant().click();
                    TimeUnit.SECONDS.sleep(3);
                } else if (searchButton == 1) {
                    compareMarketplaceDepartments.bucketButtonCompareStationary().click();
                    TimeUnit.SECONDS.sleep(3);
                } else if (searchButton == 2) {
                    compareMarketplaceDepartments.bucketButtonCompareDayNight().click();
                    TimeUnit.SECONDS.sleep(3);
                } else {
                    compareMarketplaceDepartments.bucketButtonCompareFairHouseOffer().click();
                    TimeUnit.SECONDS.sleep(3);
                }
            }
            for (int loop = 0; loop < 16; loop++) {
                compareMarketplaceDepartments.clickHeaderForCompare().click();
                if (loop < 4) {
                    compareMarketplaceDepartments.bucketItemAmbulant().click();
                    TimeUnit.SECONDS.sleep(1);
                } else if (loop < 8) {
                    compareMarketplaceDepartments.bucketItemStationary().click();
                    TimeUnit.SECONDS.sleep(1);
                } else if (loop < 12) {
                    compareMarketplaceDepartments.bucketItemDayNight().click();
                    TimeUnit.SECONDS.sleep(1);
                } else {
                    compareMarketplaceDepartments.bucketItemFairHouseOffer().click();
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            TimeUnit.SECONDS.sleep(2);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}