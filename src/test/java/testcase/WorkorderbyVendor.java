package testcase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import org.testng.annotations.Listeners;
import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class WorkorderbyVendor extends BaseTest {
	CreateworkorderPage WorkorderPage;
	Login agencyLogin;
	CreateProjectPage ProjectPage;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Workorder_by_Vendor(String PhoneEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedToastmessage) throws InterruptedException, IOException {

		WorkorderPage = new CreateworkorderPage(driver);
		agencyLogin = new Login();

		agencyLogin.login(PhoneEmail, OTP, expectedURL);

		WorkorderPage.clickOnWorkorderButton();

		WorkorderPage.clickOnCreateWorkorderButton();

		WorkorderPage.NavigateTodialogBox();

		WorkorderPage.clickOnSelectProjectVendor();

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

		WorkorderPage.clickOnAddVendorBtn();

		WorkorderPage.clickOnSelectVendor();

		WorkorderPage.clickOnSeeSummaryButton();

		WorkorderPage.clickOnSubmitforApprovalButton();

		String actualSuccessmessage = WorkorderPage.getToastmessage();
		softAssert.assertEquals(actualSuccessmessage, expectedToastmessage);

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
	public void Workorder_Quotes(String PhoneEmail, String OTP, String expectedURL, String Date, String Title,
			String expectedToastWorkOrdermessage) throws InterruptedException, IOException {

		agencyLogin = new Login();

		agencyLogin.login(PhoneEmail, OTP, expectedURL);

		WorkorderPage = new CreateworkorderPage(driver);

		ProjectPage = new CreateProjectPage(driver);

		ProjectPage.clickOnProjectTabButton();

		WorkorderPage.clickOnDesiredProject();

		WorkorderPage.clickOnVendorViewTab();

		WorkorderPage.clickOnVendorQuotes();

		WorkorderPage.clickOnCreateWorkOrder();

		WorkorderPage.NavigateTodialogBox();

		WorkorderPage.clickOnSelectProjectVendor();

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

		WorkorderPage.clickOnAddVendorBtn();

		WorkorderPage.clickOnSelectVendor();

		WorkorderPage.clickOnSeeSummaryButton();

		WorkorderPage.clickOnSubmitforApprovalButton();

		String actualSuccessmessage = WorkorderPage.getToastWorkOrdermessage();
		softAssert.assertEquals(actualSuccessmessage, expectedToastWorkOrdermessage);

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
