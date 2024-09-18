package testcase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class GetProjectApprovalAgencies extends BaseTest {

	// Get Project Approvals - Agencies
	// Workorder is done Successfully
	EnterpriseLogin enterpriseLogin = new EnterpriseLogin();
	Login agencyLogin = new Login();

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ProjectApprovalAgencies(String ProjectTitle, String ProjectDescription, String ProjectCode,
			String LinkTitle, String LinkURL, String EnterMetrics, String EnterQuantity, String StartDate,
			String EndDate, String FieldName, String EnterFrequency, String EnterRadius, String EnterItem,
			String EnterDescription, String EnterRates, String EnterQty, String EnterDays, String ExpectedResult,
			String SearchAgency, String EnterAgencyEmail, String EnterOTP, String Date, String Title,
			String expectedSuccessmessage, String phoneOrEmail, String EnterPassword, String ExpectedMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// EnterpriseLogin enterpriseLogin = new EnterpriseLogin();
		enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, EnterPassword);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		
		
		ProjectPage.clickOnSelectProjectTypeButton();
//        
		ProjectPage.clickOnHotspotButton();
		
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		
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
     
		
		ProjectPage.ClickOnAssignAgency();
		ProjectPage.enterSearchAgency(SearchAgency);
	
		ProjectPage.ClickOnAugustAgency();
		ProjectPage.clickOnSearchAssignAgency();
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.enterAgencyEmail(EnterAgencyEmail);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(EnterOTP);
		ProjectPage.clickOnLoginButton();
	
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
		

		WorkorderPage.clickOnAddBillingButton();

		WorkorderPage.clickOnAddTitleButton();

		WorkorderPage.enterTitle(Title);

		WorkorderPage.clickOnSeeSummaryButton();

		WorkorderPage.clickOnSubmitforApprovalButton();
		// ProjectPage.clickOnErrorMessage();

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		WorkorderPage.enterDhruviEmail(phoneOrEmail);
		WorkorderPage.enterDhruviPassword(EnterPassword);
		WorkorderPage.clickOnLoginButton();
	//	ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnAcceptWorkOrder();

		String actualSuccessmessage = WorkorderPage.WorkOrderApprovedMessage();
		softAssert.assertEquals(actualSuccessmessage, ExpectedMessage);

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

	// Existing Enterprise - Invalid Project Type

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ProjectApproveInvalidProjectTyp(String phoneOrEmail, String OTP, String expectedURL,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		agencyLogin.login(phoneOrEmail, OTP, expectedURL);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
		
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		
		

		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();

		String ExistingInvalidProjectType = ProjectPage.ExistingInvalidProjectType();
		softAssert.assertEquals(ExistingInvalidProjectType, ExpectedResult);
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

	// Existing Enterprise - Invalid Project Title

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ProjectApprovInvalidProjectTltl(String phoneOrEmail, String OTP, String expectedURL,
			String ProjectTitle, String ProjectDescription, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		agencyLogin.login(phoneOrEmail, OTP, expectedURL);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		
		ProjectPage.clickOnExistingEnterprise();
		
		ProjectPage.SelectDropdownEnterprise();
		
		ProjectPage.SelectOptionEnterprise();
	
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		ProjectPage.clickOnProjectDetailsButton();
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
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Existing Enterprise - Invalid Project Description

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ProjectApprovInvalidProjectDesc(String phoneOrEmail, String OTP, String expectedURL,
			String ProjectTitle, String ProjectDescription, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		agencyLogin.login(phoneOrEmail, OTP, expectedURL);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
		ProjectPage.clickOnNext1Button();
		
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();

		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		scrollPageDown();
		ProjectPage.clickOnSelectLocationButton();

		String InvalidProjectDescription = ProjectPage.EnterProperProjectDescription();
		softAssert.assertEquals(InvalidProjectDescription, ExpectedResult);
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

	// Existing Enterprise - Invalid Field Name

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ProjectApprovInvalidFieldName(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		agencyLogin.login(phoneOrEmail, OTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
		ProjectPage.clickOnNext1Button();
		
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		
		ProjectPage.clickOnProjectDetailsButton();
		
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
		scrollPageDown();
		
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		ProjectPage.clickOnEnterItem();
	//	ProjectPage.clickOnFieldTypeDropDown();
	//	ProjectPage.clickOnPhoneNumberButton();
	//	ProjectPage.clickOnContinuousLocationTracking();
	//	ProjectPage.enterFrequency(EnterFrequency);
		scrollPageDown();
	//	ProjectPage.enterRadius(EnterRadius);
		
	//	ProjectPage.clickOnAddBilling();

		String InvalidFieldName = ProjectPage.InvalidFieldName();
		softAssert.assertEquals(InvalidFieldName, ExpectedResult);
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

	// Existing Enterprise - Invalid Frequency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ProjectApprovInvalidFrequency(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		agencyLogin.login(phoneOrEmail, OTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
		ProjectPage.clickOnNext1Button();
		
		ProjectPage.clickOnProjectTypeButton();
		
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		
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
		scrollPageDown();
	
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		ProjectPage.clickOnFieldTypeDropDown();
		ProjectPage.clickOnPhoneNumberButton();
		ProjectPage.clickOnContinuousLocationTracking();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
	
		ProjectPage.clickOnAddBilling();

		String InvalidFrequency = ProjectPage.InvalidFrequency();
		softAssert.assertEquals(InvalidFrequency, ExpectedResult);
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

	// Existing Enterprise - Invalid Radius

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ProjectApprovInvalidRadius(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		agencyLogin.login(phoneOrEmail, OTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
		ProjectPage.clickOnNext1Button();
	
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();

	
		ProjectPage.clickOnProjectTypeNextButton();
		
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
		scrollPageDown();
	
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		ProjectPage.clickOnFieldTypeDropDown();
		ProjectPage.clickOnPhoneNumberButton();
		ProjectPage.clickOnContinuousLocationTracking();
		ProjectPage.enterFrequency(EnterFrequency);
		scrollPageDown();
	
		ProjectPage.enterRadius(EnterRadius);
		// ProjectPage.clickOnOnlyGpsCoordinate();
		ProjectPage.clickOnAddBilling();

		String InvalidRadius = ProjectPage.InvalidRadius();
		softAssert.assertEquals(InvalidRadius, ExpectedResult);
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
