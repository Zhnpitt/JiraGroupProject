package uiTest.stepDef.workflowMgmt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.BrowseProjectsPO;
import uiTest.pageObjects.DashBoardPO;
import uiTest.pageObjects.ProjectContentPO;

import static org.testng.Assert.assertEquals;

public class IssueStatusChangeStepDef{
    DashBoardPO dashBoardPO = new DashBoardPO();
    BrowseProjectsPO browseProjectsPO = new BrowseProjectsPO();
    ProjectContentPO projectContentPO = new ProjectContentPO();

    @When("I click project in the header")
    public void iClickProjectInTheHeader(){
        dashBoardPO.clickProjectsBtn();
    }

    @When("I click View All Projects")
    public void iClickViewAllProjects(){
        dashBoardPO.clickAllProjectBtn();
    }

    @Then("I should see BrowseProjects page")
    public void iShouldSeeBrowseProjectsPage(){
        assertEquals(URL.removeQueryString(DriverFactory.getDriver().getCurrentUrl()), URL.BrowseProjects.toString());
    }

    @When("I click {string} in project list")
    public void iClickProjectNameInProjectList(String projectName){
        browseProjectsPO.clickProjectByName(projectName);
    }

    @And("I click Issues in sidebar")
    public void iClickIssuesInSidebar(){
        projectContentPO.clickIssuesBtnInSidebar();
    }


    @And("I click issue {string} in list panel")
    public void iClickIssueInListPanel(String todoIssueName){
        projectContentPO.clickIssueInListPanel(todoIssueName);
    }

    @When("I click the status btn in issue content")
    public void iClickTheStatusBtnInIssueContent(){
        projectContentPO.clickIssueStatusBtn();
    }

    @Then("I should see issue in {string} status")
    public void iShouldSeeIssueInCurStatusStatus(String curStatus){
        assertEquals(projectContentPO.getIssueStatus(), curStatus);
    }

    @And("I click {string} status in dropdown")
    public void iClickNextStatusStatusInDropdown(String nextStatus){

        projectContentPO.clickStatusInStatusDropdown(nextStatus);
    }


}