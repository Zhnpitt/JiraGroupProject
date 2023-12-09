Feature: As a team leader user, I can create and start a new sprint
  #login as an team lead
  Background: Login in as an administrator
    Given I visit the login page
    When I enter the team lead username and password
      | username   | password |
      | John Doe | password123 |
    And I click the login button
    Then I should view the dashboard

  Scenario: create and start a new sprint
    When I click the project button in team lead dashboard
    And I choose current project
    And I click the create Sprint Button
    And I name the sprint sprint1
    And I create this sprint
