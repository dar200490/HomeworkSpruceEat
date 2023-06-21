package com.test.openMRS.tests;

import com.test.openMRS.pages.OpenMRSHomePage;
import com.test.openMRS.pages.OpenMRSLoginPage;
import com.test.openMRS.pages.OpenMRSNewPatientPage;
import org.testng.annotations.Test;

public class OpenMRSPatientTest extends OpenMRSTestBase{
@Test
    public void newPatientCreationFunctionality() throws InterruptedException {
    OpenMRSLoginPage openMRSLoginPage=new OpenMRSLoginPage(driver);
    openMRSLoginPage.loginIntoLaboratory("admin","Admin123");
    OpenMRSHomePage openMRSHomePage=new OpenMRSHomePage(driver);
    openMRSHomePage.chooseFunction("Register a patient");
    OpenMRSNewPatientPage openMRSNewPatientPage = new OpenMRSNewPatientPage(driver);
    openMRSNewPatientPage.creatingNewPatient("Darya","Yazepchyk","20","April","1990",
            "2200 E Devonave","D e s Plain s","IL","cook","60018","9 9 6 5 2 1 8 0 5 9 2");
}
}
