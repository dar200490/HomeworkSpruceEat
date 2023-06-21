package com.test.openMRS.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OpenMRSNewPatientPage {
    public OpenMRSNewPatientPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='givenName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='familyName']")
    WebElement lastName;
    @FindBy(xpath = "//span[@id='genderLabel']")
    WebElement genderButton;
    @FindBy(xpath = "//option[.='Female']")
    WebElement female;
    @FindBy(xpath = "//span[@id='birthdateLabel']")
    WebElement birthday;
    @FindBy(xpath = "//input[@name='birthdateDay']")
    WebElement day;
    @FindBy(xpath = "//select[@name='birthdateMonth']")
    WebElement month;
    @FindBy(xpath = "//input[@name='birthdateYear']")
    WebElement year;
    @FindBy(xpath = "//span[.='Address']")
    WebElement address;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressLine;
    @FindBy(xpath = "//input[@id='cityVillage']")
    WebElement city;
    @FindBy(xpath = "//input[@id='stateProvince']")
    WebElement state;
    @FindBy(xpath = "//input[@id='country']")
    WebElement country;
    @FindBy(xpath = "//input[@id='postalCode']")
    WebElement postalCode;
    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phoneNumber;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumberLine;
    @FindBy(xpath = "//span[@id='confirmation_label']")
    WebElement confirmButton;
    @FindBy(xpath = "//div[@id='dataCanvas']//div//p")
    List<WebElement> enteredInfo;
    @FindBy(xpath = "//input[@id='submit']")
    WebElement submitButton;

    public void creatingNewPatient(String firstName,String lastName,String birthDay,String birthMonth,String bithYear,String address,
                                   String city,String state,String country,String postalCode,String phoneNumber){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        genderButton.click();
        female.click();
        birthday.click();
        day.sendKeys(birthDay);
        BrowserUtils.selectBy(month,birthMonth,"text");
        year.sendKeys(bithYear);
        this.address.click();
        this.addressLine.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.country.sendKeys(country);
        this.postalCode.sendKeys(postalCode);
        this.phoneNumber.click();
        phoneNumberLine.sendKeys(phoneNumber);
        confirmButton.click();
        for(int i=0;i< enteredInfo.size();i++){
            if(i==1) {
                Assert.assertEquals(BrowserUtils.getText(enteredInfo.get(i)), "Darya Yazepchyk");
            }else if (i==2) {
                Assert.assertEquals(BrowserUtils.getText(enteredInfo.get(i)), "Female");
            }else if(i==3) {
                Assert.assertEquals(BrowserUtils.getText(enteredInfo.get(i)), "20, April, 1990");
            }else if(i==4) {
                Assert.assertEquals(BrowserUtils.getText(enteredInfo.get(i)), "2200 E Devonave, D e s Plain s, IL, cook, 60018");
            }else if(i==5){
                Assert.assertEquals(BrowserUtils.getText(enteredInfo.get(i)),"9 9 6 5 2 1 8 0 5 9 2");
                    }
                }
        submitButton.click();
            }

        }




