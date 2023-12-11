Feature: Issue management
  #prerequiste : QA user,issue with status Resolved

  Scenario Outline: As a QA user, I can change the status of an issue from “Resolved”  to “Close”
    #
    Then the response status code should be 201


    Examples: