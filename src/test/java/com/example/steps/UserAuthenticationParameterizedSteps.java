package com.example.steps;

package com.example.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import com.example.pages.LoginPage;
import com.example.pages.DashboardPage;

public class UserAuthenticationParameterizedSteps {

    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage;
    private String errorMessage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.navigateToLogin();
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        if (username.equals("validUser") && password.equals("validPass")) {
            dashboardPage = loginPage.login(username, password);
        } else if (!username.equals("validUser")) {
            errorMessage = loginPage.loginWithNonExistentUser(username, password);
        } else {
            errorMessage = loginPage.loginWithInvalidPassword(username, password);
        }
    }

    @Then("the login should be {string}")
    public void the_login_should_be(String status) {
        if (status.equals("successful")) {
            Assert.assertTrue(dashboardPage.isDisplayed());
        } else {
            Assert.assertFalse(errorMessage.isEmpty());
        }
    }
}
