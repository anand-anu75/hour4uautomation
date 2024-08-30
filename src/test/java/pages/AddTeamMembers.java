package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;

public class AddTeamMembers extends BaseTest {
	

	WebElement btn_Users;
	WebElement link_TeamMembers;
	WebElement btn_InviteTeamMembers;
    WebElement txt_Name;
    WebElement txt_Mobile;
    WebElement txt_Email;
    WebElement btn_AddTeamMember;
	WebElement errorMessage_InvalidName;
	WebElement errorMessage_InvalidMobile;
	WebElement errorMessage_InvalidEmail;
	
    
	public AddTeamMembers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//Methods to click on Users Button
	public void clickOnbtn_Users() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Users"))))
		.click();
	}
	//Method to click on Team Members
	public void clickOnLink_TeamMembers() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("link_TeamMembers"))))
		.click();
	}
	//Method to click on Invite Team Member Button
	public void clickOnbtn_InviteTeamMembers() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_InviteTeamMembers")))).click();
	
	}

    //Method to enter Name
	public void enterName(String Name) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Name"))))
		.sendKeys(Name);
		
	}
   //Method to enter mobile
	public void enterMobile(String Mobile) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Mobile"))))
		.sendKeys(Mobile);
	
	}
    //Method to enter Email
	public void enterEmail(String Email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Email"))))
		.sendKeys(Email);
		
	}
	
    public void click_On_AddTeamMember_Button() {
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AddTeamMember")))).click();
       }catch(Exception e) {
			System.out.println("complete");
		}
    }
    
    public String get_ErrorMessageForInvalidName() {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_InvalidName")))).getText();
    }
    
    public String get_ErrorMessageForInvalidMobile() {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_InvalidMobile")))).getText();

 	}
    
   public String get_ErrorMessageForInvalidEmail() {
	   return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_InvalidEmail")))).getText();
 	}
	

}