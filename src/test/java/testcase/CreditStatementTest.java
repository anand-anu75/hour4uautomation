package testcase;

import java.io.File;
import java.io.IOException;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CreditStatement;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class CreditStatementTest extends BaseTest {
	CreditStatement creditStatementTest;

	static String actualURL;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Requesting Cash Credit")
	public void verify_Req_cash_credit(String phoneOrEmail, String password, String amount, String Superadminemail,
			String Superadminpassword, String Verificationcode, String Expectedmessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		creditStatementTest = new CreditStatement(driver);

		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		creditStatementTest.enterPassword(password);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOnbtn_Topup();
		creditStatementTest.enteramount(amount);
		creditStatementTest.clickOnbtn_Paylater();
		creditStatementTest.clickOn_dropdown();
		creditStatementTest.clickOn_days();
		creditStatementTest.clickOn_checkbox();
		creditStatementTest.clickOnbtn_RequestCredits();
		creditStatementTest.clickOn_accounticon();
		creditStatementTest.clickOn_logout();
		creditStatementTest.enterSuperadminemail(Superadminemail);
		creditStatementTest.enterSuperadminpassword(Superadminpassword);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOn_approve();
		creditStatementTest.enterverificationcode(Verificationcode);
		creditStatementTest.clickOn_Next();
		String actualMessage = creditStatementTest.get_MessageForCreditstatus();

		try {
			softAssert.assertEquals(actualMessage, Expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Requesting Task Credit")
	public void verify_Req_Task_credit(String phoneOrEmail, String password, String amount, String Superadminemail,
			String Superadminpassword, String Verificationcode, String Expectedmessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		creditStatementTest = new CreditStatement(driver);

		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		creditStatementTest.enterPassword(password);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOnbtn_Topup1();
		creditStatementTest.enteramount(amount);
		creditStatementTest.clickOnbtn_Paylater();
		creditStatementTest.clickOn_dropdown();
		creditStatementTest.clickOn_days();
		creditStatementTest.clickOn_checkbox();
		creditStatementTest.clickOnbtn_RequestCredits();
		creditStatementTest.clickOn_accounticon();
		creditStatementTest.clickOn_logout();
		creditStatementTest.enterSuperadminemail(Superadminemail);
		creditStatementTest.enterSuperadminpassword(Superadminpassword);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOn_approve();
		creditStatementTest.enterverificationcode(Verificationcode);
		creditStatementTest.clickOn_Next();
		String actualMessage = creditStatementTest.get_MessageForCreditstatus();

		try {
			softAssert.assertEquals(actualMessage, Expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify View Statement button")
	public void verify_view_statement(String phoneOrEmail, String password, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		creditStatementTest = new CreditStatement(driver);

		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		creditStatementTest.enterPassword(password);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOn_ViewStatement();
		actualURL = driver.getCurrentUrl();

		try {
			softAssert.assertEquals(actualURL, expectedURL);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Export to XLS button on Credits Page")
	public void verify_Export_credits_page(String phoneOrEmail, String password)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		creditStatementTest = new CreditStatement(driver);
		creditStatementTest.deleteExistingCreditFile();
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		creditStatementTest.enterPassword(password);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOn_ExporttoXLS();

		try {
			boolean value = creditStatementTest.checkCreditFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Export to XLS button on Credit payouts Page")
	public void verify_Export_credits_payout(String phoneOrEmail, String password)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		creditStatementTest = new CreditStatement(driver);

		creditStatementTest.deleteExistingWithdrawnFile();
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		creditStatementTest.enterPassword(password);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOn_ViewStatement();
		creditStatementTest.clickOn_ExporttoXLS();

		try {
			boolean value = creditStatementTest.checkwithdrawnFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify paying Task Credit Type Amount ")
	public void verify_paying_cash_credit(String phoneOrEmail, String password, String Mobilenumber, String UPIID,
			String expectedmessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		creditStatementTest = new CreditStatement(driver);

		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		creditStatementTest.enterPassword(password);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOnbtn_Pay();
		creditStatementTest.navigateToPaymentFrame();
		creditStatementTest.enterMobilenumber(Mobilenumber);
		creditStatementTest.clickOnbtn_Continue();
		creditStatementTest.clickOn_upi();
		creditStatementTest.enterUPIID(UPIID);
		creditStatementTest.clickOnbtn_verifyandpay();
		String actualMessage = creditStatementTest.get_MessageForPaymentSuccessful();

		try {
			softAssert.assertEquals(actualMessage, expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify paying Cash Credit Type Amount ")
	public void verify_paying_Task_credit(String phoneOrEmail, String password, String Mobilenumber, String UPIID,
			String expectedmessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		creditStatementTest = new CreditStatement(driver);

		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		creditStatementTest.enterPassword(password);
		creditStatementTest.clickOnBtn_Login();
		creditStatementTest.clickOnbtn_Credits();
		creditStatementTest.clickOnbtn_Pay1();
		creditStatementTest.navigateToPaymentFrame();
		creditStatementTest.enterMobilenumber(Mobilenumber);
		creditStatementTest.clickOnbtn_Continue();
		creditStatementTest.clickOn_upi();
		creditStatementTest.enterUPIID(UPIID);
		creditStatementTest.clickOnbtn_verifyandpay();
		String actualMessage = creditStatementTest.get_MessageForPaymentSuccessful();

		try {
			softAssert.assertEquals(actualMessage, expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

}
