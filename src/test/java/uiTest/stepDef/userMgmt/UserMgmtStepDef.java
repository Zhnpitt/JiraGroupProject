package uiTest.stepDef.userMgmt;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.AdminCreateUserPO;
import uiTest.pageObjects.AdminUserMgmtPO;
import uiTest.pageObjects.DashBoardPO;

import java.util.Arrays;
import java.util.HashSet;

import static org.testng.Assert.*;

public class UserMgmtStepDef{


    private final DashBoardPO dashboardPO = new DashBoardPO();
    private final AdminUserMgmtPO adminUserMgmtPO = new AdminUserMgmtPO();
    private final AdminCreateUserPO adminCreateUserPO = new AdminCreateUserPO();


//    @And("I click confirm in Administrator Access Page")
//    public void iClickConfirmInAdministratorAccessPage(){
//        adminUserMgmtPO.clickAuthenticateConfirmBtn();
//    }

    @When("I click create user btn")
    public void iClickCreateUserBtn(){
        adminUserMgmtPO.clickCreateUserBtn();
    }

    @Then("I should see create user page")
    public void iShouldSeeCreateUserPage(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.AdminCreateUser.toString());
    }

    @When("I enter {string} {string} {string} {string} in create user page")
    public void iEnterEmailUsernameFullnamePassword(String email, String username, String fullname, String password){
        adminCreateUserPO.enterUserCreateEmail(email);
        adminCreateUserPO.enterUserCreateUsername(username);
        adminCreateUserPO.enterUserCreateFullname(fullname);
        adminCreateUserPO.enterUserCreatePassword(password);
    }

    @And("I click the user create btn")
    public void iClickTheUserCreateBtn(){
        adminCreateUserPO.clickUserCreateBtn();
    }

    @Then("I should see the created user {string} in user browser table")
    public void iShouldSeeTheCreatedUserUsernameInUserBrowserTable(String username){
        int i = adminUserMgmtPO.searchInUserBrowserTableBody(username);
        assertTrue(i != -1);
    }

    @Given("a user {string} exists in user browser table")
    public void aUserWithEmailUsernameFullnameExists(String username){
        iShouldSeeTheCreatedUserUsernameInUserBrowserTable(username);
    }

    @When("I deactivate the user with the username {string}")
    public void iDeactivateTheUserWithTheUsernameUsername(String username){
        adminUserMgmtPO.deactivateUser(username);

    }

    @Then("I activate the user with the username {string}")
    public void iActivateTheUserWithTheUsernameUsername(String username){
        adminUserMgmtPO.activateUser(username);
    }

    @Then("I should stay at login page")
    public void iShouldStayAtLoginPage(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.Login.toString());
    }


    @Then("I should see a list of deactivated users in the result set")
    public void iShouldSeeAListOfDeactivatedUsersInTheResultSet(){
    }

    @When("I select {string} in status filter")
    public void iSelectInStatusFilter(String status){
        adminUserMgmtPO.applyStatusFilter(status);
    }

    @And("I click filter btn")
    public void iClickFilterBtn(){
        adminUserMgmtPO.clickFilterBtn();
    }

    @Then("I should see the user {string} in the inactive status result set")
    public void iShouldSeeTheUserUsernameInTheInactiveStatusResultSet(String username){
        assertNotNull(adminUserMgmtPO.findInactiveUserInUserBrowserTable(username));
    }

    @Then("I click the filter reset btn")
    public void iClickTheFilterResetBtn(){
        adminUserMgmtPO.clickFilterRestBtn();
    }


    //Assumption: groupNames will not be the current groups
    //TODO:deduplicate groupNames with current groups
    @When("I assign the user {string} to {string}")
    public void iAssignTheUserUsernameToGroup(String username, String groupNames){
        String[] groupNamesArray = adminUserMgmtPO.groupNamesProvider(groupNames);
        adminUserMgmtPO.clickUserBrowserTableMoreBtn(username);
        adminUserMgmtPO.clickEditUserGroupsBtn(username);
        for (String groupName : groupNamesArray){
            adminUserMgmtPO.enterGroupsToJoin(groupName);
            adminUserMgmtPO.clickMatchingGroup();
        }
        adminUserMgmtPO.clickManageUserGroupJoinBtn();
    }

    @Then("the user {string} should be assigned to {string}")
    public void theUserUsernameShouldBeAssignedToGroup(String username, String groupNames){
        String[] groupNamesArray = adminUserMgmtPO.groupNamesProvider(groupNames);
        HashSet<String> groupSet = new HashSet<>(Arrays.asList(adminUserMgmtPO.getUserGroups(username)));
        for (String groupName : groupNamesArray){
            assertTrue(groupSet.contains(groupName));
        }
        System.out.println("all good");
    }

    @When("I select {string} in group filter")
    public void iSelectGroupInGroupFilter(String groupNames){
        adminUserMgmtPO.applyGroupFilter(groupNames);
    }


    @Then("I should see the user {string} in the result set")
    public void iShouldSeeTheUserUsernameInTheResultSet(String username){
        assertNotNull(adminUserMgmtPO.findUserRowInBrowserTable(username));
    }


}