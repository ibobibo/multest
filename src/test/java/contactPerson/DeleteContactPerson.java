package contactPerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.contactPerson.DeleteContactPersonPage;
import resources.BaseClass;

import java.io.IOException;

public class DeleteContactPerson extends BaseClass {
    @Test()
    public void deleteContactPerson() throws InterruptedException, IOException {
        initializeBrowser();

        DeleteContactPersonPage deleteContactPersonPage = new DeleteContactPersonPage(driver);
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            try {
                deleteContactPersonPage.addContactPersonCard().click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            while (getCountContactPerson() != 0) {
                try {
                    String xpath = "//section[@class='Userdata']//tr[1]//a[@class='delete']";
                    WebElement findTr = driver.findElement(By.xpath(xpath));
                    findTr.click();
                    if (findTr.isDisplayed()) {
                        findTr.click();
                        deleteContactPersonPage.delete().click();
                    }
                } catch (Exception e) {
                    System.out.println("Kein Anprechpartner mehr zu finden.");
                    break;
                }
            }
        }
        logout();
        driver.quit();
    }
}
