Feature: User Management
  Background: Login in as an administrator and navigate to user management page
    Given I visit the login page
    When I enter the admin username and password
      | username   | password |
      | niushang1997 | qirV3*z!rWX2SGF |
    And I click the login button
    Then I should view the dashboard
    Then I should see admin menu
    When I navigate to the user management page
    And I enter password in Administrator Access Page "qirV3*z!rWX2SGF"
    And I click confirm in Administrator Access Page
    Then I should see user management page

  Scenario Outline: Test user management
#  #Scenario: Admin creates a new user
#    When I click create user btn
#    Then I should see create user page
#    When I enter <email> <username> <fullname> <password> in create user page
#    And I click the user create btn
#    Then I should see the created user <username> in user browser table
#
#  #Scenario:Admin deactivates a user
#    Given a user <username> exists in user browser table
#    When I deactivate the user with the username <username>
#    When  I visit the login page
#    And I enter the <username> and <password>
#    And I click the login button
#    Then I should stay at login page

########################################################################################################################

 # Scenario:Admin deactivated users with status filter
    When I select "Inactive" in status filter
    And I click filter btn
    Then I should see the user <username> in the inactive status result set
 # if sequential, add this line to reset filter
     Then I click the filter reset btn

  #Scenario:Admin activated users with status filter
    When I activate the user with the username <username>

 # Scenario:Admin assigns a user to different user groups
    Given a user <username> exists in user browser table
    When I assign the user <username> to <groups>
    Then the user <username> should be assigned to <groups>

  #Scenario:Admin views users with group filter
    When I select <groups> in group filter
    And I click filter btn
    Then I should see the user <username> in the result set
#

    Examples:
    |email|username|fullname|password|groups|
    |"johndoe@gmail.com"| "John Doe"| "John Doe"|"password123"|"Group 1;Group 2"|




# currently i have to create groups in the web first
# TODO: in the set up i should create groups in background (check if groups exist)