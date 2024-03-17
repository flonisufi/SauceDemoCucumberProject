package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RemovePage;

public class RemoveStepDefinitions {

    RemovePage removePage = new RemovePage();

    @When("User Add a Product to Cart")
    public void user_adda_a_product_to_cart()
    {

    }


    @When("User click on Cart Page and Remove product")
    public void user_click_on_cart_page_and_remove_product()
    {
        removePage.goToCartAndRemove();

    }
    @When("User Checkout and give Informations and Continue")
    public void user_checkout_and_give_informations_and_continue(io.cucumber.datatable.DataTable dataTable)
    {
        removePage.enterInformations(dataTable);

    }
    @Then("^Validate that the total of price is (.+)$")
    public void validate_that_the_total_of_price_is(double total)
    {
        Assert.assertEquals(removePage.totalPrice(),total);
        System.out.println("Total price after product is removed is " + removePage.totalPrice());

    }


}
