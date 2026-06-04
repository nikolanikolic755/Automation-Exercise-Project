package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Returns the name on card input field
    public WebElement getNameOnCardField() {
        return driver.findElement(By.cssSelector("input[data-qa='name-on-card']"));
    }

    // Returns the card number input field
    public WebElement getCardNumberField() {
        return driver.findElement(By.cssSelector("input[data-qa='card-number']"));
    }

    // Returns the CVC input field
    public WebElement getCvcField() {
        return driver.findElement(By.cssSelector("input[data-qa='cvc']"));
    }

    // Returns the expiration month input field
    public WebElement getExpirationMonthField() {
        return driver.findElement(By.cssSelector("input[data-qa='expiry-month']"));
    }

    // Returns the expiration year input field
    public WebElement getExpirationYearField() {
        return driver.findElement(By.cssSelector("input[data-qa='expiry-year']"));
    }

    // Returns the Pay and Confirm Order button
    public WebElement getPayAndConfirmOrderButton() {
        return driver.findElement(By.cssSelector("button[data-qa='pay-button']"));
    }

    // Returns the Order Placed success message
    public WebElement getOrderPlacedMessage() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/h2/b"));
    }

    // Returns the order confirmation message
    public WebElement getOrderConfirmedMessage() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/p"));
    }

    //-------------------------------------------------------------------

    // Enters name on card
    public void inputNameOnCard(String name) {
        getNameOnCardField().clear();
        getNameOnCardField().sendKeys(name);
    }

    // Enters card number
    public void inputCardNumber(String cardNumber) {
        getCardNumberField().clear();
        getCardNumberField().sendKeys(cardNumber);
    }

    // Enters CVC
    public void inputCVC(String cvc) {
        getCvcField().clear();
        getCvcField().sendKeys(cvc);
    }

    // Enters expiration month
    public void inputExpirationMonth(String month) {
        getExpirationMonthField().clear();
        getExpirationMonthField().sendKeys(month);
    }

    // Enters expiration year
    public void inputExpirationYear(String year) {
        getExpirationYearField().clear();
        getExpirationYearField().sendKeys(year);
    }

    // Fills out all payment fields
    public void fillPaymentForm(String name, String cardNumber, String cvc, String month, String year) {
        inputNameOnCard(name);
        inputCardNumber(cardNumber);
        inputCVC(cvc);
        inputExpirationMonth(month);
        inputExpirationYear(year);
    }

    // Clicks the Pay and Confirm Order button
    public void clickPayAndConfirm() {
        getPayAndConfirmOrderButton().click();
    }

    // Returns the order confirmation message text
    public String getOrderConfirmedMessageText() {
        return getOrderConfirmedMessage().getText();
    }
}
