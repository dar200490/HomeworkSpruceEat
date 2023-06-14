package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazePlaceOrderPage {
    public BlazePlaceOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCard;
    @FindBy(xpath = "//input[@id='month']")
    WebElement month;
    @FindBy(xpath = "//input[@id='year']")
    WebElement year;
    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchaseButton;

    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']//h2")
    WebElement purchasedMessage;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okButton;

    public void placeOrderFunctionality(String name,String country,String city,String creditCard, String month, String year,
                                        String expectedMessage){

        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();
        Assert.assertEquals(BrowserUtils.getText(purchasedMessage),expectedMessage);
        okButton.click();
    }

}
