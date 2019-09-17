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

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties propFairHouseOffer = new Properties();
    public static Properties propDepartment = new Properties();


    public WebDriver initializeDriver() throws IOException {
        loadProps();
        String browserName = prop.getProperty("browser");

        //check for browser
        if (browserName.equals("chrome")) {
            //excecute test for chrome
            System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            //excecute test for firefox
            System.setProperty(prop.getProperty("firefoxDriver"), prop.getProperty("firefoxDriverPath"));
            driver = new FirefoxDriver();

        } else if (browserName.equals("edge")) {
            //excecute test for edge
            System.setProperty(prop.getProperty("edgeDriver"), prop.getProperty("edgeDriverPath"));
            driver = new InternetExplorerDriver();
        }

        return driver;
    }

    public void getScreenshot(String name) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\ibobi\\OneDrive\\Desktop\\screenShots\\" + name + "screenshot.png"));
    }

    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetwork"));
    }

    public void loadProps() throws IOException {
        prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ibobi\\OneDrive\\Dokumente\\Automatisierung\\MulTesting\\src\\main\\java\\properties\\browserData.properties");
        prop.load(fileInputStream);
    }

    public void loadPropsForFairHouseOfferDepartment() throws IOException {
        propFairHouseOffer = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ibobi\\OneDrive\\Dokumente\\Automatisierung\\MulTesting\\src\\main\\java\\properties\\fairHouseOfferDepartment.properties");
        propFairHouseOffer.load(fileInputStream);
    }

    public void loadPropsForDepartment() throws IOException {
        propDepartment = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ibobi\\OneDrive\\Dokumente\\Automatisierung\\MulTesting\\src\\main\\java\\properties\\departmentPage.properties");
        propDepartment.load(fileInputStream);
    }
}