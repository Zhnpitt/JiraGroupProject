Feature: As an admin user I can create a project
  Background: Login in as an administrator
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | zhoulikekk | Whou3344603~ |
    And I click the login button
    Then I should view the dashboard

  Scenario:I create a Scrum project
    When I click the admin menu button
    And I click the Projects button
    And I setup the project with "projectName" and "PROJ"