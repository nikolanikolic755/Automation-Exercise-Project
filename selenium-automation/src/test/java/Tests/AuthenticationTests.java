package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AuthenticationTests extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationTests.class);

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
    }

    @Test(priority = 1)
    public void verifyUserCanRegisterWithValidData() throws InterruptedException {
        loginPage.inputSignupName("Nikola");
        loginPage.inputSignupEmail(System.currentTimeMillis() + "@gmail.com");
        loginPage.clickSignupButton();
        signupPage.clickRadioButtonMr();
        signupPage.inputPasswordField("NikolaBootcamp99");
        signupPage.selectDropdownDay("15");
        signupPage.selectDropdownMonth("December");
        signupPage.selectDropdownYear("1999");
        signupPage.inputFirstNameField("Nikola");
        signupPage.inputLastNameField("Nikolic");
        signupPage.inputCompanyField("Microsoft");
        signupPage.inputAdressField("1502 W Thomas Rd");
        signupPage.selectDropdownCountry("United States");
        signupPage.inputStateField("Arizona");
        signupPage.inputCityField("Phoenix");
        signupPage.inputZipCodeField("85001");
        signupPage.inputMobileNumberField("0642328328");
        signupPage.clickCreateAccountButton();

        Assert.assertEquals(driver.getCurrentUrl(), signupPage.expectedUrl());
        Assert.assertTrue(signupPage.accountCreatedMessage().contains("ACCOUNT CREATED"));


    }

    @Test(priority = 2)
    public void verifyUserCannotRegisterWithExistingEmail() throws InterruptedException {
        loginPage.inputSignupName("Nikola");
        loginPage.inputSignupEmail("nikola_test_001@gmail.com");
        loginPage.clickSignupButton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getSignupButton()));
        Assert.assertTrue(loginPage.getSignupButton().isDisplayed());
        Assert.assertTrue(loginPage.emailAlreadyExistsMessage().contains("Email Address already exist"));
    }

    @Test(priority = 3)
    public void verifyUserCannotRegisterWithEmptyNameField() {
        loginPage.getSignupNameField().clear();
        loginPage.inputSignupEmail(System.currentTimeMillis() + "@gmail.com");
        loginPage.clickSignupButton();

        Assert.assertTrue(loginPage.getSignupButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.expectedURL());

    }

    @Test(priority = 4)
    public void verifyUserCanLoginWithValidCredentials() {
        loginPage.inputLoginEmail("nikola_test_001@gmail.com");
        loginPage.inputLoginPassword("NikolaBootcamp99");
        loginPage.clickLoginButton();

        Assert.assertTrue(navigationMenu.getLogout().isDisplayed());
    }

    @Test(priority = 5)
    public void verifyUserCanLogout() {
        loginPage.inputLoginEmail("nikola_test_001@gmail.com");
        loginPage.inputLoginPassword("NikolaBootcamp99");
        loginPage.clickLoginButton();
        navigationMenu.clickLogout();

        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.expectedURL());
    }

    @Test(priority = 6)
    public void verifyUserCannotLoginWithInvalidPassword() {

        loginPage.inputLoginEmail("nikola_test_001@gmail.com");
        loginPage.inputLoginPassword("NikolaBootcamp999");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.expectedURL());


    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}