Feature:  UC-1 Login form with empty username input
  @Smoke
  Scenario Outline: Display of required error message when the username input is empty
    Given  I enter login credentials with username "<username>" and password "<password>"
    When I clear the username input
    And I click on the login button
    Then Verify that the error message appears <error>

    Examples:
      | username                | password     | error                              |
      | problem_user            | qwerty123!@# | Epic sadface: Username is required |
      | problem_user            | problem_user | Epic sadface: Username is required |
      | standard_user           | null         | Epic sadface: Username is required |
      | performance_glitch_user | zero         | Epic sadface: Username is required |