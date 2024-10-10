package com.example.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;

public class UserAuthenticationSteps {

    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage;
    private String errorMessage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.navigateToLogin();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        dashboardPage = loginPage.login("validUser", "validPassword");
    }

    @When("the user enters an invalid password")
    public void the_user_enters_an_invalid_password() {
        errorMessage = loginPage.loginWithInvalidPassword("validUser", "invalidPassword");
    }

    @When("the user enters a non-existent username")
    public void the_user_enters_a_non_existent_username() {
        errorMessage = loginPage.loginWithNonExistentUser("nonExistentUser", "anyPassword");
    }

    @Then("the user is redirected to the dashboard")
    public void the_user_is_redirected_to_the_dashboard() {
        Assert.assertTrue(dashboardPage.isDisplayed());
    }

    @Then("an error message {string} is displayed")
    public void an_error_message_is_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, errorMessage);
    }
}
