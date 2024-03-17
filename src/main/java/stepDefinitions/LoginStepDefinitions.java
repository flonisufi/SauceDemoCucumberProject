package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.LoginPage;
import utilities.Driver;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("When user is on Sauce Demo Page")
    public void when_user_is_on_sauce_demo_page()
    {

    }

    @When("User enter valid username {string} and password {string}")
    public void user_enter_valid_username_and_password(String username, String password)
    {
        loginPage.setCredentials(username,password);

    }

    @When("User click on Login")
    public void user_click_on_login()
    {
        loginPage.login();

    }

    @Then("User is on Home Page")
    public void user_is_on_home_page()
    {
        Assert.assertTrue(loginPage.addtoCart().isDisplayed());

    }


}
