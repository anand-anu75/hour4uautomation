package testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AssignProjectVendorAgencyPage;
import pages.CreateProjectPage;
import base.BaseTest;
import utilities.ReadXLData;

public class AssignProjectVendorAgency extends BaseTest {
	
	AssignProjectVendorAgencyPage AssignProjectVendor;
	
	  @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
	    public void AssignProjectVendorData(String ExpectedResult) throws InterruptedException {
		  AssignProjectVendor = new AssignProjectVendorAgencyPage(driver);
		  CreateProjectPage ProjectPage = new CreateProjectPage(driver);
		  
		  ProjectPage.clickOnProjectTabButton();
		  Thread.sleep(2000);
		  AssignProjectVendor.SelectCreatedProject();
		  AssignProjectVendor.ClickOnAssignVendor();
		  Thread.sleep(2000);
		  AssignProjectVendor.SelectVendorToAssignProject();
		  AssignProjectVendor.SelectVendorToAssignProject();
		  AssignProjectVendor.ClickOnAssignVendorButton();
		  AssignProjectVendor.SelectedVendorAssignedSuccessfully();
		  
		  String VendorAssignedSuccessfully = AssignProjectVendor.SelectedVendorAssignedSuccessfully();
	        softAssert.assertEquals(VendorAssignedSuccessfully, ExpectedResult);
	        try {
				softAssert.assertAll();
			} catch (AssertionError e) {
				assertionMessage.set(e.getMessage());
				throw e;
			}
	  }
	  
	  @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
	    public void CreateProjectAssignVendor(String ProjectTitle,String ProjectDescription,String ProjectCode,
	    		String LinkTitle,String LinkURL,String EnterMetrics,String EnterQuantity,String CustomFieldName,
	    		String ABCD,String FieldName,String EnterFrequency,String EnterRadius,String EnterItem, 
	    		String EnterDescription,String EnterRates,String EnterQty, String EnterDays,
	    		String PaymentTerms, String TermsAndConditions,String ExpectedResult,String ExpectedMessage) 
	    				throws InterruptedException {
	        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
	        AssignProjectVendor = new AssignProjectVendorAgencyPage(driver);

	        //ProjectPage.clickOnErrorMessage();
	        ProjectPage.clickOnProjectTabButton();
	       //ProjectPage.clickOnErrorMessage();
	        ProjectPage.clickOnCreateProjectButton();
	        //ProjectPage.clickOnSelfClientButton();
	        ProjectPage.clickOnExistingEnterprise();
	        ProjectPage.SelectDropdownEnterprise();
	        Thread.sleep(2000);
	        ProjectPage.SelectOptionEnterprise();
	        Thread.sleep(2000);
	        ProjectPage.clickOnNext1Button();
	        Thread.sleep(2000);
	        ProjectPage.clickOnProjectTypeButton();
	        ProjectPage.SelectNewProjectType();
	        ProjectPage.clickOnHotspotButton();
	        ProjectPage.clickOnNext2Button();
	        //ProjectPage.clickOnProjectDetailsButton();
	        ProjectPage.enterProjectTitle(ProjectTitle);
	        ProjectPage.enterProjectDescription(ProjectDescription);
	        ProjectPage.enterProjectCode(ProjectCode);
	        ProjectPage.enterLinkTitle(LinkTitle);
	        ProjectPage.enterURL(LinkURL);
	        ProjectPage.enterMetrics(EnterMetrics);
	        ProjectPage.enterQuantity(EnterQuantity);
	        ProjectPage.clickOnStartDateButton();
	        ProjectPage.clickOnSelectStartDate();
	      //ProjectPage.clickOnEndDateButton();
	        ProjectPage.ClickOnEnterEndDate();
	        ProjectPage.clickOnSelectEndDate();
	      // Scroll Window
	        Actions actions = new Actions(driver); 
	        actions.sendKeys(Keys.PAGE_DOWN).perform();
	        Thread.sleep(1000);
	        ProjectPage.ClickOnAddCustomField();
	       ProjectPage.enterCustomFieldName(CustomFieldName);
	       ProjectPage.SelectCustomFieldType();
	       ProjectPage.SelectCustomTextArea();
	       ProjectPage.ClickOnAddField();
	       ProjectPage.enterCustomTextArea(ABCD);
	        ProjectPage.clickOnSelectLocationButton();
	        ProjectPage.clickOnSelectLocationDelhiButton();
	        ProjectPage.clickOnAddTrackingButton();
	        ProjectPage.enterFieldName(FieldName);
	        ProjectPage.clickOnFieldTypeDropDown();
	        ProjectPage.clickOnPhoneNumberButton();
	        ProjectPage.clickOnContinuousLocationTracking();
	        ProjectPage.enterFrequency(EnterFrequency);
	        ProjectPage.enterRadius(EnterRadius);
	        //ProjectPage.clickOnOnlyGpsCoordinate();
	        ProjectPage.clickOnAddBilling();
	        ProjectPage.clickOnPricingFixed();
	        ProjectPage.enterItem(EnterItem);
	        ProjectPage.enterDescription(EnterDescription);
	        ProjectPage.enterRate(EnterRates);
	        ProjectPage.enterQty(EnterQty);
	        ProjectPage.enterDays(EnterDays);
	        ProjectPage.ClickOnAddAditionalItems();
	        ProjectPage.ClickOnQuoteDate();
	        ProjectPage.SelectValidDate();
	        ProjectPage.enterPaymentTerms(PaymentTerms);
	        ProjectPage.enterTermsAndConditions(TermsAndConditions);
	        ProjectPage.clickOnReviewProject();
	        ProjectPage.clickOnSaveProject();
	        ProjectPage.ClickOnCloseMsgProjectCreatedSuccessfully();
	       
			  ProjectPage.clickOnProjectTabButton();
			  Thread.sleep(2000);
			  AssignProjectVendor.SelectCreatedProject();
			  AssignProjectVendor.ClickOnAssignVendor();
			  Thread.sleep(2000);
			  AssignProjectVendor.SelectVendorToAssignProject();
			  AssignProjectVendor.ClickOnAssignVendorButton();
			  AssignProjectVendor.SelectedVendorAssignedSuccessfully();
			  
			  String VendorAssignedSuccessfully = AssignProjectVendor.SelectedVendorAssignedSuccessfully();
		        softAssert.assertEquals(VendorAssignedSuccessfully, ExpectedMessage);
		        try {
					softAssert.assertAll();
				} catch (AssertionError e) {
					assertionMessage.set(e.getMessage());
					throw e;
				}
		  }
	  
}
