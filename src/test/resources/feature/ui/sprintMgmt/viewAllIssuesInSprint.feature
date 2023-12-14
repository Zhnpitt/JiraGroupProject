Feature: I can view all the issues in the current sprint
  #login as an team lead
  #2 issues created in backlog
  Background: Login in as an leader user
    Given I visit the login page
    When I enter the username John Doe and password password123
    And I click the login button
    Then I should view the dashboard

  Scenario: view all the issues in the current sprint
    When I click the project button in team lead dashboard
    And I choose current project
    And I click the team lead Backlog button
    And I view all the issues in the current sprint