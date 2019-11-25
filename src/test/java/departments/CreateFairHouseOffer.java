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
        accessAllCookies();
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
            DepartmentPage fairHouseOfferPage = new DepartmentPage(driver);

            try {
                fairHouseOfferPage.addDepartment().click();
                TimeUnit.SECONDS.sleep(1);
                fairHouseOfferPage.addFairHouseOfferDepartment().click();
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println("Es wurde noch kein Department angelegt.");
            }

            try {
                fairHouseOfferPage.addFirstFairHouseOfferDepartment().click();
            } catch (Exception e) {
                System.out.println("Es existiert schon ein erstes Department");
            }

            try {
                fairHouseOfferPage.accessibilityApartment().click();
            } catch (Exception e) {
                System.out.println("accessibilityApartment");
            }
            try {
                fairHouseOfferPage.accessibilityApartmentArea().click();
            } catch (Exception e) {
                System.out.println("accessibilityApartmentArea");
            }
            try {
                fairHouseOfferPage.accessibility().click();
            } catch (Exception e) {
                System.out.println("accessibility");
            }
            try {
                fairHouseOfferPage.conformation().click();
            } catch (Exception e) {
                System.out.println("conformation");
            }
            TimeUnit.SECONDS.sleep(4);
            try {
                //Submit Button hat Fehler
                fairHouseOfferPage.submitButton().click();
                fairHouseOfferPage.submitButton().click();
                fairHouseOfferPage.submitButton().click();
            } catch (Exception e) {
                System.out.println("Submit Button in modal doesnt work!");
            }

            //allgemeine Angaben
            TimeUnit.SECONDS.sleep(4);

            WebElement findName = driver.findElement(By.id("name"));
            actions.moveToElement(findName).click().build().perform();

            try {
                fairHouseOfferPage.departmentName().sendKeys(propDepartment.getProperty("fairHouseOfferDepartmentName"));
            } catch (Exception e) {
                System.out.println("departmentName");
            }
            try {
                fairHouseOfferPage.departmentStreetAddress().sendKeys(propDepartment.getProperty("streetAddress"));
            } catch (Exception e) {
                System.out.println("departmentStreetAddress");
            }
            try {
                fairHouseOfferPage.departmentStreetNumber().sendKeys(propDepartment.getProperty("streetNumber"));
            } catch (Exception e) {
                System.out.println("departmentStreetNumber");
            }
            try {
                fairHouseOfferPage.departmentPostalCode().sendKeys(propDepartment.getProperty("postalCode"));
            } catch (Exception e) {
                System.out.println("departmentPostalCode");
            }
            try {
                fairHouseOfferPage.departmentAddressCity().sendKeys(propDepartment.getProperty("addressCity"));
            } catch (Exception e) {
                System.out.println("departmentAddressCity");
            }
            try {
                fairHouseOfferPage.departmentWebsite().sendKeys(propDepartment.getProperty("website"));
            } catch (Exception e) {
                System.out.println("departmentWebsite");
            }

            //angaben zur Person
            try {
                fairHouseOfferPage.departmentContactFirstName().sendKeys(propDepartment.getProperty("contactFirstName"));
            } catch (Exception e) {
                System.out.println("departmentContactFirstName");
            }
            try {
                fairHouseOfferPage.departmentContactLastName().sendKeys(propDepartment.getProperty("contactLastName"));
            } catch (Exception e) {
                System.out.println("departmentContactLastName");
            }
            try {
                fairHouseOfferPage.departmentContactTitle().sendKeys(propDepartment.getProperty("contactTitle"));
            } catch (Exception e) {
                System.out.println("departmentContactTitle");
            }
            try {
                fairHouseOfferPage.departmentContactPhone().sendKeys(propDepartment.getProperty("contactPhone"));
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
                fairHouseOfferPage.departmentContactSalutationChosen().click();
            } catch (Exception e) {
                System.out.println("departmentContactSalutationChosen");
            }

            //sprechzeiten
            fairHouseOfferPage.mondayHourBegin().sendKeys(propDepartment.getProperty("mondayHourBegin"));
            fairHouseOfferPage.mondayMinuteBegin().sendKeys(propDepartment.getProperty("mondayMinuteBegin"));
            fairHouseOfferPage.mondayHourEnd().sendKeys(propDepartment.getProperty("mondayHourEnd"));
            fairHouseOfferPage.mondayMinuteEnd().sendKeys(propDepartment.getProperty("mondayMinuteEnd"));

            fairHouseOfferPage.wednesdayHourBegin().sendKeys(propDepartment.getProperty("wednesdayHourBegin"));
            fairHouseOfferPage.wednesdayMinuteBegin().sendKeys(propDepartment.getProperty("wednesdayMinuteBegin"));
            fairHouseOfferPage.wednesdayHourEnd().sendKeys(propDepartment.getProperty("wednesdayHourEnd"));
            fairHouseOfferPage.wednesdayMinuteEnd().sendKeys(propDepartment.getProperty("wednesdayMinuteEnd"));

            fairHouseOfferPage.fridayHourBegin().sendKeys(propDepartment.getProperty("fridayHourBegin"));
            fairHouseOfferPage.fridayMinuteBegin().sendKeys(propDepartment.getProperty("fridayMinuteBegin"));
            fairHouseOfferPage.fridayHourEnd().sendKeys(propDepartment.getProperty("fridayHourEnd"));
            fairHouseOfferPage.fridayMinuteEnd().sendKeys(propDepartment.getProperty("fridayMinuteEnd"));

            //Allgemeine Beschreibung des Wohnprojekts
            try {
                fairHouseOfferPage.descriptionOfApartment().sendKeys(propFairHouseOffer.getProperty("descriptionOfApartment"));
            } catch (Exception e) {
                System.out.println("descriptionOfDepartment");
            }

            try {
                fairHouseOfferPage.provider().sendKeys(propFairHouseOffer.getProperty("provider"));
            } catch (Exception e) {
                System.out.println("provider");
            }
            try {
                fairHouseOfferPage.operator().sendKeys(propFairHouseOffer.getProperty("operator"));
            } catch (Exception e) {
                System.out.println("operator");
            }
            try {
                fairHouseOfferPage.operatorDescription().sendKeys(propFairHouseOffer.getProperty("operatorDescription"));
            } catch (Exception e) {
                System.out.println("operatorDescription");
            }
            try {
                fairHouseOfferPage.rental().sendKeys(propFairHouseOffer.getProperty("rental"));
            } catch (Exception e) {
                System.out.println("rental");
            }
            try {
                fairHouseOfferPage.available().sendKeys(propFairHouseOffer.getProperty("available"));
            } catch (Exception e) {
                System.out.println("available");
            }

            fairHouseOfferPage.toBuy().click();

            fairHouseOfferPage.price().sendKeys(propFairHouseOffer.getProperty("price"));
            fairHouseOfferPage.houseMoney().sendKeys(propFairHouseOffer.getProperty("houseMoney"));
            fairHouseOfferPage.additionalCosts().sendKeys(propFairHouseOffer.getProperty("additionalCosts"));
            fairHouseOfferPage.provision().sendKeys(propFairHouseOffer.getProperty("provision"));

            try {
                fairHouseOfferPage.numberOfRooms().sendKeys(propFairHouseOffer.getProperty("numberOfRooms"));
            } catch (Exception e) {
                System.out.println("numberOfRooms");
            }
            try {
                fairHouseOfferPage.livingSpace().sendKeys(propFairHouseOffer.getProperty("livingSpace"));
            } catch (Exception e) {
                System.out.println("livingSpace");
            }

            try {
                fairHouseOfferPage.energyDemand().sendKeys(propFairHouseOffer.getProperty("energyDemand"));
            } catch (Exception e) {
                System.out.println("energyDemand");
            }

            //Beschreibungen örtliche Gegebenheiten
            try {
                fairHouseOfferPage.constructionYear().sendKeys(propFairHouseOffer.getProperty("yearOfConstruction"));
            } catch (Exception e) {
                System.out.println("constructionYear");
            }
            try {
                fairHouseOfferPage.refurbishmentYear().sendKeys(propFairHouseOffer.getProperty("yearOfLastRefurbishment"));
            } catch (Exception e) {
                System.out.println("refurbishmentYear");
            }
            try {
                fairHouseOfferPage.numberOfCommonRooms().sendKeys(propFairHouseOffer.getProperty("numberOfCommonRooms"));
            } catch (Exception e) {
                System.out.println("numberOfCommonRooms");
            }

            //Youtube
            try {
                fairHouseOfferPage.youTubeVideo().sendKeys(propDepartment.getProperty("youTubeVideo"));
            } catch (Exception e) {
                System.out.println("youTubeVideo");
            }

            //save
            fairHouseOfferPage.saveDepartment().click();
            TimeUnit.SECONDS.sleep(2);

            try {
                WebElement apartmentProperty = driver.findElement(By.xpath("//select[@id='residentialProperty.type']"));
                actions.moveToElement(apartmentProperty).click().build().perform();
                fairHouseOfferPage.apartmentTypeChosen().click();
            } catch (Exception e) {
                System.out.println("residentialProperty.type");
            }

            fairHouseOfferPage.saveDepartment().click();

//            TimeUnit.SECONDS.sleep(6);
//            logout();
//            TimeUnit.SECONDS.sleep(4);
        }
    }

    @AfterTest
    public void closeBrowser() {
//        driver.close();
//        driver = null;
    }
}
