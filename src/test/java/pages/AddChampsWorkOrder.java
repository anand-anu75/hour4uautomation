package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class AddChampsWorkOrder extends BaseTest {
    
     JavascriptExecutor jsExecutor;
     WebElement btn_inviteChamp;
     WebElement moreWorkorder;
     WebElement AddChampsDash;
     WebElement SelectChamps;
     WebElement SendReqButton;
     WebElement ChampAddedMessage;
     WebElement JobSeekerScheduledash;
    
    // Constructor
    public AddChampsWorkOrder(WebDriver driver) {
        BaseTest.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click the "More Options" button
    public void clickMoreOptions() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("moreWorkorder")))).click();
    }
    
    // Method to click the "Add Champs" button
    public void clickAddChamps() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("AddChampsDash")))).click();
    }
    
    // Method to click the "Select Champs" button
    public void clickSelectChamp() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("SelectChamps")))).click();
    }
    
    // Method to click the "Send Request" button
    public void clickSendReq() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("SendReqButton")))).click();
    }
    
    // Method to get the success message after adding a champ
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ChampAddedMessage")))).getText();
    }
    
    // Method to get the error message (assuming the same element as success message)
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ChampAddedMessage")))).getText();
    }
    
    // Method to click the "Desired Work Order" button
    public void clickDesiredWorkOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("desiredWorkorder")))).click();
    }

    // Method to click the "Add Champ" button in the work order
    public void clickAddChamps_btn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("AddChampButton")))).click();
    }
    
    // Method to click the "View Task" button
    public void clickViewTask_btn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("viewTasksButton")))).click();
    }
    
    // Method to click the "Job Seeker" button on the dashboard
    public void clickJobSeeker1() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("JobSeekerScheduledash")))).click();
    }
}
