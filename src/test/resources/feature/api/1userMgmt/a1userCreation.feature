Feature: User management

  Scenario Outline: create user
    #create
    When I create a user <userName> <fullName> <email> <password>
    Then the response status code should be 201

    Examples:
      | userName      | fullName               | email                   | password      |
      | "charlie"     | "Charlie of Atlassian" | "charlie@atlassian.com" | "abracadabra" |
      | "Adam Smith2" | "Adam Smith2"          | "adamsmith2@gmail.com"  | "password123" |
      | "Diana West2" | "Diana West2"          | "dianawest2@gmail.com"  | "password123" |