Feature: Log in as a developer user and change the status of an issue from “To Do” to “In Progress” and “Resolved”.

  Background: Login in as a developer
    Given I visit the login page
    When I enter the developer username and password
    And I click the login button
    Then I should view the dashboard

  Scenario Outline: change the status of an issue from “To Do” to “In Progress” and “Resolved”
    When I click project in the header
    And I click View All Projects
    Then I should see BrowseProjects page
    When I click <projectName> in project list
    #the following step is to guarantee a uniform start point(web app remembers last sidebar tab)
    And I click Issues in sidebar
    And I click issue <todoIssueSummary> in list panel
    #Change Status
    Then I should see issue in <curStatus> status
    When I click the status btn in issue content
    And I click <nextStatus> status in dropdown
    Then I should see issue in <nextStatus> status


    Examples:
      | projectName   | todoIssueSummary | curStatus     | nextStatus    |
      | "projectName" | "task2 by John"  | "To Do"       | "In Progress" |
      | "projectName" | "task2 by John"  | "In Progress" | "Resolved"    |