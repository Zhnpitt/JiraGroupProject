package uiTest.stepDef.projectRoleMgmt;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.*;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class ProjectRoleMgmtStepDef {
    WebDriver driver = DriverFactory.getDriver();
    private final LoginPO loginPO = new LoginPO();
    private final DashBoardPO dashboardPO = new DashBoardPO();
    private final SystemPagePO systemPagePO = new SystemPagePO();
    private final ProjectPO projectPO = new ProjectPO();
    private final IssuesPO issuesPO = new IssuesPO();
    private final AdminMenuPO adminMenuPO = new AdminMenuPO();


    // Background: Login in as an administrator and navigate to Project roles page
    @Given("I visit the login page")
    public void iVisitTheLoginPage() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(URL.Login.toString());
        assertEquals(driver.getCurrentUrl(), URL.Login.toString());
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
        assertEquals(driver.getCurrentUrl(),
                URL.DashBoard.toString());
    }


    //  Scenario: Admin creates three project roles
    @When("I click the admin menu button")
    public void iClickTheAdminMenuButton(){
        dashboardPO.clickAdminMenu();
    }
    @And("I click the System button")
    public void iClickTheSystemButton(){
        dashboardPO.clickSystemButton();
    }
    @And("I enter password in Administrator Access Page {string}")
    public void iEnterPassword(String password){
        dashboardPO.enterAuthenticatePassword(password);
    }
    @And("I click confirm in Administrator Access Page")
    public void iClickConfirmInAdministratorAccessPage() {
        dashboardPO.clickAuthenticateConfirmBtn();
    }
    @And("I click the Project roles button")
    public void iClickTheProjectRolesButton(){
        systemPagePO.clickProjectRolesButton();
    }
    @And("I enter the valid {} and {}")
    public void iEnterTheValidRoleNameAndDescription(String roleName, String description){
        systemPagePO.enterRoleName(roleName);
        systemPagePO.enterRoleDescription(description);
    }
    @And("I click the Add Project Role button")
    public void iClickTheAddProjectRoleButton(){
        systemPagePO.clickRoleSubmitButton();
    }
//    @Then("I should see this new role in Project Role Browser")
//    public void iShouldSeeThisNewRoleInProjectRoleBrowser(){
//        String xpathExpression = "//tbody/tr[.//td[contains(text(),'" + roleName + "')] and .//td[contains(text(),'" + roleDesc + "')]]";
//        List<WebElement> matchingElements = driver.findElements(By.xpath(xpathExpression));
//        Assert.assertFalse( matchingElements.isEmpty());
//    }


    //Scenario: Create a project
    @When("I click the admin menu button again")
    public void iClickTheAdminMenuButtonAgain(){
        dashboardPO.clickAdminMenu();
    }
    @And("I click the Projects button")
    public void IClickTheProjectsButton(){
        dashboardPO.clickProjectsButton();
    }
    @And("I create and setup the project with {} and {}")
    public void iSetupTheProject(String projectName, String projectKey ) throws InterruptedException {
        projectPO.clickCreateProjectButton();
        Thread.sleep(200);
        projectPO.clickNextButton();
        Thread.sleep(200);
        projectPO.clickSelectButton();
        Thread.sleep(200);
        projectPO.createAProject(projectName, projectKey);
    }


    //  Scenario: Admin adds existing user to a project role
    @When("I click the admin menu button third")
    public void iClickTheAdminMenuButtonThird(){
        dashboardPO.clickAdminMenu();
    }
    @And("I click the Projects button again")
    public void IClickTheProjectsButtonAgain(){
        dashboardPO.clickProjectsButton();
    }
    @And("I choose a project")
    public void iChooseAProject(){
        projectPO.chooseAProject();
    }
    @And("I click the Users and roles button")
    public void iClickTheUsersAndRolesButton(){
        projectPO.clickUsersAndRolesButton();
    }
    @And("I click the Add users to a role button")
    public void iClickTheAddUsersToARoleButton(){
        projectPO.clickAddUserToARoleButton();
    }
    @And("I enter valid {} and {}")
    public void iEnterValidUserAndRole(String userName, String roleName) throws InterruptedException {
        projectPO.enterUserName(userName);
        projectPO.chooseARole(roleName);
    }
    @And("I click the Add button")
    public void iClickTheAddButton(){
        projectPO.clickAddButton();
    }
    //Then I add a user to a role


    //Scenario: After creation, I can filter users in a project based on their roles.
    @And("I can filter all developer")
    public void iCanFilterAllDeveloper() throws InterruptedException {
        projectPO.filterDeveloper();
    }
    @And("I can filter all QA")
    public void iCanFilterAllQA() throws InterruptedException {
        projectPO.filterQA();
    }
    @And("I can filter all Team Lead")
    public void iCanFilterAllTeamLead() throws InterruptedException {
        projectPO.filterTeamLead();
    }

    //create a permission scheme
    @And("I click the issue button")
    public void iClickTheIssueButton(){
        adminMenuPO.clickIssueAdminButton();
    }
    @And("I click the Permission schemes button")
    public void iClickThePermissionSchemesButton(){
        issuesPO.clickPermissionSchemesButton();
    }
    @And("I click the Add permission scheme button")
    public void iClickTheAddPermissionSchemeButton(){
        issuesPO.clickAddPermissionSchemeButton();
    }

    @And("I name the scheme {}")
    public void iNameTheNewScheme(String name){
        issuesPO.nameANewScheme(name);
    }

    @And("I click the permission scheme submit button")
    public void iClickThePermissionSchemeSubmitButton(){
        issuesPO.submitANewScheme();
    }

    @And("I choose this scheme to edit")
    public void iChooseThisSchemeToEdit(){
        issuesPO.editPermission();
    }


    //  Scenario: After creation, I can enable team lead manage sprints
    @And("I click the Permissions button")
    public void iClickThePermissionsButton(){
        projectPO.clickPermissionsButton();
    }
    @And("I click the Actions dropbox and select Edit permissions")
    public void iClickTheActionsDropboxAndSelectEditPermissions() throws InterruptedException {
        projectPO.editPermissions();
    }
    @And("I click permission edit button")
    public void iClickManageSprintsEditButton(){
        issuesPO.clickManageSprintEditButton();
    }

    @And("I select a permission {}")
    public void iSelectAPermission(String permission){
        issuesPO.selectAPermission(permission);
    }
    @And("I select Granted to Project Role")
    public void iSelectGrantedToProjectRole(){
        issuesPO.selectProjectRoleGrant();
    }

    @And("I grant a team lead")
    public void iGrantATeamLead(){
        issuesPO.clickRoleInputTextBox();
        issuesPO.chooseTeamLead();
        issuesPO.clickGrantButton();
    }


    @And("I grant a developer")
    public void iGrantADeveloper(){
        issuesPO.clickRoleInputTextBox();
        issuesPO.chooseDeveloper();
        issuesPO.clickGrantButton();
    }

    @And("I grant a QA")
    public void iGrantAQA(){
        issuesPO.clickRoleInputTextBox();
        issuesPO.chooseQA();
        issuesPO.clickGrantButton();
    }








}
