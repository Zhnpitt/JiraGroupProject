Feature: Add a user to a role functionality
  Scenario: After creating roles
    Given I am on the Project settings page
    When I click Add users to a role button
    And select a user and a role
    And click Add button
    Then I can see user information and role in this page