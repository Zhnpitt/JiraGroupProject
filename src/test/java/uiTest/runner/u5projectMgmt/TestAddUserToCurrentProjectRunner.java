package uiTest.runner.u5projectMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = "src/test/resources/feature/ui/u5projectMgmt/addUserToCurrentProject.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.projectRoleMgmt"}
)
public class TestAddUserToCurrentProjectRunner extends TestRunner{

}