package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {
    public BlazeCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//tr[@class='success']")
    List<WebElement> allMacProCartInfo;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;


    public void validateCartInfo(String expectedTitle, String expectedPrice){
        List<String> expectedCartInfo = Arrays.asList("",expectedTitle,expectedPrice,"");
        for(int i=1;i<allMacProCartInfo.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(allMacProCartInfo.get(i)),expectedCartInfo.get(i));

        }
    }
    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
}
