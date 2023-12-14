Feature: User management

  Scenario Outline: Assign user to different group and apply filter
    When I add user <userName> to group <userGroup>
    Then the response status code should be 201
    Examples:
      | userName      | userGroup      |
      | "Adam Smith2" | "Jira-group-2" |