Feature: User management

  Scenario Outline: Apply filter to dins user in group
    When I get users from group <userGroup>
    Then I should see <userName> in group result set
    Examples:
      | userName      | userGroup      |
      | "Adam Smith2" | "Jira-group-2" |