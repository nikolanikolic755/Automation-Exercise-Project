package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AuthenticationTests extends BaseTest {

    // Initializes browser, wait, page objects and opens the login page before each test
    @BeforeMethod
    public void pageSetUp() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/login");

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

    // Registers a new user with a unique email address
    @Test(priority = 1)
    public void verifyUserCanRegisterWithValidData() {

        loginPage.signup("Nikola", System.currentTimeMillis() + "@gmail.com");
        signupPage.fillAccountInformation("NikolaBootcamp99", "15", "December", "1999", "Nikola", "Nikolic", "Microsoft", "1502 W Thomas Rd"
                , "United States", "Arizona", "Phoenix", "85001", "0642328328");
        signupPage.clickCreateAccountButton();

        Assert.assertEquals(driver.getCurrentUrl(), signupPage.getAccountCreatedPageURL());
        Assert.assertTrue(signupPage.getAccountCreatedMessageText().contains("ACCOUNT CREATED"));
    }

    // Verifies that registration is not allowed with an already registered email
    @Test(priority = 2)
    public void verifyUserCannotRegisterWithExistingEmail() {

        loginPage.signup("Nikola", "nikola_test_001@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'Email Address already exist')]")));


        Assert.assertTrue(loginPage.getEmailAlreadyExistsMessageText().contains("Email Address already exist"));
    }

    // Verifies that registration is not allowed when the name field is empty
    @Test(priority = 3)
    public void verifyUserCannotRegisterWithEmptyNameField() {
        loginPage.getSignupNameField().clear();
        loginPage.inputSignupEmail(System.currentTimeMillis() + "@gmail.com");


        Assert.assertTrue(loginPage.getSignupButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLoginPageURL());

    }

    // Verifies successful login with valid credentials
    @Test(priority = 4)
    public void verifyUserCanLoginWithValidCredentials() {
        loginPage.login("nikola_test_001@gmail.com", "NikolaBootcamp99");

        Assert.assertTrue(navigationMenu.getLogout().isDisplayed());
    }

    // Verifies that a logged-in user can log out successfully
    @Test(priority = 5)
    public void verifyUserCanLogout() {
        loginPage.login("nikola_test_001@gmail.com", "NikolaBootcamp99");
        navigationMenu.clickLogout();

        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLoginPageURL());
    }

    // Verifies that login fails when password is invalid
    @Test(priority = 6)
    public void verifyUserCannotLoginWithInvalidPassword() {

        loginPage.login("nikola_test_001@gmail.com", "NikolaBootcamp999");

        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLoginPageURL());
        Assert.assertTrue(loginPage.getIncorrectLoginMessageText().contains("Your email or password is incorrect"));

    }

    // Closes the browser after each test
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}