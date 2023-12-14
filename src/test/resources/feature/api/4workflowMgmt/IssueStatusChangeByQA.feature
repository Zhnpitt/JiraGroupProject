Feature: Issue management
  #prerequiste : QA user,issue with status Resolved
#pre:a  project with key PROJ

#create workflow
#assin the workflow to project
#Adam smith user
#A issue with status Resolved


  Scenario Outline: As a QA user, I can change the status of an issue from “Resolved”  to “Close”

    When I login with <QAUsername> and <QAPassword>
    Then the response status code should be 200
    When I find the <prevStatus> status issue in project with projectKey PROJ
    When I change the issue status by <transitionName>
    Then the response status code should be 204

    Examples:
      | QAUsername   | QAPassword    | prevStatus | transitionName |
      | "Diana West" | "password123" | "Resolved" | "R2C"          |