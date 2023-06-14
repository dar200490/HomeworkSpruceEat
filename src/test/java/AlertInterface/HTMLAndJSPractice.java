package AlertInterface;

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

import java.time.Duration;

public class HTMLAndJSPractice {
    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement clickJS = driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//..//button"));
        clickJS.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        String actualAlertText = alert.getText();
        String expectedAlertText = "Oops, something went wrong!";
        Assert.assertEquals(actualAlertText,expectedAlertText);
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);
        WebElement clickHTML = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        clickHTML.click();
        Thread.sleep(2000);
        WebElement messageHTML = driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualMessageHTML = BrowserUtils.getText(messageHTML);
        String expectedMessageHTML = "Something went wrong!";
        Assert.assertEquals(actualMessageHTML,expectedMessageHTML);
        WebElement okButton = driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
    }
}
