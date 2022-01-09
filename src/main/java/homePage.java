import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import javax.swing.text.html.Option;


public class homePage  {
 public WebDriver driver;

 public homePage(WebDriver driver){
  this.driver=driver;
 }


@FindBy(id="twotabsearchtextbox")
 public WebElement SEARCH_BAR_FIELD;
 @FindBy(id="nav-search-submit-button")
 public WebElement SEARCH_BUTTON;


 public void enterSearchCriteria(String searchType){
 WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
 element.sendKeys(searchType);

 }
  public void clickSearchButton(){
   WebElement element = driver.findElement(By.id("nav-search-submit-button"));
   element.click();
}
public void verifySearchResultsWereDisplayed(){
  WebElement myelement = driver.findElement(By.xpath("//a[@data-elementid='sbx-headline']/span[contains(text(),'iPhone 13. Your new superpower.')]"));

  Assert.assertTrue(myelement.isDisplayed());
  }


public void selectOptionFromDropDown(String option){

   WebElement ele = driver.findElement(By.id("searchDropdownBox"));
    Select val = new Select(ele);
    val.selectByVisibleText(option);
}

public void clickPhone(String phonetype){
    WebDriverWait wait=new WebDriverWait(driver,60);
    By ele=By.xpath("//a/span[contains(text(),'"+phonetype+"')]");
    wait.until(ExpectedConditions.elementToBeClickable(ele));
     WebElement ele1 =driver.findElement(ele);

     ele1.click();
}
public void addToCart() throws InterruptedException{

         WebDriverWait wait = new WebDriverWait(driver, 60);

         By ele = (By.xpath("//input[@id='add-to-cart-button']"));
         wait.until(ExpectedConditions.elementToBeClickable(ele));
         WebElement ele1 = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
         WebElement ele2 = driver.findElement(By.xpath("//span[@id='attachSiAddCoverage']//input"));
         Thread.sleep(3000);
         ele1.click();
         ele2.click();

}
public void proceedToCheckout(){
     WebElement ele = driver.findElement(By.xpath("//div[@class='a-row a-spacing-top-small']//span[@id='attach-sidesheet-checkout-button']"));
     ele.click();
}
public void clickBasket(){
    WebElement ele =driver.findElement(By.id("nav-cart-count"));
    ele.click();
}


public void verifySerchResult(String phonetype){
    WebElement ele= driver.findElement(By.xpath("//span/span[contains(text(),'"+phonetype+"'"));
     ele.isDisplayed();

}
public void deleteCookies(){
     WebElement ele= driver.findElement(By.id("sp-cc-accept"));
ele.click();
}

public void enterEmail(String userName){
     WebElement ele = driver.findElement(By.name("email"));
     ele.sendKeys(userName);
WebElement ele1= driver.findElement(By.id("continue"));
ele1.click();
}

public void selectMattresses(){
Actions action = new Actions(driver);
WebElement  ele = driver.findElement(By.id("mattress-compare-link"));
action.moveToElement(ele).perform();
WebElement ele1 = driver.findElement(By.linkText(""));
ele1.click();
}
public void clickFeedBack(){
 WebDriverWait wait = new WebDriverWait(driver ,60);
  wait.until(ExpectedConditions.elementToBeClickable(By.id("QSIFeedbackButton-btn"))).click();
   //  WebElement feedbackelement = driver.findElement(By.id("QSIFeedbackButton-btn"));
   // feedbackelement.click();
    driver.switchTo().frame("QSIFeedbackButton-survey-iframe");
    WebElement ratingele = driver.findElement(By.xpath("//div[@class='QuestionBody']//tbody//tr//td[3]//span//label[@id='QID1-3-label']"));
    ratingele.click();
    WebElement titleele= driver.findElement(By.id("NextButton"));
     titleele.click();
      WebElement ele=driver.findElement(By.xpath("//div[contains(text(),'Thank you')]"));
                    ele.isDisplayed();
 Assert.assertTrue(ele.isDisplayed());
    Assert.assertEquals(ele.isDisplayed(),true);
    //driver.switchTo().frame("epik_localstore");
    driver.switchTo().defaultContent();
    WebElement ele1 = driver.findElement(By.xpath("//div//button[@id='QSIFeedbackButton-close-btn']"));
       ele1.click();

}
}
