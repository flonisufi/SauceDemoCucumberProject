package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LogoutPage;

public class LogoutStepDefinitions {

    LogoutPage logoutPage = new LogoutPage();

    @When("User check on menu and click Logout")
    public void user_check_on_menu_and_click_logout()
    {
        logoutPage.logOutAcc();

    }

    @Then("User is redirected to Login Page")
    public void user_is_redirected_to_login_page()
    {
        Assert.assertTrue(logoutPage.loginBtn().isDisplayed());

    }

}
