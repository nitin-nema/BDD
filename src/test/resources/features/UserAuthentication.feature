Feature: User Authentication

  Scenario: Successful Login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user is redirected to the dashboard

  Scenario: Failed Login with Invalid Password
    Given the user is on the login page
    When the user enters an invalid password
    Then an error message "Invalid credentials" is displayed

  Scenario: Failed Login with Non-Existent User
    Given the user is on the login page
    When the user enters a non-existent username
    Then an error message "User does not exist" is displayed
