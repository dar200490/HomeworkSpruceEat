package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Darya");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Yazepchyk");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("dar2004100@gmail.com");
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        telephone.sendKeys("2158345171");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("darya12345");
        WebElement passwordConf = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConf.sendKeys("darya12345");
        WebElement policyPrivacy = driver.findElement(By.xpath("//input[@name='agree']"));
        policyPrivacy.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        WebElement messageCreated = driver.findElement(By.xpath("//h1[contains(text(),'Has Been Created!')]"));
        String message = messageCreated.getText().trim();
        if(message.equals("Your Account Has Been Created!")){
            WebElement continue2 = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
            continue2.click();
        }
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(currentURL.equals(expectedURL)?"PASS":"FAILED");
    }
}
