package testcase;
 
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
 
import base.BaseTest;
import pages.CreateworkorderPage;
import pages.ViewtaskPage;
import utilities.ReadXLData;

 
public class ViewTask extends BaseTest {
	ViewtaskPage ViewtaskPage;
 
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData" )
    public void ViewtaskPage(String expectedURL) throws InterruptedException {
    	ViewtaskPage = new ViewtaskPage(driver);
    	
         driver.getWindowHandles();

    	ViewtaskPage.clickOnWorkorderButton(); 
       
    	ViewtaskPage.clickOnViewTasksButton();
    	
    	
    	ViewtaskPage.NavigatetoNewTab(); 

    	String actualURL= driver.getCurrentUrl();
		softAssert.assertEquals(actualURL, expectedURL);
		System.out.println(actualURL);
		softAssert.assertAll();
	    
    }
    
    
    
}
 