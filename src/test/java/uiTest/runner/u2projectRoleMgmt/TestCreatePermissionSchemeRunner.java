package uiTest.runner.u2projectRoleMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = "src/test/resources/feature/ui/u2projectRoleMgmt/createPermissionScheme.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.projectRoleMgmt"}
)

public class TestCreatePermissionSchemeRunner extends TestRunner{
}