package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class SignupPage extends BaseTest {

	WebElement txt_mobileNumberSignUp;
	WebElement btn_exploreThePlatformSignUp;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enter_MobileNumber(String mobileNumber) {
		txt_mobileNumberSignUp = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_mobileNumberSignUp"))));
		txt_mobileNumberSignUp.sendKeys(mobileNumber);

	}

	public void enter_CompanyName(String companyName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_companyNameSignUp"))))
				.sendKeys(companyName);
	}

	public void enter_CompanyGSTNumber(String companyGSTNumber) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_companyGSTNumberSignUp"))))
				.sendKeys(companyGSTNumber);
	}

	public void enter_CompanyAddress(String companyAddress) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_companyAddSignUp"))))
				.sendKeys(companyAddress);
	}

	public void click_On_ExploreThePlatform_Button() {
		// btn_exploreThePlatform.click();
		btn_exploreThePlatformSignUp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_exploreThePlatformSignUp"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_exploreThePlatformSignUp);

	}

	public String get_SignupEmptyPhoneEmailErrorMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_SignupEmptyPhoneEmail"))))
				.getText();
	}

	public String get_SignupInvalidEmailPhoneFormatErrorMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_SignupInvalidEmailFormat"))))
				.getText();
	}

	public String get_SignupDialogBoxErrorMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_SignupDialogBox"))))
				.getText();
	}

	public String get_SignupDialogBoxIncorrectOTP() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_SingupIncorrectOTP"))))
				.getText();
	}
	
	public String get_SignupInvalidMobileNoFormatErrorMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_SingupInvalidMobileNoFormat"))))
				.getText();
	}
	public String get_SingupEmptyCompanyNameErrorMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_SingupEmptyCompanyName"))))
				.getText();
	}

}
