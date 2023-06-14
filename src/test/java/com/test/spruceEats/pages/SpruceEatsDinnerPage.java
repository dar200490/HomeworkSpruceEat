package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SpruceEatsDinnerPage {
    public SpruceEatsDinnerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//div[@id='facet_starRating_score']//li[1]")
    WebElement fourRating;

    @FindBy (xpath = "//label[@for='pop_search_editor']")
    WebElement editorChoice;

    @FindBy (xpath = "//span[@class='card__underline']")
    WebElement nameOfProduct;

    public void findProductReceipt(String expectedName) throws InterruptedException {
        if(fourRating.isEnabled() && !fourRating.isSelected()){
            fourRating.click();
        }
        Thread.sleep(1000);
        if(editorChoice.isEnabled() && !editorChoice.isSelected()){
            editorChoice.click();
        }
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(nameOfProduct),expectedName);
    }

}
