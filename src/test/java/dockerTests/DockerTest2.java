package dockerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerTest2 {
    @Test
    public void dockerTest() throws MalformedURLException, InterruptedException {

        ChromeOptions cap = new ChromeOptions();

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Learn Automation");

        Thread.sleep(5000);

        driver.quit();
    }
}

