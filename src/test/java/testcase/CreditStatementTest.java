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

		//login with enterprise email and password
		creditStatementTest = new CreditStatement(driver);

		//Enter valid phone or email
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		
		//Enter password
		creditStatementTest.enterPassword(password);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on cash credit Topup button
		creditStatementTest.clickOnbtn_Topup();
		
		//Enter Amount
		creditStatementTest.enteramount(amount);
		
		//click on pay later button
		creditStatementTest.clickOnbtn_Paylater();
		
		//click on dropdown
		creditStatementTest.clickOn_DropDown_Option();
		
		//click on Days
		creditStatementTest.clickOn_days();
		
		//Tick the checkbox
		creditStatementTest.clickOn_checkbox();
		
		//click on Request credits button
		creditStatementTest.clickOnbtn_RequestCredits();
		
		//click on Account icon
		creditStatementTest.clickOn_accounticon();
		
		//click on logout
		creditStatementTest.clickOn_logout();
		
		//Enter Superadmin Email ID
		creditStatementTest.enterSuperadminemail(Superadminemail);
		
		//Enter Superadmin password
		creditStatementTest.enterSuperadminpassword(Superadminpassword);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on Approve
		creditStatementTest.clickOn_approve();
		
		//Enter six digit verification code
		creditStatementTest.enterverificationcode(Verificationcode);
		
		//click on Next
		creditStatementTest.clickOn_Next();
		
		//Fetch success message for cash credit status
		String actualMessage = creditStatementTest.get_MessageForCreditstatus();

		//Verify success message for credit status
		try {
			softAssert.assertEquals(actualMessage, Expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Requesting Task Credit")
	public void verify_Req_Task_credit(String phoneOrEmail, String password, String amount, String Superadminemail,
			String Superadminpassword, String Verificationcode, String Expectedmessage)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		//login with enterprise email and password
		creditStatementTest = new CreditStatement(driver);

		//Enter valid phone or email
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		
		//Enter password
		creditStatementTest.enterPassword(password);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on Task credit Topup button
		creditStatementTest.clickOnbtn_Topup1();
		
		//Enter Amount
		creditStatementTest.enteramount(amount);
		
		//click on pay later button
		creditStatementTest.clickOnbtn_Paylater();
		
		//click on dropdown
		creditStatementTest.clickOn_DropDown_Option();
		
		//click on Days
		creditStatementTest.clickOn_days();
		
		//Tick the checkbox
		creditStatementTest.clickOn_checkbox();
		
		//click on Request credits button
		creditStatementTest.clickOnbtn_RequestCredits();
		
		//click on Account icon
		creditStatementTest.clickOn_accounticon();
		
		//click on logout
		creditStatementTest.clickOn_logout();
		
		//Enter Superadmin Email ID
		creditStatementTest.enterSuperadminemail(Superadminemail);
		
		//Enter Superadmin password
		creditStatementTest.enterSuperadminpassword(Superadminpassword);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on Approve
		creditStatementTest.clickOn_approve();
		
		//Enter six digit verification code
		creditStatementTest.enterverificationcode(Verificationcode);
		
		//click on Next
		creditStatementTest.clickOn_Next();
		
		//Fetch success message for Task credit status
		String actualMessage = creditStatementTest.get_MessageForCreditstatus();

		//Verify success message for Task credit status
		try {
			softAssert.assertEquals(actualMessage, Expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify View Statement button")
	public void verify_view_statement(String phoneOrEmail, String password, String expectedURL)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		//login with enterprise email and password
		creditStatementTest = new CreditStatement(driver);
		
		//Enter valid phone or email
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		
		//Enter password
		creditStatementTest.enterPassword(password);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on view statement
		creditStatementTest.clickOn_ViewStatement();
		
		//Get the current URL
		actualURL = driver.getCurrentUrl();

		//Verify with the current URL
		try {
			softAssert.assertEquals(actualURL, expectedURL);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Export to XLS button on Credits Page")
	public void verify_Export_credits_page(String phoneOrEmail, String password)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		//login with enterprise email and password
		creditStatementTest = new CreditStatement(driver);
		
		//Delete the existing file
		creditStatementTest.deleteExistingCreditFile();
		
		//Enter valid phone or email
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		
		//Enter password
		creditStatementTest.enterPassword(password);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on Export XLS
		creditStatementTest.clickOn_ExporttoXLS();

		// Ensure that the credit list file has been successfully downloaded
        try {
			boolean value = creditStatementTest.checkCreditFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Export to XLS button on Credit payouts Page")
	public void verify_Export_credits_payout(String phoneOrEmail, String password)
			throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		//login with enterprise email and password
		creditStatementTest = new CreditStatement(driver);

		//Delete the existing file
		creditStatementTest.deleteExistingWithdrawnFile();
		
		//Enter valid phone or email
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		
		//Enter password
		creditStatementTest.enterPassword(password);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on view statement
		creditStatementTest.clickOn_ViewStatement();
		
		//click on Export XLS
		creditStatementTest.clickOn_ExporttoXLS();

		// Ensure that the withdrawn payouts file has been successfully downloaded
		try {
			boolean value = creditStatementTest.checkwithdrawnFileDownload();
			softAssert.assertTrue(value);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify paying Task Credit Type Amount ")
	public void verify_paying_cash_credit(String phoneOrEmail, String password, String Mobilenumber, String UPIID,
			String expectedmessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		//login with enterprise email and password
		creditStatementTest = new CreditStatement(driver);

		//Enter valid phone or email
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		
		//Enter password
		creditStatementTest.enterPassword(password);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on pay button
		creditStatementTest.clickOnbtn_Pay();
		
		//Navigate to payment frame
		creditStatementTest.navigateToPaymentFrame();
		
		//enter Mobile Number
		creditStatementTest.enterMobilenumber(Mobilenumber);
		
		//click on continue button
		creditStatementTest.clickOnbtn_Continue();
		
		//click on UPI
		creditStatementTest.clickOn_upi();
		
		//Enter UPI ID
		creditStatementTest.enterUPIID(UPIID);
		
		//click on Verify and pay button
		creditStatementTest.clickOnbtn_verifyandpay();
		
		// Handle successful payment response
        String actualMessage = creditStatementTest.get_MessageForPaymentSuccessful();

        // Check if the payment response contains a success message
        try {
			softAssert.assertEquals(actualMessage, expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify paying Cash Credit Type Amount ")
	public void verify_paying_Task_credit(String phoneOrEmail, String password, String Mobilenumber, String UPIID,
			String expectedmessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		//login with enterprise email and password
		creditStatementTest = new CreditStatement(driver);
		
		//Enter valid phone or email
		creditStatementTest.enterPhoneOrEmail(phoneOrEmail);
		
		//Enter password
		creditStatementTest.enterPassword(password);
		
		//click on login button
		creditStatementTest.clickOnBtn_Login();
		
		//click on credits button
		creditStatementTest.clickOnbtn_Credits();
		
		//click on pay button
		creditStatementTest.clickOnbtn_Pay1();
		
		//Navigate to payment frame
		creditStatementTest.navigateToPaymentFrame();
		
		//enter Mobile Number
		creditStatementTest.enterMobilenumber(Mobilenumber);
		
		//click on continue button
		creditStatementTest.clickOnbtn_Continue();
		
		//click on UPI
		creditStatementTest.clickOn_upi();
		
		//Enter UPI ID
		creditStatementTest.enterUPIID(UPIID);
		
		//click on Verify and pay button
		creditStatementTest.clickOnbtn_verifyandpay();
		
		// Handle successful payment response
		String actualMessage = creditStatementTest.get_MessageForPaymentSuccessful();

		 // Check if the payment response contains a success message
		try {
			softAssert.assertEquals(actualMessage, expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

}

