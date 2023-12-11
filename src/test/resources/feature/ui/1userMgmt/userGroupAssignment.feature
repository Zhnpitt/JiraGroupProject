Feature: User Group Assignment

  Background: Login as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard
    Then I should see admin menu
    When I navigate to the user management page
    And I enter password in Administrator Access Page
    And I click confirm in Administrator Access Page
    Then I should see user management page

  Scenario Outline: Admin assigns a user to different user groups

 # Scenario:Admin assigns a user to different user groups
    Given a user <username> exists in user browser table
    When I assign the user <username> to <groups>
    Then the user <username> should be assigned to <groups>

  #Scenario:Admin finds users by group filter
    When I select <groups> in group filter
    And I click filter btn
    Then I should see the user <username> in the result set


    Examples:
      | email                 | username     | fullname     | password     | groups                |
      | "adamsmith@gmail.com" | "Adam Smith" | "Adam Smith" | "password123 | "jira-software-users" |