package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBlueTopItem(){
        return driver.findElement(By.linkText("Blue Top"));
    }
    public WebElement getMenTshirtItem(){
        return driver.findElement(By.linkText("Men Tshirt"));
    }
    //---------------------------------
    public String cartURL(){
        return "https://automationexercise.com/view_cart";
    }
}
