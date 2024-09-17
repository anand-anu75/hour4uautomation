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

		JobApplication.clickOnCloseMessage();
	//	Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		ProjectPage.enterDhruviEmail(EnterpriseLogin);
		ProjectPage.enterDhruviPassword(EnterprisePassword);
		;
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		WorkorderPage.clickOnWorkorderButton();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Agency']")))
		.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-pseudo-checkbox[@class=\"mat-option-pseudo-checkbox mat-pseudo-checkbox ng-star-inserted\" and @xpath=\"1\"]")))
		.click();
		
		WorkorderPage.clickOnApproveWorkorder();

		JobApplication.clickOnCloseMessage();
	//	Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		driver.get(prop.getProperty("AppURL"));

		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
	//	Thread.sleep(2000);
		Applogin.enterMobileNumber(MobileNumber);
	//	Thread.sleep(2000);
		Applogin.clickOnMobileNextButton();
	//	Thread.sleep(2000);
		Applogin.enterOTP(EnterOTP);
	//	Thread.sleep(4000);
		Applogin.clickOnOTPNext();
	//	Thread.sleep(5000);
		Applogin.clickOnAppActiveJob();
	//	Thread.sleep(4000);
		Applogin.clickOnApplyActiveJob();

	//	Thread.sleep(4000);

		driver.get(prop.getProperty("testURL"));
	//	Thread.sleep(4000);

		ProjectPage.enterDhruviEmail(enterpriseLogin);
		ProjectPage.enterDhruviPassword(enterprisePassword);
		;
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		JobApplication.clickOnWorkorderButton();
	//	Thread.sleep(4000);
		JobApplication.clickOnActiveWorkorder();
		JobApplication.ClickToApproveChamp();
		JobApplication.JobApplicationStatus();
		// Thread.sleep(3000);
		// JobApplicationPage.ClickToRejectChamp();
		// JobApplicationPage.JobApplicationStatus();

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

		JobApplication.clickOnCloseMessage();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.enterDhruviEmail(EnterpriseLogin);
		ProjectPage.enterDhruviPassword(EnterprisePassword);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnApproveWorkorder();

		JobApplication.clickOnCloseMessage();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		//Switching to App URL 
		
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
		
		//Getting back to web URL

		driver.get(prop.getProperty("testURL"));

		ProjectPage.enterDhruviEmail(enterpriseLogin);
		ProjectPage.enterDhruviPassword(enterprisePassword);
		;
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		JobApplication.clickOnWorkorderButton();
		Thread.sleep(2000);
		JobApplication.clickOnActiveWorkorder();
		// JobApplicationPage.ClickToApproveChamp();
		// JobApplicationPage.JobApplicationStatus();
		// Thread.sleep(3000);
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

		/*
		 * JobApplicationPage.clickOnProjectTabButton();
		 * JobApplicationPage.clickOnCreatedProjectOption();
		 * JobApplicationPage.clickOnAssignAgency();
		 * JobApplicationPage.enterSearchAgency(SearchAgency); Thread.sleep(2000);
		 * JobApplicationPage.clickOnSearchAgency();
		 * JobApplicationPage.clickOnSearchAssignAgency();
		 * JobApplicationPage.clickOnProfileButton();
		 * JobApplicationPage.clickOnLogoutButton();
		 * JobApplicationPage.enterAgencyEmail(EnterAgencyEmail);
		 * JobApplicationPage.clickOnSignInUsingOTP();
		 * JobApplicationPage.clickOnGetOTP();
		 * JobApplicationPage.enterOTPforAgencyLogin(EnterOTP);
		 * JobApplicationPage.clickOnLoginButton();
		 * 
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

		JobApplication.clickOnCloseMessage();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		ProjectPage.enterDhruviEmail(EnterpriseLogin);
		ProjectPage.enterDhruviPassword(EnterprisePassword);
		;
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnApproveWorkorder();

		JobApplication.clickOnCloseMessage();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		
		//Switching to App URL

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
		
		// Switching to Web URL

		driver.get(prop.getProperty("testURL"));

		ProjectPage.enterAgencyEmail(agencyLogin);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(agencyOTP);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		JobApplication.clickOnWorkorderButton();
		Thread.sleep(2000);
		JobApplication.clickOnActiveWorkorder();
		Thread.sleep(2000);
		JobApplication.ClickToApproveChamp();
		JobApplication.JobApplicationStatus();
		// Thread.sleep(3000);
		// JobApplicationPage.ClickToRejectChamp();
		// JobApplicationPage.JobApplicationStatus();

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

		/*
		 * JobApplicationPage.clickOnProjectTabButton();
		 * JobApplicationPage.clickOnCreatedProjectOption();
		 * JobApplicationPage.clickOnAssignAgency();
		 * JobApplicationPage.enterSearchAgency(SearchAgency); Thread.sleep(2000);
		 * JobApplicationPage.clickOnSearchAgency();
		 * JobApplicationPage.clickOnSearchAssignAgency();
		 * JobApplicationPage.clickOnProfileButton();
		 * JobApplicationPage.clickOnLogoutButton();
		 * JobApplicationPage.enterAgencyEmail(EnterAgencyEmail);
		 * JobApplicationPage.clickOnSignInUsingOTP();
		 * JobApplicationPage.clickOnGetOTP();
		 * JobApplicationPage.enterOTPforAgencyLogin(EnterOTP);
		 * JobApplicationPage.clickOnLoginButton();
		 * 
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

		JobApplication.clickOnCloseMessage();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		ProjectPage.enterDhruviEmail(EnterpriseLogin);
		ProjectPage.enterDhruviPassword(EnterprisePassword);
		;
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		WorkorderPage.clickOnWorkorderButton();
		WorkorderPage.clickOnApproveWorkorder();

		JobApplication.clickOnCloseMessage();
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

		// ProjectPage.clickOnErrorMessage();

		JobApplication.clickOnWorkorderButton();
		// Thread.sleep(2000);
		JobApplication.clickOnActiveWorkorder();
		Thread.sleep(2000);
		// JobApplicationPage.ClickToApproveChamp();
		// JobApplicationPage.JobApplicationStatus();
		// Thread.sleep(3000);
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

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnNext2Button();
		// ProjectPage.clickOnProjectDetailsButton();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.enterProjectCode(ProjectCode);
		ProjectPage.enterLinkTitle(LinkTitle);
		ProjectPage.enterURL(LinkURL);
		ProjectPage.enterMetrics(EnterMetrics);
		ProjectPage.enterQuantity(EnterQuantity);
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnStartDateButton();
		// ProjectPage.enterStartDate(StartDate);
		ProjectPage.clickOnSelectStartDate();
		ProjectPage.clickOnEndDateButton();
		// ProjectPage.enterEndDate(EndDate);
		ProjectPage.clickOnSelectEndDate();
		ProjectPage.clickOnSelectLocationButton();
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		ProjectPage.clickOnFieldTypeDropDown();
		ProjectPage.clickOnPhoneNumberButton();
		ProjectPage.clickOnContinuousLocationTracking();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
		// ProjectPage.clickOnOnlyGpsCoordinate();
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
		Thread.sleep(2000);
		AssignProjectVendor.SelectCreatedProject();
		AssignProjectVendor.ClickOnAssignVendor();
		Thread.sleep(2000);
		AssignProjectVendor.clickOn_DropDown();
		AssignProjectVendor.SelectVendorToAssignProject();
		AssignProjectVendor.ClickOnAssignVendorButton();
		AssignProjectVendor.SelectedVendorAssignedSuccessfully();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(vendorphoneOrEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(OTP);
		Vendorlogin.clickOnBtn_Login();

		Thread.sleep(2000);

		ProjectPage.clickOnProjectTabButton();
		AssignProjectVendor.SelectCreatedProject();

		JobApplication.clickOnPrepareAndSendQuote();
		Thread.sleep(2000);
		JobApplication.enterAmount(Amount);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);

		JobApplication.clickToOpenCalendar();
		JobApplication.clickToSelectDate();
		JobApplication.enterPaymentTerms(PaymentTerms);
		JobApplication.enterAdditionalTerms(AdditionalTerms);
		JobApplication.clickOnSendQuote();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		Thread.sleep(2000);

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(EnterEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(EnterOTP);
		Vendorlogin.clickOnBtn_Login();
		Thread.sleep(2000);

		WorkorderPage.clickOnWorkorderButton();
		Thread.sleep(2000);
		WorkorderPage.clickOnCreateWorkorderButton();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		WorkorderPage.clickOnAddBillingButton();
		Thread.sleep(2000);
		WorkorderPage.clickOnAddTitleButton();
		WorkorderPage.enterTitle(Title);
		Thread.sleep(2000);
		JobApplication.clickOnAssignVendor();
		Thread.sleep(2000);
		JobApplication.clickToSelectVendorFromOption();
		Thread.sleep(2000);
		WorkorderPage.clickOnSeeSummaryButton();
		Thread.sleep(2000);
		JobApplication.clickOnSubmitApproval();
		JobApplication.clickOnCloseMessage();
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
		Thread.sleep(5000);
		Applogin.clickOnAppActiveJob();
		Thread.sleep(2000);
		Applogin.clickOnApplyActiveJob();

		Thread.sleep(4000);

		driver.get(prop.getProperty("testURL"));

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(VendorEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(VendorOTP);
		Vendorlogin.clickOnBtn_Login();
		Thread.sleep(2000);

		WorkorderPage.clickOnWorkorderButton();
		Thread.sleep(2000);
		JobApplicationPage.clickOnActiveWorkorder();
		Thread.sleep(2000);
		JobApplicationPage.ClickToApproveChamp();
		JobApplicationPage.JobApplicationStatus();
		// Thread.sleep(3000);
		// JobApplicationPage.ClickToRejectChamp();
		// JobApplicationPage.JobApplicationStatus();

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

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnNext2Button();
		// ProjectPage.clickOnProjectDetailsButton();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.enterProjectCode(ProjectCode);
		ProjectPage.enterLinkTitle(LinkTitle);
		ProjectPage.enterURL(LinkURL);
		ProjectPage.enterMetrics(EnterMetrics);
		ProjectPage.enterQuantity(EnterQuantity);
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnStartDateButton();
		// ProjectPage.enterStartDate(StartDate);
		ProjectPage.clickOnSelectStartDate();
		ProjectPage.clickOnEndDateButton();
		// ProjectPage.enterEndDate(EndDate);
		ProjectPage.clickOnSelectEndDate();
		ProjectPage.clickOnSelectLocationButton();
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		ProjectPage.clickOnFieldTypeDropDown();
		ProjectPage.clickOnPhoneNumberButton();
		ProjectPage.clickOnContinuousLocationTracking();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
		// ProjectPage.clickOnOnlyGpsCoordinate();
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
		Thread.sleep(2000);
		AssignProjectVendor.SelectCreatedProject();
		AssignProjectVendor.ClickOnAssignVendor();
		Thread.sleep(2000);
		AssignProjectVendor.clickOn_DropDown();
		AssignProjectVendor.SelectVendorToAssignProject();
		AssignProjectVendor.ClickOnAssignVendorButton();
		AssignProjectVendor.SelectedVendorAssignedSuccessfully();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(vendorphoneOrEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(OTP);
		Vendorlogin.clickOnBtn_Login();

		Thread.sleep(2000);

		ProjectPage.clickOnProjectTabButton();
		AssignProjectVendor.SelectCreatedProject();

		JobApplication.clickOnPrepareAndSendQuote();
		Thread.sleep(2000);
		JobApplication.enterAmount(Amount);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);

		JobApplication.clickToOpenCalendar();
		JobApplication.clickToSelectDate();
		JobApplication.enterPaymentTerms(PaymentTerms);
		JobApplication.enterAdditionalTerms(AdditionalTerms);
		JobApplication.clickOnSendQuote();
		Thread.sleep(2000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		Thread.sleep(2000);

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(EnterEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(EnterOTP);
		Vendorlogin.clickOnBtn_Login();
		Thread.sleep(2000);

		WorkorderPage.clickOnWorkorderButton();
		Thread.sleep(2000);
		WorkorderPage.clickOnCreateWorkorderButton();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		WorkorderPage.clickOnAddBillingButton();
		Thread.sleep(2000);
		WorkorderPage.clickOnAddTitleButton();
		WorkorderPage.enterTitle(Title);
		Thread.sleep(2000);
		JobApplication.clickOnAssignVendor();
		Thread.sleep(2000);
		JobApplication.clickToSelectVendorFromOption();
		Thread.sleep(2000);
		WorkorderPage.clickOnSeeSummaryButton();
		Thread.sleep(2000);
		JobApplication.clickOnSubmitApproval();
		JobApplication.clickOnCloseMessage();
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
		Thread.sleep(5000);
		Applogin.clickOnAppActiveJob();
		Thread.sleep(2000);
		Applogin.clickOnApplyActiveJob();

		Thread.sleep(4000);

		driver.get(prop.getProperty("testURL"));

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(VendorEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(VendorOTP);
		Vendorlogin.clickOnBtn_Login();
		Thread.sleep(2000);

		WorkorderPage.clickOnWorkorderButton();
		Thread.sleep(2000);
		JobApplicationPage.clickOnActiveWorkorder();
		Thread.sleep(3000);
		// JobApplicationPage.ClickToApproveChamp();
		// JobApplicationPage.JobApplicationStatus();
		// Thread.sleep(3000);
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