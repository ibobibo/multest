package pageObjects.contactPerson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteContactPersonPage {
    WebDriver driver;

    public DeleteContactPersonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mul-confirm-delete-category")
    WebElement delete;
    @FindBy(xpath = "//button[@class='cancel']")
    WebElement back;

    public WebElement delete() {
        return delete;
    }

    public WebElement back() {
        return back;
    }

}
