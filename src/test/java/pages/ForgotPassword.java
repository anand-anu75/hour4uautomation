package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ForgotPassword extends BaseTest {

	WebElement txt_emailMobile;
	WebElement btn_sendRecoveryLink;
	WebElement txt_OTP;
	WebElement txt_newPassword;
	WebElement btn_submit;
	WebElement errorMessage_emptyEmailPhone;
	WebElement dialogBox_ForgotPassword;
	WebElement errorMessage_OTP_ForgotPassword;
	WebElement errorMessage_emptyNewPassword;
	WebElement errorMessage_newPasswordLessThan6Digit;

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterValidEmail(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_emailMobile"))))
				.sendKeys(email);
		// txt_emailMobile.sendKeys(email);
	}

	public void clickOnBtn_SendRecoveryLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_sendRecoveryLink"))))
				.click();
		// btn_sendRecoveryLink.click();
	}

	public void enterReceivedOTP(String OTP) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_OTP")))).sendKeys(OTP);
		// txt_OTP.sendKeys(OTP);
	}

	public void enterNewPassword(String newPassword) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_newPassword"))))
				.sendKeys(newPassword);
		// txt_newPassword.sendKeys(newPassword);
	}

	public void clickOnSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_submit")))).click();
		// btn_submit.click();
	}

	public String get_ErrorMessageForEmptyEmailPhone() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_emptyEmailPhone"))))
				.getText();
		// return errorMessage_emptyEmailPhone.getText();
	}

	public void navigateToErrorDialogBox() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("dialogBox_ForgotPassword"))));
		// wait.until(ExpectedConditions.visibilityOf(dialogBox_ForgotPassword));
	}

	public String get_ErrorMessageForEmptyOTPForgotPassword() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_OTP_ForgotPassword"))))
				.getText();
		// return errorMessage_OTP_ForgotPassword.getText();
	}

	public String get_ErrorMessageForEmptyNewPassword() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_emptyNewPassword"))))
				.getText();
		// return errorMessage_emptyNewPassword.getText();
	}

	public String get_ErrorMessageForLessThan6DigitNewPassword() {
		return wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_newPasswordLessThan6Digit"))))
				.getText();
		// return errorMessage_newPasswordLessThan6Digit.getText();
	}
}
