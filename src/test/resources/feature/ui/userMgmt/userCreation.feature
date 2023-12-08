Feature: User Creation

  Background: Login in as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard
    Then I should see admin menu
    When I navigate to the user management page
    And I enter password in Administrator Access Page "qirV3*z!rWX2SGF"
    And I click confirm in Administrator Access Page
    Then I should see user management page

  Scenario Outline: Admin deactivates a user
    When I click create user btn
    Then I should see create user page
    When I enter <email> <username> <fullname> <password> in create user page
    And I click the user create btn
    #usremgt
    Then I should see the created user <username> in user browser table

    Examples:
      | email                 | username     | fullname     | password      | groups                      |
      | "johndoe@gmail.com"   | "John Doe"   | "John Doe"   | "password123" | "Jira-group-1;Jira-group-2" |
      | "adamsmith@gmail.com" | "Adam Smith" | "Adam Smith" | "password123" | "Jira-group-1"              |
      | "dianawest@gmail.com" | "Diana West" | "Diana West" | "password123" | "Jira-group-3"              |






