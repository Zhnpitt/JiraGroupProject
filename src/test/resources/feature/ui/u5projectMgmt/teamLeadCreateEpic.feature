Feature: As an team lead, I can create different epics
  #login as an team lead
  Background: Login in as an team lead
    Given I visit the login page
    When I enter the username John Doe and password password123
    And I click the login button
    Then I should view the dashboard

  Scenario: I can create different epics
    When I click the project button in team lead dashboard
    #And I choose current project
    And I click View All Projects
    Then I should see BrowseProjects page
    When I click projectName in project list
    When I click Backlog in sidebar
    And I create an issue
    And I select a Issue Type as Epic
    And I enter Epic name as Frontend dev2 and Frontend dev summary
    And I submit an issue

    And I create an issue
    And I select a Issue Type as Epic
    And I enter Epic name as Backend dev and Backend dev summary
    And I submit an issue

    And I create an issue
    And I select a Issue Type as Epic
    And I enter Epic name as UI/UX design and UI/UX design summary
    And I submit an issue