package uiTest.stepDef.sprintMgmt.userMgmt;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.DashBoardPO;
import uiTest.pageObjects.LoginPO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class UserMgmtStepDef {

    private final LoginPO loginPO = new LoginPO();
    private final DashBoardPO dashboardPO = new DashBoardPO();

    @Given("I visit the login page")
    public void iVisitTheLoginPage() {
        DriverFactory.getDriver().manage().deleteAllCookies();
        DriverFactory.getDriver().navigate().to(URL.Login.toString());
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.Login.toString());

    }

    @When("I enter the admin username and password")
    public void iEnterTheAdminUsernameAndPassword(DataTable usercredentials) {
        List<Map<String, String>> data = usercredentials.asMaps(String.class, String.class);
        loginPO.enterUsername(data.get(0).get("username"));
        loginPO.enterPassword(data.get(0).get("password"));
    }

    @When("I enter the {string} and {string}")
    public void iEnterTheUsernameAndPassword(String username, String password) {
        loginPO.enterUsername(username);
        loginPO.enterPassword(password);
    }


    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPO.clickLoginButton();
    }

    @Then("I should view the dashboard")
    public void iShouldViewTheDashBoardPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.DashBoard.toString());
    }

    @Then("I should see admin menu")
    public void iShouldSeeAdminMenu() {
        assertTrue(dashboardPO.checkIfAdminUser());
    }

    @When("I navigate to the user management page")
    public void iNavigateToTheUserManagementPage() {
        dashboardPO.clickAdminMenu();
        dashboardPO.clickUserMgmtLink();
    }

    @Then("I should see user management page")
    public void iShouldSeeUserManagementPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.UserMgmt.toString());
    }

    @And("I enter password in Administrator Access Page {string}")
    public void iEnterPasswordInAdministratorAccessPage(String password) {
        dashboardPO.enterAuthenticatePassword(password);

    }

    @And("I click confirm in Administrator Access Page")
    public void iClickConfirmInAdministratorAccessPage() {
        dashboardPO.clickAuthenticateConfirmBtn();
    }



    @When("I click create user btn")
    public void iClickCreateUserBtn() {
        dashboardPO.clickCreateUserBtn();
    }

    @Then("I should see create user page")
    public void iShouldSeeCreateUserPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.CreateUser.toString());
    }

    @When("I enter {string} {string} {string} {string} in create user page")
    public void iEnterEmailUsernameFullnamePassword(String email, String username, String fullname, String password) {
        dashboardPO.enterUserCreateEmail(email);
        dashboardPO.enterUserCreateUsername(username);
        dashboardPO.enterUserCreateFullname(fullname);
        dashboardPO.enterUserCreatePassword(password);
    }

    @And("I click the user create btn")
    public void iClickTheUserCreateBtn() {
        dashboardPO.clickUserCreateBtn();
    }

    @Then("I should see the created user {string} in user browser table")
    public void iShouldSeeTheCreatedUserUsernameInUserBrowserTable(String username) {
        int i = dashboardPO.searchInUserBrowserTableBody(username);
        assertTrue(i != -1);
    }

    @Given("a user {string} exists in user browser table")
    public void aUserWithEmailUsernameFullnameExists(String username) {
        iShouldSeeTheCreatedUserUsernameInUserBrowserTable(username);
    }

    @When("I deactivate the user with the username {string}")
    public void iDeactivateTheUserWithTheUsernameUsername(String username) {
        dashboardPO.deactivateUser(username);

    }

    @When("I activate the user with the username {string}")
    public void iActivateTheUserWithTheUsernameUsername(String username) {
        dashboardPO.activateUser(username);
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
        dashboardPO.applyStatusFilter(status);
    }

    @And("I click filter btn")
    public void iClickFilterBtn() {
        dashboardPO.clickFilterBtn();
    }

    @Then("I should see the user {string} in the inactive status result set")
    public void iShouldSeeTheUserUsernameInTheInactiveStatusResultSet(String username) {
        assertNotNull(dashboardPO.findInactiveUserInUserBrowserTable(username));
    }

    @Then("I click the filter reset btn")
    public void iClickTheFilterResetBtn() {
        dashboardPO.clickFilterRestBtn();
    }


    //Assumption: groupNames will not be the current groups
    //TODO:deduplicate groupNames with current groups
    @When("I assign the user {string} to {string}")
    public void iAssignTheUserUsernameToGroup(String username, String groupNames) {
        String[] groupNamesArray = dashboardPO.groupNamesProvider(groupNames);
        dashboardPO.clickUserBrowserTableMoreBtn(username);
        dashboardPO.clickEditUserGroupsBtn();
        for (String groupName : groupNamesArray) {
            dashboardPO.enterGroupsToJoin(groupName);
            dashboardPO.clickMatchingGroup();
        }
        dashboardPO.clickManageUserGroupJoinBtn();
    }

    @Then("the user {string} should be assigned to {string}")
    public void theUserUsernameShouldBeAssignedToGroup(String username, String groupNames) {
        String[] groupNamesArray = dashboardPO.groupNamesProvider(groupNames);
        HashSet<String> groupSet = new HashSet<>(Arrays.asList(dashboardPO.getUserGroups(username)));
        for (String groupName : groupNamesArray) {
            assertTrue(groupSet.contains(groupName));
        }
        System.out.println("all good");
    }

    @When("I select {string} in group filter")
    public void iSelectGroupInGroupFilter(String groupNames) {
        dashboardPO.applyGroupFilter(groupNames);
    }


    @Then("I should see the user {string} in the result set")
    public void iShouldSeeTheUserUsernameInTheResultSet(String username) {
        assertNotNull(dashboardPO.findUserRowInBrowserTable(username));
    }


}
