Feature: I want to test to do item CRUD functionality with user signup

  @User
  Scenario Outline : User login
    #login
    When the user logs in with with username <username> and password <password>
    Then the response status code should be 200

    Examples:
      | username     | password       |
      | "zhoulikekk" | "Whou3344603~" |