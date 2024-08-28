package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;

public class LoginPage extends BaseTest {

	WebElement link_SignInUsingOtp;
	WebElement txt_phoneOrEmail;
	WebElement btn_GetOTP;
	WebElement txt_OTP;
	WebElement btn_login;
	WebElement link_signup;
	WebElement btn_signup;
	WebElement txt_password;
	WebElement errorMessage_invalidFormatPhNumOrEmail;
	WebElement errorMessage_EmptyPassword;
	WebElement link_forget_password;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnLink_SignInUsingOtp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("link_SignInUsingOtp"))))
				.click();

	}

	public void enterPhoneOrEmail(String phoneOrEmail) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_phoneOrEmail"))))
				.sendKeys(phoneOrEmail);
	}

	public void clickOnBtn_GetOTP() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_GetOTP")))).click();
		// btn_GetOTP.click();
	}

	public void enterOTP(String OTP) {

		for (int i = 0; i < OTP.length(); i++) {
			String otpFieldXPath = "//input[starts-with(@id, 'otp_" + i + "')]";
			WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otpFieldXPath)));
			otpField.clear();
			otpField.sendKeys(String.valueOf(OTP.charAt(i)));
		}

	}

	public void clickOnBtn_Login() {

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-container")));
		} catch (Exception e) {
			System.out.println("Overlay or modal still present.");
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_login")))).click();

	}

	public void clickOnLink_Signup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("link_signup")))).click();
		// link_signup.click();
	}

	public void clickOnBtn_Signup() throws InterruptedException {

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-container")));
		} catch (Exception e) {
			System.out.println("Overlay or modal still present.");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_signup);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_password"))))
				.sendKeys(password);
		// txt_password.sendKeys(password);
	}

	public String get_ErrorMessageForInvalidFormatPhNumOrEmail() {
		return errorMessage_invalidFormatPhNumOrEmail.getText();
	}

	public String get_ErrorMessageForEmptyPassword() {
		return errorMessage_EmptyPassword.getText();

	}

	public void clickOnLink_ForgotPassword() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("link_forget_password"))))
				.click();
		// link_forget_password.click();
	}

}
