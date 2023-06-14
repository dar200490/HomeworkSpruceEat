package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerLoginPage {
    public CustomerLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#userSelect")
    WebElement selectYourNameButton;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//strong//span")
    WebElement customerHeader;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement amountLine;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement messageTransaction;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawalButton;

    @FindBy(xpath = "//input")
    WebElement withdrawalAmountLine;

    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement balance;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositCredit;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawDebit;

    public void loginFunctionality(String customerName, String expectedMessage) throws InterruptedException {
        BrowserUtils.selectBy(selectYourNameButton,customerName,"text");
        Thread.sleep(2000);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(customerHeader),expectedMessage);
    }
    public void customerDepositFunctionality(String depositAmount,String expectedMessage) throws InterruptedException {
        depositButton.click();
        amountLine.sendKeys(depositAmount);
        Thread.sleep(500);
        submitButton.submit();
        Assert.assertEquals(BrowserUtils.getText(messageTransaction),expectedMessage);
    }
    public void customerWithdrawalFunctionality(WebDriver driver,String withdrawalAmount,String expectedMessage) throws InterruptedException {
        withdrawalButton.click();
        Thread.sleep(500);
        withdrawalAmountLine.sendKeys(withdrawalAmount);
        WebElement submitWithdrawButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitWithdrawButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(messageTransaction),expectedMessage);
    }
    public void transactionFunctionality() throws InterruptedException {
        int actualBalance = Integer.parseInt(BrowserUtils.getText(balance));
        Thread.sleep(3000);
        transactionButton.click();
        int expectedBalance = (Integer.parseInt(BrowserUtils.getText(depositCredit)))-Integer.parseInt(BrowserUtils.getText(withdrawDebit));
        Assert.assertEquals(actualBalance,expectedBalance);
    }
}
