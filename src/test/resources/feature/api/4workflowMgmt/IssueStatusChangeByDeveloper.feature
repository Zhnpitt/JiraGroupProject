Feature: Issue management
#pre:a empty project with key PROJ
#create workflow
#assign the workflow to project
#Adam Smith user

  Scenario Outline: As a developer user, I can change the status of an issue from “To Do” to “In Progress” and "Resolved"
    Given admin user create a issue in project with projectKey API
    When I login with <developerUsername> and <developerPassword>
    Then the response status code should be 200
    When I find the <prevStatus> status issue in project with projectKey API
    When I change the issue status by <transitionName>
    Then the response status code should be 204

    Examples:
      | developerUsername | developerPassword | prevStatus    | transitionName |
      | "Adam Smith"      | "password123"     | "To Do"       | "T2I"          |
      | "Adam Smith"      | "password123"     | "In Progress" | "I2R"          |