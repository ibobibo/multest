package pageObjectsMarketplace.meetingRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AskForMeetingPage {
    WebDriver driver;

    public AskForMeetingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//section[@id='app-header']//li[3]")
    WebElement searchDepartmentTitle;
    @FindBy(xpath = "//section[@class='DepartmentSearchBase']//section[@class='Input  text     empty']//input[@id='location']")
    WebElement location;
    @FindBy(xpath = "//input[@id='freeTextSearch']")
    WebElement departmentName;
    @FindBy(xpath = "//section[@class='Input  select     empty']//div[@class='select-arrow-down select-arrow-up']//label[contains(text(),'Umkreis')]")
    WebElement selectPerimeter;
    @FindBy(xpath = "//section[@class='Input text empty invalid']//input[@id='freeTextSearch']")
    WebElement searchForDepartmentName;
    @FindBy(xpath = "//button[@id='publish-department']")
    WebElement searchDepartment;
    @FindBy(xpath = "//button[@id='close-preview']")
    WebElement otherOptions;
    @FindBy(xpath = "//body//tr[1]//a[@class='button primary more-information-btn']")
    WebElement moreInformation;
    @FindBy(xpath = "//div[contains(@class,'actions')]//button[contains(@class,'cta')]")
    WebElement askForMeeting;
    @FindBy(xpath = "//input[@id='phoneNumber']")
    WebElement phoneNumber;
    @FindBy(xpath = "//select[@id='desiredTimes']")
    WebElement wishTime;
    @FindBy(xpath = "//option[contains(text(),'08:00 bis 10:00')]")
    WebElement wishTimeChosen;
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement textAreaComment;
    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='primary']")
    WebElement next;
    @FindBy(xpath = "//button[@class='secondary cancelButton']")
    WebElement cancelButton;
    @FindBy(xpath = "//button[@class='secondary']")
    WebElement backButton;
    @FindBy(xpath = "//span[contains(text(),'Ich stimme der Übermittlung der oben genannten Dat')]")
    WebElement accept;
    @FindBy(xpath = "//li[@id='account-menu']")
    WebElement accountMenu;
    @FindBy(xpath = "//span[@class='logout']")
    WebElement accountMenuLogout;

    public WebElement searchDepartmentTitle() {
        return searchDepartmentTitle;
    }

    public WebElement location() {
        return location;
    }

    public WebElement departmentName() {
        return departmentName;
    }

    public WebElement selectPerimeter() {
        return selectPerimeter;
    }

    public WebElement searchForDepartmentName() {
        return searchForDepartmentName;
    }

    public WebElement searchDepartment() {
        return searchDepartment;
    }

    public WebElement otherOptions() {
        return otherOptions;
    }

    public WebElement moreInformation() {
        return moreInformation;
    }

    public WebElement askForMeeting() {
        return askForMeeting;
    }

    public WebElement phoneNumber() {
        return phoneNumber;
    }

    public WebElement wishTime() {
        return wishTime;
    }

    public WebElement wishTimeChosen() {
        return wishTimeChosen;
    }

    public WebElement textAreaComment() {
        return textAreaComment;
    }

    public WebElement next() {
        return next;
    }

    public WebElement cancelButton() {
        return cancelButton;
    }

    public WebElement backButton() {
        return backButton;
    }

    public WebElement accept() {
        return accept;
    }

    public WebElement accountMenu() {
        return accountMenu;
    }

    public WebElement accountMenuLogout() {
        return accountMenuLogout;
    }
}
