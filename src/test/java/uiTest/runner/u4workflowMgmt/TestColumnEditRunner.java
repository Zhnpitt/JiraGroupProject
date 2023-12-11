package uiTest.runner.u4workflowMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = "src/test/resources/feature/ui/workflowMgmt/columnEdit.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.workflowMgmt", "uiTest.stepDef.adminMenu"}
)

public class TestColumnEditRunner extends TestRunner{

}