package testcase;

import java.io.File;
import java.io.IOException;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreditStatement;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class CreditStatementTest extends BaseTest {
	CreditStatement CreditStatementTest;
	
	static String actualURL;
	
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Requesting Cash Credit")
	public void verify_Req_cash_credit(String phoneOrEmail, String password, String amount, String Superadminemail, String Superadminpassword, String Verificationcode, String Expectedmessage) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOnbtn_Topup();
		CreditStatementTest.enteramount(amount);
		CreditStatementTest.clickOnbtn_Paylater();
		CreditStatementTest.clickOn_dropdown();
		CreditStatementTest.clickOn_days();
		CreditStatementTest.clickOn_checkbox();
		CreditStatementTest.clickOnbtn_RequestCredits();
		Thread.sleep(2000);
		CreditStatementTest.clickOn_accounticon();
		CreditStatementTest.clickOn_logout();
		CreditStatementTest.enterSuperadminemail(Superadminemail);
		CreditStatementTest.enterSuperadminpassword(Superadminpassword);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOn_approve();
		CreditStatementTest.enterverificationcode(Verificationcode);
		CreditStatementTest.clickOn_Next();
		String actualMessage = CreditStatementTest.get_MessageForCreditstatus();
		softAssert.assertEquals(actualMessage, Expectedmessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
		
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Requesting Task Credit")
	public void verify_Req_Task_credit(String phoneOrEmail, String password, String amount, String Superadminemail, String Superadminpassword, String Verificationcode, String Expectedmessage) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOnbtn_Topup1();
		CreditStatementTest.enteramount(amount);
		CreditStatementTest.clickOnbtn_Paylater();
		CreditStatementTest.clickOn_dropdown();
		CreditStatementTest.clickOn_days();
		CreditStatementTest.clickOn_checkbox();
		CreditStatementTest.clickOnbtn_RequestCredits();
		CreditStatementTest.clickOn_accounticon();
		CreditStatementTest.clickOn_logout();
		CreditStatementTest.enterSuperadminemail(Superadminemail);
		CreditStatementTest.enterSuperadminpassword(Superadminpassword);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOn_approve();
		CreditStatementTest.enterverificationcode(Verificationcode);
		CreditStatementTest.clickOn_Next();
		String actualMessage = CreditStatementTest.get_MessageForCreditstatus();
		softAssert.assertEquals(actualMessage, Expectedmessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
		
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify View Statement button")
	public void verify_view_statement(String phoneOrEmail, String password, String expectedURL) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOn_ViewStatement();
		actualURL = driver.getCurrentUrl();
		softAssert.assertEquals(actualURL, expectedURL);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData",description = "Verify Export to XLS button on Credits Page")
	public void verify_Export_credits_page(String phoneOrEmail, String password) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOn_ExporttoXLS();
		Thread.sleep(5000);
		File downloadedfile = new File("C:\\Users\\Apptad\\Downloads\\credit-list.xlsx");
		if(downloadedfile.exists()) {
			softAssert.assertTrue(true);
		
		}
		else { 
			softAssert.assertTrue(false);
		}
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
		
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Export to XLS button on Credit payouts Page")
	public void verify_Export_credits_payout(String phoneOrEmail, String password) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOn_ViewStatement();
		CreditStatementTest.clickOn_ExporttoXLS();
		Thread.sleep(5000);
		File downloadedfile = new File("C:\\Users\\Apptad\\Downloads\\withdrawn-payouts.xlsx");
		if(downloadedfile.exists()) {
			softAssert.assertTrue(true);
		
		}
		else { 
			softAssert.assertTrue(false);
		}
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
		
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify paying Task Credit Type Amount ")
	public void verify_paying_cash_credit(String phoneOrEmail, String password, String Mobilenumber, String UPIID, String expectedmessage, String expectedmessage1) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOnbtn_Pay();
		CreditStatementTest.switchToFrame();
		CreditStatementTest.enterMobilenumber(Mobilenumber);
		CreditStatementTest.clickOnbtn_Continue();
		CreditStatementTest.clickOn_upi();
		CreditStatementTest.enterUPIID(UPIID);
		CreditStatementTest.clickOnbtn_verifyandpay();
		String actualMessage = CreditStatementTest.get_MessageForPaymentSuccessful();
		softAssert.assertEquals(actualMessage, expectedmessage);
		driver.switchTo().parentFrame();
		String actualMessage1 = CreditStatementTest.get_MessageForPaid();
		softAssert.assertEquals(actualMessage1, expectedmessage1);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify paying Cash Credit Type Amount ")
	public void verify_paying_Task_credit(String phoneOrEmail, String password, String Mobilenumber, String UPIID, String expectedmessage, String expectedmessage1) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOnbtn_Pay1();
		CreditStatementTest.switchToFrame();
		CreditStatementTest.enterMobilenumber(Mobilenumber);
		CreditStatementTest.clickOnbtn_Continue();
		CreditStatementTest.clickOn_upi();
		CreditStatementTest.enterUPIID(UPIID);
		CreditStatementTest.clickOnbtn_verifyandpay();
		String actualMessage = CreditStatementTest.get_MessageForPaymentSuccessful();
		softAssert.assertEquals(actualMessage, expectedmessage);
		driver.switchTo().parentFrame();
		String actualMessage1 = CreditStatementTest.get_MessageForPaid();
		softAssert.assertEquals(actualMessage1, expectedmessage1);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	
}
 