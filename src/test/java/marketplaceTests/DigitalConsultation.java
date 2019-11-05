package marketplaceTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.DigitalConsultationPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DigitalConsultation extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForMarketplace();
        TimeUnit.SECONDS.sleep(1);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void digitalConsultation() throws InterruptedException {
        DigitalConsultationPage digitalConsultationPage = new DigitalConsultationPage(driver);
        TimeUnit.SECONDS.sleep(1);
        //clickDigitalConsultation
        digitalConsultationPage.clickDigitalConsultation().click();
        TimeUnit.SECONDS.sleep(1);

        //firstSite
        digitalConsultationPage.postalCode().sendKeys("13599 Berlin");
        TimeUnit.SECONDS.sleep(2);
        digitalConsultationPage.checkboxDigitalConsultation().click();
        digitalConsultationPage.nextPage().click();
        TimeUnit.SECONDS.sleep(1);

        //secondSite
        String xpathForWhichPerson = "//section[@class='SingleSelectList']//label[" + getRandomNumberInRange(1, 3) + "]";
        WebElement forWhichPersonRadioButton = driver.findElement(By.xpath(xpathForWhichPerson));
        forWhichPersonRadioButton.click();
        digitalConsultationPage.nursingDegreeAvailable().click();
        digitalConsultationPage.nextPage().click();
        TimeUnit.SECONDS.sleep(1);

        //thirdSite
        String xpathForWhichNursingDegree = "//section[@class='SingleSelectList']//label[" + getRandomNumberInRange(1, 5) + "]";
        WebElement forWhichNursingDegreeRadioButton = driver.findElement(By.xpath(xpathForWhichNursingDegree));
        forWhichNursingDegreeRadioButton.click();
        digitalConsultationPage.nextPage().click();
        TimeUnit.SECONDS.sleep(1);

        //fourthSite
        for (int y = 1; y < 13; y++) {
            TimeUnit.SECONDS.sleep(1);

            WebElement interestField = driver.findElement(By.xpath("//section[@class='MultiSelectTiles']//div[@class='answer-container']//div[" + getRandomNumberInRange(1, 12) + "]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", interestField);
            Actions actions = new Actions(driver);
            actions.moveToElement(interestField).click().build().perform();
        }
        digitalConsultationPage.nextPage().click();
        TimeUnit.SECONDS.sleep(3);

        //interestedChosenParts
        //card 1
        if (digitalConsultationPage.pflegeTitle().isDisplayed()) {
            for (int i = 0; i < 6; i++) {
                String xpathForLabelsInPflegeTitle = "//section[@class='MultiSelectList']//label[" + getRandomNumberInRange(1, 5) + "]";
                WebElement webElemForLabelsInPflegeTitle = driver.findElement(By.xpath(xpathForLabelsInPflegeTitle));
                webElemForLabelsInPflegeTitle.click();
            }
            String xpathForRadioButtonsInPflegeTitle = "//label[" + getRandomNumberInRange(1, 5) + "]//div[1]";
            WebElement webElemForRadioButtonsInPflegeTitle = driver.findElement(By.xpath(xpathForRadioButtonsInPflegeTitle));
            webElemForRadioButtonsInPflegeTitle.click();
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(3);

        //card 2
        if (digitalConsultationPage.hauswirtschaftTitle().isDisplayed()) {
            for (int i = 0; i < 6; i++) {
                String xpathForCardsInHauswirtschaftTitle = "//section[@class='MultiSelectTiles']/div[@class='answer-container']/div[" + getRandomNumberInRange(1, 5) + "]/div[1]";
                WebElement webElemForCardsInHauswirtschaftTitle = driver.findElement(By.xpath(xpathForCardsInHauswirtschaftTitle));
                webElemForCardsInHauswirtschaftTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(3);

        //card 3
        if (digitalConsultationPage.mobilitaetTitle().isDisplayed()) {
            for (int i = 0; i < 14; i++) {
                String xpathForLabelsInMobilitaetTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 13) + "]";
                WebElement webElemForLabelsInMobilitaetTitle = driver.findElement(By.xpath(xpathForLabelsInMobilitaetTitle));
                webElemForLabelsInMobilitaetTitle.click();
            }
            digitalConsultationPage.yesButtonCard3().click();
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 4
        if (digitalConsultationPage.mobilitaetTitle().isDisplayed()) {
            for (int i = 0; i < 13; i++) {
                String xpathForLabelsInMobilitaetTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 12) + "]]";
                WebElement webElemForLabelsInMobilitaetTitle = driver.findElement(By.xpath(xpathForLabelsInMobilitaetTitle));
                webElemForLabelsInMobilitaetTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 5
        if (digitalConsultationPage.essenTrinkenTitle().isDisplayed()) {
            for (int i = 0; i < 4; i++) {
                String xpathForLabelsInEssenTrinkenTitle = "//section[@class='MultiSelectTiles']/div[@class='answer-container']/div[" + getRandomNumberInRange(1, 3) + "]/div[1]";
                WebElement webElemForLabelsInEssenTrinkenTitle = driver.findElement(By.xpath(xpathForLabelsInEssenTrinkenTitle));
                webElemForLabelsInEssenTrinkenTitle.click();
            }
            for (int i = 0; i < 4; i++) {
                String xpathForLabelsInEssenTrinkenTitle = "//section[2]//label[" + getRandomNumberInRange(1, 3) + "]";
                WebElement webElemForLabelsInEssenTrinkenTitle = driver.findElement(By.xpath(xpathForLabelsInEssenTrinkenTitle));
                webElemForLabelsInEssenTrinkenTitle.click();
            }
            for (int i = 0; i < 6; i++) {
                String xpathForLabelsInEssenTrinkenTitle = "//section[3]//label[" + getRandomNumberInRange(1, 5) + "]";
                WebElement webElemForLabelsInEssenTrinkenTitle = driver.findElement(By.xpath(xpathForLabelsInEssenTrinkenTitle));
                webElemForLabelsInEssenTrinkenTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 6.1
        if (digitalConsultationPage.unterstuetzungBeiKrankheitTitle().isDisplayed()) {
            for (int i = 0; i < 8; i++) {
                String xpathForLabelsInUnterstuetzungBeiKrankheitTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 7) + "]";
                WebElement webElemForLabelsInUnterstuetzungBeiKrankheitTitle = driver.findElement(By.xpath(xpathForLabelsInUnterstuetzungBeiKrankheitTitle));
                webElemForLabelsInUnterstuetzungBeiKrankheitTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 6.2
        if (digitalConsultationPage.unterstuetzungBeiKrankheitTitle().isDisplayed()) {
            for (int i = 0; i < 4; i++) {
                String xpathForLabelsInUnterstuetzungBeiKrankheitTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 2) + "]";
                WebElement webElemForLabelsInUnterstuetzungBeiKrankheitTitle = driver.findElement(By.xpath(xpathForLabelsInUnterstuetzungBeiKrankheitTitle));
                webElemForLabelsInUnterstuetzungBeiKrankheitTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 6.3
        if (digitalConsultationPage.unterstuetzungBeiKrankheitTitle().isDisplayed()) {
            String xpathForLabelsInUnterstuetzungBeiKrankheitTitle = "//label[" + getRandomNumberInRange(1, 4) + "]//div[1]";
            WebElement webElemForLabelsInUnterstuetzungBeiKrankheitTitle = driver.findElement(By.xpath(xpathForLabelsInUnterstuetzungBeiKrankheitTitle));
            webElemForLabelsInUnterstuetzungBeiKrankheitTitle.click();
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 6.4
        if (digitalConsultationPage.unterstuetzungBeiKrankheitTitle().isDisplayed()) {
            for (int i = 0; i < 3; i++) {
                String xpathForLabelsInUnterstuetzungBeiKrankheitTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 2) + "]";
                WebElement webElemForLabelsInUnterstuetzungBeiKrankheitTitle = driver.findElement(By.xpath(xpathForLabelsInUnterstuetzungBeiKrankheitTitle));
                webElemForLabelsInUnterstuetzungBeiKrankheitTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 6.5
        if (digitalConsultationPage.unterstuetzungBeiKrankheitTitle().isDisplayed()) {
            for (int i = 0; i < 7; i++) {
                String xpathForLabelsInUnterstuetzungBeiKrankheitTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 6) + "]";
                WebElement webElemForLabelsInUnterstuetzungBeiKrankheitTitle = driver.findElement(By.xpath(xpathForLabelsInUnterstuetzungBeiKrankheitTitle));
                webElemForLabelsInUnterstuetzungBeiKrankheitTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 7.1
        if (digitalConsultationPage.hilfsmittelUndSicherheitImAlltagTitle().isDisplayed()) {
            digitalConsultationPage.yesButtonCard7().click();
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 7.2
        if (digitalConsultationPage.hilfsmittelUndSicherheitImAlltagTitle().isDisplayed()) {
            for (int i = 0; i < 15; i++) {
                String xpathForLabelsInHilfsmittelUndSicherheitImAlltagTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 14) + "]";
                WebElement webElemForLabelsInHilfsmittelUndSicherheitImAlltagTitle = driver.findElement(By.xpath(xpathForLabelsInHilfsmittelUndSicherheitImAlltagTitle));
                webElemForLabelsInHilfsmittelUndSicherheitImAlltagTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 8.1
        if (digitalConsultationPage.betreuungUndBegleitungTitle().isDisplayed()) {
            digitalConsultationPage.yesButtonCard8().click();
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 8.2
        if (digitalConsultationPage.betreuungUndBegleitungTitle().isDisplayed()) {
            for (int i = 0; i < 4; i++) {
                String xpathForLabelsInBetreuungUndBegleitungTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 3) + "]";
                WebElement webElemForLabelsInBetreuungUndBegleitungTitle = driver.findElement(By.xpath(xpathForLabelsInBetreuungUndBegleitungTitle));
                webElemForLabelsInBetreuungUndBegleitungTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 8.3
        if (digitalConsultationPage.betreuungUndBegleitungTitle().isDisplayed()) {
            for (int i = 0; i < 7; i++) {
                String xpathForLabelsInBetreuungUndBegleitungTitle = "//section[@class='MultiSelectTiles']/div[@class='answer-container']/div[" + getRandomNumberInRange(1, 6) + "]/div[1]";
                WebElement webElemForLabelsInBetreuungUndBegleitungTitle = driver.findElement(By.xpath(xpathForLabelsInBetreuungUndBegleitungTitle));
                webElemForLabelsInBetreuungUndBegleitungTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 9.1
        if (digitalConsultationPage.altersgerechtesWohnenTitle().isDisplayed()) {
            for (int i = 0; i < 4; i++) {
                String xpathForLabelsInAltersgerechtesWohnenTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 3) + "]";
                WebElement webElemForLabelsInAltersgerechtesWohnenTitle = driver.findElement(By.xpath(xpathForLabelsInAltersgerechtesWohnenTitle));
                webElemForLabelsInAltersgerechtesWohnenTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 9.2
        if (digitalConsultationPage.altersgerechtesWohnenTitle().isDisplayed()) {
            for (int i = 0; i < 25; i++) {
                String xpathForLabelsInAltersgerechtesWohnenTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 24) + "]";
                WebElement webElemForLabelsInAltersgerechtesWohnenTitle = driver.findElement(By.xpath(xpathForLabelsInAltersgerechtesWohnenTitle));
                webElemForLabelsInAltersgerechtesWohnenTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 9.3
        if (digitalConsultationPage.altersgerechtesWohnenTitle().isDisplayed()) {
            for (int i = 0; i < 20; i++) {
                String xpathForLabelsInAltersgerechtesWohnenTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 19) + "]";
                WebElement webElemForLabelsInAltersgerechtesWohnenTitle = driver.findElement(By.xpath(xpathForLabelsInAltersgerechtesWohnenTitle));
                webElemForLabelsInAltersgerechtesWohnenTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 9.4
        if (digitalConsultationPage.altersgerechtesWohnenTitle().isDisplayed()) {
            for (int i = 0; i < 19; i++) {
                String xpathForLabelsInAltersgerechtesWohnenTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 18) + "]";
                WebElement webElemForLabelsInAltersgerechtesWohnenTitle = driver.findElement(By.xpath(xpathForLabelsInAltersgerechtesWohnenTitle));
                webElemForLabelsInAltersgerechtesWohnenTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 9.5
        if (digitalConsultationPage.altersgerechtesWohnenTitle().isDisplayed()) {
            for (int i = 0; i < 15; i++) {
                String xpathForLabelsInAltersgerechtesWohnenTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 14) + "]";
                WebElement webElemForLabelsInAltersgerechtesWohnenTitle = driver.findElement(By.xpath(xpathForLabelsInAltersgerechtesWohnenTitle));
                webElemForLabelsInAltersgerechtesWohnenTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 10.1
        if (digitalConsultationPage.zuHauseBleibenTitle().isDisplayed()) {
            String xpathForLabelsInPflegeTitle = "//label[" + getRandomNumberInRange(1, 4) + "]//div[1]";
            WebElement webElemForLabelsInPflegeTitle = driver.findElement(By.xpath(xpathForLabelsInPflegeTitle));
            webElemForLabelsInPflegeTitle.click();

            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);

        //card 10.2
        if (digitalConsultationPage.zuHauseBleibenTitle().isDisplayed()) {
            for (int i = 0; i < 10; i++) {
                String xpathForLabelsInZuHauseBleibenTitle = "//div[@id='app-view-container']//label[" + getRandomNumberInRange(1, 9) + "]";
                WebElement webElemForLabelsInZuHauseBleibenTitle = driver.findElement(By.xpath(xpathForLabelsInZuHauseBleibenTitle));
                webElemForLabelsInZuHauseBleibenTitle.click();
            }
            digitalConsultationPage.nextPage().click();
        }
        TimeUnit.SECONDS.sleep(1);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
