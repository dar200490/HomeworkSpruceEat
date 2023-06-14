package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlazeHomePage {
    public BlazeHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//a[@id='itemc']")
    List<WebElement> products;

    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cartButton;



    public void selectProduct(String productName) throws InterruptedException {
        for (WebElement singleProduct : products) {
            Thread.sleep(1000);
            if (BrowserUtils.getText(singleProduct).equals(productName)) {
                singleProduct.click();
                break;
            }
        }
    }
    public void clickCartButton(){
        cartButton.click();
    }
}
