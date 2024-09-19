package testcase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AssignProjectVendorAgencyPage;
import pages.CreateProjectPage;
import base.BaseTest;
import utilities.ReadXLData;

public class AssignProjectVendorAgency extends BaseTest {

	AssignProjectVendorAgencyPage AssignProjectVendor;
	Login loginObject;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void AssignProjectVendorData(String phoneOrEmail, String OTP, String expectedURL, String ExpectedResult)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		AssignProjectVendor = new AssignProjectVendorAgencyPage(driver);
		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

		ProjectPage.clickOnProjectTabButton();
		
		AssignProjectVendor.SelectCreatedProject();
		AssignProjectVendor.ClickOnAssignVendor();
		
		AssignProjectVendor.clickOn_DropDown();
		
		AssignProjectVendor.SelectVendorToAssignProject();
		AssignProjectVendor.ClickOnAssignVendorButton();
		AssignProjectVendor.SelectedVendorAssignedSuccessfully();

		String VendorAssignedSuccessfully = AssignProjectVendor.SelectedVendorAssignedSuccessfully();
		softAssert.assertEquals(VendorAssignedSuccessfully, ExpectedResult);
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
	public void CreateProjectAssignVendor(String phoneOrEmail, String OTP, String expectedURL, String ProjectTitle,
			String ProjectDescription, String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics,
			String EnterQuantity, String CustomFieldName, String ABCD, String FieldName, String EnterFrequency,
			String EnterRadius, String EnterItem, String EnterDescription, String EnterRates, String EnterQty,
			String EnterDays, String PaymentTerms, String TermsAndConditions, String ExpectedResult,
			String ExpectedMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		AssignProjectVendor = new AssignProjectVendorAgencyPage(driver);

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
		
		ProjectPage.ClickOnEnterEndDate();
		ProjectPage.clickOnSelectEndDate();
		
		// Scroll Window
		scrollPageDown();
		
		ProjectPage.ClickOnAddCustomField();
		ProjectPage.enterCustomFieldName(CustomFieldName);
		ProjectPage.SelectCustomFieldType();
		ProjectPage.SelectCustomTextArea();
		ProjectPage.ClickOnAddField();
		ProjectPage.enterCustomTextArea(ABCD);
		ProjectPage.clickOnSelectLocationButton();
		ProjectPage.clickOnSelectLocationDelhiButton();
		ProjectPage.clickOnAddTrackingButton();
		
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
		ProjectPage.ClickOnAddAditionalItems();
		ProjectPage.ClickOnQuoteDate();
		ProjectPage.SelectValidDate();
		ProjectPage.enterPaymentTerms(PaymentTerms);
		ProjectPage.enterTermsAndConditions(TermsAndConditions);
		ProjectPage.clickOnReviewProject();
		ProjectPage.clickOnSaveProject();
		ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();

		ProjectPage.clickOnProjectTabButton();
		
		AssignProjectVendor.SelectCreatedProject();
		AssignProjectVendor.ClickOnAssignVendor();
		
		AssignProjectVendor.clickOn_DropDown();
		AssignProjectVendor.SelectVendorToAssignProject();
		AssignProjectVendor.ClickOnAssignVendorButton();
		AssignProjectVendor.SelectedVendorAssignedSuccessfully();

		String VendorAssignedSuccessfully = AssignProjectVendor.SelectedVendorAssignedSuccessfully();

		try {
			softAssert.assertEquals(VendorAssignedSuccessfully, ExpectedMessage);
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
