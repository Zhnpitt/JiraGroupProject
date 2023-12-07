Feature: Workflow Creation

  Background: Login in as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard
    Then I should see admin menu
    When I navigate to the admin issues page
    And I enter password in Administrator Access Page "qirV3*z!rWX2SGF"
    And I click confirm in Administrator Access Page
    Then I should see the issues page

  Scenario Outline: Admin create a workflow
    When I click the workflows btn in the Issues sidebar
    Then I should see workflow page
    When I click the add workflow btn in Issues
    And I enter <workflowName> and <description>
    And I click add btn in the add workflow form
    Then I should see view workflow steps page
    When I click workflows text btn
    And I add following new steps into workflow
      | stepName    | linkedStatus | destination | transitionName |
      | Closed      | Closed       |             |                |
      | Resolved    | Resolved     | Closed      | R2C            |
      | In Progress | In Progress  | Resolved    | I2R            |
      | To Do       | To Do        | In Progress | T2I            |





    Examples:
      | workflowName | description                           |
      | "workflow-1" | "To Do--InProgress--Resolved--Closed" |