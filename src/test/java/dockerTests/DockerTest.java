package dockerTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DockerTest extends BaseClass {

    @Test
    public void dockerTest() throws IOException, InterruptedException {
        initializeBrowser();
        TimeUnit.SECONDS.sleep(4);

        //email
        driver.findElement(By.xpath("//section[2]//div[1]//input[1]")).sendKeys(prop.getProperty("contactEmail"));
        TimeUnit.SECONDS.sleep(4);
        //pw
        driver.findElement(By.xpath("//section[4]//div[1]//input[1]")).sendKeys(prop.getProperty("contactPassword"));
        TimeUnit.SECONDS.sleep(4);
        //accept
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();
        TimeUnit.SECONDS.sleep(4);

        String y = driver.findElement(By.xpath("//div[@class='enterpriseNumber']")).getText();
        System.out.println("y: " + y);
        System.out.println("enterprise number");

        driver.quit();
    }
}

