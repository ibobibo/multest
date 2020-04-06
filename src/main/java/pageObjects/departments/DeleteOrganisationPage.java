package pageObjects.departments;

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

    @FindBy(xpath = "//button[@id='mul-confirm-delete-category']")
    WebElement deleteClick;

    public WebElement deleteClick() {
        return deleteClick;
    }

    @FindBy(xpath = "//button[@class='cancel']")
    WebElement cancelClick;

    public WebElement cancelClick() {
        return cancelClick;
    }

}
