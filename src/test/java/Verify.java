import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Verify extends BaseClass {
    @BeforeTest
    public void initialize() throws IOException {
        initializeMailServer();
    }

    @Test
    public void verifyRegisteredUser() {
        Actions actions = new Actions(driver);

        WebElement findEmail = driver.findElement(By.xpath("//ul[@class='email-list']//span[contains(text(),'test2@test.test0')]"));
        actions.moveToElement(findEmail).click().build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='preview-iframe panel-html']")));
            System.out.println("switch to frame");
            driver.findElement(By.xpath("/html/body/p[3]/a")).click();
        } catch (Exception e) {
            System.out.println("shit");
        }
    }

    @AfterTest
    public void closeBrowser() {
//        driver.close();
//        driver = null;
    }
}
