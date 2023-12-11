package uiTest.runner.u2projectRoleMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = "src/test/resources/feature/ui/u2projectRoleMgmt/addUserToRole.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.projectRoleMgmt"}
)

public class TestAddUserToRoleRunner extends TestRunner{
}