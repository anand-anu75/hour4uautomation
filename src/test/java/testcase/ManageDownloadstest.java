package testcase;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ManageDownloads;
import utilities.ReadXLData;

public class ManageDownloadstest extends BaseTest {
		ManageDownloads managedownloadtest;
		LoginPage login;
		
		static String actualURL;
		
		
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Dashboard Page")
		public void verify_Download_Dashboard(String phoneOrEmail, String OTP) throws InterruptedException, IOException {
			login = new LoginPage(driver);

			login.clickOnLink_SignInUsingOtp();
			login.enterPhoneOrEmail(phoneOrEmail);
			login.clickOnBtn_GetOTP();
			login.enterOTP(OTP);
			login.clickOnBtn_Login();
			
			managedownloadtest = new ManageDownloads(driver);
			managedownloadtest.clickOnbtn_More();
			managedownloadtest.clickOnbtn_DownloadProofofwork();
			Thread.sleep(5000);
			File downloadedfile = new File("C:\\Users\\Apptad\\Downloads\\proof_of_work_66d41c10ef900e1c45d355c8.pptx");
			if(downloadedfile.exists()) {
				softAssert.assertTrue(true);
			
			}
			else { 
				softAssert.assertTrue(false);
			}
			try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
			
		
		}
		
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Dashboard Page")
		public void verify_Download_ViewTask(String phoneOrEmail, String OTP) throws InterruptedException, IOException {
			login = new LoginPage(driver);

			login.clickOnLink_SignInUsingOtp();
			login.enterPhoneOrEmail(phoneOrEmail);
			login.clickOnBtn_GetOTP();
			login.enterOTP(OTP);
			login.clickOnBtn_Login();
		
			
			managedownloadtest = new ManageDownloads(driver);
			Thread.sleep(2000);
			Actions actions = new Actions(driver); 
			actions.sendKeys(Keys.ARROW_DOWN).perform();
			managedownloadtest.clickOnbtn_ViewTasks();
			String originalWindow = driver.getWindowHandle();
			 

			Set<String> allWindows = driver.getWindowHandles();

			for (String windowHandle : allWindows) {
			    if (!windowHandle.equals(originalWindow)) {
			        driver.switchTo().window(windowHandle);
			        break;
			    }
			}
			Thread.sleep(2000);
			managedownloadtest.clickOn_Openmenutoexplore();
			managedownloadtest.clickOnbtn_DownloadProofofwork();
			Thread.sleep(5000);
			File downloadedfile = new File("C:\\Users\\Apptad\\Downloads\\proof_of_work_66d595ab18789317173dd1b6.pptx");
			if(downloadedfile.exists()) {
				softAssert.assertTrue(true);
			
			}
			else { 
				softAssert.assertTrue(false);
			}
			try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
			
		
		}
		
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Workorders")
		public void verify_Download_Workorder(String phoneOrEmail, String OTP) throws InterruptedException, IOException {
			login = new LoginPage(driver);

			login.clickOnLink_SignInUsingOtp();
			login.enterPhoneOrEmail(phoneOrEmail);
			login.clickOnBtn_GetOTP();
			login.enterOTP(OTP);
			login.clickOnBtn_Login();
					
			
			managedownloadtest = new ManageDownloads(driver);
			managedownloadtest.clickOn_Completed();
			Thread.sleep(2000);
			managedownloadtest.clickOn_Openmenutoexplore();
			managedownloadtest.clickOnbtn_DownloadProofofwork();
			Thread.sleep(5000);
			File downloadedfile = new File("C:\\Users\\Apptad\\Downloads\\proof_of_work_66d41c10ef900e1c45d355c8.pptx");
			if(downloadedfile.exists()) {
				softAssert.assertTrue(true);
			
			}
			else { 
				softAssert.assertTrue(false);
			}
			try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
			
		}
		
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Dashboard Page")
		public void verify_Download_XLS(String phoneOrEmail, String OTP) throws InterruptedException, IOException {
			login = new LoginPage(driver);

			login.clickOnLink_SignInUsingOtp();
			login.enterPhoneOrEmail(phoneOrEmail);
			login.clickOnBtn_GetOTP();
			login.enterOTP(OTP);
			login.clickOnBtn_Login();
			
			
			managedownloadtest = new ManageDownloads(driver);
			managedownloadtest.clickOn_ExportXLS();
			Thread.sleep(5000);
			File downloadedfile = new File("C:\\Users\\Apptad\\Downloads\\workorder-data.xlsx");
			if(downloadedfile.exists()) {
				softAssert.assertTrue(true);
			
			}
			else { 
				softAssert.assertTrue(false);
			}
			try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
		}
	

}
