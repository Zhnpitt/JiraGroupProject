Feature: User management
  #prerequiste : userGroup "group-4"
  Background:
  #login
    When the admin user login
    Then the response status code should be 200

  Scenario Outline: create
    #create
    When I create a user <userName> <fullName> <email> <password>
    Then the response status code should be 201

    Examples:
      | userName  | fullName               | email                   | password      |
      | "charlie" | "Charlie of Atlassian" | "charlie@atlassian.com" | "abracadabra" |

  Scenario Outline: deactivate
    #deactivate
    When I deactivate user <userName>
    Then the response status code should be 200
    #deactivate user try to log in and fail
    When the user login with <userName> and <password>
    Then the response status code should be 401
    Examples:
      | userName  | fullName               | email                   | password      |
      | "charlie" | "Charlie of Atlassian" | "charlie@atlassian.com" | "abracadabra" |

   #find user by status
  Scenario Outline: find user by status
    When I find user <userName> by inactive status
    Then the response status code should be 200
    And I should see <userName> in status result set

    Examples:
      | userName  |
      | "charlie" |

      #assigning user to different group and apply filter
  Scenario Outline: assigning user to different group and apply filter
    When I add user <userName> to group <userGroup>
    Then the response status code should be 201
    When I get users from group <userGroup>
    Then I should see <userName> in group result set
    Examples:
      | userName     | userGroup |
      | "Adam Smith" | "group-4" |