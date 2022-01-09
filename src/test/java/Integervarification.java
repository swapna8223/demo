import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Integervarification {
    WebDriver driver;
   @Test
    public void verification(){
       System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\Drivers\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.navigate().to("https://www.boots.com/");
     //  driver.manage().deleteAllCookies();
       driver.findElement(By.id("onetrust-accept-btn-handler")).click();
       driver.findElement(By.xpath("//img[@class='desktop']")).click();
        WebElement ele = driver.findElement(By.id("CatalogEntryProdImg_2561518"));
           ele.click();
              String str = "£40";

           int a =  Integer.parseInt(str.replace("£" , ""));
           System.out.print(a);
       Assert.assertEquals(a , 40 );
   }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
