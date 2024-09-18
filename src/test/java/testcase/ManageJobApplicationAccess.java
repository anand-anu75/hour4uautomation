package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.AppLoginPage;
import pages.AssignProjectVendorAgencyPage;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import pages.ManageJobApplicationAccessPage;
import pages.VendorLoginPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class ManageJobApplicationAccess extends BaseTest {
	ManageJobApplicationAccessPage JobApplicationPage;
	Login loginAgency = new Login();;

	// Job Application for Approval when logging as Enterprise

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ApplicationEnterpriseAccept(String phoneOrEmail, String OTP, String expectedURL, String Date,
			String Title, String expectedSuccessmessage, String EnterpriseLogin, String EnterprisePassword,
			String MobileNumber, String EnterOTP, String enterpriseLogin, String enterprisePassword,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		ManageJobApplicationAccessPage JobApplication = new ManageJobApplicationAccessPage(driver);
		CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		AppLoginPage Applogin = new AppLoginPage(driver);
		
		//Create Work Order

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

		//Close Notification
		JobApplication.clickOnCloseMessage();

		//Log out from the Profile
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Log-In Enterprise 
		ProjectPage.enterDhruviEmail(EnterpriseLogin);
		ProjectPage.enterDhruviPassword(EnterprisePassword);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		//Approve Workorder
		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnApproveWorkorder();
		
		//Close Notification
		JobApplication.clickOnCloseMessage();

		//Log out from Profile
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Switch URL to Mobile Application URL

		driver.get(prop.getProperty("AppURL"));
		
		//Log-In into App URL

		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
		Applogin.enterMobileNumber(MobileNumber);
		Applogin.clickOnMobileNextButton();
		Applogin.enterOTP(EnterOTP);
		Applogin.clickOnOTPNext();
		
		//Apply Active Job
		Applogin.clickOnAppActiveJob();
		Applogin.clickOnApplyActiveJob();

	    //Switch to Web Application

		driver.get(prop.getProperty("testURL"));
	

		//Log-In as Enterprise
		ProjectPage.enterDhruviEmail(enterpriseLogin);
		ProjectPage.enterDhruviPassword(enterprisePassword);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();
		
		//Click on Workorder Tab
		JobApplication.clickOnWorkorderButton();
		JobApplication.clickOnActiveWorkorder();
		
		//Approve Champ
		JobApplication.ClickToApproveChamp();
		JobApplication.JobApplicationStatus();
		

		String JobApplicationstatus = JobApplication.JobApplicationStatus();
		softAssert.assertEquals(JobApplicationstatus, ExpectedResult);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Job Application for Reject when logging as Enterprise

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ApplicationEnterpriseReject(String phoneOrEmail, String OTP, String expectedURL, String Date,
			String Title, String expectedSuccessmessage, String EnterpriseLogin, String EnterprisePassword,
			String MobileNumber, String EnterOTP, String enterpriseLogin, String enterprisePassword,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		ManageJobApplicationAccessPage JobApplication = new ManageJobApplicationAccessPage(driver);
		CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		AppLoginPage Applogin = new AppLoginPage(driver);
		
		//Create Workorder

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
		
		//Close Notification
		JobApplication.clickOnCloseMessage();
	
		//Log-out from Profile
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//LogIn as Enterprise
		ProjectPage.enterDhruviEmail(EnterpriseLogin);
		ProjectPage.enterDhruviPassword(EnterprisePassword);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();
		
		//Click on Workorder Tab and Approve Workorder
		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnApproveWorkorder();

		//Close Notification
		JobApplication.clickOnCloseMessage();
		
		//Logout Progile
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		//Switching to App URL 
		
		driver.get(prop.getProperty("AppURL"));

		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
		Applogin.enterMobileNumber(MobileNumber);
		Applogin.clickOnMobileNextButton();
		Applogin.enterOTP(EnterOTP);
		Applogin.clickOnOTPNext();
	
		//Apply to Active Job
		Applogin.clickOnAppActiveJob();
		Applogin.clickOnApplyActiveJob();
		
		//Getting back to web URL

		driver.get(prop.getProperty("testURL"));
		
		//LogIn as Enterprise

		ProjectPage.enterDhruviEmail(enterpriseLogin);
		ProjectPage.enterDhruviPassword(enterprisePassword);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		//Go to Workorder Section
		JobApplication.clickOnWorkorderButton();
		JobApplication.clickOnActiveWorkorder();
		
		//Reject Champ
		JobApplication.ClickToRejectChamp();
		
		//Notification Updated
		JobApplication.JobApplicationStatus();

		String JobApplicationstatus = JobApplication.JobApplicationStatus();
		softAssert.assertEquals(JobApplicationstatus, ExpectedResult);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Job Application for Approval when logging as Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ApplicationAgencyAccept(String phoneOrEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedSuccessmessage, String EnterpriseLogin, String EnterprisePassword, String MobileNumber,
			String EnterOTP, String agencyLogin, String agencyOTP, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, agencyOTP, expectedURL);

		ManageJobApplicationAccessPage JobApplication = new ManageJobApplicationAccessPage(driver);

		CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		AppLoginPage Applogin = new AppLoginPage(driver);


		//Workorder is created
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

		//CLose Notification
		JobApplication.clickOnCloseMessage();
	
		//Log-out Profile
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Login as Enterprise Email

		ProjectPage.enterDhruviEmail(EnterpriseLogin);
		ProjectPage.enterDhruviPassword(EnterprisePassword);
		
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();
		
		//Go to Workorder Section and Approve Workorder

		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnApproveWorkorder();
		
		//Close Notification

		JobApplication.clickOnCloseMessage();
	
		//Log out from Profile

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Switching to App URL

		driver.get(prop.getProperty("AppURL"));

		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
		Applogin.enterMobileNumber(MobileNumber);
		Applogin.clickOnMobileNextButton();
		Applogin.enterOTP(EnterOTP);
		Applogin.clickOnOTPNext();
	
		//Apply to Active Job
		Applogin.clickOnAppActiveJob();
		Applogin.clickOnApplyActiveJob();
		
		// Switching to Web URL

		driver.get(prop.getProperty("testURL"));
		
		//LogIn as Agency

		ProjectPage.enterAgencyEmail(agencyLogin);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(agencyOTP);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();
		
		//Go to workorder section
		JobApplication.clickOnWorkorderButton();
		JobApplication.clickOnActiveWorkorder();
		
		//Approve Champ
		JobApplication.ClickToApproveChamp();
		
		//Status Updated
		JobApplication.JobApplicationStatus();
	

		String JobApplicationstatus = JobApplication.JobApplicationStatus();
		softAssert.assertEquals(JobApplicationstatus, ExpectedResult);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Job Application for Reject when logging as Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ApplicationAgencyReject(String phoneOrEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedSuccessmessage, String EnterpriseLogin, String EnterprisePassword, String MobileNumber,
			String EnterOTP, String agencyLogin, String agencyOTP, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, agencyOTP, expectedURL);

		ManageJobApplicationAccessPage JobApplication = new ManageJobApplicationAccessPage(driver);
		CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		AppLoginPage Applogin = new AppLoginPage(driver);

		//Workorder is created

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

		//CLose Notification
		JobApplication.clickOnCloseMessage();
		

		//Logout Profile
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		//Enter Enterprise Email
		ProjectPage.enterDhruviEmail(EnterpriseLogin);
		ProjectPage.enterDhruviPassword(EnterprisePassword);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();
		
		//Go to Workorder Section and Approve Workorder

		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnApproveWorkorder();
		
		//CLose Notification

		JobApplication.clickOnCloseMessage();
	

		//Logout Profile
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Switch to App URL

		driver.get(prop.getProperty("AppURL"));
		
		//Login as Champ

		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
		Applogin.enterMobileNumber(MobileNumber);
		Applogin.clickOnMobileNextButton();
		Applogin.enterOTP(EnterOTP);
		Applogin.clickOnOTPNext();
		
		//Apply to active job
		Applogin.clickOnAppActiveJob();
		Applogin.clickOnApplyActiveJob();
		
		//Switch to Web Application

		driver.get(prop.getProperty("testURL"));
		
		//Enter Agency Email

		ProjectPage.enterAgencyEmail(agencyLogin);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(agencyOTP);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();
		
		//Go to Workorder Section

		JobApplication.clickOnWorkorderButton();
		JobApplication.clickOnActiveWorkorder();
		
		//Reject Champ
	
		JobApplication.ClickToRejectChamp();
		JobApplication.JobApplicationStatus();

		String JobApplicationstatus = JobApplication.JobApplicationStatus();
		softAssert.assertEquals(JobApplicationstatus, ExpectedResult);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Job Application for Accepting when logging as Vendor

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void JobApplicationVendorAcceptChamp(String phoneOrEmail, String agencyOTP, String expectedURL,
			String ProjectTitle, String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL,
			String EnterMetrics, String EnterQuantity, String StartDate, String EndDate, String FieldName,
			String EnterFrequency, String EnterRadius, String EnterItem, String EnterDescription, String EnterRates,
			String EnterQty, String EnterDays, String ExpectedResult, String ExpectedMessage, String vendorphoneOrEmail,
			String OTP, String Amount, String PaymentTerms, String AdditionalTerms, String EnterEmail, String EnterOTP,
			String Date, String Title, String MobileNumber, String VendorEmail, String VendorOTP,
			String ExpectedOutcome) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, agencyOTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		AssignProjectVendorAgencyPage AssignProjectVendor = new AssignProjectVendorAgencyPage(driver);
		VendorLoginPage Vendorlogin = new VendorLoginPage(driver);
		CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
		JobApplicationPage = new ManageJobApplicationAccessPage(driver);
		AppLoginPage Applogin = new AppLoginPage(driver);
		ManageJobApplicationAccessPage JobApplication = new ManageJobApplicationAccessPage(driver);
		
		//Create Project

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();
		ProjectPage.clickOnNext2Button();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		scrollPageDown();
		ProjectPage.enterProjectCode(ProjectCode);
		ProjectPage.enterLinkTitle(LinkTitle);
		ProjectPage.enterURL(LinkURL);
		ProjectPage.enterMetrics(EnterMetrics);
		ProjectPage.enterQuantity(EnterQuantity);
		scrollPageDown();
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
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
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
		ProjectPage.clickOnProjectTabButton();
		
		//Assign Project to Vendor
		AssignProjectVendor.SelectCreatedProject();
		AssignProjectVendor.ClickOnAssignVendor();
		AssignProjectVendor.clickOn_DropDown();
		AssignProjectVendor.SelectVendorToAssignProject();
		AssignProjectVendor.ClickOnAssignVendorButton();
		AssignProjectVendor.SelectedVendorAssignedSuccessfully();
	
		//Log out from Profile
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Login As Vendor
		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(vendorphoneOrEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(OTP);
		Vendorlogin.clickOnBtn_Login();
		
		//Send quotes
		ProjectPage.clickOnProjectTabButton();
		AssignProjectVendor.SelectCreatedProject();
		JobApplication.clickOnPrepareAndSendQuote();
		JobApplication.enterAmount(Amount);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
	

		JobApplication.clickToOpenCalendar();
		JobApplication.clickToSelectDate();
		JobApplication.enterPaymentTerms(PaymentTerms);
		JobApplication.enterAdditionalTerms(AdditionalTerms);
		JobApplication.clickOnSendQuote();
	
		//Logout from Profile

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		

		//Login As Agency
		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(EnterEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(EnterOTP);
		Vendorlogin.clickOnBtn_Login();
		

		//Create Workorder
		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnCreateWorkorderButton();
		WorkorderPage.NavigateTodialogBox();
		WorkorderPage.clickOnSelectProjectButton();
		WorkorderPage.clickOnAddDetailsButton();
		WorkorderPage.clickOnSearchAddressButton();
		WorkorderPage.enterDate(Date);
		WorkorderPage.clickOnStartTimeButton();
		WorkorderPage.clickOnSelectStarttimeButton();

		Actions actions1 = new Actions(driver);
		actions1.sendKeys(Keys.ESCAPE).perform();
		WorkorderPage.clickOnEndTimeButton();
		WorkorderPage.clickOnSelectEndtimeButton();
	
		WorkorderPage.clickOnAddBillingButton();
		WorkorderPage.clickOnAddTitleButton();
		WorkorderPage.enterTitle(Title);
		
		//Assign Vendor
		JobApplication.clickOnAssignVendor();
		JobApplication.clickToSelectVendorFromOption();
		WorkorderPage.clickOnSeeSummaryButton();
		
		//Click on Approval
		JobApplication.clickOnSubmitApproval();
		JobApplication.clickOnCloseMessage();
		
		//Logout from Profile

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Switch to App URL

		driver.get(prop.getProperty("AppURL"));

		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
		Applogin.enterMobileNumber(MobileNumber);
		Applogin.clickOnMobileNextButton();
		Applogin.enterOTP(EnterOTP);
		Applogin.clickOnOTPNext();
		
		//Apply to Active Job
		Applogin.clickOnAppActiveJob();
		Applogin.clickOnApplyActiveJob();
		
		//Switch to Web URL
		
		driver.get(prop.getProperty("testURL"));
		
		//Login As Vendor Email

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(VendorEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(VendorOTP);
		Vendorlogin.clickOnBtn_Login();
		
		//Go to Workorder Section
		WorkorderPage.clickOnWorkorderButton();
		
		JobApplicationPage.clickOnActiveWorkorder();
		
		//Approve Chmap
		
		JobApplicationPage.ClickToApproveChamp();
		
		//Status Updated
		JobApplicationPage.JobApplicationStatus();
		

		String VendorChampAcceptSuccessfully = JobApplicationPage.JobApplicationStatus();
		softAssert.assertEquals(VendorChampAcceptSuccessfully, ExpectedOutcome);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Job Application for Rejecting when logging as Vendor

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void JobApplicationVendorRejectChamp(String phoneOrEmail, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String StartDate, String EndDate, String FieldName, String EnterFrequency,
			String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
			String EnterDays, String ExpectedResult, String ExpectedMessage, String vendorphoneOrEmail, String OTP,
			String Amount, String PaymentTerms, String AdditionalTerms, String EnterEmail, String EnterOTP, String Date,
			String Title, String MobileNumber, String VendorEmail, String VendorOTP, String ExpectedOutcome)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		AssignProjectVendorAgencyPage AssignProjectVendor = new AssignProjectVendorAgencyPage(driver);
		VendorLoginPage Vendorlogin = new VendorLoginPage(driver);
		CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);
		JobApplicationPage = new ManageJobApplicationAccessPage(driver);
		AppLoginPage Applogin = new AppLoginPage(driver);
		ManageJobApplicationAccessPage JobApplication = new ManageJobApplicationAccessPage(driver);
		
		//Create Project

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();
		ProjectPage.clickOnNext2Button();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		scrollPageDown();
		ProjectPage.enterProjectCode(ProjectCode);
		ProjectPage.enterLinkTitle(LinkTitle);
		ProjectPage.enterURL(LinkURL);
		ProjectPage.enterMetrics(EnterMetrics);
		ProjectPage.enterQuantity(EnterQuantity);
		scrollPageDown();
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
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
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
		ProjectPage.clickOnProjectTabButton();
	
		//Assign Project to Vendor
		AssignProjectVendor.SelectCreatedProject();
		AssignProjectVendor.ClickOnAssignVendor();
		AssignProjectVendor.clickOn_DropDown();
		AssignProjectVendor.SelectVendorToAssignProject();
		AssignProjectVendor.ClickOnAssignVendorButton();
		AssignProjectVendor.SelectedVendorAssignedSuccessfully();
		
		//Log out from Profile

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Login as Vendor

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(vendorphoneOrEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(OTP);
		Vendorlogin.clickOnBtn_Login();
		
		//Send Quotes

		ProjectPage.clickOnProjectTabButton();
		AssignProjectVendor.SelectCreatedProject();
		JobApplication.clickOnPrepareAndSendQuote();
		JobApplication.enterAmount(Amount);

		scrollPageDown();

		JobApplication.clickToOpenCalendar();
		JobApplication.clickToSelectDate();
		JobApplication.enterPaymentTerms(PaymentTerms);
		JobApplication.enterAdditionalTerms(AdditionalTerms);
		JobApplication.clickOnSendQuote();
	
		//Logout from Profile

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Login As Agency

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(EnterEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(EnterOTP);
		Vendorlogin.clickOnBtn_Login();
		

		//Go to Workorder Section
		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnCreateWorkorderButton();
		WorkorderPage.NavigateTodialogBox();
		WorkorderPage.clickOnSelectProjectButton();
		WorkorderPage.clickOnAddDetailsButton();
		WorkorderPage.clickOnSearchAddressButton();
		WorkorderPage.enterDate(Date);
		WorkorderPage.clickOnStartTimeButton();
		WorkorderPage.clickOnSelectStarttimeButton();

		Actions actions1 = new Actions(driver);
		actions1.sendKeys(Keys.ESCAPE).perform();
		WorkorderPage.clickOnEndTimeButton();
		
		WorkorderPage.clickOnSelectEndtimeButton();
		WorkorderPage.clickOnAddBillingButton();
		WorkorderPage.clickOnAddTitleButton();
		WorkorderPage.enterTitle(Title);
	
		//Assign Vendor
		JobApplication.clickOnAssignVendor();
		JobApplication.clickToSelectVendorFromOption();
		WorkorderPage.clickOnSeeSummaryButton();
		JobApplication.clickOnSubmitApproval();
		JobApplication.clickOnCloseMessage();
		
		//Logout from Profile

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Switch to App URL

		driver.get(prop.getProperty("AppURL"));

		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
		Applogin.enterMobileNumber(MobileNumber);
		Applogin.clickOnMobileNextButton();
		Applogin.enterOTP(EnterOTP);
		Applogin.clickOnOTPNext();
		
		//Apply Active Job
		Applogin.clickOnAppActiveJob();
		Applogin.clickOnApplyActiveJob();

		//Switch to Web URL

		driver.get(prop.getProperty("testURL"));
		
		//Login As Vendor

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(VendorEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(VendorOTP);
		Vendorlogin.clickOnBtn_Login();
	
		//Go to Workorder Section

		WorkorderPage.clickOnWorkorderButton();
		
		JobApplicationPage.clickOnActiveWorkorder();
		
		//Reject Champ
		
		JobApplicationPage.ClickToRejectChamp();
		JobApplicationPage.JobApplicationStatus();

		String VendorChampRejectSuccessfully = JobApplicationPage.JobApplicationStatus();
		softAssert.assertEquals(VendorChampRejectSuccessfully, ExpectedOutcome);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

}