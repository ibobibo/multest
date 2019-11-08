package pageObjectsMarketplace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscardMeetingAsMarketplaceUserPage {
    WebDriver driver;

    public DiscardMeetingAsMarketplaceUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    WebElement accountMenu;
    @FindBy(xpath = "//span[@class='logout']")
    WebElement accountMenuLogout;

    public WebElement accountMenu() {
        return accountMenu;
    }

    public WebElement accountMenuLogout() {
        return accountMenuLogout;
    }
}