Feature: Workflow Creation

  Background: Login in as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
      | username     | password        |
      | niushang1997 | qirV3*z!rWX2SGF |
    And I click the login button
    Then I should view the dashboard
    Then I should see admin menu
    When I navigate to the issues page
    And I enter password in Administrator Access Page "qirV3*z!rWX2SGF"
    And I click confirm in Administrator Access Page
    Then I should see user management page