package placements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.placements.DeletePlacementPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeletePlacement extends BaseClass {
    @Test
    public void deleteAccount() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();
        DeletePlacementPage deletePlacementPage = new DeletePlacementPage(driver);

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            System.out.println(new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//body//h3//span[1]"))).getText());
            loginLoop(i);
            TimeUnit.SECONDS.sleep(2);
            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='navbar-toggler-icon']"))).click();
            } catch (Exception e) {
                System.out.println("no toggler because window size is: " + driver.manage().window().getSize());
            }
            deletePlacementPage.editPlacement().click();
            deletePlacementPage.deletePlacement().click();
            deletePlacementPage.acceptDelete().click();
            TimeUnit.SECONDS.sleep(3);
        }
        driver.quit();
    }
}
