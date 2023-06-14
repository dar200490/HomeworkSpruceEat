package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
     /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */
     public static void main(String[] args) {
          WebDriverManager.chromedriver().setup();
          ChromeOptions options = new ChromeOptions();
          options.addArguments("--remote-allow-origins=*");
          WebDriver driver = new ChromeDriver(options);
          driver.manage().window().maximize();
          driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
          //WebElement makeApptButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
          //CSS WITH ID
          WebElement makeApptButton = driver.findElement(By.cssSelector("#btn-make-appointment"));
          makeApptButton.click();
          WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
          userName.sendKeys("John Doe");
          WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
          password.sendKeys("ThisIsNotAPassword");
          WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
          loginButton.click();
          WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
          facility.sendKeys("Hongkong CURA Healthcare Center");
          WebElement hospitalBox = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
          if(hospitalBox.isDisplayed() && !hospitalBox.isSelected()){
               hospitalBox.click();
          }
          WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
          medicaid.click();
          WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
          date.sendKeys("18/05/2023");
          WebElement message = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
          message.sendKeys("Please schedule the appointment");
          //WebElement bookApptButton = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
          //CSS WITH CLASS
          WebElement bookApptButton = driver.findElement(By.cssSelector(".btn-default"));
          bookApptButton.click();
          WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));

          String actualHeader = header.getText().trim();
          String expectedHeader = "Appointment Confirmation";
          System.out.println(expectedHeader.equals(actualHeader)?"PASS":"FAILED");
          WebElement facility2 = driver.findElement(By.xpath("//p[contains(text(),'Hongkong CURA')]"));
          System.out.println(facility2.getText().trim());
          WebElement apply = driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
          System.out.println(apply.getText().trim());
          WebElement program = driver.findElement(By.xpath("//p[contains(text(),'Medicaid')]"));
          System.out.println(program.getText().trim());
          WebElement visitDate = driver.findElement(By.xpath("//p[.='18/05/2023']"));
          System.out.println(visitDate.getText().trim());
          WebElement commend = driver.findElement(By.xpath("//p[.='Please schedule the appointment']"));
          System.out.println(commend.getText().trim());
          WebElement homePage = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
          homePage.click();
          System.out.println(driver.getCurrentUrl());
          driver.close();
     }
}
