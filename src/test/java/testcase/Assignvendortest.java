package testcase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.Assignvendor;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)

public class Assignvendortest extends BaseTest {

	Assignvendor Assignvendortest;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "Verify Assign workorder to Vendors")
	public void Assign_workorder_to_vendor(String phoneOrEmail, String password, String Date, String Workordertitle,
			String expectedmessage) throws InterruptedException, IOException {
		
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		//create workorder and assign to vendor
		Assignvendortest = new Assignvendor(driver);

		//Enter a valid Email ID
		Assignvendortest.enterPhoneOrEmail(phoneOrEmail);
		
		//Enter Password
		Assignvendortest.enterPassword(password);
		
		//click on login button
		Assignvendortest.clickOnBtn_Login();
		
		//click on workorder button
		Assignvendortest.clickOnbtn_workorder();
		
		//click on button create workorder
		Assignvendortest.clickOnbtn_createworkorder();
		
		//click on select projects
		Assignvendortest.clickOn_selectprojects();
		
		//click on Add details button
		Assignvendortest.clickOnbtn_Adddetails();
		
		//click on location
		Assignvendortest.clickOn_location();
		
		//Enter Date
		Assignvendortest.enterDate(Date);
		
		//click on start time
		Assignvendortest.clickOn_Starttime();
		
		//click on select start time
		Assignvendortest.clickOnSelect_Starttime();
		
		//click on End time
		Assignvendortest.clickOn_Endtime();
		
		//click on select End time
		Assignvendortest.clickOnSelect_Endtime();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();
	//	Thread.sleep(2000);
		
		scrollPageDown();
		//click on Add billing button
		Assignvendortest.clickOnbtn_Addbilling();
		
		//click on Add title button
		Assignvendortest.clickOnbtn_Addtitle();
		
		//Enter workorder title
		Assignvendortest.enterWorkordertitle(Workordertitle);
		
		//click on DropDown
		Assignvendortest.clickOn_DropDown();
		
		//click on Assign Vendor
		Assignvendortest.clickOn_AssignVendor();
		
		//click on See Summary button
		Assignvendortest.clickOnbtn_SeeSummary();
		
		//click on Submit for Approval button
		Assignvendortest.clickOnbtn_SubmitForApproval();
		
		//Fetch success message for workorder added successfully
		String actualMessage = Assignvendortest.get_MessageForWorkorderAddedSuccessfully();

		//Verify success message for workorder added successfully
		try {
			softAssert.assertEquals(actualMessage, expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

}
