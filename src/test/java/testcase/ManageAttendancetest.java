package testcase;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ManageAttendance;
import utilities.ReadXLData;

public class ManageAttendancetest extends BaseTest {

	ManageAttendance manageAttendancetest;
	LoginPage login;

	static String actualURL;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify attendnace in the Workorder.")
	public void verify_Attendance_Workorder(String phoneOrEmail, String OTP, String expectedURL, String expectedMessage)
			throws InterruptedException, IOException {
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

		manageAttendancetest = new ManageAttendance(driver);
		manageAttendancetest.clickOnbtn_Workorder();
		manageAttendancetest.clickOnbtn_ViewTasks();
		String originalWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		manageAttendancetest.clickOn_Openmenutoexplore();
		manageAttendancetest.clickOn_ViewJobSeekerSchedules();
		String actualMessage = manageAttendancetest.get_Actualmessage();
		softAssert.assertEquals(actualMessage, expectedMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify attendnace in the Workorder.")
	public void verify_Attendance_ViewTask(String phoneOrEmail, String OTP, String expectedURL, String expectedMessage)
			throws InterruptedException, IOException {
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

		manageAttendancetest = new ManageAttendance(driver);
		manageAttendancetest.clickOnbtn_Workorder();
		manageAttendancetest.clickOnbtn_More();
		manageAttendancetest.clickOn_ViewJobSeekerSchedules();
		Thread.sleep(2000);
		String actualMessage = manageAttendancetest.get_Actualmessage();
		softAssert.assertEquals(actualMessage, expectedMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify attendnace in the Workorder.")
	public void verify_Attendance_Active(String phoneOrEmail, String OTP, String expectedURL, String expectedMessage)
			throws InterruptedException, IOException {
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

		manageAttendancetest = new ManageAttendance(driver);
		manageAttendancetest.clickOnbtn_Workorder();
		manageAttendancetest.clickOn_Active();
		Thread.sleep(2000);
		manageAttendancetest.clickOn_Openmenutoexplore();
		manageAttendancetest.clickOn_ViewJobSeekerSchedules();
		String actualMessage = manageAttendancetest.get_Actualmessage();
		softAssert.assertEquals(actualMessage, expectedMessage);
		try {
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
