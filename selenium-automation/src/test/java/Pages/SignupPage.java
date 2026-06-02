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

    public WebElement getRadioButtonMr() {
        return driver.findElement(By.id("id_gender1"));
    }

    public Select getDropdownDay() {
        return new Select(driver.findElement(By.id("days")));
    }

    public Select getDropdownMonth() {
        return new Select(driver.findElement(By.id("months")));
    }

    public Select getDropdownYear() {
        return new Select(driver.findElement(By.id("years")));
    }

    public Select getDropdownCountry() {
        return new Select(driver.findElement(By.id("country")));
    }

    public WebElement getRadioButtonMrs() {
        return driver.findElement(By.id("id_gender2"));
    }

    public WebElement getNameField() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getFirstNameField() {
        return driver.findElement(By.id("first_name"));
    }

    public WebElement getLastNameField() {
        return driver.findElement(By.id("last_name"));
    }

    public WebElement getCompanyField() {
        return driver.findElement(By.id("company"));
    }

    public WebElement getAddressField() {
        return driver.findElement(By.id("address1"));
    }

    public WebElement getStateField() {
        return driver.findElement(By.id("state"));
    }

    public WebElement getCityField() {
        return driver.findElement(By.id("city"));
    }

    public WebElement getZipCodeField() {
        return driver.findElement(By.id("zipcode"));
    }

    public WebElement getMobileNumberField() {
        return driver.findElement(By.id("mobile_number"));
    }

    public WebElement getCreateAccountButton() {
        return driver.findElement(By.cssSelector("button[data-qa='create-account']"));
    }

    public WebElement getAccountCreated() {
        return driver.findElement(By.cssSelector("h2[data-qa='account-created']"));
    }


    //------------------------------------------

    public void selectDropdownDay(String day) {
        getDropdownDay().selectByContainsVisibleText(day);
    }

    public void selectDropdownMonth(String month) {
        getDropdownMonth().selectByContainsVisibleText(month);
    }

    public void selectDropdownYear(String year) {
        getDropdownYear().selectByContainsVisibleText(year);
    }

    public void selectDropdownCountry(String country) {
        getDropdownCountry().selectByContainsVisibleText(country);

    }

    public void clickRadioButtonMr() {
        getRadioButtonMr().click();
    }

    public void clickRadioButtonMrs() {
        getRadioButtonMrs().click();
    }


    public void inputPasswordField(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void inputFirstNameField(String firstName) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
    }

    public void inputLastNameField(String lastName) {
        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
    }

    public void inputCompanyField(String company) {
        getCompanyField().clear();
        getCompanyField().sendKeys(company);
    }

    public void inputAdressField(String address) {
        getAddressField().clear();
        getAddressField().sendKeys(address);
    }

    public void inputStateField(String state) {
        getStateField().clear();
        getStateField().sendKeys(state);
    }

    public void inputCityField(String city) {
        getCityField().clear();
        getCityField().sendKeys(city);
    }

    public void inputZipCodeField(String zipCode) {
        getZipCodeField().clear();
        getZipCodeField().sendKeys(zipCode);
    }

    public void inputMobileNumberField(String mobileNumber) {
        getMobileNumberField().clear();
        getMobileNumberField().sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        getCreateAccountButton().click();
    }

    public String accountCreatedMessage() {
        return getAccountCreated().getText();
    }

    public String expectedUrl() {
        return "https://automationexercise.com/account_created";


    }


}


