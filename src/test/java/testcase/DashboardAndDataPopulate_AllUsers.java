package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.DashboardPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class DashboardAndDataPopulate_AllUsers extends BaseTest {

	Login loginAgency = new Login();
	DashboardPage dashboard;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Select Data Range Button")
	public void verifySelectDateRange(String phoneOrEmail, String OTP, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		dashboard = new DashboardPage(driver);

		// Login to application
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		// Fetch the work order count
		String workorderCount = dashboard.get_WorkOrderCount();

		// Click on select date range
		dashboard.clickOnSelectDataRange();

		// Select Last 7 days option
		dashboard.selectLast7DaysOption();

		// Fetch the work order count after selecting Last 7 days option
		String newWorkorderCount = dashboard.get_WorkOrderCount();

		// Verify the work order count
		boolean workorderCountCheck = dashboard.verifyWorkorderCount(workorderCount, newWorkorderCount);

		try {
			softAssert.assertTrue(workorderCountCheck);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;

		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Status vise Filter")
	public void verifyStatusViseFilter(String phoneOrEmail, String OTP, String expectedURL, String dropdownOption,
			String status) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		dashboard = new DashboardPage(driver);

		// Login to application
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		// Click on dash board label
		dashboard.clickOnDashboardLabel();

		// Scroll up to page end
		dashboard.scrollToEndOfPage();

		// click on pagination option
		dashboard.clickOnPaginationOption();

		// Select 500 pagination option
		dashboard.select500Option();

		// Scroll to page start
		dashboard.scrollToPageStart();

		// Click on status drop down
		dashboard.clickOnStatusFilter();

		// Select option
		dashboard.selectDropdownOption(dropdownOption);

		// Verify the status
		boolean statusValue = dashboard.verifyStatus(status);

		try {
			softAssert.assertTrue(statusValue);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify City vise Filter")
	public void verifyCityViseFilter(String phoneOrEmail, String OTP, String expectedURL, String dropdownOption,
			String city) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		dashboard = new DashboardPage(driver);

		// Login to application
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		// Click on city filter
		dashboard.clickOnCityFilter();

		// Select City
		dashboard.selectCity(dropdownOption);

		// Verify the city record shown on dashboard
		boolean cityValue = dashboard.verifyCity(city);

		try {
			softAssert.assertTrue(cityValue);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Total Number of Workorders")
	public void verifyTotalNumberOfWorkorders(String phoneOrEmail, String OTP, String expectedURL,
			String workOrderCount) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		dashboard = new DashboardPage(driver);

		// Login to application
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		// Fetch the work order count
		String workorderCount = dashboard.get_WorkOrderCount();

		try {
			softAssert.assertEquals(workorderCount, workorderCount);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Total Fulfilment Ratio")
	public void verifyTotalFulfilmentRatio(String phoneOrEmail, String OTP, String expectedURL, String fulfilmentValue)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		dashboard = new DashboardPage(driver);

		// Login to application
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		// Fetch the work order count
		String fulfilment = dashboard.get_FulfilmentCount();

		try {
			softAssert.assertEquals(fulfilment, fulfilmentValue);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Completed tasks")
	public void verifyCompletedTasks(String phoneOrEmail, String OTP, String expectedURL, String completedTaskCount)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		dashboard = new DashboardPage(driver);

		// Login to application
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		// Fetch the work order count
		String completedTask = dashboard.get_CompletedTaskCount();

		try {
			softAssert.assertEquals(completedTask, completedTaskCount);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Items Per Page DropDown")
	public void verifyItemsPerPageDropDown(String phoneOrEmail, String OTP, String expectedURL, String paginationOption)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		dashboard = new DashboardPage(driver);

		// Login to application
		loginAgency.login(phoneOrEmail, OTP, expectedURL);

		// Click on dash board label
		dashboard.clickOnDashboardLabel();

		// Scroll up to page end
		dashboard.scrollToEndOfPage();

		// click on pagination option
		dashboard.clickOnPaginationOption();

		// Select pagination option
		dashboard.selectPaginatioOption(paginationOption);

		// Fetch the work order count
		int totalRecordOnPage = dashboard.get_TotalRecordsOnPage();
		String totalRecordOnPageString = Integer.toString(totalRecordOnPage);

		try {
			softAssert.assertEquals(totalRecordOnPageString, paginationOption);
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
