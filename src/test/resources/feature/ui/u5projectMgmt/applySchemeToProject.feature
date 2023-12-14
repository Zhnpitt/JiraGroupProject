Feature: As an admin user I can apply an existing permission scheme on our project
  #login as an admin user
  Background: Login in as an administrator
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard

  Scenario:Admin applies an existing permission scheme on project
    When I click the admin menu button again
    And I click the Project button again
    And I select a project
    And I click the Permissions button
    And I click the Actions button and select use a different scheme
    And I enter password in Administrator Access Page
    And I click confirm in Administrator Access Page
    And I select a scheme and click associate button