package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage  {

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
        return driver.findElement(By.cssSelector("input[data-qa='login-button']"));
    }

    public WebElement getSignupNameField() {
        return driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
    }

    public WebElement getSignupEmailField() {
        return driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
    }

    public WebElement getSignupButton() {
        return driver.findElement(By.cssSelector("input[data-qa='signup-button']"));
    }

    //--------------------------------

    public void inputLoginEmail() {
       getLoginEmailField().clear();
        getLoginEmailField().sendKeys("asdsa");
    }

    public void inputLoginPassword() {
       getLoginPasswordField().clear();
        getLoginPasswordField().sendKeys("asdsa");
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void inputSignupName() {
        getSignupNameField().clear();
       getSignupNameField().sendKeys("asfdfas");
    }

    public void inputSignupEmail() {
        getSignupEmailField().clear();
       getSignupEmailField().sendKeys("asfdfas");
    }
    public void clickSignupButton(){

        getSignupButton().click();
    }


}
