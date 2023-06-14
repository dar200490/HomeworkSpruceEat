package FramesAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FramePractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement frame = driver.findElement(By.cssSelector("#tinymce"));
        frame.clear();
        frame.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        System.out.println(BrowserUtils.getText(header));
    }

    /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Python Tutorial"
  5-Print out(NO validation) all the links from website
  6-Wait for Second task
 */

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");
        Actions actions = new Actions(driver);
        WebElement seleniumButton = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(seleniumButton).perform();
        Thread.sleep(2000);
        WebElement javaPython = driver.findElement(By.linkText("Selenium-Python"));
        actions.click(javaPython).perform();

        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Selenium-Python Tutorial";
        Assert.assertEquals(actualHeader,expectedHeader);
        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));
        for(WebElement singleLink: allLinks){
            System.out.println(BrowserUtils.getText(singleLink));
        }
        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        WebElement header2 = driver.findElement(By.tagName("h1"));
        String expectedHeader2 = "Category Archives: SeleniumTesting";
        Assert.assertEquals(BrowserUtils.getText(header2),expectedHeader2);
        List<WebElement> allLinks2 = driver.findElements(By.xpath("//h3[@class='entry-title']//a[@rel='bookmark']"));
        for(WebElement singleLink: allLinks2){
            System.out.println(BrowserUtils.getText(singleLink));
        }
        /*
TASK 3:
1-Go back mainPage
2-print out I am inside Frame under category1
3-Click Category3
4-Print out the header
 */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement frame1 = driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(frame1));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        Thread.sleep(2000);
        WebElement header3 = driver.findElement(By.tagName("h1"));
        String expectedHeader3 = "Category Archives: SoftwareTesting";
        Assert.assertEquals(BrowserUtils.getText(header3),expectedHeader3);



    }
}
