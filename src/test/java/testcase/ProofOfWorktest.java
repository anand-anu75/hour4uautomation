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

		manageDownloads.deleteExistingFile();
		manageDownloads.clickOnLabel();
		scrollPageDown();
		proofOfWorktest.clickOnbtn_More();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();

		try {
			boolean value = manageDownloads.checkFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from Projects section")
	public void verify_proofofwork_Project(String phoneOrEmail, String OTP, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		manageDownloads = new ManageDownloads(driver);
		manageDownloads.deleteExistingFile();

		proofOfWorktest = new ProofOfWork(driver);
		proofOfWorktest.clickOnbtn_Projects();
		proofOfWorktest.clickOnbtn_NextPage();
		proofOfWorktest.clickOnbtn_clickheretoviewWorkorders();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_LEFT).perform();
		proofOfWorktest.clickOn_Openmenutoexplore();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();

		try {
			boolean value = manageDownloads.checkFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
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
		manageDownloads.deleteExistingFile();
		manageDownloads.clickOnLabel();
		scrollPageDown();

		AddChampsWorkOrder createWorkOrder = new AddChampsWorkOrder(driver);
		createWorkOrder.clickDesiredWorkOrder();
		proofOfWorktest.clickOn_Openmenutoexplore();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();

		try {
			boolean value = manageDownloads.checkFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from View Tasks Page")
	public void verify_proofofwork_ViewTask(String phoneOrEmail, String OTP, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject = new Login();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		proofOfWorktest = new ProofOfWork(driver);
		manageDownloads = new ManageDownloads(driver);
		manageDownloads.deleteExistingFile();
		manageDownloads.clickOnLabel();
		scrollPageDown();

		proofOfWorktest.clickOnbtn_ViewTasks();
		switchToNewTab();
		proofOfWorktest.clickOn_Openmenutoexplore();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();

		try {
			boolean value = manageDownloads.checkFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

}
