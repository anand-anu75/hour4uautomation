package pages;

import org.openqa.selenium.By;
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("opt_SelectCreatedProjects"))))
			.click();
	    }
	
	public void ClickOnAssignVendor() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_AssignVendor"))))
			.click();
	    }
	
	public void clickOn_DropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("click_dropdown")))).click();
 
	}
	
	public void SelectVendorToAssignProject() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("opt_ClickOnVendor"))))
			.click();
	    }
	
	public void ClickOnAssignVendorButton() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ClickOnAssignVendor"))))
			.click();
	    }
	
	public String SelectedVendorAssignedSuccessfully() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("msg_VendorAssignedSuccessfully")))).getText();
		
	}
	
}
