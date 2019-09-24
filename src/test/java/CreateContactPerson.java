import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ContactPersonPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateContactPerson extends MulLogin {

    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test()
    public void addContactPerson() throws IOException, InterruptedException {
        ContactPersonPage contactPersonPage = new ContactPersonPage(driver);
        Actions actions = new Actions(driver);
        login();
        loadPropsForDepartment();

        TimeUnit.SECONDS.sleep(1);

        contactPersonPage.addContactPerson().click();
        TimeUnit.SECONDS.sleep(1);
        WebElement availability = driver.findElement(By.id("salutation"));
        actions.moveToElement(availability).click().build().perform();
        contactPersonPage.contactSalutationChosen().click();
        contactPersonPage.contactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
        contactPersonPage.contactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
        contactPersonPage.contactEmail().sendKeys(propDepartment.getProperty("contactEmail"));
        contactPersonPage.contactPhone().sendKeys(propDepartment.getProperty("contactPhone"));
        contactPersonPage.submit().click();

    }

    @AfterTest
    public void closeBrowser() {
    }
}
