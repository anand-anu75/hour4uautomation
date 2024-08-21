package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class SignupPage extends BaseTest {

	@FindBy(id = "mat-input-5")
	WebElement txt_mobileNumber;

	@FindBy(id = "mat-input-2")
	WebElement txt_companyName;

	@FindBy(id = "mat-input-3")
	WebElement txt_companyGSTNumber;

	@FindBy(id = "mat-input-4")
	WebElement txt_companyAdd;

	@FindBy(xpath = "//button[@class='primary-btn mt-6']")
	WebElement btn_exploreThePlatform;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enter_MobileNumber(String mobileNumber) {
		wait.until(ExpectedConditions.visibilityOf(txt_mobileNumber));
		// enterMobileNumber.sendKeys(mobileNumber);;
		txt_mobileNumber.sendKeys(mobileNumber);

	}

	public void enter_CompanyName(String companyName) {
		txt_companyName.sendKeys(companyName);

	}

	public void enter_CompanyGSTNumber(String companyGSTNumber) {
		txt_companyGSTNumber.sendKeys(companyGSTNumber);

	}

	public void enter_CompanyAddress(String companyAddress) {
		txt_companyAdd.sendKeys(companyAddress);

	}

	public void click_On_ExploreThePlatform_Button() {
		//btn_exploreThePlatform.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",btn_exploreThePlatform);

	}

}
