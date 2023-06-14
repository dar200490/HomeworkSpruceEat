package com.test.OpenChart.tests;

import com.test.OpenChart.pages.OpenCartCustomerPage;
import com.test.OpenChart.pages.OpenCartLoginPage;
import com.test.OpenChart.pages.OpenCartMainPage;
import org.testng.annotations.Test;

public class OpenCartCustomerTest extends OpenChartTestBase{

   @Test
    public void validateAlertCreatingNewCustomer() throws InterruptedException {
       OpenCartMainPage openCartMainPage = new OpenCartMainPage(driver);
       OpenCartCustomerPage openCartCustomerPage= new OpenCartCustomerPage(driver);
       OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
       openCartLoginPage.loginFunctionality("demo","demo");
       openCartMainPage.openCustomerPage();
       openCartCustomerPage.alertMessageFromNewCustomerCreating("Darya","Yazepchyk","dar200490@gmail.com",
               "12345","12345",driver,"Warning: You do not have permission to modify customers!");
   }


}
