package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateProjectPage.RandomGeneratorUtil;
import pages.CreateworkorderPage;
import pages.InvitingclientPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class AcceptRejectFromClients extends BaseTest {

	InvitingclientPage ClientPage;
	CreateworkorderPage WorkorderPage;
	CreateProjectPage ProjectPage;

	Login loginObject = new Login();
	
	//Accepting project

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void AcceptRejectClients(String phoneOrEmail, String expectedURL, String CompanyName, String PersonName,
			String Email, String MobileResponsible, String expectedSuccessMessage, String OTP, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String StartDate, String EndDate, String FieldName, String EnterFrequency,
			String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
			String EnterDays, String ExpectedResult, String SearchAgency, String EnterAgencyEmail, String EnterOTP,
			String ExpectedMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

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

		String actualSuccessmessage = ProjectPage.ProjectStatusUpdated();
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
	

	// Accept/Reject from Clients - Invalid Enterprise


	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void AcceptRejectInvalidEnterprise(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ExpectedMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

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

		Thread.sleep(3000);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		Thread.sleep(1000);
		scrollPageDown();
		// ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();

		String AcceptRejectInvalidEnterprise = ProjectPage.AcceptRejectInvalidEnterprise();
		softAssert.assertEquals(AcceptRejectInvalidEnterprise, ExpectedMessage);
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

	// Accept Reject Invalid Project Type

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void AcceptRejectInvalidProjectType(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

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

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		// ProjectPage.clickOnExistingEnterprise();
		Thread.sleep(2000);
		ProjectPage.SelectDropdownEnterprise();
		Thread.sleep(2000);
		ProjectPage.SelectOptionEnterprise();
		Thread.sleep(2000);
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		// ProjectPage.SelectNewProjectType();
		Thread.sleep(1000);
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

	// Accept Reject From Client - Invalid Project Title

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void AcceptRejectInvalidProjectTitle(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

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

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		// ProjectPage.clickOnExistingEnterprise();
		Thread.sleep(2000);
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
		Thread.sleep(2000);
		scrollPageDown();
		ProjectPage.clickOnNext1Button();

		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		// ProjectPage.clickOnProjectDetailsButton();
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

	// Accept Reject From Client - Invalid Project Description

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void AcceptRejectInvalidProjectDesc(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

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

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
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
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Accept/Reject from Client - Invalid Frequency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void AcceptRejectInvalidFrequency(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL,
			String EnterMetrics, String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

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

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		Thread.sleep(2000);
		ProjectPage.SelectOptionEnterprise();
		Thread.sleep(2000);
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
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
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
		// ProjectPage.clickOnOnlyGpsCoordinate();
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

	// Accept/Reject for Client - Invalid Radius

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void AcceptRejectInvalidRadius(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL,
			String EnterMetrics, String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

		ClientPage = new InvitingclientPage(driver);
		ProjectPage = new CreateProjectPage(driver);

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

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		Thread.sleep(2000);
		ProjectPage.SelectOptionEnterprise();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
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
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
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