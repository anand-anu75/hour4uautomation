package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AddChamps;
import utilities.ReadXLData;
import base.BaseTest;

@Listeners(base.Listeners.class)
public class AddChampsTest extends BaseTest {

	private AddChamps addChamps;
	Login loginObject = new Login();

	/**
	 * Test to add a champ with valid data. This test depends on successful login
	 * and uses data from an Excel sheet.
	 * 
	 * @param Name                   The name of the champ.
	 * @param Phone                  The phone number of the champ.
	 * @param expectedSuccessMessage The expected success message after adding the
	 *                               champ.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void addChamp_with_valid_data(String phoneOrEmail, String OTP, String expectedURL, String Name, String Phone,
			String expectedSuccessMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		addChamps = new AddChamps(driver);

		// Navigate to the relevant sections
		addChamps.navigateToUsersSection();
		addChamps.navigateToChampsSection();

		// Fill in champ details and submit
		addChamps.clickInviteChamp();
		addChamps.enterChampionName(Name);
		addChamps.enterChampionNumber(Phone);
		addChamps.clickAddChamp();

		// Assert that the success message is as expected
		String actualSuccessMessage = addChamps.getSuccessMessage();

		try {
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	}

	/**
	 * Test to validate behavior when an invalid phone number is entered. This test
	 * depends on successful login and uses data from an Excel sheet.
	 * 
	 * @param Name                 The name of the champ.
	 * @param InvalidPhone         The invalid phone number to be tested.
	 * @param expectedErrorMessage The expected error message for the invalid phone
	 *                             number.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void validate_for_invalid_phone_num(String phoneOrEmail, String OTP, String expectedURL, String Name,
			String InvalidPhone, String expectedErrorMessage) throws InterruptedException, IOException {
		loginObject.login(phoneOrEmail, OTP, expectedURL);

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		addChamps = new AddChamps(driver);

		// Navigate to the relevant sections
		addChamps.navigateToUsersSection();
		addChamps.navigateToChampsSection();

		// Enter details with invalid phone number and submit
		addChamps.clickInviteChamp();
		addChamps.enterChampionName(Name);
		addChamps.enterChampionNumber(InvalidPhone);
		addChamps.clickAddChamp();

		// Assert that the error message is as expected
		String actualErrorMessage = addChamps.getErrorMessageForInvalidPhoneNumber();
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);

		// Close the error message dialog
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[text()='close']"))).click();

		// Navigate back to the Users section
		addChamps.navigateToUsersSection();

		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

	/**
	 * Test to validate behavior when an invalid name is entered. This test depends
	 * on successful login and uses data from an Excel sheet.
	 * 
	 * @param InvalidName          The invalid name to be tested.
	 * @param Phone                The phone number of the champ.
	 * @param expectedErrorMessage The expected error message for the invalid name.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void validate_invalid_name(String phoneOrEmail, String OTP, String expectedURL, String InvalidName,
			String Phone, String expectedErrorMessage) throws InterruptedException, IOException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		loginObject.login(phoneOrEmail, OTP, expectedURL);
		addChamps = new AddChamps(driver);

		// Navigate to the relevant sections
		addChamps.navigateToUsersSection();
		addChamps.navigateToChampsSection();

		// Enter details with invalid name and submit
		addChamps.clickInviteChamp();
		addChamps.enterChampionName(InvalidName);
		addChamps.enterChampionNumber(Phone);
		addChamps.clickAddChamp();

		// Assert that the error message is as expected
		String actualErrorMessage = addChamps.getErrorMessageForInvalidName();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}
}
