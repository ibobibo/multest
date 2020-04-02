package dockerTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;

public class DockerTest extends BaseClass {

    @Test
    public void dockerTest() throws IOException, InterruptedException {
        initializeBrowser();
        System.out.println("wieder da");

        String x = driver.findElement(By.xpath("//span[contains(text(),'Bitte tragen Sie Ihre Anmeldedaten ein')]")).getText();
        System.out.println("x: " + x);
        Thread.sleep(5000);

        driver.quit();
    }
}

