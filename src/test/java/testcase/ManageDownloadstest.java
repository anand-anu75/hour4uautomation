package testcase;

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
		public void verify_Download_Dashboard(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
			login = new LoginPage(driver);

			login.clickOnLink_SignInUsingOtp();
			login.enterPhoneOrEmail(phoneOrEmail);
			login.clickOnBtn_GetOTP();
			login.enterOTP(OTP);
			login.clickOnBtn_Login();
			Thread.sleep(1000);
			actualURL = driver.getCurrentUrl();
			softAssert.assertEquals(actualURL, expectedURL);
			try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
			
			
			managedownloadtest = new ManageDownloads(driver);
			managedownloadtest.clickOnbtn_More();
			managedownloadtest.clickOnbtn_DownloadProofofwork();
		
		}
		
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Dashboard Page")
		public void verify_Download_ViewTask(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
			login = new LoginPage(driver);

			login.clickOnLink_SignInUsingOtp();
			login.enterPhoneOrEmail(phoneOrEmail);
			login.clickOnBtn_GetOTP();
			login.enterOTP(OTP);
			login.clickOnBtn_Login();
			Thread.sleep(1000);
			actualURL = driver.getCurrentUrl();
			softAssert.assertEquals(actualURL, expectedURL);
			try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
			
			
			managedownloadtest = new ManageDownloads(driver);
			
  		    Actions actions = new Actions(driver); 
			actions.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(2000);
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
			
		
		}
		
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Workorders")
		public void verify_Download_Workorder(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
			login = new LoginPage(driver);

			login.clickOnLink_SignInUsingOtp();
			login.enterPhoneOrEmail(phoneOrEmail);
			login.clickOnBtn_GetOTP();
			login.enterOTP(OTP);
			login.clickOnBtn_Login();
			Thread.sleep(1000);
			actualURL = driver.getCurrentUrl();
			softAssert.assertEquals(actualURL, expectedURL);
			try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
			
			
			managedownloadtest = new ManageDownloads(driver);
			managedownloadtest.clickOn_Active();
			Thread.sleep(2000);
			managedownloadtest.clickOn_Openmenutoexplore();
			managedownloadtest.clickOnbtn_DownloadProofofwork();
			
		}
		
		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Data from Dashboard Page")
		public void verify_Download_XLS(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
			login = new LoginPage(driver);

			login.clickOnLink_SignInUsingOtp();
			login.enterPhoneOrEmail(phoneOrEmail);
			login.clickOnBtn_GetOTP();
			login.enterOTP(OTP);
			login.clickOnBtn_Login();
			Thread.sleep(1000);
			actualURL = driver.getCurrentUrl();
			softAssert.assertEquals(actualURL, expectedURL);
			try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
			
			
			managedownloadtest = new ManageDownloads(driver);
			managedownloadtest.clickOn_ExportXLS();
		}
	

}
