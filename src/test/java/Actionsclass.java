import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actionsclass {
    public WebDriver driver;

    public Actionsclass(WebDriver driver){
this.driver = driver;

    }

    public void actionsClassDemo() throws InterruptedException{
        Actions act = new Actions(driver);
        WebElement img = driver.findElement(By.xpath("//img[@id='angular']"));
        WebElement tar = driver.findElement(By.xpath("//div[@id='droparea']"));
        act.dragAndDrop(img,tar).build().perform();
        Thread.sleep(2000);
    }






}
