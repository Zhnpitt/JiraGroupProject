package uiTest.runner.workflowMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = "src/test/resources/feature/ui/workflowMgmt/columnEdit.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.workflowMgmt", "uiTest.stepDef.adminMenu"}
)

public class TestColumnEdit extends TestRunner{

}