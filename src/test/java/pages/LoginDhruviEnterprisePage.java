package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class LoginDhruviEnterprisePage extends BaseTest{
	
	WebElement txt_enterDhruviEmail;
	WebElement txt_enterDhruviPassword;
	WebElement btn_ClickOnLogin;
	
	public LoginDhruviEnterprisePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
public void enterDhruviEmail(String phoneOrEmail) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_enterDhruviEmail"))))
		.sendKeys(phoneOrEmail);
	}

public void enterDhruviPassword(String EnterPassword) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_enterDhruviPassword"))))
	.sendKeys(EnterPassword);
}

public void clickOnLoginButton() {
    // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnLogin"))))
		.click();
 }

}
