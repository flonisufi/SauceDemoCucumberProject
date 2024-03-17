package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SortingPage;
import pages.VerifyPricePage;

public class SortingStepDefinitions {

    SortingPage sortingPage = new SortingPage();

    @When("User go to sorting and sort Name \\(Z to A)")
    public void user_go_to_sorting_and_sort_name_z_to_a()
    {
        sortingPage.sorting();

    }

    @Then("Validate that product are sorted")
    public void validate_that_product_are_sorted()
    {
        Assert.assertEquals(sortingPage.sortingText(),"Name (Z to A)");

    }


}
