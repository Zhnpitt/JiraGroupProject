package uiTest.stepDef.issueMgmt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.IssueMgmtLeaderPO;

import static org.testng.Assert.assertEquals;

public class IssueMgmtLeaderStepDef{
    IssueMgmtLeaderPO issueMgmtLeaderPO = new IssueMgmtLeaderPO();

    @Then("I should view the dashBoard")
    public void iShouldViewTheDashBoard(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.DashBoard.toString());
    }


    @When("I click projects button")
    public void iClickProjectsButton(){
        issueMgmtLeaderPO.clickProjectsBtn();
    }

    @And("I click view all projects option")
    public void iClickViewAllProjectsOption(){
        issueMgmtLeaderPO.clickViewAllProjectsBtn();
    }

    @And("I choose scrum project")
    public void iClickDemoProject(){
        issueMgmtLeaderPO.chooseScrumProject();
    }

    @And("I click backlog button")
    public void iClickBacklogButton(){
        issueMgmtLeaderPO.clickBacklogBtn();
    }

    @And("I click Epics button")
    public void iClickEpicsButton(){
        issueMgmtLeaderPO.clickEpicsBtn();
    }

    @And("I choose backend Epic")
    public void iChooseBackendEpic(){
        issueMgmtLeaderPO.clickBackendEpic();
    }

    @And("I click create issue button")
    public void iClickCreateIssueButton(){
        issueMgmtLeaderPO.clickCreateIssueBtn();
    }

    @And("I click open in dialog")
    public void iClickOpenInDialog(){
        issueMgmtLeaderPO.clickOpenInDialogBtn();
    }

    @And("I set up issue summary {string}")
    public void iSetUpIssueSummary(String summaryContent){
        issueMgmtLeaderPO.sendInSummaryArea(summaryContent);
    }

    @And("I scroll down and click priority dropdown")
    public void iScrollDownAndClickPriorityDropdown(){
        issueMgmtLeaderPO.scrollToPriorityAndClick();
    }

    @And("I set up as high priority")
    public void iSetUpAsHighPriority(){
        issueMgmtLeaderPO.clickHighPriority();
    }

    @And("I click create button")
    public void iClickCreateButton(){
        issueMgmtLeaderPO.clickCreateBtn();
        ;
    }

    @Then("I should view new created story {string}")
    public void iShouldViewNewCreatedStory(String story){
        assertEquals(issueMgmtLeaderPO.newCreatedIssueStory.getText(), story);
    }

    @And("I click issue without epics")
    public void iClickIssueWithoutEpics(){
        issueMgmtLeaderPO.clickIssueWithoutEpics();
    }

    @And("I click issue type dropdown")
    public void iClickIssueTypeDropdown(){
        issueMgmtLeaderPO.clickIssueTypeDropdown();
    }

    @And("I choose task type")
    public void iChooseTaskType(){
        issueMgmtLeaderPO.chooseTaskType();
    }

    @Then("I should view new created task2 {string}")
    public void iShouldViewNewCreatedTask2(String task){
        assertEquals(issueMgmtLeaderPO.newCreatedIssueTask2.getText(), task);
    }

    @Then("I should view new created task1 {string}")
    public void iShouldViewNewCreatedTask1(String task){
        assertEquals(issueMgmtLeaderPO.newCreatedIssueTask1.getText(), task);
    }

    @When("I click new created issue task")
    public void iClickNewCreatedIssue(){
        issueMgmtLeaderPO.clickNewCreatedIssueTask();
    }

    @And("I click three dots button")
    public void iClickThreeDotsButton(){
        issueMgmtLeaderPO.clickThreeDotsBtn();
    }

    @And("I click link button")
    public void iClickLinkButton(){
        issueMgmtLeaderPO.clickLinkBtn();
    }

    @And("I click linkIssue button")
    public void iClickLinkIssueButton(){
        issueMgmtLeaderPO.clickLinkIssueBtn();
    }

    @And("I click this issue area and choose is blocked by option")
    public void iClickThisIssueArea(){
        issueMgmtLeaderPO.thisIssueLinkType();
    }

    @And("I send {string} to issue area")
    public void iSendToIssueArea(String story){
        issueMgmtLeaderPO.setIssueArea(story);
    }

    @And("I choose the first issue")
    public void iChooseTheFirstIssue(){
        issueMgmtLeaderPO.clickFirstIssue();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Then("I should view {string} area")
    public void iShouldViewArea(String isBlockBy){
        assertEquals(issueMgmtLeaderPO.isBlockedByArea.getText(), isBlockBy);
    }

    @And("I click assign option")
    public void iClickAssignOption(){
        issueMgmtLeaderPO.clickAssignBtn();
    }

    @And("I send {string} assignee area")
    public void iSendAssigneeArea(String name){
        issueMgmtLeaderPO.sendToAssigneeArea(name);
    }

    @And("I choose Adam Smith")
    public void iChooseAdamSmith(){
        issueMgmtLeaderPO.chooseAdamSmith();
    }

    @And("I send {string} in comment area")
    public void iSendInCommentArea(String message){
        issueMgmtLeaderPO.leaveMessageInCommentArea(message);
    }

    @And("I click assign button")
    public void iClickAssignButton(){
        issueMgmtLeaderPO.clickAssignConfirmBtn();
    }

    @Then("I scroll to people and view assignee is {string}")
    public void iScrollToPeopleAndViewAssigneeIs(String adamSmith){
//        issueMgmtLeaderPO.scrollToAssigneeCheckAreaAndCheck();
        assertEquals(issueMgmtLeaderPO.assigneeAdamSmith.getText(), adamSmith);
    }

//    @When("I click all issues Area")
//    public void iClickAllIssuesArea() {
//        issueMgmtLeaderPO.clickAllIssuesBtn();
//    }

    @And("I scroll down to epic link Area and click")
    public void iScrollDownToEpicLinkAreaAndClick(){
        issueMgmtLeaderPO.scrolltoEpicLinkAreaAndClick();
    }

    @And("I click frontend epic suggestion")
    public void iClickFrontendEpicSuggestion(){
        issueMgmtLeaderPO.chooseFrontendEpicSuggestion();
    }

    @When("I click create button on blue bar")
    public void iClickCreateButtonOnBlueBar(){
        issueMgmtLeaderPO.clickCreateBtnOnBlue();
    }

    @And("I click backlog on the header")
    public void iClickBacklogOnTheHeader(){
        DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"subnav-title\"]/span")).click();
    }

    @And("I choose create issue Button")
    public void iChooseBackendCreateIssueButton(){
        issueMgmtLeaderPO.clickCreateIssueBtn();
    }
}