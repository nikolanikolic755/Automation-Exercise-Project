package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactTest extends BaseTest {

    // Initializes browser, wait, page objects and logged-in session before each test
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

    // Verifies that user can successfully submit the Contact Us form
    @Test(priority = 1)
    public void verifyUserCanSubmitContactUsForm() {

        navigationMenu.clickContactUs();
        contactUsPage.fillContactForm("Nikola", "nikola_test_001@gmail.com", "Title", "Test");
        contactUsPage.clickSubmit();

        // Waits for confirmation alert to appear
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        // Accepts the confirmation alert
        alert.accept();

        // Verify that success message is displayed after form submission
        Assert.assertTrue(contactUsPage.getSuccessMessageText().contains("Success! Your details have been submitted successfully."));

    }

    // Clears cookies and closes browser after each test
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
