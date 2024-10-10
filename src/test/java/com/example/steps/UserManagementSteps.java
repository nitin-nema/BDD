package com.example.steps;

package com.example.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import com.example.pages.AdminPage;

public class UserManagementSteps {

    private AdminPage adminPage = new AdminPage();
    private boolean userExists;
    private String userRole;

    @Given("the administrator is on the user creation page")
    public void the_administrator_is_on_the_user_creation_page() {
        adminPage.navigateToUserCreation();
    }

    @When("the administrator creates a user with username {string} and role {string}")
    public void the_administrator_creates_a_user_with_username_and_role(String username, String role) {
        adminPage.createUser(username, role);
    }

    @Then("the user {string} should be present in the user list")
    public void the_user_should_be_present_in_the_user_list(String username) {
        userExists = adminPage.isUserPresent(username);
        Assert.assertTrue("User should exist in the list", userExists);
    }

    @Given("the administrator is on the user list page")
    public void the_administrator_is_on_the_user_list_page() {
        adminPage.navigateToUserList();
    }

    @When("the administrator updates the role of user {string} to {string}")
    public void the_administrator_updates_the_role_of_user_to(String username, String newRole) {
        adminPage.updateUserRole(username, newRole);
        userRole = adminPage.getUserRole(username);
    }

    @Then("the user {string} should have the role {string}")
    public void the_user_should_have_the_role(String username, String expectedRole) {
        Assert.assertEquals(expectedRole, userRole);
    }

    @When("the administrator deletes the user {string}")
    public void the_administrator_deletes_the_user(String username) {
        adminPage.deleteUser(username);
    }

    @Then("the user {string} should no longer exist in the user list")
    public void the_user_should_no_longer_exist_in_the_user_list(String username) {
        userExists = adminPage.isUserPresent(username);
        Assert.assertFalse("User should not exist in the list", userExists);
    }
}
