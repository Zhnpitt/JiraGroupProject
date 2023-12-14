@Ignore
#default implemented when create a project
Feature: I want to test to do item CRUD functionality with add existing user to a project role

  Scenario Outline: add existing user to a project role
    When Admin add a User Name <User Name> to a role name <role name>
    Then the project role mgmt response status code should be 200
    #OR 409 ? Returned if a role with given name already exists.
    Examples:
      | User Name  | role name |
      | John Doe   | Team lead |
      | Adam Smith | Developer |
      | Bob Dylan  | Developer |
      | Cindy Lee  | Developer |
      | Diana West | QA        |

  # automatically done