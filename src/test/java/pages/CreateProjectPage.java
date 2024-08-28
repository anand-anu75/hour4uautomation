package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class CreateProjectPage extends BaseTest{
	
	WebElement tab_Project;

	WebElement btn_CreateProject;
	
	WebElement btn_SelfClient;
	
	WebElement btn_Next1;
	
	WebElement btn_ProjectType;
	
	WebElement btn_SelectProjectType;
	
	WebElement drpd_Hotspot;
	
	WebElement btn_Next2;
	
	WebElement btn_ProjectDetails;
	
	WebElement txt_ProjectTitle;
	
	WebElement txt_ProjectDescription;
	
	WebElement txt_ProjectCode;
	
	WebElement txt_LinkTitle;
	
	WebElement txt_LinkURL;
	
	WebElement txt_Metrics;
	
	WebElement txt_EnterQuantity;
	
	WebElement btn_StartDate;
	
	WebElement txt_EnterStartDate;
	
	WebElement txt_EnterEndDate;
	
	WebElement btn_EndDate;
	
	WebElement btn_SelectLocation;
	
	WebElement btn_SelectDelhi;
	
	WebElement btn_AddTracking;
	
	WebElement txt_FieldName;
	
	WebElement drpd_FieldType;
	
	WebElement btn_PhoneNumber;
	
	WebElement checkbox_ContinousLocationTracking;
	
	WebElement txt_EnterFrequency;
	
	WebElement txt_EnterRadius;

	WebElement btn_OnlyGpsCoordinate;
	
	WebElement btn_AddBilling;
	
	WebElement btn_PricingFixed;

	WebElement txt_EnterItem;
	
	WebElement txt_EnterDescription;
	
	WebElement txt_EnterRate;
	
	WebElement txt_EnterQty;

	WebElement txt_EnterDays;
	
	WebElement btn_ReviewProject;
	
	WebElement btn_SaveProject;
	
	WebElement ProjectSuccessfullyCreated_msg;
	
	WebElement SelectedImproperProjectType_msg;
	
	WebElement EnterProperProjectDescription_msg;
	
	WebElement btn_ErrorClose;
	
	WebElement InvalidFieldName_msg;
	
	WebElement InvalidFieldType_msg;
	
	WebElement InvalidFrequency_msg;
	
	WebElement InvalidRadius_msg;
	
	WebElement InvalidProjectTitle_msg;
	
	WebElement btn_NewClient;
	
	WebElement txt_Name;
	
	WebElement txt_Mobile;
	
	WebElement txt_Email;
	
	WebElement txt_Address;
	
	WebElement btn_CreateEnterprise;
	
	WebElement EnterpriseProjectSuccessfullyCreated_msg;
	
	WebElement btn_ExistingClient;
	
	WebElement drpd_SelectEnterprise;
	
	WebElement drpd_SelectOptionEnterprise;
	
	WebElement btn_AddCustomFields;
	
	WebElement txt_CustomFieldName;
	
	WebElement drpd_CustomFieldType;
	
	WebElement drpd_CustomFieldText;
	
	WebElement btn_AddCustomField;
	
	WebElement txt_EnterCustomText;
	
	WebElement btn_SelectQuoteDate;
	
	WebElement btn_SelectValidDate;
	
	WebElement txt_PaymentTerms;
	
	WebElement txt_TermsAndConditions;
	
	WebElement drpd_SelectProjectType;
	
	WebElement btn_CLickOnEndDate;
	
	WebElement btn_AddAditionalItems;
	
	WebElement btn_ToggleSwitch;
	
	WebElement msg_ProjectCreatedSuccessfullyClose;
	
	WebElement msg_InvalidEnterprise;
	
	WebElement msg_SelectEnterprise;
	
	// Initializing Driver
	
	public CreateProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	//Clicking on Project Tab
	
	public void clickOnProjectTabButton() {
       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("tab_Project"))))
		.click();
    }
	
	// Creating Project
	
	public void clickOnCreateProjectButton() {
        //wait.until(ExpectedConditions.visibilityOf(btn_CreateProject)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_CreateProject"))))
		.click();
    }
	
	//Selecting Self Client Option
	
	public void clickOnSelfClientButton() {
       // wait.until(ExpectedConditions.visibilityOf(btn_SelfClient)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelfClient"))))
		.click();
    }
	
	// Next is button is clicked
	
	public void clickOnNext1Button() {
       // wait.until(ExpectedConditions.visibilityOf(btn_Next1)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Next1"))))
		.click();
    }
	
	//Selecting the Project type option
	
	public void clickOnProjectTypeButton() throws InterruptedException {
       // wait.until(ExpectedConditions.visibilityOf(btn_ProjectType)).click();
		
		WebElement ProjectTypeButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_ProjectType"))));
		ProjectTypeButton.click();
		Thread.sleep(2000);
		ProjectTypeButton.click();
    }
	
	// Selecting Project type
	
	public void clickOnSelectProjectTypeButton() {
        //wait.until(ExpectedConditions.visibilityOf(btn_SelectProjectType)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drpd_SelectProjectType"))))
		.click();
    }
	
	//selecting Hotspot as an option
	
	public void clickOnHotspotButton() {
       // wait.until(ExpectedConditions.visibilityOf(btn_Hotspot)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drpd_Hotspot"))))
		.click();
    }
	
	//Clicking Next Button
	
	public void clickOnNext2Button() {
        //wait.until(ExpectedConditions.visibilityOf(btn_Next2)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Next2"))))
		.click();
    }
	
	//Selecting Project Details options
	
	public void clickOnProjectDetailsButton() {
        //wait.until(ExpectedConditions.visibilityOf(btn_ProjectDetails)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ProjectDetails"))))
		.click();
    }
	
	//Selecting Project title
	
	public void enterProjectTitle(String ProjectTitle) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_ProjectTitle"))))
		.sendKeys(ProjectTitle);
	}
	
	//Enter Project Description
	
	public void enterProjectDescription(String ProjectDescription) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_ProjectDescription"))))
		.sendKeys(ProjectDescription);
	}
	
	//Enter Project Code
	
	public void enterProjectCode(String ProjectCode) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_ProjectCode"))))
		.sendKeys(ProjectCode);
	}
	
	//Enter Link Title
	
public void enterLinkTitle(String LinkTitle) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_LinkTitle"))))
		.sendKeys(LinkTitle);
	}

// Enter Link URL

public void enterURL(String LinkURL) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_LinkURL"))))
	.sendKeys(LinkURL);
}

//Enter Metrics

public void enterMetrics(String EnterMetrics) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Metrics"))))
	.sendKeys(EnterMetrics);
}

//Enter Quantity

public void enterQuantity(String EnterQuantity) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterQuantity"))))
	.sendKeys(EnterQuantity);
}

//Click on Start Date Button

public void clickOnStartDateButton() throws InterruptedException {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_StartDate"))))
	.click();
}

//public void enterStartDate(String StartDate) {
//	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterStartDate"))))
//	.sendKeys(StartDate);
//}

//Selecting Start Date

public void clickOnSelectStartDate() throws InterruptedException {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectStartDate"))))
	.click();
}

// Click on End Date Button

public void clickOnEndDateButton() throws InterruptedException {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_StartDate"))))
	.click();
}

//public void enterEndDate(String EndDate) {
//	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterEndDate"))))
//	.sendKeys(EndDate);
//}

//Selecting EndDate

public void clickOnSelectEndDate() throws InterruptedException {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectEndDate"))))
    .click();
}
	
	
	//Selecting Add Location Button
	
	public void clickOnSelectLocationButton() {
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectLocation"))))
		.click();
    }
	
	//Select Location as Delhi option
	
public void clickOnSelectLocationDelhiButton() {
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectDelhi"))))
		.click();
    }

//Select Add Tracking

public void clickOnAddTrackingButton() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddTracking"))))
	.click();
}

//Enter Field Name
public void enterFieldName(String FieldName) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_FieldName"))))
	.sendKeys(FieldName);
}

//Select Field Type Drop-Down

public void clickOnFieldTypeDropDown() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drpd_FieldType"))))
	.click();
}

//Selecting Phone Number as an option

public void clickOnPhoneNumberButton() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_PhoneNumber"))))
	.click();
}

//Selecting Continuous Location Tracking 

public void clickOnContinuousLocationTracking() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("checkbox_ContinousLocationTracking"))))
	.click();
}

// Enter Frequency

public void enterFrequency(String EnterFrequency) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterFrequency"))))
	.sendKeys(EnterFrequency);
}

//Enter Radius

public void enterRadius(String EnterRadius) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterRadius"))))
	.sendKeys(EnterRadius);
}

//Selecting Only GPS-Coordinate

public void clickOnOnlyGpsCoordinate() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_OnlyGpsCoordinate"))))
	.click();
}

// Click on Add Billing

public void clickOnAddBilling() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddBilling"))))
	.click();
}

// Select Pricing Fixed

public void clickOnPricingFixed() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_PricingFixed"))))
	.click();
}

// Enter Item

public void enterItem(String EnterItem) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterItem"))))
	.sendKeys(EnterItem);
}

// Enter Description

public void enterDescription(String EnterDescription) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterDescription"))))
	.sendKeys(EnterDescription);
}

//Enter Rates

public void enterRate(String EnterRates) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterRate"))))
	.sendKeys(EnterRates);
}

//Enter Quantity

public void enterQty(String EnterQty) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterQty"))))
	.sendKeys(EnterQty);
}

//Enter Days

public void enterDays(String EnterDays) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterDays"))))
	.sendKeys(EnterDays);
}

// Click on Review Project

public void clickOnReviewProject() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ReviewProject"))))
	.click();
}

//Select Save Project

public void clickOnSaveProject() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SaveProject"))))
	.click();
}

//Display Project Created Successfully

public String ProjectCreatedSuccesfully() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ProjectSuccessfullyCreated_msg")))).getText();
	
}

//Display Selected Improper Project Type

public String SelectedImproperProjectType() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("SelectedImproperProjectType_msg")))).getText();
	
}

//Display Enter Proper Project Description

public String EnterProperProjectDescription() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("EnterProperProjectDescription_msg")))).getText();
	
}

//Click on Error Message Dialogue Box

public void clickOnErrorMessage() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ErrorClose"))))
	.click();
}

//Display Invalid Field Name

public String InvalidFieldName() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidFieldName_msg")))).getText();
	
}

//Display Invalid Field Type

public String InvalidFielType() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidFieldType_msg")))).getText();
	
}

//Display Invalid Frequency

public String InvalidFrequency() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidFrequency_msg")))).getText();
	
}

//Display Invalid Radius

public String InvalidRadius() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidRadius_msg")))).getText();
	
}

//Display Invalid Project Title

public String InvalidProjectTitle() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidProjectTitle_msg")))).getText();
	
}

//Click on New Client

public void clickOnNewClient() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_NewClient"))))
	.click();
}

//Enter Name for New Creating New Client as a Project

public void enterName(String Name) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Name"))))
	.sendKeys(Name);
}

//Enter Mobile

public void enterMobile(String Mobile) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Mobile"))))
	.sendKeys(Mobile);
}

//Enter E-mail

public void enterEmail(String Email) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Email"))))
	.sendKeys(Email);
}

//Enter Address

public void enterAddress(String Address) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Address"))))
	.sendKeys(Address);
}

//Click on Create Enterprise Button

public void clickOnCreateEnterprise() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_CreateEnterprise"))))
	.click();
}

//Verify that New Enterprise Project Created Successfully

public String EnterpriseProjectCreatedSuccesfully() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("EnterpriseProjectSuccessfullyCreated_msg")))).getText();
	
}

//Click on Existing Enterprise

public void clickOnExistingEnterprise() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ExistingClient"))))
	.click();
}

//Select Drop-Down option for Enterprise

public void SelectDropdownEnterprise() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drpd_SelectEnterprise"))))
	.click();
}

//Select option from Drop-Down option on Existing Enterprise

public void SelectOptionEnterprise() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drpd_SelectOptionEnterprise"))))
	.click();
}

//Verify that Existing Enterprise project is created

public String ExistingCreatedSuccesfully() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ExistingProjectSuccessfullyCreated_msg")))).getText();
	
}

public void ClickOnAddCustomField() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddCustomFields"))))
	.click();
}

public void enterCustomFieldName(String CustomFieldName) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_CustomFieldName"))))
	.sendKeys(CustomFieldName);
}

public void SelectCustomFieldType() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drpd_CustomFieldType"))))
	.click();
}

public void SelectCustomTextArea() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drpd_CustomFieldText"))))
	.click();
}

public void ClickOnAddField() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddCustomField"))))
	.click();
}

public void enterCustomTextArea(String ABCD) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterCustomText"))))
	.sendKeys(ABCD);
}

public void ClickOnQuoteDate() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectQuoteDate"))))
	.click();
}

public void SelectValidDate() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SelectValidDate"))))
	.click();
}

public void enterPaymentTerms(String PaymentTerms) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_PaymentTerms"))))
	.sendKeys(PaymentTerms);
}

public void enterTermsAndConditions(String TermsAndConditions) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_TermsAndConditions"))))
	.sendKeys(TermsAndConditions);
}

public void SelectNewProjectType() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drpd_SelectProjectType"))))
	.click();
}

public void ClickOnEnterEndDate() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_CLickOnEndDate"))))
	.click();
}

public void ClickOnAddAditionalItems() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddAditionalItems"))))
	.click();
}

public String ExistingInvalidProjectType() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("SelectedImproperProjectType_msg")))).getText();
	
}

public void ClickOnToggleSwitch() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ToggleSwitch"))))
	.click();
}

public void ClickOnCloseMsgProjectCreatedSuccessfully() {
    
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("msg_ProjectCreatedSuccessfullyClose"))))
	.click();
}

public String ExistingInvalidEnterprise() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("msg_InvalidEnterprise")))).getText();
	
}

public String AcceptRejectInvalidEnterprise() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("msg_SelectEnterprise")))).getText();
	
}




}
