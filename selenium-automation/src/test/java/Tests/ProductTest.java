package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest extends BaseTest {

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

    // Verifies that products are displayed on the Products page
    @Test(priority = 1)
    public void verifyProductsAreDisplayedOnProductsPage() {

        navigationMenu.clickProducts();

        Assert.assertTrue(productsPage.getWinterTopItem().isDisplayed());
        Assert.assertTrue(productsPage.getMenTshirtItem().isDisplayed());
        Assert.assertTrue(productsPage.getSleevelessDressItem().isDisplayed());
        Assert.assertTrue(productsPage.getStylishDressItem().isDisplayed());
    }

    // Verifies that user can open a product details page
    @Test(priority = 2)
    public void verifyUserCanOpenProductDetailPage() {
        homePage.clickViewProductBlueTop();

        //Verify that user is redirected to the Blue Top product details page
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.getBlueTopProductDetailsURL());

        // Verify that Blue Top product name is displayed on the product details page
        Assert.assertTrue(productsPage.blueTopProductNameText().contains("Blue Top"));
    }

    // Verifies that product search returns correct results
    @Test(priority = 3)
    public void verifyProductSearchReturnsCorrectResults() {
        navigationMenu.clickProducts();
        productsPage.inputSearchProductField("Winter top");
        productsPage.clickSearchButton();

        try {
            // Verify that products not matching the search criteria are not displayed
            Assert.assertFalse(productsPage.getMenTshirtItem().isDisplayed());
            Assert.assertFalse(productsPage.getSleevelessDressItem().isDisplayed());
            Assert.assertFalse(productsPage.getStylishDressItem().isDisplayed());

            // Fail the test if unrelated products are still visible
            Assert.fail("Assertion failed! Items not included in search are still visible!");

        } catch (Exception e) {
            // Test passes if unrelated products are not displayed in search results
            System.out.println("Assertion passed! Items not included in search are not visible!");
        }

        //Verify that Winter Top product is displayed in search results
        Assert.assertTrue(productsPage.getWinterTopItem().isDisplayed());


    }

    // Clears cookies and closes browser after each test
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
