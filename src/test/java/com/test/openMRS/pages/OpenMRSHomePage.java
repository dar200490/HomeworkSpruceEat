package com.test.openMRS.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OpenMRSHomePage {
    public OpenMRSHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "h4")
    WebElement loggedMessage;

    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement location;
    @FindBy(xpath = "//li[contains(text(),'Pharmacy')]")
    WebElement pharmacyLocation;
    @FindBy(xpath = "//a//img")
    WebElement logo;
    @FindBy(xpath = "//a[@class='button app big']")
    List<WebElement> allFunctions;
    public void loginValidation(String expectedMessage){
        Assert.assertEquals(BrowserUtils.getText(loggedMessage),expectedMessage);
    }
    public void changeLocation(WebDriver driver,String expectedMessage) throws InterruptedException {
        location.click();
        Thread.sleep(500);
        pharmacyLocation.click();
        Thread.sleep(2000);
        logo.click();
        Assert.assertEquals(BrowserUtils.getText(loggedMessage),expectedMessage);
    }
    public void chooseFunction(String expectedFunction) throws InterruptedException {
        for(WebElement function: allFunctions){
            Thread.sleep(500);
            if(BrowserUtils.getText(function).equals(expectedFunction)){
                function.click();
                break;
            }
        }
    }
}
