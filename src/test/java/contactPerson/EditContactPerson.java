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
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EditContactPerson extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies();
    }

    @Test()
    public void editContactPerson() throws IOException, InterruptedException {
        EditContactPersonPage editContactPersonPage = new EditContactPersonPage(driver);
        Actions actions = new Actions(driver);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {

            loginLoop(i);
            TimeUnit.SECONDS.sleep(1);
            loadPropsForDepartment();
            WebDriverWait wait = new WebDriverWait(driver, 5);

            int x = 1;
            while (getCountContactPerson() >= x) {
                String xpath = "//section[@class='Userdata']//tr[" + x + "]//a[@class='edit']";
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

                x++;
            }
            TimeUnit.SECONDS.sleep(2);
        }
        logout();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
