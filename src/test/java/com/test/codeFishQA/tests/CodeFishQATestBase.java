package com.test.codeFishQA.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class CodeFishQATestBase {
    public WebDriver driver;
    @BeforeTest
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get("http://codefish-io-qa.s3-website-ap-northeast-1.amazonaws.com/");
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"CodeFishQAPicture");
        }
        //driver.quit();
    }
}
