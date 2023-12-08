Feature: As an admin user I can create three project roles (team lead, developer, QA)
  #login as an admin user
  Background: Login in as an administrator
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | zhoulikekk | Whou3344603~ |
    And I click the login button
    Then I should view the dashboard

  Scenario: test
    #create a permission scheme
    When I click the admin menu button
    And I click the issue button
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page
    And I click the Permission schemes button
    And I click the Add permission scheme button
    And I name the scheme PS-1
    And I click the permission scheme submit button
    And I choose this scheme to edit

    #grant team lead Manage Sprints
    And I click permission edit button
    And I select a permission Manage Sprints
    And I select Granted to Project Role
    And I grant a team lead

    #grant team lead Assign Issues
    And I click permission edit button
    And I select a permission Assign Issues
    And I select Granted to Project Role
    And I grant a team lead

    #grant developer Resolve Issues
    And I click permission edit button
    And I select a permission Resolve Issues
    And I select Granted to Project Role
    And I grant a developer

    #grant QA Close Issues
    And I click permission edit button
    And I select a permission Close Issues
    And I select Granted to Project Role
    And I grant a QA