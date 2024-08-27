package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.AddChamps;
import utilities.ReadXLData;
import base.BaseTest;

public class AddChampsTest extends BaseTest {

    private AddChamps addChamps;

    /**
     * Test to add a champ with valid data.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param Name                  The name of the champ.
     * @param Phone                 The phone number of the champ.
     * @param expectedSuccessMessage The expected success message after adding the champ.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addChamp_with_valid_data(String Name, String Phone, String expectedSuccessMessage) {
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
        softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        softAssert.assertAll();
    }

    /**
     * Test to validate behavior when an invalid phone number is entered.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param Name                 The name of the champ.
     * @param InvalidPhone         The invalid phone number to be tested.
     * @param expectedErrorMessage The expected error message for the invalid phone number.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void validate_for_invalid_phone_num(String Name, String InvalidPhone, String expectedErrorMessage) {
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

        softAssert.assertAll();
    }

    /**
     * Test to validate behavior when an invalid name is entered.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param InvalidName           The invalid name to be tested.
     * @param Phone                 The phone number of the champ.
     * @param expectedErrorMessage  The expected error message for the invalid name.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void validate_invalid_name(String InvalidName, String Phone, String expectedErrorMessage) {
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
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);

        softAssert.assertAll();
    }
}
