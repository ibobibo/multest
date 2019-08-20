package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    public static WebDriver driver;
    public static Properties prop = new Properties();

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ibobi\\OneDrive\\Dokumente\\Automatisierung\\MulTesting\\src\\main\\java\\browserData.properties");
        prop.load(fileInputStream);
        String browserName = prop.getProperty("browser");
        System.out.println(prop.getProperty("browser"));
        //check for browser
        if (browserName.equals("chrome")) {
            //excecute test for chrome
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ibobi\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            //excecute test for firefox
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ibobi\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equals("edge")) {
            //excecute test for edge
            System.setProperty("webdriver.ie.driver", "C:\\Users\\ibobi\\Downloads\\edgedriver_win64\\edgedriver.exe");
            driver = new InternetExplorerDriver();

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public void getScreenshot(String name) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\ibobi\\OneDrive\\Desktop\\screenShots\\" + name + "screenshot.png"));
    }
}
