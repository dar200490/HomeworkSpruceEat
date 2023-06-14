package com.test.OpenChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartMainPage {
    public OpenCartMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
   @FindBy (css = ".btn-close")
    WebElement closeButton;

    @FindBy(xpath = "//a[contains(text(),' Customers')]")
    WebElement customerParentButton;

    @FindBy (xpath = "//ul[@id='collapse-5']//li//a[contains(text(),'Customers')]")
    WebElement customerChildButton;

    public void openCustomerPage(){
        closeButton.click();
        customerParentButton.click();
        customerChildButton.click();
    }
}

