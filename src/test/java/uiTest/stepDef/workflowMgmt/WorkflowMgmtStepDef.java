package uiTest.stepDef.workflowMgmt;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.AdminListWorkflowsOP;
import uiTest.pageObjects.AdminViewWorkflowStepsPO;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;


public class WorkflowMgmtStepDef {
    private final AdminListWorkflowsOP adminListWorkflowsOP = new AdminListWorkflowsOP();
    ;
    private final AdminViewWorkflowStepsPO adminViewWorkflowStepsPO = new AdminViewWorkflowStepsPO();
    ;

    @When("I click the workflows btn in the Issues sidebar")
    public void iClickTheWorkflowsBtnInTheIssuesSidebar() {
        //DriverFactory.getDriver().findElement(By.xpath("//a[@id = \"workflows\"]")).click();
        adminViewWorkflowStepsPO.clickWorkflowBtn();

    }


    @Then("I should see workflow page")
    public void iShouldSeeWorkflowPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.AdminListWorkflows.toString());
    }

    @When("I click the add workflow btn in Issues")
    public void iClickTheAddWorkflowBtn() {
        adminListWorkflowsOP.clickAddWorkflowBtn();
    }

    @And("I enter {string} and {string}")
    public void iEnterWorkflowNameAndDescription(String workflowName, String description) {
        adminListWorkflowsOP.enterWorkflowName(workflowName);
        adminListWorkflowsOP.enterDescription(description);
    }

    @And("I click add btn in the add workflow form")
    public void iClickAddBtnInTheAddWorkflowForm() {
        adminListWorkflowsOP.clickWorkflowFormAddBtn();
    }

    @Then("I should see view workflow steps page")
    public void iShouldSeeViewWorkflowStepsPage() {
        assertEquals(URL.removeQueryString(DriverFactory.getDriver().getCurrentUrl()),
              URL.AdminViewWorkflowSteps.toString());

    }


    @When("I click workflows text btn")
    public void iClickWorkflowsTextBtn() {
        adminViewWorkflowStepsPO.clickWorkflowsTextBtn();
    }

    @And("I add following new steps into workflow")
    public void iAddFollowingNewStepsIntoWorkflow(DataTable steps) {
        List<Map<String, String>> data = steps.asMaps(String.class, String.class);
        for (Map<String, String> step : data) {
            adminViewWorkflowStepsPO.enterStepName(step.get("stepName"));
            adminViewWorkflowStepsPO.enterLinkedStatus(step.get("linkedStatus"));
            //click add
            adminViewWorkflowStepsPO.clickWorkflowStepAddSubmitBtn();
            if (!step.get("linkedStatus").equals("Closed")) {
                adminViewWorkflowStepsPO.setStepDestination(step.get("destination"), step.get("transitionName"));
            }

        }
    }

    @Then("I should see the issues page")
    public void iShouldSeeTheIssuesPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.AdminViewIssueTypes.toString());

    }

}
