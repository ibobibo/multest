package digitalConsultation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DigitalConsultationPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DigitalConsultation extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void createStationaryOrganisation() throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);

            DigitalConsultationPage digitalConsultationPage = new DigitalConsultationPage(driver);

            //firstSite
            digitalConsultationPage.postalCode().sendKeys(prop.getProperty(""));
            digitalConsultationPage.checkboxDigitalConsultation().click();
            digitalConsultationPage.nextPage().click();

            //secondSite
            String xpathForWhichPerson = "//section[@class='SingleSelectList']//label[" + getRandomNumberInRange(1, 3) + "]";
            WebElement forWhichPersonRadioButton = driver.findElement(By.xpath(xpathForWhichPerson));
            forWhichPersonRadioButton.click();
            digitalConsultationPage.nursingDegreeAvailable().click();
            digitalConsultationPage.nextPage().click();

            //thirdSite
            String xpathForWhichNursingDegree = "//section[@class='SingleSelectList']//label[" + getRandomNumberInRange(1, 5) + "]";
            WebElement forWhichNursingDegreeRadioButton = driver.findElement(By.xpath(xpathForWhichNursingDegree));
            forWhichNursingDegreeRadioButton.click();
            digitalConsultationPage.nextPage().click();

            //fourthSite
            for(int y = 1; y < 6; y++){
                String xpathForInterestField = "//section[@class='MultiSelectTiles']//div[@class='answer-container']//div[" + getRandomNumberInRange(1, 12) + "]";
                WebElement interestField = driver.findElement(By.xpath(xpathForInterestField));
                interestField.click();
            }
            digitalConsultationPage.nextPage().click();


            logout();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
