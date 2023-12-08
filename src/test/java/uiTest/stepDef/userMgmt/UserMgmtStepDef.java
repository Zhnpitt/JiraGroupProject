package uiTest.stepDef.userMgmt;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.CreateUserPO;
import uiTest.pageObjects.DashBoardPO;
import uiTest.pageObjects.UserMgmtPO;

import java.util.Arrays;
import java.util.HashSet;

import static org.testng.Assert.*;

public class UserMgmtStepDef {


    private final DashBoardPO dashboardPO = new DashBoardPO();
    private final UserMgmtPO userMgmtPO = new UserMgmtPO();
    private final CreateUserPO createUserPO = new CreateUserPO();


    @Then("I should see user management page")
    public void iShouldSeeUserManagementPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.UserMgmt.toString());
    }

    @And("I enter password in Administrator Access Page {string}")
    public void iEnterPasswordInAdministratorAccessPage(String password) {
        userMgmtPO.enterAuthenticatePassword(password);

    }

    @And("I click confirm in Administrator Access Page")
    public void iClickConfirmInAdministratorAccessPage() {
        userMgmtPO.clickAuthenticateConfirmBtn();
    }

    @When("I click create user btn")
    public void iClickCreateUserBtn() {
        userMgmtPO.clickCreateUserBtn();
    }

    @Then("I should see create user page")
    public void iShouldSeeCreateUserPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.CreateUser.toString());
    }

    @When("I enter {string} {string} {string} {string} in create user page")
    public void iEnterEmailUsernameFullnamePassword(String email, String username, String fullname, String password) {
        createUserPO.enterUserCreateEmail(email);
        createUserPO.enterUserCreateUsername(username);
        createUserPO.enterUserCreateFullname(fullname);
        createUserPO.enterUserCreatePassword(password);
    }

    @And("I click the user create btn")
    public void iClickTheUserCreateBtn() {
        createUserPO.clickUserCreateBtn();
    }

    @Then("I should see the created user {string} in user browser table")
    public void iShouldSeeTheCreatedUserUsernameInUserBrowserTable(String username) {
        int i = userMgmtPO.searchInUserBrowserTableBody(username);
        assertTrue(i != -1);
    }

    @Given("a user {string} exists in user browser table")
    public void aUserWithEmailUsernameFullnameExists(String username) {
        iShouldSeeTheCreatedUserUsernameInUserBrowserTable(username);
    }

    @When("I deactivate the user with the username {string}")
    public void iDeactivateTheUserWithTheUsernameUsername(String username) {
        userMgmtPO.deactivateUser(username);

    }

    @Then("I activate the user with the username {string}")
    public void iActivateTheUserWithTheUsernameUsername(String username) {
        userMgmtPO.activateUser(username);
    }

    @Then("I should stay at login page")
    public void iShouldStayAtLoginPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.Login.toString());
    }


    @Then("I should see a list of deactivated users in the result set")
    public void iShouldSeeAListOfDeactivatedUsersInTheResultSet() {
    }

    @When("I select {string} in status filter")
    public void iSelectInStatusFilter(String status) {
        userMgmtPO.applyStatusFilter(status);
    }

    @And("I click filter btn")
    public void iClickFilterBtn() {
        userMgmtPO.clickFilterBtn();
    }

    @Then("I should see the user {string} in the inactive status result set")
    public void iShouldSeeTheUserUsernameInTheInactiveStatusResultSet(String username) {
        assertNotNull(userMgmtPO.findInactiveUserInUserBrowserTable(username));
    }

    @Then("I click the filter reset btn")
    public void iClickTheFilterResetBtn() {
        userMgmtPO.clickFilterRestBtn();
    }


    //Assumption: groupNames will not be the current groups
    //TODO:deduplicate groupNames with current groups
    @When("I assign the user {string} to {string}")
    public void iAssignTheUserUsernameToGroup(String username, String groupNames) {
        String[] groupNamesArray = userMgmtPO.groupNamesProvider(groupNames);
        userMgmtPO.clickUserBrowserTableMoreBtn(username);
        userMgmtPO.clickEditUserGroupsBtn();
        for (String groupName : groupNamesArray) {
            userMgmtPO.enterGroupsToJoin(groupName);
            userMgmtPO.clickMatchingGroup();
        }
        userMgmtPO.clickManageUserGroupJoinBtn();
    }

    @Then("the user {string} should be assigned to {string}")
    public void theUserUsernameShouldBeAssignedToGroup(String username, String groupNames) {
        String[] groupNamesArray = userMgmtPO.groupNamesProvider(groupNames);
        HashSet<String> groupSet = new HashSet<>(Arrays.asList(userMgmtPO.getUserGroups(username)));
        for (String groupName : groupNamesArray) {
            assertTrue(groupSet.contains(groupName));
        }
        System.out.println("all good");
    }

    @When("I select {string} in group filter")
    public void iSelectGroupInGroupFilter(String groupNames) {
        userMgmtPO.applyGroupFilter(groupNames);
    }


    @Then("I should see the user {string} in the result set")
    public void iShouldSeeTheUserUsernameInTheResultSet(String username) {
        assertNotNull(userMgmtPO.findUserRowInBrowserTable(username));
    }


}
