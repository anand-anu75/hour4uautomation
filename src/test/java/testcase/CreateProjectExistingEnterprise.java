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

public class CreateProjectExistingEnterprise extends BaseTest {

	Login loginAgency = new Login();

//Create Project for Existing Enterprise

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateExistingProjectPageData(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String CustomFieldName, String ABCD, String FieldName, String EnterFrequency,
			String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
			String EnterDays, String PaymentTerms, String TermsAndConditions, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

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
		
		scrollPageDown();
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
		// ProjectPage.clickOnEndDateButton();
		ProjectPage.ClickOnEnterEndDate();
		ProjectPage.clickOnSelectEndDate();
		// Scroll Window
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		
		ProjectPage.ClickOnAddCustomField();
		ProjectPage.enterCustomFieldName(CustomFieldName);
		ProjectPage.SelectCustomFieldType();
		ProjectPage.SelectCustomTextArea();
		ProjectPage.ClickOnAddField();
		ProjectPage.enterCustomTextArea(ABCD);
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
		// ProjectPage.clickOnOnlyGpsCoordinate();
		ProjectPage.clickOnAddBilling();
		ProjectPage.clickOnPricingFixed();
		ProjectPage.enterItem(EnterItem);
		ProjectPage.enterDescription(EnterDescription);
		ProjectPage.enterRate(EnterRates);
		ProjectPage.enterQty(EnterQty);
		ProjectPage.enterDays(EnterDays);
		ProjectPage.ClickOnAddAditionalItems();
		ProjectPage.ClickOnQuoteDate();
		ProjectPage.SelectValidDate();
		ProjectPage.enterPaymentTerms(PaymentTerms);
		ProjectPage.enterTermsAndConditions(TermsAndConditions);
		ProjectPage.clickOnReviewProject();
		ProjectPage.clickOnSaveProject();

		String ExistingCreatedSuccesfully = ProjectPage.ExistingCreatedSuccesfully();
		softAssert.assertEquals(ExistingCreatedSuccesfully, ExpectedResult);
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
	public void ExistingInvalidProjectType(String phoneOrEmail, String OTP, String expectedURL, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
	public void ExistingInvalidProjectTitle(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

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
		
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		
		scrollPageDown();
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

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

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
	public void ExistingInvalidFieldName(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

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
		ProjectPage.clickOnEnterItem();
	//	ProjectPage.clickOnFieldTypeDropDown();
	//	ProjectPage.clickOnPhoneNumberButton();
	//	ProjectPage.clickOnContinuousLocationTracking();
		
	//	scrollPageDown();
	//	ProjectPage.enterFrequency(EnterFrequency);
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
	public void ExistingInvalidFrequency(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
		ProjectPage.clickOnFieldTypeDropDown();
		ProjectPage.clickOnPhoneNumberButton();
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

		loginAgency.login(phoneOrEmail, OTP, expectedURL);

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
		
		scrollPageDown();
		ProjectPage.clickOnProjectTypeButton();
		ProjectPage.SelectNewProjectType();
		ProjectPage.clickOnHotspotButton();
		
		scrollPageDown();
		ProjectPage.clickOnProjectTypeNextButton();
		
		ProjectPage.enterProjectTitle(ProjectTitle);
		ProjectPage.enterProjectDescription(ProjectDescription);
		ProjectPage.enterProjectCode(ProjectCode);
		
		scrollPageDown();
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
