package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseClass {
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
            System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL(prop.getProperty("chromeDriverPath")),desiredCapabilities);
        } else if (browserName.equals("firefox")) {
            System.setProperty(prop.getProperty("firefoxDriver"), prop.getProperty("firefoxDriverPath"));
            driver = new FirefoxDriver();

        } else if (browserName.equals("edge")) {
            System.setProperty(prop.getProperty("edgeDriver"), prop.getProperty("edgeDriverPath"));
            driver = new InternetExplorerDriver();
        }

        return driver;
    }

    public void getScreenshot(String name) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/main/java/screenShots/" + name + "_screenshot.png"));
    }

    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetwork"));
    }

    public void initializeBrowserForMarketplace() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetworkMarketplace"));
    }

    public void initializeBrowserForInformationPortal() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlForInformationPortal"));
    }

    public void initializeMailServer() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlFromMailServer"));
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

            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCountContactPerson() {
        try {
            WebElement x = driver.findElement(By.xpath("//section[@class='Userdata']//tbody//tr"));
            int count = x.findElements(By.xpath("//section[@class='Userdata']//tbody//tr")).size();

            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    //access Cookies
    public void accessCookies() {
        try {
            Actions actions = new Actions(driver);
            WebElement accessCookies = driver.findElement(By.id("//a[@id='CybotCookiebotDialogBodyButtonDecline']"));
            actions.moveToElement(accessCookies).click().build().perform();
        } catch (Exception e) {
            System.out.println("Cookies wurden schon aktzeptiert.");
        }
    }

    public void accessAllCookies() throws InterruptedException {
        try {
            Actions actions = new Actions(driver);
            WebElement accessAllCookies = driver.findElement(By.xpath("//html//body//div[@id='CybotCookiebotDialog']//div[@id='CybotCookiebotDialogBody']//a[@id='CybotCookiebotDialogBodyButtonAccept']"));
            while (true) {
                if (accessAllCookies.isDisplayed()) {
                    actions.moveToElement(accessAllCookies).click().build().perform();
                    break;
                } else {
                    TimeUnit.SECONDS.sleep(5);
                }
            }
        } catch (Exception e) {
        }
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}