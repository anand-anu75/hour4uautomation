package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	WebElement expected_Message;
	WebElement errorMessage_InvalidName;
	WebElement errorMessage_InvalidMobile;
	WebElement errorMessage_InvalidEmail;

	public static String expectedName;
	public static String expectedMobileNo;
	public static String expectedEmail;

	public AddTeamMembers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Methods to click on Users Button
	public void clickOnbtn_Users() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Users")))).click();
	}

	// Method to click on Team Members
	public void clickOnLink_TeamMembers() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("link_TeamMembers"))))
				.click();
	}

	// Method to click on Invite Team Member Button
	public void clickOnbtn_InviteTeamMembers() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_InviteTeamMembers")))).click();

	}

	// Method to enter Name
	public void enterName(String Name) {

		int nameSuffix = (int) (Math.random() * 10000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Name"))))
				.sendKeys(Name + nameSuffix);

		expectedName = Name + nameSuffix;
	}

	// Method to enter mobile
	public void enterMobile(String Mobile) {

		long phoneSuffix = (long) (Math.random() * 100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Mobile"))))
				.sendKeys(Mobile + phoneSuffix);
		expectedMobileNo = "+91"+" "+Mobile +" "+ phoneSuffix;
	}

	// Method to enter Email
	public void enterEmail(String Email) {

		int emailSuffix = (int) (Math.random() * 1000000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Email"))))
				.sendKeys(Email + emailSuffix);
		expectedEmail = Email + emailSuffix;
	}

	public void click_On_AddTeamMemberButton() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_AddTeamMember")))).click();
	}

	public String get_MessageForTeamMemberAddedSuccessfully() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("expected_Message"))))
				.getText();
	}

	public String get_ErrorMessageForInvalidName() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_InvalidName"))))
				.getText();
	}

	public String get_ErrorMessageForInvalidMobile() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_InvalidMobile"))))
				.getText();

	}

	public String get_ErrorMessageForInvalidEmail() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("errorMessage_InvalidEmail"))))
				.getText();
	}

	public void clickOn_RoleDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("drpd_Role")))).click();
	}

	public void selectRoleType() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("RoleType_AGENCY_STAFF")))).click();
	}

	public void enterInvalidName(String invalidName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Name"))))
				.sendKeys(invalidName);
		;
	}

	public String get_nameOfTeamMemberAdded() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("name_TeamMember"))))
				.getText();
	}

	public String get_mobileOfTeamMemberAdded() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("mobile_TeamMember"))))
				.getText();
	}

	public String get_emailOfTeamMemberAdded() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("email_TeamMember"))))
				.getText();
	}

}
