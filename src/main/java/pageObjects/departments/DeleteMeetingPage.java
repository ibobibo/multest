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

    @FindBy(xpath = "//a[@class='requests']//span[@class='requestCount']")
    WebElement requestCount;
    @FindBy(xpath = "//textarea[@id='admin-request-cancel']")
    WebElement textArea;
    @FindBy(xpath = "//button[@class='primary btn btn-secondary']")
    WebElement submit;
    @FindBy(xpath = "//button[@class='secondary cancelButton btn btn-secondary']")
    WebElement cancel;


    public WebElement requestCount() {
        return requestCount;
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
}