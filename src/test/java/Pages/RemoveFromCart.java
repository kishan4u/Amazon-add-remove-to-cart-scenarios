package Pages;

import StepDefinations.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RemoveFromCart extends BaseClass {



    public RemoveFromCart(WebDriver driver) {
        super();
    }

     AddToCart atc  = new AddToCart(BaseClass.driver);


    //Method to return to cart via Amazon logo
    public void returnCartPage(){
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Clicking on Logo
        WebElement Logo =  BaseClass.driver.findElement(By.xpath("//*[@id=\"banner-image\"]/span/span/div/i[1]"));
        Logo.click();

        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Clicking on Return to cart button
        WebElement ReturntoCart =  BaseClass.driver.findElement(By.xpath("//*[@id=\"a-popover-content-3\"]/div[2]/div[2]/span/span/a"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ReturntoCart));
        ReturntoCart.click();
    }


    //Methon to call the add to cart method to make data reusable multiple times
    public void addmultipleItems() throws InterruptedException {

       for (int i=0 ; i<2 ; i++) {
           BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           // Calling Search box method
           atc.searchProduct();
           BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           //Calling method to select from the search result
           atc.selectProduct();
           BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           //calling method to click on Add to cart button
           atc.addToCartButton();
       }
    }

    //Method to click on Cart button to open the cart page
    public void navigateCart(){

        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement cartbutton  = BaseClass.driver.findElement(By.xpath("//span[@id=\"nav-cart-count\"]"));
        cartbutton.click();

    }

    //Clicking on delete button to remove the product from cart
    public void removeItem(){
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement delete = BaseClass.driver.findElement(By.xpath("(//input[@value='Delete'])[1]"));
        delete.click();

    }


    //Verifying the count after removing the product
    public void countChange(){

        // Method called from Add to cart and making it reusable for now
        atc.verifyCount();
    }




}
