package com.test.codeFishQA.tests;

import com.test.codeFishQA.pages.CodeFishQALoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeFishQALoginTest extends CodeFishQATestBase{


    @Test
    public void validateLoginFunctionality() throws InterruptedException {
        CodeFishQALoginPage codeFishQALoginPage = new CodeFishQALoginPage(driver);
        codeFishQALoginPage.registerNewUser("8emily","123emily123",driver);

    }
}
