package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(xpath = "//*[text()='Sign in using otp?']")
	WebElement link_SignInUsingOtp;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement txt_phoneOrEmail;

	@FindBy(xpath = "//*[text()='Get OTP']")
	WebElement btn_GetOTP;

	@FindBy(id = "otp_0_0u4nb91antvflztrkqy3")
	WebElement txt_OTP;

	@FindBy(xpath = "//*[text()='Login']")
	WebElement btn_login;

	@FindBy(xpath = "//*[@class='signup-btn']")
	WebElement link_signup;

	@FindBy(xpath = "//button[starts-with(@class, 'primary-btn')]")
	WebElement btn_signup;

	@FindBy(xpath = "//input[@ng-reflect-type='password']")
	WebElement txt_password;

	@FindBy(xpath = "//*[@class='error-wrap ng-tns-c1-1 ng-star-inserted']/div")
	WebElement errorMessage_invalidFormatPhNumOrEmail;

	@FindBy(xpath = "//*[text()='We need a password to log you in ']")
	WebElement errorMessage_EmptyPassword;
	
	@FindBy(xpath = "//*[text()='Forgot Password?']")
	WebElement link_forget_password;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnLink_SignInUsingOtp() {
		link_SignInUsingOtp.click();
	}

	public void enterPhoneOrEmail(String phoneOrEmail) {
		wait.until(ExpectedConditions.visibilityOf(txt_phoneOrEmail)).sendKeys(phoneOrEmail);
		//txt_phoneOrEmail.sendKeys(phoneOrEmail);
	}

	public void clickOnBtn_GetOTP() {
		btn_GetOTP.click();
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

		wait.until(ExpectedConditions.elementToBeClickable(btn_login)).click();

	}

	public void clickOnLink_Signup() {
		wait.until(ExpectedConditions.visibilityOf(link_signup)).click();
		link_signup.click();
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
		txt_password.sendKeys(password);
	}

	public String get_ErrorMessageForInvalidFormatPhNumOrEmail() {
		return errorMessage_invalidFormatPhNumOrEmail.getText();
	}
	
	public String get_ErrorMessageForEmptyPassword() {
		return errorMessage_EmptyPassword.getText();
		
	}
	
	public void clickOnLink_ForgotPassword() {
		link_forget_password.click();
	}

}
