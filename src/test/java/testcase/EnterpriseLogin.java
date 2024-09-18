package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginDhruviEnterprisePage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class EnterpriseLogin extends BaseTest{
	
	LoginDhruviEnterprisePage EnterpriseLogin;
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void loginDhruviEnterprise(String phoneOrEmail, String EnterPassword) throws InterruptedException, IOException {
		EnterpriseLogin = new LoginDhruviEnterprisePage(driver);

		EnterpriseLogin.enterDhruviEmail(phoneOrEmail);
		EnterpriseLogin.enterDhruviPassword(EnterPassword);
		EnterpriseLogin.clickOnLoginButton();	
	}

}
