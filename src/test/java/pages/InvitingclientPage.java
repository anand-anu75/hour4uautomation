package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;
import pages.CreateProjectPage.RandomGeneratorUtil;

public class InvitingclientPage extends BaseTest {
 


    WebElement btn_User;
    WebElement btn_Clients;
    WebElement btn_InviteClient;
    WebElement dialog_box;
    WebElement input_ClientName; 
    WebElement input_Mobile;
    WebElement input_Email;    
    WebElement input_Address;   
    WebElement btn_CreateClient;
 

    // Constructor to initialize the driver and web elements
    public InvitingclientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void clickOnUserButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_User"))))
 		.click();
     }
 
    public void clickOnClientsOption() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Clients"))))
 		.click();
     }
    
    public void clickOnInviteClientButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_InviteClient"))))
 		.click();
     }
  
    public void NavigateToDialogBox() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("dialog_box"))))
 		.click();
     }
 
    public void enterClientName(String clientName) {
    	input_ClientName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_ClientName"))));
    	input_ClientName.click(); // Clicking the input field before sending keys, if required
    	input_ClientName.sendKeys(clientName);
    }
    
    public static String generateRandomCompanyName(String companyName) {
        return companyName + (int) (Math.random() * 1000); // Generates a random number between 0 and 999
    }
    
    public static String generateRandomPersonName(String personName) {
        return personName + (int) (Math.random() * 1000); // Generates a random number between 0 and 999
    }
 
    public void enterContactPersonName(String ContactPersonName) {
    	input_Mobile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_Mobile"))));
    	input_Mobile.click();
    	// Clicking the input field before sending keys, if required
    	
    	input_Mobile.sendKeys(ContactPersonName);
    }
	
    public void enterEmail(String Email) {
    	input_Email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_Email"))));
    	input_Email.click();
    	// Clicking the input field before sending keys, if required
    	String randomEmail = RandomGeneratorUtil.generateRandomEmail(Email);
    	
    	input_Email.sendKeys(randomEmail);
    	
    }
    public void enterContactPersonPhone(String Phone) {
    	input_Address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_Address"))));
    	input_Address.click(); // Clicking the input field before sending keys, if required
    	String randomPhone = RandomGeneratorUtil.generateRandomPhoneNumber();
    	input_Address.sendKeys(randomPhone);
    }
	
	public void clickOnCreateClientButton() {
        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_CreateClient"))))
 		.click();
     }
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("successMessageClient")))).getText();
    }
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidNameClient")))).getText();
    }
    public String getPhoneErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidPhone")))).getText();
    }
    public String getEmailErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidEmail")))).getText();
    }
  
}