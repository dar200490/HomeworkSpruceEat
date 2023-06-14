package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
import java.util.List;

public class SelectPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/dar20/Downloads/Techtorial.html");
        //Task 1: Validate the default option is selected UNITED STATES
        WebElement dropdown = driver.findElement(By.xpath("//select[@name='country']"));
        Select choice = new Select(dropdown);
        String defaultCountry = choice.getFirstSelectedOption().getText().trim();
        String expectedCountry = "UNITED STATES";
        Assert.assertEquals(defaultCountry,expectedCountry);
        //Task 2: Print out all the options and count how many countries
        List<WebElement> allCountries = choice.getOptions();
        int counter = 0;
        for(WebElement country: allCountries){
            System.out.println(country.getText().trim());
            counter++;
        }
        System.out.println(counter);
        //chose your country, favorite country, and country to travel
        choice.selectByVisibleText("BELARUS ");
        Thread.sleep(3000);
        choice.selectByValue("96");
        Thread.sleep(3000);
        choice.selectByIndex(131);
    }
}
