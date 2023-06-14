package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {

        //LOCATORS-->it a way to locAte(find) element and manipulate on it
        public static void main(String[] args) throws InterruptedException {
        //ID LOCATOR:
            WebDriverManager.chromedriver().setup();
            ChromeOptions options= new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.navigate().to("file:///C:/Users/dar20/Downloads/Techtorial.html");
            driver.manage().window().maximize();
            WebElement header = driver.findElement(By.id("techtorial1"));
            String actualHeader=header.getText().trim();//it gets the text from element
            String expectedHeader = "Techtorial Academy";
            System.out.println(header.getText());
            System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT": "WRONG");
            WebElement paragraph = driver.findElement(By.id("details2"));
            System.out.println(paragraph.getText());

            //NAME LOCATOR
            WebElement firstName = driver.findElement(By.name("firstName"));
            firstName.sendKeys("Dasha");
            WebElement lastName = driver.findElement(By.name("lastName"));
            lastName.sendKeys("Yazepchyk");
            WebElement phone = driver.findElement(By.name("phone"));
            phone.sendKeys("2158345171");
            WebElement email = driver.findElement(By.id("userName"));
            email.sendKeys("dar200490@gmail.com");
            WebElement address = driver.findElement(By.name("address1"));
            address.sendKeys("238 Sycamore Cir");
            WebElement city = driver.findElement(By.name("city"));
            city.sendKeys("Feasterville");
            WebElement state = driver.findElement(By.name("state"));
            state.sendKeys("PA");
            WebElement code = driver.findElement(By.name("postalCode"));
            code.sendKeys("19053");


            //CLASS LOCATOR
            WebElement allTools = driver.findElement(By.className("group_checkbox"));
            System.out.println(allTools.getText());
            WebElement javaBox = driver.findElement(By.id("cond1"));
            if(javaBox.isDisplayed() && !javaBox.isSelected()){
                javaBox.click();
            }
            System.out.println(javaBox.isSelected()?"SELECTED":"NOT SELECTED");

            WebElement testNGBox = driver.findElement(By.id("cond3"));
            if(testNGBox.isDisplayed() && !testNGBox.isSelected()){
                testNGBox.click();
            }
            System.out.println(testNGBox.isSelected()?"SELECTED":"NOT SELECTED");
            WebElement cucumberBox = driver.findElement(By.id("cond4"));
            if(cucumberBox.isDisplayed() && !cucumberBox.isSelected()){
                cucumberBox.click();
            }
            System.out.println(cucumberBox.isSelected()?"SELECTED":"NOT SELECTED");

            //TAG NAME LOCATOR:
            WebElement header2 = driver.findElement(By.tagName("h1"));
            System.out.println(header2.getText());
            WebElement javaVersion = driver.findElement(By.tagName("u"));
            System.out.println(javaVersion.getText());

            Thread.sleep(2000);

            driver.quit();












    }
}
