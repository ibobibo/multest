package pageObjects.contactPerson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchContactPersonPage {
    WebDriver driver;

    public SearchContactPersonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='app-view-container']//li[3]//a[1]")
    WebElement addContactPersonCard;
    @FindBy(xpath = "//input[@placeholder='Suche nach E-Mail, Name']")
    WebElement searchField;
    @FindBy(xpath = "//button[@id='search-userdata']")
    WebElement searchButton;
    @FindBy(xpath = "//td[@class='userdata']//a[1]")
    WebElement resultFromSearch;

    public WebElement addContactPersonCard() {
        return addContactPersonCard;
    }

    public WebElement searchField() {
        return searchField;
    }

    public WebElement searchButton() {
        return searchButton;
    }

    public WebElement resultFromSearch() {
        return resultFromSearch;
    }
}
