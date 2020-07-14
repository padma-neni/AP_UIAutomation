@e2etests
Feature: End2End tests
  As a user should able to create an account successfully

  Scenario: Existing user should able select product and to checkout successfully
    Given User clicks on "women" tab on home page
    And Click on "Blouse" product
    And Click on add to cart with "2" quantity and verify successful message
    And User clicks on "dresses" tab on home page
    And Click on "Printed Chiffon Dress" product
    And Click on add to cart with "1" quantity and verify successful message
    When User Clicks on "proceedToCheckout" on cart page
    And User clicks on "proceedToCheckout" on Shopping cart summary page
    And User click on login button entering valid login details
    And User clicks on "proceedToCheckout" on Shopping cart summary page
    And User agree terms of Service and click proceed to checkout in shipping page
    And Click on confirm order selecting "Bank" paymenttype
    Then User successfully navigates to OrderConfirmation page

  @smoketest
  Scenario: New user should able to create account and checkout successfully
    Given User clicks on "tshirts" tab on home page
    And Click on "Faded Short Sleeve T-shirts" product
    And Click on add to cart with "1" quantity and verify successful message
    When User Clicks on "proceedToCheckout" on cart page
    And User clicks on "proceedToCheckout" on Shopping cart summary page
    And click on create account entering "valid" email address
    And user enter valid mandatory personal information
    And click on Register
    And User clicks on "proceedToCheckout" on Address page
    And User agree terms of Service and click proceed to checkout in shipping page
    And Click on confirm order selecting "Bank" paymenttype
    Then User successfully navigates to OrderConfirmation page












