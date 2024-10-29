Feature:   UC-3 Successful login
  @Smoke
  Scenario Outline: Redirecting to the new page after passing valid credentials
    Given I enter login credentials with username "<username>" and password "<password>"
    When I click on the login button
    Then Verify that page name is valid <name>

    Examples:
      | username                | password     | name      |
      | visual_user             | secret_sauce | Swag Labs |
      | locked_out_user         | secret_sauce | Swag Labs |
      | standard_user           | secret_sauce | Swag Labs |
      | performance_glitch_user | secret_sauce | Swag Labs |