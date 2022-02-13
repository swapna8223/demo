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
import java.util.ArrayList;
import java.util.List;


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

public void ClickSwitchdropdown(){
     WebElement ele = driver.findElement(By.xpath("//li/a[@href='SwitchTo.html'][1]"));
ele.click();
WebElement ele1 = driver.findElement(By.xpath("//ul/li[4]/a[contains(text(),'SwitchTo')]"));
ele1.click();
  //  WebElement ele2 = driver.findElement(By.xpath("//div/button[@class='btn btn-danger']"));
  // ele2.click();
  //  WebElement ele3 = driver.findElement(By.xpath("//div/ul/li[2]/a[contains(text(),'Alert with OK & Cancel')]"));
 //   ele3.click();
 //   WebElement ele4 = driver.findElement(By.xpath("//div/button[@class='btn btn-primary']"));
  //  ele4.click();
    WebElement ele5 = driver.findElement(By.xpath("//ul/li[3]/a[contains(text(),'Alert with Textbox ')]"));
      ele5.click();
    WebElement ele6= driver.findElement(By.xpath("//div/div[3]/button[@class='btn btn-info']"));
      ele6.click();

}

public void switchToWindows(){


//WebElement ele2 = driver.findElement(By.xpath("//ul/li[2]/a[contains(text(),'Windows')]"));
//ele2.click();
 //   WebElement ele3= driver.findElement(By.xpath("//ul/li/a[contains(text(),'Open New Tabbed Windows')]"));
 //   ele3.click();

    WebElement ele4= driver.findElement(By.xpath("//a/button[contains(text(),' click ')]"));
    ele4.click();
 }

 public void switchIframes(){
      WebElement iframe=driver.findElement(By.xpath("//ul/li/a[contains(text(),'Single Iframe ')]"));
     iframe.click();
 }

 public void datePicker(String date1){

 WebElement ele = driver.findElement(By.xpath("//div[1]/div/div/form/div[2]/div[2]"));
       ele.click();

       WebElement date2 = driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']"));
for(int i=1;i<=12;i++) {
    if (date2.getText() == date1) {
        date2.click();
    } else {

    }
}
     //  WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[2]"));
      //       ele2.click();
 }
 public void clickShop(){
     WebElement shp = driver.findElement(By.xpath("//li/a[contains(text(),'Shop')]"));
     shp.click();
     WebElement hom = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
     hom.click();
    WebElement img =  driver.findElement(By.xpath("//div[@class='col3-1 first sub_column sub_column_1-0-2-0 sub_column_post_22']"));
       img.isDisplayed();
       WebElement img1 = driver.findElement(By.xpath("//div[@class='col3-1 sub_column sub_column_1-0-2-1 sub_column_post_22']"));
  img1.isDisplayed();
     WebElement img2 = driver.findElement(By.xpath("//div[@class='col3-1 last sub_column sub_column_1-0-2-2 sub_column_post_22']"));
     img2.isDisplayed();

 }
 public void verifyBasketItems(){

     WebElement img1 = driver.findElement(By.xpath("//div[@class='col3-1 sub_column sub_column_1-0-2-1 sub_column_post_22']"));
     img1.click();
   WebElement  basketbutton = driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[5]/ul/li[1]/a[2]"));
   basketbutton.click();
   WebElement cart = driver.findElement(By.xpath("//*[@id='wpmenucartli']"));
  cart.click();
  WebElement checkbutton = driver.findElement(By.xpath("//div/a[contains(text(),'Proceed to Checkout')]"));
  checkbutton.click();
 }
public  void fillingDetails(String firstname){
     WebElement name1 = driver.findElement(By.id("billing_first_name"));
     name1.sendKeys(firstname);
 }
public void lastNameDetails(String lastname ,String Email) {
    WebElement name2 = driver.findElement(By.id("billing_last_name"));
    name2.sendKeys(lastname);
    WebElement  email = driver.findElement(By.id("billing_email"));
    email.sendKeys(Email);
}


}
