package uiTest.stepDef.sprintMgmt;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.LoginPO;
import uiTest.pageObjects.TeamLeadPO;



import javax.swing.*;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class SprintMgmtStepDef {
    private final LoginPO loginPO = new LoginPO();
    private final TeamLeadPO teamLeadPO = new TeamLeadPO();
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
    public void iMoveIssuesFromBacklogToSprint() throws InterruptedException {
        WebElement issue1 = teamLeadPO.issueInBackLog;
        WebElement issue2 = teamLeadPO.anotherIssueInBackLog;
        WebElement sprint = teamLeadPO.targetSprint;
        Actions builder = new Actions(driver);
        builder.dragAndDrop(issue1, sprint).perform();
        Thread.sleep(500);
        builder.dragAndDrop(issue2, sprint).perform();
    }
    @And("I start the sprint")
    public void iStartTheSprint(){
        teamLeadPO.startSprint();
    }

    @And("I view all the issues in the current sprint")
    public void iViewAllIssuesInCurrentSprint() throws InterruptedException {
        teamLeadPO.viewIssuesInCurrentSprint();
    }
}
