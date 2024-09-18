package pages;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_DownloadProofofwork"))))
				.click();
	}

	public void clickOnbtn_DownloadProofofworkPPT() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_DownloadProofofworkPPT"))))
				.click();
	}

	public void clickOnbtn_ViewTasks() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ViewTasks")))).click();
	}

	public void clickOn_Openmenutoexplore() {
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Openmenutoexplore"))))
					.click();
		} catch (Exception e) {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Openmenutoexplore"))))
					.click();
		}
	}

	public void clickOn_ExportXLS() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_ExportXLS")))).click();
	}

	public void clickOn_Workorder() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_onWorkorder"))))
				.click();
	}

	public void deleteExistingFile() {
		String partialFileName = "proof_of_work_";
		String downloadDir = "C:\\Users\\Apptad\\Downloads";
		File downloadedfile = new File(downloadDir);
		File[] filesToDelete = downloadedfile.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.contains(partialFileName);
			}
		});

		if (filesToDelete != null) {
			for (File file : filesToDelete) {
				if (file.delete()) {
					System.out.println("Deleted existing file: " + file.getName());
				} else {
					System.out.println("Failed to delete file: " + file.getName());
				}
			}
		}
	}

	public boolean checkFileDownload() throws InterruptedException {
		Thread.sleep(5000);
		boolean fileExist = false;
		String partialFileName = "proof_of_work_";
		String downloadDir = "C:\\Users\\Apptad\\Downloads";
		File downloadedfile = new File(downloadDir);
		File[] matchFiles = downloadedfile.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				return name.contains(partialFileName);
			}
		});
		if (matchFiles != null) {
			for (File file : matchFiles) {
				fileExist = true;
			}

		} else {
			fileExist = false;
		}
		return fileExist;
	}

	public String get_downloadProofofworkPPTSuccessMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("downloadProofofworkPPTSuccessMessage"))))
				.getText();
	}

	public String get_downloadProofofworkPPTToastMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(loc.getProperty("downloadProofofworkPPTToast_Message"))))
				.getText();
	}

	public void clickOnLabel() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_OnLabel")))).click();
	}

	public void deleteWorkOrderExistingFile() {
		String partialFileName = "workorder-data";
		String downloadDir = "C:\\Users\\Apptad\\Downloads";
		File downloadedfile = new File(downloadDir);
		File[] filesToDelete = downloadedfile.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.contains(partialFileName);
			}
		});

		if (filesToDelete != null) {
			for (File file : filesToDelete) {
				if (file.delete()) {
					System.out.println("Deleted existing file: " + file.getName());
				} else {
					System.out.println("Failed to delete file: " + file.getName());
				}
			}
		}
	}

	public boolean checkWorkOrderFileDownload() throws InterruptedException {
		Thread.sleep(5000);
		boolean fileExist = false;
		String partialFileName = "workorder-data";
		String downloadDir = "C:\\Users\\Apptad\\Downloads";
		File downloadedfile = new File(downloadDir);
		File[] matchFiles = downloadedfile.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				return name.contains(partialFileName);
			}
		});
		if (matchFiles != null) {
			for (File file : matchFiles) {
				fileExist = true;
			}

		} else {
			fileExist = false;
		}
		return fileExist;
	}

}