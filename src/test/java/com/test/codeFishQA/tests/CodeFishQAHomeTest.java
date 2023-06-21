package com.test.codeFishQA.tests;

import com.test.codeFishQA.pages.CodeFishQAHomePage;
import com.test.codeFishQA.pages.CodeFishQALoginPage;
import org.testng.annotations.Test;

public class CodeFishQAHomeTest extends CodeFishQATestBase{
    @Test
    public void validateNewUserLogged() throws InterruptedException {
        CodeFishQAHomePage codeFishQAHomePage=new CodeFishQAHomePage(driver);
        CodeFishQALoginPage codeFishQALoginPage = new CodeFishQALoginPage(driver);
        codeFishQALoginPage.registerNewUser("10emily","123emily123",driver);
        codeFishQAHomePage.validationNewUserCreated("10emily");
        codeFishQAHomePage.selectVaccine(driver);

    }
}
