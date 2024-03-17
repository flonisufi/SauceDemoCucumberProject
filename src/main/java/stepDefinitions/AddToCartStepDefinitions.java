package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddToCartPage;

public class AddToCartStepDefinitions {

    AddToCartPage addToCartPage = new AddToCartPage();

    @When("User click on Add to Cart")
    public void user_click_on_add_to_cart()
    {
        addToCartPage.addProduct();

    }
    @Then("Validate that product is added")
    public void validate_that_product_is_added()
    {
        Assert.assertEquals(addToCartPage.cardBadge(),1);
        System.out.println("Shop Card Badge is " + addToCartPage.cardBadge());

    }
}
