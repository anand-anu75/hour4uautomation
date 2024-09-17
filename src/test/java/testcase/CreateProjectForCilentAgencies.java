package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import pages.InvitingclientPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class CreateProjectForCilentAgencies extends BaseTest {

	Login loginAgency = new Login();

	// Create Project for Client/Agencies

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void createProjectForAgencies(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL,
			String EnterMetrics, String EnterQuantity, String StartDate, String EndDate, String FieldName,
			String EnterFrequency, String EnterRadius, String EnterItem, String EnterDescription, String EnterRates,
			String EnterQty, String EnterDays, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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

		String ProjectCreatedSuccesfully = ProjectPage.ProjectCreatedSuccesfully();
		softAssert.assertEquals(ProjectCreatedSuccesfully, ExpectedResult);
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


	// Invalid Project Type - Creating Project agencies

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateProjectInvalidProjectType(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
		ProjectPage.clickOnSelfClientButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		// ProjectPage.clickOnSelectProjectTypeButton();
		// ProjectPage.clickOnHotspotButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnNext2Button();
		// ProjectPage.clickOnProjectDetailsButton();

		String SelectedImproperProjectType = ProjectPage.SelectedImproperProjectType();
		softAssert.assertEquals(SelectedImproperProjectType, ExpectedResult);
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

	// Invalid Project Title - Creating Project Agencies

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateProjectInvalidProjectTitl(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
		ProjectPage.clickOnNext2Button();
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

	// Invalid Project Description - Creating Project Agencies

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateProjectInvalidProjectDesc(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	// Invalid Field Name - Create Project Agencies

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateProjectInvalidFieldName(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL,
			String EnterMetrics, String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
		ProjectPage.clickOnNext2Button();
		// ProjectPage.clickOnProjectDetailsButton();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		ProjectPage.enterProjectCode(ProjectCode);
		Thread.sleep(1000);
		scrollPageDown();
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

	// Invalid Frequency - Create Project Agencies

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateProjectInvalidFrequency(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL,
			String EnterMetrics, String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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

	// Invalid Radius - Create Project Agencies

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateProjectInvalidRadius(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ProjectTitle, String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL,
			String EnterMetrics, String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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

	// Invalid Name

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void verify_NameError(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedErrorMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);

		ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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

	// Invalid Phone number

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void verify_PhoneError(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);

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

		String actualPhoneErrorMessage = ClientPage.getPhoneErrorMessage();
		softAssert.assertEquals(actualPhoneErrorMessage, expectedSuccessMessage);

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

	// Invalid Email

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void verify_EmailError(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);

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

	// Invalid Enterprise

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ProjectClientInvalidEnterprise(String phoneOrEmail, String OTP, String expectedURL, String CompanyName,
			String PersonName, String Email, String MobileResponsible, String expectedSuccessMessage,
			String ExpectedMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		InvitingclientPage ClientPage = new InvitingclientPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);

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
		Thread.sleep(1000);
		scrollPageDown();
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

}