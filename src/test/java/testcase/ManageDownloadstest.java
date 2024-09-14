package testcase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.AddChampsWorkOrder;
import pages.CreateworkorderPage;
import pages.DashboardAndDataPopulatePage;
import pages.ManageDownloads;
import utilities.ReadXLData;

public class ManageDownloadstest extends BaseTest {
	ManageDownloads managedownloadtest;
	Login loginObject;

	static String actualURL;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Dashboard Page")
	public void verify_Download_Dashboard(String phoneOrEmail, String OTP, String expectedURL, String expectedMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Login with valid credentials
		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		// Download files
		managedownloadtest = new ManageDownloads(driver);
		managedownloadtest.deleteExistingFile();
		managedownloadtest.clickOnbtn_More();
		managedownloadtest.clickOnbtn_DownloadProofofwork();

		try {
			boolean value = managedownloadtest.checkFileDownload();
			softAssert.assertTrue(value);

			managedownloadtest.clickOnbtn_More();
			managedownloadtest.clickOnbtn_DownloadProofofworkPPT();
			String actualDownloadProofofworkPPT_Message = managedownloadtest.get_downloadProofofworkPPTSuccessMessage()
					+ "\n" + managedownloadtest.get_downloadProofofworkPPTToastMessage();

			softAssert.assertEquals(actualDownloadProofofworkPPT_Message, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Dashboard Page")
	public void verify_Download_ViewTask(String phoneOrEmail, String OTP, String expectedURL, String expectedMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		managedownloadtest = new ManageDownloads(driver);
		managedownloadtest.deleteExistingFile();

		managedownloadtest.clickOnLabel();
		// Scroll the page down
		scrollPageDown();

		managedownloadtest.clickOnbtn_ViewTasks();

		// Switch to new tab
		switchToNewTab();

		managedownloadtest.clickOn_Openmenutoexplore();
		managedownloadtest.clickOnbtn_DownloadProofofwork();

		try {
			boolean value = managedownloadtest.checkFileDownload();
			softAssert.assertTrue(value);

			managedownloadtest.clickOnbtn_More();
			managedownloadtest.clickOnbtn_DownloadProofofworkPPT();
			String actualDownloadProofofworkPPT_Message = managedownloadtest.get_downloadProofofworkPPTSuccessMessage()
					+ "\n" + managedownloadtest.get_downloadProofofworkPPTToastMessage();

			softAssert.assertEquals(actualDownloadProofofworkPPT_Message, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Workorders")
	public void verify_Download_Workorder(String phoneOrEmail, String OTP, String expectedURL, String date,
			String title, String expectedSuccessmessage, String expectedMessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

//		// Create Active workorder
//		CreateWorkorder createWorkOrder = new CreateWorkorder();
//		createWorkOrder.CreateworkorderPage(phoneOrEmail, OTP, expectedURL, date, title, expectedSuccessmessage);

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		// Download workorder
		managedownloadtest = new ManageDownloads(driver);
		managedownloadtest.deleteExistingFile();
		AddChampsWorkOrder createWorkOrder = new AddChampsWorkOrder(driver);
		managedownloadtest.clickOnLabel();
		scrollPageDown();
		createWorkOrder.clickDesiredWorkOrder();
		managedownloadtest.clickOn_Openmenutoexplore();
		managedownloadtest.clickOnbtn_DownloadProofofwork();

		try {
			boolean value = managedownloadtest.checkFileDownload();
			softAssert.assertTrue(value);

			managedownloadtest.clickOnbtn_More();
			managedownloadtest.clickOnbtn_DownloadProofofworkPPT();
			String actualDownloadProofofworkPPT_Message = managedownloadtest.get_downloadProofofworkPPTSuccessMessage()
					+ "\n" + managedownloadtest.get_downloadProofofworkPPTToastMessage();

			softAssert.assertEquals(actualDownloadProofofworkPPT_Message, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Dashboard Page")
	public void verify_Download_XLS(String phoneOrEmail, String OTP, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		managedownloadtest = new ManageDownloads(driver);
		managedownloadtest.deleteWorkOrderExistingFile();
		managedownloadtest.clickOn_ExportXLS();

		try {
			boolean value = managedownloadtest.checkWorkOrderFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
}