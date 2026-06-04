package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Returns the remove button for an item in the cart
    public WebElement getRemoveItemButton() {
        return driver.findElement(By.className("cart_quantity_delete"));
    }

    // Returns the remove button for an item in the cart
    public WebElement getBlueTopItem() {
        return driver.findElement(By.linkText("Blue Top"));
    }

    // Returns the remove button for an item in the cart
    public WebElement getMenTshirtItem() {
        return driver.findElement(By.linkText("Men Tshirt"));
    }

    // Returns the message displayed when the cart is empty
    public WebElement getCartIsEmptyMessage() {
        return driver.findElement(By.xpath("/html/body/section/div/div[2]/span/p/b"));
    }

    // Returns the checkout button
    public WebElement getProceedToCheckoutButton() {
        return driver.findElement(By.linkText("Proceed To Checkout"));
    }

    //---------------------------------------------------------------------

    // Returns the cart page URL
    public String cartURL() {
        return "https://automationexercise.com/view_cart";
    }

    // Clicks the remove button for an item in the cart
    public void removeItem() {
        getRemoveItemButton().click();
    }

    // Clicks the Proceed To Checkout button
    public void clickProceedToCheckout() {
        getProceedToCheckoutButton().click();
    }
}
