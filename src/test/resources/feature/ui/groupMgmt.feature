Feature: As an admin user, I can create groups and assign existing users to different groups
  #1.login in as an admin
  Scenario: Login in as an admin user and get WebSudo
    Given I visit the Login page
    When I enter the username "zhangchris280"
    And I enter the password "Zhn122737"
    And I click the login button
    Then I should view the dashBoard
    When I click Setting button
    And I click user management option
    Then I should view webSudo authentication page
    When I enter WebSudo password "Zhn122737"
    And And I click the confirm button
    Then I should view user management page

  Scenario: Create different groups
    When I click groups button
    And I input new "Jira-group-1"
    And I click add group button
    And I input new "Jira-group-2"
    And I click add group button
    And I input new "Jira-group-3"
    And I click add group button
    And I input new "group-4"
    And I click add group button
    Then I can view the new created groups

  Scenario: Assign existing users to different groups
    When I click bulk Edit Group Members button
    And I input "Jira" in group selected area
    And I choose target group
    And I input another "gro" in group selected area
    And I choose another target group
    And I input existing user names "Adam Smith, Diana West"
    And I click add Selected Users button
    Then I can view new users in group member table
