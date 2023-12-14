Feature: Log in as a team leader and download the velocity chart of the last 6
  months as an image
# a created project
# a completed/ended sprint
  Background: Login in as a team leader
    Given I visit the login page
    When I enter the Team lead username and password
    And I click the login button
    Then I should view the dashboard

  Scenario Outline: Team lead and download the velocity chart of the last 6 months as an image
    When I click project in the header
    And I click View All Projects
    Then I should see BrowseProjects page
    When I click <projectName> in project list
    And I click Reports in sidebar
    And I click Switch report btn
    And I click velocity chart in Switch report dropdown
    And I change the time frame to <timeFrameLength> months and apply
    And I download the velocity chart and name it <reportName>
    Then I should have a velocity chart report <reportName>

    Examples:
      | projectName   | timeFrameLength | reportName                |
      | "projectName" | "6"             | "velocityChartReport.png" |