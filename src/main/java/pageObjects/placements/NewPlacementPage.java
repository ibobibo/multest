package pageObjects.placements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPlacementPage {
    WebDriver driver;

    public NewPlacementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='SiteDashboardHeader']//a[@class='new']")
    WebElement newPlacement;
    @FindBy(id = "name")
    WebElement nameOfPlacement;
    @FindBy(id = "umbrellaOrganisation.id")
    WebElement organisation;
    @FindBy(xpath = "//option[. = 'Diakonie Michaelshoven e. V.']")
    WebElement organisationChosen;
    @FindBy(xpath = "//section[@class='FormButtons']//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//section[@class='FormButtons']//button[@class='back']")
    WebElement back;


    public WebElement newPlacement() {
        return newPlacement;
    }

    public WebElement nameOfPlacement() {
        return nameOfPlacement;
    }

    public WebElement organisation() {
        return organisation;
    }

    public WebElement organisationChosen() {
        return organisationChosen;
    }

    public WebElement submit() {
        return submit;
    }

    public WebElement back() {
        return back;
    }

}
