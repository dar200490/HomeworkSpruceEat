package com.test.codeFishQA.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CodeFishQACartPage {
    public CodeFishQACartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;
    @FindBy(tagName = "td")
    List<WebElement> allLines;

    public void cartProducts(WebDriver driver) throws InterruptedException {
        BrowserUtils.clickWithJS(driver,cartButton);
        Thread.sleep(2000);
        for(WebElement singleLine:allLines){
            if(BrowserUtils.getText(singleLine).contains("Pfizer Vaccine") || BrowserUtils.getText(singleLine).contains("Sputnik Vaccine")){
                Assert.assertTrue(BrowserUtils.getText(singleLine).contains("Sputnik Vaccine")
                        || BrowserUtils.getText(singleLine).contains("Pfizer Vaccine"));
            }
        }
    }
}
