package testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.AddChampsWorkOrderVendor;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class AddChampsWorkOrderVendorTest extends BaseTest {

	// Declaration of page object for AddChampsWorkOrderVendor
	private AddChampsWorkOrderVendor addChampsWorkOrderVendor;

	// Test method for adding a Champ Work Order for a Vendor
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_WorkOrder_Vendor(String Email, String Password, String Date, String Title,
			String expectedSuccessMessage) {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Initialize the AddChampsWorkOrderVendor page object
		addChampsWorkOrderVendor = new AddChampsWorkOrderVendor(driver);

		// Step 1: Enter email, password and click the login button
		addChampsWorkOrderVendor.enterEmail(Email);
		addChampsWorkOrderVendor.enterPassword(Password);
		addChampsWorkOrderVendor.clickLoginButton();

		// Step 2: Navigate to work order section
		addChampsWorkOrderVendor.clickOnWorkorderButton();
		addChampsWorkOrderVendor.clickOnCreateWorkorderButton();
		addChampsWorkOrderVendor.NavigateTodialogBox();

		// Step 3: Select the project
		addChampsWorkOrderVendor.clickOnSelectProjectButton();

		// Step 4: Add necessary details for the work order
		addChampsWorkOrderVendor.clickOnAddDetailsButton();
		addChampsWorkOrderVendor.clickOnSearchAddressButton();
		addChampsWorkOrderVendor.enterDate(Date);

		// Step 5: Select start time
		addChampsWorkOrderVendor.clickOnStartTimeButton();
		addChampsWorkOrderVendor.clickOnSelectStarttimeButton();

		// Close any open dialog or dropdown using ESC key
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();

		// Step 6: Select end time
		addChampsWorkOrderVendor.clickOnEndTimeButton();
		addChampsWorkOrderVendor.clickOnSelectEndtimeButton();

		// Step 7: Add billing and title details
		addChampsWorkOrderVendor.clickOnAddBillingButton();
		addChampsWorkOrderVendor.clickOnAddTitleButton();
		addChampsWorkOrderVendor.enterTitle(Title);

		// Step 8: View summary and submit for approval
		addChampsWorkOrderVendor.clickOnSeeSummaryButton();
		addChampsWorkOrderVendor.clickOnSubmitforApprovalButton();

		// Step 9: Navigate to dashboard, more options and add champs
		addChampsWorkOrderVendor.clickOnAddDashBoard();
		addChampsWorkOrderVendor.clickMoreOptions();
		addChampsWorkOrderVendor.clickAddChamps();

		// Step 10: Select a champ and send request
		addChampsWorkOrderVendor.clickSelectChamp();
		addChampsWorkOrderVendor.clickSendReq();

		// Step 11: Verify success message using soft assertion
		String actualSuccessMessage = addChampsWorkOrderVendor.getSuccessMessage();

		// Assert all to validate the soft assertions
		try {
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
}
