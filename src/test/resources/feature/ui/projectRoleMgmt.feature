Feature: Project Role management
  Background: Login in as an administrator and navigate to Project roles page
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | zhoulikekk | Whou3344603~ |
    And I click the login button
    Then I should view the dashboard
    When I click the admin menu button
    And I click the System button
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page
    Then I should see System page


  Scenario: Admin creates three project roles
    Given I am on the System page
    When I click the Project roles button
    Then I should see the Project Role Browser

    When I enter the valid Role Name and Description
    And I click the Add Project Role button
    Then I should see this new role in Project Role Browser


  Scenario: Create a project
    When I click the admin menu button again
    And I click the Projects button
    And I click the Create project button
    And I setup the project
    Then I create a project


  Scenario: Admin adds existing user to a project role
    When I click the admin menu button third
    And I click the Projects button again
    And I choose a project
    And I click the Users and roles button
    And I click the Add users to a role button
    And I enter valid user and role
    And I click the Add button
    Then I add a user to a role


  Scenario: After creation, I can filter users in a project based on their roles.
    When I click the drop box of created roles
    And I select a role
    Then I should see all users in this role


  Scenario: After creation, I can enable team lead manage sprints
    When I click the admin menu button forth
    And I click the Projects button forth
    And I choose a project again
    And I click the Permissions button
    And I click the Actions dropbox and select Edit permissions
    And I enter again password in Administrator Access Page "Whou3344603~"
    And I click again confirm in Administrator Access Page

    And I click manage sprints edit button
    And I select Project Role and select team lead
    And I click grant


  Scenario: After creation, I can enable team lead Assign Issues
    When I click the Assign Issues edit button
    And I select Project Role and select team lead again
    And I click grant again

  Scenario: After creation, I can enable developer resolve an issue
    When I click the Resolve Issues edit button
    And I select Project Role and select developer
    And I click grant third

  Scenario: After creation, I can enable QA close an issue
    When I click the Close Issues edit button
    And I select Project Role and select QA
    And I click grant forth

