package starter.steps;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class SearchApiSteps {
      EnvironmentVariables environmentVariables;
    public Response response;


    @Step
    public void getApiURL(String api) {
        String baseURL = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("environments.local.baseurl");
        response = SerenityRest.given().get(baseURL+api);
    }

    @Step
    public void verifyStatusCode(int expectedStatusCode) {
        restAssuredThat(response -> response.statusCode(expectedStatusCode));
    }

    @Step
    public void verifyTitle(String product) {
       String title = response.body().jsonPath().get("title").toString();
        assertTrue(title.contains(product));
    }

    @Step
    public void noResultsDisplayed() {
        String error = response.body().jsonPath().get("detail.error").toString();
        assertTrue(error.contains("true"));
    }

}
