Feature: I want to test to do item CRUD functionality with user signup

  Scenario Outline: Admin User login and create user

    #login
    When the user logs in with with username <username> and password <password>
    Then the response status code should be 200

    When I create a user <userName> <fullName> <email> <password>
    Then the response status code should be 201

    Examples:
      | username       | password          | userName  | fullName               | email                      | password      | applicationKeys
      | "niushang1997" | "qirV3*z!rWX2SGF" | "charlie" | "Charlie of Atlassian" | "   charlie@atlassian.com" | "abracadabra" | "jira-core"     |