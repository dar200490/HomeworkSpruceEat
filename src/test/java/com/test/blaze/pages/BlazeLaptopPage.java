package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BlazeLaptopPage {
    public BlazeLaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> allLaptop;

    public void selectMacBookPro(WebDriver driver,String laptopName) throws InterruptedException {
        Thread.sleep(3000);
        for(WebElement laptop: allLaptop){
            BrowserUtils.scrollWithJS(driver,laptop);

            if(BrowserUtils.getText(laptop).equals(laptopName)){
                laptop.click();
                break;
            }
        }
    }




}
