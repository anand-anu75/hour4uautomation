package testcase;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
		
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		login = new LoginPage(driver);

		// Click on Sign in using OTP option
		login.clickOnLink_SignInUsingOtp();
		
		// Enter phone number or email
		login.enterPhoneOrEmail(phoneOrEmail);
		
		// Click on Get OTP button
		login.clickOnBtn_GetOTP();
		
		// Enter the received OTP
		login.enterOTP(OTP);
		
		// Click on Login button
		login.clickOnBtn_Login();
		
		manageAttendancetest = new ManageAttendance(driver);
		
		//click on workorder button
		manageAttendancetest.clickOnbtn_Workorder();
		
		//click on view task button
		manageAttendancetest.clickOnbtn_ViewTasks();
		String originalWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		//click on open menu to explore
		manageAttendancetest.clickOn_Openmenutoexplore();
		
		//click on view job seeker schedules
		manageAttendancetest.clickOn_ViewJobSeekerSchedules();
		
		//Fetch the success message for check in and check out time
		String actualMessage = manageAttendancetest.get_Actualmessage();
		softAssert.assertEquals(actualMessage, expectedMessage);
		
		//verify the success message for attendance
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
		
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		
		login = new LoginPage(driver);

		// Click on Sign in using OTP option
		login.clickOnLink_SignInUsingOtp();
		
		// Enter phone number or email
		login.enterPhoneOrEmail(phoneOrEmail);
		
		// Click on Get OTP button
		login.clickOnBtn_GetOTP();
		
		// Enter the received OTP
		login.enterOTP(OTP);
		
		// Click on Login button
		login.clickOnBtn_Login();
	

		manageAttendancetest = new ManageAttendance(driver);
		
		//click on workorder button
		manageAttendancetest.clickOnbtn_Workorder();
		
		//click on More 
		manageAttendancetest.clickOnbtn_More();
		
		//click on view job seeker schedules
		manageAttendancetest.clickOn_ViewJobSeekerSchedules();
	//	Thread.sleep(2000);
		
		//Fetch the success message for check in and check out time
		String actualMessage = manageAttendancetest.get_Actualmessage();
		softAssert.assertEquals(actualMessage, expectedMessage);
		
		//verify the success message for attendance
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
		
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		
		login = new LoginPage(driver);
		
		
		// Click on Sign in using OTP option
		login.clickOnLink_SignInUsingOtp();
		
		// Enter phone number or email
		login.enterPhoneOrEmail(phoneOrEmail);
		
		// Click on Get OTP button
		login.clickOnBtn_GetOTP();
		
		// Enter the received OTP
		login.enterOTP(OTP);
		
		// Click on Login button
		login.clickOnBtn_Login();
	

		manageAttendancetest = new ManageAttendance(driver);
		
		//click on workorder button
		manageAttendancetest.clickOnbtn_Workorder();
		
		//click anywhere on workorder
		manageAttendancetest.clickOn_Completed();
		
		
		//click on open menu to explore
		manageAttendancetest.clickOn_Openmenutoexplore();
		
		//click on view job seeker schedules
		manageAttendancetest.clickOn_ViewJobSeekerSchedules();
		
		//Fetch the success message for check in and check out time
		String actualMessage = manageAttendancetest.get_Actualmessage();
		softAssert.assertEquals(actualMessage, expectedMessage);
		
		//verify the success message for attendance
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
