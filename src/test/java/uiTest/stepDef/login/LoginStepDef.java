package uiTest.stepDef.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.constants.UserRole;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.AdminUserMgmtPO;
import uiTest.pageObjects.LoginPO;
import utils.AdminProperties;
import utils.TestDataProvider;
import utils.User;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginStepDef{
    private final LoginPO loginPO = new LoginPO();
    private final AdminUserMgmtPO adminUserMgmtPO = new AdminUserMgmtPO();

    @Given("I visit the login page")
    public void iVisitTheloginPage(){
        DriverFactory.getDriver().manage().deleteAllCookies();
        DriverFactory.getDriver().navigate().to(URL.Login.toString());
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.Login.toString());
    }

    @Given("I visit the Login page")
    public void iVisitTheLoginPage(){
        DriverFactory.getDriver().navigate().to(URL.DashBoard.toString());
        //loginPO = new LoginPO();
    }

    @When("I enter the admin username and password")
    public void iEnterTheAdminUsernameAndPassword(){
        loginPO.enterUsername(AdminProperties.getAdminUsername());
        loginPO.enterPassword(AdminProperties.getAdminPassword());
    }

    @When("I enter the username {} and password {}")
    public void iEnterTheUsernameStringAndPasswordString(String username, String password){
        loginPO.enterUsername(username);
        loginPO.enterPassword(password);
    }

    @When("I enter the {string} and {string}")
    public void iEnterTheUsernameAndPassword(String username, String password){
        loginPO.enterUsername(username);
        loginPO.enterPassword(password);
    }

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username){
        loginPO.enterUsername(username);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String password){

        loginPO.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton(){
        loginPO.clickLoginButton();
    }

    @Then("I should view the dashboard")
    public void iShouldViewTheDashBoardPage(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.DashBoard.toString());
    }

    @When("I enter the developer username and password")
    public void iEnterTheDeveloperUsernameAndPassword(){
        User user = TestDataProvider.getUserWithRole(UserRole.Developer);
        assertNotNull(user, "There is no developer in test data");
        iEnterTheUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @When("I enter the QA username and password")
    public void iEnterTheQAUsernameAndPassword(){
        User user = TestDataProvider.getUserWithRole(UserRole.QA);
        assertNotNull(user, "There is no QA in test data");
        iEnterTheUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @When("I enter the Team lead username and password")
    public void iEnterTheTeamLeadUsernameAndPassword(){
        User user = TestDataProvider.getUserWithRole(UserRole.TeamLead);
        assertNotNull(user, "There is no Team lead in test data");
        iEnterTheUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Then("I should view WelcomeToJIRA page")
    public void iShouldViewWelcomeToJIRAPage(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.Welcome.toString());
    }


    @When("I click Continue in Welcome content")
    public void iClickContinueInWelcomeContent(){
        loginPO.clickContinueBtnInWelcomePage();
    }

    @And("I click Next in Welcome content")
    public void iClickNextInWelcomeContent(){
        loginPO.clickNextBtnInWelcomePage();

    }

    @And("I click the first step in next step sequence")
    public void iClickTheFirstStepInNextStepSequence(){

        loginPO.clickStepInNextStepSequence(0);
    }

    @And("I enter password in Administrator Access Page")
    public void iEnterPasswordInAdministratorAccessPage(){

        adminUserMgmtPO.enterAuthenticatePassword(AdminProperties.getAdminPassword());

    }

    @And("I click confirm in Administrator Access Page")
    public void iClickConfirmInAdministratorAccessPage(){
        adminUserMgmtPO.clickAuthenticateConfirmBtn();
    }

    @Then("I should see user management page")
    public void iShouldSeeUserManagementPage(){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.AdminUserMgmt.toString());
    }
}