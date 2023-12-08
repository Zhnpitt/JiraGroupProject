Feature: After creation, I can add existing user to a project role
  #login as an admin user
  Background: Login in as an administrator
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | zhoulikekk | Whou3344603~ |
    And I click the login button
    Then I should view the dashboard

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