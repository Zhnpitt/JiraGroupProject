Feature: User Deactivation
  #must have users in examples and they must be log in or first ime
  Background: Login as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard
    Then I should see admin menu
    When I navigate to the user management page
    And I enter password in Administrator Access Page
    And I click confirm in Administrator Access Page
    Then I should see user management page

  Scenario Outline: Admin deactivates a user
    Given a user <username> exists in user browser table
    When I deactivate the user with the username <username>
    When  I visit the login page
    And I enter the <username> and <password>
    And I click the login button
    Then I should stay at login page


    ####################################################################################################################
    #log in as admin
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard
    Then I should see admin menu
    When I navigate to the user management page
    And I enter password in Administrator Access Page
    And I click confirm in Administrator Access Page
    Then I should see user management page
     ###################################################################################################################

     # Scenario:Admin deactivated users with status filter
    When I select "Inactive" in status filter
    And I click filter btn
    Then I should see the user <username> in the inactive status result set
    ##add this line when we need to use this user as an active user
    #Then I activate the user with the username <username>

    ## if sequential, add this line to reset filter
    #Then I click the filter reset btn


    Examples:
      | username          | password      |
      | "DeactivatedUser" | "password123" |