import jdk.internal.instrumentation.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class homePageTest extends basePage {

    homePage homepage;
    ConfigManager configManager;
    String criteria;
    Actionsclass actionclass;

    @BeforeMethod
    public void baseSetup() {
        homepage = new homePage(getDriver());
        configManager = new ConfigManager();
        criteria = configManager.getProperty("searchcriteria");
       actionclass =new Actionsclass(getDriver());

    }


    @Test
    public void myFirstTest() {

        homepage.enterSearchCriteria(criteria);
        homepage.clickSearchButton();

    }

    @Test
    public void searchVerification() throws InterruptedException {
        String search = configManager.getProperty("searchphone");
        homepage.deleteCookies();
        homepage.enterSearchCriteria(search);
        homepage.clickSearchButton();
        String phone = configManager.getProperty("phonetype");
        homepage.clickPhone(phone);
        homepage.addToCart();
        homepage.proceedToCheckout();
        String userName = configManager.getProperty("Email");
        homepage.enterEmail(userName);
        homepage.clickBasket();
        homepage.verifySerchResult(phone);
        //   homepage.verifySearchResultsWereDisplayed();

    }

    @Test
    public void selectOptionFromDropDown() {
        String search = configManager.getProperty("option");
        homepage.selectOptionFromDropDown(search);
    }

    @Test
    public void clickMattress() {
        homepage.selectMattresses();
    }

    @Test
    public void verifyText() {
        homepage.clickFeedBack();


    }

    @Test
    public void ClickSwitchDropdown() {
        homepage.ClickSwitchdropdown();
        //driver.switchTo().alert().accept();
        // driver.switchTo().alert().dismiss();
        driver.switchTo().alert().sendKeys("swapna");
        driver.switchTo().alert().accept();

    }

    @Test
    public void switchToWindows() {
        homepage.switchToWindows();
        int numWindow = driver.getWindowHandles().size();
        String[] window = (String[]) driver.getWindowHandles().toArray(new String[numWindow]);
        driver.switchTo().window(window[1]);
        driver.close();
        driver.switchTo().window(window[0]);

        homepage.switchToWindows();
        String s = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            String t = driver.switchTo().window(handle).getTitle();
            System.out.println(t);
            if (t.contains("Frames & windows")) {
                driver.close();
            }
        }

    }

    @Test
    public void switchIframe() {
        //  driver.switchTo().frame("Frames");
        homepage.switchIframes();
    }
   @Test
   public void actionsClassTest() throws InterruptedException{
       actionclass.actionsClassDemo();

    }
    @Test
    public void datePicker(){
        String date1 = configManager.getProperty("datePicker");
        homepage.datePicker(date1);
    }

    @Test
    public  void clickShop() {
        homepage.clickShop();
    }

    @Test
    public void verifyBasketItems(){
        homepage.clickShop();
        homepage.verifyBasketItems();
        String  firstname = configManager.getProperty("name");
        homepage.fillingDetails(firstname);
        String Email= configManager.getProperty("email");
        String lastname = configManager.getProperty("lastName");
            homepage.lastNameDetails(lastname,Email);

           // homepage.lastNameDetails(Email);
    }
}