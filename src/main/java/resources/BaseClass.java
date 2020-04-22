package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
//            System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
//            driver = new ChromeDriver();

            DesiredCapabilities cap = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://" + hubAddress + ":4444/wd/hub"), cap);
        } else if (browserName.equals("firefox")) {
            System.setProperty(prop.getProperty("firefoxDriver"), prop.getProperty("firefoxDriverPath"));
            driver = new FirefoxDriver();

//            DesiredCapabilities cap = DesiredCapabilities.firefox();
//            driver = new RemoteWebDriver(new URL("http://" + hubAddress + ":4444/wd/hub"), cap);
        } else if (browserName.equals("edge")) {
            DesiredCapabilities cap = DesiredCapabilities.edge();
            driver = new RemoteWebDriver(new URL("http://" + hubAddress + ":4444/wd/hub"), cap);
        }
        return driver;
    }

    public void getScreenshot(String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("src/main/java/screenShots/" + name + "_screenshot.png"));
        } catch (Exception e) {
            System.out.println("Null pointer Exception in take Screenshot Method");
            System.out.println(e);
        }
    }

    public void initializeBrowser() throws IOException {
        initializeDriver();
        driver.manage().window().fullscreen();
        driver.get(prop.getProperty("urlFromHomeNetwork"));

        accessAllCookies(driver);
    }

    public void initializeBrowserForMarketplace() throws IOException, InterruptedException {
        initializeDriver();
        driver.manage().window().fullscreen();
        driver.get(prop.getProperty("urlFromHomeNetworkMarketplace"));
        TimeUnit.SECONDS.sleep(6);

        accessAllCookies(driver);
    }

    public void initializeBrowserForInformationPortal() throws IOException {
        initializeDriver();
        driver.get(prop.getProperty("urlForInformationPortal"));
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
            TimeUnit.SECONDS.sleep(2);
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

    public void login() throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("contactEmail"));
        loginLogoutPage.password().sendKeys(prop.getProperty("contactPassword"));
        loginLogoutPage.anmelden().click();
        TimeUnit.SECONDS.sleep(4);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void login(String anfrageNameEmail, String anfrageNamePassword) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(anfrageNameEmail);
        loginLogoutPage.password().sendKeys(anfrageNamePassword);
        TimeUnit.SECONDS.sleep(2);
        loginLogoutPage.anmelden().click();

        TimeUnit.SECONDS.sleep(2);
    }

    public void loginLoop(int i) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

        accessAllCookies(driver);

        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("contactEmail"));
        loginLogoutPage.password().sendKeys(prop.getProperty("contactPassword"));

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-submit']"))).click();

        TimeUnit.SECONDS.sleep(3);
    }

    public void loginLoopMarketplace(int i) throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        try {
            loginLogoutPage.anmeldenButton().click();
        } catch (Exception e) {
            System.out.println("dont need it");
        }
        TimeUnit.SECONDS.sleep(3);
        loginLogoutPage.username().sendKeys(prop.getProperty("marketPlaceName"));
        loginLogoutPage.password().sendKeys(prop.getProperty("marketPlacePassword"));

        TimeUnit.SECONDS.sleep(3);
        accessAllCookies(driver);

        loginLogoutPage.anmelden().click();
        TimeUnit.SECONDS.sleep(3);
    }

    public void loginAdmin() throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.username().sendKeys(prop.getProperty("adminName"));
        loginLogoutPage.password().sendKeys(prop.getProperty("adminPassword"));
        loginLogoutPage.anmelden().click();

        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void logout() throws InterruptedException {
        LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
        loginLogoutPage.userOption().click();
        loginLogoutPage.logout().click();

        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void cleanUp() {
        if (driver != null) {
            System.out.println("CleanUp");
            driver.quit();
            driver = null; //maybe here
        }
    }
}
