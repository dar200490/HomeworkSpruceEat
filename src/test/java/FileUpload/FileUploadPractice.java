package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\dar20\\OneDrive\\Рабочий стол\\usa (1).png");
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        WebElement validateFileName = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualName = BrowserUtils.getText(validateFileName);
        String expectedName = "usa (1).png";
        Assert.assertEquals(actualName,expectedName);
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\dar20\\OneDrive\\Рабочий стол\\Application-Subsidized Child Care.pdf");
        WebElement text = driver.findElement(By.xpath("//b[contains(text(),'Select')]"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualText,expectedText);
        WebElement termsAccept = driver.findElement(By.cssSelector("#terms"));
        if(termsAccept.isDisplayed() && !termsAccept.isSelected() && termsAccept.isEnabled()){
            termsAccept.click();
        }
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.tagName("h3"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
