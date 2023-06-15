package TestNG;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class OpenChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("QA_url"));
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys(ConfigReader.readProperty("QA_openChart_username"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys(ConfigReader.readProperty("QA_openChart_password"));
        password.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"Dashboard");
    }
    @Test
    public void negativeLoginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("DEMO");
        password.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement alert = driver.findElement(By.xpath("//div[@id='alert']"));
        Thread.sleep(3000);
        Assert.assertEquals(alert.getText().trim(),"No match for Username and/or Password.");
    }
    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        password.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed());
        Assert.assertTrue(productButton.isEnabled());
    }
    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("QA_url"));
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        password.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=1; i<=list.size();i++) {
            Thread.sleep(1000);
            Assert.assertTrue(list.get(i).isDisplayed());
            Assert.assertTrue(list.get(i).isEnabled());
            Assert.assertFalse(list.get(i).isSelected());//as default it should not be selected
            list.get(i).click();
            Assert.assertTrue(list.get(i).isSelected());//this one should be selected
            list.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }
    /*
TEST CASE:

1-You will click the productName button
2-You should create 2 arraylist
  *-One of them will be actualData
  *-Another will be expectedData
3-For(int i=1)
  *store all the names for both of the list.Please use at the end .toUpperCase or toLowerCase
4-For expected List -->you will use Collections.sort(expectedList)
                    -->Collections.reverse(expected)
                    Assert.equals(actualList,expectedlist)
 */
    @Test
    public void validateProductNameFunctionalityDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        password.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        List<WebElement> allData = driver.findElements(By.xpath("//td[@class='text-start']"));//11 elements
        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder= new ArrayList<>();
        for(int i=1;i<allData.size();i++){

            actualProductOrder.add(allData.get(i).getText().trim().toLowerCase());
            expectedProductOrder.add(allData.get(i).getText().trim().toLowerCase());


        }
        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);
    }
    @Test

    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        password.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(3000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();
        Thread.sleep(3000);
        List<WebElement> allData = driver.findElements(By.xpath("//td[@class='text-start']"));//11 elements
        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder= new ArrayList<>();
        Thread.sleep(3000);
        for(int i=1;i<allData.size();i++){

            actualProductOrder.add(allData.get(i).getText().trim().toLowerCase());
            expectedProductOrder.add(allData.get(i).getText().trim().toLowerCase());


        }
        Collections.sort(expectedProductOrder);
        Collections.reverse(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);
    }
}
