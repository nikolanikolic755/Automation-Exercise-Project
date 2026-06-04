package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Returns the Mr. gender radio button
    public WebElement getRadioButtonMr() {
        return driver.findElement(By.id("id_gender1"));
    }

    // Returns the day dropdown
    public Select getDropdownDay() {
        return new Select(driver.findElement(By.id("days")));
    }

    // Returns the month dropdown
    public Select getDropdownMonth() {
        return new Select(driver.findElement(By.id("months")));
    }

    // Returns the year dropdown
    public Select getDropdownYear() {
        return new Select(driver.findElement(By.id("years")));
    }

    // Returns the country dropdown
    public Select getDropdownCountry() {
        return new Select(driver.findElement(By.id("country")));
    }

    // Returns the password input field
    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    // Returns the first name input field
    public WebElement getFirstNameField() {
        return driver.findElement(By.id("first_name"));
    }

    // Returns the last name input field
    public WebElement getLastNameField() {
        return driver.findElement(By.id("last_name"));
    }

    // Returns the company input field
    public WebElement getCompanyField() {
        return driver.findElement(By.id("company"));
    }

    // Returns the address input field
    public WebElement getAddressField() {
        return driver.findElement(By.id("address1"));
    }

    // Returns the state input field
    public WebElement getStateField() {
        return driver.findElement(By.id("state"));
    }

    // Returns the city input field
    public WebElement getCityField() {
        return driver.findElement(By.id("city"));
    }

    // Returns the zip code input field
    public WebElement getZipCodeField() {
        return driver.findElement(By.id("zipcode"));
    }

    // Returns the mobile number input field
    public WebElement getMobileNumberField() {
        return driver.findElement(By.id("mobile_number"));
    }

    // Returns the Create Account button
    public WebElement getCreateAccountButton() {
        return driver.findElement(By.cssSelector("button[data-qa='create-account']"));
    }

    // Returns the Account Created success message
    public WebElement getAccountCreated() {
        return driver.findElement(By.cssSelector("h2[data-qa='account-created']"));
    }

    //--------------------------------------------------------------------------------------

    // Selects day from the day dropdown
    public void selectDropdownDay(String day) {
        getDropdownDay().selectByContainsVisibleText(day);
    }

    // Selects month from the month dropdown
    public void selectDropdownMonth(String month) {
        getDropdownMonth().selectByContainsVisibleText(month);
    }

    // Selects year from the year dropdown
    public void selectDropdownYear(String year) {
        getDropdownYear().selectByContainsVisibleText(year);
    }

    // Selects country from the country dropdown
    public void selectDropdownCountry(String country) {
        getDropdownCountry().selectByContainsVisibleText(country);

    }

    // Clicks the Mr. gender radio button
    public void clickRadioButtonMr() {
        getRadioButtonMr().click();
    }

    // Enters password
    public void inputPasswordField(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    // Enters first name
    public void inputFirstNameField(String firstName) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
    }

    // Enters last name
    public void inputLastNameField(String lastName) {
        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
    }

    // Enters company name
    public void inputCompanyField(String company) {
        getCompanyField().clear();
        getCompanyField().sendKeys(company);
    }

    // Enters address
    public void inputAddressField(String address) {
        getAddressField().clear();
        getAddressField().sendKeys(address);
    }

    // Enters state
    public void inputStateField(String state) {
        getStateField().clear();
        getStateField().sendKeys(state);
    }

    // Enters city
    public void inputCityField(String city) {
        getCityField().clear();
        getCityField().sendKeys(city);
    }

    // Enters zip code
    public void inputZipCodeField(String zipCode) {
        getZipCodeField().clear();
        getZipCodeField().sendKeys(zipCode);
    }

    // Enters mobile number
    public void inputMobileNumberField(String mobileNumber) {
        getMobileNumberField().clear();
        getMobileNumberField().sendKeys(mobileNumber);
    }

    // Fills out all required account information fields for signup
    public void fillAccountInformation(String password, String day, String month, String year, String firstName, String lastName, String company,
                                       String address, String country, String state, String city, String zipCode, String mobileNumber) {
        clickRadioButtonMr();
        inputPasswordField(password);
        selectDropdownDay(day);
        selectDropdownMonth(month);
        selectDropdownYear(year);
        inputFirstNameField(firstName);
        inputLastNameField(lastName);
        inputCompanyField(company);
        inputAddressField(address);
        selectDropdownCountry(country);
        inputStateField(state);
        inputCityField(city);
        inputZipCodeField(zipCode);
        inputMobileNumberField(mobileNumber);
    }

    // Clicks the Create Account button
    public void clickCreateAccountButton() {
        getCreateAccountButton().click();
    }

    // Returns the Account Created message text
    public String getAccountCreatedMessageText() {
        return getAccountCreated().getText();
    }

    // Returns the Account Created page URL
    public String getAccountCreatedPageURL() {
        return "https://automationexercise.com/account_created";


    }


}


