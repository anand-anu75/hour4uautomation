package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class AddChampsWorkOrderVendor extends BaseTest {
    
    JavascriptExecutor jsExecutor;

    // Constructor
    public AddChampsWorkOrderVendor(WebDriver driver) {
        BaseTest.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements declarations
    WebElement moreWorkorder;
    WebElement AddChampsDash;
    WebElement SelectChamps;
    WebElement SendReqButton;
    WebElement ChampAddedMessage;
    WebElement JobSeekerScheduledash;
    WebElement btn_Workorder;
    WebElement btn_CreateWorkorder;
    WebElement Dialog_box;
    WebElement btn_SelectProject;
    WebElement btn_AddDetails;
    WebElement btn_SearchAddress;
    WebElement input_EnterDate;
    WebElement btn_StartTime;
    WebElement btn_SelectStarttime;
    WebElement btn_EndTime;
    WebElement btn_SelectEndtime;
    WebElement btn_Addbilling;
    WebElement btn_AddTitle;
    WebElement input_EnterTitle;
    WebElement InputPhoneOrEmail;
    WebElement InputPassword;

    // Method to click the "Work Order" button
    public void clickOnWorkorderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Workorder")))).click();
    }
    
    // Method to click the "Create Work Order" button
    public void clickOnCreateWorkorderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_CreateWorkorder")))).click();
    }

    // Method to navigate to the dialog box
    public void NavigateTodialogBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("Dialog_box")))).click();
    }

    // Method to click the "Select Project" button
    public void clickOnSelectProjectButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectProject")))).click();
    }

    // Method to click the "Add Details" button
    public void clickOnAddDetailsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddDetails")))).click();
    }

    // Method to click the "Search Address" button
    public void clickOnSearchAddressButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SearchAddress")))).click();
    }

    // Method to enter a date in the date field
    public void enterDate(String enterDate) {
        input_EnterDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_EnterDate"))));
        input_EnterDate.click(); // Clicking the input field before sending keys, if required
        input_EnterDate.sendKeys(enterDate);
    }

    // Method to click the "Start Time" button
    public void clickOnStartTimeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_StartTime")))).click();
    }

    // Method to select the start time
    public void clickOnSelectStarttimeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectStarttime")))).click();
    }

    // Method to click the "End Time" button
    public void clickOnEndTimeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_EndTime")))).click();
    }
    
    // Method to select the end time
    public void clickOnSelectEndtimeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectEndtime")))).click();
    }

    // Method to click the "Add Billing" button
    public void clickOnAddBillingButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Addbilling")))).click();
    }

    // Method to click the "Add Title" button
    public void clickOnAddTitleButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddTitle")))).click();
    }
    
    // Method to enter a title
    public void enterTitle(String enterTitle) {
        input_EnterTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_EnterTitle"))));
        input_EnterTitle.click(); // Clicking the input field before sending keys, if required
        input_EnterTitle.sendKeys(enterTitle);
    }
    
    // Method to click the "Add Vendor" button
    public void clickOnAddVendorBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddVendorBtn")))).click();
    }

    // Method to click the "Select Vendor" button
    public void clickOnSelectVendor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectVendor")))).click();
    }
    
    // Method to click the "See Summary" button
    public void clickOnSeeSummaryButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SeeSummary")))).click();
    }

    // Method to click the "Submit for Approval" button
    public void clickOnSubmitforApprovalButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SubmitforApproval")))).click();
    } 
    
    // Method to click the "Dashboard" button
    public void clickOnAddDashBoard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Dashboard")))).click();
    }
    
    // Method to click the "More Options" button
    public void clickMoreOptions() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("moreWorkorder")))).click();
    }
    
    // Method to click the "Add Champs" button
    public void clickAddChamps() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("AddChampsDashboard")))).click();
    }
    
    // Method to enter the email
    public void enterEmail(String Email) {
        InputPhoneOrEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputPhoneOrEmail"))));
        InputPhoneOrEmail.click();
        InputPhoneOrEmail.sendKeys(Email);
    }

    // Method to enter the password
    public void enterPassword(String Password) {
        InputPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputPassword"))));
        InputPassword.click();
        InputPassword.sendKeys(Password);
    }

    // Method to click the "Login" button
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("LoginButton")))).click();
    }
    
    // Method to click the "Select Champs" button
    public void clickSelectChamp() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("SelectChamps")))).click();
    }
    
    // Method to click the "Send Request" button
    public void clickSendReq() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("SendReqButton")))).click();
    }
    
    // Method to get the success message after adding a champ
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ChampAddedMessage")))).getText();
    }
}