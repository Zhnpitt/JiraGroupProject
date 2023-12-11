#2
Feature: User First time login

  Background: Login in as an administrator and navigate to user management page
    Given I visit the login page

  Scenario Outline: complete first time log in prepartion
    When I enter the <username> and <password>
    And I click the login button
    Then I should view WelcomeToJIRA page
    When I click Continue in Welcome content
    And I click Next in Welcome content
    And I click the first step in next step sequence

    Examples:
      | email                 | username     | fullname     | password      |
      | "johndoe@gmail.com"   | "John Doe"   | "John Doe"   | "password123" |
      | "adamsmith@gmail.com" | "Adam Smith" | "Adam Smith" | "password123" |
      | "dianawest@gmail.com" | "Diana West" | "Diana West" | "password123" |
      | "bobdylan@gmail.com"  | "Bob Dylan"  | "Bob Dylan"  | "password123" |