package com.test.codeFishQA.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeFishQAHomePage {
    public CodeFishQAHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='nav-link']")
    List<WebElement> allHeaders;

    @FindBy(xpath = "//div[@class='card-body']//button[@class='btn btn-primary']")
    List<WebElement> addToCardAllButton;

    @FindBy(xpath = "//h5[@class='card-title']")
    List<WebElement> allTittles;

    public void validationNewUserCreated(String newUser){
        for(WebElement singleHeader:allHeaders){
            if(BrowserUtils.getText(singleHeader).contains(newUser)) {
                Assert.assertTrue(BrowserUtils.getText(singleHeader).contains(newUser));
                break;
            }
        }
    }
    public void selectVaccine(WebDriver driver){
        Map<WebElement,WebElement> allProducts=new HashMap<>();
        for(int i=0;i<allTittles.size();i++){
            BrowserUtils.scrollWithJS(driver,allTittles.get(i));
            allProducts.put(allTittles.get(i),addToCardAllButton.get(i));
        }
        for(Map.Entry<WebElement,WebElement> pair:allProducts.entrySet()){
            BrowserUtils.scrollWithJS(driver, pair.getKey());
            if(BrowserUtils.getText(pair.getKey()).contains("Vaccine")){
                pair.getValue().click();
            }
        }
        }

}
