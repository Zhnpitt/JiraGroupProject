Feature: Project workflow assignment

  Background: Login in as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
      | username     | password        |
      | niushang1997 | qirV3*z!rWX2SGF |
    And I click the login button
    Then I should view the dashboard

  Scenario Outline: create a project
    When I navigate to the admin projects page
    #/secure/project/BrowseProjects.jspa
    Then I should see project page
    When I click the project <projectName>
    #/plugins/servlet/project-config/SP/summary
    Then I should see project setting page
    When I click workflows in page panel navigation
    And I click the add workflow btn in project setting
    And  I click Add Existing in add workflow dropdown
    And I click <workflowName> as project workflow
    And I click Next btn in Add Existing Workflow
    And I pick all in Assign Issue Types

    Examples:
      | projectName       | workflowName |
      | "Scrum Project 1" | "workflow 1" |