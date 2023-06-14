package com.test.spruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceEatsHomePage {
    public SpruceEatsHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//li[@class='global-nav__list-item js-global-nav-item']//a//span[contains(text(),'Ingredients')]")
    WebElement ingredientsButton;

    @FindBy(xpath = "//a[contains(text(),'Fish & Seafood')]")
    WebElement fishAndSeafood;

    public void chooseSeafoodReceipts(WebDriver driver){
        Actions action = new Actions(driver);
        action.clickAndHold(ingredientsButton).perform();
        action.moveToElement(fishAndSeafood).click().perform();

    }


}
