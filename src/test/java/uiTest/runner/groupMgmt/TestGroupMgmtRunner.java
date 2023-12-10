package uiTest.runner.groupMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = {"src/test/resources/feature/ui/groupMgmt.feature"
      },
      glue = {"uiTest.stepDef.groupMgmt", "uiTest.stepDef.login"}
)
public class TestGroupMgmtRunner extends TestRunner{

}