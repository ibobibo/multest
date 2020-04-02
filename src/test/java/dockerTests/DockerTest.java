package dockerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DockerTest extends BaseClass {

    @Test
    public void dockerTest() throws IOException, InterruptedException {
        initializeBrowser();

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Learn Automation");

        Thread.sleep(5000);

        driver.quit();
    }
}

