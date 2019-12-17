package pageObjects.departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CopyDepartmentPage {
    WebDriver driver;

    public CopyDepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[1]//td[3]//a[1]")
    WebElement departmentName;
    @FindBy(xpath = "//button[@id='add-button-0']")
    WebElement addCopyOfDepartment;
    @FindBy(xpath = "//tr[2]//td[3]//a[1]")
    WebElement copiedDepartmentName;

    public WebElement departmentName() {
        return departmentName;
    }

    public WebElement addCopyOfDepartment() {
        return addCopyOfDepartment;
    }

    public WebElement copiedDepartmentName() {
        return copiedDepartmentName;
    }
}

