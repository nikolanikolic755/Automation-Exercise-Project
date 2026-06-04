package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTests extends BaseTest {

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

// Adds a valid session cookie to simulate a logged-in user
        Cookie cookie = new Cookie("sessionid", "n7mhy1ptcfqr5l7ipubje58ftwkz4wdp");
        driver.manage().addCookie(cookie);

        // Refreshes the page to apply the session cookie
        driver.navigate().refresh();
    }

    // Verifies that user can successfully complete checkout process with one product
    @Test(priority = 1)
    public void verifyUserCanCompleteCheckoutProcessWithOneItem() {

        navigationMenu.clickProducts();
        productsPage.clickAddBlueTopToCart();
        productsPage.clickContinueShopping();
        navigationMenu.clickCart();

        // Verify that Blue Top product is displayed in the cart
        Assert.assertTrue(cartPage.getBlueTopItem().isDisplayed());

        cartPage.clickProceedToCheckout();

        // Verify that user is redirected to the checkout page
        Assert.assertTrue(checkoutPage.getPlaceOrderButton().isDisplayed());

        checkoutPage.clickPlaceOrder();

        paymentPage.fillPaymentForm("Nikola", "1234", "123", "5", "2029");
        paymentPage.clickPayAndConfirm();

        // Wait until Order Placed message becomes visible
        wait.until(ExpectedConditions.visibilityOf(paymentPage.getOrderPlacedMessage()));

        // Verify that Order Placed message is displayed
        Assert.assertTrue(paymentPage.getOrderPlacedMessage().isDisplayed());

        // Verify that order confirmation message is displayed
        Assert.assertTrue(paymentPage.getOrderConfirmedMessageText().contains("Congratulations! Your order has been confirmed!"));

    }

    // Verifies that user cannot proceed to checkout with an empty cart
    @Test(priority = 2)
    public void verifyUserCannotProceedToCheckoutWithEmptyCart() {

        navigationMenu.clickCart();

        // Verify that cart empty message is displayed
        Assert.assertTrue(cartPage.getCartIsEmptyMessage().isDisplayed());

        try {

            cartPage.clickProceedToCheckout();

            // Fail the test if user is able to proceed to checkout with an empty cart
            Assert.fail("Assertion failed failed! User can proceed to checkout with empty cart");

        } catch (Exception e) {

            // Test passes if checkout cannot be accessed with an empty cart
            System.out.println("Assertion passed! User cannot proceed to checkout with empty cart");

        }
    }

    //Verifies that total price displayed on checkout page is correct
    @Test(priority = 3)
    public void verifyTotalPriceIsCorrectOnCheckoutPage() {

        navigationMenu.clickProducts();
        productsPage.clickAddBlueTopToCart();
        productsPage.clickContinueShopping();
        productsPage.clickAddMenTshirtToCart();
        productsPage.clickContinueShopping();
        navigationMenu.clickCart();
        cartPage.clickProceedToCheckout();

        //Verifies that total price displayed on checkout page is correct
        Assert.assertTrue(checkoutPage.cartTotalAmount().contains("900"));
    }

    // Clears cookies and closes browser after each test
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
