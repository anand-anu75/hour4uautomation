package testcase;

import java.util.Set;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddChampsWorkOrder;
import utilities.ReadXLData;

public class AddChampsWorkOrderTest extends BaseTest {

    private AddChampsWorkOrder addChampsWorkorder;

    /**
     * Test to add a Champ via Dashboard.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedSuccessMessage The expected success message after adding the Champ.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addChamp_via_dashBoard(String expectedSuccessMessage) {

        addChampsWorkorder = new AddChampsWorkOrder(driver);

        addChampsWorkorder.clickMoreOptions(); // Click on More Options
        addChampsWorkorder.clickAddChamps(); // Click to Add Champs

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        addChampsWorkorder.clickSelectChamp(); // Select a Champ
        addChampsWorkorder.clickSendReq(); // Send the Request

        // Assert success message
        String actualSuccessMessage = addChampsWorkorder.getSuccessMessage();
        softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        softAssert.assertAll(); // Final assertion check
    }

    /**
     * Test to add a Champ via Work Order.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedSuccessMessage The expected success message after adding the Champ.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addChamp_via_workOrder(String expectedSuccessMessage) {

        addChampsWorkorder = new AddChampsWorkOrder(driver);

        addChampsWorkorder.clickDesiredWorkOrder(); // Click on the desired Work Order
        addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        addChampsWorkorder.clickSelectChamp(); // Select a Champ
        addChampsWorkorder.clickSendReq(); // Send the Request

        // Assert success message
        String actualSuccessMessage = addChampsWorkorder.getSuccessMessage();
        softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        softAssert.assertAll(); // Final assertion check
    }

    /**
     * Test to add a Champ via View Task.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedSuccessMessage The expected success message after adding the Champ.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addChamp_via_ViewTask(String expectedSuccessMessage) {

        addChampsWorkorder = new AddChampsWorkOrder(driver);

        addChampsWorkorder.clickViewTask_btn(); // Click on View Task button

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        // Switch to the newly opened window
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        addChampsWorkorder.clickMoreOptions(); // Click on More Options
        addChampsWorkorder.clickAddChamps(); // Click to Add Champs

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        addChampsWorkorder.clickSelectChamp(); // Select a Champ
        addChampsWorkorder.clickSendReq(); // Send the Request

        // Assert success message
        String actualSuccessMessage = addChampsWorkorder.getSuccessMessage();
        softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        softAssert.assertAll(); // Final assertion check
    }

    /**
     * Test to add a Champ via Dashboard - Alternative Flow.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedSuccessMessage The expected success message after adding the Champ.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addChamp_via_dashBoard2(String expectedSuccessMessage) {

        addChampsWorkorder = new AddChampsWorkOrder(driver);

        addChampsWorkorder.clickMoreOptions(); // Click on More Options
        addChampsWorkorder.clickJobSeeker1(); // Click on the first Job Seeker

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        addChampsWorkorder.clickMoreOptions(); // Click on More Options again
        addChampsWorkorder.clickAddChamps(); // Click to Add Champs

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        addChampsWorkorder.clickSelectChamp(); // Select a Champ
        addChampsWorkorder.clickSendReq(); // Send the Request

        // Assert success message
        String actualSuccessMessage = addChampsWorkorder.getSuccessMessage();
        softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        softAssert.assertAll(); // Final assertion check
    }

    /**
     * Test for error scenario when adding a Champ via Dashboard.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedErrorMessage The expected error message after attempting to add the Champ.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addChamp_via_dashBoard_Error(String expectedErrorMessage) {

        addChampsWorkorder = new AddChampsWorkOrder(driver);

        addChampsWorkorder.clickMoreOptions(); // Click on More Options
        addChampsWorkorder.clickAddChamps(); // Click to Add Champs

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        addChampsWorkorder.clickSelectChamp(); // Select a Champ
        addChampsWorkorder.clickSendReq(); // Send the Request

        // Assert error message
        String actualErrorMessage = addChampsWorkorder.getErrorMessage();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);

        softAssert.assertAll(); // Final assertion check
    }

    /**
     * Test for error scenario when adding a Champ via Work Order.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedErrorMessage The expected error message after attempting to add the Champ.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addChamp_via_workOrder_Error(String expectedErrorMessage) {

        addChampsWorkorder = new AddChampsWorkOrder(driver);

        addChampsWorkorder.clickDesiredWorkOrder(); // Click on the desired Work Order
        addChampsWorkorder.clickAddChamps_btn(); // Click to Add Champs

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        addChampsWorkorder.clickSelectChamp(); // Select a Champ
        addChampsWorkorder.clickSendReq(); // Send the Request

        // Assert error message
        String actualErrorMessage = addChampsWorkorder.getErrorMessage();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);

        softAssert.assertAll(); // Final assertion check
    }

    /**
     * Test for error scenario when adding a Champ via View Task.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedErrorMessage The expected error message after attempting to add the Champ.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addChamp_via_ViewTask_Error(String expectedErrorMessage) {

        addChampsWorkorder = new AddChampsWorkOrder(driver);

        addChampsWorkorder.clickViewTask_btn(); // Click on View Task button

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        // Switch to the newly opened window
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        addChampsWorkorder.clickMoreOptions(); // Click on More Options
        addChampsWorkorder.clickAddChamps(); // Click to Add Champs

        // Wait for 5 seconds to allow any UI changes to take effect
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if sleep is interrupted
        }

        addChampsWorkorder.clickSelectChamp(); // Select a Champ
        addChampsWorkorder.clickSendReq(); // Send the Request

        // Assert error message
        String actualErrorMessage = addChampsWorkorder.getErrorMessage();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);

        softAssert.assertAll(); // Final assertion check
    }
}
