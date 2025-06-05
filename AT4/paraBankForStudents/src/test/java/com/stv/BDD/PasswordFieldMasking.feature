Feature: Password Field Masking

  Scenario: Password field should remain masked after browser autofill
    Given I have saved credentials in my browser
    When I navigate to Wiggle.com/login
    And the browser autofills my password
    Then the password field should display masked characters (•••••)
    And the visibility toggle should default to "hidden" state

  Scenario Outline: Login with different invalid credentials
    Given I am on the Wiggle login page
    When I enter "<username>" and "<password>"
    And I click the login button
    Then I should see "<error_message>"