Feature: Project management
  Background: Login in as an administrator
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | zhoulikekk | Whou3344603~ |
    And I click the login button
    Then I should view the dashboard

  Scenario:I create a Scrum project
    When I click the admin menu button
    And I click the Project button
    And I setup the project with "projectName1" and "PKey1"

  Scenario:I apply an existing permission scheme on a project
    When I click the admin menu button again
    And I click the Project button again
    And I select a project
    And I click the Permissions button
    And I click the Actions button and select use a different scheme
    And I enter password in Administrator Access Page "Whou3344603~"
    And I click confirm in Administrator Access Page
    And I select a scheme and click associate button



  Scenario: I can create different epics
    When I click the create button
    #And I select a Issue Type as Epic
    And I enter Frontend dev and Frontend dev summary to create an Epic

    And I click the create button
    #And I select a Issue Type as Epic
    And I enter Backend dev and Backend dev summary to create an Epic

    And I click the create button
    #And I select a Issue Type as Epic
    And I enter UI/UX design and UI/UX design summary to create an Epic




