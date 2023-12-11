package uiTest.runner.u1userMgmt;

import apiTest.runner.TestRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
      features = "src/test/resources/feature/ui/u1userMgmt/userGroupAssignment.feature",
      glue = {"uiTest.stepDef.login", "uiTest.stepDef.userMgmt", "uiTest.stepDef.adminMenu"}
)

public class TestUserGroupAssignmentRunner extends TestRunner{
}