package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;
import java.util.List;

public class DashboardPage extends BaseTest {

	// Locators that are being referenced from the locators.properties file
	WebElement btn_SelectDataRange;
	WebElement btn_ThisMonth;
	WebElement btn_StatusFilter;
	WebElement btn_StatusActiveOption;
	WebElement lbl_WelcomeUser;
	WebElement btn_CityFilter;
	WebElement btn_CityDelhiOption;
	WebElement lbl_Workorders;
	WebElement lbl_Fulfilment;
	WebElement lbl_CompletedTasks;
	WebElement ddl_ItemsPerPage;
	WebElement menu_Dashbord;
	String dashboard_AllStatus;

	// Constructor to initialize the driver and web elements
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to click on the Select Data Range button
	public void clickOnSelectDataRange() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SelectDataRange_XPath"))))
				.click();
	}

	// Method to select "This Month" from the Date Range picker
	public void selectThisMonth() {
		btn_ThisMonth = driver.findElement(By.xpath(loc.getProperty("btn_ThisMonth_XPath")));
		wait.until(ExpectedConditions.elementToBeClickable(btn_ThisMonth)).click();
	}

	public void clickOnPageToCloseDropdown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.elementFromPoint(360, 120).click();");
	}

	// Method to click on the Status Filter
	public void clickOnStatusFilter() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_StatusFilter_XPath"))))
				.click();
	}

	public void selectActiveStatus() {
		btn_StatusActiveOption = driver.findElement(By.xpath(loc.getProperty("btn_StatusActiveOption_XPath")));
		wait.until(ExpectedConditions.elementToBeClickable(btn_StatusActiveOption)).click();
	}

	// Method to click on the City Filter
	public void clickOnCityFilter() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_CityFilter_XPath")))).click();
	}

	public void selectCity(String dropdownOption) {

		if (dropdownOption.equalsIgnoreCase("Delhi")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("drp_CityDelhiOption_XPath"))))
					.click();
		}

		else if (dropdownOption.equalsIgnoreCase("Mumbai")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("drp_CityMumbaiOption_XPath"))))
					.click();
		}

	}

	// Method to retrieve the text of the Workorders label
	public String getWorkordersText() {
		WebElement lbl_Workorders = driver.findElement(By.xpath(loc.getProperty("lbl_Workorders_XPath")));
		return lbl_Workorders.getText();
	}

	// Method to retrieve the text of the Fulfilment label
	public String getFulfilmentText() {
		WebElement lbl_Fulfilment = driver.findElement(By.xpath(loc.getProperty("lbl_Fulfilment_XPath")));
		return lbl_Fulfilment.getText();
	}

	// Method to retrieve the text of the Completed Tasks label
	public String getCompletedTasksText() {
		WebElement lbl_CompletedTasks = driver.findElement(By.xpath(loc.getProperty("lbl_CompletedTasks_XPath")));
		return lbl_CompletedTasks.getText();
	}

	public String getPaginatorRangeText() {
		WebElement paginatorRangeLabel = driver.findElement(By.xpath(loc.getProperty("paginatorRangeLabel_XPath")));
		return paginatorRangeLabel.getText();
	}

	public void clickOnThirdMatSelectValue() {
		WebElement thirdMatSelectValue = driver.findElement(By.xpath(loc.getProperty("thirdMatSelectValue_XPath")));
		wait.until(ExpectedConditions.elementToBeClickable(thirdMatSelectValue)).click();
	}

	public void selectOptionTwenty() {
		WebElement optionTwenty = driver.findElement(By.xpath(loc.getProperty("optionTwenty_XPath")));
		wait.until(ExpectedConditions.elementToBeClickable(optionTwenty)).click();
	}

	public void clickOnDashboardMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("menu_Dashbord")))).click();
	}

	public String get_WorkOrderCount() {
		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("lbl_WorkOrder_Count"))))
				.getText();
	}

	public void selectLast7DaysOption() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("option_Last7Days")))).click();
	}

	public boolean verifyWorkorderCount(String workorderCount, String newWorkorderCount) {
		boolean value = false;
		if (!workorderCount.equals(newWorkorderCount)) {
			value = true;
		} else {
			value = false;
		}
		return value;

	}

	public void clickOnPaginationOption() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pagination")))).click();
	}

	public void select500Option() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pagination_500Option")))).click();
	}

	public void selectDropdownOption(String dropdownOption) {

		if (dropdownOption.equalsIgnoreCase("Pending")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pendingCheckbox")))).click();

		} else if (dropdownOption.equalsIgnoreCase("Completed")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("completedCheckbox")))).click();

		} else if (dropdownOption.equalsIgnoreCase("Active")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("activeCheckbox")))).click();

		} else if (dropdownOption.equalsIgnoreCase("Rejected")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("rejectedCheckbox")))).click();
		}
	}

	public boolean verifyStatus(String status) {
		boolean value = true;
		int retryCount = 3; // Number of retries for handling stale element
		List<WebElement> dashboard_AllStatus = null;

		while (retryCount > 0) {
			try {
				// Locate the status element and wait for it to become visible
				WebElement dashboard_Status = driver.findElement(By.xpath(loc.getProperty("dashboard_AllStatus")));
				// wait.until(ExpectedConditions.stalenessOf(dashboard_Status));

				dashboard_AllStatus = wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath(loc.getProperty("dashboard_AllStatus"))));

				// Check the status text
				for (WebElement dashboardStatus : dashboard_AllStatus) {
					String statusText = dashboardStatus.getText().trim();
					if (!statusText.equalsIgnoreCase(status)) {
						value = false;
						break;
					}
				}
				break;
			} catch (StaleElementReferenceException e) {
				retryCount--;
				if (retryCount == 0) {
					throw e;
				}
			}
		}

		return value;
	}

	public void scrollToEndOfPage() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).build().perform();
	}

	public void clickOnDashboardLabel() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_OnLabel")))).click();
	}

	public void scrollToPageStart() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.HOME).build().perform();
	}

	public boolean verifyCity(String city) {

		boolean value = true;
		WebElement dashboard_City = driver.findElement(By.xpath(loc.getProperty("dashboard_AllCity")));
		wait.until(ExpectedConditions.stalenessOf(dashboard_City));

		List<WebElement> dashboard_AllCity = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(loc.getProperty("dashboard_AllCity"))));
		for (WebElement dashboardCity : dashboard_AllCity) {
			String statusText = dashboardCity.getText().trim();
			if (!statusText.equalsIgnoreCase(city)) {
				value = false;
				break;
			}
		}
		return value;
	}

	public String get_FulfilmentCount() {

		String checkedinCount = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("fulfilmentCheckedinCount"))))
				.getText();
		String totalAppliedApplicantCount = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("fulfilmentTotalAppliedApplicantCount"))))
				.getText();
		String quantityCount = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("fulfilmentQuantityCount"))))
				.getText();

		String fulfilment = checkedinCount + totalAppliedApplicantCount + quantityCount;

		return fulfilment;
	}

	public String get_CompletedTaskCount() {
		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("completedTaskCount"))))
				.getText();
	}

	public void selectPaginatioOption(String paginationOption) {
		if (paginationOption.equalsIgnoreCase("10")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pagination_10Option"))))
					.click();
		} else if (paginationOption.equalsIgnoreCase("20")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pagination_20Option"))))
					.click();
		} else if (paginationOption.equalsIgnoreCase("50")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pagination_50Option"))))
					.click();
		} else if (paginationOption.equalsIgnoreCase("100")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pagination_100Option"))))
					.click();
		} else if (paginationOption.equalsIgnoreCase("500")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pagination_500Option"))))
					.click();
		}
	}

	public int get_TotalRecordsOnPage() throws InterruptedException {
		int attempts = 0;
		List<WebElement> totalRecordCountOnPage = null;
		while (attempts < 3) {
			try {
				totalRecordCountOnPage = wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath(loc.getProperty("recordCountOnPage"))));
				break; // Exit the loop if successful
			} catch (StaleElementReferenceException e) {
				attempts++;
				Thread.sleep(1000); // Wait and try again
			}
		}
		Thread.sleep(2000);
		return totalRecordCountOnPage.size();
	}

	public String get_ApprovedTaskCount() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("approvedTaskCount"))))
				.getText();
	}

	public void clickOnAgencyDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("drp_dashboardAgency")))).click();
	}

	public void enterAgencyNameToSearch(String agencyName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drp_AgencySearch"))))
				.sendKeys(agencyName);
	}

	public void selectAgency() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("drp_RohitAgencyValue"))))
				.click();
	}

	public boolean verifyAgency(String agencyName) {
		boolean value = true;
		int retryCount = 3; // Number of retries for handling stale element
		List<WebElement> dashboard_AllAgency = null;

		while (retryCount > 0) {
			try {
				// Locate the status element and wait for it to become visible

				dashboard_AllAgency = wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath(loc.getProperty("dashboard_AllAgency"))));

				for (WebElement dashboardAgency : dashboard_AllAgency) {
					String statusText = dashboardAgency.getText().trim();
					if (!statusText.equalsIgnoreCase(agencyName)) {
						value = false;
						break;
					}
				}
				break;
			} catch (StaleElementReferenceException e) {
				retryCount--;
				if (retryCount == 0) {
					throw e;
				}
			}
		}

		return value;
	}

}
