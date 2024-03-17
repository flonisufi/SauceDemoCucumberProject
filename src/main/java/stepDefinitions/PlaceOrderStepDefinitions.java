package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PlaceOrderPage;

public class PlaceOrderStepDefinitions {

    PlaceOrderPage placeOrderPage = new PlaceOrderPage();

    @When("User Add to Cart products")
    public void user_add_to_cart_products()
    {
        placeOrderPage.addProductsToCart();

    }

    @When("User click on Finish")
    public void user_click_on_finish()
    {
        placeOrderPage.finish();

    }

    @Then("Validate that Order has been sent successfully")
    public void validate_that_order_has_been_sent_successfully()
    {
        Assert.assertEquals(placeOrderPage.orderMessage(),"Thank you for your order!");

    }


}
