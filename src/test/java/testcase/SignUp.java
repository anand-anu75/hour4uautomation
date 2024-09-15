package testcase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.LoginPage;
import pages.SignupPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class SignUp extends BaseTest {

	LoginPage signup;
	SignupPage signupPage;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Signup with Valid Email and OTP")
	public void signUp_With_ValidEmailOTP(String phoneOrEmail, String OTP, String mobileNumber, String companyName,
			String companyGSTNumber, String companyAddress, String expectedURL) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		signup = new LoginPage(driver);

		signup.clickOnLink_Signup();
		signup.enterPhoneOrEmail(phoneOrEmail);
		signup.clickOnBtn_GetOTP();
		signup.enterOTP(OTP);
		signup.clickOnBtn_Signup();

		// creating object of signuppage class
		signupPage = new SignupPage(driver);

		// Enter data in sinup form
		signupPage.enter_MobileNumber(mobileNumber);
		signupPage.enter_CompanyName(companyName);
		signupPage.enter_CompanyGSTNumber(companyGSTNumber);
		signupPage.enter_CompanyAddress(companyAddress);
		signupPage.click_On_ExploreThePlatform_Button();

		try {
			// wait for the URL change
			wait.until(ExpectedConditions.urlToBe(expectedURL));
		} catch (Exception e) {
			System.out.println("URL is incorrect");
		}

		String actualURL = driver.getCurrentUrl();

		try {

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

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Signup with Valid Phone Number and OTP")
	public void signUp_With_ValidPhNoOTP(String phoneOrEmail, String OTP, String mobileNumber, String companyName,
			String companyGSTNumber, String companyAddress, String expectedURL) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		signup = new LoginPage(driver);

		signup.clickOnLink_Signup();
		signup.enterPhoneOrEmail(phoneOrEmail);
		signup.clickOnBtn_GetOTP();
		signup.enterOTP(OTP);
		signup.clickOnBtn_Signup();

		// creating object of signuppage class
		signupPage = new SignupPage(driver);

		// Enter data in sinup form
		signupPage.enter_MobileNumber(mobileNumber);
		signupPage.enter_CompanyName(companyName);
		signupPage.enter_CompanyGSTNumber(companyGSTNumber);
		signupPage.enter_CompanyAddress(companyAddress);
		signupPage.click_On_ExploreThePlatform_Button();

		try {
			// wait for the URL change
			wait.until(ExpectedConditions.urlToBe(expectedURL));
		} catch (Exception e) {
			System.out.println("URL is incorrect");
		}

		String actualURL = driver.getCurrentUrl();

		try {

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

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Error Message for Empty Phone Number/Email Field")
	public void verifySignupEmptyphoneEmailErr(String phoneOrEmail, String expectedMessage)
			throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		signup = new LoginPage(driver);
		signupPage = new SignupPage(driver);

		signup.clickOnLink_Signup();
		signup.enterPhoneOrEmail(phoneOrEmail);
		signup.clickOnBtn_GetOTP();

		String errorMessageForEmptyPhoneEmail = signupPage.get_SignupEmptyPhoneEmailErrorMessage();

		try {

			// Verify the Error message
			softAssert.assertEquals(errorMessageForEmptyPhoneEmail, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError ae) {
			assertionMessage.set(ae.getMessage());
			throw ae;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Error Message for Invalid Email Format")
	public void verifySignupInvalidEmailFormat(String phoneOrEmail, String expectedMessage)
			throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		signup = new LoginPage(driver);
		signupPage = new SignupPage(driver);

		signup.clickOnLink_Signup();
		signup.enterPhoneOrEmail(phoneOrEmail);
		signup.clickOnBtn_GetOTP();

		String errorMessageForInvalidEmailFormat = signupPage.get_SignupInvalidEmailPhoneFormatErrorMessage();

		try {

			// Verify the error message
			softAssert.assertEquals(errorMessageForInvalidEmailFormat, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError ae) {
			assertionMessage.set(ae.getMessage());
			throw ae;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Error Message for Invalid Phone Number Format")
	public void verifySignupInvalidPhoneFormat(String phoneOrEmail, String expectedMessage)
			throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		signup = new LoginPage(driver);
		signupPage = new SignupPage(driver);

		signup.clickOnLink_Signup();
		signup.enterPhoneOrEmail(phoneOrEmail);
		signup.clickOnBtn_GetOTP();

		String errorMessageForInvalidPhoneNoFormat = signupPage.get_SignupInvalidEmailPhoneFormatErrorMessage();

		try {

			// Verify the error message
			softAssert.assertEquals(errorMessageForInvalidPhoneNoFormat, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError ae) {
			assertionMessage.set(ae.getMessage());
			throw ae;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Error Message for Incorrect OTP")
	public void verifySignupErrIncorrectOTP(String phoneOrEmail, String OTP, String expectedMessage)
			throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		signup = new LoginPage(driver);
		signupPage = new SignupPage(driver);

		signup.clickOnLink_Signup();
		signup.enterPhoneOrEmail(phoneOrEmail);
		signup.clickOnBtn_GetOTP();
		signup.enterOTP(OTP);
		signup.clickOnBtn_Signup();

		String errorMessageForIncorrectOTP = signupPage.get_SignupDialogBoxErrorMessage() + " "
				+ signupPage.get_SignupDialogBoxIncorrectOTP();

		try {

			// Verify the error message
			softAssert.assertEquals(errorMessageForIncorrectOTP, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError ae) {
			assertionMessage.set(ae.getMessage());
			throw ae;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Error Message for Invalid Mobile Number Format")
	public void verifyInvalidMobileNoFormat(String phoneOrEmail, String OTP, String mobileNumber,
			String expectedMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		signup = new LoginPage(driver);

		signup.clickOnLink_Signup();
		signup.enterPhoneOrEmail(phoneOrEmail);
		signup.clickOnBtn_GetOTP();
		signup.enterOTP(OTP);
		signup.clickOnBtn_Signup();

		// creating object of signuppage class
		signupPage = new SignupPage(driver);

		// Enter data in sinup form
		signupPage.enter_MobileNumber(mobileNumber);
		signupPage.click_On_ExploreThePlatform_Button();

		

		String errorMessageForInvalidMobileNoFormat = signupPage.get_SignupInvalidMobileNoFormatErrorMessage();

		try {

			// Verify the error message
			softAssert.assertEquals(errorMessageForInvalidMobileNoFormat, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError ae) {
			assertionMessage.set(ae.getMessage());
			throw ae;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Error Message for Empty Company Name Field")
	public void verifyEmptyCompanyNameErr(String phoneOrEmail, String OTP, String mobileNumber, String companyName,
			String expectedMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		signup = new LoginPage(driver);

		signup.clickOnLink_Signup();
		signup.enterPhoneOrEmail(phoneOrEmail);
		signup.clickOnBtn_GetOTP();
		signup.enterOTP(OTP);
		signup.clickOnBtn_Signup();

		// creating object of signuppage class
		signupPage = new SignupPage(driver);

		// Enter data in sinup form
		signupPage.enter_MobileNumber(mobileNumber);
		signupPage.enter_CompanyName(companyName);
		signupPage.click_On_ExploreThePlatform_Button();

		

		String errorMessageForEmptyCompanyName = signupPage.get_SingupEmptyCompanyNameErrorMessage();

		try {

			// Verify the error message
			softAssert.assertEquals(errorMessageForEmptyCompanyName, expectedMessage);
			softAssert.assertAll();
		} catch (AssertionError ae) {
			assertionMessage.set(ae.getMessage());
			throw ae;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

}
