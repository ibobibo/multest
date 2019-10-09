package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyPage {
    WebDriver driver;

    public VerifyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='email-list']//span[contains(text(),'test2@test.test0')]")
    WebElement emailToVerify;

    @FindBy(xpath = "/html/body/p[3]")
    WebElement emailActivate;

    public WebElement emailToVerify() {
        return emailToVerify;
    }

    public WebElement emailActivate() {
        return emailActivate;
    }

}
