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
	    public void AcceptRejectClients(String CompanyName, String PersonName, String Email, String MobileResponsible
, String expectedSuccessMessage,String OTP, String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
	    		String LinkURL,String EnterMetrics,String EnterQuantity,String StartDate,String EndDate,String FieldName, String EnterFrequency,
	    		String EnterRadius,String EnterItem, String EnterDescription
	    		,String EnterRates,String EnterQty, String EnterDays, String ExpectedResult, String SearchAgency,
	    		String EnterAgencyEmail,String EnterOTP,String ExpectedMessage) throws InterruptedException {
	        ClientPage = new InvitingclientPage(driver);
	        ProjectPage = new CreateProjectPage(driver);
	
	        ClientPage.clickOnUserButton();
	       
	        ClientPage.clickOnClientsOption();
	
	        ClientPage.clickOnInviteClientButton();
	       
	        ClientPage.NavigateToDialogBox();
	       
	       
	        String randomName = CompanyName + (int) (Math.random() * 1000);
	        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
	        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
	        String randomEmail = generateRandomEmail(Email);
	        // Appends a random number to the email username
	 
	        ClientPage.enterClientName(randomName);
	        ClientPage.enterMobileNumber(randomAnotherName);
	        ClientPage.enterEmail(randomEmail);
	        ClientPage.enterAddress(randomPhone);
	        Thread.sleep(4000);
	        ClientPage.clickOnCreateClientButton();
	        
	        Thread.sleep(3000);
	        
	        ProjectPage.clickOnProfileButton();
	        ProjectPage.clickOnLogoutButton();
	        
	   //     ProjectPage.clickOnErrorMessage();
	        
	        ProjectPage.enterAgencyEmail(randomEmail);
	        ProjectPage.clickOnSignInUsingOTP();
	        ProjectPage.clickOnGetOTP();
	        ProjectPage.enterOTPforAgencyLogin(OTP);
	        ProjectPage.clickOnLoginButton();
//	        ProjectPage.clickOnErrorMessage();
	       
	      //ProjectPage.clickOnErrorMessage();
	        ProjectPage.clickOnProjectTabButton();
	       //ProjectPage.clickOnErrorMessage();
	       ProjectPage.clickOnCreateProjectButton();
	 //       ProjectPage.clickOnSelfClientButton();
	 //       ProjectPage.clickOnNext1Button();
	        Thread.sleep(2000);
	  //      ProjectPage.clickOnProjectTypeButton();
	        ProjectPage.clickOnSelectProjectTypeButton();
//	        Thread.sleep(2000);
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
//	      ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
	        Thread.sleep(2000);
	        ProjectPage.ClickOnAssignAgency();
	        ProjectPage.enterSearchAgency(SearchAgency);
	        Thread.sleep(2000);
	        ProjectPage.ClickOnAugustAgency();
	        ProjectPage.clickOnSearchAssignAgency();
	        Thread.sleep(2000);
	        ProjectPage.clickOnProfileButton();
	        ProjectPage.clickOnLogoutButton();
	        ProjectPage.enterAgencyEmail(EnterAgencyEmail);
	        ProjectPage.clickOnSignInUsingOTP();
	        ProjectPage.clickOnGetOTP();
	        ProjectPage.enterOTPforAgencyLogin(EnterOTP);
	        ProjectPage.clickOnLoginButton();
	        
	//        ProjectPage.clickOnErrorMessage();
	        
	        ProjectPage.clickOnProjectTabButton();
	        ProjectPage.clickOnAcceptProject();
	        
	 //       ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
	       
 
	     	  String actualSuccessmessage = ProjectPage.ProjectStatusUpdated();
	            softAssert.assertEquals(actualSuccessmessage, ExpectedMessage);
	     
	            try {
	    			softAssert.assertAll();
	    		} catch (AssertionError e) {
	    			assertionMessage.set(e.getMessage());
	    			throw e;
	    		}
 
	  
	    }
/*	 private String generateRandomPhoneNumber() {
	        long randomPhone = (long) (Math.random() * 10000000000L); // Generates a random number and ensures it's 10 digits
	        return String.format("%010d", randomPhone); // Formats it as a 10-digit string
	    }
	*/
	
	private String generateRandomPhoneNumber() {
	    // Generate the first digit as a random number between 5 and 9
	    int firstDigit = 5 + (int) (Math.random() * 5);

	    // Generate the remaining 9 digits
	    long remainingDigits = (long) (Math.random() * 1000000000L); // 9 digits

	    // Combine the first digit with the remaining 9 digits and format as a 10-digit number
	    return String.format("%d%09d", firstDigit, remainingDigits);
	}
	
	    // Utility method to generate a random email
	    private String generateRandomEmail(String baseEmail) {
	        int randomNum = (int) (Math.random() * 1000); // Generates a random number between 0 and 999
	        String[] emailParts = baseEmail.split("@");
	        if (emailParts.length == 2) {
	            return emailParts[0] + randomNum + "@" + emailParts[1]; // Inserts the random number before the '@' symbol
	        }
	        return baseEmail; // Fallback to the original email if the format is unexpected
	    }
	
	// Accept/Reject from Clients - Invalid Enterprise
	
	@Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void AcceptRejectInvalidEnterprise(String CompanyName, String PersonName, String Email, String MobileResponsible, String
    		expectedSuccessMessage,String ExpectedMessage) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name 
        String randomPhone = generateRandomPhoneNumber();// Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        Thread.sleep(3000);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
        Thread.sleep(3000);
        
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
    public void AcceptRejectInvalidProjectType(String CompanyName, String PersonName, String Email, String MobileResponsible, String
    		expectedSuccessMessage,String ExpectedResult) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name 
        String randomPhone = generateRandomPhoneNumber();// Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        Thread.sleep(3000);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
    //    ProjectPage.clickOnExistingEnterprise();
        Thread.sleep(2000);
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
    public void AcceptRejectInvalidProjectTitle(String CompanyName, String PersonName, String Email, String MobileResponsible, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name 
        String randomPhone = generateRandomPhoneNumber();// Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        Thread.sleep(3000);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
  //      ProjectPage.clickOnExistingEnterprise();
        Thread.sleep(2000);
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
    public void AcceptRejectInvalidProjectDesc(String CompanyName, String PersonName, String Email, String MobileResponsible, String
    		expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
        ProjectPage = new CreateProjectPage(driver);
        WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name 
        String randomPhone = generateRandomPhoneNumber();// Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        Thread.sleep(3000);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
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
    public void AcceptRejectInvalidFrequency(String CompanyName, String PersonName, String Email, String MobileResponsible, String
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
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name 
        String randomPhone = generateRandomPhoneNumber();// Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        Thread.sleep(3000);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
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
    public void AcceptRejectInvalidRadius(String CompanyName, String PersonName, String Email, String MobileResponsible, String
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
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name 
        String randomPhone = generateRandomPhoneNumber();// Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        Thread.sleep(3000);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
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
