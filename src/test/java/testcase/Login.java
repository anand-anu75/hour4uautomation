package testcase;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.ForgotPassword;
import pages.LoginPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class Login extends BaseTest {
	LoginPage login;

	static String actualURL;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with valid email/phone and OTP")
	public void login(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {

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

		try {
			// wait for the URL change
			wait.until(ExpectedConditions.urlToBe(expectedURL));
		} catch (Exception e) {
			System.out.println("URL is incorrect");
		}

		try {

			actualURL = driver.getCurrentUrl();

			// Verify the URL
			softAssert.assertEquals(actualURL, expectedURL);
			softAssert.assertAll();

		} catch (AssertionError ae) {
			assertionMessage.set(ae.getMessage());
			throw ae;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with valid email and password")
	public void login_with_valid_email_and_pass(String email, String password, String expectedURL)
			throws InterruptedException {
		login = new LoginPage(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Enter valid email
		login.enterPhoneOrEmail(email);

		// Enter valid password
		login.enterPassword(password);

		// Click on Login button
		login.clickOnBtn_Login();

		// Wait for the URL change
		try {
			wait.until(ExpectedConditions.urlToBe(expectedURL));
		} catch (Exception e) {
			System.out.println("URL is incorrect");
		}

		try {
			actualURL = driver.getCurrentUrl();
			softAssert.assertEquals(actualURL, expectedURL);

			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with valid phone number and password")
	public void login_with_valid_phNum_pass(String phNum, String password, String expectedURL)
			throws InterruptedException {
		login = new LoginPage(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Enter valid phone number
		login.enterPhoneOrEmail(phNum);

		// Enter valid password
		login.enterPassword(password);

		// Click on Login button
		login.clickOnBtn_Login();

		// Wait for the URL change
		try {
			wait.until(ExpectedConditions.urlToBe(expectedURL));
		} catch (Exception e) {
			System.out.println("URL is incorrect");
		}
		// Verify the URL
		try {
			actualURL = driver.getCurrentUrl();
			softAssert.assertEquals(actualURL, expectedURL);

			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid email/phone number format")
	public void validation_for_invalid_PhEmail(String phoneOrEmail, String password, String expectedErrorMessage) {
		login = new LoginPage(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Enter invalid phone number or email
		login.enterPhoneOrEmail(phoneOrEmail);

		// Enter valid password
		login.enterPassword(password);

		// Fetch error message
		String actualErrorMessage = login.get_ErrorMessageForInvalidFormatPhNumOrEmail();

		// Verify error message
		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty password field")
	public void validation_for_empty_pass(String phoneOrEmail, String expectedErrorMessage) {
		login = new LoginPage(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Enter valid phone number or email
		login.enterPhoneOrEmail(phoneOrEmail);

		// Click on Login button
		login.clickOnBtn_Login();

		// Fetch error message
		String actualErrorMessage = login.get_ErrorMessageForEmptyPassword();

		// Verify error message
		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify forgot password flow with valid email")
	public void forgot_pass_with_valid_email(String validEmail, String OTP, String newPassword, String expectedURL)
			throws InterruptedException {

		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Click on Forgot Password link
		login.clickOnLink_ForgotPassword();

		// Enter valid email ID
		forgotPassword.enterValidEmail(validEmail);

		// Click on Send Recovery Link
		forgotPassword.clickOnBtn_SendRecoveryLink();

		// Enter received OTP
		forgotPassword.enterReceivedOTP(OTP);

		// Enter new password
		forgotPassword.enterNewPassword(newPassword);

		// Click on submit button
		forgotPassword.clickOnSubmitButton();

		// Enter valid email ID
		login.enterPhoneOrEmail(validEmail);

		// Enter new password
		login.enterPassword(newPassword);

		// Click on login button
		login.clickOnBtn_Login();
		// Wait for the URL change
		try {
			wait.until(ExpectedConditions.urlToBe(expectedURL));
		} catch (Exception e) {
			System.out.println("URL is incorrect");
		}
		// Verify the URL
		try {
			actualURL = driver.getCurrentUrl();
			softAssert.assertEquals(actualURL, expectedURL);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty email/phone in Forgot Password")
	public void validation_For_empty_emailPhone(String expectedErrorMessage) {
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);

		// Click on Forgot password link
		login.clickOnLink_ForgotPassword();

		// Keep the email ID or Phone number field blank
		forgotPassword.click_OnEmailPhoneNumField();

		// Click on send recovery link
		forgotPassword.clickOnBtn_SendRecoveryLink();

		// Fetch error message
		String actualErrorMessage = forgotPassword.get_ErrorMessageForEmptyEmailPhone();

		// Verify error message
		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);

			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty OTP in Forgot Password")
	public void validation_On_Empty_OTP(String email, String password, String expectedErrorMessage) {

		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Click on forgot password link
		login.clickOnLink_ForgotPassword();

		// Enter valid email ID or phone number
		forgotPassword.enterValidEmail(email);

		// Click on Send Recovery link
		forgotPassword.clickOnBtn_SendRecoveryLink();

		// Enter new password
		forgotPassword.enterNewPassword(password);

		// Click on submit button
		forgotPassword.clickOnSubmitButton();

		// Navigate to dialog box
		forgotPassword.navigateToErrorDialogBox();

		// Fetch error message
		String actualErrorMessage = forgotPassword.get_DialogBoxErrorTitleMessage() + " "
				+ forgotPassword.get_ErrorMessageForEmptyOTPForgotPassword() + " "
				+ forgotPassword.get_dialogBoxBodyMessage();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty New Password in Forgot Password")
	public void validation_On_Empty_NewPassword(String email, String OTP, String expectedErrorMessage) {

		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Click on forgot password link
		login.clickOnLink_ForgotPassword();

		// Enter valid email ID
		forgotPassword.enterValidEmail(email);

		// Click on send recovery link
		forgotPassword.clickOnBtn_SendRecoveryLink();

		// Enter received OTP
		forgotPassword.enterReceivedOTP(OTP);

		// Click on new password field
		forgotPassword.click_OnPasswordField();

		// Click on submit button
		forgotPassword.clickOnSubmitButton();

		// Fetch error message
		String actualErrorMessage = forgotPassword.get_ErrorMessageForEmptyNewPassword().replace("...", "…");

		// Verify error message
		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for New Password less than 6 characters in Forgot Password")
	public void validation_On_NewPassword(String email, String OTP, String NewPassword, String expectedErrorMessage) {
		login = new LoginPage(driver);
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Click on forgot password link
		login.clickOnLink_ForgotPassword();

		// Enter valid email ID
		forgotPassword.enterValidEmail(email);

		// Click on send recovery link
		forgotPassword.clickOnBtn_SendRecoveryLink();

		// Enter received OTP
		forgotPassword.enterReceivedOTP(OTP);

		// Enter new password less than 6 digit
		forgotPassword.enterNewPassword(NewPassword);

		// Click on submit button
		forgotPassword.clickOnSubmitButton();

		// Navigate to error dialog box
		forgotPassword.navigateToErrorDialogBox();

		// Fetch error message
		String actualErrorMessage = forgotPassword.get_DialogBoxErrorTitleMessage() + " "
				+ forgotPassword.get_ErrorMessageForLessThan6DigitNewPassword() + " "
				+ forgotPassword.get_dialogBoxBodyMessage();

		// Verify error message
		try {

			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();

		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for invalid password")
	public void validation_On_InvalidPassword(String email, String invalidPassword, String expectedErrorMessage) {
		login = new LoginPage(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Enter valid Email ID
		login.enterPhoneOrEmail(email);

		// Enter invalid password
		login.enterPassword(invalidPassword);

		// Click on login button
		login.clickOnBtn_Login();

		// Navigate to error dialog box
		login.navigateToErrorDialogBox();

		// Fetch error message
		String actualErrorMessage = login.get_DialogBoxErrorTitleMessage() + " "
				+ login.get_InvalidPasswordErrorMessage();

		// Verify error message
		try {

			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();

		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify error message for empty email/phone field")
	public void validation_On_EmptyEmailPh(String expectedErrorMessage) {
		login = new LoginPage(driver);
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		// Click on login button
		login.clickOnBtn_Login();

		// Fetch error message
		String actualErrorMessage = login.get_emptyEmailPhoneErrorMessage();

		// Verify error message
		try {

			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
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
