package testcase;
 
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;
import pages.CreateProjectPage;
import utilities.ReadXLData;
 
public class CreateProject extends BaseTest {
    CreateProjectPage ProjectPage;
    
    // Test for Creating Project Successfully Using Self Enterprise
 
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectPageTestData(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String StartDate,String EndDate,String FieldName, String EnterFrequency, 
    		String EnterRadius,String EnterItem, String EnterDescription
    		,String EnterRates,String EnterQty, String EnterDays, String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
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
      //ProjectPage.enterStartDate(StartDate);
        ProjectPage.clickOnSelectStartDate();
        ProjectPage.clickOnEndDateButton();
      //ProjectPage.enterEndDate(EndDate);
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
        ProjectPage.clickOnPricingFixed();
        ProjectPage.enterItem(EnterItem);
        ProjectPage.enterDescription(EnterDescription);
        ProjectPage.enterRate(EnterRates);
        ProjectPage.enterQty(EnterQty);
        ProjectPage.enterDays(EnterDays);
        ProjectPage.clickOnReviewProject();
        ProjectPage.clickOnSaveProject();
        
        
        String ProjectCreatedSuccesfully = ProjectPage.ProjectCreatedSuccesfully();
        softAssert.assertEquals(ProjectCreatedSuccesfully, ExpectedResult);
		softAssert.assertAll();
    }
    
    //Test for Selecting Invalid Project Type for Self Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    
    public void SelectingImproperProjectType(String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       // ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        //ProjectPage.clickOnSelectProjectTypeButton();
       // ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        //ProjectPage.clickOnProjectDetailsButton();
        
        String SelectedImproperProjectType = ProjectPage.SelectedImproperProjectType();
        softAssert.assertEquals(SelectedImproperProjectType, ExpectedResult);
		softAssert.assertAll();
    }
    
    //Test for Invalid Project Description for Self Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void InvalidProjectDescription(String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       // ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        //ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.clickOnSelectLocationButton();
        
        String ProperProjectDescription = ProjectPage.EnterProperProjectDescription();
        softAssert.assertEquals(ProperProjectDescription, ExpectedResult);
		softAssert.assertAll();
    }
    
    //Test for Invalid Field Name for Self Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void InvalidFieldName(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
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
		softAssert.assertAll();
    }
    
    // Test for Invalid Field Type for Self Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void InvalidFieldType(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,
    		String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
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
        //Perform actions to get successfull error message
        Actions actions = new Actions(driver); 
        actions.sendKeys(Keys.ESCAPE).perform();
        ProjectPage.clickOnAddBilling();
        
        
        String InvalidFieldType = ProjectPage.InvalidFielType() ;
        softAssert.assertEquals(InvalidFieldType, ExpectedResult);
		softAssert.assertAll();
    }
    
    //Test for Invalid Frequency for Self Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void InvalidFrequency(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
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
		softAssert.assertAll();
    }
    
    //Test for Invalid Radius for Self Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void InvalidRadius(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
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
		softAssert.assertAll();
    }
    
    //Test for Invalid Project Title for Self Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void InvalidProjectTitle(String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        //ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.clickOnSelectLocationButton();
        
        String InvalidProjectTitle = ProjectPage.InvalidProjectTitle();
        softAssert.assertEquals(InvalidProjectTitle, ExpectedResult);
		softAssert.assertAll();
    }
    
    //Create Project for New Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateNewProjectEnterprise(String Name,String Mobile,String Email,String Address,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName, String EnterFrequency, 
    		String EnterRadius,String EnterItem, String EnterDescription,String EnterRates,
    		String EnterQty, String EnterDays,String PaymentTerms, String TermsAndConditions,
            String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
       //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNewClient();
        ProjectPage.enterName(Name);
        ProjectPage.enterMobile(Mobile);
        ProjectPage.enterEmail(Email);
        ProjectPage.enterAddress(Address);
        //JavascriptExecutor js = (JavascriptExecutor) driver; 
       // js.executeScript("window.scrollBy(0,800)");
        Actions actions = new Actions(driver); 
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        ProjectPage.clickOnCreateEnterprise();
        Thread.sleep(2000);
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
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
        
        
        String ProjectEnterpriseCreatedSuccesfully = ProjectPage.EnterpriseProjectCreatedSuccesfully();
        softAssert.assertEquals(ProjectEnterpriseCreatedSuccesfully, ExpectedResult);
		softAssert.assertAll();
    }
    
    //Create Project for Existing Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateExistingProjectPageData(String ProjectTitle,String ProjectDescription,String ProjectCode,
    		String LinkTitle,String LinkURL,String EnterMetrics,String EnterQuantity,String CustomFieldName,
    		String ABCD,String FieldName,String EnterFrequency,String EnterRadius,String EnterItem, 
    		String EnterDescription,String EnterRates,String EnterQty, String EnterDays,
    		String PaymentTerms, String TermsAndConditions,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

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
		softAssert.assertAll();
    }
    
    //Existing Enterprise - Invalid Project Type
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidProjectType(String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

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
    //    ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnNext2Button();
        
        String ExistingInvalidProjectType = ProjectPage.ExistingInvalidProjectTitle();
        softAssert.assertEquals(ExistingInvalidProjectType, ExpectedResult);
		softAssert.assertAll();
    }
    
    // Existing Enterprise - Invalid Project Title
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidProjectTitle(String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

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
		softAssert.assertAll();
    }
    
    //Existing Enterprise - Invalid Project Description
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidProjectDesc(String ProjectTitle,String ProjectDescription,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

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
		softAssert.assertAll();
    }
    
    //Existing Enterprise - Invalid Field Name
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidFieldName(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

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
    
    
        String InvalidFieldName = ProjectPage.InvalidFieldName();
        softAssert.assertEquals(InvalidFieldName, ExpectedResult);
	    softAssert.assertAll();
}
    
    //Existing Enterprise - Invalid Frequency
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidFrequency(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);
    
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
	softAssert.assertAll();
}
    
    //Existing Enterprise - Invalid Radius
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ExistingInvalidRadius(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);
        
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
	softAssert.assertAll();
}
   
    //Self Enterprise - Send Proposals Without Bills
    
    @Test(dependsOnMethods = {"testcase.Login.login"},dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void SendProposalWithoutBill(String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String StartDate,String EndDate,String FieldName, String EnterFrequency, 
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        ProjectPage = new CreateProjectPage(driver);

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
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
      //ProjectPage.enterStartDate(StartDate);
        ProjectPage.clickOnSelectStartDate();
        ProjectPage.clickOnEndDateButton();
      //ProjectPage.enterEndDate(EndDate);
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
        Thread.sleep(2000);
        ProjectPage.ClickOnToggleSwitch();
   //     ProjectPage.clickOnPricingFixed();
   //     ProjectPage.enterItem(EnterItem);
   //     ProjectPage.enterDescription(EnterDescription);
   //     ProjectPage.enterRate(EnterRates);
   //     ProjectPage.enterQty(EnterQty);
   //     ProjectPage.enterDays(EnterDays);
        ProjectPage.clickOnReviewProject();
        ProjectPage.clickOnSaveProject();
        
        
        String SendProposalWithoutBill = ProjectPage.ProjectCreatedSuccesfully();
        softAssert.assertEquals(SendProposalWithoutBill, ExpectedResult);
		softAssert.assertAll();
    }
    
    
    
}