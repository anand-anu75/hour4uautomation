package testcase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AppLoginPage;
import pages.LoginPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class AppLogin extends BaseTest{
	AppLoginPage Applogin;
	
	static String actualURL;
	
	//Champ applied to Work Order using Workorbit Application
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ApploginChamp(String MobileNumber,String EnterOTP) throws InterruptedException, IOException {
		Applogin = new AppLoginPage(driver);
		
		driver.get(prop.getProperty("AppURL"));
		
		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
		Applogin.enterMobileNumber(MobileNumber);
		Applogin.clickOnNextButton();
		Thread.sleep(2000);
		Applogin.enterOTP(EnterOTP);
		Thread.sleep(4000);
		Applogin.clickOnNext2Button();
		Applogin.clickOnWorkorbitButton();
		Applogin.clickOnApplyWorkorbitButton();
	}
	
	//Vendor applied to Work Order using Workorbit Application
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ApploginVendor(String MobileNumber,String EnterOTP,String VendorName,String EnterDOB) 
			throws InterruptedException, IOException {
		Applogin = new AppLoginPage(driver);
		
		driver.get(prop.getProperty("AppURL"));
		
		Applogin.clickOnLetStartButton();
		Applogin.clickOnSkiptButton();
		Applogin.enterMobileNumber(MobileNumber);
		Applogin.clickOnNextButton();
		Thread.sleep(2000);
		Applogin.enterOTP(EnterOTP);
		Thread.sleep(3000);
		Applogin.clickOnNext2Button();
		Thread.sleep(2000);
	//	Applogin.enterVendorName(VendorName);
	//	Applogin.enterOTP(EnterDOB);
		Applogin.clickOnGenderMale();
		Thread.sleep(3000);
		Applogin.clickOnNext3();
		System.out.println("Next button clicked");
		Applogin.clickOnWorkorbitButton();
		Applogin.clickOnApplyWorkorbitButton();
	}

}
