package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Returns the name input field
    public WebElement getNameField() {
        return driver.findElement(By.cssSelector("input[data-qa='name']"));
    }

    // Returns the email input field
    public WebElement getEmailField() {
        return driver.findElement(By.cssSelector("input[data-qa='email']"));
    }

    // Returns the subject input field
    public WebElement getSubjectField() {
        return driver.findElement(By.cssSelector("input[data-qa='subject']"));
    }

    // Returns the message field
    public WebElement getMessageField() {
        return driver.findElement(By.cssSelector("textarea[data-qa='message']"));
    }

    // Returns the submit button
    public WebElement getSubmitButton() {
        return driver.findElement(By.cssSelector("input[data-qa='submit-button']"));
    }

    // Returns the success message after submitting the contact form
    public WebElement getSuccessfullySubmittedMessage() {
        return driver.findElement(By.cssSelector(".status.alert.alert-success"));
    }

    //---------------------------------------------------------------------

    // Enters name into the name field
    public void inputName(String name) {
        getNameField().clear();
        getNameField().sendKeys(name);
    }

    // Enters email into the email field
    public void inputEmail(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    // Enters subject into the subject field
    public void inputSubject(String subject) {
        getSubjectField().clear();
        getSubjectField().sendKeys(subject);
    }

    // Enters message into the message field
    public void inputMessage(String message) {
        getMessageField().clear();
        getMessageField().sendKeys(message);
    }

    // Fills out all fields in the Contact Us form
    public void fillContactForm(String name, String email, String subject, String message) {
        inputName(name);
        inputEmail(email);
        inputSubject(subject);
        inputMessage(message);
    }

    // Clicks the submit button
    public void clickSubmit() {
        getSubmitButton().click();
    }

    // Returns the success message text
    public String getSuccessMessageText() {
        return getSuccessfullySubmittedMessage().getText();
    }
}
