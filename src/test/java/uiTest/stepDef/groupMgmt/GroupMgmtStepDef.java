package uiTest.stepDef.groupMgmt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.DashBoardPO;
import uiTest.pageObjects.GroupMgmtPO;
import uiTest.pageObjects.WebSudoPO;

import static org.testng.Assert.assertEquals;

public class GroupMgmtStepDef{
    private GroupMgmtPO groupMgmtPO = new GroupMgmtPO();
    private WebSudoPO webSudoPO = new WebSudoPO();
    private DashBoardPO dashBoardPO = new DashBoardPO();

    @Then("I should view the dashBoard")
    public void iShouldViewTheDashBoard(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.DashBoard.toString());
    }

    @When("I click Setting button")
    public void iClickSettingButton(){
        dashBoardPO.clickSettingBtn();
    }

    @And("I click user management option")
    public void iClickUserManagementOption(){
        dashBoardPO.clickUserMgmtBtn();
    }

    //websudo URL= http://localhost:8080/secure/admin/user/UserBrowser.jspa
    @Then("I should view webSudo authentication page")
    public void iShouldViewWebSudoAuthenticationPage(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.AdminUserMgmt.toString());
    }

    @When("I enter WebSudo password {string}")
    public void iEnterWebSudoPassword(String password){
        webSudoPO.enterWebSudoPassword(password);
    }

    @And("And I click the confirm button")
    public void andIClickTheConfirmButton(){
        webSudoPO.clickConfirmBtn();
    }

    //userMgmt URL= http://localhost:8080/secure/admin/user/UserBrowser.jspa
    @Then("I should view user management page")
    public void iShouldViewUserManagementPage(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.AdminUserMgmt.toString());
    }

    @When("I click groups button")
    public void iClickGroupsButton(){
        groupMgmtPO.clickGroupsBtn();
    }

    @And("I input new {string}")
    public void iInputNewGroupName(String groupName){
        groupMgmtPO.setAddGroupNameArea(groupName);
    }

    @And("I click add group button")
    public void iClickAddGroupButton(){
        groupMgmtPO.clickAddGroupBtn();
    }

    @Then("I can view the new created groups")
    public void iCanViewTheNewCreatedGroups(){
        assertEquals(groupMgmtPO.group1.getText(), "Jira-group-1");
    }

    @When("I click bulk Edit Group Members button")
    public void iClickBulkEditGroupMembersButton(){
        groupMgmtPO.clickBulkEditGroupMemberBtn();
    }

    @And("I input {string} in group selected area")
    public void iInputInGroupSelectedArea(String groupName){
        groupMgmtPO.setTextAreaGroup(groupName);
    }

    @And("I choose target group")
    public void iChooseTargetGroup(){
        groupMgmtPO.setChooseGroup();
    }

    @And("I input another {string} in group selected area")
    public void iInputAnotherInGroupSelectedArea(String groupName){
        groupMgmtPO.setTextAreaGroup(groupName);
    }

    @And("I choose another target group")
    public void iChooseAnotherTargetGroup(){
        groupMgmtPO.setChooseGroup();
    }

    @And("I input existing user names {string}")
    public void iInputExistingUserNames(String usernames){
        groupMgmtPO.setTestAreaUserNames(usernames);
    }

    @And("I click add Selected Users button")
    public void iClickAddSelectedUsersButton(){
        groupMgmtPO.clickAddSelectedUsersBtn();
    }

    @Then("I can view new users in group member table")
    public void iCanViewNewUsersInGroupMemberTable(){
        assertEquals(groupMgmtPO.adamUserPresence.getText(), "Adam Smith");
    }


}