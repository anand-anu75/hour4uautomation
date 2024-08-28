package testcase;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.InvitingclientPage;
import utilities.ReadXLData;

public class CreateProjectForCilentAgencies extends BaseTest{
	
 //Create Project for Client/Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void createProjectForAgencies(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String StartDate,String EndDate,String FieldName, String EnterFrequency, 
    		String EnterRadius,String EnterItem, String EnterDescription
    		,String EnterRates,String EnterQty, String EnterDays, String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
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
        
        
       String ProjectCreatedSuccesfully = ProjectPage.ProjectCreatedSuccesfully();
        softAssert.assertEquals(ProjectCreatedSuccesfully, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
     
        
    }
    
    // Invalid Enterprise - Creating Project agencies
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidEnterprise(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage, String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
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
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        //ProjectPage.clickOnSelectProjectTypeButton();
       // ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        //ProjectPage.clickOnProjectDetailsButton();
        
        String SelectedImproperProjectType = ProjectPage.SelectedImproperProjectType();
        softAssert.assertEquals(SelectedImproperProjectType, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    
}
  
    //Invalid Project Title - Creating Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidProjectTitl(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription, String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
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
    
    //Invalid Project Description - Creating Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidProjectDesc(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription, String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
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
    
    //Invalid Field Name - Create Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidFieldName(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
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
    
    //Invalid Frequency - Create Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidFrequency(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
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
    
    //Invalid Radius - Create Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidRadius(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
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
