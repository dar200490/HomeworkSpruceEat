package com.test.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMRSLoginPage {
    public OpenMRSLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//li[@id='Laboratory']")
    WebElement laboratory;
    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement loginButton;

    public void loginIntoLaboratory(String username, String password) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        if(laboratory.isEnabled() && !laboratory.isSelected()){
            laboratory.click();
            Thread.sleep(2000);
        }
        loginButton.click();
    }
}
