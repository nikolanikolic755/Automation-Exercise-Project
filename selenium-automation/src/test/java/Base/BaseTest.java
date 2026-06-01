package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ContactUsPage contactUsPage;
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public SignupPage signupPage;
    public NavigationMenu navigationMenu;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }
}
