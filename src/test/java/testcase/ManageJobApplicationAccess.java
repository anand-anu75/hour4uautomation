package testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AppLoginPage;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import pages.ManageJobApplicationAccessPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class ManageJobApplicationAccess extends BaseTest {
	ManageJobApplicationAccessPage JobApplicationPage;
	
    // Job Application for Approval when logging as Enterprise
	
	 @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ApplicationEnterpriseAccept(String Date,String Title, String expectedSuccessmessage,
    		String EnterpriseLogin,String EnterprisePassword,String MobileNumber,
    		String EnterOTP,String enterpriseLogin,String enterprisePassword,String ExpectedResult) throws InterruptedException {
    	JobApplicationPage = new ManageJobApplicationAccessPage(driver);
    	CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
    	CreateProjectPage ProjectPage = new CreateProjectPage(driver);
    	AppLoginPage Applogin = new AppLoginPage(driver);
    	
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
    	    Thread.sleep(2000);
    	    
    	    ProjectPage.clickOnProfileButton();
            ProjectPage.clickOnLogoutButton();
            ProjectPage.enterDhruviEmail(EnterpriseLogin);
            ProjectPage.enterDhruviPassword(EnterprisePassword);;	
            ProjectPage.clickOnLoginButton();
            
            ProjectPage.clickOnErrorMessage();
            
            WorkorderPage.clickOnWorkorderButton(); 
            WorkorderPage.clickOnApproveWorkorder();
            Thread.sleep(2000);
    	    
    	    ProjectPage.clickOnProfileButton();
            ProjectPage.clickOnLogoutButton();
            
            driver.get(prop.getProperty("AppURL"));
            
            
            Applogin.clickOnLetStartButton();
    		Applogin.clickOnSkiptButton();
    		Thread.sleep(2000);
    		Applogin.enterMobileNumber(MobileNumber);
    		Thread.sleep(2000);
    		Applogin.clickOnMobileNextButton();
    		Thread.sleep(2000);
    		Applogin.enterOTP(EnterOTP);
    		Thread.sleep(4000);
    		Applogin.clickOnOTPNext();
    		Thread.sleep(3000);
    		Applogin.clickOnAppActiveJob();
    		Thread.sleep(2000);
    		Applogin.clickOnApplyActiveJob();
    		
    		Thread.sleep(4000);
    		
    		driver.get(prop.getProperty("testURL"));
    		
    		ProjectPage.enterDhruviEmail(enterpriseLogin);
            ProjectPage.enterDhruviPassword(enterprisePassword);;	
            ProjectPage.clickOnLoginButton();
            
     //       ProjectPage.clickOnErrorMessage();
    		
    	    
    	JobApplicationPage.clickOnWorkorderButton();
    	Thread.sleep(4000);
    	JobApplicationPage.clickOnActiveWorkorder();
    	JobApplicationPage.ClickToApproveChamp();
    	JobApplicationPage.JobApplicationStatus();
    //	Thread.sleep(3000);
    //	JobApplicationPage.ClickToRejectChamp();
    //	JobApplicationPage.JobApplicationStatus();
    	
    	String JobApplicationstatus = JobApplicationPage.JobApplicationStatus();
        softAssert.assertEquals(JobApplicationstatus,ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    	}
	 
	// Job Application for Reject when logging as Enterprise
	 
	 @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
	    public void ApplicationEnterpriseReject(String Date,String Title, String expectedSuccessmessage,
	    		String EnterpriseLogin,String EnterprisePassword,String MobileNumber,
	    		String EnterOTP,String enterpriseLogin,String enterprisePassword,String ExpectedResult) throws InterruptedException {
	    	JobApplicationPage = new ManageJobApplicationAccessPage(driver); 
	    	CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
	    	CreateProjectPage ProjectPage = new CreateProjectPage(driver);
	    	AppLoginPage Applogin = new AppLoginPage(driver);
	    	
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
	    	    Thread.sleep(2000);
	    	    
	    	    ProjectPage.clickOnProfileButton();
	            ProjectPage.clickOnLogoutButton();
	            ProjectPage.enterDhruviEmail(EnterpriseLogin);
	            ProjectPage.enterDhruviPassword(EnterprisePassword);;	
	            ProjectPage.clickOnLoginButton();
	            
	            ProjectPage.clickOnErrorMessage();
	            
	            WorkorderPage.clickOnWorkorderButton(); 
	            WorkorderPage.clickOnApproveWorkorder();
	            Thread.sleep(2000);
	    	    
	    	    ProjectPage.clickOnProfileButton();
	            ProjectPage.clickOnLogoutButton();
	            
	            driver.get(prop.getProperty("AppURL"));
	            
	            
	            Applogin.clickOnLetStartButton();
	    		Applogin.clickOnSkiptButton();
	    		Thread.sleep(2000);
	    		Applogin.enterMobileNumber(MobileNumber);
	    		Thread.sleep(2000);
	    		Applogin.clickOnMobileNextButton();
	    		Thread.sleep(2000);
	    		Applogin.enterOTP(EnterOTP);
	    		Thread.sleep(4000);
	    		Applogin.clickOnOTPNext();
	    		Thread.sleep(3000);
	    		Applogin.clickOnAppActiveJob();
	    		Thread.sleep(2000);
	    		Applogin.clickOnApplyActiveJob();
	    		
	    		Thread.sleep(4000);
	    		
	    		driver.get(prop.getProperty("testURL"));
	    		
	    		ProjectPage.enterDhruviEmail(enterpriseLogin);
	            ProjectPage.enterDhruviPassword(enterprisePassword);;	
	            ProjectPage.clickOnLoginButton();
	            
	     //       ProjectPage.clickOnErrorMessage();
	    	
	    	JobApplicationPage.clickOnWorkorderButton();
	    	Thread.sleep(2000);
	    	JobApplicationPage.clickOnActiveWorkorder();
	//    	JobApplicationPage.ClickToApproveChamp();
	//    	JobApplicationPage.JobApplicationStatus();
	//    	Thread.sleep(3000);
	    	JobApplicationPage.ClickToRejectChamp();
	    	JobApplicationPage.JobApplicationStatus();
	    	
	    	String JobApplicationstatus = JobApplicationPage.JobApplicationStatus();
	        softAssert.assertEquals(JobApplicationstatus, ExpectedResult);
	        try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
	    	}
	 
	 
	 
	// Job Application for Approval when logging as Agency 
	 
	 @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
	 public void ApplicationAgencyAccept(String Date,String Title, String expectedSuccessmessage,
	    		String EnterpriseLogin,String EnterprisePassword,String MobileNumber,
	    		String EnterOTP,String agencyLogin,String agencyOTP,String ExpectedResult) throws InterruptedException {
	    	JobApplicationPage = new ManageJobApplicationAccessPage(driver); 
	    	 
	    	CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
	    	CreateProjectPage ProjectPage = new CreateProjectPage(driver);
	    	AppLoginPage Applogin = new AppLoginPage(driver);
	    	
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
                Thread.sleep(2000);
	    	    
	    	    ProjectPage.clickOnProfileButton();
	            ProjectPage.clickOnLogoutButton();
	            ProjectPage.enterDhruviEmail(EnterpriseLogin);
	            ProjectPage.enterDhruviPassword(EnterprisePassword);;	
	            ProjectPage.clickOnLoginButton();
	            
	            ProjectPage.clickOnErrorMessage();
	            
	            WorkorderPage.clickOnWorkorderButton(); 
	            WorkorderPage.clickOnApproveWorkorder();
	            Thread.sleep(2000);
	    	    
	    	    ProjectPage.clickOnProfileButton();
	            ProjectPage.clickOnLogoutButton();
	            
	            driver.get(prop.getProperty("AppURL"));
	            
	            
	            Applogin.clickOnLetStartButton();
	    		Applogin.clickOnSkiptButton();
	    		Thread.sleep(2000);
	    		Applogin.enterMobileNumber(MobileNumber);
	    		Thread.sleep(2000);
	    		Applogin.clickOnMobileNextButton();
	    		Thread.sleep(2000);
	    		Applogin.enterOTP(EnterOTP);
	    		Thread.sleep(4000);
	    		Applogin.clickOnOTPNext();
	    		Thread.sleep(3000);
	    		Applogin.clickOnAppActiveJob();
	    		Thread.sleep(2000);
	    		Applogin.clickOnApplyActiveJob();
	    		
	    		Thread.sleep(4000);
	    		
	    		driver.get(prop.getProperty("testURL"));
	    		
	    		ProjectPage.enterAgencyEmail(agencyLogin);
	            ProjectPage.clickOnSignInUsingOTP();
	            ProjectPage.clickOnGetOTP();
	            ProjectPage.enterOTPforAgencyLogin(agencyOTP);	
	            ProjectPage.clickOnLoginButton();
	            
	     //       ProjectPage.clickOnErrorMessage();
	    	
	    	
	    	JobApplicationPage.clickOnWorkorderButton();
	    	Thread.sleep(2000);
	    	JobApplicationPage.clickOnActiveWorkorder();
	    	Thread.sleep(2000);
	    	JobApplicationPage.ClickToApproveChamp();
	    	JobApplicationPage.JobApplicationStatus();
	  //  	Thread.sleep(3000);
	  //  	JobApplicationPage.ClickToRejectChamp();
	 //   	JobApplicationPage.JobApplicationStatus();
	    	
	    	String JobApplicationstatus = JobApplicationPage.JobApplicationStatus();
	        softAssert.assertEquals(JobApplicationstatus, ExpectedResult);
	        try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
	    	}
	 
	// Job Application for Reject when logging as Agency 

	 @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
	 public void ApplicationAgencyReject(String Date,String Title, String expectedSuccessmessage,
	    		String EnterpriseLogin,String EnterprisePassword,String MobileNumber,
	    		String EnterOTP,String agencyLogin,String agencyOTP,String ExpectedResult) throws InterruptedException {
	    	JobApplicationPage = new ManageJobApplicationAccessPage(driver); 
	    	CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
	    	CreateProjectPage ProjectPage = new CreateProjectPage(driver);
	    	AppLoginPage Applogin = new AppLoginPage(driver);
	    	
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
                Thread.sleep(2000);
	    	    
	    	    ProjectPage.clickOnProfileButton();
	            ProjectPage.clickOnLogoutButton();
	            ProjectPage.enterDhruviEmail(EnterpriseLogin);
	            ProjectPage.enterDhruviPassword(EnterprisePassword);;	
	            ProjectPage.clickOnLoginButton();
	            
	            ProjectPage.clickOnErrorMessage();
	            
	            WorkorderPage.clickOnWorkorderButton(); 
	            WorkorderPage.clickOnApproveWorkorder();
	            Thread.sleep(2000);
	    	    
	    	    ProjectPage.clickOnProfileButton();
	            ProjectPage.clickOnLogoutButton();
	            
	            driver.get(prop.getProperty("AppURL"));
	            
	            
	            Applogin.clickOnLetStartButton();
	    		Applogin.clickOnSkiptButton();
	    		Thread.sleep(2000);
	    		Applogin.enterMobileNumber(MobileNumber);
	    		Thread.sleep(2000);
	    		Applogin.clickOnMobileNextButton();
	    		Thread.sleep(2000);
	    		Applogin.enterOTP(EnterOTP);
	    		Thread.sleep(4000);
	    		Applogin.clickOnOTPNext();
	    		Thread.sleep(3000);
	    		Applogin.clickOnAppActiveJob();
	    		Thread.sleep(2000);
	    		Applogin.clickOnApplyActiveJob();
	    		
	    		Thread.sleep(4000);
	    		
	    		driver.get(prop.getProperty("testURL"));
	    		
	    		ProjectPage.enterAgencyEmail(agencyLogin);
	            ProjectPage.clickOnSignInUsingOTP();
	            ProjectPage.clickOnGetOTP();
	            ProjectPage.enterOTPforAgencyLogin(agencyOTP);	
	            ProjectPage.clickOnLoginButton();
	            
	     //       ProjectPage.clickOnErrorMessage();
	    	
	    	JobApplicationPage.clickOnWorkorderButton();
	  //  	Thread.sleep(2000);
	    	JobApplicationPage.clickOnActiveWorkorder();
	    	Thread.sleep(2000);
	  //  	JobApplicationPage.ClickToApproveChamp();
	  //  	JobApplicationPage.JobApplicationStatus();
	 //   	Thread.sleep(3000);
	    	JobApplicationPage.ClickToRejectChamp();
	    	JobApplicationPage.JobApplicationStatus();
	    	
	    	String JobApplicationstatus = JobApplicationPage.JobApplicationStatus();
	        softAssert.assertEquals(JobApplicationstatus, ExpectedResult);
	        try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
	    	}
}
