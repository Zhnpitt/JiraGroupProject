package uiTest.runner.u4workflowMgmt;


import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = "src/test/resources/feature/ui/u4workflowMgmt/workflowCreation.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.adminMenu", "uiTest.stepDef.workflowMgmt"}
)
public class TestWorkflowCreationRunner extends TestRunner{
}