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

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
   @Test
   public void validateOrderMessage() throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options= new ChromeOptions();
      options.addArguments("--remove-allow-origins=*");
      WebDriver driver = new ChromeDriver(options);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
      /*
      1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
       */
      WebElement type = driver.findElement(By.xpath("//input[@value='oneway']"));
      type.click();
      WebElement numberOfPassengers = driver.findElement(By.xpath("//select[@name='passCount']"));
      Select passengers = new Select(numberOfPassengers);
      passengers.selectByValue("4");
      WebElement departingFromButton = driver.findElement(By.xpath("//select[@name='fromPort']"));
      Select departCountry = new Select(departingFromButton);
      String defaultDepartCountry = departCountry.getFirstSelectedOption().getText().trim();
      String expectedDefaultCountry = "Acapulco".trim();
      Assert.assertEquals(expectedDefaultCountry,defaultDepartCountry);
      departCountry.selectByVisibleText("Paris");
      WebElement months = driver.findElement(By.xpath("//select[@name='fromMonth']"));
      Select monthToDepart = new Select(months);
      monthToDepart.selectByIndex(9);
      WebElement dayToDepart = driver.findElement(By.xpath("//select[@name='fromDay']"));
      Select departDay = new Select(dayToDepart);
      departDay.selectByVisibleText("15");
      Thread.sleep(3000);
      WebElement arrivingIn = driver.findElement(By.xpath("//select[@name='toPort']"));
      Select arrivingPort = new Select(arrivingIn);
      arrivingPort.selectByVisibleText("San Francisco");
      WebElement returningMonths = driver.findElement(By.xpath("//select[@name='toMonth']"));
      Select monthToArrive = new Select(returningMonths);
      monthToArrive.selectByVisibleText("December");
      WebElement dayToArrive = driver.findElement(By.xpath("//select[@name='toDay']"));
      Select arriveDay = new Select(dayToArrive);
      arriveDay.selectByValue("15");
      WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
      serviceClass.click();
      WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
      Select airlinesOptions = new Select(airlines);
      List<WebElement> allAirlinesOptions = airlinesOptions.getOptions();
      List<String> expectedOptionsAirlines = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
      for(int i=0;i<allAirlinesOptions.size();i++){
         Assert.assertEquals(allAirlinesOptions.get(i).getText().trim(),expectedOptionsAirlines.get(i));
      }
      airlinesOptions.selectByVisibleText("Unified Airlines");
      WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
      continueButton.click();
      Thread.sleep(3000);
      WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
      String actualMessage = message.getText().trim();
      String expectedMessage = "After flight finder - No Seats Available";
      Assert.assertEquals(actualMessage,expectedMessage);

   }

   @Test
   public void validateOrderMessageShortCut() throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options= new ChromeOptions();
      options.addArguments("--remove-allow-origins=*");
      WebDriver driver = new ChromeDriver(options);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

      WebElement type = driver.findElement(By.xpath("//input[@value='oneway']"));
      type.click();
      WebElement numberOfPassengers = driver.findElement(By.xpath("//select[@name='passCount']"));
      BrowserUtils.selectBy(numberOfPassengers,"4","value");
      WebElement departingFromButton = driver.findElement(By.xpath("//select[@name='fromPort']"));
      Select departCountry = new Select(departingFromButton);
      String defaultDepartCountry = departCountry.getFirstSelectedOption().getText().trim();
      String expectedDefaultCountry = "Acapulco".trim();
      Assert.assertEquals(expectedDefaultCountry,defaultDepartCountry);
      BrowserUtils.selectBy(departingFromButton,"Paris","text");
      WebElement months = driver.findElement(By.xpath("//select[@name='fromMonth']"));
      BrowserUtils.selectBy(months,"9","index");
      WebElement dayToDepart = driver.findElement(By.xpath("//select[@name='fromDay']"));
      BrowserUtils.selectBy(dayToDepart,"15","text");
      Thread.sleep(3000);
      WebElement arrivingIn = driver.findElement(By.xpath("//select[@name='toPort']"));
      BrowserUtils.selectBy(arrivingIn,"San Francisco","text");
      WebElement returningMonths = driver.findElement(By.xpath("//select[@name='toMonth']"));
      BrowserUtils.selectBy(returningMonths,"December","text");
      WebElement dayToArrive = driver.findElement(By.xpath("//select[@name='toDay']"));
      BrowserUtils.selectBy(dayToArrive,"15","value");
      WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
      serviceClass.click();
      WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
      Select airlinesOptions = new Select(airlines);
      List<WebElement> allAirlinesOptions = airlinesOptions.getOptions();
      List<String> expectedOptionsAirlines = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
      for(int i=0;i<allAirlinesOptions.size();i++){
         Assert.assertEquals(BrowserUtils.getText(allAirlinesOptions.get(i)),expectedOptionsAirlines.get(i).trim());
      }
      airlinesOptions.selectByVisibleText("Unified Airlines");
      WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
      continueButton.click();
      Thread.sleep(3000);
      WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
      Assert.assertEquals(BrowserUtils.getText(message),"After flight finder - No Seats Available");
   }
}
