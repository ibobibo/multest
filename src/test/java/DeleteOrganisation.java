import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DeleteOrganisationPage;

import java.io.IOException;

public class DeleteOrganisation extends MulLogin {

    public int getCount() {
        WebElement x = driver.findElement(By.xpath("//section[@class='Department']//tbody//tr"));
        int count = x.findElements(By.xpath("//section[@class='Department']//tbody//tr")).size();
        return count;
    }


    @BeforeTest
    public void initialize() throws IOException {
        initializeBrowser();
    }

    @Test()
    public void deleteAllOrganisation() {
        DeleteOrganisationPage deleteOrganisationPage = new DeleteOrganisationPage(driver);
        login();

        System.out.println(getCount());

        for (int i = 0; i < getCount(); i++) {
            driver.findElements(By.xpath("//td[5]//div[1]//a[2]")).get(i).click();
            deleteOrganisationPage.deleteClick().click();
        }
    }

    @AfterTest
    public void closeBrowser() {
//        driver.close();
        driver = null;
    }
}
