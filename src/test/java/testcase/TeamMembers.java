package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddTeamMembers;
import pages.LoginPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class TeamMembers extends BaseTest {
	AddTeamMembers teamMembers;
	LoginPage login;
	static String actualURL;


	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify that team member is added with valid name, mobile number and email.")

	public void validation_for_valid_Details(String phoneOrEmail, String OTP, String name, String mobile, String email, String expectedURL)
			throws InterruptedException {
		login = new LoginPage(driver);

		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();
		Thread.sleep(5000);
		
		teamMembers = new AddTeamMembers(driver);
        teamMembers.clickOnbtn_Users();
		teamMembers.clickOnLink_TeamMembers();
		teamMembers.clickOnbtn_InviteTeamMembers();
		teamMembers.enterName(name);
		teamMembers.enterMobile(mobile);
		teamMembers.enterEmail(email);
		teamMembers.click_On_AddTeamMember_Button();
		actualURL = driver.getCurrentUrl();
		softAssert.assertEquals(actualURL, expectedURL);

		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid name in Team Members Section.")

	public void validation_for_invalid_Name(String phoneOrEmail, String OTP, String name, String mobile, String email, String expectederrorMessage)
			throws InterruptedException {
		login = new LoginPage(driver);

		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();
		Thread.sleep(5000);
		
		
		teamMembers = new AddTeamMembers(driver);
        teamMembers.clickOnbtn_Users();
		teamMembers.clickOnLink_TeamMembers();
		teamMembers.clickOnbtn_InviteTeamMembers();
		teamMembers.enterName(name);
		teamMembers.enterMobile(mobile);
		teamMembers.enterEmail(email);
		teamMembers.click_On_AddTeamMember_Button();
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidName();
		softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid mobile number in Team Members Section.")

	public void validation_for_invalid_Mobile(String phoneOrEmail, String OTP, String name, String mobile, String email, String expectederrorMessage)
			throws InterruptedException {
		login = new LoginPage(driver);

		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();
		Thread.sleep(5000);
		
		
		teamMembers = new AddTeamMembers(driver);
        teamMembers.clickOnbtn_Users();
		teamMembers.clickOnLink_TeamMembers();
		teamMembers.clickOnbtn_InviteTeamMembers();
		teamMembers.enterName(name);
		teamMembers.enterMobile(mobile);
		teamMembers.enterEmail(email);
		teamMembers.click_On_AddTeamMember_Button();
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidMobile();
		softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for Invalid Email in Team Members Section.")

	public void validation_for_invalid_Email(String phoneOrEmail, String OTP, String name, String mobile, String email, String expectederrorMessage)
			throws InterruptedException {
		login = new LoginPage(driver);

		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();
		Thread.sleep(5000);
		
		
		teamMembers = new AddTeamMembers(driver);
        teamMembers.clickOnbtn_Users();
		teamMembers.clickOnLink_TeamMembers();
		teamMembers.clickOnbtn_InviteTeamMembers();
		teamMembers.enterName(name);
		teamMembers.enterMobile(mobile);
		teamMembers.enterEmail(email);
		teamMembers.click_On_AddTeamMember_Button();
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidEmail();
		softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	
	
	
}