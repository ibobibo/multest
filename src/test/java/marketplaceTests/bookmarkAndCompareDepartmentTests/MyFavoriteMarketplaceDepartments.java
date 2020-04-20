package marketplaceTests.bookmarkAndCompareDepartmentTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObjectsMarketplace.bookmarkTests.MyFavoriteMarketplaceDepartmentsPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyFavoriteMarketplaceDepartments extends BaseClass {
    @Test
    public void myFavoriteMarketplaceDepartments() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();

        loadProps();
        MyFavoriteMarketplaceDepartmentsPage myFavoriteMarketplaceDepartmentsPage = new MyFavoriteMarketplaceDepartmentsPage(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoopMarketplace(i);
            TimeUnit.SECONDS.sleep(2);
            Actions actions = new Actions(driver);
            myFavoriteMarketplaceDepartmentsPage.clickHeaderForSearch().click();

            for (int card = 1; card < 5; card++) {
                WebElement cardElement = driver.findElement(By.xpath("//div[contains(@class,'departmentSearchHeader')]//li[" + card + "]//a[1]"));
                cardElement.click();

                myFavoriteMarketplaceDepartmentsPage.location().clear();
                myFavoriteMarketplaceDepartmentsPage.location().sendKeys("Berlin");
                TimeUnit.SECONDS.sleep(2);
                myFavoriteMarketplaceDepartmentsPage.searchDepartment().click();
                TimeUnit.SECONDS.sleep(4);
                myFavoriteMarketplaceDepartmentsPage.theFirstElementIsMyFavorite().click();
                TimeUnit.SECONDS.sleep(1);
            }

            myFavoriteMarketplaceDepartmentsPage.clickHeaderForBookmark().click();
            TimeUnit.SECONDS.sleep(2);
            for (int removing = 0; removing < 4; removing++) {
                try {
                    myFavoriteMarketplaceDepartmentsPage.removeMyFavorite().click();
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    break;
                }
            }
        }
        driver.quit();
    }
}
