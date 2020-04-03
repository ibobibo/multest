package dockerTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;

public class DockerTest extends BaseClass {

    @Test
    public void dockerTest() throws IOException, InterruptedException {
        initializeBrowser();
        System.out.println(prop.getProperty("contactEmail")+" :props");
        String x = driver.findElement(By.xpath("//span[contains(text(),'Bitte tragen Sie Ihre Anmeldedaten ein')]")).getText();
        System.out.println("x: " + x);

        //email
        driver.findElement(By.xpath("//section[2]//div[1]//input[1]")).sendKeys(prop.getProperty("contactEmail"));
        //pw
        driver.findElement(By.xpath("//section[4]//div[1]//input[1]")).sendKeys(prop.getProperty("contactPassword"));
        //accept
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();
        Thread.sleep(5000);

        String y = driver.findElement(By.xpath("//div[@class='enterpriseName']")).getText();
        System.out.println("y: " + y);

        driver.quit();
    }
}

