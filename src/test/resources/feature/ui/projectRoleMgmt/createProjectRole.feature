Feature: As an admin user I can create three project roles (team lead, developer, QA)
  Background: Login in as an administrator
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