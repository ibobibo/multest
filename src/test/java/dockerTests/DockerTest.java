package dockerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;

public class DockerTest extends BaseClass {
    @Test
    public void dockerTest() throws InterruptedException, IOException {
        loadProps();
        System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
        RemoteWebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        System.out.println("a");
        driver.get("http://www.google.com");
        System.out.println("b");
        driver.findElement(By.name("q")).sendKeys("Learn Automation");
        System.out.println("c");
        Thread.sleep(5000);

        driver.quit();
    }
}

