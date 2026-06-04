package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationMenu {

    WebDriver driver;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
    }

    // Returns the Home navigation link
    public WebElement getHome() {
        return driver.findElement(By.cssSelector("a[href='/']"));
    }

    // Returns the Products navigation link
    public WebElement getProducts() {
        return driver.findElement(By.cssSelector("a[href='/products']"));
    }

    // Returns the Cart navigation link
    public WebElement getCart() {
        return driver.findElement(By.cssSelector("a[href='/view_cart']"));
    }

    // Returns the Login / Signup navigation link
    public WebElement getLoginSignup() {
        return driver.findElement(By.cssSelector("a[href='/login']"));
    }

    // Returns the Logout navigation link
    public WebElement getLogout() {
        return driver.findElement(By.cssSelector("a[href='/logout']"));
    }

    // Returns the Contact Us navigation link
    public WebElement getContactUs() {
        return driver.findElement(By.cssSelector("a[href='/contact_us']"));
    }

    //--------------------------------------------------

    // Clicks the Home navigation link
    public void clickHome() {
        getHome().click();
    }

    // Clicks the Products navigation link
    public void clickProducts() {
        getProducts().click();
    }

    // Clicks the Cart navigation link
    public void clickCart() {
        getCart().click();
    }

    // Clicks the Login / Signup navigation link
    public void clickLoginSignup() {
        getLoginSignup().click();
    }

    // Clicks the Logout navigation link
    public void clickLogout() {
        getLogout().click();
    }

    // Clicks the Contact Us navigation link
    public void clickContactUs() {
        getContactUs().click();
    }
}