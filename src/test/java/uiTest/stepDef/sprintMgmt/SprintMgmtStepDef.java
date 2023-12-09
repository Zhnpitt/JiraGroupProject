package uiTest.stepDef.sprintMgmt;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.LoginPO;
import uiTest.pageObjects.ProjectContentPO;
import uiTest.pageObjects.TeamLeadPO;

public class SprintMgmtStepDef{
    private final LoginPO loginPO = new LoginPO();
    private final TeamLeadPO teamLeadPO = new TeamLeadPO();
    ProjectContentPO projectContentPO = new ProjectContentPO();

    WebDriver driver = DriverFactory.getDriver();

    //  Scenario: create and start a new sprint

    @And("I click the create Sprint Button")
    public void iClickTheCreateSprintButton(){
        teamLeadPO.clickCreateSprintButton();
    }

    @And("I name the sprint {}")
    public void iNameTheSprint(String name){
        teamLeadPO.setSprintName(name);
    }

    @And("I create this sprint")
    public void iCreateThisSprint(){
        teamLeadPO.subMitSprint();
    }

    @And("I Move Issues From Backlog To Sprint")
    public void iMoveIssuesFromBacklogToSprint() throws InterruptedException{
        WebElement issue1 = teamLeadPO.issueAInBackLog;
        WebElement issue2 = teamLeadPO.IssueBInBackLog;
        WebElement sprint = teamLeadPO.targetSprint;
        Actions builder = new Actions(driver);
        builder.dragAndDrop(issue1, sprint).perform();
        Thread.sleep(500);
        builder.dragAndDrop(issue2, sprint).perform();

//        WebElement sprint = teamLeadPO.targetSprint;
//        Actions builder = new Actions(driver);
//        for (WebElement issue : teamLeadPO.issuesInBackLog){
//            builder.dragAndDrop(issue, sprint).perform();
//            Thread.sleep(500);
//        }
    }

    @And("I start the sprint")
    public void iStartTheSprint(){
        teamLeadPO.startSprint();
    }

    @And("I view all the issues in the current sprint")
    public void iViewAllIssuesInCurrentSprint() throws InterruptedException{
        teamLeadPO.viewIssuesInCurrentSprint();
    }


    @And("I click more btn in sprint {string}")
    public void iClickMoreBtnInSprintActiveSprintName(String activeSprintName){
        projectContentPO.clickSprintMoreBtn(activeSprintName);
    }

    @And("I click Active sprints in sidebar")
    public void iClickActiveSprintsInSidebar(){
        projectContentPO.clickActiveSprintsInSideBar();
    }

    @And("I click Complete sprint btn")
    public void iClickCompleteSprintBtn(){
        projectContentPO.clickCompleteSprintBtn();
    }

    @And("I click Complete btn in Complete sprint dialog")
    public void iClickCompleteInCompleteSprintDialog(){
        projectContentPO.clickCompleteBtnInCompleteSprintDialog();
    }

    @And("I click Reports in sidebar")
    public void iClickReportsInSidebar(){
        projectContentPO.clickReportsInSidebar();
    }

    @And("I click Switch report btn")
    public void iClickSwitchReportBtn(){
        projectContentPO.clickSwitchReportBtn();
    }

    @And("I click velocity chart in Switch report dropdown")
    public void iClickVelocityChartInSwitchReportDropdown(){
        projectContentPO.clickVelocityChartInSwitchReportDropdown();
    }


    @And("I change the time frame to {string} months and apply")
    public void iChangeTheTimeFrameToTimeFrameLengthMonthsAndApply(String lengthInMonth){
        projectContentPO.changeTimeFrameInVelocityChart(lengthInMonth);
        projectContentPO.clickTimeframeApplyBtn();
    }

    @And("I download the velocity chart")
    public void iDownloadTheVelocityChart(){
        projectContentPO.downloadVelocityChart();
    }
}