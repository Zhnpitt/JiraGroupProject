Feature: After creation, I can filter users in a project based on their roles.

  Background: Login in as an administrator
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard

  Scenario: After creation, I can filter users in a project based on their roles.
    When I click the admin menu button third
    And I click the Projects button again
    And I choose a project
    And I click the Users and roles button
    And I can filter all developer
    And I can filter all QA
    And I can filter all Team Lead