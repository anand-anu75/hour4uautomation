package testcase;
 
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Scanner;
import java.io.IOException;

import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ReadXLData;
import base.BaseTest;

import pages.InvitingclientPage;
 
@Listeners(base.Listeners.class)

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
        
        
        String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email); // Appends a random number to the email username

        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomPhone);
        ClientPage.enterEmail(randomEmail);
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
        
        
        
     //   String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email); // Appends a random number to the email username

      //  ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomPhone);
        ClientPage.enterEmail(randomEmail);
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
        
        
        String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
       // String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email); // Appends a random number to the email username

        ClientPage.enterClientName(randomName);
       // ClientPage.enterMobileNumber(randomPhone);
        ClientPage.enterEmail(randomEmail);
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
        
        
        
        String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
       // String randomEmail = generateRandomEmail(Email); // Appends a random number to the email username

        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomPhone);
       // ClientPage.enterEmail(randomEmail);
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
    private String generateRandomPhoneNumber() {
        long randomPhone = (long) (Math.random() * 10000000000L); // Generates a random number and ensures it's 10 digits
        return String.format("%010d", randomPhone); // Formats it as a 10-digit string
    }

    // Utility method to generate a random email
    private String generateRandomEmail(String baseEmail) {
        int randomNum = (int) (Math.random() * 1000); // Generates a random number between 0 and 999
        String[] emailParts = baseEmail.split("@");
        if (emailParts.length == 2) {
            return emailParts[0] + randomNum + "@" + emailParts[1]; // Inserts the random number before the '@' symbol
        }
        return baseEmail; // Fallback to the original email if the format is unexpected
    }
    
}

 