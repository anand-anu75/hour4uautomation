package testcase;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pages.AddVendorPage;
import utilities.ReadXLData;

public class AddVendor extends BaseTest {
    AddVendorPage vendorPage;

    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addNewVendor(String vendorName, String mobileNumber, String vendorEmail, String expectedResult) throws InterruptedException {
        vendorPage = new AddVendorPage(driver);

        // Step 1: Click on the User button
        vendorPage.clickOnUserButton();

        // Step 2: Click on the Vendors option
        vendorPage.clickOnVendorsOption();

        // Step 3: Click on Add Vendor button
        vendorPage.clickOnAddVendorButton();
        
        // Step 4: Navigate to the dialog box
        vendorPage.NavigateToDialogBox();

        // Step 5: Fill in the vendor details
        vendorPage.enterVendorName(vendorName);
        vendorPage.enterMobileNumber(mobileNumber);
        vendorPage.enterEmail(vendorEmail);
        
        // Step 6: Add the Vendor
        vendorPage.clickOnAddVendorDialogueButton();

        // Step 7: Retrieve the result messages
        String actualMobileNumberResult;
        if (driver.findElements(By.xpath(loc.getProperty("alert_InvalidMobileNumber_XPath"))).size() > 0) {
            actualMobileNumberResult = driver.findElement(By.xpath(loc.getProperty("alert_InvalidMobileNumber_XPath"))).getText();
        } else {
            actualMobileNumberResult = "";
        }

        String actualNameResult;
        if (driver.findElements(By.xpath(loc.getProperty("alert_NameRequired_XPath"))).size() > 0) {
            actualNameResult = driver.findElement(By.xpath(loc.getProperty("alert_NameRequired_XPath"))).getText();
        } else {
            actualNameResult = "";
        }
        
        String actualEmailResult;
        if (driver.findElements(By.xpath(loc.getProperty("alert_InvalidEmail_XPath"))).size() > 0) {
            actualEmailResult = driver.findElement(By.xpath(loc.getProperty("alert_InvalidEmail_XPath"))).getText();
        } else {
            actualEmailResult = "";
        }
        
        String actualResult;
        if (!actualEmailResult.isEmpty()) {
            actualResult = actualEmailResult;
        } else if (!actualNameResult.isEmpty()) {
            actualResult = actualNameResult;
        } else if (!actualMobileNumberResult.isEmpty()) {
            actualResult = actualMobileNumberResult;
        } else {
            if (driver.findElements(By.xpath(loc.getProperty("alert_SuccessMessage_XPath"))).size() > 0) {
                actualResult = driver.findElement(By.xpath(loc.getProperty("alert_SuccessMessage_XPath"))).getText();
            } else {
                actualResult = "No success message found";
            }
        }
        
        // Step 9: Verify the result
        softAssert.assertEquals(actualResult, expectedResult, "Vendor addition result mismatch");
        
        // Close the dialog if needed
        vendorPage.clickOnClose();
        softAssert.assertAll();
    }
    
    // New function for valid inputs from CSV
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void addValidVendor(String vendorName, String mobileNumber, String vendorEmail, String expectedResult) throws InterruptedException {
        vendorPage = new AddVendorPage(driver);

        // Step 1: Click on the User button
        vendorPage.clickOnUserButton();

        // Step 2: Click on the Vendors option
        vendorPage.clickOnAddVendorButton();

        // Step 3: Navigate to the dialog box
        vendorPage.NavigateToDialogBox();

        // Step 4: Fill in the vendor details
        vendorPage.enterVendorName(vendorName);
        vendorPage.enterMobileNumber(mobileNumber);
        vendorPage.enterEmail(vendorEmail);
        
        // Step 5: Add the Vendor
        vendorPage.clickOnAddVendorDialogueButton();

        // Step 6: Since this is for valid data, we expect success
        String actualResult;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("alert_SuccessMessage_XPath")))).getText();
        } catch (Exception e) {
            actualResult = "No success message found";
        }

        // Step 8: Verify the result
        softAssert.assertEquals(actualResult, expectedResult, "Vendor addition result mismatch");

        // Since this is a valid input case, no need to manually close the dialog as it should be handled automatically
        softAssert.assertAll();
    }
}
