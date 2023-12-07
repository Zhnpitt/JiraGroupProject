Feature: Workflow Creation

  Background: Login in as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard

  Scenario Outline: create a project
    When I click project in header
    And I click create project in project dropdown
    And I select Scrum Software Development in Crate Project dialog
    And I click next btn in Create Project dialog
    And I click Select btn in Scrum software development dialog
    And I enter <projectName> in Scrum software development dialog
    And I click Submit btn in in Scrum software development dialog





    Examples:
      | projectName       | workflowName |
      | "Scrum Project 1" | "workflow 1" |