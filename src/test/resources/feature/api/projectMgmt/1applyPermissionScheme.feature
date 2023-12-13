Feature: I want to test to do item CRUD functionality with apply a permission scheme to a project
  Scenario: apply an existing permission scheme to a project
    When I can apply an existing permission scheme PS-1 to a project PROJ
    Then the project role mgmt response status code should be 200



  #prerequite:
    # a permission scheme and a project
  #API:
    #PUT /rest/api/2/project/{projectIdOrKey}
    #GET /rest/api/2/permissionscheme
  #Body/Param:
    # Permission key
    # Project Key