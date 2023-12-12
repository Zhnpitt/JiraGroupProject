Feature: I want to test to do item CRUD functionality with filter user by role

  Scenario Outline: filter user by role
    When Admin filter users with role name <roleName>
    Then the
#    Then the project role mgmt response status code should be 200
    #OR 409 ? Returned if a role with given name already exists.
    Examples:
      | roleName   | roleDescription |
      | Team lead  | team lead       |
      | Developer  | developer       |
      | QA         | QA              |
