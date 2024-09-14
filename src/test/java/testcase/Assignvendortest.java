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
		
		Assignvendortest = new Assignvendor(driver);

		Assignvendortest.enterPhoneOrEmail(phoneOrEmail);
		Assignvendortest.enterPassword(password);
		Assignvendortest.clickOnBtn_Login();
		Assignvendortest.clickOnbtn_workorder();
		Assignvendortest.clickOnbtn_createworkorder();
		Assignvendortest.clickOn_selectprojects();
		Assignvendortest.clickOnbtn_Adddetails();
		Assignvendortest.clickOn_location();
		Assignvendortest.enterDate(Date);
		Assignvendortest.clickOn_Starttime();
		Assignvendortest.clickOnSelect_Starttime();
		Assignvendortest.clickOn_Endtime();
		Assignvendortest.clickOnSelect_Endtime();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(2000);
		Assignvendortest.clickOnbtn_Addbilling();
		Assignvendortest.clickOnbtn_Addtitle();
		Assignvendortest.enterWorkordertitle(Workordertitle);
		Assignvendortest.clickOn_DropDown();
		Assignvendortest.clickOn_AssignVendor();
		Assignvendortest.clickOnbtn_SeeSummary();
		Assignvendortest.clickOnbtn_SubmitForApproval();
		String actualMessage = Assignvendortest.get_MessageForWorkorderAddedSuccessfully();

		try {
			softAssert.assertEquals(actualMessage, expectedmessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

}
