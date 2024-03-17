@Test
@end2end


Feature: End to End Test

  Background:
    Given When user is on Sauce Demo Page
    When User enter  username "visual_user" and password "secret_sauce"
    When User click on Login

    @VerifyPrice

    Scenario: Verify price is same for a product on Page and inside a product
      When User grab the Price of product in Page
      When User click on product and go inside
      When User grab the Price of product inside
      Then Validate that the price is the same

      @Sorting

      Scenario: Sorting(Z-A,Price)
        When User go to sorting and sort Name (Z to A)
        Then Validate that product are sorted

        @AddToCart

        Scenario: Add to Cart
          When User click on Add to Cart
          Then Validate that product is added

          @RemoveProduct

          Scenario: Remove Product
            When User Add a Product to Cart
            When User click on Cart Page and Remove product
            When User Checkout and give Informations and Continue
            | Element   | Information |
            | FirstName | *******     |
            | LastName  | *******     |
            | ZipCode   | *****       |
            Then Validate that the total of price is 0.0

            @Calculations

            Scenario: Validate that Calculation when you add multiple products are correct
              When User Add to Cart multiple Products
              When User click on Cart Page
              When User Checkout and give Informations and Continue
                | Element   | Information |
                | FirstName | *******     |
                | LastName  | *******     |
                | ZipCode   | *****       |
              When User Calculate all products prices
              Then Validate that Calculations is equals to Total Price

              @PlaceOrder

              Scenario: Place Order
                When User Add to Cart products
                When User click on Cart Page
                When User Checkout and give Informations and Continue
                  | Element   | Information |
                  | FirstName | *******     |
                  | LastName  | *******     |
                  | ZipCode   | *****       |
                When User click on Finish
                Then Validate that Order has been sent successfully



