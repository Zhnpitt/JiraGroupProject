Feature: Issue management
  #prerequiste : developer user,issue with status Todo


  Scenario Outline: As a developer user, I can change the status of an issue from “To Do” to “In Progress” and “Resolved”
    #

    Then the response status code should be 201


    Examples:
      | issueID |               |               |
      | "aaaaa" | "To Do"       | "In Progress" |
      | ""      | "In Progress" | "Resolved"    |