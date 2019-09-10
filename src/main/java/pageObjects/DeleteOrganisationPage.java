package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrganisationPage {
    WebDriver driver;

    public DeleteOrganisationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='confirm']")
    WebElement deleteClick;

    public WebElement deleteClick() {
        return deleteClick;
    }
}