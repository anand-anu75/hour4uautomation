package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ManageJobApplicationAccessPage extends BaseTest {
	
	WebElement btn_PojectTab;
	
	WebElement opt_ClickOnCreatedProject;
	
	WebElement btn_AssignAgency;
	
	WebElement txt_SearchAgency;
	
	WebElement opt_ClickonSeachAgency;
	
	WebElement btn_ClickOnSearchAssignAgency;
	
	WebElement btn_ClickOnProfile;
	
	WebElement btn_LogoutEnterprise;
	
	WebElement txt_EnterAgencyEmail;
	
	WebElement btn_ClickOnSignInUsingOtp;
	
	WebElement btn_ClickOnGetOtp;
	
	WebElement txt_EnterOTPforAgencyLogin;
	
	WebElement btn_ClickOnLoginforAgency;
	
	WebElement btn_Workorder;
	
	WebElement opt_ClickOnActiveWorkOrder;
	
	WebElement btn_ChampApprove ;
	
	WebElement msg_JobApplicationStatus;
	
	WebElement btn_ChampReject;
	
	public ManageJobApplicationAccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnProjectTabButton() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("tab_Project"))))
			.click();
	    }
	
	public void clickOnCreatedProjectOption() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("opt_ClickOnCreatedProject"))))
			.click();
	    }
	
	
	public void clickOnAssignAgency() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AssignAgency"))))
			.click();
	    }
	
public void enterSearchAgency(String SearchAgency) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_SearchAgency"))))
		.sendKeys(SearchAgency);
	}

public void clickOnSearchAgency() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("opt_ClickonSeachAgency"))))
		.click();
 }

public void clickOnSearchAssignAgency() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnSearchAssignAgency"))))
		.click();
 }

public void clickOnProfileButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnProfile"))))
		.click();
 }

public void clickOnLogoutButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Logout"))))
		.click();
 }

public void enterAgencyEmail(String EnterAgencyEmail) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterAgencyEmail"))))
	.sendKeys(EnterAgencyEmail);
}

public void clickOnSignInUsingOTP() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnSignInUsingOtp"))))
		.click();
 }

public void clickOnGetOTP() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnGetOtp"))))
		.click();
 }

public void enterOTPforAgencyLogin(String EnterOTP) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_EnterOTPforAgencyLogin"))))
	.sendKeys(EnterOTP);
}

public void clickOnLoginButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnLoginforAgency"))))
		.click();
 }

public void clickOnWorkorderButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Workorder"))))
		.click();
 }	

public void clickOnActiveWorkorder() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("opt_ClickOnActiveWorkOrder"))))
		.click();
 }

public void ClickToApproveChamp() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ChampApprove"))))
		.click();
 }

public String JobApplicationStatus() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("msg_JobApplicationStatus")))).getText();
	
}

public void ClickToRejectChamp() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ChampReject"))))
		.click();
 }

}
