package departments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.departments.DepartmentPage;
import resources.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateFairHouseOffer extends BaseClass {
    @Test
    public void createFairHouseOrganisation() throws IOException, InterruptedException {
        initializeBrowser();
        loadProps();

        for (int i = 0; i < Integer.parseInt(prop.getProperty("counting")); i++) {
            loginLoop(i);
            System.out.println("fertig");
            //because we have to move explicit to our select fields
            Actions actions = new Actions(driver);

            loadPropsForDepartment();
            loadPropsForFairHouseOfferDepartment();
            DepartmentPage departmentPage = new DepartmentPage(driver);

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.addDepartmentCard())).click();
            } catch (Exception e) {
                System.out.println("Card will be clicked.");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.addDepartment())).click();
            } catch (Exception e) {
                System.out.println("first Department");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.addFirstFairHouseOfferDepartment())).click();
            } catch (Exception e) {
                System.out.println("first Department");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.addFairHouseOfferDepartment())).click();
            } catch (Exception e) {
                System.out.println("n'th Department");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.accessibilityApartment())).click();
            } catch (Exception e) {
                System.out.println("accessibilityApartment");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.accessibilityApartmentArea())).click();
            } catch (Exception e) {
                System.out.println("accessibilityApartmentArea");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.accessibility())).click();
            } catch (Exception e) {
                System.out.println("accessibility");
            }

            try {
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.conformation())).click();
            } catch (Exception e) {
                System.out.println("conformation");
            }

            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.submitButton())).click();

            //allgemeine Angaben
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

            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='residentialProperty.type']"))).click();
            try {
                departmentPage.apartmentTypeChosen().click();
            } catch (Exception e) {
                System.out.println("apartmentTypeChosen");
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
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(departmentPage.saveDepartment())).click();
            TimeUnit.SECONDS.sleep(4);
            logout();
        }
        driver.quit();
    }
}
