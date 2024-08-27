package testcase;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ManageJobApplicationAccessPage;
import utilities.ReadXLData;

public class ManageJobApplicationAccess extends BaseTest {
	ManageJobApplicationAccessPage JobApplicationPage;
	

    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void JobApplicationAccess(String Name) throws InterruptedException {
    	JobApplicationPage = new ManageJobApplicationAccessPage(driver);
    	
    	JobApplicationPage.clickOnWorkorderTab();
    	Thread.sleep(3000);
    	JobApplicationPage.clickOnActiveWorkorbit();
    	JobApplicationPage.clickOnApprove();
    	
    	}
}
