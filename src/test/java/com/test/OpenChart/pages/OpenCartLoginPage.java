package com.test.OpenChart.pages;

import Utils.BrowserUtils;
import com.test.bank.pages.BankLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenCartLoginPage {
    public OpenCartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(tagName = "button")
    WebElement loginButton;

    @FindBy(css = "#alert")
    WebElement errorMessage;


    public void loginFunctionality(String username,String password) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();Thread.sleep(2000);
    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }

}
