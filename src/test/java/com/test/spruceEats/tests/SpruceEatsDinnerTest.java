package com.test.spruceEats.tests;

import com.test.spruceEats.pages.SpruceEatsDinnerPage;
import com.test.spruceEats.pages.SpruceEatsHomePage;
import com.test.spruceEats.pages.SpruceEatsSeafoodReceiptsPage;
import org.testng.annotations.Test;

public class SpruceEatsDinnerTest extends SpruceEatsTestBase{

    @Test
    public void findProductReceiptFunctionality() throws InterruptedException {
        SpruceEatsHomePage spruceEatsHomePage = new SpruceEatsHomePage(driver);
        SpruceEatsDinnerPage spruceEatsDinnerPage = new SpruceEatsDinnerPage(driver);
        SpruceEatsSeafoodReceiptsPage spruceEatsSeafoodReceiptsPage = new SpruceEatsSeafoodReceiptsPage(driver);
        spruceEatsHomePage.chooseSeafoodReceipts(driver);
        spruceEatsSeafoodReceiptsPage.findReceipt(driver);
        spruceEatsDinnerPage.findProductReceipt("6-Ingredient Roasted Salmon Fillets");
    }
}
