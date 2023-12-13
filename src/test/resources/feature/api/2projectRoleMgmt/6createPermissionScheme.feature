Feature: I want to test to do item CRUD functionality with create permission scheme

  Scenario: create permission scheme
    #create permission scheme
    When Admin create permission scheme with scheme name PS-1 and description XXXXX
    Then the project role mgmt response status code should be 201


  #prerequite:
    # no scheme with same name is creates
  #API:
    #POST /rest/api/2/permissionscheme
  #Body/Param:
    # public class PermissionScheme {
    #    String name;
    #    String description;
    #}