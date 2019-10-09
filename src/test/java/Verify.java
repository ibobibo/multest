import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.VerifyPage;
import resources.BaseClass;

import java.io.IOException;

public class Verify extends BaseClass {
    @BeforeTest
    public void initialize() throws IOException {
        initializeMailServer();
    }

    @Test
    public void verifyRegisteredUser() {
        Actions actions = new Actions(driver);

        VerifyPage verifyPage = new VerifyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement findEmail = driver.findElement(By.xpath("//ul[@class='email-list']//span[contains(text(),'test2@test.test0')]"));
        actions.moveToElement(findEmail).click().build().perform();

        try {
            WebElement waitForFrame = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//iframe[@class='preview-iframe panel-html']"))));
            driver.switchTo().frame(waitForFrame);
            System.out.println("switch to frame 0");
            System.out.println(driver.findElement(By.xpath("/html/body/p[3]/a")).getText());
        } catch (Exception e) {
            System.out.println("doubleshit");
        }
    }

    @AfterTest
    public void closeBrowser() {
//        driver.close();
//        driver = null;
    }
}
