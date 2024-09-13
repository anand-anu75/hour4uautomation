package testcase;
 
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CreateworkorderPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class CreateWorkorder extends BaseTest {
	CreateworkorderPage WorkorderPage;
 
	//Create WorkOrder for Enterprise
    @Test(dependsOnMethods ={"testcase.Login.login"}, dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateworkorderPage(String Date, String Title, String
    		expectedSuccessmessage) throws InterruptedException {
    	WorkorderPage = new CreateworkorderPage(driver);

    	WorkorderPage.clickOnWorkorderButton(); 
       
    	WorkorderPage.clickOnCreateWorkorderButton();
        
    	WorkorderPage.NavigateTodialogBox();
 
    	WorkorderPage.clickOnSelectProjectButton();
    	
    	WorkorderPage.clickOnAddDetailsButton();
    	
        WorkorderPage.clickOnSearchAddressButton(); 	
    	
    	WorkorderPage.enterDate(Date);
    	
    	WorkorderPage.clickOnStartTimeButton();
    	
    	WorkorderPage.clickOnSelectStarttimeButton();
    	
    	 Actions actions = new Actions(driver); 
    	    actions.sendKeys(Keys.ESCAPE).perform();
    	
    	    WorkorderPage.clickOnEndTimeButton();
    	
    	    WorkorderPage.clickOnSelectEndtimeButton();
    	    	
    	    WorkorderPage.clickOnAddBillingButton();
     	
    	    WorkorderPage.clickOnAddTitleButton();
     
    	    WorkorderPage.enterTitle(Title);
     	
    	    WorkorderPage.clickOnSeeSummaryButton();
    	
    	    WorkorderPage.clickOnSubmitforApprovalButton();
    
    	   String actualSuccessmessage = WorkorderPage.getSuccessmessage();
           softAssert.assertEquals(actualSuccessmessage, expectedSuccessmessage);
    
       	try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}

       	}
    
    // Work order for Self
    @Test(dependsOnMethods ={"testcase.Login.login"}, dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_LocationError(String Date, String Title, String
    		expectedLocationErrorMessage) throws InterruptedException {
    	WorkorderPage = new CreateworkorderPage(driver);

    	WorkorderPage.clickOnWorkorderButton(); 
       
    	WorkorderPage.clickOnCreateWorkorderButton();
        
    	WorkorderPage.NavigateTodialogBox();
 
    	WorkorderPage.clickOnSelectProjectButton();
    	
    	WorkorderPage.clickOnAddDetailsButton();
    	
    	//WorkorderPage.clickOnSearchAddressButton(); 	
    	
    	WorkorderPage.enterDate(Date);
    	
    /*	WorkorderPage.clickOnStartTimeButton();
    	
    	WorkorderPage.clickOnSelectStarttimeButton();
    	
    	 Actions actions = new Actions(driver); 
    	    actions.sendKeys(Keys.ESCAPE).perform();
    	
    	    WorkorderPage.clickOnEndTimeButton();
    	
    	    WorkorderPage.clickOnSelectEndtimeButton();
    	    	
    	    WorkorderPage.clickOnAddBillingButton();
     	
    	    WorkorderPage.clickOnAddTitleButton();
     
    	    WorkorderPage.enterTitle(Title);
     	
    	    WorkorderPage.clickOnSeeSummaryButton();
    	
    	    WorkorderPage.clickOnSubmitforApprovalButton(); */
    
    	    String actualLocationErrorMessage = WorkorderPage.getLocationErrorMessage();
            softAssert.assertEquals(actualLocationErrorMessage, expectedLocationErrorMessage);
     
        	try {
    			softAssert.assertAll();
    		} catch (AssertionError e) {
    			assertionMessage.set(e.getMessage());
    			throw e;
    		}


    }
    
    @Test(dependsOnMethods ={"testcase.Login.login"}, dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_DateError(String Date, String Title, String
    		expectedDateErrorMessage) throws InterruptedException {
    	WorkorderPage = new CreateworkorderPage(driver);

    	WorkorderPage.clickOnWorkorderButton(); 
       
    	WorkorderPage.clickOnCreateWorkorderButton();
        
    	WorkorderPage.NavigateTodialogBox();
 
    	WorkorderPage.clickOnSelectProjectButton();
    	
    	WorkorderPage.clickOnAddDetailsButton();
    	
    	WorkorderPage.clickOnSearchAddressButton(); 	
    	
    	WorkorderPage.enterDate(Date);
    	
    	WorkorderPage.clickOnStartTimeButton();
    	
    	WorkorderPage.clickOnSelectStarttimeButton();
    	
    	 Actions actions = new Actions(driver); 
    	    actions.sendKeys(Keys.ESCAPE).perform();
    	
    	    /* WorkorderPage.clickOnEndTimeButton();
    	
    	    WorkorderPage.clickOnSelectEndtimeButton();
    	    	
    	    WorkorderPage.clickOnAddBillingButton();
     	
    	    WorkorderPage.clickOnAddTitleButton();
     
    	    WorkorderPage.enterTitle(Title);
     	
    	    WorkorderPage.clickOnSeeSummaryButton();
    	
    	    WorkorderPage.clickOnSubmitforApprovalButton(); */
    
    	    String actualDateErrorMessage = WorkorderPage.getDateErrorMessage();
            softAssert.assertEquals(actualDateErrorMessage, expectedDateErrorMessage);
     
        	try {
    			softAssert.assertAll();
    		} catch (AssertionError e) {
    			assertionMessage.set(e.getMessage());
    			throw e;
    		}

    }
    
    @Test(dependsOnMethods ={"testcase.Login.login"}, dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_StarttimeError(String Date, String Title, String
    		expectedStarttimeErrorMessage) throws InterruptedException {
    	WorkorderPage = new CreateworkorderPage(driver);

    	WorkorderPage.clickOnWorkorderButton(); 
       
    	WorkorderPage.clickOnCreateWorkorderButton();
        
    	WorkorderPage.NavigateTodialogBox();
 
    	WorkorderPage.clickOnSelectProjectButton();
    	
    	WorkorderPage.clickOnAddDetailsButton();
    	
    	WorkorderPage.clickOnSearchAddressButton(); 	
    	
    	//WorkorderPage.enterDate(Date);
    	
    	WorkorderPage.clickOnStartTimeButton();
    	
    	//WorkorderPage.clickOnSelectStarttimeButton();
    	
    	 Actions actions = new Actions(driver); 
    	    actions.sendKeys(Keys.ESCAPE).perform();
    	
    	    /* WorkorderPage.clickOnEndTimeButton();
    	
    	    WorkorderPage.clickOnSelectEndtimeButton();
    	    	
    	    WorkorderPage.clickOnAddBillingButton();
     	
    	    WorkorderPage.clickOnAddTitleButton();
     
    	    WorkorderPage.enterTitle(Title);
     	
    	    WorkorderPage.clickOnSeeSummaryButton();
    	
    	    WorkorderPage.clickOnSubmitforApprovalButton(); */
    
    	    String actualStarttimeErrorMessage = WorkorderPage.getStarttimeErrorMessage();
            softAssert.assertEquals(actualStarttimeErrorMessage, expectedStarttimeErrorMessage);
     
        	try {
    			softAssert.assertAll();
    		} catch (AssertionError e) {
    			assertionMessage.set(e.getMessage());
    			throw e;
    		}

    }
    
    @Test(dependsOnMethods ={"testcase.Login.login"}, dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_EndtimeError(String Date, String Title, String
    		expectedEndtimeErrorMessage) throws InterruptedException {
    	WorkorderPage = new CreateworkorderPage(driver);

    	WorkorderPage.clickOnWorkorderButton(); 
       
    	WorkorderPage.clickOnCreateWorkorderButton();
        
    	WorkorderPage.NavigateTodialogBox();
 
    	WorkorderPage.clickOnSelectProjectButton();
    	
    	WorkorderPage.clickOnAddDetailsButton();
    	
    	WorkorderPage.clickOnSearchAddressButton(); 	
    	
    	//WorkorderPage.enterDate(Date);
    	
    	WorkorderPage.clickOnStartTimeButton();
    	
    	//WorkorderPage.clickOnSelectStarttimeButton();
    	
    	 Actions actions = new Actions(driver); 
    	    actions.sendKeys(Keys.ESCAPE).perform();
    	
    	    WorkorderPage.clickOnEndTimeButton();
    	    
    	    Actions actions1 = new Actions(driver); 
    	    actions1.sendKeys(Keys.ESCAPE).perform();
    	
    	
    	   /* WorkorderPage.clickOnSelectEndtimeButton();
    	    	
    	    WorkorderPage.clickOnAddBillingButton();
     	
    	    WorkorderPage.clickOnAddTitleButton();
     
    	    WorkorderPage.enterTitle(Title);
     	
    	    WorkorderPage.clickOnSeeSummaryButton();
    	
    	    WorkorderPage.clickOnSubmitforApprovalButton(); */
    
    	    String actualEndtimeErrorMessage = WorkorderPage.getEndtimeErrorMessage();
            softAssert.assertEquals(actualEndtimeErrorMessage, expectedEndtimeErrorMessage);
     
        	try {
    			softAssert.assertAll();
    		} catch (AssertionError e) {
    			assertionMessage.set(e.getMessage());
    			throw e;
    		}

    }
    
}
 