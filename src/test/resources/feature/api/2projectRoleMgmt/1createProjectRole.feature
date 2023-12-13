Feature: I want to test to do item CRUD functionality with create project role

  Scenario Outline: create project role
    When Admin send request with role name <roleName> and role description <roleDescription>
    Then the project role mgmt response status code should be 200
    #OR 409 ? Returned if a role with given name already exists.
    Examples:
      | roleName    | roleDescription |
      | Team lead   | team lead     |
      | Developer   | developer     |
      | QA          | QA            |
