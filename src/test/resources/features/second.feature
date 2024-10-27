Feature: UC-2 Login form with empty password input
  @Smoke
  Scenario Outline: Error message appears
    Given I type the login credentials <username> <password>
    When I clear the password input
    And I click on the login button
    Then Verify that the error message appears <error>

    Examples:
      | username                | password     | error                              |
      | problem_user            | qwerty123!@# | Epic sadface: Password is required |
      | problem_user            | problem_user | Epic sadface: Password is required |
      | standard_user           | null         | Epic sadface: Password is required |
      | performance_glitch_user | "'"          | Epic sadface: Password is required |