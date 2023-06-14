package ActionsClass;

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

public class PracticeActions {
    @Test
    public void practiceDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = draggable.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']//p"));
        String actualDropBoxMessage = BrowserUtils.getText(droppable);
        String expectedDropBoxMessage = "Drop here";
        Assert.assertEquals(actualDropBoxMessage,expectedDropBoxMessage);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();
        Thread.sleep(2000);
        droppable = draggable.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessageAfterDrop = BrowserUtils.getText(droppable);
        String expectedMessageAfterDrop = "Dropped!";
        Assert.assertEquals(actualMessageAfterDrop,expectedMessageAfterDrop);
        String actualBackgroundColor = droppable.getCssValue("background-color");
        String expectedBackgroundColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualBackgroundColor,expectedBackgroundColor);
    }
    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement acceptButton = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();
        Thread.sleep(2000);
        WebElement notAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));
        String actualMessageNotAcceptable = BrowserUtils.getText(notAcceptable);
        String expectedMessageNotAcceptable = "Not Acceptable";
        Assert.assertEquals(actualMessageNotAcceptable, expectedMessageNotAcceptable);
        Thread.sleep(2000);
        WebElement dropHereBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessageDropBox = BrowserUtils.getText(dropHereBox);
        String expectedMessageDropBox = "Drop here";
        Assert.assertEquals(actualMessageDropBox,expectedMessageDropBox);
        Actions actions = new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(dropHereBox).release().perform();
        String actualMessageAfterDrop = BrowserUtils.getText(dropHereBox);
        String expectedMessageAfterDrop = "Drop here";
        Assert.assertEquals(actualMessageAfterDrop,expectedMessageAfterDrop);
    }
}
