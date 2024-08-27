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
	
	WebElement btn_Next;
	
	WebElement txt_EnterOTP;
	
	WebElement btn_Next2;
	
	WebElement btn_Workorbit;
	
	WebElement btn_ApplyWorkorbit;
	
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

public void clickOnNextButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Next"))))
		.click();
 }

public void enterOTP(String EnterOTP) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterOTP"))))
	.sendKeys(EnterOTP);
}

public void clickOnNext2Button() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Next2"))))
		.click();
 }

public void clickOnWorkorbitButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Workorbit"))))
		.click();
 }

public void clickOnApplyWorkorbitButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ApplyWorkorbit"))))
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
