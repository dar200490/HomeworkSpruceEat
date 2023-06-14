package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;

public class MovingSlider {
    @Test
    public void validateSliderFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.tagName("input"));
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));
        String expectedRange = "4.5";
        while(!BrowserUtils.getText(range).equals(expectedRange)){
            Thread.sleep(1000);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
}
