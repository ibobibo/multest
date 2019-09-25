package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.contactPerson.EditContactPersonPage;
import resources.MulLogin;

import java.io.IOException;

public class EditContactPerson extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test()
    public void editContactPerson() throws IOException {
        EditContactPersonPage editContactPersonPage = new EditContactPersonPage(driver);
        Actions actions = new Actions(driver);
        login();
        loadPropsForDepartment();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        int i = 1;
        while (getCountContactPerson() >= i) {
            String xpath = "//section[@class='Userdata']//tr[" + i + "]//a[@class='edit']";
            WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            if (findTr.isDisplayed()) {
                findTr.click();
            }
            WebElement availability = driver.findElement(By.id("salutation"));
            actions.moveToElement(availability).click().build().perform();
            editContactPersonPage.contactSalutationChosen().click();

            editContactPersonPage.contactFirstName().clear();
            editContactPersonPage.contactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));

            editContactPersonPage.contactLastName().clear();
            editContactPersonPage.contactLastName().sendKeys(propDepartment.getProperty("contactLastName"));

            editContactPersonPage.contactEmail().clear();
            editContactPersonPage.contactEmail().sendKeys(propDepartment.getProperty("contactEmail"));

            editContactPersonPage.contactPhone().clear();
            editContactPersonPage.contactPhone().sendKeys(propDepartment.getProperty("contactPhone"));

            editContactPersonPage.back().click();

            i++;
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
