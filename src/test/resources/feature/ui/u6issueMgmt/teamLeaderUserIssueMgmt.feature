Feature: As a team leader user, I can manage issues
  # login in as team leader
  # different epics created:  Frontend dev, Backend dev, UI/UX design, Testing

  Scenario: Login in as a team leader user
    Given I visit the Login page
    When I enter the username "John Doe"
    And I enter the password "password123"
    And I click the login button
    Then I should view the dashBoard

  Scenario: As a team leader, I can create issues that belong to different epics and priorities in the backlog.
    When I click projects button
    And I click view all projects option
    And I choose scrum project
    And I click backlog button
    And I click Epics button
    And I choose backend Epic
    And I click Backlog in header
    And I click create issue button
    And I click open in dialog
    And I set up issue summary "story1 by John"
    And I scroll down and click priority dropdown
    And I set up as high priority
    And I click create button
    Then I should view new created story "story1 by John"

    When I click create button on blue bar
    And I click issue type dropdown
    And I choose task type
    And I set up issue summary "task2 by John"
    And I click create button
    And I click issue without epics
    Then I should view new created task2 "task2 by John"

    When I click create button on blue bar
    And I set up issue summary "task1 by John"
    And I click create button
    And I click issue without epics
    Then I should view new created task1 "task1 by John"

  Scenario:As a team lead user, I can specify if the current issue is blocked by or is blocking other issues.
    When I click new created issue task
    And I click three dots button
    And I click link button
    And I click this issue area and choose is blocked by option
    And I send "story" to issue area
    And I choose the first issue
    And I click linkIssue button
    Then I should view "is blocked by" area

  Scenario:As a team lead user, I can assign issues to different users.
    When I click three dots button
    And I click assign option
    And I send "Adam" assignee area
    And I choose Adam Smith
    And I send "message for Adam from John" in comment area
    And I click assign button
    Then I scroll to people and view assignee is "Adam Smith"