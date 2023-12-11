Feature: As a developer user, I can manage issues
  # login in as developer
  # three issues has been created
  # comment has been left by John (team leader)

  Scenario: Login in as a developer user and get WebSudo
    Given I visit the Login page
    When I enter the username "Adam Smith"
    And I enter the password "password123"
    And I click the login button
    Then I should view the dashBoard

  Scenario: As a developer user, I can view all the issues assigned to me
    When I click assigned to me maximize button
    Then I should view all my issues "task1 by John"

  Scenario: As a developer user, I can add, edit and reply to the comments of an issue
    When I choose one issue
    And I click add comment
    And I leave a message "message from Adam"
    And I click add button
    Then I view newly created comments "message from Adam" by Adam
    And I choose first comment and click edit button
    And I click comment area and add " new edit"
    And I click save button
    Then I check "edited" sign