package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    WebDriver driver;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Returns the search product input field
    public WebElement getSearchProductField() {
        return driver.findElement(By.id("search_product"));
    }

    // Returns the search button
    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector(".fa.fa-search"));
    }

    // Returns the Add to Cart button for Blue Top
    public WebElement getAddBlueTopToCart() {
        return driver.findElement(By.cssSelector("a[data-product-id='1']"));
    }

    // Returns the Add to Cart button for Men Tshirt
    public WebElement getAddMenTshirtToCart() {
        return driver.findElement(By.cssSelector("a[data-product-id='2']"));
    }

    // Returns the Continue Shopping button from popup
    public WebElement getContinueShoppingButton() {
        return driver.findElement(By.className("modal-footer"));
    }

    // Returns the Men Tshirt product link
    public WebElement getMenTshirtItem() {
        return driver.findElement(By.cssSelector("a[href='/product_details/2']"));
    }

    // Returns the Sleeveless Dress product link
    public WebElement getSleevelessDressItem() {
        return driver.findElement(By.cssSelector("a[href='/product_details/3']"));
    }

    // Returns the Stylish Dress product link
    public WebElement getStylishDressItem() {
        return driver.findElement(By.cssSelector("a[href='/product_details/4']"));
    }

    // Returns the Winter Top product link
    public WebElement getWinterTopItem() {
        return driver.findElement(By.cssSelector("a[href='/product_details/5']"));
    }

    // Returns the Blue Top product name displayed on the product details page
    public WebElement getBlueTopProductName() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
    }

    //-------------------------------------------
    public String getBlueTopProductDetailsURL() {
        return "https://automationexercise.com/product_details/1";
    }

    // Returns the Blue Top product name text
    public String blueTopProductNameText() {
        return getBlueTopProductName().getText();
    }

    // Enters product name into the search field
    public void inputSearchProductField(String search) {
        getSearchProductField().clear();
        getSearchProductField().sendKeys(search);
    }

    // Clicks the search button
    public void clickSearchButton() {
        getSearchButton().click();
    }

    // Clicks Add to Cart for Blue Top
    public void clickAddBlueTopToCart() {
        getAddBlueTopToCart().click();
    }

    // Clicks Add to Cart for Men Tshirt
    public void clickAddMenTshirtToCart() {
        getAddMenTshirtToCart().click();
    }

    // Clicks Continue Shopping in the popup
    public void clickContinueShopping() {
        getContinueShoppingButton().click();
    }
}

