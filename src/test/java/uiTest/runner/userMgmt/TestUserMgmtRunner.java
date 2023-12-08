package uiTest.runner.userMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;
@CucumberOptions(
      features = "src/test/resources/feature/ui/userMgmt/",
      glue = {"uiTest.stepDef.userMgmt","uiTest.stepDef.login","uiTest.stepDef.adminMenu"}
)


public class TestUserMgmtRunner extends TestRunner {
}
