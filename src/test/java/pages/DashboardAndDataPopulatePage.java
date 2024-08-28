package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;
import java.time.Duration;

public class DashboardAndDataPopulatePage extends BaseTest {

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

    // Constructor to initialize the driver and web elements
    public DashboardAndDataPopulatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on the Select Data Range button
    public void clickOnSelectDataRange() {
        btn_SelectDataRange = driver.findElement(By.xpath(loc.getProperty("btn_SelectDataRange_XPath")));
        wait.until(ExpectedConditions.visibilityOf(btn_SelectDataRange)).click();
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
        btn_StatusFilter = driver.findElement(By.xpath(loc.getProperty("btn_StatusFilter_XPath")));
        wait.until(ExpectedConditions.visibilityOf(btn_StatusFilter)).click();
    }
    
    public void selectActiveStatus() {
        btn_StatusActiveOption = driver.findElement(By.xpath(loc.getProperty("btn_StatusActiveOption_XPath")));
        wait.until(ExpectedConditions.elementToBeClickable(btn_StatusActiveOption)).click();
    }

    // Method to click on the City Filter
    public void clickOnCityFilter() {
        btn_CityFilter = driver.findElement(By.xpath(loc.getProperty("btn_CityFilter_XPath")));
        wait.until(ExpectedConditions.visibilityOf(btn_CityFilter)).click();
    }
    
    public void selectCityDelhi() {
        btn_CityDelhiOption = driver.findElement(By.xpath(loc.getProperty("btn_CityDelhiOption_XPath")));
        wait.until(ExpectedConditions.elementToBeClickable(btn_CityDelhiOption)).click();
    }

    // Method to check the Workorders label
    public String getWorkordersText() {
        lbl_Workorders = driver.findElement(By.xpath(loc.getProperty("lbl_Workorders_XPath")));
        return lbl_Workorders.getText();
    }

    // Method to check the Fulfilment label
    public String getFulfilmentText() {
        lbl_Fulfilment = driver.findElement(By.xpath(loc.getProperty("lbl_Fulfilment_XPath")));
        return lbl_Fulfilment.getText();
    }

    // Method to check the Completed Tasks label
    public String getCompletedTasksText() {
        lbl_CompletedTasks = driver.findElement(By.xpath(loc.getProperty("lbl_CompletedTasks_XPath")));
        return lbl_CompletedTasks.getText();
    }

    // Method to select items per page from the dropdown
    public void selectItemsPerPage(String items) {
        ddl_ItemsPerPage = driver.findElement(By.xpath(loc.getProperty("ddl_ItemsPerPage_XPath")));
        ddl_ItemsPerPage.click();
        // Logic to select the desired option can be added here
    }
}
