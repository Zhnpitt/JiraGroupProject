Feature: I want to test to do item CRUD functionality with create different epics

  Scenario Outline: team lead create different epics
    When team lead send a request with issue type <issue type> and summary <summary> and <project key>
    Then the project role mgmt response status code should be 201

    Examples:
      | issue type   | summary       |project key|
      | Epic         | Frontend dev1 | PROJ  |
      | Epic         | Backend dev   | PROJ  |
      | Epic         | UI/UX design  | PROJ  |
      | Epic         | Testing       | PROJ  |

  #prerequite:
    #screen setup
  #API:
    #POST /rest/api/2/issue
  #Body:
    # {
    #  "fields": {
    #    "project": {
    #      "key":
    #    },
    #    "summary": ,
    #    "description": ,
    #    "issuetype": {
    #      "name":
    #    }
    #    "customfield_10104":
    #  }
    #}