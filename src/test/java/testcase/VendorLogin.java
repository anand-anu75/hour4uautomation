package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.VendorLoginPage;
import utilities.ReadXLData;

public class VendorLogin extends BaseTest{
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void VendorLoginTest(String phoneOrEmail, String OTP, String expectedURL) throws InterruptedException, IOException {
		VendorLoginPage Vendorlogin = new VendorLoginPage(driver);

		Vendorlogin.clickOnLink_SignInUsingOtp();
		Vendorlogin.enterPhoneOrEmail(phoneOrEmail);
		Vendorlogin.clickOnBtn_GetOTP();
		Vendorlogin.enterOTP(OTP);
		Vendorlogin.clickOnBtn_Login();
		Thread.sleep(1000);
		String actualURL = driver.getCurrentUrl();
		softAssert.assertEquals(actualURL, expectedURL);

		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

}
