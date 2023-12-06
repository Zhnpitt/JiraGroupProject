Feature: Create role functionality
  Scenario: Valid login
    Given I am on the Project Role Browser page
    When I enter the valid Role Name and Description
    And click the Add Project Role button
    Then I should get a new role in Project Role Browser