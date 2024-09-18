package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class LoginEnterprise extends BaseTest{
	
	    LoginPage loginAgency;

		@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
		public void loginEnterprise(String phoneOrEmail, String OTP) throws InterruptedException, IOException {
			loginAgency = new LoginPage(driver);

			loginAgency.clickOnLink_SignInUsingOtp();
			loginAgency.enterPhoneOrEmail(phoneOrEmail);
			loginAgency.clickOnBtn_GetOTP();
			loginAgency.enterOTP(OTP);
			loginAgency.clickOnBtn_Login();

		}

}
