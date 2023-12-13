Feature: I want to test to do item CRUD functionality with create a project
  Scenario:create a project
    When Admin create a project with name projectName and key PROJ
    Then the project role mgmt response status code should be 201