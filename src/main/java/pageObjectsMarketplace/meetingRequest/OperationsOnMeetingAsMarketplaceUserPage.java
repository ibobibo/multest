package pageObjectsMarketplace.meetingRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperationsOnMeetingAsMarketplaceUserPage {
    WebDriver driver;

    public OperationsOnMeetingAsMarketplaceUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    WebElement accountMenu;
    @FindBy(xpath = "//span[@class='myAccount']")
    WebElement myAccount;
    @FindBy(xpath = "//span[@class='logout']")
    WebElement accountMenuLogout;
    @FindBy(xpath = "//section[@class='RequestPreviewContainer']/div[@class='results']/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]")
    WebElement responseRequests;
    @FindBy(xpath = "//div[@class='results']//div[1]//div[1]//div[1]//div[1]//div[1]//button[2]//span[1]")
    WebElement acceptProviderRes;
    @FindBy(xpath = "//textarea[@id='message']")
    WebElement answerMessage;
    @FindBy(xpath = "//button[@class='primary']")
    WebElement submit;
    @FindBy(xpath = "//button[@class='primary']")
    WebElement discard;

    public WebElement submit() {
        return submit;
    }

    public WebElement discard() {
        return discard;
    }

    public WebElement accountMenu() {
        return accountMenu;
    }

    public WebElement myAccount() {
        return myAccount;
    }

    public WebElement accountMenuLogout() {
        return accountMenuLogout;
    }

    public WebElement responseRequests() {
        return responseRequests;
    }

    public WebElement acceptProviderRes() {
        return acceptProviderRes;
    }

    public WebElement answerMessage() {
        return answerMessage;
    }
}