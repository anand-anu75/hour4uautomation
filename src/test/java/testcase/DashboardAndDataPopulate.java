package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardAndDataPopulatePage;
import base.BaseTest;

public class DashboardAndDataPopulate extends BaseTest {

    @Test
    public void verifySelectDataRange() {
        DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);
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
    public void verifyWorkorders() {
        DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);
        String workorders = dashboardPage.getWorkordersText();
        Assert.assertEquals(workorders, "expected-workorders");
    }

    @Test
    public void verifyFulfilment() {
        DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);
        String fulfilment = dashboardPage.getFulfilmentText();
        Assert.assertEquals(fulfilment, "expected-fulfilment");
    }

    @Test
    public void verifyCompletedTasks() {
        DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);
        String completedTasks = dashboardPage.getCompletedTasksText();
        Assert.assertEquals(completedTasks, "expected-completed-tasks");
    }

    @Test
    public void verifyItemsPerPage() {
        DashboardAndDataPopulatePage dashboardPage = new DashboardAndDataPopulatePage(driver);
        dashboardPage.selectItemsPerPage("required-items");
        // Add assertion or validation here
    }
}
