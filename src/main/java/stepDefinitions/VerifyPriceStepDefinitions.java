package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.VerifyPricePage;

public class VerifyPriceStepDefinitions {

    VerifyPricePage verifyPricePage = new VerifyPricePage();
    LoginPage loginPage = new LoginPage();

    double priceOut;

    double priceIn;

    @When("User enter  username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password)
    {
        loginPage.setCredentials(username,password);

    }

    @When("User grab the Price of product in Page")
    public void user_grab_the_price_of_product_in_page()
    {
       priceOut = verifyPricePage.setPriceOut();

    }

    @When("User click on product and go inside")
    public void user_click_on_product_and_go_inside()
    {
        verifyPricePage.goToProduct();

    }

    @When("User grab the Price of product inside")
    public void user_grab_the_price_of_product_inside()
    {
        priceIn = verifyPricePage.setPriceIn();

    }

    @Then("Validate that the price is the same")
    public void validate_that_the_price_is_the_same()
    {
        Assert.assertEquals(priceOut,priceIn);
        System.out.println("Price outside of product is " + priceOut +
                " Price inside of product is " + priceIn);

    }


}
