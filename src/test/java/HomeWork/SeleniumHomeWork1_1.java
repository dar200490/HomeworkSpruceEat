package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumHomeWork1_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Darya Yazepchyk");
        WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("dar200490@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("238 Sycamore Cir");
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("805 Red Lion Rd");
        Thread.sleep(3000);
        permanentAddress.sendKeys(Keys.ENTER);
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
        String fullName1= "Name:Darya Yazepchyk";
        String userEmail1 = "Email:dar200490@gmail.com";
        String currentAddress1 = "Current Address :238 Sycamore Cir";
        String permanentAddress1 = "Permanent Address :805 Red Lion Rd";
        if(fullName1.equals(driver.findElement(By.xpath("//p[@id='name']")).getText().trim())){
            System.out.println("The full name is displayed and match");
        }else{
            System.out.println("The full name is not match");
        }
        if(userEmail1.equals(driver.findElement(By.xpath("//p[@id='email']")).getText().trim())){
            System.out.println("The email is displayed and match");
        }else{
            System.out.println("The email is not match");
        }
        if(currentAddress1.equals(driver.findElement(By.xpath("//p[@id='currentAddress']")).getText().trim())){
            System.out.println("The current address is displayed and match");
        }else{
            System.out.println("The current address is not match");
        }
        if(permanentAddress1.equals(driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText().trim())){
            System.out.println("The permanent address is displayed and match");
        }else{
            System.out.println("The permanent address is not match");
        }



    }
}
