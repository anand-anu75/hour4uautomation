package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ViewAttendanceChamps extends BaseTest {

     JavascriptExecutor jsExecutor;
     WebElement workorderButton;
     WebElement moreWorkorder;
     WebElement JobSeekerSchedule;
     WebElement viewTaskButton;
     WebElement desiredWorkorder;
     WebElement viewTasksButton;

    // Constructor
    public ViewAttendanceChamps(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click the "Workorder" button
    public void clickWorkorderBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("workorderButton")))).click();
    }

    // Method to click the "More Options" button
    public void clickMoreOpt() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("moreWorkorder")))).click();
    }

    // Method to click the "Job Seeker" button on the dashboard
    public void clickJobSeeker1() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("JobSeekerScheduledash")))).click();
    }

    // Method to click the "Job Seeker" button on the work orbit
    public void clickJobSeeker2() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("JobSeekerScheduleWorkOrbit")))).click();
    }

    // Method to click the "View Task" button
    public void clickViewTask() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("viewTasksButton")))).click();
    }

    // Method to click the "Desired Work Order" button
    public void clickDesiredWorkOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("desiredWorkorder")))).click();
    }

    // Method to get the actual message for an invalid phone number
    public String getActualMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("JobSeekerText")))).getText();
    }
}
