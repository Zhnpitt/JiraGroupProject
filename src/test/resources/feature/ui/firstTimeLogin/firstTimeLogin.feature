Feature:

  Scenario: Login in first time
    Given I visit the login page
    When I enter the developer username and password
    And I click the login button
    Then I should view the dashboard