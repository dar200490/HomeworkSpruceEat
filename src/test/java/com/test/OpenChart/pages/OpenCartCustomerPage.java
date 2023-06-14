package com.test.OpenChart.pages;

import Utils.BrowserUtils;
import com.test.OpenChart.tests.OpenChartTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenCartCustomerPage{
    public OpenCartCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addButton;

    @FindBy (xpath = "//input[@name='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='confirm']")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='input-newsletter']")
    WebElement newsletterSlide;

    @FindBy(xpath = "//input[@id='input-status']")
    WebElement statusSlide;

    @FindBy(xpath = "//input[@id='input-safe']")
    WebElement safeSlide;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    @FindBy(xpath = "//div[@id='alert']//div")
    WebElement alertMessage;

    public void alertMessageFromNewCustomerCreating(String firstName,String lastName, String email, String password,
                                                 String confirmPassword,WebDriver driver,String expectedMessage) throws InterruptedException {
        addButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        Thread.sleep(2000);
        this.confirmPassword.sendKeys(confirmPassword);
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,safeSlide);
        BrowserUtils.clickWithJS(driver,newsletterSlide);
        Thread.sleep(2000);
        statusSlide.click();
        Thread.sleep(2000);
        safeSlide.click();
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,saveButton);
        BrowserUtils.clickWithJS(driver,saveButton);
        Assert.assertEquals(BrowserUtils.getText(alertMessage),expectedMessage);
    }
}
