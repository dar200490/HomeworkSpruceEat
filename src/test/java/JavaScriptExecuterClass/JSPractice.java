package JavaScriptExecuterClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesButton);
        WebElement message = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement impressiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        js.executeScript("arguments[0].click()",impressiveButton);
        String actualMessageImpressive = BrowserUtils.getText(message);
        String expectedMessageImpressive = "You have selected Impressive";
        Assert.assertEquals(actualMessageImpressive,expectedMessageImpressive);
        WebElement noButton = driver.findElement(By.xpath("//input[@id='noRadio']"));
        Assert.assertTrue(!noButton.isEnabled());
    }
@Test
public void practice2() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remove-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.techtorialacademy.com/");
    WebElement messageOnButton= driver.findElement(By.xpath("//div[contains(text(),'Copyright © 2023')]"));
    BrowserUtils.scrollWithJS(driver,messageOnButton);
    String actualMessageOnButton = BrowserUtils.getText(messageOnButton);
    String expectedMessageOnButton = "Copyright © 2023";
    Assert.assertEquals(actualMessageOnButton,expectedMessageOnButton);
    Thread.sleep(2000);
    WebElement applyNow = driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]"));
    WebElement tech = driver.findElement(By.xpath("//b[.='LAUNCH A NEW TECH CAREER']"));
    BrowserUtils.scrollWithJS(driver,tech);
    BrowserUtils.clickWithJS(driver,applyNow);
    Thread.sleep(2000);
    String actualTitle = BrowserUtils.getTitleWithJS(driver);
    String expectedTitle = "Apply Now";
    Assert.assertEquals(actualTitle,expectedTitle);
    List<WebElement> allElements = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
    List<String> expectedMessages = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
    List<String> actualMessages = new ArrayList<>();
    for(int i=0;i<allElements.size();i++){
        Assert.assertEquals(BrowserUtils.getText(allElements.get(i)),expectedMessages.get(i));
    }


}
}