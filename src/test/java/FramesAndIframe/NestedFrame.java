package FramesAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void NestedFramePractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        //Name or ID iframe
        driver.switchTo().frame("frame-top");
        //WebElement iframe
        WebElement iframeLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));
        driver.switchTo().parentFrame();
        WebElement iframeMiddle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(iframeMiddle);
        WebElement middle = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(middle));
        driver.switchTo().parentFrame();
        WebElement iframeRight = driver.findElement(By.xpath("//frame[@name='frame-right']"));
        driver.switchTo().frame(iframeRight);
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));
        //switching frame with index
//        driver.switchTo().parentFrame();//top frame
//        driver.switchTo().parentFrame();// main html
        driver.switchTo().defaultContent();//this will go main html no matter what
        driver.switchTo().frame(1);//switching frame with indexing
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));

    }
}
