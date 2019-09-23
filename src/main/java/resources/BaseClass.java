package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    //hello
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties propFairHouseOffer = new Properties();
    public static Properties propDepartment = new Properties();
    public static Properties propNewPlacement = new Properties();


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
        FileUtils.copyFile(src, new File("src/main/java/screenShots/" + name + "screenshot.png"));
    }

    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetwork"));
    }

    public void loadProps() throws IOException {
        prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/properties/browserData.properties");
        prop.load(fileInputStream);
    }

    public void loadPropsForFairHouseOfferDepartment() throws IOException {
        propFairHouseOffer = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/properties/fairHouseOfferDepartment.properties");
        propFairHouseOffer.load(fileInputStream);
    }

    public void loadPropsForDepartment() throws IOException {
        propDepartment = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/properties/departmentPage.properties");
        propDepartment.load(fileInputStream);
    }

    public void loadPropsForPlacement() throws IOException {
        propNewPlacement = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/properties/newPlacement.properties");
        propNewPlacement.load(fileInputStream);
    }

    public int getCount() {
        try {
            WebElement x = driver.findElement(By.xpath("//section[@class='Department']//tbody//tr"));
            int count = x.findElements(By.xpath("//section[@class='Department']//tbody//tr")).size();
            System.out.println(count);
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

}