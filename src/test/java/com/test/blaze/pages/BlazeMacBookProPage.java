package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeMacBookProPage {
    public BlazeMacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[@class=\'name\']")
    WebElement header;

    @FindBy(tagName = "h3")
    WebElement priceCounter;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;
    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;

    public void macBookProInformation(String expectedHeader,String expectedPrice,String expectedDescription){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(priceCounter),expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(description),expectedDescription);
    }
   public void clickAddToCartButton(WebDriver driver,String expectedMessage) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedMessage);
        alert.accept();
   }
}
