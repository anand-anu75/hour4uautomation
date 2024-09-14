package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class RequestCredit extends BaseTest{
	
	 JavascriptExecutor jsExecutor;
	    WebElement CreditsButton;
	    WebElement InputPhoneOrEmail;
	    WebElement InputPassword;
	    WebElement EnterCreditAmount;
	    
	 // Constructor
	    public RequestCredit(WebDriver driver) {
	        this.driver = driver;
	        this.jsExecutor = (JavascriptExecutor) driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Method to enter the email
	    public void enterEmail(String Email) {
	        InputPhoneOrEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputPhoneOrEmail"))));
	        InputPhoneOrEmail.click();
	        InputPhoneOrEmail.sendKeys(Email);
	    }

	    // Method to enter the password
	    public void enterPassword(String Password) {
	        InputPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputPassword"))));
	        InputPassword.click();
	        InputPassword.sendKeys(Password);
	    }

	    // Method to click the "Login" button
	    public void clickLoginButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("LoginButton")))).click();
	    }

	    // Method to click the "Credit" button
	    public void clickCreditButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("CreditsButton")))).click();
	    }
	    
	    // Method to click the "Cash Credit" button
	    public void clickcashCreditButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("ClickCashCreditButton")))).click();
	    }
	    
	    // Method to enter the CreditAmount
	    public void enterCreditAmount(String CreditAmount) {
	    	EnterCreditAmount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("EnterCreditAmount"))));
	    	EnterCreditAmount.click();
	    	EnterCreditAmount.sendKeys(CreditAmount);
	    }
	    
	    // Method to click the "Pay Later" button
	    public void clickPayLaterButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("ClickPayLater")))).click();
	    }
	    
	    // Method to click the "Dropdown" button
	    public void clickDropdown() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("SelectDropdown")))).click();
	    }
	    
	    // Method to click the "option from Dropdown" button
	    public void clickDropdownOption() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("SelectOptionDropdown")))).click();
	    }
	    
	    // Method to click the "checkBox" button
	    public void clickCheckBox() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("SelectCheckBox")))).click();
	    }
	    
	    // Method to click the "RequestCredit" button
	    public void clickRequestCredit() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("SelectRequestCredit")))).click();
	    }
	    
	    // Method to click the "TaskCredit" button
	    public void clickTaskCredit() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("ClickTaskPopUp")))).click();
	    }
	    
	    // Method to get the Confirm Amount of credit 
	    public String getConfirmAmount() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ConfirmAmountCash")))).getText();
	    }
	    
	    // Method to get the Confirm Payment Status 
	    public String getPaymentStatus() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ConfirmPaymentStatus")))).getText();
	    }
	    
	    // Method to get the Confirm Credit Status 
	    public String getCreditStatus() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ConfirmCreditStatus")))).getText();
	    }
	    
	    // Method to get the Confirm Credit Type
	    public String getCreditType() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ConfirmCreditType")))).getText();
	    }
	    
	    // Method to get the Confirm Credit Type Task
	    public String getCreditTypeTask() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ConfirmCreditTypeTask")))).getText();
	    }
	    
}
