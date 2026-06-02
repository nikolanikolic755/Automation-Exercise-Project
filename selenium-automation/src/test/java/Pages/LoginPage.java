package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    WebDriver driver;
    WebElement loginEmailField;
    WebElement loginPasswordField;
    WebElement loginButton;
    WebElement signupNameField;
    WebElement signupEmailField;
    WebElement signupButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginEmailField() {
        return driver.findElement(By.cssSelector("input[data-qa='login-email']"));
    }

    public WebElement getLoginPasswordField() {
        return driver.findElement(By.cssSelector("input[data-qa='login-password']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("button[data-qa='login-button']"));
    }

    public WebElement getSignupNameField() {
        return driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
    }

    public WebElement getSignupEmailField() {
        return driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
    }

    public WebElement getSignupButton() {
        return driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
    }

    public WebElement getEmailExists() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/p"));
    }

    //-------------------------------------------------------------------------------------------------------

    public void inputLoginEmail(String email) {
        getLoginEmailField().clear();
        getLoginEmailField().sendKeys(email);
    }

    public void inputLoginPassword(String password) {
        getLoginPasswordField().clear();
        getLoginPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void inputSignupName(String name) {
        getSignupNameField().clear();
        getSignupNameField().sendKeys(name);
    }

    public void inputSignupEmail(String email) {
        getSignupEmailField().clear();
        getSignupEmailField().sendKeys(email);
    }

    public void clickSignupButton() {

        getSignupButton().click();
    }

    public String expectedURL() {
        return "https://automationexercise.com/login";


    }

    public String emailAlreadyExistsMessage() {
        return getEmailExists().getText();

    }


}
