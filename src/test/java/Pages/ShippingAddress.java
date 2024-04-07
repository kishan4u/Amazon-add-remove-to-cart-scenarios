package Pages;

import StepDefinations.BaseClass;
import Utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingAddress extends BaseClass {


    public ShippingAddress(WebDriver driver) {
        super();
    }
    Utility utl = new Utility(BaseClass.driver);



    // Method to open the Cart and clicking on Add to Buy button for checkout
    public void proceedCheckout(){
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           WebElement cartbutton  = BaseClass.driver.findElement(By.xpath("//span[@id=\"nav-cart-count\"]"));
           cartbutton.click();

           //Clicking on Add to buy button
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement buy =  BaseClass.driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"));
       buy.click();

       //Sign In required inorder to proceed for check out so hardcoding the data for now
       signIn("Sigma@2796");                                    // Enter password here
    }

      // method to enter email id and password in order to check out
    public void signIn(String password){
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Entering phone number
        WebElement phone =  BaseClass.driver.findElement(By.xpath("//input[@id=\"ap_email\"]"));
        phone.sendKeys("7022165264");                      //Enter Email.id or mobile number

        //Click on continue after entering email or mobile number
        WebElement contin =  BaseClass.driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        contin.click();

        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Clicking on Password button
        WebElement passwrd =  BaseClass.driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        passwrd.sendKeys(password);

       //Clicking on Sign In button
        WebElement SignIn =  BaseClass.driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        SignIn.click();
    }


    // Scrolling to the New address link and clicking to open the address form
    public void clickOnLink(){
        //Scrolling to make the new address link visible
        WebElement link=  BaseClass.driver.findElement(By.xpath("//a[@id=\"add-new-address-popover-link\"]"));
        utl._scrollToElement(link);

        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        link.click();
    }

    //Method to fill the details on form
    public void newShippingAddress(){
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           // Hard coding data
        WebElement FullName =  BaseClass.driver.findElement(By.xpath("//input[@id=\"address-ui-widgets-enterAddressFullName\"]"));
        FullName.sendKeys("Ghanshyam Nath");

        WebElement Mobilenum =  BaseClass.driver.findElement(By.xpath("//input[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]"));
        Mobilenum.sendKeys("7022165262");


        WebElement Pincode=  BaseClass.driver.findElement(By.xpath("//input[@id=\"address-ui-widgets-enterAddressPostalCode\"]"));
        Pincode.sendKeys("560076");


        WebElement Address=  BaseClass.driver.findElement(By.xpath("//input[@id=\"address-ui-widgets-enterAddressLine1\"]"));
        Address.sendKeys("7th Main Road");


        WebElement Area=  BaseClass.driver.findElement(By.xpath("//input[@id=\"address-ui-widgets-enterAddressLine2\"]"));
        Area.sendKeys("Ns Palya, Btm Layout Stage 2");


        WebElement Landmark=  BaseClass.driver.findElement(By.xpath("//input[@id=\"address-ui-widgets-landmark\"]"));
        Landmark.sendKeys("St Peters Church");

       //Waiting for the address button to be clickable and come into view.
        WebElement Addressbutton=  BaseClass.driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Addressbutton));
        utl._scrollToElement(Addressbutton);

        // Clicking on Address add button
        utl._mouseOverAndClick(Addressbutton);



    }


    //Verifying the newly added address with data enter into form, verifying only for Full name
    public void newAddressSaved(){

        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String saved =  BaseClass.driver.findElement(By.xpath("//*[@id=\"shipaddress\"]/div[3]/div/div[1]/div[2]/div[1]/ul/li[1]")).getText();
        Assert.assertEquals("Ghanshyam Nath", saved);
    }
}
