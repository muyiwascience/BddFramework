package equalexperts.io.stepsdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class APIGetBookingFormSteps {

    private RequestSpecification requestSpec;
    private Response response;
    private ResponseBody BodyResponse;


    @Given("^I have access to the web api$")
    public void iHaveAccessToTheWebApi() throws Throwable {
        RestAssured.baseURI = "";
        this.requestSpec = RestAssured.given().accept("application/json");

    }

    @When("^i fetch a booking form$")
    public void iFetchABookingForm() throws Throwable {
        this.response = requestSpec.when().get("http://hotel-test.equalexperts.io/");
    }

    @Then("^i should see the details$")
    public void iShouldSeeTheDetails() throws Throwable {
        Assert.assertEquals(response.thenReturn().statusCode(), 200);
        Headers headers =  response.thenReturn().headers();

    }
}
