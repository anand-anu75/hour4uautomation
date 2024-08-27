package testcase;

import org.testng.annotations.Test;
import pages.RequestCredit;
import base.BaseTest;

import utilities.ReadXLData;

public class RequestCreditTest extends BaseTest {
	private RequestCredit requestCredit;
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void RequestCredit(String Email, String Password, String CreditAmount) {
		requestCredit = new RequestCredit(driver);
		requestCredit.enterEmail(Email);
		requestCredit.enterPassword(Password);
		requestCredit.clickLoginButton();
        requestCredit.clickCreditButton();
        requestCredit.clickcashCreditButton();
        requestCredit.enterCreditAmount(CreditAmount);
        requestCredit.clickPayLaterButton();
    }
}
