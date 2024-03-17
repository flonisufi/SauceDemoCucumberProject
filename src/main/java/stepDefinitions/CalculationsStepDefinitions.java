package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalculationsPage;

public class CalculationsStepDefinitions {

    CalculationsPage calculationsPage = new CalculationsPage();

    double priceCalculation;


    @When("User Add to Cart multiple Products")
    public void user_add_to_cart_multiple_products()
    {
        calculationsPage.addProducts();

    }

    @When("User click on Cart Page")
    public void user_click_on_cart_page()
    {
        calculationsPage.goToCart();
    }



    @When("User Calculate all products prices")
    public void user_calculate_all_products_prices()
    {
        priceCalculation = calculationsPage.priceCalculations();

    }

    @Then("Validate that Calculations is equals to Total Price")
    public void validate_that_calculations_is_equals_to_total_price()
    {

        Assert.assertEquals(priceCalculation,calculationsPage.subTotalPrice());

        System.out.println("The price calculations are " + priceCalculation +
                " and the Total price is " + calculationsPage.subTotalPrice());

    }


}
