Feature: I want to grant default permissions to all

  Scenario Outline: grant default permissions to all
    #grant project role
    When Admin send request with type <type> and permission <permission>
    Then the project role mgmt response status code should be 201
    #OR 409 ? Returned if a role with given name already exists.
    Examples:

      |type             |  permission             |
      |applicationRole  | BROWSE_PROJECTS         |
      |applicationRole  | VIEW_DEV_TOOLS          |
      |applicationRole  | VIEW_READONLY_WORKFLOW  |
      |applicationRole  | ASSIGNABLE_USER         |
      |applicationRole  | CREATE_ISSUES           |
      |applicationRole  | EDIT_ISSUES             |
      |applicationRole  | LINK_ISSUES             |
      |applicationRole  | MOVE_ISSUES             |
      |applicationRole  | SCHEDULE_ISSUES         |
      |applicationRole  | TRANSITION_ISSUES       |
      |applicationRole  | VIEW_VOTERS_AND_WATCHERS|
      |applicationRole  | ADD_COMMENTS            |
      |applicationRole  | DELETE_OWN_COMMENTS     |
      |applicationRole  | EDIT_OWN_COMMENTS       |
      |applicationRole  | CREATE_ATTACHMENTS      |
      |applicationRole  | DELETE_OWN_ATTACHMENTS  |
      |applicationRole  | DELETE_OWN_WORKLOGS     |
      |applicationRole  | EDIT_OWN_WORKLOGS       |
      |applicationRole  | WORK_ON_ISSUES          |



