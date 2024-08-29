package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ManageDownloads extends BaseTest {
	
	WebElement btn_More;
	WebElement btn_DownloadProofofwork;
	WebElement btn_ViewTasks;
	WebElement click_Openmenutoexplore;
	WebElement click_ExportXLS;
	WebElement btn_Active;
	
	
	public ManageDownloads(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void clickOnbtn_More() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_More")))).click();
	}
	
	public void clickOnbtn_DownloadProofofwork() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_DownloadProofofwork")))).click();
	}
	
	public void clickOnbtn_ViewTasks() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ViewTasks")))).click();
	}
	
	public void clickOn_Openmenutoexplore() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Openmenutoexplore")))).click();
	}
	
	public void clickOn_ExportXLS() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_ExportXLS")))).click();
	}
	
	public void clickOn_Active() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Active")))).click();
	}
	
	

}
