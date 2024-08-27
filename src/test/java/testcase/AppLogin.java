package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AppLoginPage;
import pages.LoginPage;
import utilities.ReadXLData;

public class AppLogin extends BaseTest{
	LoginPage Applogin;
	
	static String actualURL;
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Applogin(String MobileNumber) throws InterruptedException, IOException {
		Applogin = new LoginPage(driver);
		
		driver.get(prop.getProperty("AppURL"));
		
 
		
 
	}

}
