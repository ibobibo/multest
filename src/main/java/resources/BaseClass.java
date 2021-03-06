package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pageObjects.LoginLogoutPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static RemoteWebDriver driver;
    public static Properties prop = new Properties();
    public static Properties propFairHouseOffer = new Properties();
    public static Properties propDepartment = new Properties();
    public static Properties propNewPlacement = new Properties();
    public static String hubAddress;

    public WebDriver initializeDriver() throws IOException {
        cleanUp();
        loadProps();
        String browserName = prop.getProperty("browser");
        hubAddress = "172.19.0.2";

        //check for browser
        if (browserName.equals("chrome")) {
            System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
            driver = new ChromeDriver();


//            DesiredCapabilities cap = DesiredCapabilities.chrome();
//            driver = new RemoteWebDriver(new URL("http://" + hubAddress + ":4444/wd/hub"), cap);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } else if (browserName.equals("firefox")) {
            System.setProperty(prop.getProperty("firefoxDriver"), prop.getProperty("firefoxDriverPath"));
            // headless

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
            firefoxOptions.setLogLevel(FirefoxDriverLogLevel.DEBUG);
            driver = new FirefoxDriver(firefoxOptions);

            // driver = new FirefoxDriver()

//            DesiredCapabilities cap = DesiredCapabilities.firefox();
//            driver = new RemoteWebDriver(new URL("http://" + hubAddress + ":4444/wd/hub"), cap);

            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } else if (browserName.equals("edge")) {
//            DesiredCapabilities cap = DesiredCapabilities.edge();
//            driver = new RemoteWebDriver(new URL("http://" + hubAddress + ":4444/wd/hub"), cap);
//
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        return driver;
    }

    public void getScreenshot(String name) {
        try {
//            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(src, new File("src/main/java/screenShots/" + name + "_screenshot.png"));
        } catch (Exception e) {
            System.out.println("Null pointer Exception in take Screenshot Method");
            System.out.println(e);
        }
    }

    public void initializeBrowser() throws IOException {
        initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetwork"));
        accessAllCookies(driver);
    }

    public void initializeBrowserForMarketplace() throws IOException, InterruptedException {
        initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetworkMarketplace"));
        accessAllCookies(driver);
    }

    public void initializeBrowserForInformationPortal() throws IOException {
        initializeDriver();
        driver.get(prop.getProperty("urlForInformationPortal"));
        accessAllCookies(driver);
    }

    public void initializeMailServer() throws IOException {
        initializeDriver();
        driver.get(prop.getProperty("urlFromMailServer"));
        accessAllCookies(driver);
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
            WebElement x = driver.findElement(By.xpath("//td[@class='actions']"));
            int count = x.findElements(By.xpath("//td[@class='actions']")).size();

            return count;
        } catch (Exception e) {
            System.out.println("No data exists.");
            return 0;
        }
    }

    public int getCountForDelete() {
        try {
            TimeUnit.SECONDS.sleep(2);
            WebElement x = driver.findElement(By.xpath("//td[@class='actions']"));
            int count = x.findElements(By.xpath("//td[@class='actions']")).size();
            System.out.println(count);
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCountContactPerson() {
        try {
            TimeUnit.SECONDS.sleep(2);
            WebElement x = driver.findElement(By.xpath("//section[@class='Userdata']//tbody//tr"));
            int count = x.findElements(By.xpath("//section[@class='Userdata']//tbody//tr")).size();
            if (count == 0) {
                System.out.println("Es existiert keine Kontaktperson.");
                return 0;
            }
            return count;
        } catch (Exception e) {
            driver.quit();
            Assert.fail("Nicht möglich die Contact Personen zu zählen.");
            return 0;
        }
    }

    //access Cookies
    public void accessAllCookies(RemoteWebDriver driver) {
        try {
            driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']")).click();
        } catch (Exception e) {
            System.out.println("Cant't find any cookies.");
        }
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void login() {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("contactEmail"));
        loginLogoutPage.password().sendKeys(prop.getProperty("contactPassword"));
        loginLogoutPage.anmelden().click();
    }

    public void login(String anfrageNameEmail, String anfrageNamePassword) {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(anfrageNameEmail);
        loginLogoutPage.password().sendKeys(anfrageNamePassword);
        loginLogoutPage.anmelden().click();
    }

    public void loginLoop(int i) {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("contactEmail"));
        loginLogoutPage.password().sendKeys(prop.getProperty("contactPassword"));
        loginLogoutPage.anmelden().click();
    }

    public void loginLoopMarketplace(int i) throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        try {
            loginLogoutPage.anmeldenButton().click();
        } catch (Exception e) {
            System.out.println("dont need it");
        }
        loginLogoutPage.username().sendKeys(prop.getProperty("marketPlaceName"));
        loginLogoutPage.password().sendKeys(prop.getProperty("marketPlacePassword"));
        loginLogoutPage.anmelden().click();
    }

    public void loginAdmin() {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("adminName"));
        loginLogoutPage.password().sendKeys(prop.getProperty("adminPassword"));
        loginLogoutPage.anmelden().click();
    }

    public void logout() {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.userOption().click();
        loginLogoutPage.logout().click();
    }

    public void cleanUp() {
        if (driver != null) {
            System.out.println("CleanUp");
            driver.quit();
            driver = null;
        }
    }
}
