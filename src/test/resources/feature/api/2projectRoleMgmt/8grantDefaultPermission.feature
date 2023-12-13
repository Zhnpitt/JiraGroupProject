Feature: I want to grant default permissions to all

  Scenario Outline: grant default permissions to all
    #grant all roles
    When Admin grant a default permission with type <type> and permission <permission>
    Then the project role mgmt response status code should be 201
    #OR 409 ? Returned if a role with given name already exists.
    Examples:

      |type             |  permission             |
      |applicationRole  | BROWSE_PROJECTS         |
      |applicationRole  | EDIT_SPRINT_NAME_AND_GOAL_PERMISSION|
      |applicationRole  | START_STOP_SPRINTS_PERMISSION|
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

  #prerequite:
    # a permission scheme and roles are created
  #API:
    #POST /rest/api/2/permissionscheme/{schemeId}/permission
    #GET /rest/api/2/project/{projectKey}/role
    #GET /rest/api/2/permissionscheme
  #Body/Param:
    # Permission key
    # Role ID
    # Scheme ID

