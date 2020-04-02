package dockerTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;

public class DockerTest extends BaseClass {

    @Test
    public void dockerTest() throws IOException, InterruptedException {
        initializeBrowser();

        String x = driver.findElement(By.xpath("//div[@class='brand-icon']//img")).getText();
        System.out.println("x: " + x);
        Thread.sleep(5000);

        driver.quit();
    }
}

