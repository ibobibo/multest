package dockerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerTest3 {
    public static String hubAddress;

    @Test
    public void dockerTest() throws MalformedURLException, InterruptedException {
        hubAddress = "172.19.0.2";

        DesiredCapabilities cap = DesiredCapabilities.firefox();

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + hubAddress + ":4444/wd/hub"), cap);

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Learn Automation");

        Thread.sleep(5000);

        driver.close();
    }
}

