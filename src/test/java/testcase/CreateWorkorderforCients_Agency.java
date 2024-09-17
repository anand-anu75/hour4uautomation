package testcase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import pages.InvitingclientPage;
import utilities.ReadXLData;

public class CreateWorkorderforCients_Agency extends BaseTest{
	
	CreateworkorderPage WorkorderPage;
	Login loginAgency = new Login();

	// Create WorkOrder for Agency
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateWorkorderforCientsAgency(String phoneOrEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedSuccessmessage,String EnterpriseEmail, String EnterPassword, String ExpectedMessage) throws InterruptedException, IOException {

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		WorkorderPage = new CreateworkorderPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
		
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.clickOnErrorMessage();
		WorkorderPage.enterDhruviEmail(EnterpriseEmail);
		WorkorderPage.enterDhruviPassword(EnterPassword);
		WorkorderPage.clickOnLoginButton();
//		ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnAcceptWorkOrder();

		String actualSuccessmessage = WorkorderPage.WorkOrderApprovedMessage();
		WorkorderPage.closeSuccessMessagePopup();

		try {
			softAssert.assertEquals(actualSuccessmessage, ExpectedMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}
	
	// Accept the workorder
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ClientProjectWorkorder(String phoneOrEmail, String expectedURL, String CompanyName, String PersonName,
			String Email, String MobileResponsible, String expectedSuccessMessage, String OTP, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String StartDate, String EndDate, String FieldName, String EnterFrequency,
			String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
			String EnterDays, String ExpectedResult, String SearchAgency, String EnterAgencyEmail, String EnterOTP,
			String ExpectedMessage,String Date, String Title,String expectedSuccessmessage,String EnterpriseEmail, String EnterPassword, String ExpectedMessageResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		WorkorderPage = new CreateworkorderPage(driver);

		ClientPage.clickOnUserButton();

		ClientPage.clickOnClientsOption();

		ClientPage.clickOnInviteClientButton();

		ClientPage.NavigateToDialogBox();

		ClientPage.enterClientName(CompanyName);
		ClientPage.enterContactPersonName(PersonName);
		ClientPage.enterEmail(Email);
		ClientPage.enterContactPersonPhone(MobileResponsible);
	//	Thread.sleep(1000);
		ClientPage.clickOnCreateClientButton();

	//	Thread.sleep(1000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		// ProjectPage.clickOnErrorMessage();

		ProjectPage.enterAgencyEmail(Email);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(OTP);
		ProjectPage.clickOnLoginButton();
//	        ProjectPage.clickOnErrorMessage();

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		// ProjectPage.clickOnNext1Button();
//		Thread.sleep(1000);
		// ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
//	        Thread.sleep(2000);
		ProjectPage.clickOnHotspotButton();
		ProjectPage.clickOnProjectTypeNextButton();
		// ProjectPage.clickOnProjectDetailsButton();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		ProjectPage.enterProjectCode(ProjectCode);
		ProjectPage.enterLinkTitle(LinkTitle);
		ProjectPage.enterURL(LinkURL);
		ProjectPage.enterMetrics(EnterMetrics);
		ProjectPage.enterQuantity(EnterQuantity);
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
//	      ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
//		Thread.sleep(1000);
		ProjectPage.ClickOnAssignAgency();
		ProjectPage.enterSearchAgency(SearchAgency);
//		Thread.sleep(2000);
		ProjectPage.ClickOnAugustAgency();
		ProjectPage.clickOnSearchAssignAgency();
//		Thread.sleep(1000);
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.enterAgencyEmail(EnterAgencyEmail);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(EnterOTP);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		ProjectPage.clickOnProjectTabButton();
		ProjectPage.clickOnAcceptProject();

		// ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();

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
		
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.clickOnErrorMessage();
		WorkorderPage.enterDhruviEmail(EnterpriseEmail);
		WorkorderPage.enterDhruviPassword(EnterPassword);
		WorkorderPage.clickOnLoginButton();
//		ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnAcceptWorkOrder();

		String actualSuccessmessage = WorkorderPage.WorkOrderApprovedMessage();
		WorkorderPage.closeSuccessMessagePopup();

		try {
			softAssert.assertEquals(actualSuccessmessage, ExpectedMessageResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}
	
	//P0 required at the time of project
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ClientProjectWorkorderApproval(String phoneOrEmail, String expectedURL, String CompanyName, String PersonName,
			String Email, String MobileResponsible, String expectedSuccessMessage, String OTP, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String StartDate, String EndDate, String FieldName, String EnterFrequency,
			String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
			String EnterDays, String ExpectedResult, String SearchAgency, String EnterAgencyEmail, String EnterOTP,
			String ExpectedMessage,String Date, String Title,String expectedSuccessmessage,String EnterpriseEmail, String EnterPassword, String ExpectedMessageResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		WorkorderPage = new CreateworkorderPage(driver);

		ClientPage.clickOnUserButton();

		ClientPage.clickOnClientsOption();

		ClientPage.clickOnInviteClientButton();

		ClientPage.NavigateToDialogBox();

		ClientPage.enterClientName(CompanyName);
		ClientPage.enterContactPersonName(PersonName);
		ClientPage.enterEmail(Email);
		ClientPage.enterContactPersonPhone(MobileResponsible);
	//	Thread.sleep(1000);
		ClientPage.clickOnCreateClientButton();

	//	Thread.sleep(1000);

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();

		// ProjectPage.clickOnErrorMessage();

		ProjectPage.enterAgencyEmail(Email);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(OTP);
		ProjectPage.clickOnLoginButton();
//	        ProjectPage.clickOnErrorMessage();

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		// ProjectPage.clickOnNext1Button();
//		Thread.sleep(1000);
		// ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
//	        Thread.sleep(2000);
		ProjectPage.clickOnHotspotButton();
		ProjectPage.clickOnProjectTypeNextButton();
		// ProjectPage.clickOnProjectDetailsButton();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		ProjectPage.enterProjectCode(ProjectCode);
		ProjectPage.enterLinkTitle(LinkTitle);
		ProjectPage.enterURL(LinkURL);
		ProjectPage.enterMetrics(EnterMetrics);
		ProjectPage.enterQuantity(EnterQuantity);
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
//	      ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
//		Thread.sleep(1000);
		ProjectPage.ClickOnAssignAgency();
		ProjectPage.enterSearchAgency(SearchAgency);
//		Thread.sleep(2000);
		ProjectPage.ClickOnAugustAgency();
		ProjectPage.clickOnSearchAssignAgency();
//		Thread.sleep(1000);
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.enterAgencyEmail(EnterAgencyEmail);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(EnterOTP);
		ProjectPage.clickOnLoginButton();

		// ProjectPage.clickOnErrorMessage();

		ProjectPage.clickOnProjectTabButton();
		ProjectPage.clickOnAcceptProject();

		// ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();

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
		
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.clickOnErrorMessage();
		WorkorderPage.enterDhruviEmail(EnterpriseEmail);
		WorkorderPage.enterDhruviPassword(EnterPassword);
		WorkorderPage.clickOnLoginButton();
//		ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnAcceptWorkOrder();

		String actualSuccessmessage = WorkorderPage.WorkOrderApprovedMessage();
		WorkorderPage.closeSuccessMessagePopup();

		try {
			softAssert.assertEquals(actualSuccessmessage, ExpectedMessageResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}
	
	//Invalid Start Time
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateWorkorderInvalidStartTime(String phoneOrEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedStarttimeErrorMessage) throws InterruptedException, IOException {

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		WorkorderPage = new CreateworkorderPage(driver);

		WorkorderPage.clickOnWorkorderButton();

		WorkorderPage.clickOnCreateWorkorderButton();

		WorkorderPage.NavigateTodialogBox();

		WorkorderPage.clickOnSelectProjectButton();

		WorkorderPage.clickOnAddDetailsButton();

		WorkorderPage.clickOnSearchAddressButton();

		// WorkorderPage.enterDate(Date);

		WorkorderPage.clickOnStartTimeButton();

		// WorkorderPage.clickOnSelectStarttimeButton();

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();

		/*
		 * WorkorderPage.clickOnEndTimeButton();
		 * 
		 * WorkorderPage.clickOnSelectEndtimeButton();
		 * 
		 * WorkorderPage.clickOnAddBillingButton();
		 * 
		 * WorkorderPage.clickOnAddTitleButton();
		 * 
		 * WorkorderPage.enterTitle(Title);
		 * 
		 * WorkorderPage.clickOnSeeSummaryButton();
		 * 
		 * WorkorderPage.clickOnSubmitforApprovalButton();
		 */

		String actualStarttimeErrorMessage = WorkorderPage.getStarttimeErrorMessage();
		softAssert.assertEquals(actualStarttimeErrorMessage, expectedStarttimeErrorMessage);

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
	
	//Invalid End Time
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateWorkorderInvalidEndTime(String phoneOrEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedEndtimeErrorMessage) throws InterruptedException, IOException {

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		WorkorderPage = new CreateworkorderPage(driver);

		WorkorderPage.clickOnWorkorderButton();

		WorkorderPage.clickOnCreateWorkorderButton();

		WorkorderPage.NavigateTodialogBox();

		WorkorderPage.clickOnSelectProjectButton();

		WorkorderPage.clickOnAddDetailsButton();

		WorkorderPage.clickOnSearchAddressButton();

		// WorkorderPage.enterDate(Date);

		WorkorderPage.clickOnStartTimeButton();

		// WorkorderPage.clickOnSelectStarttimeButton();

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();

		WorkorderPage.clickOnEndTimeButton();

		Actions actions1 = new Actions(driver);
		actions1.sendKeys(Keys.ESCAPE).perform();

		/*
		 * WorkorderPage.clickOnSelectEndtimeButton();
		 * 
		 * WorkorderPage.clickOnAddBillingButton();
		 * 
		 * WorkorderPage.clickOnAddTitleButton();
		 * 
		 * WorkorderPage.enterTitle(Title);
		 * 
		 * WorkorderPage.clickOnSeeSummaryButton();
		 * 
		 * WorkorderPage.clickOnSubmitforApprovalButton();
		 */

		String actualEndtimeErrorMessage = WorkorderPage.getEndtimeErrorMessage();
		softAssert.assertEquals(actualEndtimeErrorMessage, expectedEndtimeErrorMessage);

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
	
	//Invalid Location
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateWorkorderInvalidLocation(String phoneOrEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedLocationErrorMessage) throws InterruptedException, IOException {

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		WorkorderPage = new CreateworkorderPage(driver);

		WorkorderPage.clickOnWorkorderButton();

		WorkorderPage.clickOnCreateWorkorderButton();

		WorkorderPage.NavigateTodialogBox();

		WorkorderPage.clickOnSelectProjectButton();

		WorkorderPage.clickOnAddDetailsButton();

		// WorkorderPage.clickOnSearchAddressButton();

		WorkorderPage.enterDate(Date);

		/*
		 * WorkorderPage.clickOnStartTimeButton();
		 * 
		 * WorkorderPage.clickOnSelectStarttimeButton();
		 * 
		 * Actions actions = new Actions(driver);
		 * actions.sendKeys(Keys.ESCAPE).perform();
		 * 
		 * WorkorderPage.clickOnEndTimeButton();
		 * 
		 * WorkorderPage.clickOnSelectEndtimeButton();
		 * 
		 * WorkorderPage.clickOnAddBillingButton();
		 * 
		 * WorkorderPage.clickOnAddTitleButton();
		 * 
		 * WorkorderPage.enterTitle(Title);
		 * 
		 * WorkorderPage.clickOnSeeSummaryButton();
		 * 
		 * WorkorderPage.clickOnSubmitforApprovalButton();
		 */

		String actualLocationErrorMessage = WorkorderPage.getLocationErrorMessage();
		softAssert.assertEquals(actualLocationErrorMessage, expectedLocationErrorMessage);

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
	
	//Invalid Date
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateWorkorderInvalidDate(String phoneOrEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedDateErrorMessage) throws InterruptedException, IOException {

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		WorkorderPage = new CreateworkorderPage(driver);

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

		/*
		 * WorkorderPage.clickOnEndTimeButton();
		 * 
		 * WorkorderPage.clickOnSelectEndtimeButton();
		 * 
		 * WorkorderPage.clickOnAddBillingButton();
		 * 
		 * WorkorderPage.clickOnAddTitleButton();
		 * 
		 * WorkorderPage.enterTitle(Title);
		 * 
		 * WorkorderPage.clickOnSeeSummaryButton();
		 * 
		 * WorkorderPage.clickOnSubmitforApprovalButton();
		 */

		String actualDateErrorMessage = WorkorderPage.getDateErrorMessage();
		softAssert.assertEquals(actualDateErrorMessage, expectedDateErrorMessage);

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
	
	// Verify Name Error
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateWorkorderNameError(String phoneOrEmail, String OTP, String expectedURL, String Name, String Phone,
			String Email, String Address, String expectedErrorMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);

		ClientPage.clickOnUserButton();

		ClientPage.clickOnClientsOption();

		ClientPage.clickOnInviteClientButton();

		ClientPage.NavigateToDialogBox();

		String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the
																	// name
	//	String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
		// String randomEmail = generateRandomEmail(Email); // Appends a random number
		// to the email username

		ClientPage.enterClientName(randomName);
		ClientPage.enterContactPersonName(Name);
		ClientPage.enterEmail(Email);
		ClientPage.enterContactPersonPhone(Phone);
	//	Thread.sleep(1000);
		ClientPage.clickOnCreateClientButton();

		String actualErrorMessage = ClientPage.getErrorMessage();
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);

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
	
	// Verify Phone Error
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateWorkorderPhoneError(String phoneOrEmail, String OTP, String expectedURL, String Name, String Phone,
			String Email, String Address, String expectedPhoneErrorMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);

		ClientPage.clickOnUserButton();

		ClientPage.clickOnClientsOption();

		ClientPage.clickOnInviteClientButton();

		ClientPage.NavigateToDialogBox();

		String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the
																	// name
	//	String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
		// String randomEmail = generateRandomEmail(Email); // Appends a random number
		// to the email username

		ClientPage.enterClientName(randomName);
		ClientPage.enterContactPersonName(Name);
		ClientPage.enterEmail(Email);
//		ClientPage.enterContactPersonPhone(Phone);
	//	Thread.sleep(1000);
		ClientPage.clickOnCreateClientButton();

		String actualPhoneErrorMessage = ClientPage.getPhoneErrorMessage();
		softAssert.assertEquals(actualPhoneErrorMessage, expectedPhoneErrorMessage);

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
	
	// Verify Email Error
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateWorkorderEmailError(String phoneOrEmail, String OTP, String expectedURL, String Name, String Phone,
			String Email, String Address, String expectedSuccessMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);

		ClientPage.clickOnUserButton();

		ClientPage.clickOnClientsOption();

		ClientPage.clickOnInviteClientButton();

		ClientPage.NavigateToDialogBox();

		String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the
																	// name
	//	String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
		// String randomEmail = generateRandomEmail(Email); // Appends a random number
		// to the email username

		ClientPage.enterClientName(randomName);
		ClientPage.enterContactPersonName(Name);
		ClientPage.enterEmail(Email);
		ClientPage.enterContactPersonPhone(Phone);
	//	Thread.sleep(1000);
		ClientPage.clickOnCreateClientButton();

		String actualEmailErrorMessage = ClientPage.getEmailErrorMessage();
		softAssert.assertEquals(actualEmailErrorMessage, expectedSuccessMessage);

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
