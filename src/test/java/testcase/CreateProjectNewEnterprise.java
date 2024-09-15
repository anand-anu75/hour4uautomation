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

public class CreateProjectNewEnterprise extends BaseTest {

	Login loginAgency = new Login();

//Create Project Successfully for New Enterprise

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void CreateNewProjectEnterprise(String phoneOrEmail, String OTP, String expectedURL, String Name,
			String Mobile, String Email, String Address, String ProjectTitle, String ProjectDescription,
			String ProjectCode, String LinkTitle, String LinkURL, String EnterMetrics, String EnterQuantity,
			String FieldName, String EnterFrequency, String EnterRadius, String EnterItem, String EnterDescription,
			String EnterRates, String EnterQty, String EnterDays, String PaymentTerms, String TermsAndConditions,
			String ExpectedResult) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		CreateProjectPage ProjectPage = new CreateProjectPage(driver);

		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnProjectTabButton();
		// ProjectPage.clickOnErrorMessage();
		ProjectPage.clickOnCreateProjectButton();
		// ProjectPage.clickOnSelfClientButton();
		ProjectPage.clickOnNewClient();
		ProjectPage.enterName(Name);
		ProjectPage.enterMobile(Mobile);
		ProjectPage.enterEmail(Email);
		ProjectPage.enterAddress(Address);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,800)");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		ProjectPage.clickOnCreateEnterprise();
		Thread.sleep(2000);
		ProjectPage.clickOnNext1Button();
		Thread.sleep(2000);
		ProjectPage.clickOnProjectTypeButton();
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
		ProjectPage.ClickOnAddAditionalItems();
		ProjectPage.ClickOnQuoteDate();
		ProjectPage.SelectValidDate();
		ProjectPage.enterPaymentTerms(PaymentTerms);
		ProjectPage.enterTermsAndConditions(TermsAndConditions);
		ProjectPage.clickOnReviewProject();
		ProjectPage.clickOnSaveProject();

		String ProjectEnterpriseCreatedSuccesfully = ProjectPage.EnterpriseProjectCreatedSuccesfully();
		softAssert.assertEquals(ProjectEnterpriseCreatedSuccesfully, ExpectedResult);
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
