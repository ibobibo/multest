package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalConsultationPage {
    WebDriver driver;

    public DigitalConsultationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='location']")
    WebElement postalCode;
    @FindBy(xpath = "//section[@class='AdvisorPage']//label[@class='Checkbox ']//span[contains(text(),'Hiermit willigen Sie in die Verarbeitung')]")
    WebElement checkboxDigitalConsultation;
    @FindBy(xpath = "//button[@id='next-page']")
    WebElement nextPage;
    @FindBy(xpath = "//button[@id='2_4']")
    WebElement nursingDegreeAvailable;
    @FindBy(xpath = "//button[@id='2_5']")
    WebElement nursingDegreeNotAvailable;

    public WebElement postalCode() {
        return postalCode;
    }

    public WebElement checkboxDigitalConsultation() {
        return checkboxDigitalConsultation;
    }

    public WebElement nextPage() {
        return nextPage;
    }

    public WebElement nursingDegreeAvailable() {
        return nursingDegreeAvailable;
    }

    public WebElement nursingDegreeNotAvailable() {
        return nursingDegreeNotAvailable;
    }
}
