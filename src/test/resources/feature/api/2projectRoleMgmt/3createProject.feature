Feature: I want to test to do item CRUD functionality with create a project
  Scenario:create a project
    When Admin create a project with name projectName and key PROJ
    Then the project role mgmt response status code should be 201

  #prerequite:
    # no project with same name is creates
    # a user to be assigned as lead
  # API:
    #POST /rest/api/2/project
  #Body/Param:
    # public class Project {
    #    private String name;
    #    private String key;
    #    private String projectTypeKey;
    #    private String lead;
    #}