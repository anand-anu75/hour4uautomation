package testcase;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.AddChampsWorkOrder;
import pages.CreateworkorderPage;
import pages.DashboardAndDataPopulatePage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class AddChampsWorkOrderTest extends BaseTest {

	private AddChampsWorkOrder addChampsWorkorder;
	CreateWorkorder createWorkOrder;

	Login loginObject = new Login();

	/**
	 * Test to add a Champ via Dashboard. This test depends on successful login and
	 * uses data from an Excel sheet.
	 * 
	 * @param expectedSuccessMessage The expected success message after adding the
	 *                               Champ.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_via_dashBoard(String phoneOrEmail, String OTP, String expectedURL, String date, String title,
			String expectedSuccessmessageWorkorder, String expectedSuccessMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		createWorkOrder = new CreateWorkorder();

		// Create new Workorder
		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title,
				expectedSuccessmessageWorkorder);

		// Click on Dashboard
		DashboardAndDataPopulatePage dashboard = new DashboardAndDataPopulatePage(driver);
		dashboard.clickOnDashboardMenu();

		addChampsWorkorder = new AddChampsWorkOrder(driver);

		addChampsWorkorder.clickMoreOptions(); // Click on More Options
		addChampsWorkorder.clickAddChamps(); // Click to Add Champs

		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assert success message
		String actualSuccessMessage = addChampsWorkorder.getSuccessMessage();

		try {
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	/**
	 * Test to add a Champ via Work Order. This test depends on successful login and
	 * uses data from an Excel sheet.
	 * 
	 * @param expectedSuccessMessage The expected success message after adding the
	 *                               Champ.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_via_workOrder(String phoneOrEmail, String OTP, String expectedURL, String date, String title,
			String expectedSuccessmessageWorkorder, String expectedSuccessMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		createWorkOrder = new CreateWorkorder();

		// Create new Workorder
		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title,
				expectedSuccessmessageWorkorder);

		addChampsWorkorder = new AddChampsWorkOrder(driver);

		addChampsWorkorder.clickDesiredWorkOrder(); // Click on the desired Work Order
		addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assert success message
		String actualSuccessMessage = addChampsWorkorder.getSuccessMessage();

		try {
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	/**
	 * Test to add a Champ via View Task. This test depends on successful login and
	 * uses data from an Excel sheet.
	 * 
	 * @param expectedSuccessMessage The expected success message after adding the
	 *                               Champ.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_via_ViewTask(String phoneOrEmail, String OTP, String expectedURL, String date, String title,
			String expectedSuccessmessageWorkorder, String expectedSuccessMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		createWorkOrder = new CreateWorkorder();

		// Create new Workorder
		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title,
				expectedSuccessmessageWorkorder);

		addChampsWorkorder = new AddChampsWorkOrder(driver);

		addChampsWorkorder.clickViewTask_btn(); // Click on View Task button

		// Switch to the newly opened window
		switchToNewTab();

		addChampsWorkorder.clickMoreOptions(); // Click on More Options
		addChampsWorkorder.clickAddChamps(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assert success message
		String actualSuccessMessage = addChampsWorkorder.getSuccessMessage();

		try {
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	/**
	 * Test to add a Champ via Dashboard - Alternative Flow. This test depends on
	 * successful login and uses data from an Excel sheet.
	 * 
	 * @param expectedSuccessMessage The expected success message after adding the
	 *                               Champ.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_via_ViewJobSeekerSch(String phoneOrEmail, String OTP, String expectedURL, String date,
			String title, String expectedSuccessmessageWorkorder, String expectedSuccessMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		createWorkOrder = new CreateWorkorder();

		// Create new Workorder
		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title,
				expectedSuccessmessageWorkorder);

		addChampsWorkorder = new AddChampsWorkOrder(driver);

		addChampsWorkorder.clickMoreOptions(); // Click on More Options
		addChampsWorkorder.clickJobSeeker1(); // Click on the first Job Seeker
		addChampsWorkorder.clickMoreOptions(); // Click on More Options again
		addChampsWorkorder.clickAddChamps(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assert success message
		String actualSuccessMessage = addChampsWorkorder.getSuccessMessage();

		try {
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	/**
	 * Test for error scenario when adding a Champ via Dashboard. This test depends
	 * on successful login and uses data from an Excel sheet.
	 * 
	 * @param expectedErrorMessage The expected error message after attempting to
	 *                             add the Champ.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_via_dashBoard_Error(String phoneOrEmail, String OTP, String expectedURL, String date,
			String title, String expectedSuccessmessageWorkorder, String expectedErrorMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		createWorkOrder = new CreateWorkorder();

		// Create new Workorder
		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title,
				expectedSuccessmessageWorkorder);

		addChampsWorkorder = new AddChampsWorkOrder(driver);

		// Adding champ to workorder
		addChampsWorkorder.navigateToWorkOrderMenu(); // Navigate to Work order menu
		addChampsWorkorder.clickDesiredWorkOrder();
		addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assigning same champ to workorder
		addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assert error message
		String actualErrorMessage = addChampsWorkorder.getErrorMessage();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	/**
	 * Test for error scenario when adding a Champ via Work Order. This test depends
	 * on successful login and uses data from an Excel sheet.
	 * 
	 * @param expectedErrorMessage The expected error message after attempting to
	 *                             add the Champ.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_via_workOrder_Error(String phoneOrEmail, String OTP, String expectedURL, String date,
			String title, String expectedSuccessmessageWorkorder, String expectedErrorMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		createWorkOrder = new CreateWorkorder();

		// Create new Workorder
		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title,
				expectedSuccessmessageWorkorder);

		addChampsWorkorder = new AddChampsWorkOrder(driver);

		// Adding champ to workorder
		addChampsWorkorder.navigateToWorkOrderMenu(); // Navigate to Work order menu
		addChampsWorkorder.clickDesiredWorkOrder(); // Select
		addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Adding same champ to workorder
		addChampsWorkorder.navigateToWorkOrderMenu(); // Navigate to Work order menu
		addChampsWorkorder.clickDesiredWorkOrder(); // Click on the desired Work Order
		addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assert error message
		String actualErrorMessage = addChampsWorkorder.getErrorMessage();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	/**
	 * Test for error scenario when adding a Champ via View Task. This test depends
	 * on successful login and uses data from an Excel sheet.
	 * 
	 * @param expectedErrorMessage The expected error message after attempting to
	 *                             add the Champ.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_via_ViewTask_Error(String phoneOrEmail, String OTP, String expectedURL, String date,
			String title, String expectedSuccessmessageWorkorder, String expectedErrorMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		createWorkOrder = new CreateWorkorder();

		// Create new Workorder
		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title,
				expectedSuccessmessageWorkorder);

		addChampsWorkorder = new AddChampsWorkOrder(driver);

		// Adding champ to workorder
		addChampsWorkorder.navigateToWorkOrderMenu(); // Navigate to Work order menu
		addChampsWorkorder.clickDesiredWorkOrder();
		addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Adding same champ to workorder
		addChampsWorkorder.navigateToWorkOrderMenu(); // Navigate to workorder menu
		addChampsWorkorder.clickViewTask_btn(); // Click on View Task button

		// Switch to the newly opened window
		switchToNewTab();

		addChampsWorkorder.clickMoreOptions(); // Click on More Options
		addChampsWorkorder.clickAddChamps(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assert error message
		String actualErrorMessage = addChampsWorkorder.getErrorMessage();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
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
	public void addChamp_via_ViewJobSeekerError(String phoneOrEmail, String OTP, String expectedURL, String date,
			String title, String expectedSuccessmessageWorkorder, String expectedErrorMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		createWorkOrder = new CreateWorkorder();

		// Create new Workorder
		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title,
				expectedSuccessmessageWorkorder);

		addChampsWorkorder = new AddChampsWorkOrder(driver);

		// Adding champ to workorder
		addChampsWorkorder.navigateToWorkOrderMenu(); // Navigate to Work order menu
		addChampsWorkorder.clickDesiredWorkOrder(); //Select the created workorder
		addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs
		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Adding same champ again to workorder
		addChampsWorkorder.navigateToWorkOrderMenu(); // Navigate to Work order menu
		addChampsWorkorder.clickMoreOptions(); // Click on More Options
		addChampsWorkorder.clickJobSeeker1(); // Click on the first Job Seeker

		addChampsWorkorder.clickMoreOptions(); // Click on More Options again
		addChampsWorkorder.clickAddChamps(); // Click to Add Champs

		addChampsWorkorder.clickSelectChamp(); // Select a Champ
		addChampsWorkorder.clickSendReq(); // Send the Request

		// Assert error message
		String actualErrorMessage = addChampsWorkorder.getErrorMessage();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
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
