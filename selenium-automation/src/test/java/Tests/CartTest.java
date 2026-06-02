package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        contactUsPage = new ContactUsPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        signupPage = new SignupPage(driver);
        navigationMenu= new NavigationMenu(driver);
    }

    @Test(priority = 1)
    public void verifyUserCanAddMultipleItemsToCart(){

        navigationMenu.clickProducts();
        productsPage.clikAddBlueTopToCart();
        productsPage.clickContinueShopping();
        productsPage.clickAddManTshirtToCart();
        productsPage.clickContinueShopping();


        Assert.assertEquals(driver.getCurrentUrl(),cartPage.cartURL());
        Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());
        Assert.assertTrue(cartPage.getMenTshirtItem().isDisplayed());
    }
        @Test(priority = 2)
                public void verifyUserCanRemoveItemFromCart(){

        }


    @Test(priority = 3)
    public void verifyProductRemainInCartAfterPageRefresh(){
        navigationMenu.clickProducts();
        productsPage.clikAddBlueTopToCart();
        productsPage.clickContinueShopping();
        navigationMenu.clickCart();
        Assert.assertEquals(driver.getCurrentUrl(),cartPage.cartURL());
        Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());
        driver.navigate().refresh();
        Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());
    }

}
