package uiTest.stepDef.projectMgmt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import uiTest.pageObjects.*;

public class ProjectMgmtStepDef{
    private final LoginPO loginPO = new LoginPO();
    private final DashBoardPO dashboardPO = new DashBoardPO();
    private final ProjectPO projectPO = new ProjectPO();
    private final IssuesPO issuesPO = new IssuesPO();
    private final TeamLeadPO teamLeadPO = new TeamLeadPO();


    //  Background: Login in as an administrator and navigate to Project page
//    @Given("I visit the login page")
//    public void iVisitTheLoginPage(){
//        DriverFactory.getDriver().manage().deleteAllCookies();
//        DriverFactory.getDriver().navigate().to(URL.Login.toString());
//        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.Login.toString());
//    }

    //    @When("I enter the admin username and password")
//    public void iEnterTheAdminUsernameAndPassword(DataTable usercredentials) {
//        List<Map<String, String>> data = usercredentials.asMaps(String.class, String.class);
//        loginPO.enterUsername(data.get(0).get("username"));
//        loginPO.enterPassword(data.get(0).get("password"));
//    }
//    @When("I enter the {string} and {string}")
//    public void iEnterTheUsernameAndPassword(String username, String password){
//        loginPO.enterUsername(username);
//        loginPO.enterPassword(password);
//    }

//    @And("I click the login button")
//    public void iClickTheLoginButton(){
//        loginPO.clickLoginButton();
//    }

//    @Then("I should view the dashboard")
//    public void iShouldViewTheDashBoardPage() throws InterruptedException{
//        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
//              URL.DashBoard.toString());
//        Thread.sleep(500);
//    }


    //  Scenario: create a Scrum project and apply an existing permission scheme
    @When("I click the admin menu button")
    public void iClickTheAdminMenuButton(){
        dashboardPO.clickAdminMenu();
    }

    @And("I click the Project button")
    public void IClickTheProjectsButton(){
        dashboardPO.clickProjectsButton();
    }

    @And("I setup the project with {string} and {string}")
    public void iSetupTheProject(String projectName, String projectKey) throws InterruptedException{
        projectPO.clickCreateProjectButton();
        Thread.sleep(200);
        projectPO.clickNextButton();
        Thread.sleep(200);
        projectPO.clickSelectButton();
        Thread.sleep(400);
        projectPO.createAProject(projectName, projectKey);
    }
    //@Then("Then I create a project")


    //Scenario:I apply an existing permission scheme
    @When("I click the admin menu button again")
    public void iClickTheAdminMenuButtonAgain(){
        dashboardPO.clickAdminMenu();
    }

    @And("I click the Project button again")
    public void iClickTheProjectsButtonAgain(){
        dashboardPO.clickProjectsButton();
    }

    @And("I select a project")
    public void iChooseAProject(){
        projectPO.chooseAProject();
    }

    @And("I click the Permissions button")
    public void iClickThePermissionsButton(){
        projectPO.clickPermissionsButton();
    }

    @And("I click the Actions button and select use a different scheme")
    public void iClickTheActionsButtonAndSelectUseADifferentScheme() throws InterruptedException{
        projectPO.editPermissionsScheme();
    }

    @And("I enter password in Administrator Access Page {string}")
    public void iEnterPassword(String password){
        dashboardPO.enterAuthenticatePassword(password);
    }

    @And("I click confirm in Administrator Access Page")
    public void iClickConfirmInAdministratorAccessPage() throws InterruptedException{
        dashboardPO.clickAuthenticateConfirmBtn();
        Thread.sleep(1000);
    }

    @And("I select a scheme and click associate button")
    public void iSelectASchemeAndClickAssociateButton() throws InterruptedException{
        projectPO.selectAPermissionScheme();
        Thread.sleep(1000);
        projectPO.clickAssociateButton();
    }


    //  Scenario: I can create different epics
    @When("I click the project button in team lead dashboard")
    public void iClickTheProjectButtonInTeamLeadDashboard(){
        teamLeadPO.clickProjectButton();
    }


    @And("I choose current project")
    public void iChooseCurrentProject(){
        teamLeadPO.chooseCurrentProject();
    }

    @And("I create an issue")
    public void iClickCreateSssueButton(){
        teamLeadPO.createIssue();
    }

    @And("I select a Issue Type as Epic")
    public void iSelectAIssueTypeAsEpic(){
        teamLeadPO.selectEpic();
    }

    @And("I enter Epic name as {} and {}")
    public void iEnterNameAndSumToCreateAnEpic(String epicName, String epicSummary){
        teamLeadPO.createEpic(epicName, epicSummary);
    }

    @And("I submit an issue")
    public void iSubmitAnIssue() throws InterruptedException{
        teamLeadPO.submitIssue();
        Thread.sleep(500);
    }

    @And("I click the team lead Backlog button")
    public void iClickTheTeamLeadBacklogButton(){
        teamLeadPO.clickBacklogButton();
    }
}