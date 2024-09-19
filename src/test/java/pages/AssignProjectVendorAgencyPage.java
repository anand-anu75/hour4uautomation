package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class AssignProjectVendorAgencyPage extends BaseTest{
	
	WebElement opt_SelectCreatedProjects;
	
	WebElement btn_AssignVendor;
	
	WebElement click_dropdown;
	
	WebElement opt_ClickOnVendor;
	
	WebElement btn_ClickOnAssignVendor;
	
	WebElement msg_VendorAssignedSuccessfully;
	
	public AssignProjectVendorAgencyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void SelectCreatedProject() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("opt_SelectCreatedProjects"))))
			.click();
	    }
	
	public void ClickOnAssignVendor() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_AssignVendor"))))
			.click();
	    }
	
	/* public void clickOn_DropDown() {
        
		WebElement click_dropdown =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("click_dropdown"))));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", click_dropdown);
 
	}
	*/
	
	public void clickOn_DropDown() {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		} catch (Exception e) {
			System.out.println("Overlay or modal still present.");
		}
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_dropdown_option")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("click_dropdown")))).click();
	}
	
	public void SelectVendorToAssignProject() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("opt_ClickOnVendor"))))
			.click();
	    }
	
	public void ClickOnAssignVendorButton() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_ClickOnAssignVendor"))))
			.click();
	    }
	
	public String SelectedVendorAssignedSuccessfully() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("msg_VendorAssignedSuccessfully")))).getText();
		
	}
	
}
