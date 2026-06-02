package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest extends BaseTest {

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
    }
    @Test(priority = 1)
    public void verifyProductsAreDisplayedOnProductsPage(){
        navigationMenu.clickProducts();

        Assert.assertTrue(productsPage.getWinterTopItem().isDisplayed());
        Assert.assertTrue(productsPage.getMenTshirtItem().isDisplayed());
        Assert.assertTrue(productsPage.getSleevelessDressItem().isDisplayed());
        Assert.assertTrue(productsPage.getStylishDressItem().isDisplayed());
    }

    @Test(priority = 2)
    public void verifyUserCanOpenProductDetailPage() {
        homePage.clickViewProductBlueTop();

        Assert.assertEquals(driver.getCurrentUrl(), productsPage.expectedURL());
        Assert.assertTrue(productsPage.blueTopProductNameText().contains("Blue Top"));
    }

    @Test(priority = 3)
    public void verifyProductSearchReturnsCorrectReults() throws InterruptedException {
        navigationMenu.clickProducts();
        productsPage.inputSearchProductField("Winter top");
        productsPage.clickSearchButton();

        Thread.sleep(5000);
        Assert.assertTrue(productsPage.getWinterTopItem().isDisplayed());
        Assert.assertFalse(productsPage.getMenTshirtItem().isDisplayed());
        Assert.assertFalse(productsPage.getSleevelessDressItem().isDisplayed());
        Assert.assertFalse(productsPage.getStylishDressItem().isDisplayed());


    }


}
