package com.example.steps;


import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.example.UserAPI;

public class UserAPISteps {

    private UserAPI userAPI = new UserAPI();
    private Response response;

    @Given("the API is available")
    public void the_API_is_available() {
        // Optionally, perform a health check
        RestAssured.baseURI = "http://localhost:8080/api";
    }

    @When("a GET request is made to {string}")
    public void a_GET_request_is_made_to(String endpoint) {
        response = userAPI.getRequest(endpoint);
    }

    @When("a POST request is made to {string} with payload:")
    public void a_POST_request_is_made_to_with_payload(String endpoint, String payload) {
        response = userAPI.postRequest(endpoint, payload);
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer statusCode) {
        Assert.assertEquals(statusCode.intValue(), response.getStatusCode());
    }

    @Then("the response body should contain {string} with value {string}")
    public void the_response_body_should_contain_with_value(String key, String value) {
        String actualValue = response.jsonPath().getString(key);
        Assert.assertEquals(value, actualValue);
    }

    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String key) {
        Assert.assertTrue(response.jsonPath().getString(key) != null);
    }

    @Then("the user {string} should exist in the system")
    public void the_user_should_exist_in_the_system(String username) {
        Response getUserResponse = userAPI.getRequest("/users/" + username);
        Assert.assertEquals(200, getUserResponse.getStatusCode());
    }
}
