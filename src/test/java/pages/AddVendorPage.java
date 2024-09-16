package pages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;

public class AddVendorPage extends BaseTest {


	
	
//Locators that are being referenced from the locators.properties file
	
    WebElement btn_User;

    WebElement btn_Vendors;
    
    WebElement btn_AddVendor;
    
    WebElement dialog_box;
   
    WebElement input_VendorName;

    WebElement input_Mobile;

    WebElement input_Email;
    
    WebElement btn_AddVendorDialogue;
    
    WebElement btn_close;


    // Constructor to initialize the driver and web elements
    public AddVendorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on the User button
    public void clickOnUserButton() {
        WebElement btn_User = driver.findElement(By.xpath(loc.getProperty("btn_User_XPath")));
        wait.until(ExpectedConditions.visibilityOf(btn_User)).click();
    }

    // Method to click on the Vendors option
    public void clickOnVendorsOption() {
        WebElement btn_Vendors = driver.findElement(By.xpath(loc.getProperty("btn_Vendors_XPath")));
        wait.until(ExpectedConditions.visibilityOf(btn_Vendors)).click();
    }
    
    public void clickOnAddVendorButton() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_AddVendor_XPath"))));
    	addButton.click();
        
    }
    
    public void NavigateToDialogBox() {
        WebElement dialog_box = driver.findElement(By.xpath(loc.getProperty("dialog_box_XPath")));
        wait.until(ExpectedConditions.visibilityOf(dialog_box));
    }

    public void enterVendorName(String vendorName) {
        WebElement input_VendorName = driver.findElement(By.xpath(loc.getProperty("input_VendorName_XPath")));
        input_VendorName.sendKeys(vendorName);
    }

    public void enterMobileNumber(String mobile) {
        WebElement input_Mobile = driver.findElement(By.xpath(loc.getProperty("input_Mobile_XPath")));
        input_Mobile.sendKeys(mobile);
    }

    public void enterEmail(String email) {
        WebElement input_Email = driver.findElement(By.xpath(loc.getProperty("input_Email_XPath")));
        input_Email.sendKeys(email);
    }
    
	public void clickOnAddVendorDialogueButton() throws InterruptedException {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_AddVendorDialogue_XPath"))));
	    	addButton.click();
        
    }
	public void clickOnClose() {
	    WebElement btn_close = driver.findElement(By.xpath(loc.getProperty("btn_close_XPath")));
	    wait.until(ExpectedConditions.elementToBeClickable(btn_close)).click();
	}
}