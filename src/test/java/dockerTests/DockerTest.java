package dockerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerTest {
    @Test
    public void dockerTest() throws MalformedURLException, InterruptedException {
        FirefoxOptions cap = new FirefoxOptions();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Learn Automation");

        Thread.sleep(5000);

        driver.quit();
    }
}

