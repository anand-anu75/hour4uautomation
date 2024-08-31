package pages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;
 
public class CreateworkorderPage extends BaseTest {
 

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
    
    WebElement btn_SeeSummary;
    
    WebElement btn_SubmitforApproval;
    
    WebElement msg_WorkOrderCreatedSuccessfully;
    
    WebElement btn_ClickOnProfile;
    
    WebElement btn_Logout;
    
    
    
    // Constructor to initialize the driver and web elements
    public CreateworkorderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void clickOnWorkorderButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Workorder"))))
 		.click();
     }
 
    public void clickOnCreateWorkorderButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_CreateWorkorder"))))
 		.click();
     }
    
    public void NavigateTodialogBox() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("Dialog_box"))))
 		.click();
     }
    
    public void clickOnSelectProjectButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectProject"))))
 		.click();
     }
    
    public void clickOnAddDetailsButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddDetails"))))
 		.click();
     }
    
    public void clickOnSearchAddressButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SearchAddress"))))
 		.click();
     }
    public void enterDate(String enterDate) {
    	input_EnterDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_EnterDate"))));
    	input_EnterDate.click(); // Clicking the input field before sending keys, if required
    	input_EnterDate.sendKeys(enterDate);
    }
	
    
    public void clickOnStartTimeButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_StartTime"))))
 		.click();
     }
    
    public void clickOnSelectStarttimeButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectStarttime"))))
 		.click();
     }
    
    public void clickOnEndTimeButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_EndTime"))))
 		.click();
     }
    
    public void clickOnSelectEndtimeButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectEndtime"))))
 		.click();
     }
    
    public void clickOnAddBillingButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Addbilling"))))
 		.click();
     }
    
    public void clickOnAddTitleButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddTitle"))))
 		.click();
     }
    
    
    public void enterTitle(String enterTitle) {
    	input_EnterTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_EnterTitle"))));
    	input_EnterTitle.click(); // Clicking the input field before sending keys, if required
    	input_EnterTitle.sendKeys(enterTitle);
    }
	
  
 
    public void clickOnSeeSummaryButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SeeSummary"))))
 		.click();
     }
    
    public void clickOnSubmitforApprovalButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SubmitforApproval"))))
 		.click();
     } 
    
    public String getSuccessmessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("msg_WorkOrderCreatedSuccessfully")))).getText();
    }
    
    public String getLocationErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidLocation")))).getText();
    }
    
    public String getDateErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidDate")))).getText();
    }
    
    public String getStarttimeErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidStartTime")))).getText();
    }
    
    public String getEndtimeErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidEndTime")))).getText();
    }
    
    public void clickOnProfile() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnProfile"))))
 		.click();
     } 
    
    public void clickOnLogout() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Logout"))))
 		.click();
     } 
    
public void enterDhruviEmail(String phoneOrEmail) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_enterDhruviEmail"))))
		.sendKeys(phoneOrEmail);
	}

public void enterDhruviPassword(String EnterPassword) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_enterDhruviPassword"))))
	.sendKeys(EnterPassword);
}

public void clickOnLoginButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnLogin"))))
		.click();
 }
    
    
    
}