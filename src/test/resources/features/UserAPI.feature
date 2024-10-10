Feature: User API Integration

  Scenario: Retrieve user details
    Given the API is available
    When a GET request is made to "/users/1"
    Then the response status should be 200
    And the response body should contain "username" with value "john_doe"

  Scenario: Create a new user via API
    Given the API is available
    When a POST request is made to "/users" with payload:
      """
      {
        "username": "jane_doe",
        "password": "securePass123",
        "role": "user"
      }
      """
    Then the response status should be 201
    And the response body should contain "id"
    And the user "jane_doe" should exist in the system
