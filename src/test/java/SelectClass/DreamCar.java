package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
    */
    @Test
    public void headersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        WebElement conditionOfTheCar = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(conditionOfTheCar,"New","text");
        WebElement makeButton = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeButton,"lexus","value");
        WebElement modelButton = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(modelButton,"lexus-rx_350","value");
        WebElement priceButton = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select selector = new Select(priceButton);
        String actualPrice = BrowserUtils.getText(selector.getFirstSelectedOption());
        String expectedPrice = "No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
        WebElement distanceButton = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distanceButton,"3","index");
        WebElement zipCodeButton = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCodeButton.clear();
        zipCodeButton.sendKeys("60056");
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();
        WebElement header = driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        Assert.assertEquals(BrowserUtils.getText(header),"New Lexus RX 350 for sale");
        WebElement sortByPriceButton = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        Thread.sleep(3000);
        BrowserUtils.selectBy(sortByPriceButton,"Lowest price","text");
        Thread.sleep(3000);
        List<WebElement> titles = driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement singleTitle: titles){
            Thread.sleep(3000);

            Assert.assertTrue(BrowserUtils.getText(singleTitle).contains("Lexus RX 350"));

        }
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> expectedPrices = new ArrayList<>();
        List<Integer> actualPrices = new ArrayList<>();
        for(WebElement price: prices){
            expectedPrices.add(Integer.parseInt(BrowserUtils.getText(price).replace("$","").replace(",","")));
            actualPrices.add(Integer.parseInt(BrowserUtils.getText(price).replace("$","").replace(",","")));
        }
        Collections.sort(expectedPrices);
        Assert.assertEquals(expectedPrices,actualPrices);
        System.out.println(expectedPrices);
        System.out.println(actualPrices);





    }
}
