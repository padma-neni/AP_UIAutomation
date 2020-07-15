@accountstest @regressiontest
Feature: Accounts tests
  As a user should able to create an account successfully

  Scenario: User should able to create an account successfully
    Given User clicks on sign in link on homepage
    And click on create account entering "valid" email address
    When user enter valid mandatory personal information
    And click on Register
    Then account should be created successfully

  Scenario: User should not be able to create account with existing emailaddress
    Given User clicks on sign in link on homepage
    And click on create account entering "existing" email address
    Then error message should be displayed

  Scenario: User should able to login with existing details
    Given User clicks on sign in link on homepage
    When User click on login button entering valid login details
    Then user should successfully logged in

