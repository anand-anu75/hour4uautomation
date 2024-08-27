package testcase;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.WithdrawCredit;
import utilities.ReadXLData;

public class WithdrawCreditTest extends BaseTest {
    private WithdrawCredit withdrawCredit;

    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_valid_Upi(String Email, String Password, String Amount, String Upi, String Remark, String Otp) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clearAndEnterUpi(Upi);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
        withdrawCredit.enterOtp(Otp);
        withdrawCredit.clickNext();
    }
    
    
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_valid_Bank(String Email, String Password, String Amount, String BankAccountNumber, String BankAccountConfirm, String IFSCcode,String AccountHolderName, String Remark, String Otp) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clickRadioButton();
        withdrawCredit.enterBankAccount(BankAccountNumber);
        withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
        withdrawCredit.enterIFSCcode(IFSCcode);
        withdrawCredit.enterAccountHolderName(AccountHolderName);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
        withdrawCredit.enterOtp(Otp);
        withdrawCredit.clickNext();
    }
    
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_Invalid_Upi(String Email, String Password, String Amount, String Upi, String Remark) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clearAndEnterUpi(Upi);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
    }
    
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_Invalid_BankNumber(String Email, String Password, String Amount, String BankAccountNumber, String BankAccountConfirm, String IFSCcode,String AccountHolderName, String Remark) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clickRadioButton();
        withdrawCredit.enterBankAccount(BankAccountNumber);
        withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
        withdrawCredit.enterIFSCcode(IFSCcode);
        withdrawCredit.enterAccountHolderName(AccountHolderName);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
    }
    
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_Invalid_BankNumber2(String Email, String Password, String Amount, String BankAccountNumber, String BankAccountConfirm, String IFSCcode,String AccountHolderName, String Remark) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clickRadioButton();
        withdrawCredit.enterBankAccount(BankAccountNumber);
        withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
        withdrawCredit.enterIFSCcode(IFSCcode);
        withdrawCredit.enterAccountHolderName(AccountHolderName);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
    }
    
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_Invalid_IFSCcode(String Email, String Password, String Amount, String BankAccountNumber, String BankAccountConfirm, String IFSCcode,String AccountHolderName, String Remark) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clickRadioButton();
        withdrawCredit.enterBankAccount(BankAccountNumber);
        withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
        withdrawCredit.enterIFSCcode(IFSCcode);
        withdrawCredit.enterAccountHolderName(AccountHolderName);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
    }
    
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_Short_IFSCcode(String Email, String Password, String Amount, String BankAccountNumber, String BankAccountConfirm, String IFSCcode,String AccountHolderName, String Remark) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clickRadioButton();
        withdrawCredit.enterBankAccount(BankAccountNumber);
        withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
        withdrawCredit.enterIFSCcode(IFSCcode);
        withdrawCredit.enterAccountHolderName(AccountHolderName);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
    }
    
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_Invalid_Name(String Email, String Password, String Amount, String BankAccountNumber, String BankAccountConfirm, String IFSCcode,String AccountHolderName, String Remark) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clickRadioButton();
        withdrawCredit.enterBankAccount(BankAccountNumber);
        withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
        withdrawCredit.enterIFSCcode(IFSCcode);
        withdrawCredit.enterAccountHolderName(AccountHolderName);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
    }
    
    @Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void Withdraw_Short_Name(String Email, String Password, String Amount, String BankAccountNumber, String BankAccountConfirm, String IFSCcode,String AccountHolderName, String Remark) {
        withdrawCredit = new WithdrawCredit(driver);
        withdrawCredit.enterEmail(Email);
        withdrawCredit.enterPassword(Password);
        withdrawCredit.clickLoginButton();
        withdrawCredit.clickCreditButton();
        withdrawCredit.clickWithdrawButton();
        withdrawCredit.enterAmount(Amount);
        withdrawCredit.clickNext();
        withdrawCredit.clickRadioButton();
        withdrawCredit.enterBankAccount(BankAccountNumber);
        withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
        withdrawCredit.enterIFSCcode(IFSCcode);
        withdrawCredit.enterAccountHolderName(AccountHolderName);
        withdrawCredit.enterRemark(Remark);
        withdrawCredit.clickCheckBox();
        withdrawCredit.clickNext();
    }
}