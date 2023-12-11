package uiTest.runner.u6issueMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = {"src/test/resources/feature/ui/issueMgmt/teamLeaderUserIssueMgmt.feature"
      },
      glue = {"uiTest.stepDef.issueMgmt", "uiTest.stepDef.login"}
)
public class TestIssueMgmtLeaderRunner extends TestRunner{
}