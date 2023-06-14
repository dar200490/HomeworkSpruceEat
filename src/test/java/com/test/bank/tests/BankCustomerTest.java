package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerLoginPage;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase{
    @Test
    public void validateCustomerLoginTransactions() throws InterruptedException {
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,"Darya","Yazepchyk","19053",
                "Customer added successfully with customer id");
        bankManagerPage.openAccountFunctionality(driver,"Darya Yazepchyk","Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality("Darya","Yazepchyk","19053");
        loginPage.clickHomeButton();
        loginPage.customerLoginButton();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.loginFunctionality("Darya Yazepchyk","Darya Yazepchyk");
        customerLoginPage.customerDepositFunctionality("500","Deposit Successful");
        customerLoginPage.customerWithdrawalFunctionality(driver,"300","Transaction successful");
        customerLoginPage.transactionFunctionality();
    }

}
