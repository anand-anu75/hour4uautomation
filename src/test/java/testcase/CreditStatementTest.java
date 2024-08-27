package testcase;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreditStatement;
import utilities.ReadXLData;

public class CreditStatementTest extends BaseTest {
	CreditStatement CreditStatementTest;
	
	static String actualURL;
	
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void enterprise(String phoneOrEmail, String password, String amount, String Superadminemail, String Superadminpassword, String Verificationcode, String Expectedmessage) throws InterruptedException, IOException {
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
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void enterprise1(String phoneOrEmail, String password, String amount, String Superadminemail, String Superadminpassword, String Verificationcode, String Expectedmessage) throws InterruptedException, IOException {
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
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void enterprise2(String phoneOrEmail, String password, String expectedURL) throws InterruptedException, IOException {
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
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void enterprise3(String phoneOrEmail, String password) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOn_ExporttoXLS();
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void enterprise4(String phoneOrEmail, String password) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOn_ViewStatement();
		CreditStatementTest.clickOn_ExporttoXLS();
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void enterprise5(String phoneOrEmail, String password, String Mobilenumber, String UPIID, String expectedmessage) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOnbtn_Pay();
		WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='razorpay-checkout-frame']")));
		driver.switchTo().frame(frame);
		CreditStatementTest.enterMobilenumber(Mobilenumber);
		CreditStatementTest.clickOnbtn_Continue();
		CreditStatementTest.clickOn_upi();
		CreditStatementTest.enterUPIID(UPIID);
		CreditStatementTest.clickOnbtn_verifyandpay();
		String actualMessage = CreditStatementTest.get_MessageForPaymentSuccessful();
		softAssert.assertEquals(actualMessage, expectedmessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void enterprise6(String phoneOrEmail, String password, String Mobilenumber, String UPIID, String expectedmessage) throws InterruptedException, IOException {
		CreditStatementTest = new CreditStatement(driver);
		
		
		CreditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		CreditStatementTest.enterPassword(password);
		CreditStatementTest.clickOnBtn_Login();
		CreditStatementTest.clickOnbtn_Credits();
		CreditStatementTest.clickOnbtn_Pay1();
		WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='razorpay-checkout-frame']")));
		driver.switchTo().frame(frame);
		CreditStatementTest.enterMobilenumber(Mobilenumber);
		CreditStatementTest.clickOnbtn_Continue();
		CreditStatementTest.clickOn_upi();
		CreditStatementTest.enterUPIID(UPIID);
		CreditStatementTest.clickOnbtn_verifyandpay();
		String actualMessage = CreditStatementTest.get_MessageForPaymentSuccessful();
		softAssert.assertEquals(actualMessage, expectedmessage);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}
	
}
 