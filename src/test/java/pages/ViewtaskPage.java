package pages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;
 
public class ViewtaskPage extends BaseTest {
 

    WebElement btn_Workorder;

    WebElement btn_ViewTasks;  
       
    WebElement btn_addTasks;
    
    WebElement btn_selectjobseeker;
    
    WebElement btn_Selectchamp;
    
    WebElement txt_textfield;
    
    WebElement input_enterTextField;
    
    WebElement btn_submitBtn;


    // Constructor to initialize the driver and web elements
    public ViewtaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void clickOnWorkorderButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Workorder"))))
 		.click();
     }
 
    public void clickOnViewTasksButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ViewTasks"))))
 		.click();
     }
    
    public void clickOnaddTasksButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_addTasks"))))
 		.click();
 		
     }
    
    public void clickOnselectjobseekerButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_selectjobseeker"))))
 		.click();
     }
    
    
    public void clickOnSelectchampButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Selectchamp"))))
 		.click();
     }
    
    public void clickOntextfieldButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_textfield"))))
 		.click();
     }
    
    public void enterTextField(String TextField) {
    	input_enterTextField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_enterTextField"))));
    	input_enterTextField.click(); // Clicking the input field before sending keys, if required
    	input_enterTextField.sendKeys(TextField);
	    }
    
    public void clickOnsubmitButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_submitBtn"))))
 		.click();
     }
   
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("successMessageXpath")))).getText();
    }
    /*public void NavigatetoNewTab() {
    	String originalWindow = driver.getWindowHandle();


    	Set<String> allWindows = driver.getWindowHandles();
    	 


    	for (String windowHandle : allWindows) {

    	    if (!windowHandle.equals(originalWindow)) {

    	        driver.switchTo().window(windowHandle);

    	        break;

    	    }

    	}
    	 
	}
*/ 

}