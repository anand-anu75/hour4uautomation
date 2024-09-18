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

public class CreateProjectSelfAgency extends BaseTest {
	CreateProjectPage ProjectPage;

	Login loginObject = new Login();

	// Create Project For Self Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateProjectPageTestData(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String StartDate, String EndDate, String FieldName, String EnterFrequency,
			String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
			String EnterDays, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();
		// Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
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
		// ProjectPage.enterStartDate(StartDate);
		ProjectPage.clickOnSelectStartDate();
		ProjectPage.clickOnEndDateButton();
		// ProjectPage.enterEndDate(EndDate);
		ProjectPage.clickOnSelectEndDate();
		ProjectPage.clickOnSelectLocationButton();
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		// ProjectPage.enterFieldName(FieldName);
		// ProjectPage.clickOnFieldTypeDropDown();
		// ProjectPage.clickOnPhoneNumberButton();
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

		String projectCreatedSuccesfullyMessage = ProjectPage.ProjectCreatedSuccesfully() + "\n"
				+ ProjectPage.ProjectCreatedMessage();

//		String ProjectCreatedMessage = ProjectPage.ProjectCreatedMessage();
//		softAssert.assertEquals(ProjectCreatedMessage, ExpectedMessage);
		try {
			softAssert.assertEquals(projectCreatedSuccesfullyMessage, ExpectedResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Test for Selecting Invalid Project Type for Self Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void SelectingImproperProjectType(String phoneOrEmail, String OTP, String expectedURL, String ExpectedResult)
			throws InterruptedException, IOException {
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();
		// Thread.sleep(2000);

		ProjectPage.clickOnProjectTypeButton();
		// ProjectPage.clickOnSelectProjectTypeButton();
		// ProjectPage.clickOnHotspotButton();
		Thread.sleep(1000);
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		// ProjectPage.clickOnProjectDetailsButton();

		String SelectedImproperProjectType = ProjectPage.SelectedImproperProjectType();

		try {
			softAssert.assertEquals(SelectedImproperProjectType, ExpectedResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Test for Invalid Project Description for Self Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void InvalidProjectDescription(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();
		// Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		// ProjectPage.clickOnProjectDetailsButton();
		scrollPageDown();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		ProjectPage.clickOnSelectLocationButton();

		String ProperProjectDescription = ProjectPage.EnterProperProjectDescription();

		try {
			softAssert.assertEquals(ProperProjectDescription, ExpectedResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Test for Invalid Field Name for Self Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void InvalidFieldName(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
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
		ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();
		// Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
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
		scrollPageDown();
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		ProjectPage.pressBackSpaceButton();

		// ProjectPage.clickOnFieldTypeDropDown();
		// ProjectPage.clickOnPhoneNumberButton();
		ProjectPage.clickOnContinuousLocationTracking();
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
		// ProjectPage.clickOnOnlyGpsCoordinate();
		ProjectPage.clickOnAddBilling();

		String InvalidFieldName = ProjectPage.InvalidFieldName();

		try {
			softAssert.assertEquals(InvalidFieldName, ExpectedResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Test for Invalid Field Type for Self Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void InvalidFieldType(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();
		// Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
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
		// ProjectPage.clickOnFieldTypeDropDown();
		// Perform actions to get successfull error message
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();
		ProjectPage.clickOnAddBilling();

		String InvalidFieldType = ProjectPage.InvalidFielType();
		softAssert.assertEquals(InvalidFieldType, ExpectedResult);
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

	// Test for Invalid Frequency for Self Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void InvalidFrequency(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
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
		ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();
		// Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
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
		// ProjectPage.clickOnFieldTypeDropDown();
		// ProjectPage.clickOnPhoneNumberButton();
		ProjectPage.clickOnContinuousLocationTracking();
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
		// ProjectPage.clickOnOnlyGpsCoordinate();
		ProjectPage.clickOnAddBilling();

		String InvalidFrequency = ProjectPage.InvalidFrequency();

		try {
			softAssert.assertEquals(InvalidFrequency, ExpectedResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Test for Invalid Radius for Self Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void InvalidRadius(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
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
		ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();
		// Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
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
		// ProjectPage.clickOnFieldTypeDropDown();
		// ProjectPage.clickOnPhoneNumberButton();
		ProjectPage.clickOnContinuousLocationTracking();
		scrollPageDown();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
		// ProjectPage.clickOnOnlyGpsCoordinate();
		ProjectPage.clickOnAddBilling();

		String InvalidRadius = ProjectPage.InvalidRadius();

		try {
			softAssert.assertEquals(InvalidRadius, ExpectedResult);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	// Test for Invalid Project Title for Self Agency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void InvalidProjectTitle(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNext1Button();
		//Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		// ProjectPage.clickOnProjectDetailsButton();
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		ProjectPage.clickOnSelectLocationButton();

		String InvalidProjectTitle = ProjectPage.InvalidProjectTitle();

		try {
			softAssert.assertEquals(InvalidProjectTitle, ExpectedResult);
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
