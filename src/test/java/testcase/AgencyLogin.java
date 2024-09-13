package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AgencyloginPage;
import utilities.ReadXLData;

public class AgencyLogin extends BaseTest {
	AgencyloginPage Agencylogin;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Agencylogin(String PhoneEmail, String Password) throws InterruptedException {
		Agencylogin = new AgencyloginPage(driver);
		
		Agencylogin.enterPhoneEmail(PhoneEmail);
		Agencylogin.enterPassword(Password);
		Agencylogin.clickOnLoginBtn(); 

	}

}
