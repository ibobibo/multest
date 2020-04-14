package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.contactPerson.DeleteContactPersonPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteContactPerson extends BaseClass {
    @Test()
    public void deleteContactPerson() throws InterruptedException, IOException {
        initializeBrowser();
        accessAllCookies(driver);

        DeleteContactPersonPage deleteContactPersonPage = new DeleteContactPersonPage(driver);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            try {
                deleteContactPersonPage.addContactPersonCard().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            while (getCountContactPerson() != 0) {
                try {
                    String xpath = "//section[@class='Userdata']//tr[1]//a[@class='delete']";
                    WebElement findTr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                    if (findTr.isDisplayed()) {
                        findTr.click();
                        deleteContactPersonPage.delete().click();
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (Exception e) {
                    System.out.println("Kein Anprechpartner mehr zu finden.");
                    break;
                }
            }
            TimeUnit.SECONDS.sleep(2);
        }
        logout();
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
    }
}
