package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class AppLoginPage extends BaseTest {
	
	WebElement btn_LetStart;
	
	WebElement btn_Skip;
	
	WebElement txt_MobileNumber;
	
	WebElement btn_MobileNextButton;
	
	WebElement txt_EnterOTP;
	
	WebElement btn_OTPNext;
	
	WebElement opt_AppActiveJobAvailable ;
	
	WebElement btn_ApplyActiveJob;
	
	WebElement txt_VendorName;
	
	WebElement txt_VendorDOB;
	
	WebElement btn_GenderMale;
	
	WebElement btn_Next3;
	
	public AppLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnLetStartButton() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_LetStart"))))
			.click();
	    }
	
	public void clickOnSkiptButton() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Skip"))))
			.click();
	    }
	
public void enterMobileNumber(String MobileNumber) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_MobileNumber"))))
		.sendKeys(MobileNumber);
	}

public void clickOnMobileNextButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_MobileNextButton"))))
		.click();
 }

public void enterOTP(String EnterOTP) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterOTP"))))
	.sendKeys(EnterOTP);
}

public void clickOnOTPNext() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_OTPNext"))))
		.click();
 }

public void clickOnAppActiveJob() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("opt_AppActiveJobAvailable"))))
		.click();
 }

public void clickOnApplyActiveJob() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ApplyActiveJob"))))
		.click();
 }

public void enterVendorName(String VendorName) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_VendorName"))))
	.sendKeys(VendorName);
}

public void enterDOB(String EnterDOB) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_VendorDOB"))))
	.sendKeys(EnterDOB);
}

public void clickOnGenderMale() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_GenderMale"))))
		.click();
 }

public void clickOnNext3() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Next3"))))
		.click();
 }

	

}
