Feature: As an admin user, I can create groups and assign existing users to different groups

  Scenario: login in as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard
    Then I should see admin menu
    When I navigate to the user management page
    And I enter password in Administrator Access Page
    And I click confirm in Administrator Access Page
    Then I should see user management page

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