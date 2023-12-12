Feature: Issue management
#pre:a empty project with key PROJ
  #newly create issue start with TODO

  #prerequiste : to do to in progress
  Scenario Outline: As a developer user, I can change the status of an issue from “To Do” to “In Progress”
    When admin user create a issue in project with projectKey PROJ
    When I login with <developerUsername> and <developerPassword>
    Then the response status code should be 200
    When I find the <prevStatus> status issue in project with projectKey PROJ
    When I change the issue status from <prevStatus> to <nextStatus>
    Then the response status code should be 204

    Examples:
      | developerUsername | developerPassword | prevStatus | nextStatus    |
      | "Adam Smith"      | "password123"     | "To Do"    | "In Progress" |
      | "Adam Smith"      | "password123"     | "Progress" | "In Resolved" |

#    #only one issue with in progress status
#  Scenario Outline: As a developer user, I can change the status of an issue from “In Progress” to “Resolved”
#    When I login with <username> and <password>
#    Then the response status code should be 200
#    When I find the <prevStatus> status issue in project with projectKey PROJ
#    When I change the issue status from <prevStatus> to <nextStatus>
#    Then the response status code should be 204
#
#    Examples:
#      | username     | password      | prevStatus | nextStatus    |
#      | "Adam Smith" | "password123" | "Progress" | "In Resolved" |