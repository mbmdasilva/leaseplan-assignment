package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.steps.SearchApiSteps;



public class SearchStepDefinitions {

    @Steps
    public SearchApiSteps searchApi;

    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String api) {
        searchApi.getApiURL(api);
    }

    @Then("he sees the results displayed for {string}")
    public void heSeesTheResultsDisplayedFor(String product) {
        searchApi.verifyStatusCode(200);
        searchApi.verifyTitle(product);
    }

    @Then("he does not see the results")
    public void he_Doesn_Not_See_The_Results() {
       searchApi.noResultsDisplayed();
    }

}
