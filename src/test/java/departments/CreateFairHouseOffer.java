package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import resources.MulLoginLogout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateFairHouseOffer extends MulLoginLogout {

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        initializeBrowser();
        accessAllCookies(driver);
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void createFairHouseOrganisation() throws IOException, InterruptedException {
        loadProps();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loadProps();
            loginLoop(i);

            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);

            loadPropsForDepartment();
            loadPropsForFairHouseOfferDepartment();
            DepartmentPage departmentPage = new DepartmentPage(driver);

            try{
                departmentPage.addDepartmentCard().click();
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                System.out.println("Card wird geklickt.");
            }

            try {
                departmentPage.addDepartment().click();
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println("Es wurde noch kein Department angelegt.");
            }

            try {
                departmentPage.addFirstFairHouseOfferDepartment().click();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Es wurde noch kein Department angelegt.");
            }

            try {
                departmentPage.addFairHouseOfferDepartment().click();
            } catch (Exception e) {
                System.out.println("Es existiert schon ein erstes Department");
            }

            try {
                departmentPage.accessibilityApartment().click();
            } catch (Exception e) {
                System.out.println("accessibilityApartment");
            }
            try {
                departmentPage.accessibilityApartmentArea().click();
            } catch (Exception e) {
                System.out.println("accessibilityApartmentArea");
            }
            try {
                departmentPage.accessibility().click();
            } catch (Exception e) {
                System.out.println("accessibility");
            }
            try {
                departmentPage.conformation().click();
            } catch (Exception e) {
                System.out.println("conformation");
            }
            TimeUnit.SECONDS.sleep(4);
            try {
                //Submit Button hat Fehler
                departmentPage.submitButton().click();
                departmentPage.submitButton().click();
                departmentPage.submitButton().click();
            } catch (Exception e) {
                System.out.println("Submit Button in modal doesnt work!");
            }

            //allgemeine Angaben
            TimeUnit.SECONDS.sleep(4);

            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

            try {
                departmentPage.departmentName().sendKeys(propDepartment.getProperty("fairHouseOfferDepartmentName"));
            } catch (Exception e) {
                System.out.println("departmentName");
            }
            try {
                departmentPage.departmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
            } catch (Exception e) {
                System.out.println("departmentStreetAddress");
            }
            try {
                departmentPage.departmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
            } catch (Exception e) {
                System.out.println("departmentStreetNumber");
            }
            try {
                departmentPage.departmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
            } catch (Exception e) {
                System.out.println("departmentPostalCode");
            }
            try {
                departmentPage.departmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
            } catch (Exception e) {
                System.out.println("departmentAddressCity");
            }
            try {
                departmentPage.departmentWebsite().sendKeys(propDepartment.getProperty("website"));
            } catch (Exception e) {
                System.out.println("departmentWebsite");
            }

            //angaben zur Person
            try {
                departmentPage.departmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
            } catch (Exception e) {
                System.out.println("departmentContactFirstName");
            }
            try {
                departmentPage.departmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
            } catch (Exception e) {
                System.out.println("departmentContactLastName");
            }
            try {
                departmentPage.departmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
            } catch (Exception e) {
                System.out.println("departmentContactTitle");
            }
            try {
                departmentPage.departmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));
            } catch (Exception e) {
                System.out.println("departmentContactPhone");
            }

            WebElement contactSalutation = driver.findElement(By.id("contact.salutation"));
            try {
                actions.moveToElement(contactSalutation).click().build().perform();
            } catch (Exception e) {
                System.out.println("contactSalutation");
            }
            try {
                departmentPage.departmentContactSalutationChosen().click();
            } catch (Exception e) {
                System.out.println("departmentContactSalutationChosen");
            }

            //sprechzeiten
            departmentPage.mondayHourBegin().sendKeys(propDepartment.getProperty("mondayHourBegin"));
            departmentPage.mondayMinuteBegin().sendKeys(propDepartment.getProperty("mondayMinuteBegin"));
            departmentPage.mondayHourEnd().sendKeys(propDepartment.getProperty("mondayHourEnd"));
            departmentPage.mondayMinuteEnd().sendKeys(propDepartment.getProperty("mondayMinuteEnd"));

            departmentPage.wednesdayHourBegin().sendKeys(propDepartment.getProperty("wednesdayHourBegin"));
            departmentPage.wednesdayMinuteBegin().sendKeys(propDepartment.getProperty("wednesdayMinuteBegin"));
            departmentPage.wednesdayHourEnd().sendKeys(propDepartment.getProperty("wednesdayHourEnd"));
            departmentPage.wednesdayMinuteEnd().sendKeys(propDepartment.getProperty("wednesdayMinuteEnd"));

            departmentPage.fridayHourBegin().sendKeys(propDepartment.getProperty("fridayHourBegin"));
            departmentPage.fridayMinuteBegin().sendKeys(propDepartment.getProperty("fridayMinuteBegin"));
            departmentPage.fridayHourEnd().sendKeys(propDepartment.getProperty("fridayHourEnd"));
            departmentPage.fridayMinuteEnd().sendKeys(propDepartment.getProperty("fridayMinuteEnd"));

            //Allgemeine Beschreibung des Wohnprojekts
            try {
                departmentPage.descriptionOfApartment().sendKeys(propFairHouseOffer.getProperty("descriptionOfApartment"));
            } catch (Exception e) {
                System.out.println("descriptionOfDepartment");
            }

            try {
                departmentPage.provider().sendKeys(propFairHouseOffer.getProperty("provider"));
            } catch (Exception e) {
                System.out.println("provider");
            }
            try {
                departmentPage.operator().sendKeys(propFairHouseOffer.getProperty("operator"));
            } catch (Exception e) {
                System.out.println("operator");
            }
            try {
                departmentPage.operatorDescription().sendKeys(propFairHouseOffer.getProperty("operatorDescription"));
            } catch (Exception e) {
                System.out.println("operatorDescription");
            }
            try {
                departmentPage.rental().sendKeys(propFairHouseOffer.getProperty("rental"));
            } catch (Exception e) {
                System.out.println("rental");
            }
            try {
                departmentPage.available().sendKeys(propFairHouseOffer.getProperty("available"));
            } catch (Exception e) {
                System.out.println("available");
            }

            departmentPage.toBuy().click();

            departmentPage.price().sendKeys(propFairHouseOffer.getProperty("price"));
            departmentPage.houseMoney().sendKeys(propFairHouseOffer.getProperty("houseMoney"));
            departmentPage.additionalCosts().sendKeys(propFairHouseOffer.getProperty("additionalCosts"));
            departmentPage.provision().sendKeys(propFairHouseOffer.getProperty("provision"));

            try {
                departmentPage.numberOfRooms().sendKeys(propFairHouseOffer.getProperty("numberOfRooms"));
            } catch (Exception e) {
                System.out.println("numberOfRooms");
            }
            try {
                departmentPage.livingSpace().sendKeys(propFairHouseOffer.getProperty("livingSpace"));
            } catch (Exception e) {
                System.out.println("livingSpace");
            }

            try {
                departmentPage.energyDemand().sendKeys(propFairHouseOffer.getProperty("energyDemand"));
            } catch (Exception e) {
                System.out.println("energyDemand");
            }

            //Beschreibungen örtliche Gegebenheiten
            try {
                departmentPage.constructionYear().sendKeys(propFairHouseOffer.getProperty("yearOfConstruction"));
            } catch (Exception e) {
                System.out.println("constructionYear");
            }
            try {
                departmentPage.refurbishmentYear().sendKeys(propFairHouseOffer.getProperty("yearOfLastRefurbishment"));
            } catch (Exception e) {
                System.out.println("refurbishmentYear");
            }
            try {
                departmentPage.numberOfCommonRooms().sendKeys(propFairHouseOffer.getProperty("numberOfCommonRooms"));
            } catch (Exception e) {
                System.out.println("numberOfCommonRooms");
            }

            //Youtube
            try {
                departmentPage.youTubeVideo().sendKeys(propDepartment.getProperty("youTubeVideo"));
            } catch (Exception e) {
                System.out.println("youTubeVideo");
            }

            //save
            departmentPage.saveDepartment().click();
            TimeUnit.SECONDS.sleep(2);

            try {
                WebElement apartmentProperty = driver.findElement(By.xpath("//select[@id='residentialProperty.type']"));
                actions.moveToElement(apartmentProperty).click().build().perform();
                departmentPage.apartmentTypeChosen().click();
            } catch (Exception e) {
                System.out.println("residentialProperty.type");
            }

            departmentPage.saveDepartment().click();

//            TimeUnit.SECONDS.sleep(6);
//            logout();
//            TimeUnit.SECONDS.sleep(4);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver = null;
    }
}
