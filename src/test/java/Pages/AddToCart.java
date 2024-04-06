package Pages;

import StepDefinations.BaseClass;
import Utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class AddToCart extends BaseClass {

    int countervalBefore = 0;
    public AddToCart(WebDriver driver) {
        super();
    }

    Utility u = new Utility(BaseClass.driver);

    // Method to Search product in search box
    public void searchProduct() throws InterruptedException {

        // Entering the value of product as pc into Searchbox
       WebElement ele =  BaseClass.driver.findElement(By.id("twotabsearchtextbox"));
        ele.click();
        ele.sendKeys("pc");



    }

  // Method to Select the product
    public void selectProduct(){
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement option1 = BaseClass.driver.findElement(By.xpath("//div[@class=\"left-pane-results-container\"]/div[1]/div[1]/div[1]"));

       // Called method from utilities class for mouse hover the search result and then click on first option
        u._mouseOverAndClick(option1);

    }

    // Method to click on Add to Cart button
    public void addToCartButton(){
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Calling the counter method to get the initial value before adding the product
        valueofcounter();
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Called from utilities class. Scrolling screen method to view the add to cart button on screen
        WebElement cart = BaseClass.driver.findElement(By.xpath("(//span[contains(@id,'a-autoid-1')]//span)[1]"));
        u._scrollToElement(cart);

        cart.click();

    }

    //Initial Counter method
    public void valueofcounter(){

        String initialCounter = driver.findElement(By.xpath("//span[@id=\"nav-cart-count\"]")).getText();
        countervalBefore = Integer.parseInt(initialCounter);
        System.out.println("value of the counter before is : " + countervalBefore);
    }

 // Method to count the Cart increment/decrement after add/ remove product from cart
    public void verifyCount(){


        String afterCounter = driver.findElement(By.xpath("//span[@id=\"nav-cart-count\"]")).getText();
        int countervalAfter = Integer.parseInt(afterCounter);
        System.out.println("value of the counter after is : " + countervalAfter);

// verifying the previous counter value with current counter value
        if(countervalAfter > countervalBefore){
            System.out.println("Counter worked i.e incremented");
        }else{
            System.out.println("Counter has decremented");
        }


    }

}
