package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class CreateProjectEnterprise extends BaseTest {
	CreateProjectPage ProjectPage;

	EnterpriseLogin enterpriseLogin = new EnterpriseLogin();

	// Test for Creating Project Successfully

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateProjectEnterpriseData(String phoneOrEmail, String enterPassword, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String StartDate, String EndDate, String FieldName, String EnterFrequency,
			String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
			String EnterDays, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, enterPassword);

		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		
		
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		ProjectPage.clickOnProjectTypeNextButton();
		
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
		
		ProjectPage.clickOnContinuousLocationTracking();
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

	// Test for Selecting Invalid Project Type

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")

	public void EnterpriseImproperProjectType(String phoneOrEmail, String enterPassword, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, enterPassword);

		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		
		ProjectPage.clickOnProjectTypeNextButton();
		

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

	// Test for Invalid Project Description

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void EnterpriseInvalidProjectDesc(String phoneOrEmail, String enterPassword, String ProjectTitle,
			String ProjectDescription, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, enterPassword);
		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();

		
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		ProjectPage.clickOnProjectTypeNextButton();
		
		ProjectPage.enterProjectTitle(ProjectTitle);
		scrollPageDown();
		ProjectPage.enterProjectDescription(ProjectDescription);
		ProjectPage.clickOnSelectLocationButton();

		String ProperProjectDescription = ProjectPage.EnterProperProjectDescription();
		softAssert.assertEquals(ProperProjectDescription, ExpectedResult);
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

	// Test for Invalid Field Name

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void EnterpriseInvalidFieldName(String phoneOrEmail, String enterPassword, String ProjectTitle,
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
		
		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		ProjectPage.clickOnProjectTypeNextButton();
		
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
		
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		ProjectPage.pressBackSpaceButton();
		
		ProjectPage.clickOnContinuousLocationTracking();
		ProjectPage.enterFrequency(EnterFrequency);
		ProjectPage.enterRadius(EnterRadius);
		
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

	// Test for Invalid Field Type

/*
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
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
		
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		ProjectPage.clickOnFieldTypeDropDown();
		
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

	// Test for Invalid Frequency

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void EnterpriseInvalidFrequency(String phoneOrEmail, String enterPassword, String ProjectTitle,
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


		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		ProjectPage.clickOnProjectTypeNextButton();
		
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
		
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		
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

	// Test for Invalid Radius

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void EnterpriseInvalidRadius(String phoneOrEmail, String enterPassword, String ProjectTitle,
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


		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
		ProjectPage.clickOnProjectTypeNextButton();
	
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
		
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		ProjectPage.enterFieldName(FieldName);
		
		ProjectPage.clickOnContinuousLocationTracking();
		ProjectPage.enterFrequency(EnterFrequency);
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

	// Test for Invalid Project Title

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void EnterpriseInvalidProjectTitle(String phoneOrEmail, String enterPassword, String ProjectTitle,
			String ProjectDescription, String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		enterpriseLogin.loginDhruviEnterprise(phoneOrEmail, enterPassword);
		ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();



		ProjectPage.clickOnSelectProjectTypeButton();
		ProjectPage.clickOnHotspotButton();
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

}
