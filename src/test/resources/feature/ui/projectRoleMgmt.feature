Feature: Feature: User Management
  Background: Login in as an administrator and navigate to Project roles page
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | zhoulikekk | Whou3344603~ |
    And I click the login button
    Then I should view the dashboard

    When I click the admin menu button
    And I click the System button
    And I enter password
      | password |
      | Whou3344603~ |
    Then I should see System page

    When I click the Project roles button
    Then I should see the Project Role Browser

    When I enter the valid Role Name and Description
    And I click the Add Project Role button
    Then I should see this new role in Project Role Browser

