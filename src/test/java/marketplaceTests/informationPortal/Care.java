package marketplaceTests.informationPortal;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsMarketplace.pageObjectsInformationPortal.CarePage;
import resources.BaseClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Care extends BaseClass {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowserForInformationPortal();
        TimeUnit.SECONDS.sleep(2);
        accessAllCookies();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void care() throws IOException, InterruptedException {
        loadProps();
        CarePage carePage = new CarePage(driver);
        TimeUnit.SECONDS.sleep(2);

        carePage.careCard().click();
        TimeUnit.SECONDS.sleep(2);

        carePage.pflegebedürftigkeit().click();
        TimeUnit.SECONDS.sleep(2);
        //mehrInfo
        carePage.feststellungDerPflegebedürftigkeit().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.pflegebedürftigkeitVonKindern().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.beantragungLeistungen().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.pflegegrade().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.pflegeberatung().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.leistungenDerPflegekassenNachGrad().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.leistungImEinzelnen().click();
        TimeUnit.SECONDS.sleep(2);
        //mehrInfo
        carePage.pflegegeld().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.pflegesachleistungen().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.kombinationsleistungen().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.kurzzeitpflege().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.verhinderungspflege().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.zusätzlicheLeistungen().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.tagesNachtPflege().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.pflegehilfsmittel().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.wohnumfeldverbesserndeMaßnahmen().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.leistungenDerKrankenkassen().click();
        TimeUnit.SECONDS.sleep(2);
        //mehrInfo
        carePage.pflegeNachÄrztlicherVerordnung().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.verordnungEinerKrankenbeförderung().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.spezialisiertePalliativversorgung().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.außerklinischeIntensivpflege().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.hospiz().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.allgemeineVorsorgeuntersuchungen().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.hilfeFuerAngehoerige().click();
        TimeUnit.SECONDS.sleep(2);
        //mehrInfo
        carePage.pflegeUndFamilienpflegezeit().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.pflegeunterstützungsgeld().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(3);
        carePage.selbstPflege().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(4);

        carePage.pflegeeinrichtungen().click();
        TimeUnit.SECONDS.sleep(2);
        //mehrInfo
        carePage.ambulantePflege().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.tagesUndNachtpflege().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.stationärePflege().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.krankenhaus().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.pflegebedürftigeMenschenVersorgen().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.andereMenschenVertreten().click();
        TimeUnit.SECONDS.sleep(2);

        //mehrInfo
        carePage.patientenverfügung().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs1.get(0));

        carePage.vollmacht().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs2.get(0));

        TimeUnit.SECONDS.sleep(2);
        carePage.vorsorgevollmacht().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs3 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs3.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs3.get(0));

        TimeUnit.SECONDS.sleep(2);
        carePage.gesetzlicheBetreuung().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs4 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs4.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs4.get(0));
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.grundpflegerischeMaßnahmen().click();
        TimeUnit.SECONDS.sleep(2);
        //mehrInfo
        carePage.pflegebedarfIdentifizieren().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs5 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs5.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs5.get(0));

        TimeUnit.SECONDS.sleep(2);
        carePage.mundNaseOhrenPflege().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs6 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs6.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs6.get(0));

        TimeUnit.SECONDS.sleep(2);
        carePage.teilUndGanzkörperpflege().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs7 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs7.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs7.get(0));

        TimeUnit.SECONDS.sleep(2);
        carePage.medizinischeFußpflege().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs8 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs8.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs8.get(0));
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.vorbeugenBesserAlsHeilen().click();
        TimeUnit.SECONDS.sleep(2);
        //mehrInfo
        carePage.sturzprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.thromboseprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.dekubitusprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.obstipationsprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.pneumonieprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.kontrakturprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.intertrigoprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.aspirationsprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        carePage.mundsoorUndParotitisprophylaxe().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.hygiene().click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);

        carePage.speziellerPflegebedarf().click();
        TimeUnit.SECONDS.sleep(2);

        //mehrInfo
        carePage.pflegeBeiDemenz().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs9 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs9.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs9.get(0));

        carePage.pflegeNachSchlaganfall().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs10 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs10.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs10.get(0));

        carePage.pflegeBeiHerzerkrankung().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs11 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs11.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs11.get(0));

        carePage.pflegeBeiDiabetesMellitus().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs12 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs12.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs12.get(0));

        carePage.pflegeBeiAtemwegserkrankung().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs13 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs13.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs13.get(0));

        carePage.pflegeBeiTumorleiden().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs14 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs14.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs14.get(0));

        carePage.pflegeNachKnochenbrüchen().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs15 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs15.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs15.get(0));

        carePage.pflegeBeiPEG().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs16 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs16.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs16.get(0));

        carePage.pflegeBeiHarnkatheterismus().click();
        TimeUnit.SECONDS.sleep(2);
        ArrayList<String> tabs17 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs17.get(1));
        driver.close();
        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().window(tabs17.get(0));
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(2);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
