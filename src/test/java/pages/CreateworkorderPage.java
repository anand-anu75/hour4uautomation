package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;

public class CreateworkorderPage extends BaseTest {

	WebElement btn_Workorder;

	WebElement btn_CreateWorkorder;

	WebElement Dialog_box;

	WebElement btn_SelectProject;

	WebElement btn_AddDetails;

	WebElement btn_SearchAddress;

	WebElement input_EnterDate;

	WebElement btn_StartTime;

	WebElement btn_SelectStarttime;

	WebElement btn_EndTime;

	WebElement btn_SelectEndtime;

	WebElement btn_Addbilling;

	WebElement btn_AddTitle;

	WebElement input_EnterTitle;

	WebElement btn_SeeSummary;

	WebElement btn_SubmitforApproval;

	WebElement msg_WorkOrderCreatedSuccessfully;

	WebElement btn_ClickOnProfile;

	WebElement btn_Logout;

	WebElement mgs_JobOrderApprovedSuccessfully;

	// Constructor to initialize the driver and web elements
	public CreateworkorderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnWorkorderButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_Workorder")))).click();
	}

	public void clickOnCreateWorkorderButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_CreateWorkorder"))))
				.click();
	}

	public void NavigateTodialogBox() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("Dialog_box")))).click();
	}

	public void clickOnSelectProjectButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SelectProject"))))
				.click();
	}

	public void clickOnAddDetailsButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_AddDetails")))).click();
	}

	public void clickOnSearchAddressButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SearchAddress"))))
				.click();
	}

	public void enterDate(String enterDate) {
		input_EnterDate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("input_EnterDate"))));
		input_EnterDate.click(); // Clicking the input field before sending keys, if required
		input_EnterDate.sendKeys(enterDate);
	}

	public void clickOnStartTimeButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_StartTime")))).click();
	}

	public void clickOnSelectStarttimeButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SelectStarttime"))))
				.click();
	}

	public void clickOnEndTimeButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_EndTime")))).click();
	}

	public void clickOnSelectEndtimeButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SelectEndtime"))))
				.click();
	}

	/*public void clickOnAddBillingButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_Addbilling")))).click();
	}
*/
	public void clickOnAddBillingButton() {
		WebElement btn_Addbilling = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Addbilling"))));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", btn_Addbilling);
	}
	
	public void clickOnAddTitleButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_AddTitle")))).click();
	}

	public void enterTitle(String enterTitle) {
		input_EnterTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("input_EnterTitle"))));
		input_EnterTitle.click(); // Clicking the input field before sending keys, if required

		int titleSuffix = (int) (Math.random() * 10000);

		input_EnterTitle.sendKeys(enterTitle + titleSuffix);
	}

	public void clickOnSeeSummaryButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SeeSummary")))).click();
	}

	public void clickOnSubmitforApprovalButton() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SubmitforApproval"))))
				.click();
	}

	public String getSuccessmessage() {
		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("msg_WorkOrderCreatedSuccessfully")))).getText();
	}

	public String getLocationErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidLocation"))))
				.getText();
	}

	public String getDateErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidDate"))))
				.getText();
	}

	public String getStarttimeErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidStartTime"))))
				.getText();
	}

	public String getEndtimeErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("InvalidEndTime"))))
				.getText();
	}

	public void clickOnProfile() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_ClickOnProfile"))))
				.click();
	}

	public String WorkOrderApprovedMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("mgs_JobOrderApprovedSuccessfully"))))
				.getText();
	}

	public void clickOnLogout() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_Logout")))).click();
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_ClickOnLogin"))))
				.click();
	}

	public void closeSuccessMessagePopup() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("closePopupMessage"))))
				.click();
	}

	public void clickOnSelectProjectVendor() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SelectProjectforVendor"))))
				.click();
	}

	public void clickOnAddVendorBtn() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_AddVendorBtn"))))
				.click();
	}

	public void clickOnSelectVendor() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SelectVendor"))))
				.click();
	}

	public void clickOnDesiredProject() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("msg_DesiredProject"))))
				.click();
	}

	public void clickOnVendorViewTab() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_VendorView")))).click();
	}

	public void clickOnVendorQuotes() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_VendorQuotes"))))
				.click();
	}

	public void clickOnCreateWorkOrder() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_CreateWorkOrder"))))
				.click();
	}

	public String getToastmessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("Toastmessage"))))
				.getText();
	}

	public String getToastWorkOrdermessage() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ToastWorkOrdermessage"))))
				.getText();
	}

	public void clickOnApproveWorkorder() {
		// wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ApproveWorkorder"))))
				.click();
	}

}