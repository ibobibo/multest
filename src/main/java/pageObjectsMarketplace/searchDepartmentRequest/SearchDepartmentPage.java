package pageObjectsMarketplace.searchDepartmentRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchDepartmentPage {

    WebDriver driver;

    public SearchDepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='app-header']//li[3]")
    WebElement searchDepartmentTitle;
    @FindBy(xpath = "//div[contains(@class,'tab-pane active')]//div[contains(@class,'row')]//div[contains(@class,'col-12')]//section[contains(@class,'DepartmentSearchBase')]//div//input[@id='location']")
    WebElement location;
    @FindBy(xpath = "//input[@id='freeTextSearch']")
    WebElement departmentName;
    @FindBy(xpath = "//div[contains(@class,'tab-pane active')]//div[contains(@class,'row')]//div[contains(@class,'col-12')]//section[contains(@class,'DepartmentSearchBase')]//div//select[@id='area']")
    WebElement selectPerimeter;
    @FindBy(xpath = "//option[. = '5 km']")
    WebElement selectPerimeterOption5;
    @FindBy(xpath = "//option[. = '50 km']")
    WebElement selectPerimeterOption50;
    @FindBy(xpath = "//button[@id='publish-department']")
    WebElement searchDepartment;
    @FindBy(xpath = "//div[@class='lead address']//div[2]")
    WebElement getPostalCodeOfResult;
    @FindBy(xpath = "//div[@id='app-view-container']//li[5]//a[1]")
    WebElement nextPage;

    public WebElement searchDepartmentTitle() {
        return searchDepartmentTitle;
    }

    public WebElement location() {
        return location;
    }

    public WebElement departmentName() {
        return departmentName;
    }

    public WebElement selectPerimeter() {
        return selectPerimeter;
    }

    public WebElement selectPerimeterOption5() {
        return selectPerimeterOption5;
    }

    public WebElement selectPerimeterOption50() {
        return selectPerimeterOption50;
    }

    public WebElement searchDepartment() {
        return searchDepartment;
    }

    public WebElement getPostalCodeOfResult() {
        return getPostalCodeOfResult;
    }

    public WebElement nextPage() {
        return nextPage;
    }
}


