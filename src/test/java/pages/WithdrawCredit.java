package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class WithdrawCredit extends BaseTest {
    JavascriptExecutor jsExecutor;
    WebElement CreditsButton;
    WebElement InputPhoneOrEmail;
    WebElement InputPassword;
    WebElement InputAmount;
    WebElement InputUpiId;
    WebElement InputRemarks;
    WebElement InputCheckBox;
    WebElement InputVerificationCode;
    WebElement InputBankAccount;
    WebElement InputBankAccountConfirm;
    WebElement InputIfscCode;
    WebElement InputAccountHolderName;

    // Constructor
    public WithdrawCredit(WebDriver driver) {
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

    // Method to click the "Withdraw" button
    public void clickWithdrawButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("WithdrawButton")))).click();
    }

    // Method to enter the amount
    public void enterAmount(String Amount) {
        InputAmount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputAmount"))));
        InputAmount.click();
        InputAmount.sendKeys(Amount);
    }

    // Method to click the "Next" button
    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("ClickNext")))).click();
    }

    // Method to clear the default UPI and enter a new UPI
    public void clearAndEnterUpi(String Upi) {
        InputUpiId = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputUpiId"))));
        InputUpiId.clear();  // Clear the default UPI
        InputUpiId.sendKeys(Upi);  // Enter the UPI from Excel
    }
    
 // Method to enter the Remark
    public void enterRemark(String Remark) {
    	InputRemarks = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputRemarks"))));
    	InputRemarks.click();
    	InputRemarks.sendKeys(Remark);
    }
    
    
 // Method to click the "Checkbox" button
    public void clickCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputCheckBox")))).click();
    }
    
 // Method to enter the Otp
    public void enterOtp(String Otp) {
    	InputVerificationCode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputVerificationCode"))));
    	InputVerificationCode.click();
    	InputVerificationCode.sendKeys(Otp);
    }
    
 // Method to click the "Radio" button
    public void clickRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("ClickRadioButton")))).click();
    }
    
 // Method to enter the BankAccount Number
    public void enterBankAccount(String BankAccountNumber) {
    	InputBankAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputBankAccount"))));
    	InputBankAccount.click();
    	InputBankAccount.sendKeys(BankAccountNumber);
    }
    
 // Method to enter the BankAccount Number
    public void enterBankAccountConfirm(String BankAccountNumberConfirm) {
    	InputBankAccountConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputBankAccountConfirm"))));
    	InputBankAccountConfirm.click();
    	InputBankAccountConfirm.sendKeys(BankAccountNumberConfirm);
    }
    
 // Method to enter the IFSC code
    public void enterIFSCcode(String IFSCcode) {
    	InputIfscCode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputIfscCode"))));
    	InputIfscCode.click();
    	InputIfscCode.sendKeys(IFSCcode);
    }
    
 // Method to enter the IFSC code
    public void enterAccountHolderName(String AccountHolderName) {
    	InputAccountHolderName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("InputAccountHolderName"))));
    	InputAccountHolderName.click();
    	InputAccountHolderName.sendKeys(AccountHolderName);
    }
}