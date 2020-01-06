package pageObjects.departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcceptMeetingPage {
    WebDriver driver;

    public AcceptMeetingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='requests']//span[@class='requestCount']")
    WebElement requestCount;
    @FindBy(xpath = "//input[@placeholder='Zeit *']")
    WebElement timeSelectField;
    @FindBy(xpath = "//li[contains(text(),'00:00')]")
    WebElement whichTime;
    @FindBy(xpath = "//textarea[@id='message']")
    WebElement textArea;
    @FindBy(xpath = "//button[@class='primary']")
    WebElement submit;
    @FindBy(xpath = "//button[@class='secondary']")
    WebElement cancel;
    @FindBy(xpath = "//section[@class='MasterDashboard']//div[contains(@class,'request SETTLED')]")
    WebElement newRequest;
    @FindBy(xpath = "//label[2]//div[1]//div[1]//span[1]")
    WebElement labelForKindOfRes;

    public WebElement requestCount() {
        return requestCount;
    }

    public WebElement timeSelectField() {
        return timeSelectField;
    }

    public WebElement labelForKindOfRes() {
        return labelForKindOfRes;
    }

    public WebElement whichTime() {
        return whichTime;
    }

    public WebElement textArea() {
        return textArea;
    }

    public WebElement submit() {
        return submit;
    }

    public WebElement cancel() {
        return cancel;
    }

    public WebElement newRequest() {
        return newRequest;
    }

}