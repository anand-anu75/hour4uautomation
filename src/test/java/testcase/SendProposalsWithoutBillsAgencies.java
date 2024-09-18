package testcase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CreateProjectPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class SendProposalsWithoutBillsAgencies extends BaseTest {
	CreateProjectPage ProjectPage;
	Login loginObject = new Login();

	// Send Proposals Without Bills for Existing Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void SendProposalWithoutBill(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String StartDate, String EndDate, String FieldName, String EnterFrequency,
			String EnterRadius, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);
		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		
		ProjectPage.SelectOptionEnterprise();
		scrollPageDown();
	
		ProjectPage.clickOnNext1Button();

		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
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
		
		ProjectPage.clickOnContinuousLocationTracking();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
	
		ProjectPage.clickOnAddBilling();
	
		ProjectPage.ClickOnToggleSwitch();

		ProjectPage.clickOnReviewProject();
		ProjectPage.clickOnSaveProject();

		String SendProposalWithoutBill = ProjectPage.ProjectCreatedSuccesfully();

		try {
			softAssert.assertEquals(SendProposalWithoutBill, ExpectedResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Existing Enterprise - Invalid Enterprise

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ExistingInvalidEnterprise(String phoneOrEmail, String OTP, String expectedURL, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);
		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
	
		ProjectPage.clickOnCreateProjectButton();

	
		
		scrollPageDown();
		ProjectPage.clickOnNext1Button();

		String ExistingInvalidEnterprise = ProjectPage.ExistingInvalidEnterprise();

		try {
			softAssert.assertEquals(ExistingInvalidEnterprise, ExpectedResult);
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
	public void ExistingInvalidProjectType(String phoneOrEmail, String OTP, String expectedURL, String ExpectedResult)
			throws InterruptedException, IOException {
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

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
	
		
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();

		String ExistingInvalidProjectType = ProjectPage.ExistingInvalidProjectType();

		try {
			softAssert.assertEquals(ExistingInvalidProjectType, ExpectedResult);
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
	public void ExistingInvalidProjectTitle(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ExpectedResult) throws InterruptedException, IOException {
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject.login(phoneOrEmail, OTP, expectedURL);
		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
	
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		// Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();
	
		ProjectPage.clickOnProjectTypeNextButton();
	
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
	public void ExistingInvalidProjectDesc(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ExpectedResult) throws InterruptedException, IOException {
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

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
		ProjectPage.enterProjectTitle(ProjectTitle);
		scrollPageDown();
	
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

	// Existing Enterprise - Invalid Field Name

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ExistingInvalidFieldName(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

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
		// ProjectPage.clickOnProjectDetailsButton();
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
		ProjectPage.pressBackSpaceButton();
	
//		ProjectPage.clickOnContinuousLocationTracking();
//		scrollPageDown();
	//	ProjectPage.enterFrequency(EnterFrequency);
	//	ProjectPage.enterRadius(EnterRadius);
		// ProjectPage.clickOnOnlyGpsCoordinate();
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

	// Existing Enterprise - Invalid Field Type
	/*
	 * @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData") public
	 * void InvalidFieldType(String phoneOrEmail, String OTP, String expectedURL,
	 * String ProjectTitle, String ProjectDescription, String ProjectCode, String
	 * LinkTitle, String LinkURL, String EnterMetrics, String EnterQuantity, String
	 * FieldName, String ExpectedResult) throws InterruptedException, IOException {
	 * 
	 * softAssert = new SoftAssert(); assertionMessage = new ThreadLocal<>();
	 * 
	 * loginObject.login(phoneOrEmail, OTP, expectedURL); ProjectPage = new
	 * CreateProjectPage(driver);
	 * 
	 * // ProjectPage.clickOnErrorMessage(); ProjectPage.clickOnProjectTabButton();
	 * // ProjectPage.clickOnErrorMessage();
	 * ProjectPage.clickOnCreateProjectButton(); //
	 * ProjectPage.clickOnSelfClientButton();
	 * ProjectPage.clickOnExistingEnterprise();
	 * ProjectPage.SelectDropdownEnterprise(); // Thread.sleep(2000);
	 * ProjectPage.SelectOptionEnterprise(); Thread.sleep(1000); scrollPageDown();
	 * ProjectPage.clickOnNext1Button(); // Thread.sleep(2000);
	 * ProjectPage.clickOnProjectTypeButton();
	 * ProjectPage.clickOnSelectProjectTypeButton();
	 * ProjectPage.clickOnHotspotButton(); scrollPageDown(); Thread.sleep(1000);
	 * ProjectPage.clickOnProjectTypeNextButton(); //
	 * ProjectPage.clickOnProjectDetailsButton();
	 * ProjectPage.enterProjectTitle(ProjectTitle);
	 * ProjectPage.enterProjectDescription(ProjectDescription); scrollPageDown();
	 * Thread.sleep(1000); ProjectPage.enterProjectCode(ProjectCode);
	 * ProjectPage.enterLinkTitle(LinkTitle); ProjectPage.enterURL(LinkURL);
	 * ProjectPage.enterMetrics(EnterMetrics);
	 * ProjectPage.enterQuantity(EnterQuantity); scrollPageDown();
	 * Thread.sleep(1000); ProjectPage.clickOnStartDateButton();
	 * ProjectPage.clickOnSelectStartDate(); ProjectPage.clickOnEndDateButton();
	 * ProjectPage.clickOnSelectEndDate();
	 * ProjectPage.clickOnSelectLocationButton();
	 * ProjectPage.clickOnSelectLocationDelhiButton();
	 * ProjectPage.clickOnAddTrackingButton();
	 * ProjectPage.enterFieldName(FieldName); //
	 * ProjectPage.clickOnFieldTypeDropDown(); // Perform actions to get successfull
	 * error message Actions actions = new Actions(driver);
	 * actions.sendKeys(Keys.ESCAPE).perform(); ProjectPage.clickOnAddBilling();
	 * 
	 * String InvalidFieldType = ProjectPage.InvalidFielType();
	 * softAssert.assertEquals(InvalidFieldType, ExpectedResult); try {
	 * softAssert.assertAll(); } catch (AssertionError e) {
	 * assertionMessage.set(e.getMessage()); throw e; } }
	 */

	// Existing Enterprise - Invalid Frequency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ExistingInvalidFrequency(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
			throws InterruptedException, IOException {
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

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
		
		ProjectPage.clickOnContinuousLocationTracking();
		scrollPageDown();
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
	public void ExistingInvalidRadius(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
			throws InterruptedException, IOException {
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		
		ProjectPage.clickOnExistingEnterprise();
		ProjectPage.SelectDropdownEnterprise();
		ProjectPage.SelectOptionEnterprise();
	
		scrollPageDown();
		ProjectPage.clickOnNext1Button();
		
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();
	
		ProjectPage.clickOnProjectTypeNextButton();
		// ProjectPage.clickOnProjectDetailsButton();
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
		
		ProjectPage.clickOnContinuousLocationTracking();
		ProjectPage.enterFrequency(EnterFrequency);
		scrollPageDown();
		
		ProjectPage.enterRadius(EnterRadius);
		
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
