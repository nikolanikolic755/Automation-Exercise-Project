package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {


    // Initializes browser, wait, page objects and opens the home page before each test
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
        navigationMenu = new NavigationMenu(driver);
        paymentPage = new PaymentPage(driver);
    }

    // Verifies that user can add multiple products to the cart
    @Test(priority = 1)
    public void verifyUserCanAddMultipleItemsToCart() {

        navigationMenu.clickProducts();
        productsPage.clickAddBlueTopToCart();
        productsPage.clickContinueShopping();
        productsPage.clickAddMenTshirtToCart();
        productsPage.clickContinueShopping();
        navigationMenu.clickCart();

        // Verify that user is redirected to the cart page
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.cartURL());

        // Verify that Blue Top product is displayed in the cart
        Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());

        // Verify that Men Tshirt product is displayed in the cart
        Assert.assertTrue(cartPage.getMenTshirtItem().isDisplayed());
    }

    // Verifies that user can remove a product from the cart
    @Test(priority = 2)
    public void verifyUserCanRemoveItemFromCart() {

        navigationMenu.clickProducts();
        productsPage.clickAddBlueTopToCart();
        productsPage.clickContinueShopping();
        navigationMenu.clickCart();

        // Verify that Blue Top product is displayed in the cart before removal
        Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());

        cartPage.removeItem();

        // Wait until cart empty message becomes visible
        wait.until(ExpectedConditions.visibilityOf(cartPage.getCartIsEmptyMessage()));

        // Verify that cart empty message is displayed
        Assert.assertTrue(cartPage.getCartIsEmptyMessage().isDisplayed());

        try {
            Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());
            Assert.fail("Assertion failed, item still present in cart!");
        } catch (Exception e) {
            System.out.println("Assertion passed! Item is removed from the cart!");
        }
    }

    // Verifies that products remain in the cart after page refresh
    @Test(priority = 3)
    public void verifyProductRemainInCartAfterPageRefresh() {

        navigationMenu.clickProducts();
        productsPage.clickAddBlueTopToCart();
        productsPage.clickContinueShopping();
        navigationMenu.clickCart();

        // Verify that user is redirected to the cart page
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.cartURL());

        // Verify that Blue Top product is displayed before page refresh
        Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());

        driver.navigate().refresh();

        // Verify that Blue Top product remains in the cart after page refresh
        Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());
    }

    // Closes browser and clears cookies after each test
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}