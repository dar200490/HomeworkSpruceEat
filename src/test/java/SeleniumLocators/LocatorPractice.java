package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Darya");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Yazepchyk");
        Thread.sleep(2000);
        WebElement gender = driver.findElement(By.id("sex-0"));
        if (gender.isDisplayed() && !gender.isSelected()){
            gender.click();
        }
        WebElement yearsOfExperience = driver.findElement(By.id("exp-4"));
        yearsOfExperience.click();
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("05/17/2023");
        Thread.sleep(2000);
        WebElement profession1 = driver.findElement(By.id("profession-0"));
        profession1.click();
        WebElement profession2 = driver.findElement(By.id("profession-1"));
        profession2.click();
        WebElement automationTool = driver.findElement(By.id("tool-2"));
        automationTool.click();
        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("North America");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualURL.equals(expectedURL)?"CORRECT":"WRONG");
        driver.close();
    }
}
