package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;

public class Assignvendor extends BaseTest {
	
	WebElement txt_phoneOrEmail;
	WebElement txt_password;
	WebElement btn_login;
	WebElement btn_workorder;
	WebElement btn_createworkorder;
	WebElement click_selectprojects;
	WebElement btn_Adddetails;
	WebElement click_location;
	WebElement txt_date;
	WebElement click_Starttime;
	WebElement select_Starttime;
	WebElement click_Endtime;
	WebElement select_Endtime;
	WebElement btn_Addbilling;
	WebElement btn_Addtitle;
	WebElement txt_Workordertitle;
	WebElement btn_SeeSummary;
	WebElement btn_approval;
	WebElement click_dropdown;
	WebElement Assign_vendor;
	WebElement message_workorderaddedsuccessfully;
	
	public Assignvendor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void enterPhoneOrEmail(String phoneOrEmail) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_phoneOrEmail"))))
				.sendKeys(phoneOrEmail);
	}
	
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_password"))))
				.sendKeys(password);
	}
	
	public void clickOnBtn_Login() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_login")))).click();

	}
	
	public void clickOnbtn_workorder() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_workorder"))))
		.click();
	}
	
	public void clickOnbtn_createworkorder() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_createworkorder"))))
		.click();
	}
	
	public void clickOn_selectprojects() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_selectprojects"))))
		.click();
	}
	
	public void clickOnbtn_Adddetails() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Adddetails"))))
		.click();
	}
	
	public void clickOn_location() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_location"))))
		.click();
	}
	
	public void enterDate(String Date) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_date"))))
				.sendKeys(Date);
	}
	
	public void clickOn_Starttime() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Starttime"))))
		.click();
	}
	
	public void clickOnSelect_Starttime() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("select_Starttime"))))
		.click();
	}
	
	public void clickOn_Endtime() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Endtime"))))
		.click();
	}
	
	public void clickOnSelect_Endtime() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("select_Endtime"))))
		.click();
	}
	
	public void clickOnbtn_Addbilling() {
		WebElement btn_Addbilling = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Addbilling"))));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", btn_Addbilling);
	}
	
	public void clickOnbtn_Addtitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Addtitle"))))
		.click();
	}
	
	public void enterWorkordertitle(String Workordertitle) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Workordertitle"))))
				.sendKeys(Workordertitle);
	}
	
	public void clickOnbtn_SeeSummary() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SeeSummary"))))
		.click();
	}
	
	public void clickOnbtn_SubmitForApproval() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_approval"))))
		.click();
	}
	
	public void clickOn_DropDown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_dropdown"))))
		.click();
	}
	
	public void clickOn_AssignVendor() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("Assign_vendor"))))
		.click();
	}
	
	public String get_MessageForWorkorderAddedSuccessfully() {
	   	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("message_workorderaddedsuccessfully")))).getText();
	    	
 }
	

}
