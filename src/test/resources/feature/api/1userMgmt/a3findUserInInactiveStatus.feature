Feature: User management

   Scenario Outline: find user by inactive status
      When I find user <userName> by inactive status
      Then the response status code should be 200
      And I should see <userName> in status result set

      Examples:
         | userName  |
         | "charlie" |