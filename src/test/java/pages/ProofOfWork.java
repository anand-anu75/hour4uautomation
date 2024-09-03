package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ProofOfWork extends BaseTest  {
	
	WebElement btn_More;
	WebElement btn_DownloadProofofwork;
	WebElement btn_Projects;
	WebElement btn_NextPage;
	WebElement btn_clickheretoviewWorkorders;
	WebElement btn_Workorders;
    WebElement btn_ViewTasks;
    WebElement click_Completed;
    WebElement click_Openmenutoexplore;
	
	public ProofOfWork(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void clickOnbtn_More() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_More")))).click();
	
//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_More);
	}
	
	public void clickOnbtn_DownloadProofofwork() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_DownloadProofofwork")))).click();
		
	//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_DownloadProofofwork);
	}
	
	public void clickOnbtn_Projects() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Projects")))).click();
	}
	
	public void clickOnbtn_NextPage() {
		WebElement clickOn_NextButton=
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_NextPage"))));
		Actions actions =new Actions(driver);
		// Perform double-click action on the located element
		actions.doubleClick(clickOn_NextButton).perform();
	}
	
	public void clickOnbtn_clickheretoviewWorkorders() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_clickheretoviewWorkorders")))).click();
	}
	
	public void clickOnbtn_Workorders() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Workorders")))).click();
	}
	
	public void clickOnbtn_ViewTasks() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ViewTasks")))).click();
	}
	
	public void clickOn_Completed() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Completed")))).click();
	}
	
	public void clickOn_Openmenutoexplore() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Openmenutoexplore")))).click();
	}
}