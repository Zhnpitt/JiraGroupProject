Feature: Log in as a team leader and end the current active sprint.
# a created project
  #a created and started sprint
  Background: Login in as a team leader
    Given I visit the login page
    When I enter the Team lead username and password
    And I click the login button
    Then I should view the dashboard

  Scenario Outline:
    When I click project in the header
    And I click View All Projects
    Then I should see BrowseProjects page
    When I click <projectName> in project list
    And I click Active sprints in sidebar
    And I click Complete sprint btn
    And I click Complete btn in Complete sprint dialog


    Examples:
      | projectName   |
      | "projectName" |