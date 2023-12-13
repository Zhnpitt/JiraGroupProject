Feature: I want to grant permissions to certain project role

  Scenario Outline: grant permissions to certain project role
    #grant project role
    When Admin grant a role permission with type <type>,  role name <roleName> and permission <permission>
    Then the project role mgmt response status code should be 201
    #OR 409 ? Returned if a role with given name already exists.
    Examples:
      |  type           | roleName    | permission       |
      |projectrole      | Team lead   | MANAGE_SPRINTS_PERMISSION     |
      |projectrole      | Team lead   | ASSIGN_ISSUES    |
      |projectrole      | Developer   | RESOLVE_ISSUES   |
      |projectrole      | QA          | CLOSE_ISSUES     |

  #prerequite:
    # a permission scheme and roles are created
  #API:
    #POST /rest/api/2/permissionscheme/{schemeId}/permission
    #GET /rest/api/2/project/{projectKey}/role
    #GET /rest/api/2/permissionscheme
  #Body/Param:
    # Permission key
    # Role ID
    # Scheme ID

