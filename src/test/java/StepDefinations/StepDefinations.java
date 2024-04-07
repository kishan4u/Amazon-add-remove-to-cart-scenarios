package StepDefinations;

import Pages.AddToCart;
import Pages.RemoveFromCart;
import Pages.ShippingAddress;
import Utility.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class StepDefinations {

    AddToCart atc = new AddToCart(BaseClass.driver);
    Utility ut = new Utility(BaseClass.driver);
    RemoveFromCart rfc = new RemoveFromCart(BaseClass.driver);

    ShippingAddress spad = new ShippingAddress(BaseClass.driver);

    //Method to launch browser and enter URL via calling the Baseclasss method launchbrowser and passing the parameter
    @Given("Navigate to the Amazon homepage")
    public void navigate_to_the_amazon_homepage() {
       BaseClass.lauchBrowser("Chrome", "https://www.amazon.in");
    }

    @When("Search for a specific product")
    public void search_for_a_specific_product() throws InterruptedException {

         atc.searchProduct();
    }

    @When("Select a product from the search results")
    public void select_a_product_from_the_search_results() {
          atc.selectProduct();
    }

    @When("Click Add to Cart button")
    public void click_add_to_cart_button() {
          atc.addToCartButton();
    }


    @Then("The item is added to the cart")
    public void the_item_is_added_to_the_cart() {

        //Verifying the Alert pop up after adding the product to the cart

       /* String value= BaseClass.driver.findElement(By.xpath("//div[@class='a-changeover-inner']/strong")).getText();
        ut.validateText("Item Added", value);*/

       atc.verifyCount();

    }

    @Given("Add items to the cart and proceed to checkout")
    public void add_items_to_the_cart_and_proceed_to_checkout() {
        spad.proceedCheckout();

    }
    @When("Click on the Change link under the shipping address")
    public void click_on_the_link_under_the_shipping_address() {
        spad.clickOnLink();

    }
    @When("Enter a new shipping address and save it")
    public void enter_a_new_shipping_address_and_save_it() {

        spad.newShippingAddress();
    }


    @Then("The new shipping address is saved")
    public void the_new_shipping_address_is_saved() {

         spad.newAddressSaved();

    }

    @Given("Add multiple items to the cart")
    public void add_multiple_items_to_the_cart() {
       rfc.returnCartPage();
    }

    @When("Navigate to the cart page")
    public void navigate_to_the_cart_page() throws InterruptedException {
        rfc.addmultipleItems();

    }
    @When("Remove an item from the cart")
    public void remove_an_item_from_the_cart() {
        rfc.navigateCart();
        rfc.removeItem();

    }

    @Then("The item is removed from the cart, and the cart total is updated accordingly")
    public void the_item_is_removed_from_the_cart_and_the_cart_total_is_updated_accordingly() {
        rfc.countChange();

    }




}
