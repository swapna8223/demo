
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class basePage {
    public WebDriver driver;

public WebDriver getDriver(){
    return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }



    @BeforeTest
    public void intialization() {
        System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    //    driver.get("https://www.amazon.co.uk/");
        driver.get("https://purple.com/");
}

    @AfterTest
    public void tearDown(){
    driver.close();
    }

}
