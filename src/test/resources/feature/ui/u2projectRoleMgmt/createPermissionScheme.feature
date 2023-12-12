Feature: As an admin user I can create the permission scheme
  #login as an admin user
  Background: Login in as an administrator
    Given I visit the login page
    When I enter the admin username and password
    And I click the login button
    Then I should view the dashboard

  Scenario: test
    #create a permission scheme
    When I click the admin menu button
    And I click the issue button
    And I enter password in Administrator Access Page
    And I click confirm in Administrator Access Page
    And I click the Permission schemes button
    And I click the Add permission scheme button
    And I name the scheme PS-1
    And I click the permission scheme submit button
    And I choose this scheme to edit

    #grant team lead Manage Sprints
    And I click permission edit button
    And I select a permission Manage Sprints
    And I select Granted to Project Role
    And I grant a team lead

    #grant team lead Assign Issues
    And I click permission edit button
    And I select a permission Assign Issues
    And I select Granted to Project Role
    And I grant a team lead

    #grant developer Resolve Issues
    And I click permission edit button
    And I select a permission Resolve Issues
    And I select Granted to Project Role
    And I grant a developer

    #grant QA Close Issues
    And I click permission edit button
    And I select a permission Close Issues
    And I select Granted to Project Role
    And I grant a QA


    #Browse Projects
    And I click permission edit button
    And I select a permission Browse Projects
    And I select Granted to Application access
    And I grant Any logged in user

     #Browse Projects
    And I click permission edit button
    And I select a permission Browse Projects
    And I select Granted to Application access
    And I grant Any logged in user

     #View Development Tools
    And I click permission edit button
    And I select a permission View Development Tools
    And I select Granted to Application access
    And I grant Any logged in user

    #View Read-Only Workflow
    And I click permission edit button
    And I select a permission View Read-Only Workflow
    And I select Granted to Application access
    And I grant Any logged in user


############################################################################################
  #other basic setup
  #Create Issues
    And I click permission edit button
    And I select a permission Create Issues
    And I select Granted to Application access
    And I grant Any logged in user
  #Edit Issues
    And I click permission edit button
    And I select a permission Edit Issues
    And I select Granted to Application access
    And I grant Any logged in user
  #Link Issues
    And I click permission edit button
    And I select a permission Link Issues
    And I select Granted to Application access
    And I grant Any logged in user
  #Move Issues
    And I click permission edit button
    And I select a permission Move Issues
    And I select Granted to Application access
    And I grant Any logged in user
  #Schedule Issues
    And I click permission edit button
    And I select a permission Schedule Issues
    And I select Granted to Application access
    And I grant Any logged in user
  #Transition Issues
    And I click permission edit button
    And I select a permission Transition Issues
    And I select Granted to Application access
    And I grant Any logged in user
  #View Voters and Watchers
    And I click permission edit button
    And I select a permission View Voters and Watchers
    And I select Granted to Application access
    And I grant Any logged in user
  #Add Comments
    And I click permission edit button
    And I select a permission Add Comments
    And I select Granted to Application access
    And I grant Any logged in user
  #Delete Own Comments
    And I click permission edit button
    And I select a permission Delete Own Comments
    And I select Granted to Application access
    And I grant Any logged in user
  #Edit Own Comments
    And I click permission edit button
    And I select a permission Edit Own Comments
    And I select Granted to Application access
    And I grant Any logged in user
  #Create Attachments
    And I click permission edit button
    And I select a permission Create Attachments
    And I select Granted to Application access
    And I grant Any logged in user
  #Delete Own Attachments
    And I click permission edit button
    And I select a permission Delete Own Attachments
    And I select Granted to Application access
    And I grant Any logged in user
  #Delete Own Worklogs
    And I click permission edit button
    And I select a permission Delete Own Worklogs
    And I select Granted to Application access
    And I grant Any logged in user
  #Edit Own Worklogs
    And I click permission edit button
    And I select a permission Edit Own Worklogs
    And I select Granted to Application access
    And I grant Any logged in user
  #Work On Issues
    And I click permission edit button
    And I select a permission Work On Issues
    And I select Granted to Application access
    And I grant Any logged in user
  #Assignable User
    And I click permission edit button
    And I select a permission Assignable User
    And I select Granted to Application access
    And I grant Any logged in user

      #Assignable User
    And I click permission edit button
    And I select a permission Delete Issues
    And I select Granted to Group
    And I grant jira-administrators