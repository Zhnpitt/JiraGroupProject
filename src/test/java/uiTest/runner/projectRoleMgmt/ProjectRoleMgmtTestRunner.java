package uiTest.runner.projectRoleMgmt;

import io.cucumber.testng.CucumberOptions;
import uiTest.runner.UiTestRunner;

@CucumberOptions(
        features = {"src/test/resources/feature/ui/projectRoleMgmt.feature"},
        glue = {"uiTest.stepDef.projectRoleMgmt"}
)
public class ProjectRoleMgmtTestRunner extends UiTestRunner {
}
