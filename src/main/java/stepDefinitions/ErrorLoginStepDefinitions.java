package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ErrorLoginPage;
import pages.LoginPage;

public class ErrorLoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    ErrorLoginPage errorLoginPage = new ErrorLoginPage();

    @When("User enter invalid username {string} and password {string}")
    public void user_enter_invalid_username_and_password(String username, String password)
    {
        loginPage.setCredentials(username,password);

    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed()
    {
        Assert.assertEquals(errorLoginPage.errorMessage(),
                "Epic sadface: Username and password do not match any user in this service");


    }
}
