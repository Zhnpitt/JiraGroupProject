Feature: User management

  Scenario Outline: Deactivate a user
    #deactivate
    When I deactivate user <userName>
    Then the response status code should be 200
    #deactivate user try to log in and fail
    When the user login with <userName> and <password>
    Then the response status code should be 401
    Examples:
      | userName  | password      |
      | "charlie" | "abracadabra" |