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
import pages.LoginPage;
import pages.ManageDownloads;
import pages.ProofOfWork;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class ProofOfWorktest extends BaseTest {
	ProofOfWork proofOfWorktest;
	Login loginObject;
	ManageDownloads manageDownloads;

	static String actualURL;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from Dashboard Page")
	public void verify_proofofwork_Dashboard(String phoneOrEmail, String OTP, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		proofOfWorktest = new ProofOfWork(driver);
		manageDownloads = new ManageDownloads(driver);

		//Delete the existing file
		manageDownloads.deleteExistingFile();
		
		manageDownloads.clickOnLabel();
		
		// Scroll the page down
		scrollPageDown();
		
	//	Thread.sleep(2000);
		//click on three dot
		proofOfWorktest.clickOnbtn_More();
		
		//click on download proof of work
		proofOfWorktest.clickOnbtn_DownloadProofofwork();

		// Ensure that the proof of work file has been successfully downloaded
		try {
			boolean value = manageDownloads.checkFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from Projects section")
	public void verify_proofofwork_Project(String phoneOrEmail, String OTP, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		//login with valid details
		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		manageDownloads = new ManageDownloads(driver);
		
		//Delete the existing file
		manageDownloads.deleteExistingFile();

		proofOfWorktest = new ProofOfWork(driver);
		
		//click on projects button
		proofOfWorktest.clickOnbtn_Projects();
		
		//Navigate to Next page
	//	proofOfWorktest.clickOnbtn_NextPage();
		
		//click to view workorder
		proofOfWorktest.clickOnbtn_clickheretoviewWorkorders();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_LEFT).perform();
		
		//click open menu to explore
		proofOfWorktest.clickOnbtn_More();
		
		
		//click on download proof of work
		proofOfWorktest.clickOnbtn_DownloadProofofwork();

		// Ensure that the proof of work file has been successfully downloaded
		try {
			boolean value = manageDownloads.checkFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from Job Application Page")
	public void verify_proofofwork_JobApp(String phoneOrEmail, String OTP, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		proofOfWorktest = new ProofOfWork(driver);
		manageDownloads = new ManageDownloads(driver);
		
		//Delete the existing file
		manageDownloads.deleteExistingFile();
		manageDownloads.clickOnLabel();
		
		//scroll the page down
		scrollPageDown();

	//	AddChampsWorkOrder createWorkOrder = new AddChampsWorkOrder(driver);
	//	createWorkOrder.clickDesiredWorkOrder();
		
	//	Thread.sleep(2000);
		//click on open menu to explore
		proofOfWorktest.clickOn_Openmenutoexplore();
		
		//click on Download proof of work
		proofOfWorktest.clickOnbtn_DownloadProofofwork();

		// Ensure that the proof of work file has been successfully downloaded
		try {
			boolean value = manageDownloads.checkFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from View Tasks Page")
	public void verify_proofofwork_ViewTask(String phoneOrEmail, String OTP, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		//login with valid Details
		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		proofOfWorktest = new ProofOfWork(driver);
		manageDownloads = new ManageDownloads(driver);
		
		//Delete the existing file
		manageDownloads.deleteExistingFile();
		manageDownloads.clickOnLabel();
		
		//scroll the page down
		scrollPageDown();

		//click on view task button
		proofOfWorktest.clickOnbtn_ViewTasks();
		
		//Switch to new Tab
		switchToNewTab();
		
		//click on open menu to explore
		proofOfWorktest.clickOn_Openmenutoexplore();
		
		//click on download proof of work
		proofOfWorktest.clickOnbtn_DownloadProofofwork();

		// Ensure that the proof of work file has been successfully downloaded
		try {
			boolean value = manageDownloads.checkFileDownload();
			softAssert.assertTrue(value);
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
