package testcase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.AssignProjectVendorAgencyPage;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import utilities.ReadXLData;

public class WorkOrderApproval_Enterprise extends BaseTest {
	CreateProjectPage ProjectPage;
	Login loginAgency = new Login();;

	EnterpriseLogin enterpriseLogin = new EnterpriseLogin();

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void WorkOrderApprovalEnterprise(String ProjectTitle, String ProjectDescription, String ProjectCode,
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
		// ProjectPage.clickOnSelfClientButton();
		// ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		// ProjectPage.clickOnProjectTypeButton();
		ProjectPage.clickOnSelectProjectTypeButton();
//        Thread.sleep(2000);
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
//      ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
		Thread.sleep(2000);
		ProjectPage.ClickOnAssignAgency();
		ProjectPage.enterSearchAgency(SearchAgency);
		Thread.sleep(2000);
		ProjectPage.ClickOnAugustAgency();
		ProjectPage.clickOnSearchAssignAgency();
		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.enterAgencyEmail(EnterAgencyEmail);
		ProjectPage.clickOnSignInUsingOTP();
		ProjectPage.clickOnGetOTP();
		ProjectPage.enterOTPforAgencyLogin(EnterOTP);
		ProjectPage.clickOnLoginButton();
	//	ProjectPage.clickOnErrorMessage();
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
		Thread.sleep(2000);

		WorkorderPage.clickOnAddBillingButton();

		WorkorderPage.clickOnAddTitleButton();

		WorkorderPage.enterTitle(Title);

		WorkorderPage.clickOnSeeSummaryButton();

		WorkorderPage.clickOnSubmitforApprovalButton();
		// ProjectPage.clickOnErrorMessage();

		ProjectPage.clickOnProfileButton();
		ProjectPage.clickOnLogoutButton();
		ProjectPage.clickOnErrorMessage();
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



@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
public void InvalidFieldNameWorkorder(String phoneOrEmail, String enterPassword, String ProjectTitle,
		String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
		String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
		throws InterruptedException, IOException {

	softAssert = new SoftAssert();
	assertionMessage = new ThreadLocal<>();
	enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, enterPassword);
	ProjectPage = new CreateProjectPage(driver);

	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnProjectTabButton();
	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnCreateProjectButton();
	// ProjectPage.clickOnSelfClientButton();
	// ProjectPage.clickOnNext1Button();
	Thread.sleep(1000);
	// ProjectPage.clickOnProjectTypeButton();
	ProjectPage.clickOnSelectProjectTypeButton();
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
	ProjectPage.clickOnSelectStartDate();
	ProjectPage.clickOnEndDateButton();
	ProjectPage.clickOnSelectEndDate();
	ProjectPage.clickOnSelectLocationButton();
	Thread.sleep(1000);
	ProjectPage.clickOnSelectLocationDelhiButton();
	ProjectPage.clickOnAddTrackingButton();
	ProjectPage.enterFieldName(FieldName);
	ProjectPage.pressBackSpaceButton();
	// ProjectPage.clickOnFieldTypeDropDown();
	// ProjectPage.clickOnPhoneNumberButton();
	ProjectPage.clickOnContinuousLocationTracking();
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


//// Test for Invalid Field Type

/*@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
public void EnterpriseInvalidFieldType(String phoneOrEmail, String enterPassword, String ProjectTitle, String ProjectDescription, String ProjectCode,
		String LinkTitle, String LinkURL, String EnterMetrics, String EnterQuantity, String FieldName,
		String ExpectedResult) throws InterruptedException, IOException {
	
	enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, enterPassword);
	ProjectPage = new CreateProjectPage(driver);

	 ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnProjectTabButton();
	 ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnCreateProjectButton();
	ProjectPage.clickOnSelfClientButton();
	ProjectPage.clickOnNext1Button();
	Thread.sleep(1000);
	ProjectPage.clickOnProjectTypeButton();
	ProjectPage.clickOnSelectProjectTypeButton();
	ProjectPage.clickOnHotspotButton();
	ProjectPage.clickOnProjectTypeNextButton();
	 ProjectPage.clickOnProjectDetailsButton();
	ProjectPage.enterProjectTitle(ProjectTitle);
	ProjectPage.enterProjectDescription(ProjectDescription);
	ProjectPage.enterProjectCode(ProjectCode);
	ProjectPage.enterLinkTitle(LinkTitle);
	ProjectPage.enterURL(LinkURL);
	ProjectPage.enterMetrics(EnterMetrics);
	ProjectPage.enterQuantity(EnterQuantity);
	ProjectPage.clickOnStartDateButton();
	ProjectPage.clickOnSelectStartDate();
    ProjectPage.clickOnEndDateButton();
	ProjectPage.clickOnSelectEndDate();
	ProjectPage.clickOnSelectLocationButton();
	Thread.sleep(1000);
	ProjectPage.clickOnSelectLocationDelhiButton();
	ProjectPage.clickOnAddTrackingButton();
	ProjectPage.enterFieldName(FieldName);
	ProjectPage.clickOnFieldTypeDropDown();
    Perform actions to get successfull error message
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
	}
}

*/

@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
public void InvalidFrequencyWorkorder(String phoneOrEmail, String enterPassword, String ProjectTitle,
		String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
		String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
		throws InterruptedException, IOException {

	softAssert = new SoftAssert();
	assertionMessage = new ThreadLocal<>();
	enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, enterPassword);

	ProjectPage = new CreateProjectPage(driver);

	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnProjectTabButton();
	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnCreateProjectButton();
//	ProjectPage.clickOnSelfClientButton();
//	ProjectPage.clickOnNext1Button();
	Thread.sleep(1000);
//	ProjectPage.clickOnProjectTypeButton();
	ProjectPage.clickOnSelectProjectTypeButton();
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
	ProjectPage.clickOnSelectStartDate();
	ProjectPage.clickOnEndDateButton();
	ProjectPage.clickOnSelectEndDate();
	ProjectPage.clickOnSelectLocationButton();
	Thread.sleep(1000);
	ProjectPage.clickOnSelectLocationDelhiButton();
	ProjectPage.clickOnAddTrackingButton();
	ProjectPage.enterFieldName(FieldName);
	// ProjectPage.clickOnFieldTypeDropDown();
	// ProjectPage.clickOnPhoneNumberButton();
	ProjectPage.clickOnContinuousLocationTracking();
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

@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
public void InvalidRadiusWorkorder(String phoneOrEmail, String enterPassword, String ProjectTitle,
		String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
		String EnterQuantity, String FieldName, String EnterFrequency, String EnterRadius, String ExpectedResult)
		throws InterruptedException, IOException {

	softAssert = new SoftAssert();
	assertionMessage = new ThreadLocal<>();
	enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, enterPassword);

	ProjectPage = new CreateProjectPage(driver);

	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnProjectTabButton();
	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnCreateProjectButton();
//	ProjectPage.clickOnSelfClientButton();
//	ProjectPage.clickOnNext1Button();
	Thread.sleep(1000);
//	ProjectPage.clickOnProjectTypeButton();
	ProjectPage.clickOnSelectProjectTypeButton();
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
	ProjectPage.clickOnSelectStartDate();
	ProjectPage.clickOnEndDateButton();
	ProjectPage.clickOnSelectEndDate();
	ProjectPage.clickOnSelectLocationButton();
	Thread.sleep(1000);
	ProjectPage.clickOnSelectLocationDelhiButton();
	ProjectPage.clickOnAddTrackingButton();
	ProjectPage.enterFieldName(FieldName);
	// ProjectPage.clickOnFieldTypeDropDown();
	// ProjectPage.clickOnPhoneNumberButton();
	ProjectPage.clickOnContinuousLocationTracking();
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


@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
public void InvalidQuoteWorkorder(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
		String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
		String EnterQuantity, String CustomFieldName, String ABCD, String FieldName, String EnterFrequency,
		String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
		String EnterDays, String PaymentTerms, String TermsAndConditions, String ExpectedResult) throws InterruptedException, IOException {

	softAssert = new SoftAssert();
	assertionMessage = new ThreadLocal<>();

	
	loginAgency.login(phoneOrEmail, OTP, expectedURL);

	CreateProjectPage ProjectPage = new CreateProjectPage(driver);


	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnProjectTabButton();
	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnCreateProjectButton();
 //   ProjectPage.clickOnSelfClientButton();
	ProjectPage.clickOnExistingEnterprise();
	ProjectPage.SelectDropdownEnterprise();
	 Thread.sleep(2000);
	ProjectPage.SelectOptionEnterprise();
	scrollPageDown();
	 Thread.sleep(2000);
	ProjectPage.clickOnNext1Button();
	// Thread.sleep(2000);
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
	// ProjectPage.clickOnEndDateButton();
	ProjectPage.ClickOnEnterEndDate();
	ProjectPage.clickOnSelectEndDate();
	// Scroll Window
	scrollPageDown();
	Thread.sleep(1000);
	ProjectPage.ClickOnAddCustomField();
	ProjectPage.enterCustomFieldName(CustomFieldName);
	ProjectPage.SelectCustomFieldType();
	ProjectPage.SelectCustomTextArea();
	ProjectPage.ClickOnAddField();
	ProjectPage.enterCustomTextArea(ABCD);
	ProjectPage.clickOnSelectLocationButton();
	ProjectPage.clickOnSelectLocationDelhiButton();
	ProjectPage.clickOnAddTrackingButton();
	// ProjectPage.enterFieldName(FieldName);
	// ProjectPage.clickOnFieldTypeDropDown();
	// ProjectPage.clickOnPhoneNumberButton();
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
//	ProjectPage.ClickOnQuoteDate();
	//ProjectPage.SelectValidDate();
	ProjectPage.enterPaymentTerms(PaymentTerms);
	ProjectPage.enterTermsAndConditions(TermsAndConditions);
	ProjectPage.clickOnReviewProject();
//	ProjectPage.clickOnSaveProject();
	
	String actualSuccessmessage = ProjectPage.SelectValidQuoteMessage();
	softAssert.assertEquals(actualSuccessmessage, ExpectedResult);

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

@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
public void InvalidTermsWorkorder(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
		String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
		String EnterQuantity, String CustomFieldName, String ABCD, String FieldName, String EnterFrequency,
		String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
		String EnterDays, String PaymentTerms, String TermsAndConditions, String ExpectedtermsResult) throws InterruptedException, IOException {

	softAssert = new SoftAssert();
	assertionMessage = new ThreadLocal<>();

	
	loginAgency.login(phoneOrEmail, OTP, expectedURL);

	CreateProjectPage ProjectPage = new CreateProjectPage(driver);


	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnProjectTabButton();
	// ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnCreateProjectButton();
 //   ProjectPage.clickOnSelfClientButton();
	ProjectPage.clickOnExistingEnterprise();
	ProjectPage.SelectDropdownEnterprise();
	 Thread.sleep(2000);
	ProjectPage.SelectOptionEnterprise();
	scrollPageDown();
	 Thread.sleep(2000);
	ProjectPage.clickOnNext1Button();
	// Thread.sleep(2000);
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
	// ProjectPage.clickOnEndDateButton();
	ProjectPage.ClickOnEnterEndDate();
	ProjectPage.clickOnSelectEndDate();
	// Scroll Window
	scrollPageDown();
	Thread.sleep(1000);
	ProjectPage.ClickOnAddCustomField();
	ProjectPage.enterCustomFieldName(CustomFieldName);
	ProjectPage.SelectCustomFieldType();
	ProjectPage.SelectCustomTextArea();
	ProjectPage.ClickOnAddField();
	ProjectPage.enterCustomTextArea(ABCD);
	ProjectPage.clickOnSelectLocationButton();
	ProjectPage.clickOnSelectLocationDelhiButton();
	ProjectPage.clickOnAddTrackingButton();
	// ProjectPage.enterFieldName(FieldName);
	// ProjectPage.clickOnFieldTypeDropDown();
	// ProjectPage.clickOnPhoneNumberButton();
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
	//ProjectPage.enterPaymentTerms(PaymentTerms);
	ProjectPage.enterTermsAndConditions(TermsAndConditions);
	ProjectPage.clickOnReviewProject();
	//ProjectPage.clickOnSaveProject();
	
	String actualSuccessmessage = ProjectPage.SelectValidtermMessage();
	softAssert.assertEquals(actualSuccessmessage, ExpectedtermsResult);

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

@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
public void InvalidLocationWorkorder(String ProjectTitle, String ProjectDescription, String ProjectCode,
		String LinkTitle, String LinkURL, String EnterMetrics, String EnterQuantity, String StartDate,
		String EndDate, String FieldName, String EnterFrequency, String EnterRadius, String EnterItem,
		String EnterDescription, String EnterRates, String EnterQty, String EnterDays, String ExpectedResult,
		String SearchAgency, String EnterAgencyEmail, String EnterOTP, String Date, String Title,
		String expectedSuccessmessage, String phoneOrEmail, String EnterPassword, String expectedLocationErrorMessage)
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
	// ProjectPage.clickOnSelfClientButton();
	// ProjectPage.clickOnNext1Button();
	Thread.sleep(2000);
	// ProjectPage.clickOnProjectTypeButton();
	ProjectPage.clickOnSelectProjectTypeButton();
//    Thread.sleep(2000);
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
//  ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
	Thread.sleep(2000);
	ProjectPage.ClickOnAssignAgency();
	ProjectPage.enterSearchAgency(SearchAgency);
	Thread.sleep(2000);
	ProjectPage.ClickOnAugustAgency();
	ProjectPage.clickOnSearchAssignAgency();
	ProjectPage.clickOnProfileButton();
	ProjectPage.clickOnLogoutButton();
	ProjectPage.enterAgencyEmail(EnterAgencyEmail);
	ProjectPage.clickOnSignInUsingOTP();
	ProjectPage.clickOnGetOTP();
	ProjectPage.enterOTPforAgencyLogin(EnterOTP);
	ProjectPage.clickOnLoginButton();
//	ProjectPage.clickOnErrorMessage();
	ProjectPage.clickOnProjectTabButton();
	ProjectPage.clickOnAcceptProject();

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
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
		public void InvalidDateWorkorder(String ProjectTitle, String ProjectDescription, String ProjectCode,
				String LinkTitle, String LinkURL, String EnterMetrics, String EnterQuantity, String StartDate,
				String EndDate, String FieldName, String EnterFrequency, String EnterRadius, String EnterItem,
				String EnterDescription, String EnterRates, String EnterQty, String EnterDays, String ExpectedResult,
				String SearchAgency, String EnterAgencyEmail, String EnterOTP, String Date, String Title,
				String expectedSuccessmessage, String phoneOrEmail, String EnterPassword, String expectedDateErrorMessage)
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
			// ProjectPage.clickOnSelfClientButton();
			// ProjectPage.clickOnNext1Button();
			Thread.sleep(2000);
			// ProjectPage.clickOnProjectTypeButton();
			ProjectPage.clickOnSelectProjectTypeButton();
//		    Thread.sleep(2000);
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
		//  ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
			Thread.sleep(2000);
			ProjectPage.ClickOnAssignAgency();
			ProjectPage.enterSearchAgency(SearchAgency);
			Thread.sleep(2000);
			ProjectPage.ClickOnAugustAgency();
			ProjectPage.clickOnSearchAssignAgency();
			ProjectPage.clickOnProfileButton();
			ProjectPage.clickOnLogoutButton();
			ProjectPage.enterAgencyEmail(EnterAgencyEmail);
			ProjectPage.clickOnSignInUsingOTP();
			ProjectPage.clickOnGetOTP();
			ProjectPage.enterOTPforAgencyLogin(EnterOTP);
			ProjectPage.clickOnLoginButton();
//			ProjectPage.clickOnErrorMessage();
			ProjectPage.clickOnProjectTabButton();
			ProjectPage.clickOnAcceptProject();
			

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
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
		public void InvalidStarttimeWorkorder(String ProjectTitle, String ProjectDescription, String ProjectCode,
				String LinkTitle, String LinkURL, String EnterMetrics, String EnterQuantity, String StartDate,
				String EndDate, String FieldName, String EnterFrequency, String EnterRadius, String EnterItem,
				String EnterDescription, String EnterRates, String EnterQty, String EnterDays, String ExpectedResult,
				String SearchAgency, String EnterAgencyEmail, String EnterOTP, String Date, String Title,
				String expectedSuccessmessage, String phoneOrEmail, String EnterPassword, String expectedStarttimeErrorMessage)
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
			// ProjectPage.clickOnSelfClientButton();
			// ProjectPage.clickOnNext1Button();
			Thread.sleep(2000);
			// ProjectPage.clickOnProjectTypeButton();
			ProjectPage.clickOnSelectProjectTypeButton();
//		    Thread.sleep(2000);
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
		//  ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
			Thread.sleep(2000);
			ProjectPage.ClickOnAssignAgency();
			ProjectPage.enterSearchAgency(SearchAgency);
			Thread.sleep(2000);
			ProjectPage.ClickOnAugustAgency();
			ProjectPage.clickOnSearchAssignAgency();
			ProjectPage.clickOnProfileButton();
			ProjectPage.clickOnLogoutButton();
			ProjectPage.enterAgencyEmail(EnterAgencyEmail);
			ProjectPage.clickOnSignInUsingOTP();
			ProjectPage.clickOnGetOTP();
			ProjectPage.enterOTPforAgencyLogin(EnterOTP);
			ProjectPage.clickOnLoginButton();
//			ProjectPage.clickOnErrorMessage();
			ProjectPage.clickOnProjectTabButton();
			ProjectPage.clickOnAcceptProject();
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
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
		public void InvalidEndtimeWorkorder(String ProjectTitle, String ProjectDescription, String ProjectCode,
				String LinkTitle, String LinkURL, String EnterMetrics, String EnterQuantity, String StartDate,
				String EndDate, String FieldName, String EnterFrequency, String EnterRadius, String EnterItem,
				String EnterDescription, String EnterRates, String EnterQty, String EnterDays, String ExpectedResult,
				String SearchAgency, String EnterAgencyEmail, String EnterOTP, String Date, String Title,
				String expectedSuccessmessage, String phoneOrEmail, String EnterPassword, String expectedEndtimeErrorMessage)
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
			// ProjectPage.clickOnSelfClientButton();
			// ProjectPage.clickOnNext1Button();
			Thread.sleep(2000);
			// ProjectPage.clickOnProjectTypeButton();
			ProjectPage.clickOnSelectProjectTypeButton();
//		    Thread.sleep(2000);
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
		//  ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
			Thread.sleep(2000);
			ProjectPage.ClickOnAssignAgency();
			ProjectPage.enterSearchAgency(SearchAgency);
			Thread.sleep(2000);
			ProjectPage.ClickOnAugustAgency();
			ProjectPage.clickOnSearchAssignAgency();
			ProjectPage.clickOnProfileButton();
			ProjectPage.clickOnLogoutButton();
			ProjectPage.enterAgencyEmail(EnterAgencyEmail);
			ProjectPage.clickOnSignInUsingOTP();
			ProjectPage.clickOnGetOTP();
			ProjectPage.enterOTPforAgencyLogin(EnterOTP);
			ProjectPage.clickOnLoginButton();
//			ProjectPage.clickOnErrorMessage();
			ProjectPage.clickOnProjectTabButton();
			ProjectPage.clickOnAcceptProject();
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
}
