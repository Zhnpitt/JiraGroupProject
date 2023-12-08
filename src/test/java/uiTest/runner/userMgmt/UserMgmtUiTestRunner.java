package uiTest.runner.userMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.uiTestRunner;
@CucumberOptions(
      features = "src/test/resources/feature/ui/userMgmt/",
      glue = {"uiTest.stepDef.userMgmt","uiTest.stepDef.login","uiTest.stepDef.adminMenu"}
)


public class UserMgmtUiTestRunner extends uiTestRunner {
}
