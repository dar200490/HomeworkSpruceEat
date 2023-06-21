package com.test.codeFishQA.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class CodeFishQALoginPage {
    public CodeFishQALoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement login;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@name='regbtn']")
    WebElement registerButton;
    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement registerButton2;
    @FindBy(xpath = "//div[@class='errorMessage alert alert-danger']")
    WebElement alertMessage;
    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement loginButton;




    public void registerNewUser(String username,String password,WebDriver driver) throws InterruptedException {
        registerButton.click();
        login.sendKeys(username);
        this.password.sendKeys(password);
        registerButton2.click();
        Thread.sleep(3000);
        login.clear();
        Thread.sleep(3000);
        login.sendKeys(username);
        this.password.clear();
        Thread.sleep(3000);
        this.password.sendKeys(password);
        Thread.sleep(3000);
        loginButton.click();

    }

}
