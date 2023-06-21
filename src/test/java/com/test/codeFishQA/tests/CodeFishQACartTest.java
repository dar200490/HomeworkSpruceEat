package com.test.codeFishQA.tests;

import com.test.codeFishQA.pages.CodeFishQACartPage;
import com.test.codeFishQA.pages.CodeFishQAHomePage;
import com.test.codeFishQA.pages.CodeFishQALoginPage;
import org.testng.annotations.Test;

public class CodeFishQACartTest extends CodeFishQATestBase{
    @Test
    public void addedProductToCartFunctionality() throws InterruptedException {
        CodeFishQAHomePage codeFishQAHomePage=new CodeFishQAHomePage(driver);
        CodeFishQALoginPage codeFishQALoginPage = new CodeFishQALoginPage(driver);
        CodeFishQACartPage codeFishQACartPage = new CodeFishQACartPage(driver);
        codeFishQALoginPage.registerNewUser("14emily","123emily123",driver);
        codeFishQAHomePage.validationNewUserCreated("14emily");
        codeFishQAHomePage.selectVaccine(driver);
        codeFishQACartPage.cartProducts(driver);
    }
}
