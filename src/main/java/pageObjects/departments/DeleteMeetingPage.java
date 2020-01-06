package pageObjects.departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteMeetingPage {
    WebDriver driver;

    public DeleteMeetingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement textArea;
    @FindBy(xpath = "//button[@class='primary']")
    WebElement submit;
    @FindBy(xpath = "//button[@class='secondary']")
    WebElement cancel;
    @FindBy(xpath = "//label[3]//div[1]//div[1]//span[1]")
    WebElement discardMeetingReqFromUser;

    public WebElement textArea() {
        return textArea;
    }

    public WebElement submit() {
        return submit;
    }

    public WebElement cancel() {
        return cancel;
    }

    public WebElement discardMeetingReqFromUser() {
        return discardMeetingReqFromUser;
    }

}