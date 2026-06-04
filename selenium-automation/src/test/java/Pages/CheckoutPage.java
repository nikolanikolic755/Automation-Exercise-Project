package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Returns the Place Order button
    public WebElement getPlaceOrderButton() {
        return driver.findElement(By.linkText("Place Order"));
    }

    // Returns the total amount displayed in the checkout summary
    public WebElement getTotalAmount() {
        return driver.findElement(By.xpath("/html/body/section/div/div[5]/table/tbody/tr[3]/td[4]/p"));
    }

    //------------------------------------------------------------

    // Clicks the Place Order button
    public void clickPlaceOrder() {
        getPlaceOrderButton().click();
    }

    // Returns the displayed total cart amount
    public String cartTotalAmount() {
        return getTotalAmount().getText();
    }
}

