package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(5000);
        navigationMenu.clickProducts();
        Thread.sleep(5000);
        navigationMenu.clickHome();
        Thread.sleep(5000);
        navigationMenu.clickCart();
        Thread.sleep(5000);
        navigationMenu.clickLoginSignup();
        Thread.sleep(5000);
        navigationMenu.clickContactUs();



    }

}
