Feature: As a team leader user, I can create new sprint and move issues from the backlog to this sprint, then start it
  the current sprint.
  #login as an team lead
  #2 issues created in backlog
  Background: Login in as an leader user
    Given I visit the login page
    When I enter the Team lead username and password
    And I click the login button
    Then I should view the dashboard

  Scenario: create a sprint, move issues to it, then start

    And I click the team lead Backlog button
    And I click the create Sprint Button
    And I name the sprint sprintA
    And I create this sprint

    And I Move Issues From Backlog To Sprint

    And I start the sprint