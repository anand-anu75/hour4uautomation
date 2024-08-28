package testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateProjectPage;
import utilities.ReadXLData;

public class CreateProjectExistingEnterprise extends BaseTest {
	
//Create Project for Existing Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateExistingProjectPageData(String ProjectTitle,String ProjectDescription,String ProjectCode,
    		String LinkTitle,String LinkURL,String EnterMetrics,String EnterQuantity,String CustomFieldName,
    		String ABCD,String FieldName,String EnterFrequency,String EnterRadius,String EnterItem, 
    		String EnterDescription,String EnterRates,String EnterQty, String EnterDays,
    		String PaymentTerms, String TermsAndConditions,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
        
        String ExistingCreatedSuccesfully = ProjectPage.ExistingCreatedSuccesfully();
        softAssert.assertEquals(ExistingCreatedSuccesfully, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }
    
    //Existing Enterprise - Invalid Project Type
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidProjectType(String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
    //    ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnNext2Button();
        
        String ExistingInvalidProjectType = ProjectPage.ExistingInvalidProjectType();
        softAssert.assertEquals(ExistingInvalidProjectType, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }
    
    // Existing Enterprise - Invalid Project Title
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidProjectTitle(String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
      //  ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.clickOnSelectLocationButton();
        
        String InvalidProjectTitle = ProjectPage.InvalidProjectTitle();
        softAssert.assertEquals(InvalidProjectTitle, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }
    
    //Existing Enterprise - Invalid Project Description
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidProjectDesc(String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.clickOnSelectLocationButton();
        
        String InvalidProjectDescription = ProjectPage.EnterProperProjectDescription();
        softAssert.assertEquals(InvalidProjectDescription, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    }
    
    //Existing Enterprise - Invalid Field Name
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidFieldName(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);

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
        ProjectPage.clickOnEndDateButton();
        ProjectPage.clickOnSelectEndDate();
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
    
    
        String InvalidFieldName = ProjectPage.InvalidFieldName();
        softAssert.assertEquals(InvalidFieldName, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
}
    
    //Existing Enterprise - Invalid Frequency
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidFrequency(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
    
  //ProjectPage.clickOnErrorMessage();
    ProjectPage.clickOnProjectTabButton();
   //ProjectPage.clickOnErrorMessage();
    ProjectPage.clickOnCreateProjectButton();
    //ProjectPage.clickOnSelfClientButton();
    ProjectPage.clickOnExistingEnterprise();
    ProjectPage.SelectDropdownEnterprise();
    ProjectPage.SelectOptionEnterprise();
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
    ProjectPage.clickOnEndDateButton();
    ProjectPage.clickOnSelectEndDate();
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
    
    String InvalidFrequency = ProjectPage.InvalidFrequency();
    softAssert.assertEquals(InvalidFrequency, ExpectedResult);
    try {
		softAssert.assertAll();
	} catch (AssertionError e) {
		assertionMessage.set(e.getMessage());
		throw e;
	}
}
    
    //Existing Enterprise - Invalid Radius
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidRadius(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
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
        ProjectPage.clickOnEndDateButton();
        ProjectPage.clickOnSelectEndDate();
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
    
    
    String InvalidRadius = ProjectPage.InvalidRadius();
    softAssert.assertEquals(InvalidRadius, ExpectedResult);
    try {
		softAssert.assertAll();
	} catch (AssertionError e) {
		assertionMessage.set(e.getMessage());
		throw e;
	}
}

}
