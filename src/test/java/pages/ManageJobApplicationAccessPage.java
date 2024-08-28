package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ManageJobApplicationAccessPage extends BaseTest {
	
	WebElement tab_Workorder;
	
	WebElement btn_ActiveWorkorbit;
	
	WebElement btn_Approve;
	
	public ManageJobApplicationAccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnWorkorderTab() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("tab_Workorder"))))
			.click();
	    }
	
	public void clickOnActiveWorkorbit() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ActiveWorkorbit"))))
			.click();
	    }
	
	public void clickOnApprove() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Approve"))))
			.click();
	    }
	
	public void clickOnReject() {
	       // wait.until(ExpectedConditions.visibilityOf(tab_Project)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Reject"))))
			.click();
	    }


}
