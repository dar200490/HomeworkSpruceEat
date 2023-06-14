package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazePlaceOrderTest extends BlazeTestBase{



    @Test
    public void verifyPlaceOrderFunctionality() throws InterruptedException {
        BlazeHomePage blazeHomePage = new BlazeHomePage(driver);
        BlazeLaptopPage blazeLaptopPage = new BlazeLaptopPage(driver);
        BlazeMacBookProPage blazeMacBookProPage = new BlazeMacBookProPage(driver);
        blazeHomePage.selectProduct("Laptops");
        blazeLaptopPage.selectMacBookPro(driver,"MacBook Pro");
        blazeMacBookProPage.macBookProInformation("MacBook Pro","$1100 *includes tax",
                "Product description\n" + "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        blazeMacBookProPage.clickAddToCartButton(driver,"Product added");
        blazeHomePage.clickCartButton();
        BlazeCartPage blazeCartPage = new BlazeCartPage(driver);
        blazeCartPage.clickPlaceOrderButton();
        BlazePlaceOrderPage blazePlaceOrderPage = new BlazePlaceOrderPage(driver);
        blazePlaceOrderPage.placeOrderFunctionality("Darya Yazepchyk","USA","Phila","123456789","June",
                "2023","Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/index.html");
    }
}
