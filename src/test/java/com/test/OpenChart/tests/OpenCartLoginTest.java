package com.test.OpenChart.tests;

import com.test.OpenChart.pages.OpenCartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartLoginTest extends OpenChartTestBase{

   @Test
   public void happyPathLogin() throws InterruptedException {
       OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
       openCartLoginPage.loginFunctionality("demo","demo");
       Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
   }

   @Test
    public void validateNegativeLogin() throws InterruptedException {
       OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
       openCartLoginPage.loginFunctionality("wrongUsername","wrongPassword");
       Assert.assertEquals(openCartLoginPage.errorMessage(),"No match for Username and/or Password.");

   }
}
