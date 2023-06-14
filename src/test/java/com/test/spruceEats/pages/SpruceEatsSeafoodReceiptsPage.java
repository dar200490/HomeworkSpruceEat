package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceEatsSeafoodReceiptsPage {
    public SpruceEatsSeafoodReceiptsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//input[@id='search-form-input']")
    WebElement searchLine;

    @FindBy (xpath = "//form[@action='/search/']//button[contains(text(),'Search')]")
    WebElement searchButton;

    public void findReceipt(WebDriver driver){
        BrowserUtils.scrollWithJS(driver,searchLine);
        searchLine.sendKeys("Fish for dinner");
        searchButton.submit();

    }
}
