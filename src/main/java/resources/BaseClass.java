package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

public class BaseClass {
    public static RemoteWebDriver driver;
    public static Properties prop = new Properties();
    public static Properties propFairHouseOffer = new Properties();
    public static Properties propDepartment = new Properties();
    public static Properties propNewPlacement = new Properties();


    public WebDriver initializeDriver() throws IOException {
        loadProps();
        String browserName = prop.getProperty("browser");

        //check for browser
        if (browserName.equals("chrome")) {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        } else if (browserName.equals("firefox")) {
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        } else if (browserName.equals("edge")) {
            DesiredCapabilities cap = DesiredCapabilities.edge();
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        }
        System.out.println("after if");
        return driver;
    }

    public void getScreenshot(String name) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/main/java/screenShots/" + name + "_screenshot.png"));
    }

    public void initializeBrowser() throws IOException, InterruptedException {
        initializeDriver();
        System.out.println(prop.getProperty("urlFromHomeNetwork"));
        driver.get(prop.getProperty("urlFromHomeNetwork"));
    }

    public void initializeBrowserForMarketplace() throws IOException, InterruptedException {
        initializeDriver();
        driver.get(prop.getProperty("urlFromHomeNetworkMarketplace"));
    }

    public void initializeBrowserForInformationPortal() throws IOException, InterruptedException {
        initializeDriver();
        driver.get(prop.getProperty("urlForInformationPortal"));
    }

    public void initializeMailServer() throws IOException, InterruptedException {
        initializeDriver();
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

    public void accessAllCookies(RemoteWebDriver driver) {
        driver.findElement(By.xpath("//div[@id='CybotCookiebotDialog']//a[@id='CybotCookiebotDialogBodyButtonAccept']")).click();
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}