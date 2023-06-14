package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorIntro2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/dar20/Downloads/Techtorial.html");

        //LINKTEXT LOCATOR
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader)?"CORRECT":"FALSE");

        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */

        driver.navigate().back();
        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        String actualHeaderSel = seleniumHeader.getText().trim();
        String expectedHeaderSel = "Selenium automates browsers. That's it!";
        System.out.println(actualHeaderSel.equals(expectedHeaderSel)?"CORRECT":"FAILED");
        driver.navigate().back();
        WebElement cucumberLink = driver.findElement(By.linkText ("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        String actualHeaderCuc = cucumberHeader.getText().trim();
        String expectedHeaderCuc = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualHeaderCuc.equals(expectedHeaderCuc)?"CORRECT":"FAILED");
        driver.navigate().back();
        WebElement testNGLink = driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement testNGHeader = driver.findElement(By.tagName("h2"));
        String actualHeaderTestNG = testNGHeader.getText().trim();
        String expectedHeaderTestNG = "TestNG";
        System.out.println(expectedHeaderTestNG.equals(actualHeaderTestNG)?"CORRECT":"FAILED");
        driver.navigate().back();
        String currecntURL = driver.getCurrentUrl();
        String expectedURL = "file:///C:/Users/dar20/Downloads/Techtorial.html";
        System.out.println(expectedURL.equals(currecntURL)?"PASS":"FAILED");


        //LOCATER PARTIALLINKTEXT:
        WebElement restAPI = driver.findElement(By.partialLinkText("Rest"));
        restAPI.click();
        System.out.println(driver.getTitle());





    }
}
