package pageObjectsMarketplace.bookmarkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyFavoriteMarketplaceDepartmentsPage {
    WebDriver driver;

    public MyFavoriteMarketplaceDepartmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Vermittlung')]")
    WebElement clickHeaderForSearch;
    @FindBy(xpath = "//div[contains(@class,'tab-pane active')]//div[contains(@class,'row')]//div[contains(@class,'col-12')]//section[contains(@class,'DepartmentSearchBase')]//div//input[@id='location']")
    WebElement location;
    @FindBy(xpath = "//tr[1]//section[@class='DepartmentBookmarkButton']//button[@class='bookmark ']")
    WebElement theFirstElementIsMyFavorite;
    @FindBy(xpath = "//a[contains(@class,'Bookmarks nav-link')]")
    WebElement clickHeaderForBookmark;
    @FindBy(xpath = "//tr[1]//section[@class='DepartmentBookmarkButton']//button[@class='bookmarked ']")
    WebElement removeMyFavorite;
    @FindBy(xpath = "//button[@id='publish-department']")
    WebElement searchDepartment;

    public WebElement clickHeaderForSearch() {
        return clickHeaderForSearch;
    }

    public WebElement location() {
        return location;
    }

    public WebElement theFirstElementIsMyFavorite() {
        return theFirstElementIsMyFavorite;
    }

    public WebElement clickHeaderForBookmark() {
        return clickHeaderForBookmark;
    }

    public WebElement removeMyFavorite() {
        return removeMyFavorite;
    }

    public WebElement searchDepartment() {
        return searchDepartment;
    }

}
