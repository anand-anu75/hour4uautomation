package testcase;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProofOfWork;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)


public class ProofOfWorktest extends BaseTest {
	ProofOfWork proofOfWorktest;
	LoginPage login;
	
	static String actualURL;
	
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from Dashboard Page")
	public void verify_proofofwork_Dashboard(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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
		
		
		proofOfWorktest = new ProofOfWork(driver);
		proofOfWorktest.clickOnbtn_More();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();
	
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from Projects section")
	public void verify_proofofwork_Project(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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
		
		
		proofOfWorktest = new ProofOfWork(driver);
		proofOfWorktest.clickOnbtn_Projects();
		proofOfWorktest.clickOnbtn_NextPage();
		proofOfWorktest.clickOnbtn_clickheretoviewWorkorders();
		Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);
        proofOfWorktest.clickOn_Openmenutoexplore();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();
		
	}
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from Job Application Page")
	public void verify_proofofwork_JobApp(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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
		
		
		proofOfWorktest = new ProofOfWork(driver);
		Actions actions = new Actions(driver); 
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		proofOfWorktest.clickOnbtn_ViewTasks();
		String originalWindow = driver.getWindowHandle();
		 

		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
		    if (!windowHandle.equals(originalWindow)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		Thread.sleep(2000);
		proofOfWorktest.clickOn_Openmenutoexplore();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();
		
	
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Download Proof of Work from View Tasks Page")
	public void verify_proofofwork_ViewTask(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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
		
		
		proofOfWorktest = new ProofOfWork(driver);
		Actions actions = new Actions(driver); 
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		proofOfWorktest.clickOn_Active();
		Thread.sleep(2000);
		proofOfWorktest.clickOn_Openmenutoexplore();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();
		
	
	}
	
	


}
 