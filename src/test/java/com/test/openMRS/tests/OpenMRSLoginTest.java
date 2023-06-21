package com.test.openMRS.tests;

import com.test.openMRS.pages.OpenMRSFindPatientsPage;
import com.test.openMRS.pages.OpenMRSHomePage;
import com.test.openMRS.pages.OpenMRSLoginPage;
import org.testng.annotations.Test;

public class OpenMRSLoginTest extends OpenMRSTestBase{
    @Test
    public void validateLoginFunctionality() throws InterruptedException {
        OpenMRSLoginPage openMRSLoginPage=new OpenMRSLoginPage(driver);
        openMRSLoginPage.loginIntoLaboratory("admin","Admin123");
        OpenMRSHomePage openMRSHomePage=new OpenMRSHomePage(driver);
        openMRSHomePage.loginValidation("Logged in as Super User (admin) at Laboratory.");
        openMRSHomePage.changeLocation(driver,"Logged in as Super User (admin) at Pharmacy.");
        openMRSHomePage.chooseFunction("Find Patient Record");
        OpenMRSFindPatientsPage openMRSFindPatientsPage=new OpenMRSFindPatientsPage(driver);
        openMRSFindPatientsPage.findPatient(driver,"John johnes");
    }
}
