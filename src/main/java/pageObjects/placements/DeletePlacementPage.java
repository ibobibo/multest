package pageObjects.placements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePlacementPage {
    WebDriver driver;

    public DeletePlacementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='SiteDashboardHeader']//a[@class='edit']")
    WebElement editPlacement;

    public WebElement editPlacement() {
        return editPlacement;
    }
}
