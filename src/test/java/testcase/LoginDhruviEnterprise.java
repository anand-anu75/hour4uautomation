package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginDhruviEnterprisePage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class LoginDhruviEnterprise extends BaseTest{
	
	LoginDhruviEnterprisePage LoginDhruviEnterprise;
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void loginDhruviEnterprise(String phoneOrEmail, String EnterPassword) throws InterruptedException, IOException {
		LoginDhruviEnterprise = new LoginDhruviEnterprisePage(driver);

		LoginDhruviEnterprise.enterDhruviEmail(phoneOrEmail);
		LoginDhruviEnterprise.enterDhruviPassword(EnterPassword);
		LoginDhruviEnterprise.clickOnLoginButton();	
	}

}
