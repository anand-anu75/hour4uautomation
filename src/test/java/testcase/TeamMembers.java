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

		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();

		teamMembers = new AddTeamMembers(driver);
		teamMembers.clickOnbtn_Users();
		teamMembers.clickOnLink_TeamMembers();
		teamMembers.clickOnbtn_InviteTeamMembers();
		teamMembers.enterName(name);
		teamMembers.enterMobile(mobile);
		teamMembers.enterEmail(email);
		teamMembers.clickOn_RoleDropdown();
		teamMembers.selectRoleType();
		teamMembers.click_On_AddTeamMemberButton();
		String actualMessage = teamMembers.get_MessageForTeamMemberAddedSuccessfully();
		String teamMemberName = teamMembers.get_nameOfTeamMemberAdded();
		String teamMemberMobileNo= teamMembers.get_mobileOfTeamMemberAdded();
		String teamMemberEmail = teamMembers.get_emailOfTeamMemberAdded();

		try {
			softAssert.assertEquals(actualMessage, expectedMessage);
			softAssert.assertEquals(teamMemberName, AddTeamMembers.expectedName);
			softAssert.assertEquals(teamMemberMobileNo, AddTeamMembers.expectedMobileNo);
			softAssert.assertEquals(teamMemberEmail, AddTeamMembers.expectedEmail);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid name in Team Members Section.")
	public void validation_for_invalid_Name(String phoneOrEmail, String OTP, String invalidName, String mobile, String email,
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
		teamMembers.clickOnbtn_Users();
		teamMembers.clickOnLink_TeamMembers();
		teamMembers.clickOnbtn_InviteTeamMembers();
		teamMembers.enterInvalidName(invalidName);
		teamMembers.enterMobile(mobile);
		teamMembers.enterEmail(email);
		teamMembers.clickOn_RoleDropdown();
		teamMembers.selectRoleType();
		teamMembers.click_On_AddTeamMemberButton();
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidName();

		try {
			softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid mobile number in Team Members Section.")
	public void validation_for_invalid_Mobile(String phoneOrEmail, String OTP, String name, String mobile, String email,
			String expectederrorMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

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
		teamMembers.clickOn_RoleDropdown();
		teamMembers.selectRoleType();
		teamMembers.click_On_AddTeamMemberButton();
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidMobile();

		try {
			softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for Invalid Email in Team Members Section.")
	public void validation_for_invalid_Email(String phoneOrEmail, String OTP, String name, String mobile, String email,
			String expectederrorMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		login.clickOnLink_SignInUsingOtp();
		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_GetOTP();
		login.enterOTP(OTP);
		login.clickOnBtn_Login();

		teamMembers = new AddTeamMembers(driver);
		teamMembers.clickOnbtn_Users();
		teamMembers.clickOnLink_TeamMembers();
		teamMembers.clickOnbtn_InviteTeamMembers();
		teamMembers.enterName(name);
		teamMembers.enterMobile(mobile);
		teamMembers.enterEmail(email);
		teamMembers.clickOn_RoleDropdown();
		teamMembers.selectRoleType();
		teamMembers.click_On_AddTeamMemberButton();
		String actualerrorMessage = teamMembers.get_ErrorMessageForInvalidEmail();

		try {
			softAssert.assertEquals(actualerrorMessage, expectederrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
}