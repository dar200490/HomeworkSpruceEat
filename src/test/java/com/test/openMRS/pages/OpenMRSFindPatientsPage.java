package com.test.openMRS.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OpenMRSFindPatientsPage {
    public OpenMRSFindPatientsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "td")
    List<WebElement> allPatients;

    public void findPatient(WebDriver driver,String expectedPatientName){
        int count = 0;
        for(WebElement patientName:allPatients){
            BrowserUtils.scrollWithJS(driver,patientName);

            if(BrowserUtils.getText(patientName).equals(expectedPatientName)){
                count++;
            }
        }
        Assert.assertEquals(count,1);
    }
}
