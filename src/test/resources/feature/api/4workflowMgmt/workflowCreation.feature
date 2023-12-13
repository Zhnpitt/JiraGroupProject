Feature: Workflow creation

  Scenario Outline:As an admin user, I can create the following workflow: To Do → In Progress → Resolved → Closed
    When I log in as admin user
    Then the response status code should be 200
    When I create a workflow Scheme called "WC-1"
    Then the response status code should be 200
    When I create add a workflow to scheme
    Then the response status code should be 200
    When I create a workflow called "wf1"
    Then the response status code should be 200
    When I defines the following workflow steps:
      | Step Name   |
      | To Do       |
      | In Progress |
      | Resolved    |
      | Closed      |
    And I creates transitions between the steps as follows:
      | From Step   | To Step     | Transition Name |
      | To Do       | In Progress | Start Progress  |
      | In Progress | Resolved    | Resolve Issue   |
      | Resolved    | Closed      | Close Issue
    And associates the workflow with issue types "Task" and "Bug"
    Then the workflow "MyWorkflow" is successfully created and configured

    Examples:
      | developerUsername | developerPassword | prevStatus    | transitionName |
      | "Adam Smith"      | "password123"     | "To Do"       | "T2I"          |
      | "Adam Smith"      | "password123"     | "In Progress" | "I2R"          |