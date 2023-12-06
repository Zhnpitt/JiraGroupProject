Feature: filter users in a project functionality
  Scenario: After creating roles
    Given I am on the Project settings page
    When I click the Roles button
    And select a role
    Then I can see users in the role in this project