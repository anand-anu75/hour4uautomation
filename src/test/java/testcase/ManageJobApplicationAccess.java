package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ManageJobApplicationAccessPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class ManageJobApplicationAccess extends BaseTest {
	ManageJobApplicationAccessPage JobApplicationPage;
	
    // Job Application for Approval when logging as Enterprise
	
	 @Test(dependsOnMethods = {"testcase.LoginDhruviEnterprise.loginDhruviEnterprise"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ApplicationEnterpriseAccept(String ExpectedMessage) throws InterruptedException {
    	JobApplicationPage = new ManageJobApplicationAccessPage(driver);  
    	
 /*   	JobApplicationPage.clickOnProjectTabButton();
    	JobApplicationPage.clickOnCreatedProjectOption();
    	JobApplicationPage.clickOnAssignAgency();
    	JobApplicationPage.enterSearchAgency(SearchAgency);
    	Thread.sleep(2000);
    	JobApplicationPage.clickOnSearchAgency();
    	JobApplicationPage.clickOnSearchAssignAgency();
    	JobApplicationPage.clickOnProfileButton();
    	JobApplicationPage.clickOnLogoutButton();
    	JobApplicationPage.enterAgencyEmail(EnterAgencyEmail);
    	JobApplicationPage.clickOnSignInUsingOTP();
    	JobApplicationPage.clickOnGetOTP();
    	JobApplicationPage.enterOTPforAgencyLogin(EnterOTP);
    	JobApplicationPage.clickOnLoginButton();
    	
   */   
    	JobApplicationPage.clickOnWorkorderButton();
    	Thread.sleep(2000);
    	JobApplicationPage.clickOnActiveWorkorder();
    	JobApplicationPage.ClickToApproveChamp();
    	JobApplicationPage.JobApplicationStatus();
    //	Thread.sleep(3000);
    //	JobApplicationPage.ClickToRejectChamp();
    //	JobApplicationPage.JobApplicationStatus();
    	}
	 
	// Job Application for Reject when logging as Enterprise
	 
	 @Test(dependsOnMethods = {"testcase.LoginDhruviEnterprise.loginDhruviEnterprise"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
	    public void ApplicationEnterpriseReject(String ExpectedResult) throws InterruptedException {
	    	JobApplicationPage = new ManageJobApplicationAccessPage(driver); 
	    	
	    	JobApplicationPage.clickOnWorkorderButton();
	    	Thread.sleep(2000);
	    	JobApplicationPage.clickOnActiveWorkorder();
	//    	JobApplicationPage.ClickToApproveChamp();
	//    	JobApplicationPage.JobApplicationStatus();
	//    	Thread.sleep(3000);
	    	JobApplicationPage.ClickToRejectChamp();
	    	JobApplicationPage.JobApplicationStatus();
	    	}
	 
	// Job Application for Approval when logging as Agency 
	 
	 @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
	 public void ApplicationAgencyAccept(String ExpectedMessage) throws InterruptedException {
	    	JobApplicationPage = new ManageJobApplicationAccessPage(driver); 
	    	
	    	JobApplicationPage.clickOnWorkorderButton();
	  //  	Thread.sleep(2000);
	    	JobApplicationPage.clickOnActiveWorkorder();
	    	Thread.sleep(2000);
	    	JobApplicationPage.ClickToApproveChamp();
	    	JobApplicationPage.JobApplicationStatus();
	  //  	Thread.sleep(3000);
	  //  	JobApplicationPage.ClickToRejectChamp();
	 //   	JobApplicationPage.JobApplicationStatus();
	    	}
	 
	// Job Application for Reject when logging as Agency 

	 @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
	 public void ApplicationAgencyReject(String ExpectedResult) throws InterruptedException {
	    	JobApplicationPage = new ManageJobApplicationAccessPage(driver); 
	    	
	    	JobApplicationPage.clickOnWorkorderButton();
	  //  	Thread.sleep(2000);
	    	JobApplicationPage.clickOnActiveWorkorder();
	    	Thread.sleep(2000);
	  //  	JobApplicationPage.ClickToApproveChamp();
	  //  	JobApplicationPage.JobApplicationStatus();
	 //   	Thread.sleep(3000);
	    	JobApplicationPage.ClickToRejectChamp();
	    	JobApplicationPage.JobApplicationStatus();
	    	}
}
