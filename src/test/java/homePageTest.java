import jdk.internal.instrumentation.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homePageTest extends basePage {

    homePage homepage;
    ConfigManager configManager;
    String criteria;

    @BeforeMethod
    public void baseSetup() {
        homepage = new homePage(getDriver());
        configManager = new ConfigManager();
        criteria = configManager.getProperty("searchcriteria");
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
    public void verifyText(){
homepage.clickFeedBack();


    }




}