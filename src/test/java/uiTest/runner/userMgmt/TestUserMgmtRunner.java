package uiTest.runner.userMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.TestRunner;

@CucumberOptions(
      features = "src/test/resources/feature/ui/userMgmt/",
      glue = {"uiTest.stepDef"}
)


public class TestUserMgmtRunner extends TestRunner{
}