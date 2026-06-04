package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    WebDriver driver;

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

    public WebElement getEmailAlreadyExistsMessage() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/p"));
    }

    public WebElement getIncorrectLoginMessage() {
        return driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
    }

    //-----------------------------------------------------------------------------------

    // Enters email into the login email field
    public void inputLoginEmail(String email) {
        getLoginEmailField().clear();
        getLoginEmailField().sendKeys(email);
    }

    // Enters password into the login password field
    public void inputLoginPassword(String password) {
        getLoginPasswordField().clear();
        getLoginPasswordField().sendKeys(password);
    }

    // Clicks the Login button
    public void clickLoginButton() {
        getLoginButton().click();
    }

    // Enters login credentials and clicks Login button
    public void login(String email, String password) {
        inputLoginEmail(email);
        inputLoginPassword(password);
        clickLoginButton();
    }

    // Enters name into the signup name field
    public void inputSignupName(String name) {
        getSignupNameField().clear();
        getSignupNameField().sendKeys(name);
    }

    // Enters email into the signup email field
    public void inputSignupEmail(String email) {
        getSignupEmailField().clear();
        getSignupEmailField().sendKeys(email);
    }

    // Clicks the Signup button
    public void clickSignupButton() {

        getSignupButton().click();
    }

    // Enters signup data and clicks Signup button
    public void signup(String name, String email) {
        inputSignupName(name);
        inputSignupEmail(email);
        clickSignupButton();
    }

    // Returns the login page URL
    public String getLoginPageURL() {
        return "https://automationexercise.com/login";
    }

    // Returns the email already exists warning message
    public String getEmailAlreadyExistsMessageText() {
        return getEmailAlreadyExistsMessage().getText();
    }

    // Returns the invalid login error message text
    public String getIncorrectLoginMessageText() {
        return getIncorrectLoginMessage().getText();
    }
}
