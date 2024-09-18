package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	public void addTeamMember(String phoneOrEmail, String OTP, String name, String mobile, String email,
			String expectedMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);
		
		// Steps to perform login with OTP

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

		// Create team member
		teamMembers = new AddTeamMembers(driver);
		
		//click on Users button
		teamMembers.clickOnbtn_Users();
		
		//click on team members
		teamMembers.clickOnLink_TeamMembers();
		
		//click on Invite Team Members
		teamMembers.clickOnbtn_InviteTeamMembers();
		
		//Enter a valid Name
		teamMembers.enterName(name);
		
		//Enter a valid Mobile Number
		teamMembers.enterMobile(mobile);
		
		//Enter a valid Email ID
		teamMembers.enterEmail(email);
		
		//click on Role DropDown
		teamMembers.clickOn_RoleDropdown();
		
		//select the Role type
		teamMembers.selectRoleType();
		
		//click on Add Team Member Button
		teamMembers.click_On_AddTeamMemberButton();
		
		//Fetch success Message for valid details
		String actualMessage = teamMembers.get_MessageForTeamMemberAddedSuccessfully();
		String teamMemberName = teamMembers.get_nameOfTeamMemberAdded();
		String teamMemberMobileNo = teamMembers.get_mobileOfTeamMemberAdded();
		String teamMemberEmail = teamMembers.get_emailOfTeamMemberAdded();

		//Verify success Message for valid details
		try {
			softAssert.assertEquals(actualMessage, expectedMessage);
			softAssert.assertEquals(teamMemberName, AddTeamMembers.expectedName);
			softAssert.assertEquals(teamMemberMobileNo, AddTeamMembers.expectedMobileNo);
			softAssert.assertEquals(teamMemberEmail, AddTeamMembers.expectedEmail);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid name in Team Members Section.")
	public void validation_for_invalid_Name(String phoneOrEmail, String OTP, String invalidName, String mobile,
			String email, String expectederrorMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Login with valid credentials
		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();

		// Create team member
		teamMembers = new AddTeamMembers(driver);
		
		//click on Users button
		teamMembers.clickOnbtn_Users();
		
		//click on team members
		teamMembers.clickOnLink_TeamMembers();
		
		//click on Invite Team Members
		teamMembers.clickOnbtn_InviteTeamMembers();
		
		//Enter a Invalid Name
		teamMembers.enterInvalidName(invalidName);
		
		//Enter a valid Mobile Number
		teamMembers.enterMobile(mobile);
		
		//Enter a valid Email ID
		teamMembers.enterEmail(email);
		
		//select the Role type
		teamMembers.clickOn_RoleDropdown();
		
		//select the Role type
		teamMembers.selectRoleType();
		
		//click on Add Team Member Button
		teamMembers.click_On_AddTeamMemberButton();
		
		//Fetch Error Message for Invalid Name
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidName();

		//Verify Error Message for Invalid Name
		try {
			softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid mobile number in Team Members Section.")
	public void validation_for_invalid_Mobile(String phoneOrEmail, String OTP, String name, String mobile, String email,
			String expectederrorMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Login with valid credentials
		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();

		// Create team member
		teamMembers = new AddTeamMembers(driver);
		
		//click on Users button
		teamMembers.clickOnbtn_Users();
		
		//click on Team members
		teamMembers.clickOnLink_TeamMembers();
		
		//click on Invite Team Members button
		teamMembers.clickOnbtn_InviteTeamMembers();
		
		//Enter a valid name
		teamMembers.enterName(name);
		
		//Enter a invalid Mobile number
		teamMembers.enterMobile(mobile);
		
		//Enter a valid Email ID
		teamMembers.enterEmail(email);
		
		//click on Role DropDown
		teamMembers.clickOn_RoleDropdown();
		
		//select a Role Type
		teamMembers.selectRoleType();
		
		//click o Add Team Member Button
		teamMembers.click_On_AddTeamMemberButton();
		
		//Fetch Error Message for Invalid Mobile Number
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidMobile();

		//Verify Error Message for Invalid Mobile Number
		try {
			softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for Invalid Email in Team Members Section.")
	public void validation_for_invalid_Email(String phoneOrEmail, String OTP, String name, String mobile, String email,
			String expectederrorMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Login with valid credentials
		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();

		// Create team member
		teamMembers = new AddTeamMembers(driver);
		
		//click on Users button
		teamMembers.clickOnbtn_Users();
		
		//click on Team members
		teamMembers.clickOnLink_TeamMembers();
		
		//click on Invite Team Members button
		teamMembers.clickOnbtn_InviteTeamMembers();
		
		//Enter a valid Name
		teamMembers.enterName(name);
		
		//Enter a valid Mobile number
		teamMembers.enterMobile(mobile);
		
		//Enter a Invalid Email ID
		teamMembers.enterEmail(email);
		
		//click on Add Team Member Button
		teamMembers.click_On_AddTeamMemberButton();
		
		//Fetch Error Message for Invalid Email ID
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidEmail();

		//Verify error message for invalid Email ID
		try {
			softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
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