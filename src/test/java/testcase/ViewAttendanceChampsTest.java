package testcase;

import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ViewAttendanceChamps;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class ViewAttendanceChampsTest extends BaseTest {
    private ViewAttendanceChamps viewAttendanceChamps;

    /**
     * Test method to verify dashboard navigation and message validation.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedMessage The expected message to validate after navigating.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void dashboard(String expectedMessage) {
        // Initialize the ViewAttendanceChamps object
        viewAttendanceChamps = new ViewAttendanceChamps(driver);

        // Click on More Options and Job Seeker 1
        viewAttendanceChamps.clickMoreOpt();
        viewAttendanceChamps.clickJobSeeker1();

        // Retrieve the actual message and validate it against the expected message
        String actualMessage = viewAttendanceChamps.getActualMessage();
        softAssert.assertEquals(actualMessage, expectedMessage);

        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }

    /**
     * Test method to verify view task functionality and message validation.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedMessage The expected message to validate after navigating.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void viewTask(String expectedMessage) {
        // Initialize the ViewAttendanceChamps object
        viewAttendanceChamps = new ViewAttendanceChamps(driver);

        // Click on View Task button
        viewAttendanceChamps.clickViewTask();

        // Switch to the newly opened window
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Click on More Options and Job Seeker 1 in the new window
        viewAttendanceChamps.clickMoreOpt();
        viewAttendanceChamps.clickJobSeeker1();

        // Retrieve the actual message and validate it against the expected message
        String actualMessage = viewAttendanceChamps.getActualMessage();
        softAssert.assertEquals(actualMessage, expectedMessage);

        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }

    /**
     * Test method to verify work order functionality and message validation.
     * This test depends on successful login and uses data from an Excel sheet.
     * 
     * @param expectedMessage The expected message to validate after navigating.
     */
    @Test(dependsOnMethods = "testcase.Login.login", dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void workOrder(String expectedMessage) {
        // Initialize the ViewAttendanceChamps object
        viewAttendanceChamps = new ViewAttendanceChamps(driver);

        // Perform the necessary actions for work order functionality
        viewAttendanceChamps.clickDesiredWorkOrder();

        // Click on More Options and Job Seeker 2
        viewAttendanceChamps.clickMoreOpt();
        viewAttendanceChamps.clickJobSeeker2();

        // Retrieve the actual message and validate it against the expected message
        String actualMessage = viewAttendanceChamps.getActualMessage();
        softAssert.assertEquals(actualMessage, expectedMessage);

        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }
}
