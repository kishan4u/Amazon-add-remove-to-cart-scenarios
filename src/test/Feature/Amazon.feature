Feature: Amazon products cycle

@First
Scenario: Adding items to Cart
  Given Navigate to the Amazon homepage
   When Search for a specific product
   And Select a product from the search results
   When Click Add to Cart button
  Then The item is added to the cart

  @Second
  Scenario: Updating Shipping Information
    Given Add items to the cart and proceed to checkout
    When Click on the Change link under the shipping address
    And Enter a new shipping address and save it
    Then The new shipping address is saved

    @Third
    Scenario: Removing items from the cart
    Given Add multiple items to the cart
    When Navigate to the cart page
    When Remove an item from the cart
    Then The item is removed from the cart, and the cart total is updated accordingly