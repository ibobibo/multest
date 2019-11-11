package pageObjectsMarketplace.pageObjectsInformationPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarePage {

    WebDriver driver;

    public CarePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[contains(@class,'elementor-button elementor-size-lg elementor-animation-grow')]")
    WebElement careCard;

    @FindBy(xpath = "//a[contains(text(),'Pflegebedürftigkeit')]")
    WebElement pflegebedürftigkeit;
    //mehr Info
    @FindBy(xpath = "//a[contains(text(),'Feststellung der Pflegebedürftigkeit')]")
    WebElement feststellungDerPflegebedürftigkeit;
    @FindBy(xpath = "//a[contains(text(),'Pflegebedürftigkeit von Kindern')]")
    WebElement pflegebedürftigkeitVonKindern;

    @FindBy(xpath = "//div[@class='elementor-element elementor-element-258c6974 elementor-widget elementor-widget-heading']//a[contains(text(),'Beantragung von Leistungen der Pflegekasse')]")
    WebElement beantragungLeistungen;
    @FindBy(xpath = "//a[contains(text(),'Die Pflegegrade')]")
    WebElement pflegegrade;
    @FindBy(xpath = "//a[contains(text(),'Pflegeberatung')]")
    WebElement pflegeberatung;
    @FindBy(xpath = "//div[@class='elementor-element elementor-element-6b1fe09f elementor-widget elementor-widget-heading']//a[contains(text(),'Alle Leistungen der Pflegekassen nach Pflegegrad i')]")
    WebElement leistungenDerPflegekassenNachGrad;

    @FindBy(xpath = "//a[contains(text(),'Die Leistungen im Einzelnen')]")
    WebElement leistungImEinzelnen;
    //mehrInfo
    @FindBy(xpath = "//a[contains(text(),'Pflegegeld')]")
    WebElement pflegegeld;
    @FindBy(xpath = "//a[contains(text(),'Pflegesachleistungen')]")
    WebElement pflegesachleistungen;
    @FindBy(xpath = "//div[contains(@class,'elementor-element elementor-element-133a9fda elementor-column elementor-col-25 elementor-inner-column')]//a[1]")
    WebElement kombinationsleistungen;
    @FindBy(xpath = "//a[contains(text(),'Kurzzeitpflege')]")
    WebElement kurzzeitpflege;
    @FindBy(xpath = "//div[contains(@class,'elementor-element elementor-element-4f1ae21 elementor-column elementor-col-25 elementor-inner-column')]//a[1]")
    WebElement verhinderungspflege;
    @FindBy(xpath = "//a[contains(text(),'Zusätzliche Betreuungs- und Entlastungsleistungen')]")
    WebElement zusätzlicheLeistungen;
    @FindBy(xpath = "//div[contains(@class,'elementor-element elementor-element-9849a7f elementor-widget elementor-widget-heading')]//h2[contains(@class,'elementor-heading-title elementor-size-default')]")
    WebElement tagesNachtPflege;
    @FindBy(xpath = "//a[contains(text(),'Pflegehilfsmittel')]")
    WebElement pflegehilfsmittel;
    @FindBy(xpath = "//section[contains(@class,'elementor-element elementor-element-9f92660 elementor-section-boxed elementor-section-height-default elementor-section-height-default elementor-section elementor-top-section')]//a[1]")
    WebElement wohnumfeldverbesserndeMaßnahmen;

    @FindBy(xpath = "//div[@class='elementor-element elementor-element-4c3d06d8 elementor-widget elementor-widget-heading']//a[contains(text(),'Leistungen der Krankenkassen')]")
    WebElement leistungenDerKrankenkassen;
    //mehrInfo
    @FindBy(xpath = "//a[contains(text(),'Pflege nach ärztlicher Verordnung (Behandlungspfle')]")
    WebElement pflegeNachÄrztlicherVerordnung;
    @FindBy(xpath = "//a[contains(text(),'Verordnung einer Krankenbeförderung (Transportsche')]")
    WebElement verordnungEinerKrankenbeförderung;
    @FindBy(xpath = "//a[contains(text(),'Spezialisierte ambulante Palliativversorgung (SPAV')]")
    WebElement spezialisiertePalliativversorgung;
    @FindBy(xpath = "//a[contains(text(),'Außerklinische Intensivpflege')]")
    WebElement außerklinischeIntensivpflege;
    @FindBy(xpath = "//a[contains(text(),'Hospiz')]")
    WebElement hospiz;
    @FindBy(xpath = "//a[contains(text(),'Allgemeine Vorsorge-untersuchungen')]")
    WebElement allgemeineVorsorgeuntersuchungen;

    @FindBy(xpath = "//a[contains(text(),'Hilfe für pflegende Angehörige mit Arbeitsverhältn')]")
    WebElement hilfeFuerAngehoerige;
    //mehrInfo
    @FindBy(xpath = "//a[contains(text(),'Pflegezeit und Familienpflegezeit')]")
    WebElement pflegeUndFamilienpflegezeit;
    @FindBy(xpath = "//a[contains(text(),'Pflegeunterstützungsgeld')]")
    WebElement pflegeunterstützungsgeld;
    @FindBy(xpath = "//div[contains(@class,'elementor-element elementor-element-6a11762c elementor-column elementor-col-25 elementor-inner-column')]//div[@class='elementor-widget-wrap']")
    WebElement selbstPflege;

    @FindBy(xpath = "//a[contains(text(),'Pflegeeinrichtungen')]")
    WebElement pflegeeinrichtungen;
    //mehrInfo
    @FindBy(xpath = "//a[contains(text(),'Ambulante Pflege')]")
    WebElement ambulantePflege;
    @FindBy(xpath = "//a[contains(text(),'Tages- und Nachtpflege')]")
    WebElement tagesUndNachtpflege;
    @FindBy(xpath = "//a[contains(text(),'Stationäre Pflege')]")
    WebElement stationärePflege;
    @FindBy(xpath = "//a[contains(text(),'Krankenhaus')]")
    WebElement krankenhaus;

    @FindBy(xpath = "//a[contains(text(),'Pflegebedürftige Menschen versorgen - was heißt da')]")
    WebElement pflegebedürftigeMenschenVersorgen;

    @FindBy(xpath = "//a[contains(text(),'Andere Menschen vertreten')]")
    WebElement andereMenschenVertreten;
    //mehrInfo
    @FindBy(xpath = "//a[contains(text(),'Patientenverfügung')]")
    WebElement patientenverfügung;
    @FindBy(xpath = "//a[contains(text(),'Vollmacht')]")
    WebElement vollmacht;
    @FindBy(xpath = "//a[contains(text(),'Vorsorgevollmacht')]")
    WebElement vorsorgevollmacht;
    @FindBy(xpath = "//a[contains(text(),'Gesetzliche Betreuung')]")
    WebElement gesetzlicheBetreuung;

    @FindBy(xpath = "//a[contains(text(),'Grundpflegerische Maßnahmen')]")
    WebElement grundpflegerischeMaßnahmen;
    //mehrInfo
    @FindBy(xpath = "//a[contains(text(),'Pflegebedarf identifizieren')]")
    WebElement pflegebedarfIdentifizieren;
    @FindBy(xpath = "//a[contains(text(),'Mund-, Nasen und Ohrenpflege')]")
    WebElement mundNaseOhrenPflege;
    @FindBy(xpath = "//div[contains(@class,'elementor-element elementor-element-64aa5880 elementor-column elementor-col-25 elementor-inner-column')]//a[1]")
    WebElement teilUndGanzkörperpflege;
    @FindBy(xpath = "//a[contains(text(),'Fußpflege und medizinische Fußpflege')]")
    WebElement medizinischeFußpflege;

    @FindBy(xpath = "//a[contains(text(),'Vorbeugen ist besser als Heilen - Prophylaktische')]")
    WebElement vorbeugenBesserAlsHeilen;
    //mehrInfo
    @FindBy(xpath = "//a[contains(text(),'Sturzprophylaxe')]")
    WebElement sturzprophylaxe;
    @FindBy(xpath = "//a[contains(text(),'Thromboseprophylaxe')]")
    WebElement thromboseprophylaxe;
    @FindBy(xpath = "//a[contains(text(),'Dekubitusprophylaxe')]")
    WebElement dekubitusprophylaxe;
    @FindBy(xpath = "//a[contains(text(),'Obstipationsprophylaxe')]")
    WebElement obstipationsprophylaxe;
    @FindBy(xpath = "//a[contains(text(),'Pneumonieprophylaxe')]")
    WebElement pneumonieprophylaxe;
    @FindBy(xpath = "//a[contains(text(),'Kontrakturprophylaxe')]")
    WebElement kontrakturprophylaxe;
    @FindBy(xpath = "//a[contains(text(),'Intertrigoprophylaxe')]")
    WebElement intertrigoprophylaxe;
    @FindBy(xpath = "//a[contains(text(),'Aspirationsprophylaxe')]")
    WebElement aspirationsprophylaxe;
    @FindBy(xpath = "//a[contains(text(),'Mundsoor- und Parotitisprophylaxe')]")
    WebElement mundsoorUndParotitisprophylaxe;

    @FindBy(xpath = "//a[contains(text(),'Hygiene')]")
    WebElement hygiene;

    @FindBy(xpath = "//a[contains(text(),'Spezieller Pflegebedarf bei schwerer Krankheit')]")
    WebElement speziellerPflegebedarf;
    //mehrInfo
    @FindBy(xpath = "//a[contains(text(),'Pflege bei Demenz')]")
    WebElement pflegeBeiDemenz;
    @FindBy(xpath = "//a[contains(text(),'Pflege nach Schlaganfall')]")
    WebElement pflegeNachSchlaganfall;
    @FindBy(xpath = "//a[contains(text(),'Pflege bei Herzerkrankungen')]")
    WebElement pflegeBeiHerzerkrankung;
    @FindBy(xpath = "//a[contains(text(),'Pflege bei Diabetes Mellitus')]")
    WebElement pflegeBeiDiabetesMellitus;
    @FindBy(xpath = "//a[contains(text(),'Pflege bei Atemwegserkrankungen')]")
    WebElement pflegeBeiAtemwegserkrankung;
    @FindBy(xpath = "//a[contains(text(),'Pflege bei Tumorleiden')]")
    WebElement pflegeBeiTumorleiden;
    @FindBy(xpath = "//a[contains(text(),'Pflege nach Kochenbrüchen')]")
    WebElement pflegeNachKnochenbrüchen;
    @FindBy(xpath = "//a[contains(text(),'Pflege bei PEG (perkutane enterale Gastrostomie)')]")
    WebElement pflegeBeiPEG;
    @FindBy(xpath = "//a[contains(text(),'Pflege bei Harnkatheterismus')]")
    WebElement pflegeBeiHarnkatheterismus;


    public WebElement careCard() {
        return careCard;
    }

    public WebElement pflegebedürftigkeit() {
        return pflegebedürftigkeit;
    }

    //mehr Info
    public WebElement feststellungDerPflegebedürftigkeit() {
        return feststellungDerPflegebedürftigkeit;
    }

    public WebElement pflegebedürftigkeitVonKindern() {
        return pflegebedürftigkeitVonKindern;
    }

    public WebElement beantragungLeistungen() {
        return beantragungLeistungen;
    }

    public WebElement pflegegrade() {
        return pflegegrade;
    }

    public WebElement pflegeberatung() {
        return pflegeberatung;
    }

    public WebElement leistungenDerPflegekassenNachGrad() {
        return leistungenDerPflegekassenNachGrad;
    }

    public WebElement leistungImEinzelnen() {
        return leistungImEinzelnen;
    }

    //mehrInfo
    public WebElement pflegegeld() {
        return pflegegeld;
    }

    public WebElement pflegesachleistungen() {
        return pflegesachleistungen;
    }

    public WebElement kombinationsleistungen() {
        return kombinationsleistungen;
    }

    public WebElement kurzzeitpflege() {
        return kurzzeitpflege;
    }

    public WebElement verhinderungspflege() {
        return verhinderungspflege;
    }

    public WebElement zusätzlicheLeistungen() {
        return zusätzlicheLeistungen;
    }

    public WebElement tagesNachtPflege() {
        return tagesNachtPflege;
    }

    public WebElement pflegehilfsmittel() {
        return pflegehilfsmittel;
    }

    public WebElement wohnumfeldverbesserndeMaßnahmen() {
        return wohnumfeldverbesserndeMaßnahmen;
    }


    public WebElement leistungenDerKrankenkassen() {
        return leistungenDerKrankenkassen;
    }

    //mehrInfo
    public WebElement pflegeNachÄrztlicherVerordnung() {
        return pflegeNachÄrztlicherVerordnung;
    }

    public WebElement verordnungEinerKrankenbeförderung() {
        return verordnungEinerKrankenbeförderung;
    }

    public WebElement spezialisiertePalliativversorgung() {
        return spezialisiertePalliativversorgung;
    }

    public WebElement außerklinischeIntensivpflege() {
        return außerklinischeIntensivpflege;
    }

    public WebElement hospiz() {
        return hospiz;
    }

    public WebElement allgemeineVorsorgeuntersuchungen() {
        return allgemeineVorsorgeuntersuchungen;
    }


    public WebElement hilfeFuerAngehoerige() {
        return hilfeFuerAngehoerige;
    }

    //mehrInfo
    public WebElement pflegeUndFamilienpflegezeit() {
        return pflegeUndFamilienpflegezeit;
    }

    public WebElement pflegeunterstützungsgeld() {
        return pflegeunterstützungsgeld;
    }

    public WebElement selbstPflege() {
        return selbstPflege;
    }


    public WebElement pflegeeinrichtungen() {
        return pflegeeinrichtungen;
    }

    //mehrInfo
    public WebElement ambulantePflege() {
        return ambulantePflege;
    }

    public WebElement tagesUndNachtpflege() {
        return tagesUndNachtpflege;
    }

    public WebElement stationärePflege() {
        return stationärePflege;
    }

    public WebElement krankenhaus() {
        return krankenhaus;
    }


    public WebElement pflegebedürftigeMenschenVersorgen() {
        return pflegebedürftigeMenschenVersorgen;
    }

    public WebElement andereMenschenVertreten() {
        return andereMenschenVertreten;
    }

    //mehrInfo
    public WebElement patientenverfügung() {
        return patientenverfügung;
    }

    public WebElement vollmacht() {
        return vollmacht;
    }

    public WebElement vorsorgevollmacht() {
        return vorsorgevollmacht;
    }

    public WebElement gesetzlicheBetreuung() {
        return gesetzlicheBetreuung;
    }


    public WebElement grundpflegerischeMaßnahmen() {
        return grundpflegerischeMaßnahmen;
    }

    //mehrInfo
    public WebElement pflegebedarfIdentifizieren() {
        return pflegebedarfIdentifizieren;
    }

    public WebElement mundNaseOhrenPflege() {
        return mundNaseOhrenPflege;
    }

    public WebElement teilUndGanzkörperpflege() {
        return teilUndGanzkörperpflege;
    }

    public WebElement medizinischeFußpflege() {
        return medizinischeFußpflege;
    }


    public WebElement vorbeugenBesserAlsHeilen() {
        return vorbeugenBesserAlsHeilen;
    }

    //mehrInfo
    public WebElement sturzprophylaxe() {
        return sturzprophylaxe;
    }

    public WebElement thromboseprophylaxe() {
        return thromboseprophylaxe;
    }

    public WebElement dekubitusprophylaxe() {
        return dekubitusprophylaxe;
    }

    public WebElement obstipationsprophylaxe() {
        return obstipationsprophylaxe;
    }

    public WebElement pneumonieprophylaxe() {
        return pneumonieprophylaxe;
    }

    public WebElement kontrakturprophylaxe() {
        return kontrakturprophylaxe;
    }

    public WebElement intertrigoprophylaxe() {
        return intertrigoprophylaxe;
    }

    public WebElement aspirationsprophylaxe() {
        return aspirationsprophylaxe;
    }

    public WebElement mundsoorUndParotitisprophylaxe() {
        return mundsoorUndParotitisprophylaxe;
    }


    public WebElement hygiene() {
        return hygiene;
    }


    public WebElement speziellerPflegebedarf() {
        return speziellerPflegebedarf;
    }

    //mehrInfo
    public WebElement pflegeBeiDemenz() {
        return pflegeBeiDemenz;
    }

    public WebElement pflegeNachSchlaganfall() {
        return pflegeNachSchlaganfall;
    }

    public WebElement pflegeBeiHerzerkrankung() {
        return pflegeBeiHerzerkrankung;
    }

    public WebElement pflegeBeiDiabetesMellitus() {
        return pflegeBeiDiabetesMellitus;
    }

    public WebElement pflegeBeiAtemwegserkrankung() {
        return pflegeBeiAtemwegserkrankung;
    }

    public WebElement pflegeBeiTumorleiden() {
        return pflegeBeiTumorleiden;
    }

    public WebElement pflegeNachKnochenbrüchen() {
        return pflegeNachKnochenbrüchen;
    }

    public WebElement pflegeBeiPEG() {
        return pflegeBeiPEG;
    }

    public WebElement pflegeBeiHarnkatheterismus() {
        return pflegeBeiHarnkatheterismus;
    }
}
