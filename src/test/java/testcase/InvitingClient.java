package testcase;
 
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ReadXLData;
import base.BaseTest;
import pages.CreateProjectPage;
import pages.InvitingclientPage;
 
public class InvitingClient extends BaseTest {
	InvitingclientPage ClientPage;
 
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void createNewClient(String Name, String Phone, String Email, String Address, String
    		expectedSuccessMessage) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
 
        ClientPage.clickOnUserButton();
 
        ClientPage.clickOnClientsOption();
 
        ClientPage.clickOnInviteClientButton();
        
        ClientPage.NavigateToDialogBox();
        
        
        ClientPage.enterClientName(Name);
        
        ClientPage.enterMobileNumber(Phone);
        
        ClientPage.enterEmail(Email);
        
        ClientPage.enterAddress(Address);
        
        ClientPage.clickOnCreateClientButton();
        
        String actualSuccessMessage = ClientPage.getSuccessMessage();
        softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
 
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
        
    	
        
    }
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_NameError(String Name, String Phone, String Email, String Address, String
    		expectedErrorMessage) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
 
        ClientPage.clickOnUserButton();
 
        ClientPage.clickOnClientsOption();
 
        ClientPage.clickOnInviteClientButton();
        
        ClientPage.NavigateToDialogBox();
        
        
        ClientPage.enterClientName(Name);
        
        ClientPage.enterMobileNumber(Phone);
        
        ClientPage.enterEmail(Email);
        
        ClientPage.enterAddress(Address);
        
        ClientPage.clickOnCreateClientButton();
        
        String actualErrorMessage = ClientPage.getErrorMessage();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
 
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
        
       
           
        
    }
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_PhoneError(String Name, String Phone, String Email, String Address, String
    		expectedPhoneErrorMessage) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
 
        ClientPage.clickOnUserButton();
 
        ClientPage.clickOnClientsOption();
 
        ClientPage.clickOnInviteClientButton();
        
        ClientPage.NavigateToDialogBox();
        
        
        ClientPage.enterClientName(Name);
        
        ClientPage.enterMobileNumber(Phone);
        
        ClientPage.enterEmail(Email);
        
        ClientPage.enterAddress(Address);
        
        ClientPage.clickOnCreateClientButton();
        
        String actualPhoneErrorMessage = ClientPage.getPhoneErrorMessage();
        softAssert.assertEquals(actualPhoneErrorMessage, expectedPhoneErrorMessage);
 
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
        
       	
           
        
    }
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_EmailError(String Name, String Phone, String Email, String Address, String
    		expectedEmailErrorMessage) throws InterruptedException {
        ClientPage = new InvitingclientPage(driver);
 
        ClientPage.clickOnUserButton();
 
        ClientPage.clickOnClientsOption();
 
        ClientPage.clickOnInviteClientButton();
        
        ClientPage.NavigateToDialogBox();
        
        
        ClientPage.enterClientName(Name);
        
        ClientPage.enterMobileNumber(Phone);
        
        ClientPage.enterEmail(Email);
        
        ClientPage.enterAddress(Address);
        
        ClientPage.clickOnCreateClientButton();
        
        String actualEmailErrorMessage = ClientPage.getEmailErrorMessage();
        softAssert.assertEquals(actualEmailErrorMessage, expectedEmailErrorMessage);
 
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
             
        
    }
    
    
}

 