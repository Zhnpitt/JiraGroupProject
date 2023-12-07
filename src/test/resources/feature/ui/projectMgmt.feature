Feature: Project management
  Background: Login in as an administrator and navigate to Project page
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | zhoulikekk | Whou3344603~ |
    And I click the login button
    Then I should view the dashboard

  Scenario: create a Scrum project and apply an existing permission scheme
    When I click the admin menu button
    And I click the Project button
    And I setup the project
    Then I create a project

    When I click the admin menu button again
    And I click the Project button again
    And I select a project
    And I click the Permissions button
    And I click the Actions button and select use a different scheme
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page

    And I select a scheme and click associate button

  Scenario: I can add user to the current project
    ??????????

  Scenario: I can create different epics
    When I click the admin menu button third
    And I click the Project button third
    And I select a project third
    And I click the Epic button
    And I click the Edit Workflow button
    And I click the Add status button and add a status
    Then I get a new status




