package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class AgencyloginPage extends BaseTest {

	    WebElement input_enterPhoneEmail;

	    WebElement input_enterPassword;  
	    
	    WebElement btn_LoginBtn;
	      

	public AgencyloginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	 public void enterPhoneEmail(String PhoneEmail) {
		 input_enterPhoneEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_enterPhoneEmail"))));
		 input_enterPhoneEmail.click(); // Clicking the input field before sending keys, if required
		 input_enterPhoneEmail.sendKeys(PhoneEmail);
	    }
	  
	  public void enterPassword(String Password) {
		  input_enterPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_enterPassword"))));
		  input_enterPassword.click(); // Clicking the input field before sending keys, if required
		  input_enterPassword.sendKeys(Password);
	    }

	  public void clickOnLoginBtn() {
	        // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_LoginBtn"))))
	 		.click();
	     }
}
