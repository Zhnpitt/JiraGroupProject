package uiTest.runner.u3groupMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = {"src/test/resources/feature/ui/u3groupMgmt/groupMgmt.feature"
      },
      glue = {"uiTest.stepDef.groupMgmt", "uiTest.stepDef.adminMenu", "uiTest.stepDef.login"}
)
public class TestGroupMgmtRunner extends TestRunner{

}