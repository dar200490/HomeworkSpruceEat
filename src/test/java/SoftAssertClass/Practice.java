package SoftAssertClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Practice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement clickFirst = driver.findElement(By.xpath("//button[contains(@id,'alertBox')]"));
        clickFirst.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//div[contains(@id,'output')]"));
        String actualMessage1 = BrowserUtils.getText(message);
        String expectedMessage1 = "You selected alert popup";
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualMessage1,expectedMessage1);
        System.out.println(BrowserUtils.getText(message));
        WebElement clickSecond = driver.findElement(By.xpath("//button[contains(@id,'confirmBox')]"));
        BrowserUtils.scrollWithJS(driver,clickSecond);
        clickSecond.click();
        alert.dismiss();
        String actualMessage2 = BrowserUtils.getText(message);
        String expectedMessage2 = "You pressed Cancel in confirmation popupa";
        softAssert.assertEquals(actualMessage2,expectedMessage2);
        System.out.println(BrowserUtils.getText(message));
        WebElement clickThird = driver.findElement(By.xpath("//button[contains(@id,'promptBox')]"));
        BrowserUtils.scrollWithJS(driver,clickThird);
        clickThird.click();
        alert.sendKeys("Darya");
        alert.accept();
        String actualMessage3= BrowserUtils.getText(message);
        String expectedMessage3= "You entered text Darya in prompt popup";
        softAssert.assertEquals(actualMessage3,expectedMessage3);
        System.out.println(BrowserUtils.getText(message));
        softAssert.assertAll();
    }
}
