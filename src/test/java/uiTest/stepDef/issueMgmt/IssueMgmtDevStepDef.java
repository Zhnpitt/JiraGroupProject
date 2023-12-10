package uiTest.stepDef.issueMgmt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.pageObjects.IssueMgmtDevPO;

import static org.testng.Assert.assertEquals;

public class IssueMgmtDevStepDef {
    IssueMgmtDevPO issueMgmtDevPO = new IssueMgmtDevPO();

    @When("I click assigned to me maximize button")
    public void iClickAssignedToMeMaximizeButton() {
        issueMgmtDevPO.clickAssignToMe();
    }

    @Then("I should view all my issues {string}")
    public void iShouldViewAllMyIssues(String summary) {
        assertEquals(issueMgmtDevPO.assignedTask.getText(), summary);
    }

    @When("I choose one issue")
    public void iChooseOneIssue() {
        issueMgmtDevPO.clickAssignedTask();
    }

    @And("I click add comment")
    public void iClickAddComment() {
        issueMgmtDevPO.clickAddComments();
    }

    @And("I leave a message {string}")
    public void iLeaveAMessage(String message) {
        issueMgmtDevPO.leaveMessageInCommentArea(message);
    }

    @And("I click add button")
    public void iClickAddButton() {
        issueMgmtDevPO.clickAddBtn();
    }

    @Then("I view newly created comments {string} by Adam")
    public void iScrollDownToActivityAreaAndClickCommentsOption(String comment) {
        assertEquals(issueMgmtDevPO.addedComment.getText(), comment);
    }

    @And("I choose first comment and click edit button")
    public void iChooseFirstCommentAndClickEditButton() {
        issueMgmtDevPO.clickFirstEditBtn();
    }

    @And("I click comment area and add {string}")
    public void iClickCommentAreaAndAdd(String newMsg) {
        issueMgmtDevPO.editMessageInCommentArea(newMsg);

    }

    @And("I click save button")
    public void iClickSaveButton() {
        issueMgmtDevPO.clickSaveBtn();
    }

    @Then("I check {string} sign")
    public void iCheckSign(String edited) {
        assertEquals(issueMgmtDevPO.editedSign.getText(), edited);
    }
}
