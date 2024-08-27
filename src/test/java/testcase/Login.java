package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.ForgotPassword;
import pages.LoginPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class Login extends BaseTest {
	LoginPage login;

	static String actualURL;
	
	//Testing

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void login(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
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

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with valid email and password")
	public void login_with_valid_email_and_pass(String email, String password, String expectedURL)
			throws InterruptedException {
		login = new LoginPage(driver);

		login.enterPhoneOrEmail(email);
		login.enterPassword(password);
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
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with valid phone number and password")
	public void login_with_valid_phNum_pass(String phNum, String password, String expectedURL)
			throws InterruptedException {
		login = new LoginPage(driver);

		login.enterPhoneOrEmail(phNum);
		login.enterPassword(password);
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
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid email/phone number format")
	public void validation_for_invalid_PhEmail(String phoneOrEmail, String password, String expectedErrorMessage) {
		login = new LoginPage(driver);

		login.enterPhoneOrEmail(phoneOrEmail);
		login.enterPassword(password);
		String actuaErrorMessage = login.get_ErrorMessageForInvalidFormatPhNumOrEmail();
		softAssert.assertEquals(actuaErrorMessage, expectedErrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty password field")
	public void validation_for_empty_pass(String phoneOrEmail, String expectedErrorMessage) {
		login = new LoginPage(driver);

		login.enterPhoneOrEmail(phoneOrEmail);
		login.clickOnBtn_Login();
		String actualErrorMessage = login.get_ErrorMessageForEmptyPassword();
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify forgot password flow with valid email")
	public void forgot_pass_with_valid_email(String validEmail, String OTP, String newPassword, String expectedURL)
			throws InterruptedException {
		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);

		login.clickOnLink_ForgotPassword();

		forgotPassword.enterValidEmail(validEmail);
		forgotPassword.clickOnBtn_SendRecoveryLink();
		forgotPassword.enterReceivedOTP(OTP);
		forgotPassword.enterNewPassword(newPassword);
		forgotPassword.clickOnSubmitButton();

		login.enterPhoneOrEmail(validEmail);
		login.enterPassword(newPassword);
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

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty email/phone in Forgot Password")
	public void validation_For_empty_emailPhone(String expectedErrorMessage) {

		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);

		login.clickOnLink_ForgotPassword();

		forgotPassword.enterValidEmail(" ");
		forgotPassword.clickOnBtn_SendRecoveryLink();

		String actualErrorMessage = forgotPassword.get_ErrorMessageForEmptyEmailPhone();
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty OTP in Forgot Password")
	public void validation_On_Empty_OTP(String email, String password, String expectedErrorMessage) {

		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);

		login.clickOnLink_ForgotPassword();

		forgotPassword.enterValidEmail(email);
		forgotPassword.clickOnBtn_SendRecoveryLink();
		forgotPassword.enterNewPassword(password);
		forgotPassword.clickOnSubmitButton();
		forgotPassword.navigateToErrorDialogBox();

		String actualErrorMessage = forgotPassword.get_ErrorMessageForEmptyOTPForgotPassword();
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty OTP in Forgot Password")
	public void validation_On_Empty_NewPassword(String email, String OTP, String expectedErrorMessage) {

		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);

		login.clickOnLink_ForgotPassword();

		forgotPassword.enterValidEmail(email);
		forgotPassword.clickOnBtn_SendRecoveryLink();
		forgotPassword.enterReceivedOTP(OTP);
		forgotPassword.clickOnSubmitButton();

		String actualErrorMessage = forgotPassword.get_ErrorMessageForEmptyNewPassword();
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for New Password less than 6 characters in Forgot Password")
	public void validation_On_NewPassword(String email, String OTP, String NewPassword, String expectedErrorMessage) {
		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);

		login.clickOnLink_ForgotPassword();

		forgotPassword.enterValidEmail(email);
		forgotPassword.clickOnBtn_SendRecoveryLink();
		forgotPassword.enterReceivedOTP(OTP);
		forgotPassword.enterNewPassword(NewPassword);
		forgotPassword.clickOnSubmitButton();
		forgotPassword.navigateToErrorDialogBox();

		String actualErrorMessage = forgotPassword.get_ErrorMessageForLessThan6DigitNewPassword();
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}
}
