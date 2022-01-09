import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class UrlNameVerification {
    WebDriver driver;
  @Test
  public void test(){

    System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.navigate().to("https://www.boots.com/");
      driver.manage().deleteAllCookies();
 String str = driver.getTitle();
 System.out.print(str);

      Assert.assertTrue(str.equals("Beauty | Health | Pharmacy and Prescriptions - Boots"));

      }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
  }


