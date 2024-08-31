package testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import pages.InvitingclientPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class AcceptRejectFromClients extends BaseTest{
	
	InvitingclientPage ClientPage;
	CreateworkorderPage WorkorderPage;
	CreateProjectPage ProjectPage;
	@Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
	    public void AcceptRejectClients(String Name, String Phone, String Email, String Address, String
	    		expectedSuccessMessage, String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
	    		String LinkURL,String EnterMetrics,String EnterQuantity,String StartDate,String EndDate,String FieldName, String EnterFrequency,
	    		String EnterRadius,String EnterItem, String EnterDescription
	    		,String EnterRates,String EnterQty, String EnterDays, String ExpectedResult, String Date, String Title, String
	    		expectedSuccessmessage) throws InterruptedException {
	        ClientPage = new InvitingclientPage(driver);
	        ProjectPage = new CreateProjectPage(driver);
	        WorkorderPage = new CreateworkorderPage(driver);
	
	        ClientPage.clickOnUserButton();
	       
	        ClientPage.clickOnClientsOption();
	
	        ClientPage.clickOnInviteClientButton();
	       
	        ClientPage.NavigateToDialogBox();
	       
	       
	        ClientPage.enterClientName(Name);
	       
	        ClientPage.enterMobileNumber(Phone);
	       
	        ClientPage.enterEmail(Email);
	       
	        ClientPage.enterAddress(Address);
	       
	        ClientPage.clickOnCreateClientButton();
	       
	      //ProjectPage.clickOnErrorMessage();
	        ProjectPage.clickOnProjectTabButton();
	      //ProjectPage.clickOnErrorMessage();
	        ProjectPage.clickOnCreateProjectButton();
	        ProjectPage.clickOnSelfClientButton();
	        ProjectPage.clickOnNext1Button();
	        Thread.sleep(2000);
	        ProjectPage.clickOnProjectTypeButton();
	        ProjectPage.clickOnSelectProjectTypeButton();
	        ProjectPage.clickOnHotspotButton();
	        ProjectPage.clickOnNext2Button();
	        //ProjectPage.clickOnProjectDetailsButton();
	        ProjectPage.enterProjectTitle(ProjectTitle);
	        ProjectPage.enterProjectDescription(ProjectDescription);
	        ProjectPage.enterProjectCode(ProjectCode);
	        ProjectPage.enterLinkTitle(LinkTitle);
	        ProjectPage.enterURL(LinkURL);
	        ProjectPage.enterMetrics(EnterMetrics);
	        ProjectPage.enterQuantity(EnterQuantity);
	        ProjectPage.clickOnStartDateButton();
	      //ProjectPage.enterStartDate(StartDate);
	        ProjectPage.clickOnSelectStartDate();
	        ProjectPage.clickOnEndDateButton();
	      //ProjectPage.enterEndDate(EndDate);
	        ProjectPage.clickOnSelectEndDate();
	        ProjectPage.clickOnSelectLocationButton();
	        ProjectPage.clickOnSelectLocationDelhiButton();
	        ProjectPage.clickOnAddTrackingButton();
	        ProjectPage.enterFieldName(FieldName);
	        ProjectPage.clickOnFieldTypeDropDown();
	        ProjectPage.clickOnPhoneNumberButton();
	        ProjectPage.clickOnContinuousLocationTracking();
	        ProjectPage.enterFrequency(EnterFrequency);
	        ProjectPage.enterRadius(EnterRadius);
	        //ProjectPage.clickOnOnlyGpsCoordinate();
	        ProjectPage.clickOnAddBilling();
	        ProjectPage.clickOnPricingFixed();
	        ProjectPage.enterItem(EnterItem);
	        ProjectPage.enterDescription(EnterDescription);
	        ProjectPage.enterRate(EnterRates);
	        ProjectPage.enterQty(EnterQty);
	        ProjectPage.enterDays(EnterDays);
	        ProjectPage.clickOnReviewProject();
	        ProjectPage.clickOnSaveProject();
	        ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
	       
	        
	       
	        WorkorderPage.clickOnWorkorderButton();
	       
	    	WorkorderPage.clickOnCreateWorkorderButton();
	       
	    	WorkorderPage.NavigateTodialogBox();
	
	    	WorkorderPage.clickOnSelectProjectButton();
	   	
	    	WorkorderPage.clickOnAddDetailsButton();
	   	
	        WorkorderPage.clickOnSearchAddressButton(); 	
	   	
	    	WorkorderPage.enterDate(Date);
	   	
	    	WorkorderPage.clickOnStartTimeButton();
	   	
	    	WorkorderPage.clickOnSelectStarttimeButton();
	   	
	   	Actions actions = new Actions(driver);
	    	    actions.sendKeys(Keys.ESCAPE).perform();
	   	
	    	WorkorderPage.clickOnEndTimeButton();
	   	
	        WorkorderPage.clickOnSelectEndtimeButton();
	   	   	
	  	    WorkorderPage.clickOnAddBillingButton();
	     	
	  	    WorkorderPage.clickOnAddTitleButton();
	     
	  	    WorkorderPage.enterTitle(Title);
	     	
	  	    WorkorderPage.clickOnSeeSummaryButton();
	   	
	    	    WorkorderPage.clickOnSubmitforApprovalButton();
	   
 
	     	  String actualSuccessmessage = WorkorderPage.getSuccessmessage();
	            softAssert.assertEquals(actualSuccessmessage, expectedSuccessmessage);
	     
	            softAssert.assertAll();
 
	  
	    }
	
	// Accept/Reject from Clients - Invalid Enterprise
	
	@Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void AcceptRejectInvalidEnterprise(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ExpectedMessage) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        ClientPage.enterClientName(Name);
       
        ClientPage.enterMobileNumber(Phone);
       
        ClientPage.enterEmail(Email);
       
        ClientPage.enterAddress(Address);
       
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       // ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
   //     ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        
        String AcceptRejectInvalidEnterprise = ProjectPage.AcceptRejectInvalidEnterprise();
        softAssert.assertEquals(AcceptRejectInvalidEnterprise, ExpectedMessage);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}    
	}
	
	//Accept Reject Invalid Project Type
	
	@Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void AcceptRejectInvalidProjectType(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ExpectedResult) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        ClientPage.enterClientName(Name);
       
        ClientPage.enterMobileNumber(Phone);
       
        ClientPage.enterEmail(Email);
       
        ClientPage.enterAddress(Address);
       
        ClientPage.clickOnCreateClientButton();
        
        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        Thread.sleep(2000);
        ProjectPage.SelectOptionEnterprise();
        Thread.sleep(2000);
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
    //    ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnNext2Button();
        
        String ExistingInvalidProjectType = ProjectPage.ExistingInvalidProjectType();
        softAssert.assertEquals(ExistingInvalidProjectType, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }
	
	// Accept Reject From Client - Invalid Project Title
	
	@Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void AcceptRejectInvalidProjectTitle(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        ClientPage.enterClientName(Name);
       
        ClientPage.enterMobileNumber(Phone);
       
        ClientPage.enterEmail(Email);
       
        ClientPage.enterAddress(Address);
       
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
      //  ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.clickOnSelectLocationButton();
        
        String InvalidProjectTitle = ProjectPage.InvalidProjectTitle();
        softAssert.assertEquals(InvalidProjectTitle, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }
	
	//Accept Reject From Client - Invalid Project Description
	
	@Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void AcceptRejectInvalidProjectDesc(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        ClientPage.enterClientName(Name);
       
        ClientPage.enterMobileNumber(Phone);
       
        ClientPage.enterEmail(Email);
       
        ClientPage.enterAddress(Address);
       
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.clickOnSelectLocationButton();
        
        String InvalidProjectDescription = ProjectPage.EnterProperProjectDescription();
        softAssert.assertEquals(InvalidProjectDescription, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }
	
	//Accept/Reject from Client - Invalid Frequency
	
	@Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void AcceptRejectInvalidFrequency(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        ClientPage.enterClientName(Name);
       
        ClientPage.enterMobileNumber(Phone);
       
        ClientPage.enterEmail(Email);
       
        ClientPage.enterAddress(Address);
       
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        Thread.sleep(2000);
        ProjectPage.SelectOptionEnterprise();
        Thread.sleep(2000);
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();  
        //ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.enterProjectCode(ProjectCode);
        ProjectPage.enterLinkTitle(LinkTitle);
        ProjectPage.enterURL(LinkURL);
        ProjectPage.enterMetrics(EnterMetrics);
        ProjectPage.enterQuantity(EnterQuantity);
        ProjectPage.clickOnStartDateButton();
        ProjectPage.clickOnSelectStartDate();
        ProjectPage.clickOnEndDateButton();
        ProjectPage.clickOnSelectEndDate();
        ProjectPage.clickOnSelectLocationButton();
        ProjectPage.clickOnSelectLocationDelhiButton();
        ProjectPage.clickOnAddTrackingButton();
        ProjectPage.enterFieldName(FieldName);
        ProjectPage.clickOnFieldTypeDropDown();
        ProjectPage.clickOnPhoneNumberButton();
        ProjectPage.clickOnContinuousLocationTracking();
        ProjectPage.enterFrequency(EnterFrequency);
        ProjectPage.enterRadius(EnterRadius);
        //ProjectPage.clickOnOnlyGpsCoordinate();
        ProjectPage.clickOnAddBilling();
        
        String InvalidFrequency = ProjectPage.InvalidFrequency();
        softAssert.assertEquals(InvalidFrequency, ExpectedResult);
        try {
    		softAssert.assertAll();
    	} catch (AssertionError e) {
    		assertionMessage.set(e.getMessage());
    		throw e;
    	}
    }
	
	// Accept/Reject for Client - Invalid Radius
	
	@Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void AcceptRejectInvalidRadius(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        ClientPage.enterClientName(Name);
       
        ClientPage.enterMobileNumber(Phone);
       
        ClientPage.enterEmail(Email);
       
        ClientPage.enterAddress(Address);
       
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        Thread.sleep(2000);
        ProjectPage.SelectOptionEnterprise();
        Thread.sleep(2000);
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();  
      //ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.enterProjectCode(ProjectCode);
        ProjectPage.enterLinkTitle(LinkTitle);
        ProjectPage.enterURL(LinkURL);
        ProjectPage.enterMetrics(EnterMetrics);
        ProjectPage.enterQuantity(EnterQuantity);
        ProjectPage.clickOnStartDateButton();
        ProjectPage.clickOnSelectStartDate();
        ProjectPage.clickOnEndDateButton();
        ProjectPage.clickOnSelectEndDate();
        ProjectPage.clickOnSelectLocationButton();
        ProjectPage.clickOnSelectLocationDelhiButton();
        ProjectPage.clickOnAddTrackingButton();
        ProjectPage.enterFieldName(FieldName);
        ProjectPage.clickOnFieldTypeDropDown();
        ProjectPage.clickOnPhoneNumberButton();
        ProjectPage.clickOnContinuousLocationTracking();
        ProjectPage.enterFrequency(EnterFrequency);
        ProjectPage.enterRadius(EnterRadius);
      //ProjectPage.clickOnOnlyGpsCoordinate();
       ProjectPage.clickOnAddBilling();
    
    
    String InvalidRadius = ProjectPage.InvalidRadius();
    softAssert.assertEquals(InvalidRadius, ExpectedResult);
    try {
		softAssert.assertAll();
	} catch (AssertionError e) {
		assertionMessage.set(e.getMessage());
		throw e;
	}
}
	

}
