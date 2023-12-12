Feature: Login s an admin user and edit columns in the Scrum board
#Requirment: A created project with create workflow named Workflow project
# Optional: create issues in different status in this project
  Background:
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard

  Scenario Outline:
    When I click project in the header
    And I click View All Projects
    Then I should see BrowseProjects page
    When I click <projectName> in project list
#In project content
    When I click Backlog in sidebar
    And I click Board btn in Backlog
    And I click Configure in Board drop down
    Then I should view Rapid View page
    When I click Columns in Configuration sidebar
#Column management
    Then I should see Column management content
    #Then I should see issue in different column
    When I add a new column with <columnName> and <category>
    Then I should see column with name <columnName>
    When I change column <columnName> to <newColumnName>
    Then I should see column with name <newColumnName>
    When I delete column <newColumnName>
    Then i should not see <newColumnName>


    Examples:
      | projectName   | columnName | category     | newColumnName |
      | "projectName" | "column 1" | "In process" | 'Column new'  |