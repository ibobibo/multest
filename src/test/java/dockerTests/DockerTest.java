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
        System.out.println("a");
        FirefoxOptions cap = new FirefoxOptions();
        System.out.println("b");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        System.out.println("c");
        driver.get("http://www.google.com");
        System.out.println("d");
        driver.findElement(By.name("q")).sendKeys("Learn Automation");
        System.out.println("e");
        Thread.sleep(5000);

        driver.quit();
    }
}

