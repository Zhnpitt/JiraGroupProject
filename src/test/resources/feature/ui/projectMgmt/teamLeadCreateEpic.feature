Feature: As an team lead, I can create different epics
  #login as an team lead
  Background: Login in as an administrator
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | John Doe | password123 |
    And I click the login button
    Then I should view the dashboard

  Scenario: create different epics