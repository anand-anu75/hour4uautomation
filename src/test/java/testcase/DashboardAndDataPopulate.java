package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashboardAndDataPopulatePage;
import base.BaseTest;

public class DashboardAndDataPopulate extends BaseTest {

	// Global variables to store initial values
    private String initialWorkorders;
    private String initialFulfilment;
    private String initialCompletedTasks;
    private String initialPaginatorRange;
    

    // Method to capture initial values before applying any filter
    private void storeInitialValues(DashboardAndDataPopulatePage dashboardPage) {
        initialWorkorders = dashboardPage.getWorkordersText();
        initialFulfilment = dashboardPage.getFulfilmentText();
        initialCompletedTasks = dashboardPage.getCompletedTasksText();
        
    }

    // Method to capture new values after applying filters
    private String[] getNewValues(DashboardAndDataPopulatePage dashboardPage) {
        String newWorkorders = dashboardPage.getWorkordersText();
        String newFulfilment = dashboardPage.getFulfilmentText();
        String newCompletedTasks = dashboardPage.getCompletedTasksText();
        return new String[]{newWorkorders, newFulfilment, newCompletedTasks};
    }
	
	
	@Test
    public void verifySelectDataRange() {
        DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);
        storeInitialValues(dashboardPage);
        dashboardPage.clickOnSelectDataRange();
        dashboardPage.selectThisMonth(); // Select "This Month" from the dropdown
        
        
        // Add assertion or validation here
    }

    @Test
    public void verifyStatusFilter() {
        DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);
        dashboardPage.clickOnStatusFilter();
        dashboardPage.selectActiveStatus(); // Select "Active" from the Status filter dropdown
        dashboardPage.clickOnPageToCloseDropdown();
        dashboardPage.clickOnCityFilter();
        dashboardPage.selectCityDelhi();
        dashboardPage.clickOnPageToCloseDropdown();
        // Add assertion or validation here
    }

    @Test
    public void verifyWorkordersFulfilmentsTasks() {
    	DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);

        // Ensure initial values are stored
        if (initialWorkorders == null || initialFulfilment == null || initialCompletedTasks == null) {
            storeInitialValues(dashboardPage);
        }

        // Capture new values after applying filters or other operations
        String[] newValues = getNewValues(dashboardPage);

        // Perform soft assertions to verify that the values have changed
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(newValues[0], initialWorkorders, "Workorders should change after applying the filter.");
        softAssert.assertNotEquals(newValues[1], initialFulfilment, "Fulfilment should change after applying the filter.");
        softAssert.assertNotEquals(newValues[2], initialCompletedTasks, "Completed Tasks should change after applying the filter.");
        
        // Execute all soft assertions
        softAssert.assertAll();
    }

    
    @Test
    public void verifyItemsPerPage() {
        DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);
        
        // Step 1: Refresh the page
        //driver.navigate().refresh();

        // Step 2: Store the initial paginator range value
        initialPaginatorRange = dashboardPage.getPaginatorRangeText();

        // Step 3: Click on the third mat-select value and select "20" from the dropdown
        dashboardPage.clickOnThirdMatSelectValue();
        dashboardPage.selectOptionTwenty();

        // Step 4: Get the new paginator range value after selecting 20 items per page
        String newPaginatorRange = dashboardPage.getPaginatorRangeText();

        // Step 5: Perform soft assertion to verify that the paginator range has changed
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(newPaginatorRange, initialPaginatorRange, "Paginator range should change after selecting 20 items per page.");
        
        // Execute all soft assertions
        softAssert.assertAll();
    }
}
