package marketplaceTests.bookmarkAndCompareDepartmentTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.bookmarkTests.MyFavoriteMarketplaceDepartmentsPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyFavoriteMarketplaceDepartments extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void myFavoriteMarketplaceDepartments() throws IOException, InterruptedException {
        loadProps();
        MyFavoriteMarketplaceDepartmentsPage myFavoriteMarketplaceDepartmentsPage = new MyFavoriteMarketplaceDepartmentsPage(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(2);
            myFavoriteMarketplaceDepartmentsPage.clickHeaderForSearch().click();

            for (int card = 1; card < 5; card++) {
                WebElement cardElement = driver.findElement(By.xpath("//ul[@class='tab-bar nav nav-tabs']//li[" + card + "]"));
                cardElement.click();
                myFavoriteMarketplaceDepartmentsPage.location().sendKeys("Berlin");
                TimeUnit.SECONDS.sleep(2);
                myFavoriteMarketplaceDepartmentsPage.searchDepartment().click();
                TimeUnit.SECONDS.sleep(2);
                myFavoriteMarketplaceDepartmentsPage.theFirstElementIsMyFavorite().click();
                TimeUnit.SECONDS.sleep(1);
                myFavoriteMarketplaceDepartmentsPage.location().clear();
            }

            myFavoriteMarketplaceDepartmentsPage.clickHeaderForBookmark().click();
            TimeUnit.SECONDS.sleep(2);
            for (int removing = 0; removing < 4; removing++) {
                myFavoriteMarketplaceDepartmentsPage.removeMyFavorite().click();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
