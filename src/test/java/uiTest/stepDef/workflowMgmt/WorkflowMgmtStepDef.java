package uiTest.stepDef.workflowMgmt;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.ListWorkflowsOP;
import uiTest.pageObjects.ViewWorkflowStepsPO;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;


public class WorkflowMgmtStepDef {
    private final ListWorkflowsOP listWorkflowsOP = new ListWorkflowsOP();
    ;
    private final ViewWorkflowStepsPO viewWorkflowStepsPO = new ViewWorkflowStepsPO();
    ;

    @When("I click the workflows btn in the Issues sidebar")
    public void iClickTheWorkflowsBtnInTheIssuesSidebar() {
        //DriverFactory.getDriver().findElement(By.xpath("//a[@id = \"workflows\"]")).click();
        viewWorkflowStepsPO.clickWorkflowBtn();

    }


    @Then("I should see workflow page")
    public void iShouldSeeWorkflowPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.ListWorkflows.toString());
    }

    @When("I click the add workflow btn in Issues")
    public void iClickTheAddWorkflowBtn() {
        listWorkflowsOP.clickAddWorkflowBtn();
    }

    @And("I enter {string} and {string}")
    public void iEnterWorkflowNameAndDescription(String workflowName, String description) {
        listWorkflowsOP.enterWorkflowName(workflowName);
        listWorkflowsOP.enterDescription(description);
    }

    @And("I click add btn in the add workflow form")
    public void iClickAddBtnInTheAddWorkflowForm() {
        listWorkflowsOP.clickWorkflowFormAddBtn();
    }

    @Then("I should see view workflow steps page")
    public void iShouldSeeViewWorkflowStepsPage() {
        assertEquals(URL.removeQueryString(DriverFactory.getDriver().getCurrentUrl()),
              URL.ViewWorkflowSteps.toString());

    }


    @When("I click workflows text btn")
    public void iClickWorkflowsTextBtn() {
        viewWorkflowStepsPO.clickWorkflowsTextBtn();
    }

    @And("I add following new steps into workflow")
    public void iAddFollowingNewStepsIntoWorkflow(DataTable steps) {
        List<Map<String, String>> data = steps.asMaps(String.class, String.class);
        for (Map<String, String> step : data) {
            viewWorkflowStepsPO.enterStepName(step.get("stepName"));
            viewWorkflowStepsPO.enterLinkedStatus(step.get("linkedStatus"));
            //click add
            viewWorkflowStepsPO.clickWorkflowStepAddSubmitBtn();
            if (!step.get("linkedStatus").equals("Closed")) {
                viewWorkflowStepsPO.setStepDestination(step.get("destination"), step.get("transitionName"));
            }

        }
    }

    @Then("I should see the issues page")
    public void iShouldSeeTheIssuesPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.ViewIssueTypes.toString());

    }

}
