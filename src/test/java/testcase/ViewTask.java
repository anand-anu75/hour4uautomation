package testcase;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AgencyloginPage;
import pages.CreateworkorderPage;
import pages.ViewtaskPage;
import utilities.ReadXLData;

public class ViewTask extends BaseTest {
	ViewtaskPage ViewtaskPage;
	AgencyloginPage Agencylogin;
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ViewtaskPage(String PhoneEmail, String Password,String TextField, String expectedNewTabURL)
			throws InterruptedException, IOException {
		
		
      Agencylogin = new AgencyloginPage(driver);
		
		Agencylogin.enterPhoneEmail(PhoneEmail);
		Agencylogin.enterPassword(Password);
		Agencylogin.clickOnLoginBtn(); 

		ViewtaskPage = new ViewtaskPage(driver);

		driver.getWindowHandles();

		ViewtaskPage.clickOnWorkorderButton();

		ViewtaskPage.clickOnViewTasksButton();

		//ViewtaskPage.NavigatetoNewTab();
		
		Thread.sleep(2000);
		
		ViewtaskPage.clickOnaddTasksButton();
		
		ViewtaskPage.clickOnselectjobseekerButton();
		
		ViewtaskPage.clickOnSelectchampButton();

		ViewtaskPage.clickOntextfieldButton();
		
		ViewtaskPage.enterTextField(TextField);
		
		ViewtaskPage.clickOnsubmitButton();
		
		String actualSuccessMessage = ViewtaskPage.getSuccessMessage();
        softAssert.assertEquals(actualSuccessMessage, expectedNewTabURL);
 
    	try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
        
  
    }

}
