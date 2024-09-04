package testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class GetProjectApprovalAgencies extends BaseTest {
	
	//Get Project Approvals - Agencies
    // Workorder is done Successfully

    @Test(dependsOnMethods = {"testcase.LoginDhruviEnterprise.loginDhruviEnterprise"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ProjectApprovalAgencies(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String StartDate,String EndDate,String FieldName, String EnterFrequency, 
    		String EnterRadius,String EnterItem, String EnterDescription
    		,String EnterRates,String EnterQty, String EnterDays, String ExpectedResult,
    		String SearchAgency,String EnterAgencyEmail,String EnterOTP,String Date, String Title, 
    		String expectedSuccessmessage,String phoneOrEmail,String EnterPassword,String ExpectedMessage
) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
        CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
       ProjectPage.clickOnCreateProjectButton();
 //       ProjectPage.clickOnSelfClientButton();
 //       ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
  //      ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
//        Thread.sleep(2000);
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
//      ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
        Thread.sleep(2000);
        ProjectPage.ClickOnAssignAgency();
        ProjectPage.enterSearchAgency(SearchAgency);
        Thread.sleep(2000);
        ProjectPage.ClickOnAugustAgency();
        ProjectPage.clickOnSearchAssignAgency();
        ProjectPage.clickOnProfileButton();
        ProjectPage.clickOnLogoutButton();
        ProjectPage.enterAgencyEmail(EnterAgencyEmail);
        ProjectPage.clickOnSignInUsingOTP();
        ProjectPage.clickOnGetOTP();
        ProjectPage.enterOTPforAgencyLogin(EnterOTP);
        ProjectPage.clickOnLoginButton();
        ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
        ProjectPage.clickOnAcceptProject();
        
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
    	    Thread.sleep(2000);
    	    	
    	    WorkorderPage.clickOnAddBillingButton();
     	
    	    WorkorderPage.clickOnAddTitleButton();
     
    	    WorkorderPage.enterTitle(Title);
     	
    	    WorkorderPage.clickOnSeeSummaryButton();
    	
    	    WorkorderPage.clickOnSubmitforApprovalButton();
    	//    ProjectPage.clickOnErrorMessage();
    	    
    	    ProjectPage.clickOnProfileButton();
            ProjectPage.clickOnLogoutButton();
    	    WorkorderPage.enterDhruviEmail(phoneOrEmail);
    	    WorkorderPage.enterDhruviPassword(EnterPassword);
    	    WorkorderPage.clickOnLoginButton();
    	    ProjectPage.clickOnErrorMessage();
    	    ProjectPage.clickOnAcceptWorkOrder();
    	    
    	   
         
            
        
    	   String actualSuccessmessage = WorkorderPage.WorkOrderApprovedMessage();
           softAssert.assertEquals(actualSuccessmessage, ExpectedMessage);
    
           try {
   			softAssert.assertAll();
   		} catch (AssertionError e) {
   			assertionMessage.set(e.getMessage());
   			throw e;
   		}
        
    }
    

    //Existing Enterprise - Invalid Project Type
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ProjectApproveInvalidProjectTyp(String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
    
    // Existing Enterprise - Invalid Project Title
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ProjectApprovInvalidProjectTltl(String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        Thread.sleep(2000);
        ProjectPage.SelectDropdownEnterprise();
        Thread.sleep(2000);
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
    
    //Existing Enterprise - Invalid Project Description
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ProjectApprovInvalidProjectDesc(String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
    
    //Existing Enterprise - Invalid Field Name
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ProjectApprovInvalidFieldName(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
    
    
        String InvalidFieldName = ProjectPage.InvalidFieldName();
        softAssert.assertEquals(InvalidFieldName, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
}
    
    //Existing Enterprise - Invalid Frequency
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ProjectApprovInvalidFrequency(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
    
  //ProjectPage.clickOnErrorMessage();
    ProjectPage.clickOnProjectTabButton();
   //ProjectPage.clickOnErrorMessage();
    ProjectPage.clickOnCreateProjectButton();
    //ProjectPage.clickOnSelfClientButton();
    Thread.sleep(2000);
    ProjectPage.clickOnExistingEnterprise();
    ProjectPage.SelectDropdownEnterprise();
    ProjectPage.SelectOptionEnterprise();
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
    
    //Existing Enterprise - Invalid Radius
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ProjectApprovInvalidRadius(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        Thread.sleep(2000);
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
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
