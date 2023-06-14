package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        WebElement title = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(title));
        String mainPageID = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());//main PageID -->The internet
        Set<String> allPagesID = driver.getWindowHandles();
        for(String id: allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }

        }
        title = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(title));
    }
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        Thread.sleep(2000);

        WebElement openNewTab = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        BrowserUtils.scrollWithJS(driver,openNewTab);
        Thread.sleep(2000);
        openNewTab.click();
        Thread.sleep(2000);
        String mainPageID = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();
        for(String id: allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle);
        String actualHeader = BrowserUtils.getText(driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]")));
        String expectedHeader = "AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();

    }
}
