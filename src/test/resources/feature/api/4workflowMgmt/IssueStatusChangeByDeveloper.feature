Feature: Issue management
#pre:a empty project with key PROJ
#create workflow
#assin the workflow to project
#Adam smith user

  Scenario Outline: As a developer user, I can change the status of an issue from “To Do” to “In Progress”
    Given admin user create a issue in project with projectKey PROJ
    When I login with <developerUsername> and <developerPassword>
    Then the response status code should be 200
    When I find the <prevStatus> status issue in project with projectKey PROJ
    When I change the issue status by <transitionName>
    Then the response status code should be 204

    Examples:
      | developerUsername | developerPassword | prevStatus    | transitionName |
      | "Adam Smith"      | "password123"     | "To Do"       | "T2I"          |
      | "Adam Smith"      | "password123"     | "In Progress" | "I2R"          |