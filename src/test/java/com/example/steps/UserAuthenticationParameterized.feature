Feature: User Authentication with Parameterization

  Scenario Outline: User attempts to log in
    Given the user is on the login page
    When the user logs in with username "<username>" and password "<password>"
    Then the login should be "<status>"

    Examples:
      | username      | password       | status     |
      | validUser     | validPass      | successful |
      | validUser     | wrongPass      | failed     |
      | invalidUser   | anyPass        | failed     |
