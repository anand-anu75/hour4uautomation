package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SignupPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class SignUp extends BaseTest {

	LoginPage signup;
	SignupPage signupPage;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void signUp(String phoneOrEmail, String OTP, String mobileNumber, String companyName,
			String companyGSTNumber, String companyAddress) throws InterruptedException {
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
		softAssert.assertEquals(companyGSTNumber, companyAddress);
		signupPage.click_On_ExploreThePlatform_Button();
		softAssert.assertAll();
	}

}
