package pageObjectsMarketplace.bookmarkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareMarketplaceDepartmentsPage {
    WebDriver driver;

    public CompareMarketplaceDepartmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='app-header']//li[3]")
    WebElement clickHeaderForSearch;
    @FindBy(xpath = "//div[contains(@class,'tab-pane active')]//div[contains(@class,'row')]//div[contains(@class,'col-12')]//section[contains(@class,'DepartmentSearchBase')]//div//input[@id='location']")
    WebElement location;
    @FindBy(xpath = "//section[@id='app-header']//li[5]")
    WebElement clickHeaderForCompare;
    @FindBy(xpath = "//button[@id='publish-department']")
    WebElement searchDepartment;
    @FindBy(xpath = "//div[@class='bucket AMBULANT']/div[1]/button[1]")
    WebElement bucketItemAmbulant;
    @FindBy(xpath = "//div[@class='bucket STATIONARY']/div[1]/button[1]")
    WebElement bucketItemStationary;
    @FindBy(xpath = "//div[@class='bucket DAYCARE']/div[1]/button[1]")
    WebElement bucketItemDayNight;
    @FindBy(xpath = "//div[@class='bucket HOUSING']/div[1]/button[1]")
    WebElement bucketItemFairHouseOffer;

    public WebElement clickHeaderForSearch() {
        return clickHeaderForSearch;
    }

    public WebElement location() {
        return location;
    }

    public WebElement clickHeaderForCompare() {
        return clickHeaderForCompare;
    }

    public WebElement searchDepartment() {
        return searchDepartment;
    }

    public WebElement bucketItemAmbulant() {
        return bucketItemAmbulant;
    }

    public WebElement bucketItemStationary() {
        return bucketItemStationary;
    }

    public WebElement bucketItemDayNight() {
        return bucketItemDayNight;
    }

    public WebElement bucketItemFairHouseOffer() {
        return bucketItemFairHouseOffer;
    }
}