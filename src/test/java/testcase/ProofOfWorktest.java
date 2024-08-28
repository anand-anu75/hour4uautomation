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
	
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void proofofwork(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void proofofwork1(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void proofofwork2(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void proofofwork3(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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
		proofOfWorktest.clickOn_Completed();
		Thread.sleep(2000);
		proofOfWorktest.clickOn_Openmenutoexplore();
		proofOfWorktest.clickOnbtn_DownloadProofofwork();
		
	
	}
	
	


}
 