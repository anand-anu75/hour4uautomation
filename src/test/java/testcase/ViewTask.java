package testcase;

import java.io.IOException;
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
	Login loginAgency = new Login();
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void ViewtaskPage(String phoneOrEmail, String OTP, String expectedURL, String expectedNewTabURL)
			throws InterruptedException, IOException {
		
		
		loginAgency.login(phoneOrEmail, OTP, expectedURL);
		ViewtaskPage = new ViewtaskPage(driver);

		driver.getWindowHandles();

		ViewtaskPage.clickOnWorkorderButton();

		ViewtaskPage.clickOnViewTasksButton();

		ViewtaskPage.NavigatetoNewTab();

		String actualURL = driver.getCurrentUrl();
		softAssert.assertEquals(actualURL, expectedNewTabURL);
		System.out.println(actualURL);
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

	}

}
