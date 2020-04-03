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
        driver.findElement(By.xpath("//input[@id='contact.firstName']")).sendKeys(prop.getProperty("contactEmail"));
        TimeUnit.SECONDS.sleep(4);
        //pw
        driver.findElement(By.xpath("//input[@id='enterprise.address.streetAddress']")).sendKeys(prop.getProperty("contactPassword"));
        TimeUnit.SECONDS.sleep(4);
        //accept
        driver.findElement(By.xpath("//input[@id='enterprise.address.streetNumber']")).sendKeys("contactPassword");
        TimeUnit.SECONDS.sleep(4);

        String y = driver.findElement(By.xpath("//input[@id='enterprise.address.streetNumber']")).getText();
        System.out.println("y: " + y);

        driver.quit();
    }
}

