package uiTest.stepDef.adminMenu;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.pageObjects.DashBoardPO;

import static org.testng.Assert.assertTrue;

public class AdminMenuStepDef {
    private final DashBoardPO dashboardPO = new DashBoardPO();

    @Then("I should see admin menu")
    public void iShouldSeeAdminMenu() {
        assertTrue(dashboardPO.checkIfAdminUser());
    }


    @When("I navigate to the user management page")
    public void iNavigateToTheUserManagementPage() {
        dashboardPO.clickAdminMenu();
        dashboardPO.clickUserMgmtLink();
    }

    @When("I navigate to the admin issues page")
    public void iNavigateToTheIssuesPage() {
        dashboardPO.clickAdminMenu();
        dashboardPO.clickAdminIssuesBtn();
    }
}