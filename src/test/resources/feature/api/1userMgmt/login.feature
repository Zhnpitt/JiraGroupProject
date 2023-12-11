Feature: I want to test to do item CRUD functionality with user signup

  @User
  Scenario Outline: User signup and login

    #login
    When the user logs in with with username <username> and password <password>
    Then the response status code should be 200

    Examples:
      | username       | password          |
      | "niushang1997" | "qirV3*z!rWX2SGF" |