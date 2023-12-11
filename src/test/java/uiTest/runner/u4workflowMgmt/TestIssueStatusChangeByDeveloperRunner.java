package uiTest.runner.u4workflowMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = "src/test/resources/feature/ui/u4workflowMgmt/IssueStatusChangeByDeveloper.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.workflowMgmt"}
)

public class TestIssueStatusChangeByDeveloperRunner extends TestRunner{
}