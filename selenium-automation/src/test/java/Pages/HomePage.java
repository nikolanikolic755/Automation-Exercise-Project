package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    // Returns the View Product link for the Blue Top product
    public WebElement getViewProductBlueTop() {
        return driver.findElement(By.cssSelector("a[href='/product_details/1']"));
    }

    //---------------------------------------------------------

    // Clicks the View Product link for the Blue Top product
    public void clickViewProductBlueTop() {
        getViewProductBlueTop().click();
    }
}

