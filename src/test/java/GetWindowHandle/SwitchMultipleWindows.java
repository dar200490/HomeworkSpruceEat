package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {

    @Test
    public void practiceMultipleWindows(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.techtorialacademy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        String mainPageID = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();
        for(String id: allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver,"Contact us");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());
    }


    /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */

    @Test
    public void RealTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4 = driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        BrowserUtils.scrollWithJS(driver,firstName);
        firstName.sendKeys("Darya");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Yazepchyk");
        WebElement genderFemale = driver.findElement(By.xpath("//input[@id='femalerb']"));
        BrowserUtils.scrollWithJS(driver,genderFemale);
        if(genderFemale.isEnabled() && !genderFemale.isSelected()){
            genderFemale.click();
        }
        WebElement languageEnglish = driver.findElement(By.xpath("//input[@id='englishchbx']"));
        if(languageEnglish.isEnabled() && !languageEnglish.isSelected()){
            languageEnglish.click();
        }
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("dar200490@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345");
        WebElement registerButton = driver.findElement(By.xpath("//button[@id='registerbtn']"));
        BrowserUtils.scrollWithJS(driver,registerButton);
        Thread.sleep(2000);
        registerButton.click();
        WebElement message = driver.findElement(By.xpath("//label[@id='msg']"));
        String expectedMessage = "Registration is Successful";
        String actualMessage = BrowserUtils.getText(message);
        Assert.assertEquals(expectedMessage,actualMessage);
        BrowserUtils.switchByTitle(driver,"Window Handles Practice");
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Window')]"));
        String actualHeader = BrowserUtils.getText(header);
        String expectHeader = "Window Handles Practice";
        Assert.assertEquals(actualHeader,expectHeader);
        BrowserUtils.switchByTitle(driver,"AlertsDemo - H Y R Tutorials");
        Thread.sleep(2000);
        WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='promptBox']"));
        clickMeButton.click();
        driver.quit();
    }
}
