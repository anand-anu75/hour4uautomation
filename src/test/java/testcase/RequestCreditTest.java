package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RequestCredit;
import base.BaseTest;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class RequestCreditTest extends BaseTest {
    private RequestCredit requestCredit;

    /**
     * Test to validate the behavior when requesting cash credit.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param Email                The email address used for login.
     * @param Password             The password used for login.
     * @param CreditAmount         The amount of credit to request.
     * @param expectedConfirmAmount The expected confirmation amount after request.
     * @param expectedPaymentStatus The expected payment status after request.
     * @param expectedCreditStatus The expected credit status after request.
     * @param expectedCreditType   The expected type of credit after request.
     */
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void RequestCredit(String Email, String Password, String CreditAmount, String expectedConfirmAmount, String expectedPaymentStatus, String expectedCreditStatus, String expectedCreditType) {
        // Initialize RequestCredit page object
        requestCredit = new RequestCredit(driver);

        // Perform login steps
        requestCredit.enterEmail(Email);
        requestCredit.enterPassword(Password);
        requestCredit.clickLoginButton();

        // Navigate to the cash credit request section
        requestCredit.clickCreditButton();
        requestCredit.clickcashCreditButton();

        // Enter credit amount and proceed with payment options
        requestCredit.enterCreditAmount(CreditAmount);
        requestCredit.clickPayLaterButton();
        requestCredit.clickDropdown();
        requestCredit.clickDropdownOption();

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        // Interact with the checkbox and request credit
        requestCredit.clickCheckBox();

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        // Submit the credit request
        requestCredit.clickRequestCredit();

        // Wait for 2 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        // Assert that the actual results match the expected values
        String ActualConfirmAmount = requestCredit.getConfirmAmount();
        String ActualPaymentStatus = requestCredit.getPaymentStatus();
        String ActualCreditStatus = requestCredit.getCreditStatus();
        String ActualCreditType = requestCredit.getCreditType();

        softAssert.assertEquals(ActualConfirmAmount, expectedConfirmAmount);
        softAssert.assertEquals(ActualPaymentStatus, expectedPaymentStatus);
        softAssert.assertEquals(ActualCreditStatus, expectedCreditStatus);
        softAssert.assertEquals(ActualCreditType, expectedCreditType);

        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

    }

    /**
     * Test to validate the behavior when requesting task credit.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param Email                The email address used for login.
     * @param Password             The password used for login.
     * @param CreditAmount         The amount of credit to request.
     * @param expectedConfirmAmount The expected confirmation amount after request.
     * @param expectedPaymentStatus The expected payment status after request.
     * @param expectedCreditStatus The expected credit status after request.
     * @param expectedCreditType   The expected type of credit after request.
     */
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void TaskCredit(String Email, String Password, String CreditAmount, String expectedConfirmAmount, String expectedPaymentStatus, String expectedCreditStatus, String expectedCreditType) {
        // Initialize RequestCredit page object
        requestCredit = new RequestCredit(driver);

        // Perform login steps
        requestCredit.enterEmail(Email);
        requestCredit.enterPassword(Password);
        requestCredit.clickLoginButton();

        // Navigate to the task credit request section
        requestCredit.clickCreditButton();
        requestCredit.clickTaskCredit();

        // Enter credit amount and proceed with payment options
        requestCredit.enterCreditAmount(CreditAmount);
        requestCredit.clickPayLaterButton();
        requestCredit.clickDropdown();
        requestCredit.clickDropdownOption();

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        // Interact with the checkbox and request credit
        requestCredit.clickCheckBox();

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        // Submit the credit request
        requestCredit.clickRequestCredit();

        // Assert that the actual results match the expected values
        String ActualConfirmAmount = requestCredit.getConfirmAmount();
        String ActualPaymentStatus = requestCredit.getPaymentStatus();
        String ActualCreditStatus = requestCredit.getCreditStatus();
        String ActualCreditType = requestCredit.getCreditTypeTask();

        softAssert.assertEquals(ActualConfirmAmount, expectedConfirmAmount);
        softAssert.assertEquals(ActualPaymentStatus, expectedPaymentStatus);
        softAssert.assertEquals(ActualCreditStatus, expectedCreditStatus);
        softAssert.assertEquals(ActualCreditType, expectedCreditType);

        try {
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
