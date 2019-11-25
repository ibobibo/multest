package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties propFairHouseOffer = new Properties();
    public static Properties propDepartment = new Properties();
    public static Properties propNewPlacement = new Properties();


    public WebDriver initializeDriver() throws IOException, InterruptedException {
        loadProps();
        String browserName = prop.getProperty("browser");

        //check for browser
        if (browserName.equals("chrome")) {
            System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
            driver = new ChromeDriver();
//            WebDriverManager.chromedriver().version("78.0.3904.105").setup();
//            driver = new ChromeDriver();
//            driver.get("https://dev-partner.mitpflegeleben.de/#/login");
//            TimeUnit.SECONDS.sleep(4);
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

    public void initializeBrowser() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetwork"));
    }

    public void initializeBrowserForMarketplace() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetworkMarketplace"));
    }

    public void initializeBrowserForInformationPortal() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get(prop.getProperty("urlForInformationPortal"));
    }

    public void initializeMailServer() throws IOException, InterruptedException {
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