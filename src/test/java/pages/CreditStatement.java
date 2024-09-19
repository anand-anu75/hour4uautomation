package pages;

import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class CreditStatement extends BaseTest {

	WebElement txt_phoneOrEmail;
	WebElement txt_password;
	WebElement btn_login;
	WebElement btn_Credits;
	WebElement txt_amount;
	WebElement btn_Paylater;
	WebElement click_days;
	WebElement click_dropdown_option;
	WebElement click_checkbox;
	WebElement btn_RequestCredits;
	WebElement click_accounticon;
	WebElement click_logout;
	WebElement txt_SuperadminEmail;
	WebElement txt_Superadminpassword;
	WebElement click_approve;
	WebElement ViewStatement;
	WebElement click_ExporttoXLS;
	WebElement txt_Mobilenumber;
	WebElement btn_Continue;
	WebElement Message_Creditstatus;
	WebElement click_upi;
	WebElement txt_UPIID;
	WebElement btn_Verifyandpay;
	WebElement message_PaymentSuccessful;

	public CreditStatement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterPhoneOrEmail(String phoneOrEmail) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_phoneOrEmail"))))
				.sendKeys(phoneOrEmail);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_password"))))
				.sendKeys(password);
	}

	public void clickOnBtn_Login() {

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-container")));
		} catch (Exception e) {
			System.out.println("Overlay or modal still present.");
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_login")))).click();

	}

	public void clickOnbtn_Credits() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Credits")))).click();
	}

	public void clickOnbtn_Topup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Topup")))).click();
	}

	public void enteramount(String amount) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_amount"))))
				.sendKeys(amount);

	}

	public void clickOnbtn_Paylater() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Paylater")))).click();
	}

	public void clickOn_DropDown_Option() {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		} catch (Exception e) {
			System.out.println("Overlay or modal still present.");
		}
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_dropdown_option")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("click_dropdown_option")))).click();
	}
	

	public void clickOn_days() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_days")))).click();
	}

	public void clickOn_checkbox() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_checkbox")))).click();
	}

	public void clickOnbtn_RequestCredits() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_RequestCredits"))))
				.click();
	}

	public void clickOn_accounticon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_accounticon"))))
				.click();
	}

	public void clickOn_logout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_logout")))).click();
	}

	public void enterSuperadminemail(String SuperadminEmail) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_SuperadminEmail"))))
				.sendKeys(SuperadminEmail);
	}

	public void enterSuperadminpassword(String SuperadminPassword) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Superadminpassword"))))
				.sendKeys(SuperadminPassword);
	}

	public void clickOn_approve() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_approve")))).click();
	}

	public void enterverificationcode(String verificationcode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_verificationcode"))))
				.sendKeys(verificationcode);

	}

	public void clickOn_Next() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Next")))).click();
	}

	public void clickOnbtn_Topup1() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Topup1")))).click();
	}

	public void clickOn_ViewStatement() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_ViewStatement"))))
				.click();
	}

	public void clickOn_ExporttoXLS() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_ExporttoXLS"))))
				.click();
	}

	public void clickOnbtn_Pay() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Pay")))).click();
	}

	public void enterMobilenumber(String Mobilenumber) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_Mobilenumber"))))
				.sendKeys(Mobilenumber);
	}

	public void clickOnbtn_Continue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Continue")))).click();

	}

	public void clickOnbtn_Pay1() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Pay1")))).click();
	}

	public String get_MessageForCreditstatus() {
		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("Message_Creditstatus"))))
				.getText();

	}

	public void clickOn_upi() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_upi")))).click();
	}

	public void enterUPIID(String UPIID) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_UPIID"))))
				.sendKeys(UPIID);

	}

	public void clickOnbtn_verifyandpay() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Verifyandpay"))))
				.click();
	}

	public String get_MessageForPaymentSuccessful() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("message_PaymentSuccessful"))))
				.getText();

	}

	public void deleteExistingCreditFile() {
		String partialFileName = "credit-list";
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

	public boolean checkCreditFileDownload() {

		boolean fileExist = false;
		String partialFileName = "credit-list";
		String downloadDir = "C:\\Users\\Apptad\\Downloads";
		File downloadedfile = new File(downloadDir);
		long endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(60);

		while ((System.currentTimeMillis() < endTime) && fileExist == false) {
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

		}
		return fileExist;
	}

	public void deleteExistingWithdrawnFile() {
		String partialFileName = "withdrawn-payouts";
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

	public boolean checkwithdrawnFileDownload() {

		boolean fileExist = false;
		String partialFileName = "withdrawn-payouts";
		String downloadDir = "C:\\Users\\Apptad\\Downloads";
		File downloadedfile = new File(downloadDir);
		long endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(60);

		while ((System.currentTimeMillis() < endTime) && fileExist == false) {
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

		}
		return fileExist;
	}

	public void navigateToPaymentFrame() {
		WebElement frame = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("paymentFrame"))));
		driver.switchTo().frame(frame);
	}

}