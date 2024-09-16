package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class AddChamps extends BaseTest {

	JavascriptExecutor jsExecutor;
	WebElement btn_inviteChamp;
	WebElement inputName;
	WebElement inputPhone;
	WebElement btn_addChamp;
	WebElement usersButton;
	WebElement champsLink;
	WebElement invalidNameMessageXpath;
	WebElement invalidPhoneNumberMessageXpath;
	WebElement successMessageXpath;

	// Constructor
	public AddChamps(WebDriver driver) {
		this.driver = driver;
		this.jsExecutor = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	// Method to click the "Invite Champ" button
	public void clickInviteChamp() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_inviteChamp")))).click();
	}

	// Method to enter the champion's name in the "Invite Champ" form
	public void enterChampionName(String champName) {

		int name = (int) (Math.random() * 10000);

		inputName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_name"))));
		inputName.click(); // Clicking the input field before sending keys, if required

		if (!champName.equalsIgnoreCase("")) {
			inputName.sendKeys(champName + name);
		} else {
			inputName.sendKeys(champName);

		}
	}

	// Method to enter the champion's phone number in the "Invite Champ" form
	public void enterChampionNumber(String phoneNumber) {
		int phoneNum = (int) (Math.random() * 100000);
		inputPhone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("input_phone"))));
		inputPhone.click(); // Clicking the input field before sending keys, if required
		inputPhone.sendKeys(phoneNumber + phoneNum);
	}

	// Method to click the "Add Champ" button
	public void clickAddChamp() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_addChamp")))).click();
	}

	// Method to navigate to the "Users" section
	public void navigateToUsersSection() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("usersButton")))).click();
	}

	// Method to navigate to the "Champs" section under "Users"
	public void navigateToChampsSection() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("champsLink")))).click();
	}

	// Method to get the success message after adding a champ
	public String getSuccessMessage() {
		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("successMessageXpath"))))
				.getText();
	}

	// Method to get the error message for an invalid phone number
	public String getErrorMessageForInvalidPhoneNumber() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("invalidPhoneNumberMessageXpath"))))
				.getText();
	}

	// Method to get the error message for an invalid name
	public String getErrorMessageForInvalidName() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("invalidNameMessageXpath"))))
				.getText();
	}

}
