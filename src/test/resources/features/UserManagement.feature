Feature: User Management

  Scenario: Create a new user
    Given the administrator is on the user creation page
    When the administrator creates a user with username "john_doe" and role "admin"
    Then the user "john_doe" should be present in the user list

  Scenario: Update an existing user's role
    Given the administrator is on the user list page
    When the administrator updates the role of user "john_doe" to "superadmin"
    Then the user "john_doe" should have the role "superadmin"

  Scenario: Delete a user
    Given the administrator is on the user list page
    When the administrator deletes the user "john_doe"
    Then the user "john_doe" should no longer exist in the user list
