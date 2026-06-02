package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    WebDriver driver;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchProductField() {
        return driver.findElement(By.id("search_product"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector(".fa.fa-search"));
    }

    public WebElement getAddBlueTopToCart() {
        return driver.findElement(By.cssSelector("a[data-product-id='1']"));
    }

    public WebElement getAddMenTshirtToCart() {
        return driver.findElement(By.cssSelector("a[data-product-id='2']"));
    }
    public WebElement getContinueShoppingButton(){
        return driver.findElement(By.className("modal-footer"));
    }

    public WebElement getMenTshirtItem() {
        return driver.findElement(By.cssSelector("a[href='/product_details/2']"));
    }

    public WebElement getSleevelessDressItem() {
        return driver.findElement(By.cssSelector("a[href='/product_details/3']"));
    }

    public WebElement getStylishDressItem() {
        return driver.findElement(By.cssSelector("a[href='/product_details/4']"));
    }

    public WebElement getWinterTopItem() {
        return driver.findElement(By.cssSelector("a[href='/product_details/5']"));
    }

    public WebElement getBlueTopProductName() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
    }

    //-------------------------------------------
    public String expectedURL() {
        return "https://automationexercise.com/product_details/1";
    }

    public String blueTopProductNameText() {
        return getBlueTopProductName().getText();
    }

    public void inputSearchProductField(String search) {
        getSearchProductField().clear();
        getSearchProductField().sendKeys(search);
    }

    public void clickSearchButton() {
        getSearchButton().click();
    }

    public void clikAddBlueTopToCart() {
        getAddBlueTopToCart().click();
    }

    public void clickAddManTshirtToCart() {
        getAddMenTshirtToCart().click();
    }
public void clickContinueShopping(){
        getContinueShoppingButton().click();
}
}

