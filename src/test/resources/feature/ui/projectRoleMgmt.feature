Feature: Project Role management
  Background: Login in as an administrator and navigate to Project roles page
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | zhoulikekk | Whou3344603~ |
    And I click the login button
    Then I should view the dashboard

  Scenario: Admin creates three project roles
    When I click the admin menu button
    And I click the System button
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page
    And I click the Project roles button
    And I enter the valid team lead and team lead
    And I click the Add Project Role button
    And I enter the valid developer and developer
    And I click the Add Project Role button
    And I enter the valid QA and QA
    And I click the Add Project Role button

  Scenario: Create a project
    When I click the admin menu button again
    And I click the Projects button
    And I create and setup the project with projectName and projectKey

  Scenario: Admin adds existing user to a project role
    When I click the admin menu button third
    And I click the Projects button again
    And I choose a project
    And I click the Users and roles button

    And I click the Add users to a role button
    And I enter valid johndoe@gmail.com and Team lead
    And I click the Add button
    And I click the Add users to a role button
    And I enter valid Adam Smith and Developer
    And I click the Add button
    And I click the Add users to a role button
    And I enter valid Bob Dylan and Developer
    And I click the Add button
    And I click the Add users to a role button
    And I enter valid Cindy Lee and Developer
    And I click the Add button
    And I click the Add users to a role button
    And I enter valid Diana West and QA
    And I click the Add button

  Scenario: After creation, I can filter users in a project based on their roles.
    When I click the admin menu button third
    And I click the Projects button again
    And I choose a project
    And I click the Users and roles button
    And I can filter all developer
    And I can filter all QA
    And I can filter all Team Lead

  Scenario: After creation, I can enable team lead manage sprints
    When I click the admin menu button
    And I click the Projects button
    And I choose a project
    And I click the Permissions button
    And I click the Actions dropbox and select Edit permissions
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page

    And I click permission edit button
    And I select a permission Manage Sprints
    And I select Granted to Project Role
    And I grant a team lead

  Scenario: After creation, I can enable team lead Assign Issues
    When I click the admin menu button
    And I click the Projects button
    And I choose a project
    And I click the Permissions button
    And I click the Actions dropbox and select Edit permissions
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page

    And I click permission edit button
    And I select a permission Assign Issues
    And I select Granted to Project Role
    And I grant a team lead

  Scenario: After creation, I can enable develope Resolve Issues
    When I click the admin menu button
    And I click the Projects button
    And I choose a project
    And I click the Permissions button
    And I click the Actions dropbox and select Edit permissions
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page

    And I click permission edit button
    And I select a permission Resolve Issues
    And I select Granted to Project Role
    And I grant a developer

  Scenario: After creation, I can enable QA Close Issues
    When I click the admin menu button
    And I click the Projects button
    And I choose a project
    And I click the Permissions button
    And I click the Actions dropbox and select Edit permissions
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page

    And I click permission edit button
    And I select a permission Close Issues
    And I select Granted to Project Role
    And I grant a QA



