package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class NavigationMenu {

    WebDriver driver;
    WebElement home;
    WebElement products;
    WebElement cart;
    WebElement loginSignup;
    WebElement contactUs;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHome() {
        return driver.findElement(By.cssSelector("a[href='/']"));
    }

    public WebElement getProducts() {
        return driver.findElement(By.cssSelector("a[href='/products']"));
    }

    public WebElement getCart() {
        return driver.findElement(By.cssSelector("a[href='/view_cart']"));
    }

    public WebElement getLoginSignup() {
        return driver.findElement(By.cssSelector("a[href='/login']"));
    }

    public WebElement getLogout() {
        return driver.findElement(By.cssSelector("a[href='/logout']"));
    }

    public WebElement getContactUs() {
        return driver.findElement(By.cssSelector("a[href='/contact_us']"));
    }


    //--------------------------------------------------

    public void clickHome() {
        getHome().click();
    }

    public void clickProducts() {
        getProducts().click();
    }

    public void clickCart() {
        getCart().click();
    }

    public void clickLoginSignup() {
        getLoginSignup().click();
    }

    public void clickLogout() {
        getLogout().click();
    }

    public void clickContactUs() {
        getContactUs().click();
    }

}
